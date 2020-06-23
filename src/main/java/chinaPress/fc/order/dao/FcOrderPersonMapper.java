package chinaPress.fc.order.dao;

import chinaPress.fc.order.model.FcOrderPerson;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcOrderPersonMapper {
    int deleteByPrimaryKey(Integer id);

    int insertSelective(FcOrderPerson record);

    FcOrderPerson selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcOrderPerson record);

}