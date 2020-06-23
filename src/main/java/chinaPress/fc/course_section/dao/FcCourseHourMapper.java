package chinaPress.fc.course_section.dao;

import chinaPress.fc.course_section.model.FcCourseHour;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseHourMapper {
	
	/**
	 * 根据课程id查询视频数量
	 * @param courseId
	 * @return
	 */
	int selectCourseHourCountByCOurseId(Integer courseId);
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCourseHour record);

    FcCourseHour selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseHour record);
}