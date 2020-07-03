package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TerminalSubmitOrderDetailVo {
	/**
	 * 我的课程/订单
	 */
	private Integer id;

	/**
	 * 订单日期
	 */
	private Date date;

	/**
	 * 订单编码
	 */
	private String code;

	/**
	 * 课程id
	 */
	private Integer courseId;

	/**
	 * 课程名称
	 */
	private String coursePhoto;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 视频数量
	 */
	private Integer videoNumber;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 是否使用优惠券（0.否1.是）
	 */
	private Integer isCoupon;

	/**
	 * 优惠券id
	 */
	private Integer couponId;

	/**
	 * 优惠券编码
	 */
	private String couponCode;

	/**
	 * 订单金额
	 */
	private BigDecimal orderAmount;

	/**
	 * 折扣金额
	 */
	private BigDecimal discountAmount;

	/**
	 * 支付金额
	 */
	private BigDecimal payAmount;

	/**
	 * 发票类型：1.无需发票，2.个人，3.公司
	 */
	private Integer invoiceType;

	/**
	 * 发票抬头
	 */
	private String invoiceTitle;

	/**
	 * 发票税号
	 */
	private String invoiceNumber;

	/**
	 * 发票明细
	 */
	private String invoiceDetails;

	/**
	 * 收货人姓名
	 */
	private String consigneeName;

	/**
	 * 收获地区
	 */
	private String consigneeArea;

	/**
	 * 收获详细地址
	 */
	private String consigneeAddress;

	/**
	 * 收获电话
	 */
	private String consigneePhone;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public String getCoursePhoto() {
		return coursePhoto;
	}

	public void setCoursePhoto(String coursePhoto) {
		this.coursePhoto = coursePhoto;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(Integer videoNumber) {
		this.videoNumber = videoNumber;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Integer getIsCoupon() {
		return isCoupon;
	}

	public void setIsCoupon(Integer isCoupon) {
		this.isCoupon = isCoupon;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public BigDecimal getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(BigDecimal orderAmount) {
		this.orderAmount = orderAmount;
	}

	public BigDecimal getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(BigDecimal discountAmount) {
		this.discountAmount = discountAmount;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public Integer getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(Integer invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getInvoiceDetails() {
		return invoiceDetails;
	}

	public void setInvoiceDetails(String invoiceDetails) {
		this.invoiceDetails = invoiceDetails;
	}

	public String getConsigneeName() {
		return consigneeName;
	}

	public void setConsigneeName(String consigneeName) {
		this.consigneeName = consigneeName;
	}

	public String getConsigneeArea() {
		return consigneeArea;
	}

	public void setConsigneeArea(String consigneeArea) {
		this.consigneeArea = consigneeArea;
	}

	public String getConsigneeAddress() {
		return consigneeAddress;
	}

	public void setConsigneeAddress(String consigneeAddress) {
		this.consigneeAddress = consigneeAddress;
	}

	public String getConsigneePhone() {
		return consigneePhone;
	}

	public void setConsigneePhone(String consigneePhone) {
		this.consigneePhone = consigneePhone;
	}
}
