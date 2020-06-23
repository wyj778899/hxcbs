package chinaPress.role.member.vo;

/**
 * 用户登陆成功返回的用户信息
 * @author Administrator
 *
 */
public class MemberInfoVo {

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 头像
	 */
	private String photo;
	
	/**
	 * 角色id
	 */
	private Integer roleId;
	
	/**
	 * 角色类型
	 */
	private Integer roleType;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	
	
	
	
}
