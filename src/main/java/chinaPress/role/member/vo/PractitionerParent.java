package chinaPress.role.member.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	private String sex;
	
	/**
	 * 孩子生日
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date birthdayTime;

	public Date getBirthdayTime() {
		return birthdayTime;
	}

	public void setBirthdayTime(Date birthdayTime) {
		this.birthdayTime = birthdayTime;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
