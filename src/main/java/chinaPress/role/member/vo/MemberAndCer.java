package chinaPress.role.member.vo;

/**
 * 用于员工信息对应证书信息返回数据
 * @author Administrator
 *
 */
public class MemberAndCer {
	
	/**
	 * 序号
	 */
	private Integer id;
	
	/**
	 * 证书头像
	 */
	private String photo;
	
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 手机号
	 */
	private String tellPhone;
	
	/**
	 * 性别
	 */
	private String sex;
	
	
	/**
	 * 证书类型
	 */
	private String certificateType;
	
	
	/**
	 * 审核人
	 */
	private String userName;
	
	/**
	 * 审核状态
	 */
	private String auditStatus;

	
	/**
     * 证书图片
     * @return photo
     */
	public String getPhoto() {
		return photo;
	}

	/**
     * 证书图片
     * @param photo
     */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
     * 证书编号
     * @return id
     */
	public Integer getId() {
		return id;
	}

	/**
     * 证书编号
     * @param id
     */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
     * 用户名
     * @return name
     */
	public String getName() {
		return name;
	}

	/**
     * 用户名
     * @param name
     */
	public void setName(String name) {
		this.name = name;
	}

	/**
     * 手机号
     * @return tellPhone
     */
	public String getTellPhone() {
		return tellPhone;
	}

	/**
     * 手机号
     * @param tellPhone
     */
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	/**
     * 性别
     * @return sex
     */
	public String getSex() {
		return sex;
	}

	/**
     * 性别
     * @param sex
     */
	public void setSex(String sex) {
		this.sex = sex;
	}

	/**
     * 证书类型
     * @return certificateType
     */
	public String getCertificateType() {
		return certificateType;
	}

	/**
     * 证书类型
     * @param certificateType
     */
	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	/**
     * 审核人
     * @return userName
     */
	public String getUserName() {
		return userName;
	}

	/**
     * 审核人
     * @param userName
     */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
     * 审核状态
     * @return auditStatus
     */
	public String getAuditStatus() {
		return auditStatus;
	}

	/**
     * 审核状态
     * @param auditStatus
     */
	public void setAuditStatus(String auditStatus) {
		this.auditStatus = auditStatus;
	}
	
	
	
}
