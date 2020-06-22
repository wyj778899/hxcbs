package chinaPress.fc.self_test.vo;

import chinaPress.common.param.PageParam;

public class FcSelfTestListParam extends PageParam {

	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 角色类型（1.家长2.从业者）
	 */
	private Integer roleType;

	/**
	 * 课程名称
	 */
	private String courseName;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

}
