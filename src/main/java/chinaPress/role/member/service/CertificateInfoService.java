package chinaPress.role.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.dao.CertificateInfoMapper;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.model.CertificateInfo;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.vo.MemberAndCer;

@Service
@Transactional
public class CertificateInfoService {

	/**
	 * 注入证书dao
	 */
	@Autowired
	private CertificateInfoMapper certificateInfoMapper;
	
	/**
	 * 注入员工dao
	 */
	@Autowired
	private MemberInfoMapper memberInfoMapper;

	/**
	 *添加证书 
	 * @param certificateInfo
	 * @return
	 */
	public Result addCertificate(CertificateInfo certificateInfo) {
		certificateInfo.setState(1);
		certificateInfo.setAuditStatus(1);
		int i = certificateInfoMapper.insertSelective(certificateInfo);
		if (i > 0) {
			return new Result(0, "添加成功", "");
		} else {
			return new Result(-1, "数据库错误", "");
		}
	}

	/**
	 * 更新证书
	 * @param certificateInfo
	 * @return
	 */
	public Result setCertificate(CertificateInfo certificateInfo) {
		int i = certificateInfoMapper.updateByPrimaryKeySelective(certificateInfo);
		if (i > 0) {
			return new Result(0, "更新成功", "");
		} else {
			return new Result(-1, "数据库错误", "");
		}
	}
	
	/**
	 * 通过id 查询证书只返回证书图片信息
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findCertificateOnePrice(Integer id) {
		CertificateInfo c = certificateInfoMapper.selectByPrimaryKey(id);
		if (c != null) {
			return new Result(0, "查询成功", c.getPhoto());
		} else {
			return new Result(-1, "数据库错误", "");
		}
	}

	/**
	 * 通过id 查询证书
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Result findCertificateOne(Integer id) {
		CertificateInfo c = certificateInfoMapper.selectByPrimaryKey(id);
		if (c != null) {
			return new Result(0, "查询成功", c);
		} else {
			return new Result(-1, "数据库错误", "");
		}
	}
	
	/**
	 * 通过证书id 查询用户和证书的关联信息    用于管理员审核证书信息
	 * @param id
	 * @return
	 */
	@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
	public Result findByCerId(Integer id) {
		MemberAndCer memberAndCer = memberInfoMapper.selectByCerId(id);
		if(memberAndCer!=null) {
			return new Result(0,"查询成功",memberAndCer);
		}else {
			return new Result(-1,"数据库错误","");
		}
	}

	/**
	 * 根据用户名，手机号，证书类型，审核状态，条件查询证书信息
	 * @param certificateInfo
	 * @return
	 */
	 @Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
	 public Result findCertificates(MemberInfo memberInfo) { 
		 List<MemberAndCer> list = memberInfoMapper.selectMemberAndCertificate(memberInfo);
		 if (list.size()>0) { 
			 return new Result(0, "查询成功", list); 
		 } else { 
			 return new Result(-1, "数据库错误", ""); 
		 } 
	}
	 

	 /**
	  * 根据用户名，手机号，证书类型，审核状态，条件查询证书信息   根据条件展示个数  用于分页展示
	  * @param memberInfo
	  * @return
	  */
	 @Transactional(propagation = Propagation.SUPPORTS, readOnly = true) 
	 public Result findCertificateCount(MemberInfo memberInfo) {
		 int count = memberInfoMapper.queryCerCount(memberInfo);
		 if(count>0) {
			 return new Result(0, "查询成功", count); 
		 }else {
			 return new Result(-1, "查询失败", 0); 
		 }
	 }
	 
}
