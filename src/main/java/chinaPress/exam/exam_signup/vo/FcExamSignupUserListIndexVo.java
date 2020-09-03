package chinaPress.exam.exam_signup.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamSignupUserListIndexVo {
	/**
	 * 考试报名id
	 */
	private Integer signupId;
	/**
	 * 考试报名用户id
	 */
	private Integer signupUserId;
	/**
	 * 报名名称
	 */
	private String name;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 审核状态审核状态(0未审核,1已审核,2已驳回,3已报考)
	 */
	private Integer auditStatus;
	/**
	 * 审核状态审核状态(0未审核,1已审核,2已驳回,3已报考)
	 */
	private String auditStatusTxt;
	/**
	 * 考试形式
	 */
	private String examForm;
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
	private String district;
	/**
	 * 详细地址
	 */
	private String address;
	/**
	 * 考试报名开始时间
	 */
	@JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	/**
	 * 考试报名结束时间
	 */
	@JsonFormat(pattern = "yyyy.MM.dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
	/**
	 * 是否开启补考1.是0.不是
	 */
	private Integer isAgain;
	/**
	 * 第几次补考
	 */
	private Integer againCount;
	/**
	 * 补考价格
	 */
	private BigDecimal againPrice;

	/**
	 * @return the signupId
	 */
	public Integer getSignupId() {
		return signupId;
	}

	/**
	 * @param signupId the signupId to set
	 */
	public void setSignupId(Integer signupId) {
		this.signupId = signupId;
	}

	/**
	 * @return the signupUserId
	 */
	public Integer getSignupUserId() {
		return signupUserId;
	}

	/**
	 * @param signupUserId the signupUserId to set
	 */
	public void setSignupUserId(Integer signupUserId) {
		this.signupUserId = signupUserId;
	}

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the auditStatus
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @param auditStatus the auditStatus to set
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @return the auditStatusTxt
	 */
	public String getAuditStatusTxt() {
		return auditStatusTxt;
	}

	/**
	 * @param auditStatusTxt the auditStatusTxt to set
	 */
	public void setAuditStatusTxt(String auditStatusTxt) {
		this.auditStatusTxt = auditStatusTxt;
	}

	/**
	 * @return the examForm
	 */
	public String getExamForm() {
		return examForm;
	}

	/**
	 * @param examForm the examForm to set
	 */
	public void setExamForm(String examForm) {
		this.examForm = examForm;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the isAgain
	 */
	public Integer getIsAgain() {
		return isAgain;
	}

	/**
	 * @param isAgain the isAgain to set
	 */
	public void setIsAgain(Integer isAgain) {
		this.isAgain = isAgain;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the againCount
	 */
	public Integer getAgainCount() {
		return againCount;
	}

	/**
	 * @param againCount the againCount to set
	 */
	public void setAgainCount(Integer againCount) {
		this.againCount = againCount;
	}

	/**
	 * @return the againPrice
	 */
	public BigDecimal getAgainPrice() {
		return againPrice;
	}

	/**
	 * @param againPrice the againPrice to set
	 */
	public void setAgainPrice(BigDecimal againPrice) {
		this.againPrice = againPrice;
	}
}
