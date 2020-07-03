package chinaPress.fc.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.book.model.FcCourseBook;
import chinaPress.fc.book.vo.FcCourseBookVo;

@Mapper
@Repository
public interface FcCourseBookMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(FcCourseBook record);

	int insertSelective(FcCourseBook record);

	FcCourseBook selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcCourseBook record);

	int updateByPrimaryKey(FcCourseBook record);

	/**
	 * 查询课程相关的推荐数据
	 * 
	 * @author maguoliang
	 * @param courseId 课程id
	 * @return
	 */
	List<FcCourseBookVo> selectFcCourseAboutBook(Integer courseId);
}