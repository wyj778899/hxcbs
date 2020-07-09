package chinaPress.fc.order.vo;

import chinaPress.common.param.PageParam;

public class TerminalOrderListParam extends PageParam {

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
	private String courseName;

	/**
	 * 支付状态（1.未支付2.已支付）
	 */
	private Integer payStatus;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}
}
