package chinaPress.fc.course_section.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course_section.service.FcCourseHourService;
import chinaPress.fc.course_section.vo.FcCourseHourVo;

@RestController
public class FcCourseHourController {
	
	@Autowired
	private FcCourseHourService fcCourseHourService;
	
	/**
	 *  根据章节id查询关联课时
	 * @param sectionId
	 * @return
	 */
	@RequestMapping("selectCourseHourListBySectionId")
	public Result selectCourseHourListBySectionId(Integer sectionId){
		List<FcCourseHourVo> data = fcCourseHourService.selectCourseHourListBySectionId(sectionId);
		if(data.size()>0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}
	
	/**
	 * 根据课程id查询视频数量
	 * @param sectionId
	 * @return
	 */
	@RequestMapping("selectCourseHourCountByCOurseId")
	public Result selectCourseHourCountByCOurseId(Integer courseId){
		int count = fcCourseHourService.selectCourseHourCountByCOurseId(courseId);
		if(count>0) {
			return ResultUtil.custom(1, "查询成功", count);
		}
		return ResultUtil.custom(-1, "查询失败", count);
	}

}
