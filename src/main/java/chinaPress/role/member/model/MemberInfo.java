package chinaPress.role.member.model;

import java.util.Date;

/**
 * role_staff_archives
 * 
 * @author Administrator
 * @date 2020-06-17 13:04:06
 */
public class MemberInfo {
	/**
	 * 员工档案
	 */
	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 头像
	 */
	private String photo;

	/**
	 * 手机号
	 */
	private String tellPhone;

	/**
	 * 邮箱
	 */
	private String email;

	/**
	 * 性别（1.男2，女）
	 */
	private Integer sex;

	/**
	 * 省
	 */
	private String provice;

	/**
	 * 市
	 */
	private String city;

	/**
	 * 区
	 */
	private String area;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 是否启用(0.否1.是)
	 */
	private Integer isStart;

	/**
	 * 状态（0.无效1.有效）
	 */
	private Integer state;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新人
	 */
	private Integer updateId;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 1.员工2.机构3.家长4.从业者5.注册用户
	 */
	private Integer roleType;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String password;

	/**
	 * 当前页数
	 */
	private Integer page;

	/**
	 * 每页显示的条数
	 */
	private Integer limit;

	/**
	 * 审核状态（1.待审核2.已审核3.已驳回）
	 */
	private Integer auditStatus;

	/**
	 * 证书类型（1.教师资格证2.学历证书3.认证行为分析治疗室）
	 */
	private Integer certificateType;

	/**
	 * 验证码 用于添加注册
	 */
	private String verificationCode;
	
	
	/** 
	 * 注册来源   1华夏      2恩起
	 */
	private Integer source;

	
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	/**
	 * 验证码
	 * 
	 * @return verificationCode
	 */
	public String getVerificationCode() {
		return verificationCode;
	}

	/**
	 * 验证码
	 * 
	 * @param verificationCode
	 */
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

	/**
	 * 审核状态
	 * 
	 * @return auditStatus
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * 审核状态
	 * 
	 * @param auditStatus
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * 证书类型
	 * 
	 * @return certificateType
	 */
	public Integer getCertificateType() {
		return certificateType;
	}

	/**
	 * 证书类型
	 * 
	 * @param certificateType
	 */
	public void setCertificateType(Integer certificateType) {
		this.certificateType = certificateType;
	}

	/**
	 * 当前页数
	 * 
	 * @return page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 当前页数
	 * 
	 * @param page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 显示的条数
	 * 
	 * @return limit
	 */
	public Integer getLimit() {
		return limit;
	}

	/**
	 * 显示的条数
	 * 
	 * @param limit
	 */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	/**
	 * 员工档案
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 员工档案
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 姓名
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 姓名
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 头像
	 * 
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 头像
	 * 
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 手机号
	 * 
	 * @return tellPhone
	 */
	public String getTellPhone() {
		return tellPhone;
	}

	/**
	 * 手机号
	 * 
	 * @param tellPhone
	 */
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	/**
	 * 邮箱
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 邮箱
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 性别（1.男2，女）
	 * 
	 * @return sex
	 */
	public Integer getSex() {
		return sex;
	}

	/**
	 * 性别（1.男2，女）
	 * 
	 * @param sex
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}

	/**
	 * 省
	 * 
	 * @return provice
	 */
	public String getProvice() {
		return provice;
	}

	/**
	 * 省
	 * 
	 * @param provice
	 */
	public void setProvice(String provice) {
		this.provice = provice;
	}

	/**
	 * 市
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 市
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 区
	 * 
	 * @return area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 区
	 * 
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 详细地址
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 详细地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 是否启用(0.否1.是)
	 * 
	 * @return isStart
	 */
	public Integer getIsStart() {
		return isStart;
	}

	/**
	 * 是否启用(0.否1.是)
	 * 
	 * @param isStart
	 */
	public void setIsStart(Integer isStart) {
		this.isStart = isStart;
	}

	/**
	 * 状态（0.无效1.有效）
	 * 
	 * @return state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 状态（0.无效1.有效）
	 * 
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
	}

	/**
	 * 创建人
	 * 
	 * @return createId
	 */
	public Integer getCreateId() {
		return createId;
	}

	/**
	 * 创建人
	 * 
	 * @param createId
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 更新人
	 * 
	 * @return updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * 更新人
	 * 
	 * @param updateId
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 角色id
	 * 
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * 角色id
	 * 
	 * @param roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 1.员工2.机构3.家长4.从业者5.注册用户
	 * 
	 * @return roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * 1.员工2.机构3.家长4.从业者5.注册用户
	 * 
	 * @param roleType
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * 用户名
	 * 
	 * @return userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 用户名
	 * 
	 * @param userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 密码
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public MemberInfo() {
		super();
	}

	public MemberInfo(String tellPhone) {
		super();
		this.tellPhone = tellPhone;
	}

	public MemberInfo(Integer roleId, Integer roleType) {
		super();
		this.roleId = roleId;
		this.roleType = roleType;
	}
}