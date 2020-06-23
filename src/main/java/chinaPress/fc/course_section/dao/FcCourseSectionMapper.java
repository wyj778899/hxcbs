package chinaPress.fc.course_section.dao;

import chinaPress.common.tree.model.TreeNode;
import chinaPress.fc.course_section.model.FcCourseSection;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseSectionMapper {
	
	/**
	 * 根据课程查看关联章节
	 * @param courseId
	 * @return
	 */
	List<TreeNode> selectCourseSectionList(Integer courseId);
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCourseSection record);

    FcCourseSection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseSection record);
}