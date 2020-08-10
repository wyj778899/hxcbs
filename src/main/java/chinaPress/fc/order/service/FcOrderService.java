package chinaPress.fc.order.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.DateUtil;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.book.dao.FcBookArchivesMapper;
import chinaPress.fc.book.model.FcBookArchives;
import chinaPress.fc.coupon.dao.FcDiscountCouponMapper;
import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.model.FcDiscountCoupon;
import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import chinaPress.fc.course.dao.FcCourseArchivesMapper;
import chinaPress.fc.course.model.FcCourseArchives;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.order.dao.FcOrderBookMapper;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderBook;
import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.fc.order.vo.OrderInvoiceInfo;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPayOrderDetailVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;
import chinaPress.fc.order.vo.TerminalSubmitOrderDetailVo;
import chinaPress.fc.order.vo.UserInvoiceInfo;

@Service
public class FcOrderService {

	@Autowired
	private FcOrderMapper fcOrderMapper;

	@Autowired
	private FcOrderPersonMapper fcOrderPersonMapper;

	@Autowired
	private FcCourseHourMapper fcCourseHourMapper;

	@Autowired
	private FcOrderPersonHourMapper fcOrderPersonHourMapper;

	@Autowired
	private FcDiscountCouponRecordMapper fcDiscountCouponRecordMapper;

