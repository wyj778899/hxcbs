package chinaPress.fc.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.order.service.FcOrderService;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;

@RequestMapping("fc_order")
@RestController
public class FcOrderController {

	@Autowired
	private FcOrderService fcOrderService;

	/**
	 * 终端 我的订单数据数量
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalOrderCount")
	public Result findTerminalOrderCount(TerminalOrderListParam param) {
		int count = fcOrderService.findTerminalOrderCount(param);
		return ResultUtil.ok(count);
	}

	/**
	 * 终端 我的订单数据集合
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalOrderList")
	public Result findTerminalOrderList(TerminalOrderListParam param) {
		List<TerminalOrderListVo> data = fcOrderService.findTerminalOrderList(param);
		return ResultUtil.ok(data);
	}

	/**
	 * 终端 机构我的订单详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findTerminalInstitutionOrderDetail")
	public Result findTerminalInstitutionOrderDetail(Integer id) {
		TerminalInstitutionOrderDetailVo detail = fcOrderService.findTerminalInstitutionOrderDetail(id);
		if (detail != null) {
			return ResultUtil.ok(detail);
		} else {
			return ResultUtil.error();
		}

	}

	/**
	 * 终端家长 课程数据数量
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalPractitionerCourseCount")
	public Result findTerminalPractitionerCourseCount(TerminalPractitionerOrderCourseListParam param) {
		int count = fcOrderService.findTerminalPractitionerCourseCount(param);
		return ResultUtil.ok(count);
	}

	/**
	 * 终端家长 课程数据集合
	 * 
	 * @param param
	 * @return
	 */
	@GetMapping("findTerminalPractitionerCourseList")
	public Result findTerminalPractitionerCourseList(TerminalPractitionerOrderCourseListParam param) {
		List<TerminalPractitionerOrderCourseListVo> data = fcOrderService.findTerminalPractitionerCourseList(param);
		return ResultUtil.ok(data);
	}
}
