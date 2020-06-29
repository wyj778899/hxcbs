package chinaPress.role.member.controller;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.role.member.model.MemberInfo;
import chinaPress.role.member.model.PractitionerInfo;
import chinaPress.role.member.model.TrainInstitutionInfo;
import chinaPress.role.member.model.UserInfo;
import chinaPress.role.member.service.MemberInfoService;
import chinaPress.role.member.vo.PractitionerApplyInfoVo;

@RestController
@RequestMapping("/member")
public class MemberInfoController {

	/**
	 * 用户业务层注入
	 */
	@Autowired
	private MemberInfoService memberInfoService;
	
	/**
	 * 添加培训机构
	 * @param trainInstitutionInfo
	 * @return
	 */
	@RequestMapping("/registerInstitution")
	public Result registerInstitution(TrainInstitutionInfo trainInstitutionInfo) {
		return memberInfoService.addInstitution(trainInstitutionInfo);
	}
	
	/**
	 * 更新培训机构
	 * @param trainInstitutionInfo
	 * @return
	 */
	@RequestMapping("/modifyInstitution")
	public Result modifyInstitution(TrainInstitutionInfo trainInstitutionInfo) {
		return memberInfoService.setInstitution(trainInstitutionInfo);
	}
	
	/**
	 * 通过id查询培训机构信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPageInstitution")
	public Result queryPageInstitution(int id) {
		return memberInfoService.findInstitution(id);
	}
	
	/**
	 * 添加用户信息
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/registerUser")
	public Result registerUser(UserInfo userInfo) {
		return memberInfoService.addUserInfo(userInfo);
	}
	
	/**
	 * 通过id查询用户信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPageUser")
	public Result queryPageUser(int id) {
		return memberInfoService.findUserInfo(id);
	}
	
	/**
	 * 更新用户信息
	 * @param userInfo
	 * @return
	 */
	@RequestMapping("/modifyUser")
	public Result modifyUser(UserInfo userInfo) {
		return memberInfoService.setUserInfo(userInfo);
	}
	
	/**
	 * 添加家长/从业者信息
	 * @param practitioner
	 * @return
	 */
	@RequestMapping("/registerPractitioner")
	public Result registerPractitioner(PractitionerInfo practitioner) {
		return memberInfoService.addPractitionerInfo(practitioner);
	}
	
	/**
	 * 通过id查询家长/从业者信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPagePractitioner")
	public Result queryPagePractitioner(int id) {
		return memberInfoService.findPractitionerInfo(id);
	}
	
	/**
	 * 通过id查询家长/从业者报名信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/findPractitionerApplyInfo")
	public Result findPractitionerApplyInfo(Integer id) {
		PractitionerApplyInfoVo model = memberInfoService.findPractitionerApplyInfo(id);
		if (model != null) {
			return ResultUtil.ok(model);
		} else {
			return ResultUtil.error();
		}
	}
	
	/**
	 * 添加会员信息
	 * @param memberInfo
	 * @return
	 */
	@RequestMapping("/registerMember")
	public Result registerMember(MemberInfo memberInfo) {
		return memberInfoService.addMemberInfo(memberInfo);
	}
	
	/**
	 * 通过id查询会员信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/queryPageMember")
	public Result queryPageMember(int id) {
		return memberInfoService.findMemberById(id);
	}
	
	/**
	 * 更新会员信息
	 * @param memberInfo
	 * @return
	 */
	@RequestMapping("/modifyMember")
	public Result modifyMember(MemberInfo memberInfo) {
		return memberInfoService.setMemberInfo(memberInfo);
	}
	
	/**
	 * 更新家长/从业者信息
	 * @param practitioner
	 * @return
	 */
	@RequestMapping("/modifyPractitioner")
	public Result modifyPractitioner(PractitionerInfo practitioner) {
		return memberInfoService.setpractitionerInfo(practitioner);
	}
	
