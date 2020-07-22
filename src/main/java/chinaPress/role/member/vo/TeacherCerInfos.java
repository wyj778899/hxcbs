package chinaPress.role.member.vo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 20200713    wyj add
 * 一个教师对应多个证书返回      发证日期，发证机构，证书编号
 * @author Administrator
 *
 */
public class TeacherCerInfos {

	/**
	 * 教师名称
	 */
	private String teaName;
	
	
	/**
	 * 教师头像
	 */
	private String head;
	
	/**
	 * 机构名称
	 */
	private String institutionName;
	
	/**
	 * 身份证号
	 */
	private String certificateNumber;
	
	/**
	 * 证书信息
	 */
	private List<CertInfo> certs;

	
	/**
	 * 分数
	 */
	private BigDecimal source;

	
	public BigDecimal getSource() {
		return source;
	}

	public void setSource(BigDecimal source) {
		this.source = source;
	}

	public String getTeaName() {
		return teaName;
	}

	public void setTeaName(String teaName) {
		this.teaName = teaName;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public List<CertInfo> getCerts() {
		return certs;
	}

	public void setCerts(List<CertInfo> certs) {
		this.certs = certs;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}
	
	
}
