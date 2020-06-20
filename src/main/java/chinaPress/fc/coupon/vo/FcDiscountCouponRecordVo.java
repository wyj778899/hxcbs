package chinaPress.fc.coupon.vo;

public class FcDiscountCouponRecordVo {
	/**
	 * 优惠券记录id
	 */
	private Integer id;
	/**
	 * 优惠券编码
	 */
	private String code;
	/**
	 * 发放人名称
	 */
	private String grantRoleName;
	/**
	 * 发放人角色
	 */
	private String grantRoleTypeName;
	/**
	 * 发放时间
	 */
	private String grantTime;
	/**
	 * 发放人手机号
	 */
	private String grantRolePhone;
	/**
	 * 使用状态
	 */
	private String statusName;
	/**
	 * 使用时间
	 */
	private String useTime;

	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置：code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取：grantRoleName
	 */
	public String getGrantRoleName() {
		return grantRoleName;
	}

	/**
	 * 设置：grantRoleName
	 */
	public void setGrantRoleName(String grantRoleName) {
		this.grantRoleName = grantRoleName;
	}

	/**
	 * 获取：grantRoleTypeName
	 */
	public String getGrantRoleTypeName() {
		return grantRoleTypeName;
	}

	/**
	 * 设置：grantRoleTypeName
	 */
	public void setGrantRoleTypeName(String grantRoleTypeName) {
		this.grantRoleTypeName = grantRoleTypeName;
	}

	/**
	 * 获取：grantTime
	 */
	public String getGrantTime() {
		return grantTime;
	}

	/**
	 * 设置：grantTime
	 */
	public void setGrantTime(String grantTime) {
		this.grantTime = grantTime;
	}

	/**
	 * 获取：grantRolePhone
	 */
	public String getGrantRolePhone() {
		return grantRolePhone;
	}

	/**
	 * 设置：grantRolePhone
	 */
	public void setGrantRolePhone(String grantRolePhone) {
		this.grantRolePhone = grantRolePhone;
	}

	/**
	 * 获取：statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * 设置：statusName
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}

	/**
	 * 获取：useTime
	 */
	public String getUseTime() {
		return useTime;
	}

	/**
	 * 设置：useTime
	 */
	public void setUseTime(String useTime) {
		this.useTime = useTime;
	}
}
