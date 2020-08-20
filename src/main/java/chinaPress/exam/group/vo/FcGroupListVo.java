package chinaPress.exam.group.vo;

import java.util.List;

public class FcGroupListVo {
	/**
	 * 分组id
	 */
	private Integer id;
	/**
	 * 分组名称
	 */
	private String name;
	/**
	 * 分组人
	 */
	private List<FcGroupUserVo> userList;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the userList
	 */
	public List<FcGroupUserVo> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<FcGroupUserVo> userList) {
		this.userList = userList;
	}
}
