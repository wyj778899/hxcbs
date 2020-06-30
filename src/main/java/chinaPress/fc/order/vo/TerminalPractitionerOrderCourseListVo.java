package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TerminalPractitionerOrderCourseListVo {

	/**
	 * 课程id
	 */
	private Integer id;

	/**
	 * 课程封面
	 */
	private String photo;
	
	/**
	 * 课程名称
	 */
	private String name;

	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date startTime;

	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date endTime;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 总章节
	 */
	private Integer totalCount;

	/**
	 * 已看章节
	 */
	private Integer haveCount;

	/**
	 * 状态：1.学习中，2.已完成
	 */
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getHaveCount() {
		return haveCount;
	}

	public void setHaveCount(Integer haveCount) {
		this.haveCount = haveCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
