package chinaPress.exam.exam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam.service.FcExamService;
import chinaPress.exam.exam.vo.FcExamManageDetailVo;

@RestController
@RequestMapping("exam")
public class FcExamController {
	@Autowired
	private FcExamService fcExamService;

	/**
	 * 添加考试设置
	 * 
	 * @param fcExam
	 * @param signupUsers
	 */
	@RequestMapping("manage/add")
	public Result addFcExam(FcExam fcExam, String signupUsers) {
		try {
			fcExamService.addFcExam(fcExam, signupUsers);
			return ResultUtil.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}

	/**
	 * 修改考试设置
	 * 
	 * @param fcExam
	 * @param signupUsers
	 * @return
	 */
	@RequestMapping("manage/update")
	public Result updateExam(FcExam fcExam, String signupUsers) {
		try {
			fcExamService.updateExam(fcExam, signupUsers);
			return ResultUtil.ok();
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error();
		}
	}

	/**
	 * 查询考试详情
	 * 
	 * @param id 考试id
	 */
	@RequestMapping("manage/detail")
	public Result selectFcExamDetail(Integer id) {
		FcExamManageDetailVo data = fcExamService.selectFcExamDetail(id);
		if (data != null) {
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error(data);
		}
	}
}
