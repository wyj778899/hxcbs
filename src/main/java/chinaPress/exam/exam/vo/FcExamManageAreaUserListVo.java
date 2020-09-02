package chinaPress.exam.exam.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamManageAreaUserListVo {
	/**
	 * id
	 */
	private Integer id;
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
	 * 所在机构
	 */
	private String institutionName;
	/**
	 * 职务/职称
	 */
	private String post;
	/**
	 * 考试状态
	 */
	private String status;
	/**
	 * 成绩
	 */
	private Double score;
	/**
	 * 发证时间
	 */
	@JsonFormat(pattern = "yyyy/MM/dd", timezone = "GMT+8")
	private Date certificationTime;
	/**
	 * 证书编号
	 */
	private String certificationCode;
	/**
	 * 考试地点
	 */
	private String examAddress;

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
	 * @return the institutionName
	 */
	public String getInstitutionName() {
		return institutionName;
	}

	/**
	 * @param institutionName the institutionName to set
	 */
	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the score
	 */
	public Double getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(Double score) {
		this.score = score;
	}

	/**
	 * @return the certificationTime
	 */
	public Date getCertificationTime() {
		return certificationTime;
	}

	/**
	 * @param certificationTime the certificationTime to set
	 */
	public void setCertificationTime(Date certificationTime) {
		this.certificationTime = certificationTime;
	}

	/**
	 * @return the certificationCode
	 */
	public String getCertificationCode() {
		return certificationCode;
	}

	/**
	 * @param certificationCode the certificationCode to set
	 */
	public void setCertificationCode(String certificationCode) {
		this.certificationCode = certificationCode;
	}

	/**
	 * @return the examAddress
	 */
	public String getExamAddress() {
		return examAddress;
	}

	/**
	 * @param examAddress the examAddress to set
	 */
	public void setExamAddress(String examAddress) {
		this.examAddress = examAddress;
	}
}
