package chinaPress.fc.self_test.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.self_test.model.FcSelfTest;
import chinaPress.fc.self_test.vo.FcSelfTestDetailVo;
import chinaPress.fc.self_test.vo.FcSelfTestListParam;
import chinaPress.fc.self_test.vo.FcSelfTestListVo;

@Mapper
@Repository
public interface FcSelfTestMapper {

	int insertSelective(FcSelfTest record);

	FcSelfTest selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcSelfTest record);

	/**
	 * 详情
	 * 
	 * @param id
	 * @return
	 */
	FcSelfTestDetailVo detail(Integer id);

	/**
	 * 数据数量
	 * 
	 * @param param
	 * @return
	 */
	int count(FcSelfTestListParam param);

	/**
	 * 数据集合
	 * 
	 * @param param
	 * @return
	 */
	List<FcSelfTestListVo> list(FcSelfTestListParam param);

}