package chinaPress.fc.question.dao;

import chinaPress.fc.question.model.FcQuestionOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcQuestionOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcQuestionOption record);

    int insertSelective(FcQuestionOption record);

    FcQuestionOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcQuestionOption record);

    int updateByPrimaryKey(FcQuestionOption record);
}