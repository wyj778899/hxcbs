package chinaPress.fc.apply.vo;

import java.math.BigDecimal;
import java.util.Date;

public class TerminalPractitionerApplyDetailVo {

	/**
	 * 
	 */
	private Integer id;

	/**
	 * 申请时间
	 */
	private Date applyTime;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 课程使用天数
	 */
	private Integer courseNumber;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 年龄
	 */
	private Integer age;

	/**
	 * 性别（1.男2，女）
	 */
	private Integer sex;

	/**
	 * 手机号
	 */
	private String tellPhone;

	/**
	 * 证件号码
	 */
	private String certificateNumber;

	/**
	 * 审核状态（1.待审核2.已审核3.已驳回）
	 */
	private Integer auditStatus;

	/**
	 * 驳回消息
	 */
	private String reasonMessage;

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

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
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

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}
}
