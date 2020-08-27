package chinaPress.fc.order.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import chinaPress.fc.apply.dao.FcApplyPersonMapper;
import chinaPress.fc.apply.model.FcApply;
import chinaPress.fc.apply.model.FcApplyPerson;
import chinaPress.fc.book.dao.FcBookArchivesMapper;
import chinaPress.fc.book.model.FcBookArchives;
import chinaPress.fc.coupon.dao.FcDiscountCouponMapper;
import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.model.FcDiscountCoupon;
import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.order.dao.FcOrderBookMapper;
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
	@Autowired
	private FcDiscountCouponRecordMapper fcDiscountCouponRecordMapper;
	@Autowired
	private FcOrderBookMapper fcOrderBookMapper;
	@Autowired
	private FcBookArchivesMapper fcBookArchivesMapper;
	@Autowired
	private FcDiscountCouponMapper fcDiscountCouponMapper;
	@Autowired
	private FcApplyPersonMapper fcApplyPersonMapper;

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
		return fcOrderService.insertPractitioner(record, bookIdsStr);
	}

	/**
	 * 修改家长/从业者订单
	 * 
	 * @param record
	 * @return
	 */
	@PostMapping("updatePractitioner")
	public Result updatePractitioner(FcOrder record, String bookIdsStr) {
		return fcOrderService.updatePractitioner(record, bookIdsStr);
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

	/**
	 * 如果使用优惠券后支付金额为0元，走此接口
	 * 
	 * @author maguoliang
	 * @param orderId 订单id
	 * @return
	 */
	@RequestMapping("falseWxPayOrder")
	public Result falseWxPayOrder(Integer orderId) {
		Result result = new Result();
		// 订单详情
		FcOrder orderModel = fcOrderService.selectById(orderId);
		if (orderModel != null) {
			if (orderModel.getPayStatus().intValue() == 1) {
				// 金额效验
				// 订单金额（实际为课程金额+书籍金额），支付金额（订单金额-优惠金额）
				BigDecimal payPrice = BigDecimal.valueOf(0);
				// 先查询课程金额
				FcCourseArchives checkCourse = fcCourseArchivesMapper.selectByPrimaryKey(orderModel.getCourseId());
				payPrice = payPrice.add(checkCourse.getCoursePrice());
				// 在查询书籍金额
				BigDecimal bookPrice = BigDecimal.valueOf(0);
				// 在查询优惠金额
				BigDecimal discountPrice = BigDecimal.valueOf(0);
				List<Integer> bookIdList = fcOrderBookMapper.findBookIds(orderId);
				if (bookIdList.size() > 0) {
					for (Integer bookId : bookIdList) {
						FcBookArchives checkBook = fcBookArchivesMapper.selectByPrimaryKey(bookId);
						bookPrice = bookPrice.add(checkBook.getPrice());
					}
					payPrice = payPrice.add(bookPrice);
				}
				// 如果客户端订单金额和实际订单金额不一致，返回错误
				if (payPrice.compareTo(orderModel.getOrderAmount()) != 0) {
					result = ResultUtil.custom(-1, "非法数据，金额错误", -1);
				}
				// 判断优惠金额
				if (orderModel.getIsCoupon() == 1) {
					// 优惠券id
					Integer couponId = orderModel.getCouponId();
					FcDiscountCouponRecord checkCoupon = fcDiscountCouponRecordMapper.selectByPrimaryKey(couponId);
					if (checkCoupon == null) {
						result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
					} else {
						Integer finalGrantRoleType = 0;
						if (checkCoupon.getGrantRoleType().intValue() == 2) {
							finalGrantRoleType = 1;
						} else if (checkCoupon.getGrantRoleType().intValue() == 3) {
							finalGrantRoleType = 2;
						} else if (checkCoupon.getGrantRoleType().intValue() == 4) {
							finalGrantRoleType = 3;
						}
						// 角色类型（1.机构2.家长3.从业者）
//						orderModel.getRoleType();
						// 检查优惠券是否合法
						if (checkCoupon.getStatus().intValue() == 1 || checkCoupon.getStatus().intValue() == 3) {
							result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
						}
						if (checkCoupon.getStatus().intValue() == 2) {
							if (checkCoupon.getGrantRoleId().intValue() == orderModel.getRoleId().intValue()
									&& finalGrantRoleType.intValue() == orderModel.getRoleType().intValue()) {
								FcDiscountCoupon fcDiscountCoupon = fcDiscountCouponMapper
										.selectByPrimaryKey(checkCoupon.getCouponId());
								// 类型（1.满减劵2.观影劵）
								if (fcDiscountCoupon.getType().intValue() == 1) {
									discountPrice = fcDiscountCoupon.getEnoughMoney();
									payPrice = payPrice.subtract(discountPrice);
								}
								if (fcDiscountCoupon.getType().intValue() == 2) {
									payPrice = new BigDecimal(0);
								}
								// 检测最终支付金额是否一致
								if (payPrice.compareTo(orderModel.getPayAmount()) == 0) {
									return paySucces(orderModel);
								} else {
									result = ResultUtil.custom(-1, "非法数据，金额错误", -1);
								}
							} else {
								result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
							}
						}
					}
				}
				// 没使用优惠券
				else {
					if (orderModel.getDiscountAmount().compareTo(new BigDecimal(0)) > 0
							|| orderModel.getPayAmount().compareTo(new BigDecimal(0)) == 0) {
						result = ResultUtil.custom(-1, "非法数据，金额错误", -1);
					} else {
						if (payPrice.compareTo(orderModel.getPayAmount()) != 0) {
							result = ResultUtil.custom(-1, "非法数据，金额错误", -1);
						} else {
							return paySucces(orderModel);
						}
					}
				}
			} else if (orderModel.getPayStatus().intValue() == 2) {
				result = ResultUtil.custom(-1, "该订单已支付", -1);
			} else if (orderModel.getPayStatus().intValue() == 3) {
				result = ResultUtil.custom(-1, "该订单已关闭", -1);
			}
		} else {
			result = ResultUtil.custom(0, "该订单不存在");
		}
		return result;
	}

	/**
	 * 支付成功后
	 * 
	 * @author maguoliang
	 * @param orderModel
	 * @return
	 */
	public Result paySucces(FcOrder orderModel) {
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
		updOrder.setPayTime(new Date());
		fcOrderService.updateByPrimaryKeySelective(updOrder);

		if (orderModel.getIsCoupon() != null && orderModel.getIsCoupon().intValue() == 1) {
			FcDiscountCouponRecord couponRecord = new FcDiscountCouponRecord();
			couponRecord.setId(orderModel.getCouponId());
			couponRecord.setStatus(3);
			fcDiscountCouponRecordMapper.updateByPrimaryKeySelective(couponRecord);
		}

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
				message = "您好，您报名的（" + courseName + "）课程，已经缴费成功，您可以登陆hxclss.cn登陆，访问“我的课堂”中进行学习。";
				smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
				// 同时给机构下所有报名人员发送短信
				Integer applyId = orderModel.getApplyId();
				List<FcApplyPerson> list = fcApplyPersonMapper.findByApplyId(applyId);
				List<String> tellPhoneList = new ArrayList<String>();
				for (FcApplyPerson fcApplyPerson : list) {
					MemberInfo selMemberInfo = new MemberInfo();
					selMemberInfo.setRoleType(
							fcApplyPerson.getRoleType() == 1 ? 3 : (fcApplyPerson.getRoleType() == 4 ? 2 : null));
					selMemberInfo.setRoleId(fcApplyPerson.getRoleId());
					MemberInfo resultMemberInfo = memberInfoMapper.selectByPrimaryKey(selMemberInfo);
					tellPhoneList.add(resultMemberInfo.getTellPhone());
				}
				smsService.sendFinishSMS(String.join(",", tellPhoneList), message);
			} else {
				// 家长/从业者
				message = "您好：您已成功报名（" + courseName + "），请及时关注课程信息，祝您学习愉快！";
				smsService.sendFinishSMS(memberInfo.getTellPhone(), message);
			}
		}
		return ResultUtil.custom(1, "支付成功");
	}

	/**
	 * 查询订单发票信息终端
	 * 
	 * @param record 接收的参数为 是否已申请发票:invoiceState(0未申请1已申请), roleId:角色id
	 *               roleType:角色类型 page:分页页数 limit:分页个数
	 * @return
	 */
	@RequestMapping("/queryInvoiceInfo")
	public Result queryInvoiceInfo(Integer invoiceState, Integer roleId, Integer roleType, Integer page,
			Integer limit) {
		FcOrder record = new FcOrder();
		record.setInvoiceState(invoiceState);
		record.setRoleId(roleId);
		record.setRoleType(roleType);
		record.setPage((page - 1) * limit);
		record.setLimit(limit);
		return fcOrderService.findInvoiceInfo(record);
	}

	/**
	 * 查询订单发票信息终端个数
	 * 
	 * @return
	 */
	@RequestMapping("/queryInvoiceInfoCount")
	public Result queryInvoiceInfoCount(FcOrder record) {
		return fcOrderService.findInvoiceInfoCount(record);
	}

	/**
	 * 更新发票信息
	 * 
	 * @param record
	 * @return
	 */
	@RequestMapping("/modifyInvoiceInfo")
	public Result modifyInvoiceInfo(FcOrder record) {
		// 当用户申请开发票的时候将法装申请状态改成已申请
		record.setInvoiceState(1);
		return fcOrderService.setInvoiceInfoCount(record);
	}

	/**
	 * 查询订单发票信息后台管理端
	 * 
	 * @return
	 */
	@RequestMapping("/queryUserInvoices")
	public Result queryUserInvoices(Integer type, Integer page, Integer limit) {
		return fcOrderService.findUserInvoices(type, (page - 1) * limit, limit);
	}

	/**
	 * 查询订单发票信息后台管理端个数
	 * 
	 * @return
	 */
	@RequestMapping("/queryUserInvoicesCount")
	public Result queryUserInvoicesCount(Integer type) {
		return fcOrderService.findUserInvoicesCount(type);
	}

	/**
	 * 发票详情信息
	 * 
	 * @return
	 */
	@RequestMapping("/queryInvoicePage")
	public Result queryInvoicePage(Integer id) {
		return fcOrderService.findInvoicePage(id);
	}

}
