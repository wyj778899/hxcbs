package chinaPress.fc.order.model;

import java.util.Date;

/**
 * fc_order_person
 * 
 * @author Chaoqun
 * @date 2020-06-22 17:55:04
 */
public class FcOrderPerson {
	/**
	 * 课程关联人员
	 */
	private Integer id;

	/**
	 * 课程订单id
	 */
	private Integer orderId;

	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 角色类型（1.家长2.从业者）
	 */
	private Integer roleType;

	/**
	 * 总章节数
	 */
	private Integer totalCount;

	/**
	 * 当前看到的章节数
	 */
	private Integer sectionCount;

	/**
	 * 已经看过的数量
	 */
	private Integer haveCount;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新人
	 */
	private Integer updateId;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	/**
	 * 是否是个人（0.否1.是）
	 */
	private Integer isIndividual;

	/**
	 * 课程关联人员
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 课程关联人员
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 课程订单id
	 * 
	 * @return orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 课程订单id
	 * 
	 * @param orderId
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 角色id
	 * 
	 * @return roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * 角色id
	 * 
	 * @param roleId
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	/**
	 * 角色类型（1.家长2.从业者）
	 * 
	 * @return roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * 角色类型（1.家长2.从业者）
	 * 
	 * @param roleType
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * 总章节数
	 * 
	 * @return totalCount
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * 总章节数
	 * 
	 * @param totalCount
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	/**
	 * 当前看到的章节数
	 * 
	 * @return sectionCount
	 */
	public Integer getSectionCount() {
		return sectionCount;
	}

	/**
	 * 当前看到的章节数
	 * 
	 * @param sectionCount
	 */
	public void setSectionCount(Integer sectionCount) {
		this.sectionCount = sectionCount;
	}

	/**
	 * 已经看过的数量
	 * 
	 * @return haveCount
	 */
	public Integer getHaveCount() {
		return haveCount;
	}

	/**
	 * 已经看过的数量
	 * 
	 * @param haveCount
	 */
	public void setHaveCount(Integer haveCount) {
		this.haveCount = haveCount;
	}

	/**
	 * 创建人
	 * 
	 * @return createId
	 */
	public Integer getCreateId() {
		return createId;
	}

	/**
	 * 创建人
	 * 
	 * @param createId
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 更新人
	 * 
	 * @return updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * 更新人
	 * 
	 * @param updateId
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getIsIndividual() {
		return isIndividual;
	}

	public void setIsIndividual(Integer isIndividual) {
		this.isIndividual = isIndividual;
	}
}