package chinaPress.fc.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.vo.CourseArchivesNewVo;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;
import chinaPress.fc.course.vo.PageIndexCourseVo;

@Mapper
@Repository
public interface FcCourseArchivesMapper {
	
	/**
	 * 根据分类id查询关联课程
	 * @param categoryId
	 * @return
	 */
	List<CourseArchivesNewVo> selectCourseByCategoryId(Integer categoryId);
	
	/**
	 *  查询课程详情
	 * @param id
	 * @return
	 */
	CourseArchivesNewVo selectCourseArchivesById(Integer id);
	
	/**
	 * 查询首页随机5条课程
	 * @return
	 */
	List<PageIndexCourseVo> selectPageIndexCourse();
	
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