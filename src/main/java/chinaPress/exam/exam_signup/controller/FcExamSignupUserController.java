package chinaPress.exam.exam_signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam_signup.model.FcExamSignupUser;
import chinaPress.exam.exam_signup.service.FcExamSignupUserService;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupUserListVo;

@RestController
@RequestMapping("exam_signup_user")
public class FcExamSignupUserController {
	@Autowired
	private FcExamSignupUserService examSignupUserService;

	/**
	 * 查询考试报名的人员信息
	 * 
	 * @author maguoliang
	 * @param signupAreaId      考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       是否允许补考(1允许,0不允许)
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectExamSignupUserCount(Integer signupAreaId, String userName, String tellPhone,
			String certificateNumber, Integer examineType) {
		int index = examSignupUserService.selectExamSignupUserCount(signupAreaId, userName, tellPhone,
				certificateNumber, examineType);
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
	 * @param signupAreaId      考试报名区域时间id
	 * @param userName          姓名
	 * @param tellPhone         手机号
	 * @param certificateNumber 身份证号
	 * @param examineType       是否允许补考(1允许,0不允许)
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectExamSignupUserList(Integer signupAreaId, String userName, String tellPhone,
			String certificateNumber, Integer examineType, Integer pageNumber, Integer pageSize) {
		List<FcExamSignupUserListVo> list = examSignupUserService.selectExamSignupUserList(signupAreaId, userName,
				tellPhone, certificateNumber, examineType, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
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
		} else {
			result = ResultUtil.custom(0, "报名失败", 0);
		}
		return result;
	}

	/**
	 * 审核用户考试报名
	 * 
	 * @author maguoliang
	 * @param signupUserId 考试报名用户id
	 * @param status       审核状态1.通过2.拒绝
	 * @param remarks      驳回原因
	 * @return
	 */
	@RequestMapping("manage/audit")
	public Result auditFcExamSignupUser(Integer signupUserId, Integer status, String remarks) {
		int index = examSignupUserService.auditFcExamSignupUser(signupUserId, status, remarks);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
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
	public Result selectFcExamSignupUserDetail(Integer signupUserId) {
		FcExamSignupUserDetailVo data = examSignupUserService.selectFcExamSignupUserDetail(signupUserId);
		if (data != null) {
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error(data);
		}
	}
}
