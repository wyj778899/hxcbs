package chinaPress.exam.paper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.paper.model.FcPaper;
import chinaPress.exam.paper.vo.PaperQuestionStem;
import chinaPress.exam.paper.vo.PaperStemVo;

@Mapper
@Repository
public interface FcPaperMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcPaper record);

    FcPaper selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcPaper record);
    
    /**
     * 试卷名称判断唯一
     * @return
     */
    int selectByPaperName(@Param("paperId")Integer paperId,@Param("paperName")String paperName);
    
    /**
     * 试卷id 查询试卷信息,试卷-试题-试题分类型-试题答案
     * @param id
     * @return
     */
    FcPaper selectByPaperId(@Param("id")Integer id);
    
    /**
     * 试卷id查询考试试卷关联表判断是否有试卷和试题关联
     * @param id
     * @return
     */
    int selectExamPaperId(@Param("id")Integer id);
    
    /**
     * 通过试卷名称搜索试卷信息
     * @return
     */
    List<PaperStemVo> selectPaperLikeName(@Param("paperName") String paperName,@Param("paperCatalog")Integer paperCatalog,@Param("page")Integer page,@Param("limit")Integer limit);
    
    /**
     * 通过试卷名称搜索试卷个数信息
     * @param paperName
     * @return
     */
    int selectPaperLikeNameCount(@Param("paperName")String paperName,@Param("paperCatalog")Integer paperCatalog);
    
    
    /**
     * 查询考试信息    是否显示正确答案信息
     * @param examId
     * @param flag
     * @return
     */
    PaperQuestionStem selectExamById(@Param("examId")Integer examId,@Param("flag")Integer flag);
    
}