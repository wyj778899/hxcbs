package chinaPress.role.member.vo;

/**
 * 用户信息用于发布优惠券
 * @author Administrator
 *
 */
public class MemberCouponInfo {

	
	/**
	 * 编号
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String name;
	
	/**
	 * 手机号
	 */
	private String tellPhone;
	
	/**
	 * 所属类型
	 */
	private Integer roleType;
	
	/**
	 * 角色id
	 */
	private Integer roleId;
	
	/**
	 * 角色名称
	 */
	private String RoleName;
	
	
	
	
	

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return RoleName;
	}

	public void setRoleName(String roleName) {
		RoleName = roleName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
	
}
