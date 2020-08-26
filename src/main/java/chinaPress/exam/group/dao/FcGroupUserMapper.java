package chinaPress.exam.group.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.exam.group.model.FcGroupUser;

@Mapper
@Repository
public interface FcGroupUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcGroupUser record);

    FcGroupUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcGroupUser record);

    /**
     * 分组id删除分组关联用户的信息
     * @param groupId
     * @return
     */
    int deleteByGroupId(@Param("groupId")Integer groupId);
}