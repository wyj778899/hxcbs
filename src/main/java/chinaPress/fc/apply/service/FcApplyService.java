package chinaPress.fc.apply.service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.sms.service.SMSService;
import chinaPress.common.util.JacksonUtil;
import chinaPress.common.util.Md5Util;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.fc.apply.vo.FcApplyPersonParam;
import chinaPress.fc.apply.vo.TerminalApplyListParam;
import chinaPress.fc.apply.vo.TerminalApplyListVo;
import chinaPress.fc.apply.vo.TerminalInstitutionApplyDetailVo;
import chinaPress.fc.apply.vo.TerminalPractitionerApplyDetailVo;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;

@Service
public class FcApplyService {

	@Autowired
	private FcApplyMapper fcApplyMapper;

	@Autowired
	private FcApplyPersonMapper fcApplyPersonMapper;

	@Autowired
	private MemberInfoMapper memberInfoMapper;

	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;

	@Autowired
	private FcOrderMapper fcOrderMapper;

	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;

	@Autowired
	private SMSService smsService;

	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;

	@Autowired
	private FcOrderPersonHourMapper fcOrderPersonHourMapper;

	/**
	 * 新增
	 * 
	 * @param record
	 * @param personJson
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws NoSuchAlgorithmException
	 */
	@Transactional
	public Result insert(FcApply record, String personJson)
			throws NoSuchAlgorithmException, UnsupportedEncodingException {
		Map<String, Object> resultMap = new HashMap<>();
		int index = fcApplyMapper.insertSelective(record);
		if (index > 0) {
			int staffRoleType = 0;
			List<FcApplyPersonParam> personList = JacksonUtil.fromJSONList(personJson, FcApplyPersonParam.class);
			if (record.getApplyType().intValue() == 1) {
				staffRoleType = 2;
				for (FcApplyPersonParam item : personList) {

					MemberInfo memberParam = new MemberInfo();
					memberParam.setTellPhone(item.getTellPhone());
					MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
					if (memberInfo != null) {
						if (memberInfo.getRoleType().intValue() != 3 && memberInfo.getRoleType().intValue() != 4) {
							continue;
						}

						// 修改员工
						MemberInfo updMember = new MemberInfo();
						updMember.setId(memberInfo.getId());
						updMember.setName(item.getName());
						updMember.setSex(item.getSex());
						memberInfoMapper.updateByPrimaryKeySelective(memberInfo);

						// 修改家长/从业者
						PractitionerInfo updPractitioner = new PractitionerInfo();
						updPractitioner.setId(memberInfo.getRoleId());
						updPractitioner.setName(item.getName());
						updPractitioner.setSex(item.getSex());
						updPractitioner.setAge(item.getAge());
						updPractitioner.setCertificateNumber(item.getCertificateNumber());
						updPractitioner.setPost(item.getPost());
						updPractitioner.setWorkYear(item.getWorkYear());
						updPractitioner.setCensusAddress(item.getCensusAddress());
						updPractitioner.setInstitutionAddress(item.getInstitutionAddress());
						updPractitioner.setEducation(item.getEducation());
						practitionerInfoMapper.updateByPrimaryKeySelective(updPractitioner);

						FcApplyPerson applyPerson = new FcApplyPerson();
						applyPerson.setApplyId(record.getId());
						applyPerson.setCreateId(record.getCreateId());
						applyPerson.setRoleId(memberInfo.getRoleId());
						if (memberInfo.getRoleType().intValue() == 3) {
							applyPerson.setRoleType(1);
						} else if (memberInfo.getRoleType().intValue() == 4) {
							applyPerson.setRoleType(2);
						}
						fcApplyPersonMapper.insertSelective(applyPerson);
					} else {
						item.setRoleType(2);
						// 新增家长/从业者
						PractitionerInfo practitionerInfo = new PractitionerInfo();
						practitionerInfo.setUserName(item.getTellPhone());
						practitionerInfo.setPassword(Md5Util.getEncryptedPwd("123456"));
						practitionerInfo.setName(item.getName());
						practitionerInfo.setTellPhone(item.getTellPhone());
						practitionerInfo.setCertificateNumber(item.getCertificateNumber());
						practitionerInfo.setSex(item.getSex());
						practitionerInfo.setAge(item.getAge());
						practitionerInfo.setPost(item.getPost());
						practitionerInfo.setWorkYear(item.getWorkYear());
						practitionerInfo.setCensusAddress(item.getCensusAddress());
						practitionerInfo.setInstitutionAddress(item.getInstitutionAddress());
						practitionerInfo.setEducation(item.getEducation());
						practitionerInfo.setType(item.getRoleType());
						practitionerInfoMapper.insertSelective(practitionerInfo);
						// 新增员工表
						MemberInfo insMemberModel = new MemberInfo();
						insMemberModel.setUserName(item.getTellPhone());
						insMemberModel.setName(item.getName());
						insMemberModel.setTellPhone(item.getTellPhone());
						insMemberModel.setPassword(Md5Util.getEncryptedPwd("123456"));
						insMemberModel.setSex(item.getSex());
						insMemberModel.setAddress(item.getInstitutionAddress());
						insMemberModel.setIsStart(0);
						insMemberModel.setRoleId(practitionerInfo.getId());
						if (item.getRoleType().intValue() == 1) {
							insMemberModel.setRoleType(3);
						} else if (item.getRoleType().intValue() == 2) {
							insMemberModel.setRoleType(4);
						}
						memberInfoMapper.insertSelective(insMemberModel);

						FcApplyPerson applyPerson = new FcApplyPerson();
						applyPerson.setApplyId(record.getId());
						applyPerson.setCreateId(record.getCreateId());
						applyPerson.setRoleId(practitionerInfo.getId());
						applyPerson.setRoleType(item.getRoleType());
						fcApplyPersonMapper.insertSelective(applyPerson);
					}
				}

				MemberInfo memberParam = new MemberInfo();
				memberParam.setRoleId(record.getApplyId());
				memberParam.setRoleType(staffRoleType);
				MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
				if (memberInfo != null) {
					String courseName = fcCourseArchivesMapper.selectByPrimaryKey(record.getCourseId()).getName();
					String message = "【华夏云课堂】尊敬的机构用户：您已成功提交" + courseName
							+ "课程的报名信息，我们会在2-3个工作日进行审核，您可在“我的课堂”中查询结果。如有疑义，可致电010-64672273。感谢您的支持！";
					smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
				}

				resultMap.put("type", 1);
				return ResultUtil.ok(resultMap);
			} else {

				FcApplyPersonParam personModel = personList.get(0);
				MemberInfo memberParam = new MemberInfo();
				memberParam.setTellPhone(personModel.getTellPhone());
				MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
				if (memberInfo != null) {
					// 修改员工
					MemberInfo updMember = new MemberInfo();
					updMember.setId(memberInfo.getId());
					updMember.setName(personModel.getName());
					memberInfoMapper.updateByPrimaryKeySelective(memberInfo);

					// 修改家长/从业者
					PractitionerInfo updPractitioner = new PractitionerInfo();
					updPractitioner.setId(memberInfo.getRoleId());
					// 姓名
					updPractitioner.setName(personModel.getName());
					updPractitioner.setAge(personModel.getAge());
					updPractitioner.setPost(personModel.getPost());
					updPractitioner.setWorkYear(personModel.getWorkYear());
					// 学历
					updPractitioner.setEducation(personModel.getEducation());
					// 机构名称
					updPractitioner.setInstitutionName(personModel.getInstitutionName());
					// 单位地址
					updPractitioner.setInstitutionAddress(personModel.getInstitutionAddress());
					practitionerInfoMapper.updateByPrimaryKeySelective(updPractitioner);
				}

				FcApplyPerson person = new FcApplyPerson();
				person.setApplyId(record.getId());
				person.setRoleId(record.getApplyId());
				if (record.getApplyType().intValue() == 2) {
					person.setRoleType(1);
				} else if (record.getApplyType().intValue() == 3) {
					person.setRoleType(2);
				}
				person.setCreateId(record.getCreateId());
				fcApplyPersonMapper.insertSelective(person);
				resultMap.put("type", 2);
				resultMap.put("applyId", record.getId());
				return ResultUtil.ok(resultMap);
			}
		}
		return ResultUtil.error();
	}

