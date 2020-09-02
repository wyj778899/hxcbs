package chinaPress.exam.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam.service.FcExamUserService;
import chinaPress.exam.exam.vo.FcExamManageAreaUserListVo;

@RestController
@RequestMapping("exam_user")
public class FcExamUserController {
	@Autowired
	private FcExamUserService fcExamUserService;

	/**
	 * 查询考试区域用户
	 * 
	 * @param signupAreaId      考试报名区域id
	 * @param name              名称
	 * @param phone             手机
	 * @param certificateNumber 身份证
	 * @param status            状态1.通过2.没通过
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectFcExamAreaUserCount(Integer signupAreaId, String name, String phone, String certificateNumber,
			Integer status) {
		int index = fcExamUserService.selectFcExamAreaUserCount(signupAreaId, name, phone, certificateNumber, status);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 查询考试区域用户
	 * 
	 * @param signupAreaId      考试报名区域id
	 * @param name              名称
	 * @param phone             手机
	 * @param certificateNumber 身份证
	 * @param status            状态1.通过2.没通过
	 * @param pageNumber        第几页
	 * @param pageSize          每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectFcExamAreaUserList(Integer signupAreaId, String name, String phone, String certificateNumber,
			Integer status, Integer pageNumber, Integer pageSize) {
		List<FcExamManageAreaUserListVo> list = fcExamUserService.selectFcExamAreaUserList(signupAreaId, name, phone,
				certificateNumber, status, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}
}
