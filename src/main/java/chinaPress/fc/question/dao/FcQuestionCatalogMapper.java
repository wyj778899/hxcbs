package chinaPress.fc.question.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.question.model.FcQuestionCatalog;
import chinaPress.fc.question.vo.FcQuestionCatalogVo;

@Mapper
@Repository
public interface FcQuestionCatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcQuestionCatalog record);

    int insertSelective(FcQuestionCatalog record);

    FcQuestionCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcQuestionCatalog record);

    int updateByPrimaryKey(FcQuestionCatalog record);
    
    /**
     * 查询分类编号或者名称的个数  不可以重复校验
     * @param sort
     * @param name
     * @return
     */
    int selectBySortAndName(@Param("sort")Integer sort,@Param("name") String name,@Param("id") Integer id);
    
    /**
     * 查询所有
     * @return
     */
    List<FcQuestionCatalogVo> selectAll(@Param("name")String name,@Param("page")Integer page,@Param("limit")Integer limit);
    
    
    /**
     * 查询所有分类个数
     * @return
     */
    int selectAllCount(@Param("name")String name);
    
    
    /**
     * 根据分类id查询书籍信息
     * @return
     */
    int selectByCatalogId(@Param("id")Integer id);
}