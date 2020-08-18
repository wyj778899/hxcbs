package chinaPress.fc.apply.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.vo.FcApplyPersonVo;
import chinaPress.fc.apply.vo.TerminalApplyPersonListParam;
import chinaPress.fc.apply.vo.TerminalApplyPersonListVo;

@Service
public class FcApplyPersonService {

	@Autowired
	private FcApplyPersonMapper fcApplyPersonMapper;

	/**
	 * 终端 数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalCount(TerminalApplyPersonListParam param) {
		return fcApplyPersonMapper.findTerminalCount(param);
	}

	/**
	 * 终端 数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalApplyPersonListVo> findTerminalList(TerminalApplyPersonListParam param) {
		return fcApplyPersonMapper.findTerminalList(param);
	}

	/**
	 * 查询所有报名申请已审核的家长和从业者个数
	 * 
	 * @author maguoliang
	 * @param tellPhoneUserName 用户名或手机号
	 * @return
	 */
	public int selectFcApplyPersonInfoCount(String tellPhoneUserName) {
		return fcApplyPersonMapper.selectFcApplyPersonInfoCount(tellPhoneUserName);
	}

	/**
	 * 查询所有报名申请已审核的家长和从业者列表
	 * 
	 * @author maguoliang
	 * @param tellPhoneUserName 用户名或手机号
	 * @param offset            从第几条数据开始查询
	 * @param rows              查询多少条数据
	 * @return
	 */
	public List<FcApplyPersonVo> selectFcApplyPersonInfoList(String tellPhoneUserName, Integer pageNumber,
			Integer pageSize) {
		return fcApplyPersonMapper.selectFcApplyPersonInfoList(tellPhoneUserName, pageNumber * pageSize - pageSize,
				pageSize);
	}
}
