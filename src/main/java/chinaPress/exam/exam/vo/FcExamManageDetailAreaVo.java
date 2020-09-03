package chinaPress.exam.exam.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamManageDetailAreaVo {
	/**
	 * 考试设置报名区域id
	 */
	private Integer id;
	/**
	 * 考试报名区域id
	 */
	private Integer examSignupAreaId;
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
	 * 关联课程
	 */
	private String courseName;
	/**
	 * 考试形式
	 */
	private String examForm;
	/**
	 * 关联证书
	 */
	private String certName;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the examSignupAreaId
	 */
	public Integer getExamSignupAreaId() {
		return examSignupAreaId;
	}

	/**
	 * @param examSignupAreaId the examSignupAreaId to set
	 */
	public void setExamSignupAreaId(Integer examSignupAreaId) {
		this.examSignupAreaId = examSignupAreaId;
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
	 * @return the certName
	 */
	public String getCertName() {
		return certName;
	}

	/**
	 * @param certName the certName to set
	 */
	public void setCertName(String certName) {
		this.certName = certName;
	}
}
