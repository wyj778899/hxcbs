package chinaPress.fc.apply.dao;

import chinaPress.fc.apply.model.FcApply;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcApplyMapper {

    int insertSelective(FcApply record);

    FcApply selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcApply record);

}