package chinaPress.exam.exam.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.exam.exam.service.FcExamAreaService;
import chinaPress.exam.exam.vo.FcExamManageAreaListVo;

@RestController
@RequestMapping("exam_area")
public class FcExamAreaController {
	@Autowired
	private FcExamAreaService fcExamAreaService;

	/**
	 * 查询考试设置下的考试区域
	 * 
	 * @param examId    考试id
	 * @param province  省
	 * @param city      市
	 * @param district  区
	 * @param startTime 开始时间
	 * @param endTime   结束时间
	 * @param status    考试状态1.未开始2.进行中3.已结束
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectFcExamAreaCount(Integer examId, String province, String city, String district, String startTime,
			String endTime, Integer status) {
		int index = fcExamAreaService.selectFcExamAreaCount(examId, province, city, district, startTime, endTime,
				status);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error(index);
		}
	}

	/**
	 * 查询考试设置下的考试区域
	 * 
	 * @param examId     考试id
	 * @param province   省
	 * @param city       市
	 * @param district   区
	 * @param startTime  开始时间
	 * @param endTime    结束时间
	 * @param status     考试状态1.未开始2.进行中3.已结束
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectFcExamAreaList(Integer examId, String province, String city,
			String district, String startTime, String endTime, Integer status, Integer pageNumber, Integer pageSize) {
		List<FcExamManageAreaListVo> list = fcExamAreaService.selectFcExamAreaList(examId, province, city, district,
				startTime, endTime, status, pageNumber, pageSize);
		if (list.size() > 0) {
			return ResultUtil.ok(list);
		} else {
			return ResultUtil.error(list);
		}
	}
}
