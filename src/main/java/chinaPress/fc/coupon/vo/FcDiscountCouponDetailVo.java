package chinaPress.fc.coupon.vo;

import java.util.List;

public class FcDiscountCouponDetailVo extends FcDiscountCouponListVo {
	/**
	 * 优惠券金额
	 */
	private String money;
	/**
	 * 发放数量
	 */
	private Integer grantCount;
	/**
	 * 核销数量
	 */
	private Integer useCount;
//	/**
//	 * 优惠券记录
//	 */
//	private List<FcDiscountCouponRecordVo> couponRecordList;

	/**
	 * 获取：money
	 */
	public String getMoney() {
		return money;
	}

	/**
	 * 设置：money
	 */
	public void setMoney(String money) {
		this.money = money;
	}

	/**
	 * 获取：grantCount
	 */
	public Integer getGrantCount() {
		return grantCount;
	}

	/**
	 * 设置：grantCount
	 */
	public void setGrantCount(Integer grantCount) {
		this.grantCount = grantCount;
	}

	/**
	 * 获取：useCount
	 */
	public Integer getUseCount() {
		return useCount;
	}

	/**
	 * 设置：useCount
	 */
	public void setUseCount(Integer useCount) {
		this.useCount = useCount;
	}

//	/**
//	 * 获取：couponRecordList
//	 */
//	public List<FcDiscountCouponRecordVo> getCouponRecordList() {
//		return couponRecordList;
//	}
//
//	/**
//	 * 设置：couponRecordList
//	 */
//	public void setCouponRecordList(List<FcDiscountCouponRecordVo> couponRecordList) {
//		this.couponRecordList = couponRecordList;
//	}
}
