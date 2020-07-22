package chinaPress.role.member.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.service.TeacherInfoService;

@RestController
@RequestMapping("/teacher")
public class TeacherInfoController {

	
	@Autowired
	private TeacherInfoService teacherInfoService;
	
	/**
	 * 查询教师证书信息
	 * @param name
	 * @param certificateNumber
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCert")
	public Result queryTeacherAndCert(String name,String certificateNumber) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndCert(practitionerInfo);
	}
	
	
	/**
	 * 查询教师成绩信息
	 * @param name
	 * @param certificateNumber
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndScore")
	public Result queryTeacherAndScore(String name,String certificateNumber) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndScore(practitionerInfo);
	}
	
	
	/**
	 * 认证教师
	 * 查询教师证书信息
	 * @param name
	 * @param certificateNumber
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCertInfos")
	public Result queryTeacherAndCertInfos(String name,String certificateNumber) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndCertInfos(practitionerInfo);
	}
	
	
	
	/**
	 * 教师id查询证书信息    证书信息展示，发证机构，发证时间，证书图片，证书编号
	 * @param teaId  教师id
	 * @param type   1只查教师资格证信息     null查询所有证书信息
	 * @return
	 */
	@RequestMapping("/queryTeacherByCers")
	public Result queryTeacherByCers(Integer teaId,Integer type) {
		return teacherInfoService.findTeacherByCers(teaId,type);
	}
}
