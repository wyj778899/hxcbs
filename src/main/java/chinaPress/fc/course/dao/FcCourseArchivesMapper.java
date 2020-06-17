package chinaPress.fc.course.dao;

import chinaPress.fc.course.model.FcCourseArchives;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseArchivesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcCourseArchives record);

    int insertSelective(FcCourseArchives record);

    FcCourseArchives selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseArchives record);

    int updateByPrimaryKey(FcCourseArchives record);
}