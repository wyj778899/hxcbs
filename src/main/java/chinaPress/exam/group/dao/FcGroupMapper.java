package chinaPress.exam.group.dao;

import chinaPress.exam.group.model.FcGroup;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcGroup record);

    int insertSelective(FcGroup record);

    FcGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcGroup record);

    int updateByPrimaryKey(FcGroup record);
}