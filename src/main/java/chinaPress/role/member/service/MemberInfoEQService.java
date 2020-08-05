package chinaPress.role.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.Md5Util;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.dao.PractitionerInfoMapper;
import chinaPress.role.member.dao.TrainInstitutionInfoMapper;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.model.TrainInstitutionInfo;
import chinaPress.role.member.vo.MemberInfoVo;


/**
 * 20200720     恩启注册用户业务类
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
	 * 培训机构
	 */
	@Autowired
	private TrainInstitutionInfoMapper trainInstitutionInfoMapper;
	
	/**
	 * 家长/从业者注册
	 * @param practitionerInfo
	 * @return
	 */
	@Transactional
	public Result addPract(PractitionerInfo practitionerInfo) {
		if(practitionerInfo.getRealName()==null || practitionerInfo.getRealName()=="") {
			return new Result(-1,"真实姓名必填",-1);
		}
		if(practitionerInfo.getCertificateNumber()==null || practitionerInfo.getCertificateNumber()=="") {
			return new Result(-1,"身份证号必填",-1);
		}
		if(practitionerInfo.getSex()==null) {
			return new Result(-1,"性别必填",-1);
		}
		if(practitionerInfo.getEmail()==null || practitionerInfo.getEmail()=="") {
			return new Result(-1,"邮箱必填",-1);
		}
		if(practitionerInfo.getWorkYear()==null) {
			return new Result(-1,"工作年限必填",-1);
		}
		if(practitionerInfo.getEmail()==null || practitionerInfo.getEmail()=="") {
			return new Result(-1,"邮箱必填",-1);
		}
		if(practitionerInfo.getNativePlace()==null || practitionerInfo.getNativePlace()=="") {
			return new Result(-1,"籍贯必填",-1);
		}
		if(practitionerInfo.getEthnic()==null || practitionerInfo.getEthnic()=="") {
			return new Result(-1,"民族必填",-1);
		}
		if(practitionerInfo.getEducation()==null || practitionerInfo.getEducation()=="") {
			return new Result(-1,"学历必填",-1);
		}
		if(practitionerInfo.getPost()==null || practitionerInfo.getPost()=="") {
			return new Result(-1,"职业必填",-1);
		}
		if(practitionerInfo.getMailingAddress()==null || practitionerInfo.getMailingAddress()=="") {
			return new Result(-1,"邮寄地址必填",-1);
		}
		if(practitionerInfo.getInstitutionName()==null || practitionerInfo.getInstitutionName()=="") {
			return new Result(-1,"现就职机构名称必填",-1);
		}
		if(practitionerInfo.getInstitutionAddress()==null || practitionerInfo.getInstitutionAddress()=="") {
			return new Result(-1,"工作所在地详细地址必填",-1);
		}
		if(practitionerInfo.getUserName()==null || practitionerInfo.getUserName()=="") {
			return new Result(-1,"用户名必填",-1);
		}
		if(practitionerInfo.getTellPhone()==null || practitionerInfo.getTellPhone()=="") {
			return new Result(-1,"手机号必填",-1);
		}
		//通过手机号和用户名判断用户是否存在
		MemberInfo nameParam = new MemberInfo();
		String userName = practitionerInfo.getUserName();
		nameParam.setUserName(userName);
		if(memberInfoMapper.selectByPrimaryKey(nameParam)!=null) {
			return new Result(-1,"用户名已注册",-1);
		}
		
		MemberInfo tellParam = new MemberInfo();
		String tellPhone = practitionerInfo.getTellPhone();
		tellParam.setTellPhone(tellPhone);
		if(memberInfoMapper.selectByPrimaryKey(tellParam)!=null) {
			return new Result(-1,"手机号注册",-1);
		}
 
		try {
			//判断身份证号
			String certificate = practitionerInfo.getCertificateNumber();
			if (certificate != null && certificate != "") {
				// 家长和从业者
				PractitionerInfo p = practitionerInfoMapper.selectByIdCert(certificate, null);
				if (p != null) {
					// 用户身份
					Integer type = p.getType();
					String phone = p.getTellPhone();
					// 注册信息为从业者,身份证号不为null的信息身份为从业者和手机号码为null 满足修改条件
					if ((practitionerInfo.getType() != null && practitionerInfo.getType() == 2) && type == 2
							&& (phone.length()==0 || phone.equals(""))) {
						// 为从业者时执行更新操作
						practitionerInfo.setId(p.getId());
						//恩起注册的用户赋值初始密码
						practitionerInfo.setPassword(Md5Util.getEncryptedPwd("12345678"));
						//角色id和角色类型查询档案表id
						Integer id = memberInfoMapper.selectByRoleIdAndType(practitionerInfo.getId(), 4);
						if(id==null) {
							return new Result(-1,"用户信息异常","");
						}
						practitionerInfo.setSource(1);//更新的话归属于华夏
						practitionerInfoMapper.updateByPrimaryKeySelective(practitionerInfo);
						MemberInfo m = new MemberInfo();
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
						m.setSource(1);//更新的话用户归属于华夏
						m.setId(id);//档案表的id
						// 状态有值进行操作
						if (practitionerInfo.getType() != null && 1 == practitionerInfo.getType()) {
							m.setRoleType(3);
						}
						if (practitionerInfo.getType() != null && 2 == practitionerInfo.getType()) {
							m.setRoleType(4);
						}
						m.setPhoto(practitionerInfo.getUserHead());
						memberInfoMapper.updateByPrimaryKeySelective(m);
						return new Result(0, "添加成功", "");
					} else {
						return new Result(-1, "身份证号已注册", "");
					}
				}
				// 培训机构
				TrainInstitutionInfo t = trainInstitutionInfoMapper.selectByIdCert(certificate, null);
				if (t != null) {
					return new Result(-1, "身份证号已注册", "");
				}
			}
			practitionerInfo.setSource(2);//创建的话归属于恩起
			practitionerInfo.setState(1);
			practitionerInfo.setPassword(Md5Util.getEncryptedPwd("12345678"));
			practitionerInfo.setName(practitionerInfo.getRealName());
			//添加家长从业者信息
			practitionerInfoMapper.insertSelective(practitionerInfo);
			MemberInfo m = new MemberInfo();
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
			m.setState(2);//创建的话对数恩起
			m.setRoleId(practitionerInfo.getId());
			m.setSource(2);
			if(practitionerInfo.getType()==1) {
				m.setRoleType(3);
			}else {
				m.setRoleType(4);
			}
			m.setPhoto("assets/image/userImg.jpg");
			//添加员工档案信息
			memberInfoMapper.insertSelective(m);
			MemberInfoVo memberInfoVo = new MemberInfoVo();
			memberInfoVo.setName(userName);
			memberInfoVo.setPhoto(m.getPhoto());
			memberInfoVo.setRoleId(m.getRoleId());
			memberInfoVo.setRoleType(m.getRoleType());
			memberInfoVo.setTellPhone(tellPhone);
			return new Result(1,"ok",memberInfoVo);
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(0,"error",null);
		}
	}
}
