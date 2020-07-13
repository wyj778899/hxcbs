package chinaPress.role.member.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 20200713   wyj   add
 * 证书信息
 * @author Administrator
 *
 */
public class CertInfo {

	/**
	 * 证书id
	 */
	private Integer certId;
	
	/**
	 * 证书头像
	 */
	private String certPhoto;
	
	/**
	 * 证书名称
	 */
	private String certName;
	
	/**
	 * 证书编码
	 */
	private String certCode;
	
	/**
	 * 分数
	 */
	private String grade;
	
	/**
	 * 发证时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date certificateTime;
	
	/**
	 * 发证机构
	 */
	private String tetsAddress;


	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}


	public Date getCertificateTime() {
		return certificateTime;
	}

	public void setCertificateTime(Date certificateTime) {
		this.certificateTime = certificateTime;
	}

	

	public String getTetsAddress() {
		return tetsAddress;
	}

	public void setTetsAddress(String tetsAddress) {
		this.tetsAddress = tetsAddress;
	}

	public Integer getCertId() {
		return certId;
	}

	public void setCertId(Integer certId) {
		this.certId = certId;
	}

	public String getCertPhoto() {
		return certPhoto;
	}

	public void setCertPhoto(String certPhoto) {
		this.certPhoto = certPhoto;
	}

	public String getCertCode() {
		return certCode;
	}

	public void setCertCode(String certCode) {
		this.certCode = certCode;
	}

}
