package chinaPress.role.member.vo;


/**
 * 证书信息    20200709     add
 * @author wyj
 *
 */
public class CertVo {
	
	/**
	 * 教师头像
	 */
	private String head;
	
	/**
	 * 教师名称
	 */
	private String name;
	
	/**
	 * 证件编号
	 */
	private String certificateNumber;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 证书图片
	 */
	private String photo;
	
	/**
	 * 证书编码
	 */
	private String certCode;
	
	/**
	 * 证书分数
	 */
	private String grade;

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
}
