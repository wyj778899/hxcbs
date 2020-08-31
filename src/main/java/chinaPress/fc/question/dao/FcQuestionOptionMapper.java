package chinaPress.fc.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.question.model.FcQuestionOption;
import chinaPress.fc.question.vo.FcQuestionOptionVo;

@Mapper
@Repository
public interface FcQuestionOptionMapper {
	int deleteByPrimaryKey(Integer id);

	/**
	 * 根据题干id删除选项
	 * 
	 * @param stemId
	 * @return
	 */
	int deleteByStemId(Integer stemId);

	int insertSelective(FcQuestionOption record);

	List<FcQuestionOptionVo> selectByStemId(Integer id);

	int updateByPrimaryKeySelective(FcQuestionOption record);

	/**
	 * 试题id删除试题答案信息
	 * 
	 * @param itemId
	 * @return
	 */
	int deleteItemId(Integer itemId);
}