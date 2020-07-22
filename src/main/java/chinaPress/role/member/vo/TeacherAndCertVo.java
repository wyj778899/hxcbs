package chinaPress.role.member.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	 * 证书名称
	 */
	private String typeName;
	
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
	
	/**
	 * 发证时间      20200713   添加发证日期字段
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date certificateTime;
	
	public Date getCertificateTime() {
		return certificateTime;
	}

	public void setCertificateTime(Date certificateTime) {
		this.certificateTime = certificateTime;
	}

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

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	
}
