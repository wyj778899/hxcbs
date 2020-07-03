package chinaPress.fc.book.dao;

import chinaPress.fc.book.model.FcBookArchives;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcBookArchivesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcBookArchives record);

    int insertSelective(FcBookArchives record);

    FcBookArchives selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcBookArchives record);

    int updateByPrimaryKey(FcBookArchives record);
}