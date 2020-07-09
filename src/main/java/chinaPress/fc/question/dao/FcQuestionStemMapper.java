package chinaPress.fc.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.question.model.FcQuestionStem;
import chinaPress.fc.question.vo.FcQuestionStemListVo;

@Mapper
@Repository
public interface FcQuestionStemMapper {

	/**
	 * 根据课程和课时查询关联的试题
	 * 
	 * @param courseId
	 * @param hourId
	 * @param pageNumber
	 * @param pageSize
	 * @return
	 */
	List<FcQuestionStemListVo> selectQuestionStemList(Integer courseId, Integer hourId, Integer type);

	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcQuestionStem record);

	FcQuestionStem selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcQuestionStem record);

	/**
	 * 查询该视频有没有小节题
	 * 
	 * @author maguoliang
	 * @param courseId  课程id
	 * @param sectionId 章节id
	 * @return
	 */
	List<FcQuestionStem> selectIsHaveStem(@Param("courseId") Integer courseId, @Param("sectionId") Integer sectionId);
}