	@Autowired
	private FcOrderBookMapper fcOrderBookMapper;
	@Autowired
	private FcCourseArchivesMapper fcCourseArchivesMapper;
	@Autowired
	private FcBookArchivesMapper fcBookArchivesMapper;
	@Autowired
	private FcDiscountCouponMapper fcDiscountCouponMapper;
	
	

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
		List<Integer> idList = new ArrayList<Integer>();
		List<TerminalOrderListVo> list = fcOrderMapper.findTerminalOrderList(param);
		for (TerminalOrderListVo terminalOrderListVo : list) {
			if (terminalOrderListVo.getPayStatus().intValue() == 1
					&& DateUtil.getLongOfTwoDate(terminalOrderListVo.getCreateTime(), new Date()) >= 100) {
				terminalOrderListVo.setPayStatus(3);
				idList.add(terminalOrderListVo.getId());
			}
			int courseHourCount = fcCourseHourMapper.selectCourseHourCountByCOurseId(terminalOrderListVo.getCourseId());
			terminalOrderListVo.setCourseHourCount(courseHourCount);
		}
		updatePayStatus(idList);
		return list;
	}

	/**
	 * 需要修改支付状态为已关闭的订单
	 * 
	 * @author maguoliang
	 * @param idList
	 */
	private void updatePayStatus(List<Integer> idList) {
		for (Integer id : idList) {
			FcOrder record = new FcOrder();
			record.setId(id);
			record.setPayStatus(3);
			fcOrderMapper.updateByPrimaryKeySelective(record);
		}
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

	/**
	 * 终端家长 课程数据数量
	 * 
	 * @param param
	 * @return
	 */
	public int findTerminalPractitionerCourseCount(TerminalPractitionerOrderCourseListParam param) {
		return fcOrderMapper.findTerminalPractitionerCourseCount(param);
	}

	/**
	 * 终端家长 课程数据集合
	 * 
	 * @param param
	 * @return
	 */
	public List<TerminalPractitionerOrderCourseListVo> findTerminalPractitionerCourseList(
			TerminalPractitionerOrderCourseListParam param) {
		Date current_date = new Date();
		List<TerminalPractitionerOrderCourseListVo> data = fcOrderMapper.findTerminalPractitionerCourseList(param);
		for (TerminalPractitionerOrderCourseListVo item : data) {
			if (item.getEndTime().getTime() < current_date.getTime()) {
				item.setStatus(3);
			}
			// 判断当前这个课程当前报名人正在学习中的课时id
			Integer fcOrderPersonHour = fcOrderPersonHourMapper.selectTheNewestHour(item.getId(),
					param.getRoleId(), param.getRoleType());
			item.setLearningHourId(fcOrderPersonHour);
		}
		return data;
	}

	/**
	 * 新增家长/从业者订单
	 * 
	 * @param record
	 * @param bookIdsStr
	 * @return
	 */
	@Transactional
	public Result insertPractitioner(FcOrder record, String bookIdsStr) {
		Result result = new Result();
		// 金额效验
		// 订单金额（实际为课程金额+书籍金额），支付金额（订单金额-优惠金额）
		BigDecimal payPrice = BigDecimal.valueOf(0);
		// 先查询课程金额
		FcCourseArchives checkCourse = fcCourseArchivesMapper.selectByPrimaryKey(record.getCourseId());
		payPrice = payPrice.add(checkCourse.getCoursePrice());
		// 在查询书籍金额
		BigDecimal bookPrice = BigDecimal.valueOf(0);
		// 在查询优惠金额
		BigDecimal discountPrice = BigDecimal.valueOf(0);
		
		if (StringUtils.isNotBlank(bookIdsStr)) {
			String[] checkBookIds = bookIdsStr.split(",");
			for (String checkBookId : checkBookIds) {
				FcBookArchives checkBook = fcBookArchivesMapper.selectByPrimaryKey(Integer.parseInt(checkBookId));
				if (checkBook != null) {
					bookPrice = bookPrice.add(checkBook.getPrice());
				} else {
					return ResultUtil.custom(-1, "非法数据，书籍错误", -1);
				}
			}
			payPrice = payPrice.add(bookPrice);
		}
		// 如果客户端订单金额和实际订单金额不一致，返回错误
		if (payPrice.compareTo(record.getOrderAmount()) != 0) {
			result = ResultUtil.custom(-1, "非法数据，金额错误", -1);
		}
		
		// 判断优惠金额
		if (record.getIsCoupon() != null && record.getIsCoupon().intValue() == 1) {
			// 优惠券id
			Integer couponId = record.getCouponId();
			FcDiscountCouponRecord checkCoupon = fcDiscountCouponRecordMapper.selectByPrimaryKey(couponId);
			if (checkCoupon == null) {
				result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
			} else {
				// 发放角色类型（1.机构2.家长3.从业者）
//				checkCoupon.getGrantRoleType();
				// 角色类型（1.机构2.家长3.从业者）
//				orderModel.getRoleType();
				// 检查优惠券是否合法
				if (checkCoupon.getStatus().intValue() == 1 || checkCoupon.getStatus().intValue() == 3) {
					result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
				}
				if (checkCoupon.getStatus().intValue() == 2) {
					if (checkCoupon.getGrantRoleId().intValue() == record.getRoleId().intValue()
							&& checkCoupon.getGrantRoleType().intValue() == record.getRoleType().intValue()) {
						FcDiscountCoupon fcDiscountCoupon = fcDiscountCouponMapper.selectByPrimaryKey(checkCoupon.getCouponId());
						// 类型（1.满减劵2.观影劵）
						if (fcDiscountCoupon.getType().intValue() == 1) {
							discountPrice = fcDiscountCoupon.getEnoughMoney();
							payPrice = payPrice.subtract(discountPrice);
						}
						if (fcDiscountCoupon.getType().intValue() == 2) {
							payPrice = new BigDecimal(0);
						}
						// 检测最终支付金额是否一致
						if (payPrice.compareTo(record.getPayAmount()) == 0) {
							return submitOrderSuccess(record, bookIdsStr);
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
			return submitOrderSuccess(record, bookIdsStr);
		}
		return result;
	}
	
	/**
	 * 提交订单成功后
	 * @author maguoliang
	 * @param record
	 * @param bookIdsStr
	 * @return
	 */
	public Result submitOrderSuccess(FcOrder record, String bookIdsStr) {
		if (record.getCouponId() != null) {
			record.setIsCoupon(1);
		} else {
			record.setIsCoupon(0);
		}
		record.setPayStatus(1);
		//需要开发票的时候给发票状态赋值
		if(record.getInvoiceType()!=null && (record.getInvoiceType()==2 || record.getInvoiceType()==3)) {
			record.setInvoiceState(0);
		}
		Date current_date = new Date();
		record.setCode(String.valueOf(current_date.getTime()));
		record.setDate(current_date);
		
		int index = fcOrderMapper.insertSelective(record);
		if (index > 0) {
			if (bookIdsStr != null && !bookIdsStr.equals("")) {
				String[] bookIds = bookIdsStr.split(",");
				for (String bookId : bookIds) {
					fcOrderBookMapper.insertSelective(new FcOrderBook(record.getId(), Integer.parseInt(bookId)));
				}
			}

			// 如果使用优惠券，修改优惠券状态为已核销
//			if (record.getIsCoupon().intValue() == 1) {
//				FcDiscountCouponRecord couponRecord = new FcDiscountCouponRecord();
//				couponRecord.setId(record.getCouponId());
//				couponRecord.setStatus(3);
//				fcDiscountCouponRecordMapper.updateByPrimaryKeySelective(couponRecord);
//			}

			FcOrderPerson person = new FcOrderPerson();
			person.setOrderId(record.getId());
			person.setRoleId(record.getRoleId());
			// 家长
			if (record.getRoleType().intValue() == 2) {
				person.setRoleType(1);
			}
			// 从业者
			else if (record.getRoleType().intValue() == 3) {
				person.setRoleType(2);
			}
			person.setTotalCount(fcCourseHourMapper.selectCourseHourCountByCOurseId(record.getCourseId()));
			int personIndex = fcOrderPersonMapper.insertSelective(person);
			if (personIndex > 0) {
				FcOrderPersonHour personHour = new FcOrderPersonHour();
				personHour.setOrderPersonId(person.getId());
				personHour.setHourId(fcCourseHourMapper.selectCourseHourIdBysectionId(record.getCourseId()));
				fcOrderPersonHourMapper.insertSelective(personHour);
			}
			return ResultUtil.custom(1, "操作成功", record.getId());
		} else {
			return ResultUtil.custom(0, "操作失败");
		}
	}

	/**
	 * 修改家长/从业者订单
	 * 
	 * @param record
	 * @param bookIdsStr
	 * @return
	 */
	@Transactional
	public Result updatePractitioner(FcOrder record, String bookIdsStr) {
		Result result = new Result();
		// 金额效验
		// 订单金额（实际为课程金额+书籍金额），支付金额（订单金额-优惠金额）
		BigDecimal payPrice = BigDecimal.valueOf(0);
		// 先查询课程金额
		FcOrder checkOrder = fcOrderMapper.selectByPrimaryKey(record.getId());
		if (checkOrder == null) {
			return ResultUtil.custom(-1, "该订单不存在");
		} else {
			FcCourseArchives checkCourse = fcCourseArchivesMapper.selectByPrimaryKey(checkOrder.getCourseId());
			payPrice = payPrice.add(checkCourse.getCoursePrice());
			// 在查询书籍金额
			BigDecimal bookPrice = BigDecimal.valueOf(0);
			// 在查询优惠金额
			BigDecimal discountPrice = BigDecimal.valueOf(0);
			
			if (StringUtils.isNotBlank(bookIdsStr)) {
				String[] checkBookIds = bookIdsStr.split(",");
				for (String checkBookId : checkBookIds) {
					FcBookArchives checkBook = fcBookArchivesMapper.selectByPrimaryKey(Integer.parseInt(checkBookId));
					if (checkBook != null) {
						bookPrice = bookPrice.add(checkBook.getPrice());
					} else {
						return ResultUtil.custom(-1, "非法数据，书籍错误", -1);
					}
				}
				payPrice = payPrice.add(bookPrice);
			}
			// 如果客户端订单金额和实际订单金额不一致，返回错误
			if (payPrice.compareTo(record.getOrderAmount()) != 0) {
				return ResultUtil.custom(-1, "非法数据，金额错误", -1);
			}
			// 判断优惠金额
			if (record.getIsCoupon() != null && record.getIsCoupon().intValue() == 1) {
				// 优惠券id
				Integer couponId = record.getCouponId();
				FcDiscountCouponRecord checkCoupon = fcDiscountCouponRecordMapper.selectByPrimaryKey(couponId);
				if (checkCoupon == null) {
					result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
				} else {
					// 发放角色类型（1.机构2.家长3.从业者）
		//						checkCoupon.getGrantRoleType();
					// 角色类型（1.机构2.家长3.从业者）
		//						orderModel.getRoleType();
					// 检查优惠券是否合法
					if (checkCoupon.getStatus().intValue() == 1 || checkCoupon.getStatus().intValue() == 3) {
						result = ResultUtil.custom(-1, "非法数据，优惠券错误", -1);
					}
					if (checkCoupon.getStatus().intValue() == 2) {
						if (checkCoupon.getGrantRoleId().intValue() == record.getRoleId().intValue()
								&& checkCoupon.getGrantRoleType().intValue() == record.getRoleType().intValue()) {
							FcDiscountCoupon fcDiscountCoupon = fcDiscountCouponMapper.selectByPrimaryKey(checkCoupon.getCouponId());
							// 类型（1.满减劵2.观影劵）
							if (fcDiscountCoupon.getType().intValue() == 1) {
								discountPrice = fcDiscountCoupon.getEnoughMoney();
								payPrice = payPrice.subtract(discountPrice);
							}
							if (fcDiscountCoupon.getType().intValue() == 2) {
								payPrice = new BigDecimal(0);
							}
							// 检测最终支付金额是否一致
							if (payPrice.compareTo(record.getPayAmount()) == 0) {
								return updateOrderSuccess(record, bookIdsStr);
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
				return updateOrderSuccess(record, bookIdsStr);
			}
		}
		return result;
	}
	
	/**
	 * 修改订单提交成功后
	 * @author maguoliang
	 * @param record
	 * @param bookIdsStr
	 * @return
	 */
	public Result updateOrderSuccess(FcOrder record, String bookIdsStr) {
		Result result = new Result();
		FcOrder orderModel = fcOrderMapper.selectByPrimaryKey(record.getId());
		if (orderModel == null) {
			result = ResultUtil.custom(-1, "该订单不存在");
		}
		if (record.getCouponId() != null) {
			record.setIsCoupon(1);
		} else {
			record.setIsCoupon(0);
		}
		if (orderModel.getIsCoupon()!=null && orderModel.getIsCoupon().intValue() == 1) {
			FcDiscountCouponRecord couponRecord = new FcDiscountCouponRecord();
			couponRecord.setId(orderModel.getCouponId());
			couponRecord.setStatus(2);
			fcDiscountCouponRecordMapper.updateByPrimaryKeySelective(couponRecord);
		}
		int index = fcOrderMapper.updateByPrimaryKeySelective(record);
		if (index > 0) {
			fcOrderBookMapper.deleteByOrderId(record.getId());
			if (bookIdsStr != null && !bookIdsStr.equals("")) {
				String[] bookIds = bookIdsStr.split(",");
				for (String bookId : bookIds) {
					fcOrderBookMapper.insertSelective(new FcOrderBook(record.getId(), Integer.parseInt(bookId)));
				}
			}
//			if (record.getIsCoupon().intValue() == 1) {
//				FcDiscountCouponRecord couponRecord = new FcDiscountCouponRecord();
//				couponRecord.setId(record.getCouponId());
//				couponRecord.setStatus(3);
//				fcDiscountCouponRecordMapper.updateByPrimaryKeySelective(couponRecord);
//			}
			result = ResultUtil.custom(1, "操作成功", record.getId());
		}
		return result;
	}

	/**
	 * 根据id查询
	 * 
	 * @param id
	 * @return
	 */
	public FcOrder selectById(Integer id) {
		return fcOrderMapper.selectByPrimaryKey(id);
	}

	/**
	 * 根据code 查询
	 * 
	 * @param code
	 * @return
	 */
	public FcOrder selectByCode(String code) {
		return fcOrderMapper.selectByCode(code);
	}

	/**
	 * 修改
	 * 
	 * @param record
	 * @return
	 */
	public int updateByPrimaryKeySelective(FcOrder record) {
		return fcOrderMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 查询课程是否拥有
	 * 
	 * @param roleId
	 * @param roleType 角色类型：1.家长2.从业者
	 * @param courseId
	 * @return
	 */
	public Map<String, Object> findMyCourseIsExist(Integer roleId, Integer roleType, Integer courseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		FcOrder order = fcOrderMapper.findMyCourseIsExist(roleId, roleType, courseId);
		if (order != null) {
			Date current_date = new Date();
			if (order.getPayStatus() == 1 && DateUtil.getLongOfTwoDate(order.getCreateTime(), new Date()) < 2) {
				map.put("code", 1);
				map.put("message", "未支付订单，请进行支付");
				map.put("orderId", order.getId());
			} else if (order.getPayStatus() == 1 && DateUtil.getLongOfTwoDate(order.getCreateTime(), new Date()) >= 2) {
				FcOrder record = new FcOrder();
				record.setId(order.getId());
				record.setPayStatus(3);
				fcOrderMapper.updateByPrimaryKeySelective(record);
				map.put("code", -1);
				map.put("message", "未有课程，可以购买");
			} else if (order.getPayStatus() == 2) {
				if (order.getEndTime().getTime() > current_date.getTime()) {
					map.put("code", 0);
					map.put("message", "该课程学习中，不可再次购买");
				} else {
					map.put("code", -1);
					map.put("message", "未有课程，可以购买");
				}
			} else {
				map.put("code", -1);
				map.put("message", "未有课程，可以购买");
			}
		} else {
			map.put("code", -1);
			map.put("message", "未有课程，可以购买");
		}
		return map;
	}

	/**
	 * 终端支付订单详情
	 * 
	 * @param id
	 * @return
	 */
	public TerminalPayOrderDetailVo findTerminalPayOrderDetail(Integer id) {
		TerminalPayOrderDetailVo detail = fcOrderMapper.findTerminalPayOrderDetail(id);
		if (detail != null) {
			detail.setBookIds(fcOrderBookMapper.findBookIds(id));
			detail.setVideoNumber(fcCourseHourMapper.selectCourseHourCountByCOurseId(detail.getCourseId()));
		}
		return detail;
	}

	/**
	 * 终端提交订单详情
	 * 
	 * @param id
	 * @return
	 */
	public TerminalSubmitOrderDetailVo findTerminalSubmitOrderDetail(Integer id) {
		TerminalSubmitOrderDetailVo detail = fcOrderMapper.findTerminalSubmitOrderDetail(id);
		if (detail != null) {
			detail.setBookIds(fcOrderBookMapper.findBookIds(id));
			detail.setVideoNumber(fcCourseHourMapper.selectCourseHourCountByCOurseId(detail.getCourseId()));
		}
		return detail;
	}

	/**
	 * 判断当前这个课程当前报名人是否正在学习中
	 * 
	 * @author maguoliang
	 * @param roleId   角色id
	 * @param roleType 角色类型
	 * @param courseId 课程id
	 * @return
	 */
	public FcOrder selectCourseIsLearning(Integer roleId, Integer roleType, Integer courseId) {
		return fcOrderMapper.selectCourseIsLearning(roleId, roleType, courseId);
	}
	
	/**
	 * 通过订单id和发票状态查询当前订单是否已开发票信息
	 * @return
	 */
	public Result findInvoiceInfo(FcOrder record) {
		try {
			List<OrderInvoiceInfo> list = fcOrderMapper.selectInvoiceInfo(record);
			return new Result(1,"查询成功",list);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 通过订单id和发票状态查询当前订单是否已开发票信息个数
	 * @param id
	 * @param invoiceState
	 * @return
	 */
	public Result findInvoiceInfoCount(FcOrder record) {
		try {
			int count = fcOrderMapper.selectInvoiceInfoCount(record);
			return new Result(1,"查询成功",count);
		}catch(Exception e) {
			return new Result(0,"系统错误","");
		}
	}
	
	
	/**
	 * 更新订单的发票信息
	 * @param record
	 * @return
	 */
	public Result setInvoiceInfoCount(FcOrder record) {
		try {
		    int count = fcOrderMapper.updateByPrimaryKeySelective(record);
			return new Result(1,"更新成功",count);
		}catch(Exception e) {
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 查询用户的发票信息
	 * @param type
	 * @return
	 */
	@Transactional
	public Result findUserInvoices(Integer type,Integer page,Integer limit) {
		try {
			List<UserInvoiceInfo> list = fcOrderMapper.selectUserInvoices(type,page,limit);
			return new Result(1,"查询成功",list);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 查询用户的发票信息个数
	 * @param type
	 * @return
	 */
	@Transactional
	public Result findUserInvoicesCount(Integer type) {
		try {
			int count = fcOrderMapper.selectUserInvoicesCount(type);
			return new Result(1,"查询成功",count);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
	
	/**
	 * 发票详情信息
	 * @param id
	 * @return
	 */
	@Transactional
	public Result findInvoicePage(Integer id) {
		try {
			OrderInvoiceInfo orderInvoiceInfo = fcOrderMapper.selectInvoicePage(id);
			return new Result(1,"查询成功",orderInvoiceInfo);
		}catch(Exception e) {
			e.printStackTrace();
			return new Result(0,"系统错误","");
		}
	}
}
