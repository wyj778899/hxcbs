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
import chinaPress.fc.course_category.vo.CourseCategoryVo;
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
			return ResultUtil.custom(1, "有数据", data);
		}
		return ResultUtil.custom(0, "无数据", data);
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
			return ResultUtil.custom(1, "有数据", data);
		}
		return ResultUtil.custom(0, "无数据", data);
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
		} else if (index == -1) {
			return ResultUtil.custom(-1, "该分类名称在同级中已存在，请重新添加");
		} else if (index == -2) {
			return ResultUtil.custom(-2, "最多支持两级分类，请重新添加");
		}
		return ResultUtil.custom(0, "新增失败");
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
			return ResultUtil.custom(-1, "该分类名称在同级中已存在，请重新输入");
		}
		return ResultUtil.custom(0, "修改失败");
	}

	/**
	 * 查询详情
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	@RequestMapping("selectFcCourseCategoryDetail")
	public Result selectFcCourseCategoryDetail(Integer id) {
		CourseCategoryVo data = fcCourseCategoryService.selectFcCourseCategoryDetail(id);
		if (data != null) {
			return ResultUtil.custom(1, "有数据", data);
		}
		return ResultUtil.custom(0, "无数据", data);
	}

	/**
	 * 根据code查询
	 * 
	 * @author maguoliang
	 * @param code
	 * @return
	 */
	@RequestMapping("selectFcCourseCategoryByCode")
	public Result selectFcCourseCategoryByCode(String code) {
		List<CourseCategoryVo> list = fcCourseCategoryService.selectFcCourseCategoryByCode(code);
		if (list.size() > 0) {
			return ResultUtil.custom(1, "有数据", list);
		}
		return ResultUtil.custom(0, "无数据", list);
	}
}
