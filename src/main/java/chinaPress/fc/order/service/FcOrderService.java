package chinaPress.fc.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;

@Service
public class FcOrderService {

	@Autowired
	private FcOrderMapper fcOrderMapper;

	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;

	/**
	 * 终端 我的订单数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalOrderCount(TerminalOrderListParam param) {
		return fcOrderMapper.findTerminalOrderCount(param);
	}

	/**
	 * 终端 我的订单数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalOrderListVo> findTerminalOrderList(TerminalOrderListParam param) {
		return fcOrderMapper.findTerminalOrderList(param);
	}

	/**
	 * 终端 机构我的订单详情
	 * 
	 * @param id
	 * @return
	 */
	public TerminalInstitutionOrderDetailVo findTerminalInstitutionOrderDetail(Integer id) {
		TerminalInstitutionOrderDetailVo detail = fcOrderMapper.findTerminalInstitutionOrderDetail(id);
		if (detail != null) {
			detail.setVideoNumber(fcCourseHourMapper.selectCourseHourCountByCOurseId(detail.getCourseId()));
		}
		return detail;
	}
}
