package chinaPress.exam.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam.model.FcExam;
import chinaPress.exam.exam.service.FcExamService;
import chinaPress.exam.exam.vo.FcExamManageDetailVo;
import chinaPress.exam.exam.vo.FcExamManageListVo;

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
	 * @param signupAreas
	 */
	@RequestMapping("manage/add")
	public Result addFcExam(FcExam fcExam, String signupUsers, String signupAreas) {
		try {
			fcExamService.addFcExam(fcExam, signupUsers, signupAreas);
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
	 * @param signupAreas
	 * @return
	 */
	@RequestMapping("manage/update")
	public Result updateExam(FcExam fcExam, String signupUsers, String signupAreas) {
		Result result = new Result();
		try {
			int index = fcExamService.updateExam(fcExam, signupUsers, signupAreas);
			if (index > 0) {
				result = ResultUtil.ok();
			}
			if (index == -1) {
				result = ResultUtil.custom(index, "当前操作的考试设置不存在", index);
			}
			if (index == -2) {
				result = ResultUtil.custom(index, "当前操作的考试设置关联的报名信息不存在", index);
			}
			if (index == -3) {
				result = ResultUtil.custom(index, "当前操作的考试设置关联的考试报名区域时间不存在", index);
			}
			if (index == -4) {
				result = ResultUtil.custom(index, "当前操作的考试设置正在考试中，无法操作", index);
			}
			if (index == -5) {
				result = ResultUtil.custom(index, "当前操作的考试设置已关闭", index);
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = ResultUtil.error();
		}
		return result;
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

	/**
	 * 查询考试设置列表个数
	 * 
	 * @param name 考试名称
	 * @param type 考试类型
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectFcExamCount(String name, Integer type) {
		int index = fcExamService.selectFcExamCount(name, type);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 查询考试设置列表个数
	 * 
	 * @param name       考试名称
	 * @param type       考试类型
	 * @param pageNumber 查询第几页
	 * @param pageSize   查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectFcExamList(String name, Integer type, Integer pageNumber, Integer pageSize) {
		List<FcExamManageListVo> list = fcExamService.selectFcExamList(name, type, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}
}
