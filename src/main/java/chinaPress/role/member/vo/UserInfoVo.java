package chinaPress.role.member.vo;


/**
 * 注册用户实体类  20200717    终端管理员档案
 * @author wyj
 *
 */
public class UserInfoVo {

	
	/**
	 * 编号
	 */
	private Integer id;

	/**
	 * 名称
	 */
	private String name;
	
	/**
	 * 手机号
	 */
	private String tellPhone;
	
	/**
	 * 是否有效
	 */
	private String state;

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

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	
	
}
