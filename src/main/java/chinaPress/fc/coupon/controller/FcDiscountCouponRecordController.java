package chinaPress.fc.coupon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chinaPress.common.result.model.Result;
import chinaPress.common.util.ResultUtil;
import chinaPress.fc.coupon.service.FcDiscountCouponRecordService;
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
}
