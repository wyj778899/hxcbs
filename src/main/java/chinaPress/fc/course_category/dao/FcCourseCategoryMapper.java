package chinaPress.fc.course_category.dao;

import chinaPress.fc.course_category.model.FcCourseCategory;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseCategoryMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcCourseCategory record);

    int insertSelective(FcCourseCategory record);

    FcCourseCategory selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseCategory record);

    int updateByPrimaryKey(FcCourseCategory record);
}