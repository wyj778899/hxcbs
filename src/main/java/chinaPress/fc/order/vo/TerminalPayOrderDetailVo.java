package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TerminalPayOrderDetailVo {

	/**
	 * 订单id
	 */
	private Integer id;

	/**
	 * 订单编码
	 */
	private String code;

	/**
	 * 支付状态
	 */
	private Integer payStatus;

	/**
	 * 支付金额
	 */
	private BigDecimal payAmount;

	/**
	 * 订单创建时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date createTime;

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
	 * 课程有效期
	 */
	private Integer courseNumber;

	/**
	 * 申请id
	 */
	private Integer applyId;

	/**
	 * 申请人数
	 */
	private Integer applyCount;

	/**
	 * 书籍id集合
	 */
	private List<Integer> bookIds;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
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

	/**
	 * 获取：bookIds
	 */
	public List<Integer> getBookIds() {
		return bookIds;
	}

	/**
	 * 设置：bookIds
	 */
	public void setBookIds(List<Integer> bookIds) {
		this.bookIds = bookIds;
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
	 * 获取：courseNumber
	 */
	public Integer getCourseNumber() {
		return courseNumber;
	}

	/**
	 * 设置：courseNumber
	 */
	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * 获取：payStatus
	 */
	public Integer getPayStatus() {
		return payStatus;
	}

	/**
	 * 设置：payStatus
	 */
	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	/**
	 * 获取：applyId
	 */
	public Integer getApplyId() {
		return applyId;
	}

	/**
	 * 设置：applyId
	 */
	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	/**
	 * 获取：applyCount
	 */
	public Integer getApplyCount() {
		return applyCount;
	}

	/**
	 * 设置：applyCount
	 */
	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}
}
