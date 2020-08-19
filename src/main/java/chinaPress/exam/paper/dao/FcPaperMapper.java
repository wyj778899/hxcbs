package chinaPress.exam.paper.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.paper.model.FcPaper;

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

}