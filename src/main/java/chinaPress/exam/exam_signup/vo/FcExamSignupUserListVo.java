package chinaPress.exam.exam_signup.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamSignupUserListVo {
	/**
	 * 报名用户主键id
	 */
	private Integer id;
	/**
	 * 区域
	 */
	private String area;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	/**
	 * 结束时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
	/**
	 * 个人照片
	 */
	private String photo;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 手机号
	 */
	private String phone;
	/**
	 * 身份证号
	 */
	private String certificateNumber;
	/**
	 * 学习进度
	 */
	private String studyProcess;
	/**
	 * 是否补考1.是0.否
	 */
	private Integer isMakeUp;
	/**
	 * 补考次数
	 */
	private Integer makeUp;
	/**
	 * 审核状态0.未审核1.已审核2.已驳回
	 */
	private Integer auditStatus;
	/**
	 * 申请报名角色id
	 */
	private Integer roleId;
	/**
	 * 申请报名角色类型（1.家长2.从业者）
	 */
	private Integer roleType;
	/**
	 * 关联课程id
	 */
	private Integer courseId;

	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 设置：area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取：photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 设置：photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 获取：name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * 设置：education
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * 获取：phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 设置：phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * 获取：certificateNumber
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}

	/**
	 * 设置：certificateNumber
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	/**
	 * 获取：studyProcess
	 */
	public String getStudyProcess() {
		return studyProcess;
	}

	/**
	 * 设置：studyProcess
	 */
	public void setStudyProcess(String studyProcess) {
		this.studyProcess = studyProcess;
	}

	/**
	 * 获取：isMakeUp
	 */
	public Integer getIsMakeUp() {
		return isMakeUp;
	}

	/**
	 * 设置：isMakeUp
	 */
	public void setIsMakeUp(Integer isMakeUp) {
		this.isMakeUp = isMakeUp;
	}

	/**
	 * 获取：makeUp
	 */
	public Integer getMakeUp() {
		return makeUp;
	}

	/**
	 * 设置：makeUp
	 */
	public void setMakeUp(Integer makeUp) {
		this.makeUp = makeUp;
	}

	/**
	 * 获取：auditStatus
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * 设置：auditStatus
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * 获取：roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * 设置：roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 获取：roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * 设置：roleType
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * 获取：courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * 设置：courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
}
