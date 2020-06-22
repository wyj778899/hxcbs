package chinaPress.fc.self_test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.self_test.model.FcSelfTestStemOption;
import chinaPress.fc.self_test.vo.FcSelfTestStemOptionInsertParam;

@Mapper
@Repository
public interface FcSelfTestStemOptionMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcSelfTestStemOption record);

	FcSelfTestStemOption selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcSelfTestStemOption record);

	int updateByPrimaryKey(FcSelfTestStemOption record);

	/**
	 * 批量新增
	 * 
	 * @param testStemId
	 * @param list
	 * @return
	 */
	int batchInsert(@Param("testStemId") Integer testStemId, @Param("list") List<FcSelfTestStemOptionInsertParam> list);
	
}