package chinaPress.fc.apply.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TerminalInstitutionApplyDetailVo {

	/**
	 * 报名
	 */
	private Integer id;

	/**
	 * 课程id
	 */
	private Integer courseId;

	/**
	 * 课程名称
	 */
	private Integer courseName;

	/**
	 * 申请人数
	 */
	private Integer applyCount;

	/**
	 * 申请时间
	 */
	private Date applyTime;

	/**
	 * 视频数量
	 */
	private Integer videoNumber;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 审核状态（1.待审核2.已审核3.已驳回）
	 */
	private Integer auditStatus;

	/**
	 * 驳回消息
	 */
	private String reasonMessage;

	/**
	 * 课程使用天数
	 */
	private Integer courseNumber;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCourseName() {
		return courseName;
	}

	public void setCourseName(Integer courseName) {
		this.courseName = courseName;
	}

	public Integer getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(Integer applyCount) {
		this.applyCount = applyCount;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public String getReasonMessage() {
		return reasonMessage;
	}

	public void setReasonMessage(String reasonMessage) {
		this.reasonMessage = reasonMessage;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public Integer getVideoNumber() {
		return videoNumber;
	}

	public void setVideoNumber(Integer videoNumber) {
		this.videoNumber = videoNumber;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
