package chinaPress.fc.order.vo;

import chinaPress.common.param.PageParam;

public class TerminalPractitionerOrderCourseListParam extends PageParam {

	/**
	 * 角色类型（1.机构2.家长3.从业者）
	 */
	private Integer roleType;

	/**
	 * 下单角色id
	 */
	private Integer roleId;

	/**
	 * 课程名称
	 */
	private Integer courseName;

	public Integer getRoleType() {
		return roleType;
	}

	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public Integer getCourseName() {
		return courseName;
	}

	public void setCourseName(Integer courseName) {
		this.courseName = courseName;
	}
}
