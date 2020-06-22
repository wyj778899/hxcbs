package chinaPress.fc.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.service.FcCourseArchivesService;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;

@RestController
public class FcCourseArchivesController {
	@Autowired
	private FcCourseArchivesService fcCourseArchivesService;
	
	/**
	 * 查询课程列表
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	@RequestMapping("selectCOurseArchivesList")
	public Result selectCOurseArchivesList(CourseArchivesParam record,Integer pageNumber,
			Integer pageSize) {
		List<CourseArchivesVo> data = fcCourseArchivesService.selectCOurseArchivesList(record, pageNumber, pageSize);
		if(data.size()>0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}
	
	/**
	 * 查询课程数量
	 * @param record
	 * @return
	 */
	@RequestMapping("selectCourseArchivesCount")
	public Result selectCourseArchivesCount(CourseArchivesParam record) {
		int count = fcCourseArchivesService.selectCourseArchivesCount(record);
		if(count>0) {
			return ResultUtil.custom(1, "查询成功", count);
		}
		return ResultUtil.custom(-1, "查询失败", count);
		
	}
	
	/**
	 * 新增课程
	 * @param record
	 * @param section
	 * @return
	 */
	@RequestMapping("insertCourseArchives")
	public Result insertCourseArchives(FcCourseArchives record,String section) {
		int index = fcCourseArchivesService.insertCourseArchives(record, section);
		if(index>0) {
			return ResultUtil.custom(1, "操作成功");
		}
		return ResultUtil.custom(-1, "操作失败");
	}
	
	/**
	 * 课程上下架
	 * @param record
	 * @return
	 */
	@RequestMapping("updateCourseArchivesStatus")
	public Result updateCourseArchivesStatus(FcCourseArchives record) {
		int index = fcCourseArchivesService.updateCourseArchivesStatus(record);
		if(index>0) {
			return ResultUtil.custom(1, "操作成功");
		}
		return ResultUtil.custom(-1, "操作失败");
	}

}
