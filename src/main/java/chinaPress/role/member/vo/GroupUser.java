package chinaPress.role.member.vo;

/**
 * 分组用户信息
 * @author wyj
 *
 */
public class GroupUser {

	/**
	 * 家长/从业者id
	 */
	private Integer id;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 手机号
	 */
	private String tellPhone;
	
	/**
	 * 角色
	 */
	private String type;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
}
