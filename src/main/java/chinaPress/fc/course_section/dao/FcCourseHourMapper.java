package chinaPress.fc.course_section.dao;

import chinaPress.fc.course_section.model.FcCourseHour;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseHourMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCourseHour record);

    FcCourseHour selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseHour record);
}