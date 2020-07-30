package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TerminalOrderListVo {

	/**
	 * 我的课程/订单
	 */
	private Integer id;

	/**
	 * 订单日期
	 */
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date date;

	/**
	 * 订单编码
	 */
	private String code;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 课程封面
	 */
	private String courseCover;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 课程使用天数
	 */
	private Integer courseNumber;

	/**
	 * 支付状态（1.未支付2.已支付）
	 */
	private Integer payStatus;

	/**
	 * 订单创建时间
	 */
	private Date createTime;

	/**
	 * 订单的支付金额
	 */
	private BigDecimal payAmount;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * 获取：createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 设置：createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 获取：payAmount
	 */
	public BigDecimal getPayAmount() {
		return payAmount;
	}

	/**
	 * 设置：payAmount
	 */
	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	/**
	 * 获取：courseCover
	 */
	public String getCourseCover() {
		return courseCover;
	}

	/**
	 * 设置：courseCover
	 */
	public void setCourseCover(String courseCover) {
		this.courseCover = courseCover;
	}
}
