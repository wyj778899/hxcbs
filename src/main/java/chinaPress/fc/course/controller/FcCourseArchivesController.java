package chinaPress.fc.course.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.service.FcCourseArchivesService;
import chinaPress.fc.course.vo.CourseArchivesNewVo;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;
import chinaPress.fc.course.vo.PageIndexCourseVo;

@RestController
public class FcCourseArchivesController {
	@Autowired
	private FcCourseArchivesService fcCourseArchivesService;

	/**
	 * 根据分类id查询关联课程
	 * 
	 * @param categoryId 课程分类id
	 * @param roleId     角色id
	 * @param roleType   角色类型
	 * @return
	 */
	@RequestMapping("selectCourseByCategoryId")
	public Result selectCourseByCategoryId(Integer categoryId, Integer roleId, Integer roleType) {
		List<CourseArchivesNewVo> data = fcCourseArchivesService.selectCourseByCategoryId(categoryId, roleId, roleType);
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 查询课程详情
	 * 
	 * @author maguoliang
	 * @param id       课程id
	 * @param roleId   当前登录角色id
	 * @param roleType 当前登录角色类型
	 * @return
	 */
	@RequestMapping("selectCourseArchivesById")
	public Result selectCourseArchivesById(Integer id, Integer roleId, Integer roleType) {
		CourseArchivesNewVo data = fcCourseArchivesService.selectCourseArchivesById(id, roleId, roleType);
		if (data != null) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 查询首页随机5条课程
	 * 
	 * @return
	 */
	@RequestMapping("selectPageIndexCourse")
	public List<PageIndexCourseVo> selectPageIndexCourse() {
		return fcCourseArchivesService.selectPageIndexCourse();
	}

	/**
	 * 查询课程列表
	 * 
	 * @param record     表头查询条件
	 * @param pageNumber 第几页
	 * @param pageSize   每页查询多少条
	 * @return
	 */
	@RequestMapping("manage/courseList")
	public Result selectCourseArchivesList(CourseArchivesParam record, Integer pageNumber, Integer pageSize) {
		List<CourseArchivesVo> data = fcCourseArchivesService.selectCourseArchivesList(record, pageNumber, pageSize);
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 查询课程数量
	 * 
	 * @param record 表头查询条件
	 * @return
	 */
	@RequestMapping("manage/courseCount")
	public Result selectCourseArchivesCount(CourseArchivesParam record) {
		int count = fcCourseArchivesService.selectCourseArchivesCount(record);
		if (count > 0) {
			return ResultUtil.custom(1, "查询成功", count);
		}
		return ResultUtil.custom(-1, "查询失败", count);

	}

	/**
	 * 新增课程
	 * 
	 * @param record
	 * @param section
	 * @return
	 */
	@RequestMapping("insertCourseArchives")
	public Result insertCourseArchives(FcCourseArchives record, String section) {
		int index = fcCourseArchivesService.insertCourseArchives(record, section);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功");
		}
		return ResultUtil.custom(-1, "操作失败");
	}

	/**
	 * 课程上下架
	 * 
	 * @param id        课程id
	 * @param isPutaway 是否上下架
	 * @return
	 */
	@RequestMapping("manage/updateCoursePutWay")
	public Result updateCourseArchivesStatus(Integer id, Integer isPutaway) {
		int index = fcCourseArchivesService.updateCourseArchivesStatus(id, isPutaway);
		if (index > 0) {
			return ResultUtil.custom(1, "操作成功");
		}
		return ResultUtil.custom(-1, "操作失败");
	}

}
