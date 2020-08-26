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

    int updateByPrimaryKey(FcPaperStem record);
    
    
    int deleteByPaperId(@Param("paperId")Integer paperId);
}