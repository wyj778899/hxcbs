package chinaPress.fc.apply.service;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.sms.service.SMSService;
import chinaPress.common.util.DateUtil;
import chinaPress.common.util.JacksonUtil;
import chinaPress.common.util.Md5Util;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.fc.apply.vo.FcApplyPersonParam;
import chinaPress.fc.apply.vo.OrderVo;
import chinaPress.fc.apply.vo.TerminalApplyListParam;
import chinaPress.fc.apply.vo.TerminalApplyListVo;
import chinaPress.fc.apply.vo.TerminalInstitutionApplyDetailVo;
import chinaPress.fc.apply.vo.TerminalPractitionerApplyDetailVo;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.dao.TrainInstitutionInfoMapper;
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
	
	@Autowired
	private TrainInstitutionInfoMapper trainInstitutionInfoMapper;
	
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
		List<FcApplyPersonParam> personList = JacksonUtil.fromJSONList(personJson, FcApplyPersonParam.class);
		//手机号排重
		long phones = personList.stream().map(FcApplyPersonParam::getTellPhone).distinct().count();
		if(phones < personList.size()){
			resultMap.put("error","报名信息手机号码重复");
			return ResultUtil.error(resultMap);
		}
		//身份证号排重
		long certs = personList.stream().map(FcApplyPersonParam::getCertificateNumber).distinct().count();
		if(certs < personList.size()){
			resultMap.put("error","报名信息身份证号重复");
			return ResultUtil.error(resultMap);
		}
		//机构报名校验身份证号,个人报名不校验
		if(record.getApplyType().intValue() == 1) {
			for(FcApplyPersonParam f : personList) {
				String certificateNumber = f.getCertificateNumber();
				//判断机构是否存在，存在直接返回   
				if(trainInstitutionInfoMapper.selectByIdCert(certificateNumber, null)!=null) {
					resultMap.put("error",certificateNumber+":身份证号已被机构注册");
					return ResultUtil.error(resultMap);
				}
				int count = 0;
				//手机号查询
				MemberInfo param = new MemberInfo();
				param.setTellPhone(f.getTellPhone());
				MemberInfo m = memberInfoMapper.selectByPrimaryKey(param);
				count++;
				//用户名查询
				if(m==null) {
					MemberInfo param1 = new MemberInfo();
					param1.setUserName(f.getTellPhone());
					m = memberInfoMapper.selectByPrimaryKey(param1);
					count++;
				}
				//身份证号查询
				if(m==null) {
					PractitionerInfo pra = practitionerInfoMapper.selectByIdCert(f.getCertificateNumber(), null);
					if(pra!=null) {
						m = new MemberInfo();
						m.setRoleId(pra.getId());
						m.setRoleType(pra.getType() == 1 ? 3: pra.getType() == 2 ? 4 :null);
						count++;
					}
				}
				if(m!=null) {
					//校验机构报名的用户是否已经申请报名并且订单状态还存在     这样的用户不允许二次报名
					OrderVo orderVo = fcApplyMapper.selectApplyOrder(record.getCourseId(), m.getRoleType()==3?1:m.getRoleType()==4?2:null,m.getRoleId());
					if(orderVo!=null) {
					Date d = new Date();
					//订单的开始时间到现在是否为两天            或者                订单的状态为已支付       未支付的情况不准确
					if((orderVo.getPayStatus()!=null && orderVo.getPayStatus().intValue()==2) || (orderVo.getCreateTime()!=null && DateUtil.getLongOfTwoDate(orderVo.getCreateTime(),d)>1)){
						if(count == 1) {
							resultMap.put("error",f.getTellPhone()+":此用户已报名该课程,并且已生成订单");
						}else if (count == 2){
							resultMap.put("error",f.getUserName()+":此用户已报名该课程,并且已生成订单");
						}else if(count == 3) {
							resultMap.put("error",f.getCertificateNumber()+":此用户已报名该课程,并且已生成订单");
						}
						
						return ResultUtil.error(resultMap);
					}
					}
				}
			}
		}
		int index = fcApplyMapper.insertSelective(record);
		if (index > 0) {
			int staffRoleType = 0;
			if (record.getApplyType().intValue() == 1) {
				staffRoleType = 2;
				for (FcApplyPersonParam item : personList) {
					if (item.getSex() == null) {
						item.setSex(1);
					}
					//判断手机号是否存在
					MemberInfo memberParam = new MemberInfo();
					memberParam.setTellPhone(item.getTellPhone());
					MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
					if(memberInfo==null) {
						//手机号查询为null走用户名查询
						MemberInfo nameParam = new MemberInfo();
						nameParam.setUserName(item.getTellPhone());
						memberInfo = memberInfoMapper.selectByPrimaryKey(nameParam);
					}
					if(memberInfo==null) {
						//用户查询为null走身份证号查询
						PractitionerInfo p = practitionerInfoMapper.selectByIdCert(item.getCertificateNumber(), null);
						if(p!=null) {
							//用户角色id和角色类型查询员工表的id
							Integer mId = memberInfoMapper.selectByRoleIdAndType(p.getId(), p.getType() == 1 ? 3: p.getType() == 2 ? 4 :null);
							memberInfo = new MemberInfo();
							memberInfo.setRoleId(p.getId());//赋值角色id
							memberInfo.setRoleType(p.getType() == 1 ? 3: p.getType() == 2 ? 4 :null);//赋值角色类型
							//身份证号匹配成功并且手机号为null并且查询出来的用户角色为从业者                   此处是教师数据缺失的用户信息进行更新，别的数据不操作
							if(StringUtils.isBlank(p.getTellPhone())&&(p.getType()!=null && p.getType().intValue()==2)){
								// 修改员工
								MemberInfo updMember = new MemberInfo();
								updMember.setId(mId);
								updMember.setName(item.getName());
								updMember.setSex(item.getSex());
								updMember.setUserName(item.getTellPhone());
								updMember.setTellPhone(item.getTellPhone());
								updMember.setPassword(Md5Util.getEncryptedPwd("12345678"));//赋初始密码
								memberInfoMapper.updateByPrimaryKeySelective(updMember);

								// 修改家长/从业者
								PractitionerInfo updPractitioner = new PractitionerInfo();
								updPractitioner.setPassword(Md5Util.getEncryptedPwd("12345678"));//赋初始密码
								updPractitioner.setId(memberInfo.getRoleId());
								updPractitioner.setUserName(item.getTellPhone());
								updPractitioner.setTellPhone(item.getTellPhone());
								updPractitioner.setName(item.getName());
								updPractitioner.setSex(item.getSex());
								updPractitioner.setCertificateNumber(item.getCertificateNumber());
								updPractitioner.setPost(item.getPost());
								updPractitioner.setWorkYear(item.getWorkYear());
								updPractitioner.setCensusAddress(item.getCensusAddress());
								updPractitioner.setInstitutionName(item.getInstitutionName());
								updPractitioner.setInstitutionAddress(item.getInstitutionAddress());
								updPractitioner.setEducation(item.getEducation());
								updPractitioner.setEthnic(item.getEthnic());
								updPractitioner.setNativePlace(item.getNativePlace());
								updPractitioner.setMailingAddress(item.getMailingAddress());
								updPractitioner.setAge(item.getAge());
								practitionerInfoMapper.updateByPrimaryKeySelective(updPractitioner);
							}
						}
					}
					if (memberInfo != null) {
						if (memberInfo.getRoleType().intValue() != 3 && memberInfo.getRoleType().intValue() != 4) {
							continue;
						}
 
						// 修改员工
//						MemberInfo updMember = new MemberInfo();
//						updMember.setId(memberInfo.getId());
//						updMember.setName(item.getName());
//						updMember.setSex(item.getSex());
//						memberInfoMapper.updateByPrimaryKeySelective(updMember);

						// 修改家长/从业者
//						PractitionerInfo updPractitioner = new PractitionerInfo();
//						updPractitioner.setId(memberInfo.getRoleId());
//						updPractitioner.setName(item.getName());
//						updPractitioner.setSex(item.getSex());
//						updPractitioner.setCertificateNumber(item.getCertificateNumber());
//						updPractitioner.setPost(item.getPost());
//						updPractitioner.setWorkYear(item.getWorkYear());
//						updPractitioner.setCensusAddress(item.getCensusAddress());
//						updPractitioner.setInstitutionName(item.getInstitutionName());
//						updPractitioner.setInstitutionAddress(item.getInstitutionAddress());
//						updPractitioner.setEducation(item.getEducation());
//						updPractitioner.setEthnic(item.getEthnic());
//						updPractitioner.setNativePlace(item.getNativePlace());
//						updPractitioner.setMailingAddress(item.getMailingAddress());
//						practitionerInfoMapper.updateByPrimaryKeySelective(updPractitioner);

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
						practitionerInfo.setPassword(Md5Util.getEncryptedPwd("12345678"));
						practitionerInfo.setName(item.getName());
						practitionerInfo.setTellPhone(item.getTellPhone());
						practitionerInfo.setCertificateNumber(item.getCertificateNumber());
						practitionerInfo.setSex(item.getSex());
						practitionerInfo.setPost(item.getPost());
						practitionerInfo.setWorkYear(item.getWorkYear());
						practitionerInfo.setCensusAddress(item.getCensusAddress());
						practitionerInfo.setInstitutionName(item.getInstitutionName());
						practitionerInfo.setInstitutionAddress(item.getInstitutionAddress());
						practitionerInfo.setEducation(item.getEducation());
						practitionerInfo.setType(item.getRoleType());
						practitionerInfo.setEthnic(item.getEthnic());
						practitionerInfo.setNativePlace(item.getNativePlace());
						practitionerInfo.setMailingAddress(item.getMailingAddress());
						practitionerInfo.setRealName(item.getName());
						practitionerInfo.setAge(item.getAge());
						practitionerInfoMapper.insertSelective(practitionerInfo);
						// 新增员工表
						MemberInfo insMemberModel = new MemberInfo();
						insMemberModel.setUserName(item.getTellPhone());
						insMemberModel.setName(item.getName());
						insMemberModel.setTellPhone(item.getTellPhone());
						insMemberModel.setPassword(Md5Util.getEncryptedPwd("12345678"));
						insMemberModel.setSex(item.getSex());
						insMemberModel.setAddress(item.getInstitutionAddress());
						insMemberModel.setIsStart(1);//是否启用
						insMemberModel.setState(2);//已审核
						insMemberModel.setSource(1);//用户来源
						insMemberModel.setRoleId(practitionerInfo.getId());
						insMemberModel.setPhoto("assets/image/userImg.jpg");
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

				//个人报名申请不修改用户个人信息
//				FcApplyPersonParam personModel = personList.get(0);
//				MemberInfo memberParam = new MemberInfo();
//				memberParam.setTellPhone(personModel.getTellPhone());
//				MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
//				if (memberInfo != null) {
//					// 修改员工
//					MemberInfo updMember = new MemberInfo();
//					updMember.setId(memberInfo.getId());
//					updMember.setName(personModel.getName());
//					memberInfoMapper.updateByPrimaryKeySelective(memberInfo);
//
//					// 修改家长/从业者
//					PractitionerInfo updPractitioner = new PractitionerInfo();
//					updPractitioner.setId(memberInfo.getRoleId());
//					// 姓名
//					updPractitioner.setName(personModel.getName());
//					updPractitioner.setPost(personModel.getPost());
//					updPractitioner.setWorkYear(personModel.getWorkYear());
//					// 学历
//					updPractitioner.setEducation(personModel.getEducation());
//					// 机构名称
//					updPractitioner.setInstitutionName(personModel.getInstitutionName());
//					// 单位地址
//					updPractitioner.setInstitutionAddress(personModel.getInstitutionAddress());
//					updPractitioner.setEthnic(personModel.getEthnic());
//					updPractitioner.setNativePlace(personModel.getNativePlace());
//					updPractitioner.setMailingAddress(personModel.getMailingAddress());
//					practitionerInfoMapper.updateByPrimaryKeySelective(updPractitioner);
//				}

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
				resultMap.put("courseId", record.getCourseId());
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
				insOrder.setApplyId(id);
				// 订单金额和支付金额
				List<FcApplyPerson> personList = fcApplyPersonMapper.findByApplyId(id);
				FcCourseArchives fcCourseArchives = fcCourseArchivesMapper.selectByPrimaryKey(applyModel.getCourseId());
				BigDecimal orderMoney = fcCourseArchives.getCoursePrice().multiply(BigDecimal.valueOf(personList.size()));
				insOrder.setOrderAmount(orderMoney);
				insOrder.setPayAmount(orderMoney);
				int insOrderIndex = fcOrderMapper.insertSelective(insOrder);
				if (insOrderIndex > 0) {
					int totalCount = fcCourseHourMapper.selectCourseHourCountByCOurseId(applyModel.getCourseId());
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
