package chinaPress.fc.course_section.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.course_section.model.FcCourseSection;
import chinaPress.fc.course_section.vo.FcCourseSectionVo;
import chinaPress.fc.course_section.vo.FcSectionHourInfo;

@Mapper
@Repository
public interface FcCourseSectionMapper {
	
	/**
	 * 根据课程查看关联章节
	 * @param courseId
	 * @return
	 */
	List<FcCourseSectionVo> selectCourseSectionList(Integer courseId);
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCourseSection record);

    FcCourseSection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseSection record);
    
    /**
     * 查询所有课时id和对应的章节名称
     * @return
     */
    List<FcSectionHourInfo> selectSectionAndHourAll();
}