package chinaPress.fc.course.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course.vo.CourseArchivesNewVo;
import chinaPress.fc.course.vo.CourseArchivesParam;
import chinaPress.fc.course.vo.CourseArchivesVo;
import chinaPress.fc.course.vo.CourseIndexVo;
import chinaPress.fc.course.vo.CourseTutorVo;
import chinaPress.fc.course.vo.PageIndexCourseVo;

@Mapper
@Repository
public interface FcCourseArchivesMapper {

	/**
	 * 根据分类id查询关联课程
	 * 
	 * @param categoryId
	 * @return
	 */
	List<CourseArchivesNewVo> selectCourseByCategoryId(Integer categoryId);

	/**
	 * 查询课程详情
	 * 
	 * @param id
	 * @return
	 */
	CourseArchivesNewVo selectCourseArchivesById(Integer id);

	/**
	 * 查询首页随机5条课程
	 * 
	 * @return
	 */
	List<PageIndexCourseVo> selectPageIndexCourse();

	/**
	 * 查询课程列表
	 * 
	 * @param record 表头查询条件
	 * @param offset 从哪一条数据开始查询
	 * @param rows   查询多少条数据
	 * @return
	 */
	List<CourseArchivesVo> selectCourseArchivesList(@Param("record") CourseArchivesParam record,
			@Param("offset") Integer offset, @Param("rows") Integer rows);

	/**
	 * 查询课程数量
	 * 
	 * @param record 表头查询条件
	 * @return
	 */
	int selectCourseArchivesCount(@Param("record") CourseArchivesParam record);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcCourseArchives record);

	FcCourseArchives selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcCourseArchives record);

	/**
	 * 首页课程的详情
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	CourseIndexVo selectIndexCourseDetail(Integer id);

	/**
	 * 查询课程相关联的导师
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @return
	 */
	List<CourseTutorVo> selectCourseAboutTutor(Integer courseId);
	
	/**
	 * 查询所有上架的课程个数
	 * @author maguoliang
	 * @return
	 */
	int selectPutAwayCourseCount();
}