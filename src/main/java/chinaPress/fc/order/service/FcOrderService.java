package chinaPress.fc.order.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.model.FcDiscountCouponRecord;
import chinaPress.fc.course_section.dao.FcCourseHourMapper;
import chinaPress.fc.order.dao.FcOrderMapper;
import chinaPress.fc.order.dao.FcOrderPersonHourMapper;
import chinaPress.fc.order.dao.FcOrderPersonMapper;
import chinaPress.fc.order.model.FcOrder;
import chinaPress.fc.order.model.FcOrderPerson;
import chinaPress.fc.order.model.FcOrderPersonHour;
import chinaPress.fc.order.vo.TerminalInstitutionOrderDetailVo;
import chinaPress.fc.order.vo.TerminalOrderListParam;
import chinaPress.fc.order.vo.TerminalOrderListVo;
import chinaPress.fc.order.vo.TerminalPayOrderDetailVo;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListParam;
import chinaPress.fc.order.vo.TerminalPractitionerOrderCourseListVo;

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
		}
		return data;
	}

	/**
	 * 新增家长/从业者订单
	 * 
	 * @param record
	 * @return
	 */
	public int insertPractitioner(FcOrder record) {
		if (record.getCouponId() != null) {
			record.setIsCoupon(1);
		} else {
			record.setIsCoupon(0);
		}
		record.setPayStatus(1);
		Date current_date = new Date();
		record.setCode(String.valueOf(current_date.getTime()));
		record.setDate(current_date);
		int index = fcOrderMapper.insertSelective(record);
		if (index > 0) {
			// 如果使用优惠券，修改优惠券状态为已核销
			if (record.getIsCoupon().intValue() == 1) {
				FcDiscountCouponRecord couponRecord = new FcDiscountCouponRecord();
				couponRecord.setId(record.getCouponId());
				couponRecord.setStatus(3);
				fcDiscountCouponRecordMapper.updateByPrimaryKeySelective(couponRecord);
			}
			
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
	 * @param roleType
	 * @param courseId
	 * @return
	 */
	public Map<String, Object> findMyCourseIsExist(Integer roleId, Integer roleType, Integer courseId) {
		Map<String, Object> map = new HashMap<String, Object>();
		FcOrder order = fcOrderMapper.findMyCourseIsExist(roleId, roleType, courseId);
		if (order != null) {
			Date current_date = new Date();
			if (order.getPayStatus() == 1) {
				map.put("code", 1);
				map.put("message", "未支付订单，请进行支付");
				map.put("orderId", order.getId());
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
			detail.setVideoNumber(fcCourseHourMapper.selectCourseHourCountByCOurseId(detail.getCourseId()));
		}
		return detail;
	}
}
