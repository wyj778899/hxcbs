package chinaPress.fc.apply.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.util.JacksonUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.fc.apply.vo.FcApplyPersonParam;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPerson;
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

	/**
	 * 新增
	 * 
	 * @param record
	 * @param personJson
	 * @return
	 */
	public int insert(FcApply record, String personJson) {
		int index = fcApplyMapper.insertSelective(record);
		if (index > 0) {
			if (record.getApplyType().intValue() == 1) {
				List<FcApplyPersonParam> personList = JacksonUtil.fromJSONList(personJson, FcApplyPersonParam.class);
				for (FcApplyPersonParam item : personList) {

					MemberInfo memberParam = new MemberInfo();
					memberParam.setTellPhone(item.getTellPhone());
					MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
					if (memberInfo != null) {
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
						// 新增家长/从业者
						PractitionerInfo practitionerInfo = new PractitionerInfo();
						practitionerInfo.setUserName(item.getTellPhone());
						practitionerInfo.setName(item.getName());
						practitionerInfo.setTellPhone(item.getTellPhone());
						practitionerInfo.setCertificateNumber(item.getCertificateNumber());
						practitionerInfo.setSex(item.getSex());
						practitionerInfo.setAddress(item.getAddress());
						practitionerInfo.setType(2);
						practitionerInfoMapper.insertSelective(practitionerInfo);
						// 新增员工表
						MemberInfo insMemberModel = new MemberInfo();
						insMemberModel.setName(item.getName());
						insMemberModel.setTellPhone(item.getTellPhone());
						insMemberModel.setSex(item.getSex());
						insMemberModel.setAddress(item.getAddress());
						insMemberModel.setIsStart(0);
						insMemberModel.setRoleId(practitionerInfo.getId());
						insMemberModel.setRoleType(4);
						memberInfoMapper.insertSelective(insMemberModel);

						FcApplyPerson applyPerson = new FcApplyPerson();
						applyPerson.setApplyId(record.getId());
						applyPerson.setCreateId(record.getCreateId());
						applyPerson.setRoleId(practitionerInfo.getId());
						applyPerson.setRoleType(2);
						fcApplyPersonMapper.insertSelective(applyPerson);
					}
				}
			} else {
				FcApplyPerson person = new FcApplyPerson();
				person.setApplyId(record.getId());
				person.setRoleId(record.getApplyId());
				person.setRoleType(record.getApplyType());
				person.setCreateId(record.getCreateId());
				fcApplyPersonMapper.insertSelective(person);
			}
		}
		return index;
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
					List<FcApplyPerson> personList = fcApplyPersonMapper.findByApplyId(id);
					for (FcApplyPerson item : personList) {
						FcOrderPerson person = new FcOrderPerson();
						person.setOrderId(insOrder.getId());
						person.setRoleId(item.getRoleId());
						person.setRoleType(item.getRoleType());
						person.setCreateId(auditPeople);
						person.setIsIndividual(0);
						fcOrderPersonMapper.insertSelective(person);
					}
				}
			}
		}
		return index;
	}
}
