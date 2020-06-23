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

    int insertSelective(FcQuestionOption record);

    List<FcQuestionOptionVo> selectByStemId(Integer id);

    int updateByPrimaryKeySelective(FcQuestionOption record);
}