package chinaPress.fc.order.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.DateUtil;
import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
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
					&& DateUtil.getLongOfTwoDate(terminalOrderListVo.getCreateTime(), new Date()) >= 2) {
				terminalOrderListVo.setPayStatus(3);
				idList.add(terminalOrderListVo.getId());
			}
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
	public int insertPractitioner(FcOrder record, String bookIdsStr) {
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
			return record.getId();
		}
		return 0;
	}

	/**
	 * 修改家长/从业者订单
	 * 
	 * @param record
	 * @param bookIdsStr
	 * @return
	 */
	public int updatePractitioner(FcOrder record, String bookIdsStr) {
		FcOrder orderModel = fcOrderMapper.selectByPrimaryKey(record.getId());
		if (orderModel == null) {
			return 0;
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
			return record.getId();
		}
		return 0;
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
