package chinaPress.exam.exam_option.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.exam_option.model.FcExamOption;
import chinaPress.exam.exam_option.vo.ExamStemOption;

@Mapper
@Repository
public interface FcExamOptionMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcExamOption record);

    FcExamOption selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcExamOption record);
    
    /**
     * 考试id,试卷id,试题id,用户id查询考生考试信息
     * @return
     */
    Integer selectExamUserInfo(@Param("examId")Integer examId,@Param("paperId")Integer paperId,@Param("stemId")Integer stemId,@Param("userId")Integer userId);
    
    /**
     * 通过考试id，用户id查询考生的考试信息
     * @param examId
     * @param paperId
     * @param userId
     * @return
     */
    List<ExamStemOption> selectExamStemOption(@Param("examId")Integer examId,@Param("userId")Integer userId);
    
    /**
     * 考试id和用户id查询考试分数信息
     * @param examId
     * @param userId
     * @return
     */
    Integer selectExamGrade(@Param("examId")Integer examId,@Param("userId")Integer userId);
}