	/**
	 * 登陆验证   手机号 + 密码
	 * @param userName
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/login")
	public Result login(String userName,String password,HttpServletRequest request) {
		Result result = memberInfoService.findNameAndPassword(userName, password);
		if(result.getData()!=null) {
			request.getSession().setAttribute("member", result.getData());
		}
		return result;
	}
	
	/**
	 * 通过用户名，手机号，证件号展示家长/从业人员信息
	 * @param name
	 * @param certificateNumber
	 * @param tellPhone
	 * @param type 1家长/2从业者
	 * @param page
	 * @param limit
	 * @return
	 */
	@RequestMapping("/queryPractitionerAll")
	public Result queryPractitionerAll(String name,String certificateNumber,String tellPhone,Integer type,Integer page,Integer limit) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setPage((page-1)*limit);
		practitionerInfo.setLimit(limit);
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setTellPhone(tellPhone);
		practitionerInfo.setType(type);
		return memberInfoService.findPractitionerAll(practitionerInfo);
	}
	
	/**
	 * 通过用户名，手机号，证件号展示家长/从业人员信息  查询总个数，用户分页
	 * @param name
	 * @param certificateNumber
	 * @param tellPhone
	 * @param type
	 * @return
	 */
	@RequestMapping("/queryPractitionerCount")
	public Result queryPractitionerCount(String name,String certificateNumber,String tellPhone,Integer type) {
		PractitionerInfo practitionerInfo = new PractitionerInfo();
		practitionerInfo.setName(name);
		practitionerInfo.setCertificateNumber(certificateNumber);
		practitionerInfo.setTellPhone(tellPhone);
		practitionerInfo.setType(type);
		return memberInfoService.findPractitionerCount(practitionerInfo);
	}
	
	/**
	 * 通过公司名称，企业编码，企业法人，注册人手机号，开始页数，每页显示的条数显示培训机构信息
	 * @param name
	 * @param code
	 * @param legalPerson
	 * @param registerTell
	 * @return
	 */
	@RequestMapping("/queryInstitutionAll")
	public Result queryInstitutionAll(String name,String code,String legalPerson,String registerTell,Integer page,Integer limit) {
		TrainInstitutionInfo trainInstitutionInfo = new TrainInstitutionInfo();
		trainInstitutionInfo.setName(name);
		trainInstitutionInfo.setCode(code);
		trainInstitutionInfo.setLegalPerson(legalPerson);
		trainInstitutionInfo.setRegisterTell(registerTell);
		trainInstitutionInfo.setPage((page-1)*limit);
		trainInstitutionInfo.setLimit(limit);
		return memberInfoService.findTrainInstitutionAll(trainInstitutionInfo);
	}
	
	
	/**
	 * 通过公司名称，企业编码，企业法人，注册人手机号，开始页数，每页显示的条数显示培训机构信息   用于分页展示条件查询数据个数
	 * @param name
	 * @param code
	 * @param legalPerson
	 * @param registerTell
	 * @return
	 */
	@RequestMapping("/queryInstitutionCount")
	public Result queryInstitutionCount(String name,String code,String legalPerson,String registerTell) {
		TrainInstitutionInfo trainInstitutionInfo = new TrainInstitutionInfo();
		trainInstitutionInfo.setName(name);
		trainInstitutionInfo.setCode(code);
		trainInstitutionInfo.setLegalPerson(legalPerson);
		trainInstitutionInfo.setRegisterTell(registerTell);
		return memberInfoService.findTrainInstitutionCount(trainInstitutionInfo);
	}
	
	/**
	 * 
	 * @param file
	 * @param request
	 * @param response
	 * @param type 1为培训机构   2为家长/从业者
	 * @return
	 */
	@RequestMapping("/dataImport.do")
	@ResponseBody
	public Result dataImport(MultipartFile file,HttpServletRequest request, HttpServletResponse response,Integer type) {
		Result result = null;
		if(file==null) {
			return new Result(-1, "文件不存在", "");
		}
		String name=file.getOriginalFilename();
		if(name.indexOf(".xlsx")==-1) {
			return new Result(-1, "请上传.xlsx结尾的文件", "");
		}
        try {
			InputStream in = file.getInputStream();
			XSSFWorkbook wb = new XSSFWorkbook(in);
			result =  memberInfoService.ExcelImport(wb,type);
			wb.close();
			in.close();
			return result;
		} catch (IOException e) {
			e.printStackTrace();
			return new Result(-1, "上传失败", "");
		}
	}
	
	
	/**
	 * 通过用户名/手机号和姓名查询员工信息，用于发放优惠券
	 * @param name       用户名/手机号
	 * @param page   	   页数
	 * @param name       每页显示的条数
	 * @return
	 */
	@RequestMapping("/queryMembers")
	public Result queryMembers(String name,Integer page,Integer limit) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setName(name);
		memberInfo.setPage((page-1)*limit);
		memberInfo.setLimit(limit);
		return memberInfoService.findMemberNameAndTell(memberInfo);
	}
	
	
	/**
	 * 通过用户名/手机号和姓名查询员工信息，用于发放优惠券    返回查询数据的个数
	 * @param name
	 * @return
	 */
	@RequestMapping("/queryMemberCount")
	public Result queryMemberCount(String name) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setName(name);
		return memberInfoService.findMemberCount(memberInfo);
	}
	
	/**
	 * 用过角色id和角色类型查询用户证书信息
	 * @param roleTd
	 * @param roleType
	 * @return
	 */
	@RequestMapping("/queryUserAndCers")
	public Result queryUserAndCers(Integer roleId,Integer roleType) {
		return memberInfoService.findUserAndCers(roleId, roleType);
	}
	
	/**
	 * 用过角色id和角色类型查询用户证书信息个数
	 * @param roleTd
	 * @param roleType
	 * @return
	 */
	@RequestMapping("/queryUserAndCerCounts")
	public Result queryUserAndCerCounts(Integer roleId,Integer roleType) {
		return memberInfoService.findUserAndCerCounts(roleId, roleType);
	}
	
	/**
	 * 通过员工手机号修改员工密码   员工表和所属类型的员工的密码都会修改        比如家长表和员工表会同时修改
	 * @param userName   用户名
	 * @param password   新密码
	 * @param verificationCode   验证码
	 * @return
	 */
	@RequestMapping("/registerPassword")
	public Result registerPassword(String tellPhone,String password,String verificationCode) {
		MemberInfo memberInfo = new MemberInfo();
		memberInfo.setTellPhone(tellPhone);
		memberInfo.setPassword(password);
		memberInfo.setVerificationCode(verificationCode);
		return memberInfoService.updatePassword(memberInfo);
	}
	
	/**
	 * 登录状态下修改密码不需要验证码
	 * @param tellPhone   手机号
	 * @param passwordOld 原始密码
	 * @param passwordNew 修改的新密码
	 * @param password    输入的原始密码
	 * @return
	 */
	@RequestMapping("/registerUserPwd")
	public Result registerUserPwd(String tellPhone,String passwordOld,String passwordNew,String password) {
		return memberInfoService.updateUserPwd(tellPhone,passwordOld,passwordNew,password);
	}
}
