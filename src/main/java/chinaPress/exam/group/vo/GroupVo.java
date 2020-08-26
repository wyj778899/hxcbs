package chinaPress.exam.group.vo;

import java.util.List;

/**
 * 分组的人员信息
 * @author wyj
 *
 */
public class GroupVo {

	/**
	 * 分组id
	 */
	private Integer groupId;
	
	/**
	 * 分组名称
	 */
	private String groupName;
	
	/**
	 * 分组的所有用户信息
	 */
	private List<UserVo> users;


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

	public List<UserVo> getUsers() {
		return users;
	}

	public void setUsers(List<UserVo> users) {
		this.users = users;
	}
	
}
