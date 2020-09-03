package chinaPress.exam.exam_record.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam_record.model.FcExamRecord;

@Mapper
@Repository
public interface FcExamRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcExamRecord record);

    FcExamRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcExamRecord record);
    
   /**
    * 通过报名id，区域id，考试id，用户id查询考生的考试信息
    * @param signupId
    * @param areaId
    * @param examId
    * @param userId
    * @return
    */
    FcExamRecord selectByUserExam(@Param("signupId")Integer signupId,@Param("areaId")Integer areaId,@Param("examId")Integer examId,@Param("userId")Integer userId);
}