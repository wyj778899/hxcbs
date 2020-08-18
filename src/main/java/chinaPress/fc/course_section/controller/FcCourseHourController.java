package chinaPress.fc.course_section.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course_section.service.FcCourseHourService;

@RestController
public class FcCourseHourController {

	@Autowired
	private FcCourseHourService fcCourseHourService;

	/**
	 * 根据章节id查询关联课时
	 * 
	 * @param sectionId
	 * @return
	 */
	@RequestMapping("selectCourseHourListBySectionId")
	public Result selectCourseHourListBySectionId(Integer personId, Integer courseId, Integer sectionId,
			Integer roleType, Integer type) {
		return fcCourseHourService.selectCourseHourListBySectionId(personId, courseId, sectionId, roleType, type);

	}

	/**
	 * 根据课程id查询视频数量
	 * 
	 * @param sectionId
	 * @return
	 */
	@RequestMapping("selectCourseHourCountByCOurseId")
	public Result selectCourseHourCountByCOurseId(Integer courseId) {
		int count = fcCourseHourService.selectCourseHourCountByCOurseId(courseId);
		if (count > 0) {
			return ResultUtil.custom(1, "查询成功", count);
		}
		return ResultUtil.custom(-1, "查询失败", count);
	}

	/**
	 * 查询课时id和章节名称
	 * @return
	 */
	@RequestMapping("querySectionAndHourAll")
	public Result querySectionAndHourAll() {
		return fcCourseHourService.findSectionAndHourAll();
	} 
}
