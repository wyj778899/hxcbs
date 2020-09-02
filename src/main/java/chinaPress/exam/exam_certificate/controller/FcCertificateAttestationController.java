package chinaPress.exam.exam_certificate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.exam.exam_certificate.model.FcCertificateAttestation;
import chinaPress.exam.exam_certificate.service.FcCertificateAttestationService;

/**
 * 证书档案信息
 * @author wyj
 *
 */
@RestController
@RequestMapping("/certAttestation")
public class FcCertificateAttestationController {
	
	@Autowired
	private FcCertificateAttestationService fcCertificateAttestationService;

	/**
	 * 添加证书档案
	 * @param attestation
	 * @return
	 */
	@RequestMapping("/registerAttestation")
	public Result registerAttestation(FcCertificateAttestation attestation) {
		return fcCertificateAttestationService.addAttestation(attestation);
	}
	
	/**
	 * 更新证书档案
	 * @param attestation
	 * @return
	 */
	@RequestMapping("/modifyAttestation")
	public Result modifyAttestation(FcCertificateAttestation attestation) {
		return fcCertificateAttestationService.setAttestation(attestation);
	}
	
	/**
	 * id查询证书信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPageAttestation")
	public Result queryPageAttestation(Integer id) {
		return fcCertificateAttestationService.findPageAttestation(id);
	}
	
	/**
	 * 删除证书档案信息
	 * @param id
	 */
	@RequestMapping("/removeAttestation")
	public Result removeAttestation(Integer id) {
		return fcCertificateAttestationService.deleteAttestation(id);
	}
	
	/**
	 * 查询所有证书信息
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryAttestationAll")
	public Result queryAttestationAll(Integer page,Integer limit) {
		return fcCertificateAttestationService.findAttestationAll((page-1)*limit, limit);
	}
	
	/**
	 * 查询所有证书信息个数
	 * @return
	 */
	@RequestMapping("/queryAttestationCount")
	public Result queryAttestationCount() {
		return fcCertificateAttestationService.findAttestationAllCount();
	}
	
	/**
	 * 角色id和角色类型查询证书信息
	 * @param roleId
	 * @param roleType
	 * @return
	 */
	@RequestMapping("/queryUserCertificate")
	public Result queryUserCertificate(Integer roleId,Integer roleType) {
		return fcCertificateAttestationService.findUserCertificate(roleId, roleType);
	}
}
