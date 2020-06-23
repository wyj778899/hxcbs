package chinaPress.fc.order.vo;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TerminalInstitutionOrderDetailVo {

	/**
	 * 订单id
	 */
	private Integer id;

	/**
	 * 课程id
	 */
	private Integer courseId;

	/**
	 * 订单编码
	 */
	private String code;

	/**
	 * 支付状态（1.未支付2.已支付）
	 */
	private Integer payStatus;

	/**
	 * 开始日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
	 * 结束日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 视频数量
	 */
	private Integer videoNumber;

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

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(Integer videoNumber) {
		this.videoNumber = videoNumber;
	}
}
