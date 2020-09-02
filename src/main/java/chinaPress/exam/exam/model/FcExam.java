package chinaPress.exam.exam.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_exam
 * 
 * @author Administrator
 * @date 2020-08-24 16:46:47
 */
public class FcExam {
	/**
	 * 考试表
	 */
	private Integer id;

	/**
	 * 考试名称
	 */
	private String examName;

	/**
	 * 省
	 */
	private String province;

	/**
	 * 市
	 */
	private String city;

	/**
	 * 区
	 */
	private String area;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 考试报名表
	 */
	private Integer signupId;

	/**
	 * 考试报名区域id
	 */
	private Integer signupAreaId;

	/**
	 * 考试类型(1自测 2认证考试)
	 */
	private Integer examType;

	/**
	 * 关联试卷
	 */
	private Integer paperId;

	/**
	 * 考试形式(1关联课程 2关联分组)
	 */
	private Integer examForm;

	/**
	 * 课程id或分组id
	 */
	private Integer examFormId;

	/**
	 * 开始时间
	 */
	private Date startTime;

	/**
	 * 结束时间
	 */
	private Date endTime;

	/**
	 * 关联课程
	 */
	private Integer courseId;

	/**
	 * 关联分组
	 */
	private Integer groupId;

	/**
	 * 是否允许补考(1允许,0不允许)
	 */
	private Integer againType;

	/**
	 * 补考价格
	 */
	private BigDecimal againPrice;

	/**
	 * 考试分数
	 */
	private String grade;

	/**
	 * 考试及格评语
	 */
	private String passComment;

	/**
	 * 考试不及格评语
	 */
	private String failComment;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新人
	 */
	private Integer updateId;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 考试表
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 考试表
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 考试名称
	 * 
	 * @return examName
	 */
	public String getExamName() {
		return examName;
	}

	/**
	 * 考试名称
	 * 
	 * @param examName
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}

	/**
	 * 省
	 * 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 省
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 市
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 市
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 区
	 * 
	 * @return area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 区
	 * 
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 详细地址
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 详细地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 考试报名表
	 * 
	 * @return signupId
	 */
	public Integer getSignupId() {
		return signupId;
	}

	/**
	 * 考试报名表
	 * 
	 * @param signupId
	 */
	public void setSignupId(Integer signupId) {
		this.signupId = signupId;
	}

	/**
	 * 考试报名区域id
	 * 
	 * @return signupAreaId
	 */
	public Integer getSignupAreaId() {
		return signupAreaId;
	}

	/**
	 * 考试报名区域id
	 * 
	 * @param signupAreaId
	 */
	public void setSignupAreaId(Integer signupAreaId) {
		this.signupAreaId = signupAreaId;
	}

	/**
	 * 考试类型(1自测 2认证考试)
	 * 
	 * @return examType
	 */
	public Integer getExamType() {
		return examType;
	}

	/**
	 * 考试类型(1自测 2认证考试)
	 * 
	 * @param examType
	 */
	public void setExamType(Integer examType) {
		this.examType = examType;
	}

	/**
	 * 考试形式(1关联课程 2关联分组)
	 * 
	 * @return examForm
	 */
	public Integer getExamForm() {
		return examForm;
	}

	/**
	 * 考试形式(1关联课程 2关联分组)
	 * 
	 * @param examForm
	 */
	public void setExamForm(Integer examForm) {
		this.examForm = examForm;
	}

	/**
	 * @return the examFormId
	 */
	public Integer getExamFormId() {
		return examFormId;
	}

	/**
	 * @param examFormId the examFormId to set
	 */
	public void setExamFormId(Integer examFormId) {
		this.examFormId = examFormId;
	}

	/**
	 * 开始时间
	 * 
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 开始时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 结束时间
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 结束时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 关联课程
	 * 
	 * @return courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * 关联课程
	 * 
	 * @param courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * 关联分组
	 * 
	 * @return groupId
	 */
	public Integer getGroupId() {
		return groupId;
	}

	/**
	 * 关联分组
	 * 
	 * @param groupId
	 */
	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	/**
	 * 是否允许补考(1允许,0不允许)
	 * 
	 * @return againType
	 */
	public Integer getAgainType() {
		return againType;
	}

	/**
	 * 是否允许补考(1允许,0不允许)
	 * 
	 * @param againType
	 */
	public void setAgainType(Integer againType) {
		this.againType = againType;
	}

	/**
	 * 补考价格
	 * 
	 * @return againPrice
	 */
	public BigDecimal getAgainPrice() {
		return againPrice;
	}

	/**
	 * 补考价格
	 * 
	 * @param againPrice
	 */
	public void setAgainPrice(BigDecimal againPrice) {
		this.againPrice = againPrice;
	}

	/**
	 * 考试分数
	 * 
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 考试分数
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 考试及格评语
	 * 
	 * @return passComment
	 */
	public String getPassComment() {
		return passComment;
	}

	/**
	 * 考试及格评语
	 * 
	 * @param passComment
	 */
	public void setPassComment(String passComment) {
		this.passComment = passComment;
	}

	/**
	 * 考试不及格评语
	 * 
	 * @return failComment
	 */
	public String getFailComment() {
		return failComment;
	}

	/**
	 * 考试不及格评语
	 * 
	 * @param failComment
	 */
	public void setFailComment(String failComment) {
		this.failComment = failComment;
	}

	/**
	 * 创建人
	 * 
	 * @return createId
	 */
	public Integer getCreateId() {
		return createId;
	}

	/**
	 * 创建人
	 * 
	 * @param createId
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 更新人
	 * 
	 * @return updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * 更新人
	 * 
	 * @param updateId
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * @return the paperId
	 */
	public Integer getPaperId() {
		return paperId;
	}

	/**
	 * @param paperId the paperId to set
	 */
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
}