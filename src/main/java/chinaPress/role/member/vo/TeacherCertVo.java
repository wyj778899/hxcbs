package chinaPress.role.member.vo;

/**
 * 教师证书显示字段    20200709  add
 * @author wyj
 *
 */
public class TeacherCertVo {

	/**
	 * 教师名称
	 */
	private String name;
	
	/**
	 * 教师身份证号
	 */
	private String certificateNumber;
	
	/**
	 * 证书编码
	 */
	private String certCode;
	
	/**
	 * 证书图片
	 */
	private String certPhoto;
	
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

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

	public String getCertPhoto() {
		return certPhoto;
	}

	public void setCertPhoto(String certPhoto) {
		this.certPhoto = certPhoto;
	}

		

}
