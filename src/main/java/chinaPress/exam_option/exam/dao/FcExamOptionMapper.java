package chinaPress.exam_option.exam.dao;

import chinaPress.exam.exam_option.model.FcExamOption;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcExamOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcExamOption record);

    int insertSelective(FcExamOption record);

    FcExamOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcExamOption record);

    int updateByPrimaryKey(FcExamOption record);
}