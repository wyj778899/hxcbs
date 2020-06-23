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

	/**
	 * 状态：1.学习中，2.已完成
	 */
	private Integer status;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
