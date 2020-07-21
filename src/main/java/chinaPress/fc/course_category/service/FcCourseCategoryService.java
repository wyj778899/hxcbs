package chinaPress.fc.course_category.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.common.tree.model.TreeNode;
import chinaPress.common.util.TreeUtil;
import chinaPress.fc.course_category.dao.FcCourseCategoryMapper;
import chinaPress.fc.course_category.model.FcCourseCategory;
import chinaPress.fc.course_category.vo.CourseCategoryParam;
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
	 * 查询服务分类树
	 * 
	 * @param record
	 * @return
	 */
	public List<TreeNode> tree(CourseCategoryParam record) {
		List<TreeNode> data = new ArrayList<>();
		if (record.getName() != null && !record.getName().equals("")) {
			List<String> codeList = fcCourseCategoryMapper.selectCourseCategoryByNames(record.getName());
			record.setCodeList(codeList);
			if (record.getCheckedCode() != null && !record.getCheckedCode().equals("")) {
				if (record.getCodeList().size() == 0) {
					return data;
				}
			}
		}
		List<TreeNode> data2 = fcCourseCategoryMapper.selectCourseCategoryAll(record);
		if (data2.size() > 0) {
			data.addAll(data2);
		}
		return TreeUtil.buildByRecursive(data2);
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
	 * 根据名字模糊查询
	 * 
	 * @param name
	 * @return
	 */
	public List<TreeNode> selectCourseCategoryByNames(String name) {
		List<String> codeList = fcCourseCategoryMapper.selectCourseCategoryByNames(name);
		List<TreeNode> lists = new ArrayList<TreeNode>();
		if (codeList.size() > 0) {
			CourseCategoryParam model = new CourseCategoryParam();
			model.setCodeList(codeList);
			List<TreeNode> list = fcCourseCategoryMapper.selectCourseCategoryAll(model);
			return TreeUtil.buildByRecursive(list);
		} else {
			return lists;
		}
	}

	/**
	 * 新增
	 * 
	 * @param record
	 * @return
	 */
	public int inserCourseCategory(FcCourseCategory record) {
		Integer nameCount = fcCourseCategoryMapper.selectCourseCategoryByName(record.getName());
		if (nameCount > 0) {
			return -2;
		}
		// 固定编码长度
		int codeLength = 2;
		// 编码初始值
		String initialCode = "01";
		String parentCode = record.getCode();
		if (parentCode.length() / codeLength >= 2) {
			return -3;
		}
		if (record.getPid() == 0) {
			List<FcCourseCategory> list = fcCourseCategoryMapper.selectByPid(record.getPid());
			if (list.size() > 0) {
				FcCourseCategory model = list.get(list.size() - 1);
				String code = String.valueOf(Integer.parseInt(model.getCode()) + 1);
				for (int i = code.length(); i < codeLength; i++) {
					code = "0" + code;
				}
				record.setCode(code);
			} else {
				record.setCode(initialCode);
			}
		} else {
			List<FcCourseCategory> list = fcCourseCategoryMapper.selectByPid(record.getPid());
			if (list.size() > 0) {
				FcCourseCategory model = list.get(list.size() - 1);
				String code = model.getCode();
				String prefix = code.substring(0, code.length() - 3);
				String suffix = code.substring(code.length() - 3, code.length());
				code = String.valueOf(Integer.parseInt(suffix) + 1);
				for (int i = code.length(); i < 3; i++) {
					code = "0" + code;
				}
				record.setCode(prefix + code);
			} else {
				record.setCode(parentCode + initialCode);
			}
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
		CourseCategoryParam model = new CourseCategoryParam();
		model.setNotId(record.getId());
		model.setpId(record.getPid());
		model.setName(record.getName());
		model.setCode(record.getCode());
		List<TreeNode> list = fcCourseCategoryMapper.selectCourseCategoryAll(model);
		if (list.size() > 0) {
			return -2;
		}
		return fcCourseCategoryMapper.updateByPrimaryKeySelective(record);
	}

}
