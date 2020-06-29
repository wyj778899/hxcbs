package chinaPress.fc.order.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_order
 * 
 * @author Chaoqun
 * @date 2020-06-22 17:54:34
 */
public class FcOrder {
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
	 * 角色类型（1.机构2.家长3.从业者）
	 */
	private Integer roleType;

	/**
	 * 下单角色id
	 */
	private Integer roleId;

	/**
	 * 课程id
	 */
	private Integer courseId;

	/**
	 * 有效开始时间
	 */
	private Date startTime;

	/**
	 * 有效结束时间
	 */
	private Date endTime;

	/**
	 * 是否使用优惠券（0.否1.是）
	 */
	private Integer isCoupon;

	/**
	 * 优惠券id
	 */
	private Integer couponId;

	/**
	 * 支付状态（1.未支付2.已支付）
	 */
	private Integer payStatus;

	/**
	 * 状态（0.无效1.有效）
	 */
	private Integer state;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新人
	 */
	private Integer updateId;

	/**
	 * 更新时间
	 */
	private Date updateTime;

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
	 * 报名申请id
	 */
	private Integer applyId;

//	<result column="invoice_type" jdbcType="INTEGER" property="invoiceType" />
//    <result column="invoice_title" jdbcType="VARCHAR" property="invoiceTitle" />
//    <result column="invoice_number" jdbcType="VARCHAR" property="invoiceNumber" />
//    <result column="invoice_details" jdbcType="VARCHAR" property="invoiceDetails" />
//    <result column="consignee_name" jdbcType="VARCHAR" property="consigneeName" />
//    <result column="consignee_area" jdbcType="VARCHAR" property="consigneeArea" />
//    <result column="consignee_address" jdbcType="VARCHAR" property="consigneeAddress" />
//    <result column="consignee_phone" jdbcType="VARCHAR" property="consigneePhone" />
//    <result column="payment_mode" jdbcType="VARCHAR" property="paymentMode" />
//    <result column="third_party_no" jdbcType="VARCHAR" property="thirdPartyNo" />
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

	/**
	 * 支付方式：1.微信，2.支付宝
	 */
	private String paymentMode;

	/**
	 * 第三方单号
	 */
	private String thirdPartyNo;

	/**
	 * 我的课程/订单
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 我的课程/订单
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 订单日期
	 * 
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 订单日期
	 * 
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 订单编码
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 订单编码
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 角色类型（1.机构2.家长3.从业者）
	 * 
	 * @return roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * 角色类型（1.机构2.家长3.从业者）
	 * 
	 * @param roleType
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * 下单角色id
	 * 
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * 下单角色id
	 * 
	 * @param roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 课程id
	 * 
	 * @return courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * 课程id
	 * 
	 * @param courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * 有效开始时间
	 * 
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 有效开始时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 有效结束时间
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 有效结束时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 是否使用优惠券（0.否1.是）
	 * 
	 * @return isCoupon
	 */
	public Integer getIsCoupon() {
		return isCoupon;
	}

	/**
	 * 是否使用优惠券（0.否1.是）
	 * 
	 * @param isCoupon
	 */
	public void setIsCoupon(Integer isCoupon) {
		this.isCoupon = isCoupon;
	}

	/**
	 * 优惠券id
	 * 
	 * @return couponId
	 */
	public Integer getCouponId() {
		return couponId;
	}

	/**
	 * 优惠券id
	 * 
	 * @param couponId
	 */
	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	/**
	 * 支付状态（1.未支付2.已支付）
	 * 
	 * @return payStatus
	 */
	public Integer getPayStatus() {
		return payStatus;
	}

	/**
	 * 支付状态（1.未支付2.已支付）
	 * 
	 * @param payStatus
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * 状态（0.无效1.有效）
	 * 
	 * @return state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 状态（0.无效1.有效）
	 * 
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 创建人
	 * 
	 * @return createId
	 */
	public Integer getCreateId() {
		return createId;
	}

	/**
	 * 创建人
	 * 
	 * @param createId
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 更新人
	 * 
	 * @return updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * 更新人
	 * 
	 * @param updateId
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
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

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
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

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public String getThirdPartyNo() {
		return thirdPartyNo;
	}

	public void setThirdPartyNo(String thirdPartyNo) {
		this.thirdPartyNo = thirdPartyNo;
	}
}