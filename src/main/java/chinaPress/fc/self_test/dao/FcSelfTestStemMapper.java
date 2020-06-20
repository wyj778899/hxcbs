package chinaPress.fc.self_test.dao;

import chinaPress.fc.self_test.model.FcSelfTestStem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface FcSelfTestStemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FcSelfTestStem record);

    int insertSelective(FcSelfTestStem record);

    FcSelfTestStem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FcSelfTestStem record);

    int updateByPrimaryKey(FcSelfTestStem record);
}