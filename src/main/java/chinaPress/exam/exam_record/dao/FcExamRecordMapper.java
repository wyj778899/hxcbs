package chinaPress.exam.exam_record.dao;

import chinaPress.exam.exam_record.model.FcExamRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcExamRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcExamRecord record);

    FcExamRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcExamRecord record);

}