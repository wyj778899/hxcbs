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
	 * @param isPutaway 上下架状态 1.上架0.下架
	 * @return
	 */
	@RequestMapping("manage/onOffShelf")
	public Result onShelf(Integer areaId, Integer isPutaway) {
		try {
			fcExamSignupAreaService.onOffShelf(areaId, isPutaway);
			return ResultUtil.ok(1);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.error(0);
		}
	}

	/**
	 * 根据考试报名id查询该考试报名下的区域时间
	 * 
	 * @param signupId  考试报名id
	 * @param province  区域-省
	 * @param city      区域-市
	 * @param district  区域-区
	 * @param startTime 考试开始时间
	 * @param endTime   考试结束时间
	 * @param isPutaway 是否上架1.上架0.下架
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectBySignupIdCount(Integer signupId, String province, String city, String district,
			String startTime, String endTime, Integer isPutaway) {
		int index = fcExamSignupAreaService.selectBySignupIdCount(signupId, province, city, district, startTime,
				endTime, isPutaway);
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
	 * @param province   区域-省
	 * @param city       区域-市
	 * @param district   区域-区
	 * @param startTime  考试开始时间
	 * @param endTime    考试结束时间
	 * @param isPutaway  是否上架1.上架0.下架
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectBySignupIdList(Integer signupId, String province, String city, String district,
			String startTime, String endTime, Integer isPutaway, Integer pageNumber, Integer pageSize) {
		List<FcExamSignupAreaListVo> list = fcExamSignupAreaService.selectBySignupIdList(signupId, province, city,
				district, startTime, endTime, isPutaway, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}
}
