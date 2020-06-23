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
	 * 编号
	 */
	private Integer id;
	
	/**
	 * 类型
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}
	
	
}
