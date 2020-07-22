package chinaPress.fc.book.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.book.model.FcBookArchives;

@Mapper
@Repository
public interface FcBookArchivesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcBookArchives record);

    int insertSelective(FcBookArchives record);

    FcBookArchives selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcBookArchives record);

    int updateByPrimaryKey(FcBookArchives record);
    
    /**
     * id查询书籍信息，书籍信息包括书籍的内容和书籍的目录
     * @param id
     * @return
     */
    List<FcBookArchives> selectBookInfos(@Param("id")Integer id);
}