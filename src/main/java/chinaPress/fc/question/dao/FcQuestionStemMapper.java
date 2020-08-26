package chinaPress.fc.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.question.model.FcQuestionStem;
import chinaPress.fc.question.vo.FcQuestionAndOption;
import chinaPress.fc.question.vo.FcQuestionInfo;
import chinaPress.fc.question.vo.FcQuestionStemListVo;
import chinaPress.fc.question.vo.QuestionNameVo;
import chinaPress.fc.question.vo.QuestionVo;

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
	
	/**
	 * 试题名称不可重复,查询试题名称
	 * @param questionStem
	 * @return
	 */
	int selectByQuestionStem(@Param("questionStem") String questionStem,@Param("id")Integer id);
	
	/**
	 * 通过id查询试题信息和试题关联的答案信息
	 * @param id
	 * @return
	 */
	FcQuestionAndOption selectById(@Param("id")Integer id);
	
	/**
	 * 查询所有试题的名称
	 * @return
	 */
	List<String> selectQuestionStemNameAll();
	
	
	/**
	 * 通过试题名称,试题难度,试题分类查询试题信息,用于展示管理端试题查询信息
	 * @param questionStem
	 * @param taskDifficulty
	 * @param catalogId
	 * @param type
	 * @return
	 */
	List<FcQuestionInfo> selectByCatalogIdAll(@Param("questionStem") String questionStem, @Param("taskDifficulty") Integer taskDifficulty,@Param("catalogId")Integer catalogId,@Param("type")Integer type,@Param("page")Integer page,@Param("limit")Integer limit);
	
	
	/**
	 * 通过试题名称,试题难度,试题分类查询试题信息,用于展示管理端试题查询信息个数
	 * @param questionStem
	 * @param taskDifficulty
	 * @param catalogId
	 * @param type
	 * @return
	 */
	int selectByCatalogIdCount(@Param("questionStem") String questionStem, @Param("taskDifficulty") Integer taskDifficulty,@Param("catalogId")Integer catalogId,@Param("type")Integer type);

	/**
	 * 查询所有试题信息        关联试题分类,试题答案 
	 * @return
	 */
	List<QuestionVo> selectQuestionAll();
	
	
	/**
	 * 查询试题的名称信息
	 * @param catalogId            试题分类id
	 * @param questionType         试题类型 
	 * @param taskDifficulty       试题难度     
	 * @return
	 */
	QuestionNameVo selectQuestionNameInfo(@Param("catalogId") Integer catalogId,@Param("questionType")Integer questionType,@Param("taskDifficulty") Integer taskDifficulty);
}