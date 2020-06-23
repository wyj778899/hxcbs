package chinaPress.role.member.vo;

/**
 * 家长信息展示
 * @author Administrator
 *
 */
public class PractitionerParent {

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
	 * 性别
	 */
	private Integer sex;

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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
	
	
	
	
}
