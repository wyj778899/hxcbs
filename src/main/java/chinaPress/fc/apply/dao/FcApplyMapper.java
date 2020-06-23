package chinaPress.fc.apply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.vo.TerminalApplyListParam;
import chinaPress.fc.apply.vo.TerminalApplyListVo;
import chinaPress.fc.apply.vo.TerminalInstitutionApplyDetailVo;

@Mapper
@Repository
public interface FcApplyMapper {

	int insertSelective(FcApply record);

	FcApply selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FcApply record);

	/**
	 * 终端 报名申请数据数量
	 * 
	 * @return
	 */
	int findTerminalApplyCount(TerminalApplyListParam param);

	/**
	 * 终端 报名申请数据集合
	 * 
	 * @return
	 */
	List<TerminalApplyListVo> findTerminalApplyList(TerminalApplyListParam param);

	/**
	 * 终端机构 详情
	 * @param id
	 * @return
	 */
	TerminalInstitutionApplyDetailVo findTerminalInstitutionDetail(Integer id);
	
}