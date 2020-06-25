package chinaPress.role.member.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.role.member.model.UserInfo;

@Mapper
@Repository
public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserInfo record);

}