package chinaPress.exam.exam_signup.vo;

/**
 * 考生信息
 * @author wyj
 *
 */
public class ExamUserVo {

	/**
	 * 考生id
	 */
	private Integer id;
	
	/**
	 * 考生用户名
	 */
	private String userName;
	
	/**
	 * 考生手机号
	 */
	private String tellPhone;
	
	/**
	 * 考生头像
	 */
	private String 	userHead;

	
	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
	}

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

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}
	
}
