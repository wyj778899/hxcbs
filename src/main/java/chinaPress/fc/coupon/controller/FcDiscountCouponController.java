package chinaPress.fc.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.coupon.model.FcDiscountCoupon;
import chinaPress.fc.coupon.service.FcDiscountCouponService;
import chinaPress.fc.coupon.vo.FcDiscountCouponDetailVo;
import chinaPress.fc.coupon.vo.FcDiscountCouponListVo;

@RestController
@RequestMapping("coupon")
public class FcDiscountCouponController {
	@Autowired
	private FcDiscountCouponService fcDiscountCouponService;

	/**
	 * 添加优惠券
	 * 
	 * @author maguoliang
	 * @param name      优惠券名称
	 * @param startTime 优惠券有效开始时间
	 * @param endTime   优惠券有效结束时间
	 * @return
	 */
	@RequestMapping("manage/add")
	public Result addFcDiscountCoupon(FcDiscountCoupon fcDiscountCoupon, String course) {
		return fcDiscountCouponService.addFcDiscountCoupon(fcDiscountCoupon, course);
	}

	/**
	 * 查询优惠券个数
	 * 
	 * @author maguoliang
	 * @param name      优惠券名称
	 * @param startTime 优惠券有效开始时间
	 * @param endTime   优惠券有效结束时间
	 * @return
	 */
	@RequestMapping("manage/count")
	public Result selectFcDiscountCouponCount(String name, String startTime, String endTime) {
		int index = fcDiscountCouponService.selectFcDiscountCouponCount(name, startTime, endTime);
		return ResultUtil.ok(index);
	}

	/**
	 * 查询优惠券列表
	 * 
	 * @author maguoliang
	 * @param name      优惠券名称
	 * @param startTime 优惠券有效开始时间
	 * @param endTime   优惠券有效结束时间
	 * @param offset    从哪一条开始查询
	 * @param rows      查询多少条
	 * @return
	 */
	@RequestMapping("manage/list")
	public Result selectFcDiscountCouponList(String name, String startTime, String endTime, Integer pageNumber,
			Integer pageSize) {
		List<FcDiscountCouponListVo> list = fcDiscountCouponService.selectFcDiscountCouponList(name, startTime, endTime,
				pageNumber, pageSize);
		return ResultUtil.ok(list);
	}

	/**
	 * 查询优惠券详情+明细
	 * 
	 * @author maguoliang
	 * @param id
	 * @return
	 */
	@RequestMapping("manage/detail")
	public Result selectFcDiscountCouponDetail(Integer id) {
		FcDiscountCouponDetailVo fcDiscountCouponDetailVo = fcDiscountCouponService.selectFcDiscountCouponDetail(id);
		return ResultUtil.ok(fcDiscountCouponDetailVo);
	}
}
