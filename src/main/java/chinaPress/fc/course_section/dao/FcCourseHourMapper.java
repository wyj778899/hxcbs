package chinaPress.fc.course_section.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.course_section.model.FcCourseHour;
import chinaPress.fc.course_section.vo.FcCourseHourVo;

@Mapper
@Repository
public interface FcCourseHourMapper {

	/**
	 * 根据课程id查询第一个视频的id
	 * 
	 * @param courseId
	 * @return
	 */
	Integer selectCourseHourIdBysectionId(Integer courseId);

	/**
	 * 根据课程id和课时id查询下一个课时id
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @param hourId   当前课时id
	 * @return
	 */
	int selectCourseNextHourIdBysectionId(@Param("courseId") Integer courseId, @Param("hourId") Integer hourId);

	/**
	 * 根据章节id查询关联课时
	 * 
	 * @param sectionId
	 * @return
	 */
	List<FcCourseHourVo> selectCourseHourListBySectionId(Integer sectionId);

	/**
	 * 根据课程id查询视频数量
	 * 
	 * @param courseId
	 * @return
	 */
	int selectCourseHourCountByCOurseId(Integer courseId);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcCourseHour record);

	FcCourseHour selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcCourseHour record);
}