package chinaPress.role.member.vo;

/**
 * 用于从业者数据返回
 * @author Administrator
 *
 */
public class PractitionerEmps {

	/**
	 * 编号
	 */
	private Integer id;
	
	
	/**
	 * 用户名
	 */
	private String name;
	
	
	/**
	 * 手机号
	 */
	private String tellPhone;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	/**
	 * 证件号
	 */
	private String certificateNumber;
	
	/**
	 * 所在地
	 */
	private String address;

	/**
	 * 真实姓名
	 */
	private String realName;
	

	public String getRealName() {
		return realName;
	}


	public void setRealName(String realName) {
		this.realName = realName;
	}


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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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
