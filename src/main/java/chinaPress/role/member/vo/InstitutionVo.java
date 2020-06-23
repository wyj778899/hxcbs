package chinaPress.role.member.vo;

/**
 * 展示培训机构信息
 * @author Administrator
 *
 */
public class InstitutionVo {

	/**
	 * 编号
	 */
	private Integer id;
	
	/**
	 * 公司名称
	 */
	private String name;
	
	/**
	 * 企业统一编码
	 */
	private String code;
	
	/**
	 * 企业法人
	 */
	private String legalPerson;
	
	/**
	 * 企业法人证件号
	 */
	private String certificateNumber;
	
	/**
	 * 注册人姓名
	 */
	private String registerName;
	
	/**
	 * 注册人手机号
	 */
	private String registerTell;
	
	
	/**
	 * 审核状态
	 */
	private Integer auditStatus;
	
	

	public Integer getAuditStatus() {
		return auditStatus;
	}

	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getRegisterName() {
		return registerName;
	}

	public void setRegisterName(String registerName) {
		this.registerName = registerName;
	}

	public String getRegisterTell() {
		return registerTell;
	}

	public void setRegisterTell(String registerTell) {
		this.registerTell = registerTell;
	}
	
	
	
	
}
