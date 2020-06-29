package chinaPress.fc.apply.vo;

public class FcApplyPersonParam {

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
     * 年龄
     */
    private Integer age;

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
     * 户籍地址
     */
    private String censusAddress;
    
    /**
     * 单位地址
     */
    private String institutionAddress;
    
    /**
     * 学历
     */
    private String education;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
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
}
