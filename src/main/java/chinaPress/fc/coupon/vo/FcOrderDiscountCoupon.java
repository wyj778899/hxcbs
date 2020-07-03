package chinaPress.fc.coupon.vo;

import java.math.BigDecimal;

public class FcOrderDiscountCoupon {
	/**
	 * 优惠券记录id
	 */
	private Integer id;
	/**
	 * 满多少元
	 */
	private BigDecimal enoughMoney;
	/**
	 * 减多少元
	 */
	private BigDecimal discountMoney;

	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：enoughMoney
	 */
	public BigDecimal getEnoughMoney() {
		return enoughMoney;
	}

	/**
	 * 设置：enoughMoney
	 */
	public void setEnoughMoney(BigDecimal enoughMoney) {
		this.enoughMoney = enoughMoney;
	}

	public BigDecimal getDiscountMoney() {
		return discountMoney;
	}

	public void setDiscountMoney(BigDecimal discountMoney) {
		this.discountMoney = discountMoney;
	}

}
