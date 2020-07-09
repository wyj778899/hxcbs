package chinaPress.fc.order.controller;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.sms.service.SMSService;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.apply.dao.FcApplyMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.service.FcOrderService;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPayOrderDetailVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;
import chinaPress.fc.order.vo.TerminalSubmitOrderDetailVo;
import chinaPress.role.member.dao.MemberInfoMapper;
import chinaPress.role.member.model.MemberInfo;

@RequestMapping("fc_order")
@RestController
public class FcOrderController {

	@Autowired
	private FcOrderService fcOrderService;
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Autowired
	private SMSService smsService;
	@Autowired
	private FcApplyMapper fcApplyMapper;
	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

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
	public Result insertPractitioner(FcOrder record, String bookIdsStr) {
		int index = fcOrderService.insertPractitioner(record, bookIdsStr);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 修改家长/从业者订单
	 * 
	 * @param record
	 * @return
	 */
	@PostMapping("updatePractitioner")
	public Result updatePractitioner(FcOrder record, String bookIdsStr) {
		int index = fcOrderService.updatePractitioner(record, bookIdsStr);
		if (index > 0) {
			return ResultUtil.ok(index);
		} else {
			return ResultUtil.error();
		}
	}

	/**
	 * 查询课程是否拥有
	 * 
	 * @param roleId   角色id
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

	/**
	 * 终端提交订单详情
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("findTerminalSubmitOrderDetail")
	public Result findTerminalSubmitOrderDetail(Integer id) {
		TerminalSubmitOrderDetailVo data = fcOrderService.findTerminalSubmitOrderDetail(id);
		if (data != null) {

			return ResultUtil.ok(data);
		} else {
			return ResultUtil.error();
		}
	}

	@RequestMapping("falseWxPayOrder")
	public Result falseWxPayOrder(Integer orderId) {
		// 订单详情
		FcOrder orderModel = fcOrderService.selectById(orderId);
		if (orderModel != null) {
			if (orderModel.getPayStatus() == 1) {
				// 课程档案
				FcCourseArchives courseModel = fcCourseArchivesMapper.selectByPrimaryKey(orderModel.getCourseId());

				FcOrder updOrder = new FcOrder();
				updOrder.setId(orderModel.getId());
				// 当前时间
				Calendar current_calendar = Calendar.getInstance();
				// 开始时间
				updOrder.setStartTime(current_calendar.getTime());
				// 结束时间
				current_calendar.add(Calendar.DAY_OF_YEAR, courseModel.getCourseNumber());
				updOrder.setEndTime(current_calendar.getTime());
				updOrder.setPayStatus(2);
				fcOrderService.updateByPrimaryKeySelective(updOrder);

				// 修改订单子数据为个人
				fcOrderPersonMapper.updateIndividualByOrderId(orderModel.getId());

				// 修改申请记录为已缴费
				if (orderModel.getApplyId() != null) {
					FcApply updApply = new FcApply();
					updApply.setId(orderModel.getApplyId());
					updApply.setApplySchedule(2);
					fcApplyMapper.updateByPrimaryKeySelective(updApply);
				}

				MemberInfo memberParam = new MemberInfo();
				memberParam.setRoleId(orderModel.getRoleId());
				if (orderModel.getRoleType() == 1) {
					memberParam.setRoleType(2);
				} else if (orderModel.getRoleType() == 2) {
					memberParam.setRoleType(3);
				} else if (orderModel.getRoleType() == 3) {
					memberParam.setRoleType(4);
				}
				MemberInfo memberInfo = memberInfoMapper.selectByPrimaryKey(memberParam);
				if (memberInfo != null) {
					String courseName = fcCourseArchivesMapper.selectByPrimaryKey(orderModel.getCourseId()).getName();
					String message = "";
					if (orderModel.getRoleType().intValue() == 1) {
						// 机构
					} else {
						// 家长/从业者
						message = "【华夏云课堂】您好：您已成功报名[" + courseName + "]，请及时关注课程信息，祝您学习愉快！";
						smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
					}
				}
			}
			return ResultUtil.custom(1, "支付成功");
		} else {
			return ResultUtil.custom(0, "该订单不存在");
		}
	}
}
