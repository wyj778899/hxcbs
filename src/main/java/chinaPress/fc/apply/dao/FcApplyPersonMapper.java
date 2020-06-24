package chinaPress.fc.apply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.fc.apply.vo.TerminalApplyPersonListParam;
import chinaPress.fc.apply.vo.TerminalApplyPersonListVo;

@Mapper
@Repository
public interface FcApplyPersonMapper {
	int deleteByPrimaryKey(Integer id);

	int insertSelective(FcApplyPerson record);

	FcApplyPerson selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcApplyPerson record);

	List<FcApplyPerson> findByApplyId(Integer applyId);

	/**
	 * 终端 数据数量
	 * 
	 * @param param
	 * @return
	 */
	int findTerminalCount(TerminalApplyPersonListParam param);

	/**
	 * 终端 数据集合
	 * 
	 * @param param
	 * @return
	 */
	List<TerminalApplyPersonListVo> findTerminalList(TerminalApplyPersonListParam param);

}