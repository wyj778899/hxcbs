package chinaPress.role.member.vo;

public class PractitionerApplyInfoVo {

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 手机号
	 */
	private String tellPhone;

	/**
	 * 性别（1.男2.女）
	 */
	private Integer sex;

	/**
	 * 证件号码
	 */
	private String certificateNumber;

	/**
	 * 岗位
	 */
	private String post;

	/**
	 * 工作年限
	 */
	private Integer workYear;

	/**
	 * 单位地址
	 */
	private String institutionAddress;

	/**
	 * 学历
	 */
	private String education;

	/**
	 * 1.家长2.从业者
	 */
	private Integer type;

	/**
	 * 公司姓名
	 */
	private String institutionName;

	/**
	 * 民族
	 */
	private String ethnic;

	/**
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 邮寄地址
	 */
	private String mailingAddress;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getWorkYear() {
		return workYear;
	}

	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}

	public String getInstitutionAddress() {
		return institutionAddress;
	}

	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getEthnic() {
		return ethnic;
	}

	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}
}
