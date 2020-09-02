package chinaPress.exam.exam_signup.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamSignupUserDetailVo {
	/**
	 * 考试报名id
	 */
	private Integer id;
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
	 * 地址
	 */
	private String address;
	/**
	 * 详细地址
	 */
	private String detailAddress;
	/**
	 * 所在机构
	 */
	private String institution;
	/**
	 * 职务职称
	 */
	private String post;
	/**
	 * 身份证正面
	 */
	private String certificateFront;
	/**
	 * 身份证反面
	 */
	private String certificateBehind;
	/**
	 * 手持身份证
	 */
	private String certificateHand;
	/**
	 * 审核状态0.未审核1.已审核2.已驳回
	 */
	private Integer auditStatus;
	/**
	 * 驳回原因
	 */
	private String rejectReason;
	/**
	 * 报名区域
	 */
	private String signupArea;
	/**
	 * 区域开始时间
	 */
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Date areaStartTime;
	/**
	 * 区域结束时间
	 */
	@JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
	private Date areaEndTime;

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
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * @return the detailAddress
	 */
	public String getDetailAddress() {
		return detailAddress;
	}

	/**
	 * @param detailAddress the detailAddress to set
	 */
	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	/**
	 * @return the institution
	 */
	public String getInstitution() {
		return institution;
	}

	/**
	 * @param institution the institution to set
	 */
	public void setInstitution(String institution) {
		this.institution = institution;
	}

	/**
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @return the certificateFront
	 */
	public String getCertificateFront() {
		return certificateFront;
	}

	/**
	 * @param certificateFront the certificateFront to set
	 */
	public void setCertificateFront(String certificateFront) {
		this.certificateFront = certificateFront;
	}

	/**
	 * @return the certificateBehind
	 */
	public String getCertificateBehind() {
		return certificateBehind;
	}

	/**
	 * @param certificateBehind the certificateBehind to set
	 */
	public void setCertificateBehind(String certificateBehind) {
		this.certificateBehind = certificateBehind;
	}

	/**
	 * @return the certificateHand
	 */
	public String getCertificateHand() {
		return certificateHand;
	}

	/**
	 * @param certificateHand the certificateHand to set
	 */
	public void setCertificateHand(String certificateHand) {
		this.certificateHand = certificateHand;
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
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * @param rejectReason the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}

	/**
	 * @return the signupArea
	 */
	public String getSignupArea() {
		return signupArea;
	}

	/**
	 * @param signupArea the signupArea to set
	 */
	public void setSignupArea(String signupArea) {
		this.signupArea = signupArea;
	}

	/**
	 * @return the areaStartTime
	 */
	public Date getAreaStartTime() {
		return areaStartTime;
	}

	/**
	 * @param areaStartTime the areaStartTime to set
	 */
	public void setAreaStartTime(Date areaStartTime) {
		this.areaStartTime = areaStartTime;
	}

	/**
	 * @return the areaEndTime
	 */
	public Date getAreaEndTime() {
		return areaEndTime;
	}

	/**
	 * @param areaEndTime the areaEndTime to set
	 */
	public void setAreaEndTime(Date areaEndTime) {
		this.areaEndTime = areaEndTime;
	}
}
