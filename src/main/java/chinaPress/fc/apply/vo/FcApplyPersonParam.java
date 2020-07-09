package chinaPress.fc.apply.vo;

public class FcApplyPersonParam {

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
	 * 民族
	 */
	private String ethnic;

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
	 * 籍贯
	 */
	private String nativePlace;

	/**
	 * 户籍地址
	 */
	private String censusAddress;

	/**
	 * 单位地址
	 */
	private String institutionAddress;

	/**
	 * 邮寄地址
	 */
	private String mailingAddress;

	/**
	 * 学历
	 */
	private String education;

	/**
	 * 机构名称
	 */
	private String institutionName;

	/**
	 * 角色类型（1.家长2.从业者）
	 */
	private Integer roleType;

	/**
	 * 数据错误类型0.正确1.课程正在学习中，不可报名2.该手机号用户为机构角色，不可报名3.该手机号为注册用户角色，不可报名
	 */
	private Integer errorType;

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
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

	public String getCensusAddress() {
		return censusAddress;
	}

	public void setCensusAddress(String censusAddress) {
		this.censusAddress = censusAddress;
	}

	public String getInstitutionAddress() {
		return institutionAddress;
	}

	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
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

	/**
	 * 获取：errorType
	 */
	public Integer getErrorType() {
		return errorType;
	}

	/**
	 * 设置：errorType
	 */
	public void setErrorType(Integer errorType) {
		this.errorType = errorType;
	}
}
