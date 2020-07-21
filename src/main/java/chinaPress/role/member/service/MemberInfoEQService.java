package chinaPress.role.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.Md5Util;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.vo.MemberInfoVo;


/**
 * 20200720     恩起注册用户业务类
 * @author wyj
 *
 */
@Service
public class MemberInfoEQService {

	/**
	 * 员工信息
	 */
	@Autowired
	private MemberInfoMapper memberInfoMapper;

	/**
	 * 家长从业者
	 */
	@Autowired
	private PractitionerInfoMapper practitionerInfoMapper;
	
	/**
	 * 报名申请
	 */
	@Autowired
	private FcApplyMapper fcApplyMapper;
	
	
	/**
	 * 报名申请的用户关联课程进度
	 */
	@Autowired
	private FcApplyPersonMapper fcApplyPersonMapper;

	/**
	 * 从业者注册
	 * 1：注册
	 * 2：报名
	 * 3：生成订单
	 * 4：关联课程学习进度
	 * @param practitionerInfo
	 * @return
	 */
	@Transactional
	public Result addPract(PractitionerInfo practitionerInfo) {
		if(practitionerInfo.getRealName()==null || practitionerInfo.getRealName()=="") {
			return new Result(-1,"真实姓名必填","");
		}
		if(practitionerInfo.getCertificateNumber()==null || practitionerInfo.getCertificateNumber()=="") {
			return new Result(-1,"身份证号必填","");
		}
		if(practitionerInfo.getSex()==null) {
			return new Result(-1,"性别必填","");
		}
		if(practitionerInfo.getEmail()==null || practitionerInfo.getEmail()=="") {
			return new Result(-1,"邮箱必填","");
		}
		if(practitionerInfo.getWorkYear()==null) {
			return new Result(-1,"工作年限必填","");
		}
		if(practitionerInfo.getEmail()==null || practitionerInfo.getEmail()=="") {
			return new Result(-1,"邮箱必填","");
		}
		if(practitionerInfo.getNativePlace()==null || practitionerInfo.getNativePlace()=="") {
			return new Result(-1,"籍贯必填","");
		}
		if(practitionerInfo.getEthnic()==null || practitionerInfo.getEthnic()=="") {
			return new Result(-1,"民族必填","");
		}
		if(practitionerInfo.getEducation()==null || practitionerInfo.getEducation()=="") {
			return new Result(-1,"学历必填","");
		}
		if(practitionerInfo.getPost()==null || practitionerInfo.getPost()=="") {
			return new Result(-1,"职业必填","");
		}
		if(practitionerInfo.getMailingAddress()==null || practitionerInfo.getMailingAddress()=="") {
			return new Result(-1,"邮寄地址必填","");
		}
		if(practitionerInfo.getInstitutionName()==null || practitionerInfo.getInstitutionName()=="") {
			return new Result(-1,"现就职机构名称必填","");
		}
		if(practitionerInfo.getInstitutionAddress()==null || practitionerInfo.getInstitutionAddress()=="") {
			return new Result(-1,"工作所在地详细地址必填","");
		}
		if(practitionerInfo.getUserName()==null || practitionerInfo.getUserName()=="") {
			return new Result(-1,"用户名必填","");
		}
		if(practitionerInfo.getTellPhone()==null || practitionerInfo.getTellPhone()=="") {
			return new Result(-1,"手机号必填","");
		}
		//通过手机号和用户名判断用户是否存在
		MemberInfo nameParam = new MemberInfo();
		String userName = practitionerInfo.getUserName();
		nameParam.setUserName(userName);
		MemberInfo m = memberInfoMapper.selectByPrimaryKey(nameParam);
		if(m==null) {		
			MemberInfo tellParam = new MemberInfo();
			String tellPhone = practitionerInfo.getTellPhone();
			tellParam.setTellPhone(tellPhone);
			m = memberInfoMapper.selectByPrimaryKey(tellParam);
		}
		Integer id = null;
		Integer type = null;
		try {
			practitionerInfo.setSource(2);
			practitionerInfo.setState(2);
			//用户存在不做任何操作直接报名,
			if(m!=null) {
				id = m.getRoleId();
				//员工档案表里面的3代表家长，4代表从业者
				type = m.getRoleType() == 3 ? 2:3;
			}else {//否则走添加操作
				practitionerInfo.setPassword(Md5Util.getEncryptedPwd("12345678"));
				practitionerInfoMapper.insertSelective(practitionerInfo);
				id = practitionerInfo.getId();
				m = new MemberInfo();
				m.setUserName(practitionerInfo.getUserName());
				m.setPassword(practitionerInfo.getPassword());
				m.setName(practitionerInfo.getName());
				m.setAddress(practitionerInfo.getAddress());
				m.setTellPhone(practitionerInfo.getTellPhone());
				m.setSex(practitionerInfo.getSex());
				m.setProvice(practitionerInfo.getProvice());
				m.setCity(practitionerInfo.getCity());
				m.setArea(practitionerInfo.getArea());
				m.setAddress(practitionerInfo.getAddress());
				m.setEmail(practitionerInfo.getEmail());
				m.setIsStart(1);
				m.setState(2);
				m.setRoleId(practitionerInfo.getId());
				m.setSource(2);
				if(practitionerInfo.getType()==1) {
					m.setRoleType(3);
					type = 2;
				}else {
					m.setRoleType(4);
					type = 3;
				}
				m.setPhoto("assets/image/userImg.jpg");
				memberInfoMapper.insertSelective(m);
			}
			//报名申请
			FcApply fcApply = new FcApply();
			fcApply.setApplyCount(1);//申请人数
			fcApply.setApplyId(id);//申请人id
			fcApply.setApplyType(type);//申请人类型
			fcApply.setAuditStatus(2);//已审核
			fcApply.setCourseId(1);//课程id
			fcApplyMapper.insertSelective(fcApply);//报名添加
			FcApplyPerson person = new FcApplyPerson(); //课程进度
			person.setApplyId(fcApply.getId());//报名id
			person.setRoleId(id);//用户id
			person.setRoleType(practitionerInfo.getType());//用户角色
			fcApplyPersonMapper.insertSelective(person);//课程进度添加
			return new Result(1,"ok",1);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0,"error",0);
		}
	}
}
