package chinaPress.role.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	 * @param verificationCode
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCert")
	public Result queryTeacherAndCert(String name,String certificateNumber,String verificationCode,Integer page,Integer limit,HttpServletRequest request) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		//判断验证码是否正确
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		if(verificationCode==null || verificationCode=="") {
			return new Result(-1,"验证码错误","");
		}
		if(code==null || code=="") {
			return new Result(-1,"验证码错误","");
		}
		if(!code.equals(verificationCode.toUpperCase())) {
			return new Result(-1,"验证码错误","");
		}
		return teacherInfoService.findTeacherAndCert(practitionerInfo);
	}
	
	/**
	 * 查询教师证书信息个数
	 * @param name
	 * @param certificateNumber
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCertCount")
	public Result queryTeacherAndCertCount(String name,String certificateNumber) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		return teacherInfoService.findTeacherAndCertCount(practitionerInfo);
	}
	
	/**
	 * 查询教师成绩信息
	 * @param name
	 * @param certificateNumber
	 * @param verificationCode
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndScore")
	public Result queryTeacherAndScore(String name,String certificateNumber,String verificationCode,Integer page,Integer limit,HttpServletRequest request) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		//判断验证码是否正确
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		if(verificationCode==null || verificationCode=="") {
			return new Result(-1,"验证码错误","");
		}
		if(code==null || code=="") {
			return new Result(-1,"验证码错误","");
		}
		if(!code.equals(verificationCode.toUpperCase())) {
			return new Result(-1,"验证码错误","");
		}
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
	 * @param verificationCode
	 * @param page
	 * @param limit
	 * @param request
	 * @return
	 */
	@RequestMapping("/queryTeacherAndCertInfos")
	public Result queryTeacherAndCertInfos(String name,String certificateNumber,String verificationCode,Integer type,Integer page,Integer limit,HttpServletRequest request) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		practitionerInfo.setType(type);
		//判断验证码是否正确
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		if(verificationCode==null || verificationCode=="") {
			return new Result(-1,"验证码错误","");
		}
		if(code==null || code=="") {
			return new Result(-1,"验证码错误","");
		}
		if(!code.equals(verificationCode.toUpperCase())) {
			return new Result(-1,"验证码错误","");
		}
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
	
}
