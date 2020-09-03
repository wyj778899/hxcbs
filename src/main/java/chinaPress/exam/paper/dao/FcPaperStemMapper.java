package chinaPress.exam.paper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.paper.model.FcPaperStem;

@Mapper
@Repository
public interface FcPaperStemMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcPaperStem record);

    FcPaperStem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcPaperStem record);

    /**
     * 通过试卷id删除试题信息
     * @param paperId
     * @return
     */
    int deleteByPaperId(@Param("paperId")Integer paperId);
    
    /**
     * 试题id 查询是否关联试卷
     * @param stemId
     * @return
     */
    int selectByQuestionId(@Param("stemId")Integer stemId);
    
    /**
     * 通过考试id查询考试的总分数
     * @param examId
     * @return
     */
    Integer selectExamGrade(@Param("examId")Integer examId);
}