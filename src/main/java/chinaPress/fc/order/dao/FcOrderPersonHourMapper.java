package chinaPress.fc.order.dao;

import chinaPress.fc.order.model.FcOrderPersonHour;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcOrderPersonHourMapper {

    int insertSelective(FcOrderPersonHour record);

    FcOrderPersonHour selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcOrderPersonHour record);

}