package chinaPress.fc.apply.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TerminalApplyListVo {

	/**
	 * 报名
	 */
	private Integer id;

	/**
	 * 申请时间
	 */
	@JsonFormat(pattern = "yyyy/MM/dd")
	private Date applyTime;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 学员数量
	 */
	private Integer studentsNumber;

	/**
	 * 课程使用天数
	 */
	private Integer courseNumber;

	/**
	 * 审核状态（1.待审核2.已审核3.已驳回）
	 */
	private Integer auditStatus;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
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

	public Integer getStudentsNumber() {
		return studentsNumber;
	}

	public void setStudentsNumber(Integer studentsNumber) {
		this.studentsNumber = studentsNumber;
	}

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}
}
