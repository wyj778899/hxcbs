package chinaPress.fc.question.dao;

import chinaPress.fc.question.model.FcQuestionStem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcQuestionStemMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcQuestionStem record);

    FcQuestionStem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcQuestionStem record);
}