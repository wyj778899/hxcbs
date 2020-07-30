package chinaPress.fc.course_category.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.tree.model.TreeNode;
import chinaPress.common.util.TreeUtil;
import chinaPress.fc.course_category.dao.FcCourseCategoryMapper;
import chinaPress.fc.course_category.model.FcCourseCategory;
import chinaPress.fc.course_category.vo.CourseCategoryParam;
import chinaPress.fc.course_category.vo.CourseCategoryVo;
import chinaPress.fc.course_category.vo.PageIndexCategoryVo;

@Service
public class FcCourseCategoryService {
	@Autowired
	private FcCourseCategoryMapper fcCourseCategoryMapper;

	/**
	 * 查询首页点击更多分类
	 * 
	 * @return
	 */
	public List<PageIndexCategoryVo> selectPageIndexCategory() {
		return fcCourseCategoryMapper.selectPageIndexCategory();
	}

	/**
	 * 查询全部
	 * 
	 * @param courseCategoryParam
	 * @return
	 */
	public List<TreeNode> selectCourseCategoryAll(CourseCategoryParam courseCategoryParam) {
		List<TreeNode> list = fcCourseCategoryMapper.selectCourseCategoryAll(courseCategoryParam);
		return TreeUtil.buildByRecursive(list);
	}

	/**
	 * 根据id查询详情
	 * 
	 * @param id
	 * @return
	 */
	public FcCourseCategory selectById(Integer id) {
		return fcCourseCategoryMapper.selectById(id);
	}

	/**
	 * 新增
	 * 
	 * @param record
	 * @return
	 */
	@Transactional
	public int inserCourseCategory(FcCourseCategory record) {
		// 查询名称是否重复
		FcCourseCategory nameCount = fcCourseCategoryMapper.selectCourseCategoryByName(record.getName(),
				record.getPid());
		if (nameCount != null) {
			return -1;
		}
		// 编码初始值
		String initialCode = "01";
		// 查询添加是否为第一级
		if (record.getPid() == 0 || record.getPid() == null) {
			record.setLevel(1);
			// 查询有没有同级
			List<FcCourseCategory> list = fcCourseCategoryMapper.selectByPid(record.getPid());
			if (list.size() > 0) {
				// 获取最后一个
				FcCourseCategory model = list.get(list.size() - 1);
				String code = String.valueOf(Integer.parseInt(model.getCode()) + 1);
				if (code.length() == 1) {
					code = "0" + code;
				}
				record.setCode(code);
			} else {
				record.setCode(initialCode);
			}
		} else {
			FcCourseCategory parentFcCourseCategory = fcCourseCategoryMapper.selectById(record.getPid());
			if (parentFcCourseCategory.getCode().length() == 4) {
				return -2;
			}
			record.setLevel(parentFcCourseCategory.getLevel() + 1);
			// 查询有没有同级
			List<FcCourseCategory> list = fcCourseCategoryMapper.selectByPid(record.getPid());
			if (list.size() > 0) {
				// 获取最后一个
				FcCourseCategory model = list.get(list.size() - 1);
				String code = model.getCode();
				String prefix = code.substring(0, code.length() - 3);
				String suffix = code.substring(code.length() - 3, code.length());
				code = String.valueOf(Integer.parseInt(suffix) + 1);
				if (code.length() == 1) {
					code = "0" + code;
				}
				record.setCode(prefix + code);
			} else {
				record.setCode(parentFcCourseCategory.getCode() + initialCode);
			}
			parentFcCourseCategory.setIsLast(0);
			fcCourseCategoryMapper.updateByPrimaryKeySelective(parentFcCourseCategory);
		}
		return fcCourseCategoryMapper.insertSelective(record);
	}

	/**
	 * 修改服务分类
	 * 
	 * @param record
	 * @return
	 */
	public int updataCourseCategory(FcCourseCategory record) {
		// 查询名称是否重复
		FcCourseCategory fcCourseCategory = fcCourseCategoryMapper.selectById(record.getId());
		FcCourseCategory nameCount = fcCourseCategoryMapper.selectCourseCategoryByName(record.getName(),
				fcCourseCategory.getPid());
		if (nameCount != null) {
			if (nameCount.getId().intValue() == record.getId().intValue()) {
				return -1;
			}
		}
		return fcCourseCategoryMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 查询详情
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	public CourseCategoryVo selectFcCourseCategoryDetail(Integer id) {
		return fcCourseCategoryMapper.selectFcCourseCategoryDetail(id);
	}
	
	/**
	 * 根据code查询
	 * 
	 * @author maguoliang
	 * @param code
	 * @return
	 */
	public List<CourseCategoryVo> selectFcCourseCategoryByCode(String code) {
		return fcCourseCategoryMapper.selectFcCourseCategoryByCode(code);
	}
}
