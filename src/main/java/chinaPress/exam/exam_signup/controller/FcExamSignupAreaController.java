package chinaPress.exam.exam_signup.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam_signup.service.FcExamSignupAreaService;
import chinaPress.exam.exam_signup.vo.FcExamSignupAreaListVo;

@RestController
@RequestMapping("exam_signup_area")
public class FcExamSignupAreaController {
	@Autowired
	private FcExamSignupAreaService fcExamSignupAreaService;

	/**
	 * 下架考试报名区域
	 * 
	 * @author maguoliang
	 * @param areaId 考试报名区域id
	 * @return
	 */
	@RequestMapping("manage/offShelf")
	public Result onShelf(Integer areaId) {
		int index = fcExamSignupAreaService.onShelf(areaId);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 根据考试报名id查询该考试报名下的区域时间
	 * 
	 * @param signupId
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectBySignupIdCount(Integer signupId) {
		int index = fcExamSignupAreaService.selectBySignupIdCount(signupId);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 根据考试报名id查询该考试报名下的区域时间
	 * 
	 * @param signupId   考试报名id
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectBySignupIdList(Integer signupId, Integer pageNumber, Integer pageSize) {
		List<FcExamSignupAreaListVo> list = fcExamSignupAreaService.selectBySignupIdList(signupId, pageNumber,
				pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}
}
