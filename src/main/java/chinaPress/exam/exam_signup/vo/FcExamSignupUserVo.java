package chinaPress.exam.exam_signup.vo;

/**
 * 考试报名的用户信息封装
 * @author wyj
 *
 */
public class FcExamSignupUserVo {

	/**
	 * 用户id
	 */
	private Integer id;

	/**
	 * 考试id
	 */
	private Integer examId;
	
	/**
	 * 用户头像
	 */
	private String userHead;
	
	/**
	 * 姓名
	 */
	private String userName;
	
	/**
	 * 身份证号
	 */
	private String certificateNumber;
	
	/**
	 * 手机号码
	 */
	private String tellPhone;
	
	/**
	 * 学历
	 */
	private String education;
	
	/**
	 * 身份证前面
	 */
	private String certificateFront;
	
	/**
	 * 身份证后面
	 */
	private String certificateBehind;
	
	/**
	 * 手持身份证
	 */
	private String handCertificate;
	
	/**
	 * 省市区地址
	 */
	private String provinceCityArea;
	
	/**
	 * 详细地址
	 */
	private String address;
	
	/**
	 * 职位
	 */
	private String post;
	
	/**
	 * 机构名称
	 */
	private String institutionName;
	
	/**
	 * 现场和非现场考试   1现场  0非现场
	 */
	private Integer examForm;
	

	public Integer getExamForm() {
		return examForm;
	}

	public void setExamForm(Integer examForm) {
		this.examForm = examForm;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getCertificateFront() {
		return certificateFront;
	}

	public void setCertificateFront(String certificateFront) {
		this.certificateFront = certificateFront;
	}

	public String getCertificateBehind() {
		return certificateBehind;
	}

	public void setCertificateBehind(String certificateBehind) {
		this.certificateBehind = certificateBehind;
	}

	public String getHandCertificate() {
		return handCertificate;
	}

	public void setHandCertificate(String handCertificate) {
		this.handCertificate = handCertificate;
	}

	public String getProvinceCityArea() {
		return provinceCityArea;
	}

	public void setProvinceCityArea(String provinceCityArea) {
		this.provinceCityArea = provinceCityArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}
	
}
