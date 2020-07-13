package chinaPress.role.member.controller;

import javax.servlet.http.HttpServletRequest;

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
	 * @param enterpriseCode
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCert")
	public Result queryTeacherAndCert(String name,String certificateNumber,String enterpriseCode,Integer page,Integer limit,HttpServletRequest request) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		practitionerInfo.setEnterpriseCode(enterpriseCode);
		return teacherInfoService.findTeacherAndCert(practitionerInfo);
	}
	
	/**
	 * 查询教师证书信息个数
	 * @param name
	 * @param certificateNumber
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCertCount")
	public Result queryTeacherAndCertCount(String name,String certificateNumber,String enterpriseCode) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setEnterpriseCode(enterpriseCode);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndCertCount(practitionerInfo);
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
	public Result queryTeacherAndScore(String name,String certificateNumber,Integer page,Integer limit,HttpServletRequest request) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		return teacherInfoService.findTeacherAndScore(practitionerInfo);
	}
	
	/**
	 * 查询教师成绩信息个数
	 * @param name
	 * @param certificateNumber
	 * @return
	 */
	@RequestMapping("/queryTeacherAndScoreCount")
	public Result queryTeacherAndScoreCount(String name,String certificateNumber) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndScoreCount(practitionerInfo);
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
	public Result queryTeacherAndCertInfos(String name,String certificateNumber,Integer type,Integer page,Integer limit,HttpServletRequest request) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		practitionerInfo.setType(type);
		return teacherInfoService.findTeacherAndCertInfos(practitionerInfo);
	}
	
	/**
	 * 认证教师
	 * 查询教师证书信息
	 * @param name
	 * @param certificateNumber
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCertInfosCount")
	public Result queryTeacherAndCertInfosCount(String name,String certificateNumber) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndCertInfosCount(practitionerInfo);
	}
	
	
	/**
	 * 教师id和证书id查询用户信息
	 * @param teaId
	 * @param cerId
	 * @return
	 */
	@RequestMapping("/queryTeacherByIdAndCerId")
	public Result queryTeacherByIdAndCerId(Integer teaId,Integer cerId) {
		return teacherInfoService.findTeacherByIdAndCerId(teaId, cerId);
	}
	
}
