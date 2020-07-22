package chinaPress.fc.book_catalog.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.book_catalog.model.FcBookCatalog;

@Mapper
@Repository
public interface FcBookCatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcBookCatalog record);

    int insertSelective(FcBookCatalog record);

    FcBookCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcBookCatalog record);

    int updateByPrimaryKey(FcBookCatalog record);
    
    /**
     * 删除书籍目录
     * @param bookId
     * @return
     */
    int deleteByBookId(@Param("bookId")Integer bookId);
}