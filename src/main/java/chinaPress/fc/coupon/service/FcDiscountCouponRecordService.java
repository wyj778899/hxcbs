package chinaPress.fc.coupon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import chinaPress.fc.coupon.dao.FcDiscountCouponRecordMapper;
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
}
