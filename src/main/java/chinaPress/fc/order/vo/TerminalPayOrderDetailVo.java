package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.List;

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
	 * 支付金额
	 */
	private BigDecimal payAmount;

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
}
