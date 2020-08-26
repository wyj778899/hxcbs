package chinaPress.exam.exam.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamManageDetailUserVo {
	/**
	 * 考试用户id
	 */
	private Integer examUserId;
	/**
	 * 考试报名用户id
	 */
	private Integer examSignupUserId;
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
	 * 姓名
	 */
	private String userName;
	/**
	 * 学历
	 */
	private String education;
	/**
	 * 手机号
	 */
	private String tellPhone;
	/**
	 * 身份证号
	 */
	private String certificateNumber;
	/**
	 * 补考次数
	 */
	private Integer againCount;

	/**
	 * @return the examUserId
	 */
	public Integer getExamUserId() {
		return examUserId;
	}

	/**
	 * @param examUserId the examUserId to set
	 */
	public void setExamUserId(Integer examUserId) {
		this.examUserId = examUserId;
	}

	/**
	 * @return the examSignupUserId
	 */
	public Integer getExamSignupUserId() {
		return examSignupUserId;
	}

	/**
	 * @param examSignupUserId the examSignupUserId to set
	 */
	public void setExamSignupUserId(Integer examSignupUserId) {
		this.examSignupUserId = examSignupUserId;
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the education
	 */
	public String getEducation() {
		return education;
	}

	/**
	 * @param education the education to set
	 */
	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * @return the tellPhone
	 */
	public String getTellPhone() {
		return tellPhone;
	}

	/**
	 * @param tellPhone the tellPhone to set
	 */
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	/**
	 * @return the certificateNumber
	 */
	public String getCertificateNumber() {
		return certificateNumber;
	}

	/**
	 * @param certificateNumber the certificateNumber to set
	 */
	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
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
}
