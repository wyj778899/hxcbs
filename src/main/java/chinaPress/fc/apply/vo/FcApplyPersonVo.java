package chinaPress.fc.apply.vo;

public class FcApplyPersonVo {
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
	private String sexTxt;
	/**
	 * 手机号
	 */
	private String tellPhone;
	/**
	 * 角色
	 */
	private String typeTxt;

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
	 * 获取：userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * 设置：userName
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 获取：sexTxt
	 */
	public String getSexTxt() {
		return sexTxt;
	}

	/**
	 * 设置：sexTxt
	 */
	public void setSexTxt(String sexTxt) {
		this.sexTxt = sexTxt;
	}

	/**
	 * 获取：tellPhone
	 */
	public String getTellPhone() {
		return tellPhone;
	}

	/**
	 * 设置：tellPhone
	 */
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	/**
	 * 获取：typeTxt
	 */
	public String getTypeTxt() {
		return typeTxt;
	}

	/**
	 * 设置：typeTxt
	 */
	public void setTypeTxt(String typeTxt) {
		this.typeTxt = typeTxt;
	}
}
