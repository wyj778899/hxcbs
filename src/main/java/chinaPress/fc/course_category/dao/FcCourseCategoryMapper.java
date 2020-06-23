package chinaPress.fc.course_category.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.common.tree.model.TreeNode;
import chinaPress.fc.course_category.model.FcCourseCategory;
import chinaPress.fc.course_category.vo.CourseCategoryParam;
import chinaPress.fc.course_category.vo.PageIndexCategoryVo;

@Mapper
@Repository
public interface FcCourseCategoryMapper {
	
	/**
	 *  查询首页点击更多分类
	 * @return
	 */
	List<PageIndexCategoryVo> selectPageIndexCategory();
	
	/**
	 * 根据名称模糊查
	 * @param name
	 * @return
	 */
	List<String> selectCourseCategoryByNames(String name);
	
	/**
	 * 查询名称是否存在
	 * @param name
	 * @return
	 */
	Integer selectCourseCategoryByName(String name);
	
	/**
	 * 查询所有分类
	 * @param pid
	 * @param code
	 * @param name
	 * @return
	 */
	List<TreeNode> selectCourseCategoryAll(CourseCategoryParam courseCategoryParam);

	/**
	 * 根据id查询详情
	 * @param record
	 * @return
	 */
    FcCourseCategory selectById(Integer id);
	
	/**
	 * 根据父级id查询
	 * @param id
	 * @return
	 */
	List<FcCourseCategory> selectByPid(Integer id);
    
	/**
	 * 新增
	 * @param record
	 * @return
	 */
    int insertSelective(FcCourseCategory record);

    /**
     * 编辑
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(FcCourseCategory record);

}