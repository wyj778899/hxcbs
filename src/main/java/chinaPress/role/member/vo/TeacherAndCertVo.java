package chinaPress.role.member.vo;

import java.util.List;

/**
 * 20200709   教师的证书信息
 * @author wyj
 *
 */
public class TeacherAndCertVo {

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
	 * 分数
	 */
	private String srouce;
	
	/**
	 * 证书信息
	 */
	private List<CertVo> certs;
	
	

	public String getSrouce() {
		return srouce;
	}

	public void setSrouce(String srouce) {
		this.srouce = srouce;
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

	public List<CertVo> getCerts() {
		return certs;
	}

	public void setCerts(List<CertVo> certs) {
		this.certs = certs;
	}
	
	
	
	
}
