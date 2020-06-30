package chinaPress.fc.order.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.service.FcOrderService;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPayOrderDetailVo;
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

	/**
	 * 新增家长/从业者订单
	 * 
	 * @param record
	 * @return
	 */
	@PostMapping("insertPractitioner")
	public Result insertPractitioner(FcOrder record) {
		int index = fcOrderService.insertPractitioner(record);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 查询课程是否拥有
	 * 
	 * @param roleId 角色id
	 * @param roleType 角色类型（1.家长2.从业者）
	 * @param courseId 课程id
	 * @return
	 */
	@GetMapping("findMyCourseIsExist")
	public Map<String, Object> findMyCourseIsExist(Integer roleId, Integer roleType, Integer courseId) {
		return fcOrderService.findMyCourseIsExist(roleId, roleType, courseId);
	}

	/**
	 * 终端支付订单详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findTerminalPayOrderDetail")
	public Result findTerminalPayOrderDetail(Integer id) {
		TerminalPayOrderDetailVo data = fcOrderService.findTerminalPayOrderDetail(id);
		if (data != null) {
			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error();
		}
	}
}
