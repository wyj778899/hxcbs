package chinaPress.fc.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
import chinaPress.fc.coupon.vo.FcDiscountCouponRecordVo;
import chinaPress.fc.coupon.vo.FcDiscountMyCouponRecordListVo;
import chinaPress.fc.coupon.vo.FcDiscountValidCouponVo;

@Service
public class FcDiscountCouponRecordService {
	@Autowired
	private FcDiscountCouponRecordMapper fcDiscountCouponRecordMapper;

	/**
	 * 查询可发放优惠券个数
	 * 
	 * @author maguoliang
	 * @return
	 */
	public int selectValidCouponCount() {
		return fcDiscountCouponRecordMapper.selectValidCouponCount();
	}

	/**
	 * 查询可发放优惠券列表
	 * 
	 * @author maguoliang
	 * @param pageNumber 第几页
	 * @param pageSize   每页多少条
	 * @return
	 */
	public List<FcDiscountValidCouponVo> selectValidCouponList(Integer pageNumber, Integer pageSize) {
		return fcDiscountCouponRecordMapper.selectValidCouponList(pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 查询优惠券明细
	 * 
	 * @author maguoliang
	 * @param couponId      优惠券id
	 * @param code          优惠券编码
	 * @param grantRoleName 领取人名称
	 * @param status        使用状态
	 * @param startTime     开始时间
	 * @param endTime       结束时间
	 * @return
	 */
	public int selectCouponRecordDetailCount(Integer couponId, String code, String grantRoleName, Integer status,
			String startTime, String endTime) {
		return fcDiscountCouponRecordMapper.selectCouponRecordDetailCount(couponId, code, grantRoleName, status,
				startTime, endTime);
	}

	/**
	 * 查询优惠券明细
	 * 
	 * @author maguoliang
	 * @param couponId      优惠券id
	 * @param code          优惠券编码
	 * @param grantRoleName 领取人名称
	 * @param status        使用状态
	 * @param startTime     开始时间
	 * @param endTime       结束时间
	 * @param pageNumber    第几页
	 * @param pageSize      每页查询查询多少条数据
	 * @return
	 */
	public List<FcDiscountCouponRecordVo> selectCouponRecordDetailList(Integer couponId, String code,
			String grantRoleName, Integer status, String startTime, String endTime, Integer pageNumber,
			Integer pageSize) {
		return fcDiscountCouponRecordMapper.selectCouponRecordDetailList(couponId, code, grantRoleName, status,
				startTime, endTime, pageNumber * pageSize - pageSize, pageSize);
	}

	/**
	 * 查询我的优惠券个数
	 * 
	 * @author maguoliang
	 * @param grantRoleId   领取人角色id
	 * @param grantRoleType 领取人角色类型
	 * @param type          优惠券类型1.满减券2.观看券
	 * @param name          优惠券名称
	 * @param code          优惠券编码
	 * @param status        优惠券使用状态1.未使用2.已过期
	 * @return
	 */
	public int selectMyCouponRecordCount(Integer grantRoleId, Integer grantRoleType, Integer type, String name,
			String code, Integer status) {
		return fcDiscountCouponRecordMapper.selectMyCouponRecordCount(grantRoleId, grantRoleType, type, name, code,
				status);
	}

	/**
	 * 查询我的优惠券列表
	 * 
	 * @author maguoliang
	 * @param grantRoleId   领取人角色id
	 * @param grantRoleType 领取人角色类型
	 * @param type          优惠券类型1.满减券2.观看券
	 * @param name          优惠券名称
	 * @param code          优惠券编码
	 * @param status        优惠券使用状态1.未使用2.已过期
	 * @param pageNumber    第几页
	 * @param pageSize      每页查询多少条
	 * @return
	 */
	public List<FcDiscountMyCouponRecordListVo> selectMyCouponRecordList(Integer grantRoleId, Integer grantRoleType,
			Integer type, String name, String code, Integer status, Integer pageNumber, Integer pageSize) {
		return fcDiscountCouponRecordMapper.selectMyCouponRecordList(grantRoleId, grantRoleType, type, name, code,
				status, pageNumber * pageSize - pageSize, pageSize);
	}
}
