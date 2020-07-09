package chinaPress.fc.apply.vo;

public class TerminalApplyPersonListVo {

	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别（1.男2.女）
	 */
	private Integer sex;

	/**
	 * 民族
	 */
	private String ethnic;

	/**
	 * 学历
	 */
	private String education;

	/**
	 * 证件号码
	 */
	private String certificateNumber;

	/**
	 * 手机号
	 */
	private String tellPhone;

	/**
	 * 岗位
	 */
	private String post;

	/**
	 * 工作年限
	 */
	private Integer workYear;

	/**
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 户籍地址
	 */
	private String censusAddress;

	/**
	 * 工作所在详细地址
	 */
	private String institutionAddress;

	/**
	 * 邮寄地址
	 */
	private String mailingAddress;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
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

	public Integer getWorkYear() {
		return workYear;
	}

	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}

	public String getCensusAddress() {
		return censusAddress;
	}

	public void setCensusAddress(String censusAddress) {
		this.censusAddress = censusAddress;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	/**
	 * 获取：nativePlace
	 */
	public String getNativePlace() {
		return nativePlace;
	}

	/**
	 * 设置：nativePlace
	 */
	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	/**
	 * 获取：institutionAddress
	 */
	public String getInstitutionAddress() {
		return institutionAddress;
	}

	/**
	 * 设置：institutionAddress
	 */
	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}

	/**
	 * 获取：mailingAddress
	 */
	public String getMailingAddress() {
		return mailingAddress;
	}

	/**
	 * 设置：mailingAddress
	 */
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	/**
	 * 获取：ethnic
	 */
	public String getEthnic() {
		return ethnic;
	}

	/**
	 * 设置：ethnic
	 */
	public void setEthnic(String ethnic) {
		this.ethnic = ethnic;
	}
}
