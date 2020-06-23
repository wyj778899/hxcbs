package chinaPress.fc.apply.vo;

import java.util.Date;

public class TerminalApplyListVo {

	/**
	 * 报名
	 */
	private Integer id;

	/**
	 * 申请时间
	 */
	private Date applyTime;

	/**
	 * 课程名称
	 */
	private Integer courseName;

	/**
	 * 课程价格
	 */
	private Integer coursePrice;

	/**
	 * 学员数量
	 */
	private Integer studentsNumber;

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

	public Integer getCourseName() {
		return courseName;
	}

	public void setCourseName(Integer courseName) {
		this.courseName = courseName;
	}

	public Integer getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(Integer coursePrice) {
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
}
