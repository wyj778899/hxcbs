package chinaPress.exam.exam_signup.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam_signup.model.FcExamSignupUser;
import chinaPress.exam.exam_signup.service.FcExamSignupUserService;
import chinaPress.exam.exam_signup.vo.ExamUserVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupDetailAreaListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserPrepareVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserVo;
import chinaPress.exam.exam_signup.vo.FcExamToUserVo;

@RestController
@RequestMapping("exam_signup_user")
public class FcExamSignupUserController {
	@Autowired
	private FcExamSignupUserService examSignupUserService;

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupId          考试报名id
	 * @param signupAreaIds     考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       审核状态(0未审核,1已审核,2已驳回3.已关联考试)
	 * @param startTime         开始时间
	 * @param endTime           结束时间
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectExamSignupUserCount(Integer signupId, String signupAreaIds, String userName, String tellPhone,
			String certificateNumber, Integer examineType, String startTime, String endTime) {
		int index = examSignupUserService.selectExamSignupUserCount(signupId, signupAreaIds, userName, tellPhone,
				certificateNumber, examineType, startTime, endTime);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupId          考试报名id
	 * @param signupAreaIds     考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       审核状态(0未审核,1已审核,2已驳回3.已关联考试)
	 * @param startTime         开始时间
	 * @param endTime           结束时间
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectExamSignupUserList(Integer signupId, String signupAreaIds, String userName, String tellPhone,
			String certificateNumber, Integer examineType, String startTime, String endTime, Integer pageNumber,
			Integer pageSize) {
		List<FcExamSignupUserListVo> list = examSignupUserService.selectExamSignupUserList(signupId, signupAreaIds,
				userName, tellPhone, certificateNumber, examineType, startTime, endTime, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}

	/**
	 * 查询考试报名用户信息
	 * 
	 * @param signupUserId 考试报名用户id
	 * @return
	 */
	@RequestMapping("manage/detail")
	public Result selectManageFcExamSignupUserDetail(Integer signupUserId) {
		FcExamSignupUserDetailVo data = examSignupUserService.selectFcExamSignupUserDetail(signupUserId);
		if (data != null) {
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error(data);
		}
	}

	/**
	 * 报名之前检查是否满足报名条件
	 * 
	 * @param signupId     考试报名id
	 * @param signupAreaId 考试报名区域id
	 * @param roleId       角色id
	 * @param roleType     角色类型1.家长2.从业者
	 * @return
	 */
	@RequestMapping("index/checkIsSignup")
	public Result checkIsSignup(Integer signupId, Integer signupAreaId, Integer roleId, Integer roleType) {
		Result result = new Result();
		int index = examSignupUserService.checkIsSignup(signupId, signupAreaId, roleId, roleType);
		if (index > 0) {
			result = ResultUtil.custom(index, "可以报名", index);
		} else if (index == -1) {
			result = ResultUtil.custom(index, "该场考试报名不存在", index);
		} else if (index == -2) {
			result = ResultUtil.custom(index, "该场考试报名区域不存在", index);
		} else if (index == -3) {
			result = ResultUtil.custom(index, "该场考试报名和区域不一致", index);
		} else if (index == -4) {
			result = ResultUtil.custom(index, "该场考试报名已下架", index);
		} else if (index == -5) {
			result = ResultUtil.custom(index, "该场考试报名区域报名人数已满", index);
		} else if (index == -6) {
			result = ResultUtil.custom(index, "请在报名时间范围内报名", index);
		} else if (index == -7) {
			result = ResultUtil.custom(index, "该场考试报名区域已下架", index);
		} else if (index == -8) {
			result = ResultUtil.custom(index, "已报名该场考试报名区域", index);
		} else if (index == -9) {
			result = ResultUtil.custom(index, "不能报考相同的考试时间", index);
		} else if (index == -10) {
			result = ResultUtil.custom(index, "当前已有报考考试，无法进行报名", index);
		}
		return result;
	}

	/**
	 * 用户考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignupUser
	 * @return
	 */
	@RequestMapping("index/signup")
	public Result userSignup(FcExamSignupUser fcExamSignupUser) {
		Result result = new Result();
		int index = examSignupUserService.userSignup(fcExamSignupUser);
		if (index > 0) {
			result = ResultUtil.custom(index, "报名成功", index);
		} else if (index == -1) {
			result = ResultUtil.custom(index, "该场考试报名不存在", index);
		} else if (index == -2) {
			result = ResultUtil.custom(index, "该场考试报名区域不存在", index);
		} else if (index == -3) {
			result = ResultUtil.custom(index, "该场考试报名和区域不一致", index);
		} else if (index == -4) {
			result = ResultUtil.custom(index, "该场考试报名已下架", index);
		} else if (index == -5) {
			result = ResultUtil.custom(index, "该场考试报名区域报名人数已满", index);
		} else if (index == -6) {
			result = ResultUtil.custom(index, "请在报名时间范围内报名", index);
		} else if (index == -7) {
			result = ResultUtil.custom(index, "该场考试报名区域已下架", index);
		} else if (index == -8) {
			result = ResultUtil.custom(index, "已报名该场考试报名区域", index);
		} else {
			result = ResultUtil.custom(0, "报名失败", 0);
		}
		return result;
	}

	/**
	 * 审核用户考试报名
	 * 
	 * @author maguoliang
	 * @param signupUserIds 考试报名用户id
	 * @param status        审核状态1.通过2.拒绝
	 * @param remarks       驳回原因
	 * @return
	 */
	@RequestMapping("manage/audit")
	public Result auditFcExamSignupUser(String signupUserIds, Integer status, String remarks) {
		try {
			examSignupUserService.auditFcExamSignupUser(signupUserIds, status, remarks);
			return ResultUtil.ok(1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(0);
		}
	}

	/**
	 * 查询前台管理端用户的已报名审核个数
	 * 
	 * @param roleId   角色id
	 * @param roleType 角色类型1.家长2.从业者
	 * @return
	 */
	@RequestMapping("index/audit/count")
	public Result selectUserFcExamSignupCount(Integer roleId, Integer roleType) {
		int index = examSignupUserService.selectUserFcExamSignupCount(roleId, roleType);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 查询前台管理端用户的已报名审核列表
	 * 
	 * @param roleId     角色id
	 * @param roleType   角色类型1.家长2.从业者
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	@RequestMapping("index/audit/list")
	public Result selectUserFcExamSignupList(Integer roleId, Integer roleType, Integer pageNumber, Integer pageSize) {
		List<FcExamSignupUserListIndexVo> list = examSignupUserService.selectUserFcExamSignupList(roleId, roleType,
				pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}

	/**
	 * 查询考试报名用户信息
	 * 
	 * @param signupUserId 考试报名用户id
	 * @return
	 */
	@RequestMapping("index/audit/detail")
	public Result selectIndexFcExamSignupUserDetail(Integer signupUserId) {
		FcExamSignupUserDetailVo data = examSignupUserService.selectFcExamSignupUserDetail(signupUserId);
		if (data != null) {
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error(data);
		}
	}

	/**
	 * 根据多个考试报名区域id和考试报名id查询
	 * 
	 * @param signupId      考试报名id
	 * @param signupAreaIds 考试报名区域id集合
	 * @return
	 */
	@RequestMapping("area/manage/count")
	public Result selectBySignupIdAndSignupIdCount(Integer signupId, String signupAreaIds) {
		int index = examSignupUserService.selectBySignupIdAndSignupIdCount(signupId, signupAreaIds);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 根据多个考试报名区域id和考试报名id查询
	 * 
	 * @param signupId      考试报名id
	 * @param signupAreaIds 考试报名区域id集合
	 * @param pageNumber    第几页
	 * @param pageSize      每页查询多少条
	 * @return
	 */
	@RequestMapping("area/manage/list")
	public Result selectBySignupIdAndSignupIdList(Integer signupId, String signupAreaIds, Integer pageNumber,
			Integer pageSize) {
		List<FcExamSignupDetailAreaListVo> list = examSignupUserService.selectBySignupIdAndSignupIdList(signupId,
				signupAreaIds, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}

	/**
	 * 身份证号和手机号查询用户考试信息 用户登录
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @param examId
	 * @return
	 */
	@RequestMapping("query/user/detail")
	public Result queryCertificateNumberAndTellPhone(String certificateNumber, String tellPhone,Integer examId) {
		FcExamSignupUserVo vo = examSignupUserService.findCertificateNumberAndTellPhone(certificateNumber, tellPhone,examId);
		if (vo != null) {
			return ResultUtil.ok(vo);
		} else {
			return ResultUtil.error(vo);
		}
	}

	/**
	 * 查询用户的所有考试信息
	 * 
	 * @param certificateNumber
	 * @param tellPhone
	 * @return
	 */
	@RequestMapping("query/user/exams")
	public Result queryUserExams(String certificateNumber, String tellPhone) {
		List<FcExamToUserVo> list = examSignupUserService.findUserExams(certificateNumber, tellPhone);
		if (list != null && list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}

	/**
	 * 用户的头像，手机号，用户名信息
	 * 
	 * @param certificateNumber 身份证号
	 * @param tellPhone         手机号
	 * @param signupId          考试报名id
	 * @param signupAreaId      考试报名区域id
	 * @return
	 */
	@RequestMapping("query/user/info")
	public Result queryUserInfo(String certificateNumber, String tellPhone, Integer signupId, Integer signupAreaId) {
		ExamUserVo vo = examSignupUserService.findUserInfo(certificateNumber, tellPhone, signupId, signupAreaId);
		if (vo != null) {
			return ResultUtil.ok(vo);
		} else {
			return ResultUtil.error(vo);
		}
	}

	/**
	 * 根据家长/从业者id查询信息
	 * 
	 * @param id 家长/从业者id
	 * @return
	 */
	@RequestMapping("index/prepare/info")
	public Result selectSignupUserInfoById(Integer id) {
		FcExamSignupUserPrepareVo data = examSignupUserService.selectSignupUserInfoById(id);
		if (data != null) {
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error(data);
		}
	}

	/**
	 * 人脸对比
	 * 
	 * @param request
	 * @param id
	 * @param imageUrl
	 * @return
	 */
	@RequestMapping("compareFace")
	public Result compareFace(HttpServletRequest request, HttpServletResponse response, Integer id, String imageUrl) {
//		response.setHeader("Access-Control-Allow-Origin", "*");
		return examSignupUserService.compareFace(request, id, imageUrl);
	}
}
