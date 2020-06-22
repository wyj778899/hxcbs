package chinaPress.fc.course_section.dao;

import chinaPress.fc.course_section.model.FcCourseSection;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseSectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCourseSection record);

    FcCourseSection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseSection record);
}