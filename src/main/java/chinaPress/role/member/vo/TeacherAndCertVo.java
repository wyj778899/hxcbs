package chinaPress.role.member.vo;

/**
 * 20200709   教师的证书信息
 * @author wyj
 *
 */
public class TeacherAndCertVo {

	/**
	 * 教师编号
	 */
	private Integer teaId;
	
	/**
	 * 证书id
	 */
	private Integer cerId;
	
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private Integer sex;
	
	/**
	 * 证件号
	 */
	private String certificateNumber;
	
	/**
	 * 证书编号
	 */
	private String certCode;
	
	
	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	

	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public Integer getCerId() {
		return cerId;
	}

	public void setCerId(Integer cerId) {
		this.cerId = cerId;
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

	
}
