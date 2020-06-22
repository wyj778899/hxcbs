package chinaPress.fc.course.dao;

import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCourseArchivesMapper {
	
	/**
	 * 查询课程列表
	 * @param record
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<CourseArchivesVo> selectCOurseArchivesList(CourseArchivesParam record,@Param("pageNumber")Integer pageNumber,
			@Param("pageSize")Integer pageSize);
	
	/**
	 * 查询课程数量
	 * @param record
	 * @return
	 */
	int selectCourseArchivesCount(CourseArchivesParam record);
	
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCourseArchives record);

    FcCourseArchives selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCourseArchives record);
}