	/**
	 * 审核
	 * 
	 * @param id
	 * @param auditStatus 审核状态（1.待审核2.已审核3.已驳回）
	 * @param auditPeople 审核人
	 * @return
	 */
	public int audit(Integer id, Integer auditStatus, Integer auditPeople) {
		FcApply applyModel = fcApplyMapper.selectByPrimaryKey(id);
		if (applyModel == null) {
			return 0;
		}
		FcApply updApplyModel = new FcApply();
		updApplyModel.setId(id);
		updApplyModel.setAuditStatus(auditStatus);
		int index = fcApplyMapper.updateByPrimaryKeySelective(updApplyModel);
		if (index > 0) {
			if (auditStatus == 2) {
				Date current_date = new Date();
				FcOrder insOrder = new FcOrder();
				insOrder.setDate(current_date);
				insOrder.setCode(String.valueOf(current_date.getTime()));
				insOrder.setRoleType(applyModel.getApplyType());
				insOrder.setRoleId(applyModel.getApplyId());
				insOrder.setCourseId(applyModel.getCourseId());
				insOrder.setPayStatus(1);
				insOrder.setCreateId(auditPeople);
				int insOrderIndex = fcOrderMapper.insertSelective(insOrder);
				if (insOrderIndex > 0) {
					int totalCount = fcCourseHourMapper.selectCourseHourCountByCOurseId(applyModel.getCourseId());
					List<FcApplyPerson> personList = fcApplyPersonMapper.findByApplyId(id);
					for (FcApplyPerson item : personList) {
						FcOrderPerson person = new FcOrderPerson();
						person.setOrderId(insOrder.getId());
						person.setRoleId(item.getRoleId());
						person.setRoleType(item.getRoleType());
						person.setTotalCount(totalCount);
						person.setCreateId(auditPeople);
						person.setIsIndividual(0);
						int personIndex = fcOrderPersonMapper.insertSelective(person);
						if (personIndex > 0) {
							FcOrderPersonHour personHour = new FcOrderPersonHour();
							personHour.setOrderPersonId(person.getId());
							personHour.setHourId(
									fcCourseHourMapper.selectCourseHourIdBysectionId(applyModel.getCourseId()));
							fcOrderPersonHourMapper.insertSelective(personHour);
						}
					}
				}
			}

			MemberInfo memberParam = new MemberInfo();
			memberParam.setRoleId(applyModel.getApplyId());
			if (applyModel.getApplyType() == 1) {
				memberParam.setRoleType(2);
			} else if (applyModel.getApplyType() == 2) {
				memberParam.setRoleType(3);
			} else if (applyModel.getApplyType() == 3) {
				memberParam.setRoleType(4);
			}
			MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
			if (memberInfo != null) {
				String courseName = fcCourseArchivesMapper.selectByPrimaryKey(applyModel.getCourseId()).getName();
				String message = "";
				if (applyModel.getApplyType().intValue() == 1 && auditStatus == 2) {
					// 审核
					message = "【华夏云课堂】您好：您已成功报名" + courseName + "，请及时关注课程信息，祝您学习愉快！";
					smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
				} else if (applyModel.getApplyType().intValue() == 1 && auditStatus == 3) {
					// 驳回
//					message = "【华夏云课堂】您好：您已成功报名" + courseName + "，请及时关注课程信息，祝您学习愉快！";
//					smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
				}
			}
		}
		return index;
	}

	/**
	 * 终端 报名申请数据数量
	 * 
	 * @return
	 */
	public int findTerminalApplyCount(TerminalApplyListParam param) {
		return fcApplyMapper.findTerminalApplyCount(param);
	}

	/**
	 * 终端 报名申请数据集合
	 * 
	 * @return
	 */
	public List<TerminalApplyListVo> findTerminalApplyList(TerminalApplyListParam param) {
		return fcApplyMapper.findTerminalApplyList(param);
	}

	/**
	 * 终端机构 详情
	 * 
	 * @param id
	 * @return
	 */
	public TerminalInstitutionApplyDetailVo findTerminalInstitutionDetail(Integer id) {
		TerminalInstitutionApplyDetailVo detail = fcApplyMapper.findTerminalInstitutionDetail(id);
		if (detail != null) {
			detail.setVideoNumber(fcCourseHourMapper.selectCourseHourCountByCOurseId(detail.getCourseId()));
		}
		return detail;
	}

	/**
	 * 终端家长 详情
	 * 
	 * @param id
	 * @return
	 */
	public TerminalPractitionerApplyDetailVo findTerminalPractitionerDetail(Integer id) {
		return fcApplyMapper.findTerminalPractitionerDetail(id);
	}
}
