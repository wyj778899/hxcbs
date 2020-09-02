package chinaPress.role.comment.vo;

public class FcCommentListVo {
	/**
	 * 评论id
	 */
	private Integer id;
	/**
	 * 用户名
	 */
	private String userName;
	/**
	 * 角色
	 */
	private String roleTypeName;
	/**
	 * 手机号
	 */
	private String tellPhone;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 审核状态
	 */
	private Integer status;
	/**
	 * 审核状态
	 */
	private String statusName;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the roleTypeName
	 */
	public String getRoleTypeName() {
		return roleTypeName;
	}

	/**
	 * @param roleTypeName the roleTypeName to set
	 */
	public void setRoleTypeName(String roleTypeName) {
		this.roleTypeName = roleTypeName;
	}

	/**
	 * @return the tellPhone
	 */
	public String getTellPhone() {
		return tellPhone;
	}

	/**
	 * @param tellPhone the tellPhone to set
	 */
	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
}
