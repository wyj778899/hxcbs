package chinaPress.role.praise.dao;

import chinaPress.role.praise.model.FcCommentPraise;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCommentPraiseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcCommentPraise record);

    int insertSelective(FcCommentPraise record);

    FcCommentPraise selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCommentPraise record);

    int updateByPrimaryKey(FcCommentPraise record);
}