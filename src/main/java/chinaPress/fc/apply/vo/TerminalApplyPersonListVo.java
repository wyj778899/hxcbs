package chinaPress.fc.apply.vo;

public class TerminalApplyPersonListVo {

	private Integer id;

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
	 * 详细地址
	 */
	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
