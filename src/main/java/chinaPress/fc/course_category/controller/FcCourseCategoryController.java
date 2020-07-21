package chinaPress.fc.course_category.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.tree.model.TreeNode;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.course_category.model.FcCourseCategory;
import chinaPress.fc.course_category.service.FcCourseCategoryService;
import chinaPress.fc.course_category.vo.CourseCategoryParam;
import chinaPress.fc.course_category.vo.PageIndexCategoryVo;

@RestController

public class FcCourseCategoryController {

	@Autowired
	private FcCourseCategoryService fcCourseCategoryService;

	/**
	 * 查询首页点击更多分类
	 * 
	 * @return
	 */
	@RequestMapping("selectPageIndexCategory")
	public Result selectPageIndexCategory() {
		List<PageIndexCategoryVo> data = fcCourseCategoryService.selectPageIndexCategory();
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 查询服务分类树
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("courseCategoryTree")
	public Result courseCategoryTree(CourseCategoryParam record) {
		List<TreeNode> data = fcCourseCategoryService.tree(record);
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 查询全部
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("selectCourseCategoryAll")
	public Result selectCourseCategoryAll(CourseCategoryParam record) {
		List<TreeNode> data = fcCourseCategoryService.selectCourseCategoryAll(record);
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 根据id查询详情
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("selectCourseCategory")
	public Result selectCourseCategory(Integer id) {
		FcCourseCategory data = fcCourseCategoryService.selectById(id);
		if (data != null) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 根据名字模糊查询
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("selectCourseCategoryByNames")
	public Result selectCourseCategoryByNames(String name) {
		List<TreeNode> data = fcCourseCategoryService.selectCourseCategoryByNames(name);
		if (data.size() > 0) {
			return ResultUtil.custom(1, "查询成功", data);
		}
		return ResultUtil.custom(-1, "查询失败", data);
	}

	/**
	 * 新增
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("inserCourseCategory")
	public Result inserCourseCategory(FcCourseCategory record) {
		int index = fcCourseCategoryService.inserCourseCategory(record);
		if (index > 0) {
			return ResultUtil.custom(1, "新增成功");
		} else if (index == -2) {
			return ResultUtil.custom(1, "该分类在同级中已存在，请重新添加");
		} else if (index == -3) {
			return ResultUtil.custom(1, "最多支持两级分类，请重新添加");
		}
		return ResultUtil.custom(1, "新增失败");
	}

	/**
	 * 编辑
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("updataCourseCategory")
	public Result updataCourseCategory(FcCourseCategory record) {
		int index = fcCourseCategoryService.updataCourseCategory(record);
		if (index > 0) {
			return ResultUtil.custom(1, "修改成功");
		} else if (index == -2) {
			return ResultUtil.custom(1, "该分类在同级中已存在，请重新输入");
		}
		return ResultUtil.custom(1, "修改失败");
	}
}
