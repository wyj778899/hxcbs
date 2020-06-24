package chinaPress.role.member.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.model.CertificateInfo;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.service.CertificateInfoService;

@RestController
@RequestMapping("/certificate")
public class CertificateInfoController {

	
	@Autowired
	private CertificateInfoService certificateInfoService;
	
	/**
	 * 添加员工证书信息
	 * @param certificateInfo
	 * @return
	 */
	@RequestMapping("/registerCertificate")
	public Result registerCertificate(CertificateInfo certificateInfo) {
		return certificateInfoService.addCertificate(certificateInfo);
	}
	
	
	/**
	 * 更新员工证书信息
	 * @param certificateInfo
	 * @return
	 */
	@RequestMapping("/modifyCertificate")
	public Result modifyCertificate(CertificateInfo certificateInfo) {
		return certificateInfoService.setCertificate(certificateInfo);
	}
	
	/**
	 * 通过id查询证书信息  用于用户更新
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPageCertificate")
	public Result queryPageCertificate(Integer id) {
		return certificateInfoService.findCertificateOne(id);
	}
	
	/**
	 * 通过证书id 查询用户和证书的关联信息    用于管理员审核证书信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPageMemAndCer")
	public Result queryPageMemAndCer(Integer id) {
		return certificateInfoService.findByCerId(id);
	}
	
	/**
	 * 更新证书审核状态
	 * @param auditStatus
	 * @return
	 */
	@RequestMapping("/modifyCertificateState")
	public Result modifyCertificateState(Integer auditStatus,Integer id) {
		CertificateInfo certificateInfo = new CertificateInfo();
		certificateInfo.setId(id);
		certificateInfo.setAuditStatus(auditStatus);
		return certificateInfoService.setCertificate(certificateInfo);
	}
	
	/**
	 * 通过用户名，手机号，证书类型，审批状态查询员工的证书信息
	 * @param name
	 * @param tellPhone
	 * @param certificateType
	 * @param auditStatus
	 * @return
	 */
	@RequestMapping("/queryMemberAndCertificate")
	public Result queryMemberAndCertificate(String name,String tellPhone,Integer certificateType,Integer auditStatus,Integer page,Integer limit) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setName(name);
		memberInfo.setTellPhone(tellPhone);
		memberInfo.setAuditStatus(auditStatus);
		memberInfo.setCertificateType(certificateType);
		memberInfo.setPage((page-1)*limit);
		memberInfo.setLimit(limit);
		return certificateInfoService.findCertificates(memberInfo);
	}
	
	
	/**
	 * 通过用户名，手机号，证书类型，审批状态查询员工的证书信息   条件查询返回总个数    用于分页展示
	 * @param name
	 * @param tellPhone
	 * @param certificateType
	 * @param auditStatus
	 * @return
	 */
	@RequestMapping("/queryMemberAndCertificateCount")
	public Result queryMemberAndCertificateCount(String name,String tellPhone,Integer certificateType,Integer auditStatus) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setName(name);
		memberInfo.setTellPhone(tellPhone);
		memberInfo.setAuditStatus(auditStatus);
		memberInfo.setCertificateType(certificateType);
		return certificateInfoService.findCertificateCount(memberInfo);
	}
}
