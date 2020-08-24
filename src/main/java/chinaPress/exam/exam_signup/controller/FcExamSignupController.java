package chinaPress.exam.exam_signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam_signup.model.FcExamSignup;
import chinaPress.exam.exam_signup.service.FcExamSignupService;
import chinaPress.exam.exam_signup.vo.FcExamSignupIndexDetailVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupIndexVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupListVo;
import chinaPress.exam.exam_signup.vo.FcExamSignupManageDetailVo;

@RestController
@RequestMapping("exam_signup")
public class FcExamSignupController {
	@Autowired
	private FcExamSignupService fcExamSignupService;

	/**
	 * 查询考试报名列表个数
	 * 
	 * @author maguoliang
	 * @param signupName 考试报名名称
	 * @param examForm   考试形式(1现场0非现场)
	 * @param isPutaway  是否上架1.上架0.下架
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectExamSignupCount(String signupName, Integer examForm, Integer isPutaway) {
		int count = fcExamSignupService.selectExamSignupCount(signupName, examForm, isPutaway);
		if (count > 0) {
			return ResultUtil.ok(count);
		} else {
			return ResultUtil.error(count);
		}
	}

	/**
	 * 查询考试报名列表个数
	 * 
	 * @author maguoliang
	 * @param signupName 考试报名名称
	 * @param examForm   考试形式(1现场0非现场)
	 * @param isPutaway  是否上架1.上架0.下架
	 * @param pageNumber 第几页
	 * @param pageSize   查询多少条数据
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectExamSignupList(String signupName, Integer examForm, Integer isPutaway, Integer pageNumber,
			Integer pageSize) {
		List<FcExamSignupListVo> list = fcExamSignupService.selectExamSignupList(signupName, examForm, isPutaway,
				pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}

	/**
	 * 添加考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignup 考试报名信息
	 * @param areas        考试报名关联的区域json字符串
	 */
	@RequestMapping("manage/add")
	public Result insertExamSignup(FcExamSignup fcExamSignup, String areas) {
		try {
			fcExamSignupService.insertExamSignup(fcExamSignup, areas);
			return ResultUtil.custom(1, "操作成功", 1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}

	/**
	 * 修改考试报名
	 * 
	 * @author maguoliang
	 * @param fcExamSignup 考试报名信息
	 * @param areas        考试报名关联的区域json字符串
	 */
	@RequestMapping("manage/update")
	public Result updateExamSignup(FcExamSignup fcExamSignup, String areas) {
		try {
			fcExamSignupService.updateExamSignup(fcExamSignup, areas);
			return ResultUtil.custom(1, "操作成功", 1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "操作失败", 0);
		}
	}

	/**
	 * 查询已上架的考试报名详情
	 * 
	 * @author maguoliang
	 * @param signupId
	 * @return
	 */
	@RequestMapping("manage/detail")
	public Result selectExamSignupDetail(Integer signupId) {
		FcExamSignupManageDetailVo data = fcExamSignupService.selectExamSignupDetail(signupId);
		if (data != null) {
			return ResultUtil.custom(1, "有数据", data);
		} else {
			return ResultUtil.custom(0, "无数据", data);
		}
	}

	/**
	 * 查询已上架的考试报名列表
	 * 
	 * @author maguoliang
	 * @return
	 */
	@RequestMapping("index/list")
	public Result selectPutawayExamSignupList() {
		List<FcExamSignupIndexVo> list = fcExamSignupService.selectPutawayExamSignupList();
		if (list.size() > 0) {
			return ResultUtil.custom(1, "有数据", list);
		} else {
			return ResultUtil.custom(0, "无数据", list);
		}
	}

	/**
	 * 查询已上架的考试报名详情
	 * 
	 * @author maguoliang
	 * @param signupId
	 * @return
	 */
	@RequestMapping("index/detail")
	public Result selectPutawayExamSignupDetail(Integer signupId) {
		FcExamSignupIndexDetailVo data = fcExamSignupService.selectPutawayExamSignupDetail(signupId);
		if (data != null) {
			return ResultUtil.custom(1, "有数据", data);
		} else {
			return ResultUtil.custom(0, "无数据", data);
		}
	}
}
