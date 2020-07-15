package chinaPress.role.comment.dao;

import chinaPress.role.comment.model.FcCommentInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcCommentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcCommentInfo record);

    FcCommentInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcCommentInfo record);

}