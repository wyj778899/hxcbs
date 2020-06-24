package chinaPress.fc.apply.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.apply.dao.FcApplyPersonMapper;
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
}
