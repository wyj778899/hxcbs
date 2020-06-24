package chinaPress.fc.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.coupon.service.FcDiscountCouponRecordService;
import chinaPress.fc.coupon.vo.FcDiscountCouponRecordVo;
import chinaPress.fc.coupon.vo.FcDiscountMyCouponRecordListVo;
import chinaPress.fc.coupon.vo.FcDiscountValidCouponVo;

@RestController
@RequestMapping("coupon/record")
public class FcDiscountCouponRecordController {
	@Autowired
	private FcDiscountCouponRecordService fcDiscountCouponRecordService;

	/**
	 * 查询可发放优惠券个数
	 * 
	 * @author maguoliang
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectValidCouponCount() {
		int index = fcDiscountCouponRecordService.selectValidCouponCount();
		return ResultUtil.ok(index);
	}

	/**
	 * 查询可发放优惠券列表
	 * 
	 * @author maguoliang
	 * @param pageNumber 第几页
	 * @param pageSize   每页多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectValidCouponList(Integer pageNumber, Integer pageSize) {
		List<FcDiscountValidCouponVo> list = fcDiscountCouponRecordService.selectValidCouponList(pageNumber, pageSize);
		return ResultUtil.ok(list);
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
	@RequestMapping("manage/detailCount")
	public Result selectCouponRecordDetailCount(Integer couponId, String code, String grantRoleName, Integer status,
			String startTime, String endTime) {
		int index = fcDiscountCouponRecordService.selectCouponRecordDetailCount(couponId, code, grantRoleName, status,
				startTime, endTime);
		return ResultUtil.ok(index);
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
	@RequestMapping("manage/detailList")
	public Result selectCouponRecordDetailList(Integer couponId, String code, String grantRoleName, Integer status,
			String startTime, String endTime, Integer pageNumber, Integer pageSize) {
		List<FcDiscountCouponRecordVo> list = fcDiscountCouponRecordService.selectCouponRecordDetailList(couponId, code,
				grantRoleName, status, startTime, endTime, pageNumber, pageSize);
		return ResultUtil.ok(list);
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
	 * @param courseName    优惠券课程名称
	 * @param status        优惠券使用状态1.未使用2.已过期
	 * @param searchTxt     搜索条件（优惠券名称/编码或课程名称）
	 * @return
	 */
	@RequestMapping("index/myDetailCount")
	public Result selectMyCouponRecordCount(Integer grantRoleId, Integer grantRoleType, Integer type, String name,
			String code, String courseName, Integer status, String searchTxt) {
		int index = fcDiscountCouponRecordService.selectMyCouponRecordCount(grantRoleId, grantRoleType, type, name,
				code, courseName, status, searchTxt);
		return ResultUtil.ok(index);
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
	 * @param courseName    优惠券课程名称
	 * @param status        优惠券使用状态1.未使用2.已过期
	 * @param searchTxt     搜索条件（优惠券名称/编码或课程名称）
	 * @param pageNumber    第几页
	 * @param pageSize      每页查询多少条
	 * @return
	 */
	@RequestMapping("index/myDetailList")
	public Result selectMyCouponRecordList(Integer grantRoleId, Integer grantRoleType, Integer type, String name,
			String code, String courseName, Integer status, String searchTxt, Integer pageNumber, Integer pageSize) {
		List<FcDiscountMyCouponRecordListVo> list = fcDiscountCouponRecordService.selectMyCouponRecordList(grantRoleId,
				grantRoleType, type, name, code, courseName, status, searchTxt, pageNumber, pageSize);
		return ResultUtil.ok(list);
	}

	/**
	 * 发放优惠券
	 * 
	 * @author maguoliang
	 * @param roleId          发放角色id
	 * @param roleType        发放角色类型
	 * @param couponRecordIds 发放优惠券id集合
	 * @return
	 */
	@RequestMapping("manage/grantCoupon")
	public Result grantCoupon(Integer roleId, Integer roleType, String couponRecordIds) {
		try {
			int index = fcDiscountCouponRecordService.grantCoupon(roleId, roleType, couponRecordIds);
			return ResultUtil.custom(1, "发放成功", index);
		} catch (Exception e) {
			e.printStackTrace();
			return ResultUtil.custom(0, "发放失败", 0);
		}
	}
}
