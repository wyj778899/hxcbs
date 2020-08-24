package chinaPress.exam.exam.dao;

import chinaPress.exam.exam.model.FcExam;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcExamMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcExam record);

    int insertSelective(FcExam record);

    FcExam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcExam record);

    int updateByPrimaryKey(FcExam record);
}