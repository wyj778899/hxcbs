package chinaPress.fc.book_content.dao;

import chinaPress.fc.book_content.model.FcBookContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcBookContentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcBookContent record);

    int insertSelective(FcBookContent record);

    FcBookContent selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcBookContent record);

    int updateByPrimaryKey(FcBookContent record);
    
    /**
     * 删除书籍内容
     * @param bookId
     * @return
     */
    int deleteByBookId(@Param("bookId")Integer bookId);
}