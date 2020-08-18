package chinaPress.fc.apply.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.fc.apply.vo.FcApplyPersonVo;
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

	/**
	 * 查询所有报名申请已审核的家长和从业者个数
	 * 
	 * @author maguoliang
	 * @param tellPhoneUserName 用户名或手机号
	 * @return
	 */
	int selectFcApplyPersonInfoCount(String tellPhoneUserName);

	/**
	 * 查询所有报名申请已审核的家长和从业者列表
	 * 
	 * @author maguoliang
	 * @param tellPhoneUserName 用户名或手机号
	 * @param offset            从第几条数据开始查询
	 * @param rows              查询多少条数据
	 * @return
	 */
	List<FcApplyPersonVo> selectFcApplyPersonInfoList(@Param("tellPhoneUserName") String tellPhoneUserName,
			@Param("offset") Integer offset, @Param("rows") Integer rows);
}