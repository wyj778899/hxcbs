package chinaPress.fc.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonParam;
import chinaPress.fc.order.vo.TerminalInstitutionOrderPersonVo;

@Service
public class FcOrderPersonService {

	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

	/**
	 * 终端 查询订单人员数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalCount(TerminalInstitutionOrderPersonParam param) {
		return fcOrderPersonMapper.findTerminalCount(param);
	}

	/**
	 * 终端 查询订单人员数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalInstitutionOrderPersonVo> findTerminalList(
			TerminalInstitutionOrderPersonParam param) {
		return fcOrderPersonMapper.findTerminalList(param);
	}
}
