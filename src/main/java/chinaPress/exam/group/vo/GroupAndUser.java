package chinaPress.exam.group.vo;

/**
 * 分组的用户信息
 * @author wyj
 *
 */
public class GroupAndUser {

	/**
	 * 分组id
	 */
	private Integer groupId;
	
	/**
	 * 分组名称
	 */
	private String groupName;
	
	/**
	 * 分组人员
	 */
	private String userName;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
