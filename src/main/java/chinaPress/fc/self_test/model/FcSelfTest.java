package chinaPress.fc.self_test.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_self_test
 * 
 * @author Chaoqun
 * @date 2020-06-19 16:07:48
 */
public class FcSelfTest {
	/**
	 * 自测
	 */
	private Integer id;

	/**
	 * 角色id
	 */
	private Integer roleId;

	/**
	 * 角色类型（1.家长2.从业者）
	 */
	private Integer roleType;

	/**
	 * 课程id
	 */
	private Integer courseId;

	/**
	 * 分数
	 */
	private BigDecimal score;

	/**
	 * 是否通过
	 */
	private Integer isPass;

	/**
	 * 状态（0.否1.是）
	 */
	private Integer state;

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
	 * 自测
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 自测
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * 课程id
	 * 
	 * @return courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * 课程id
	 * 
	 * @param courseId
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	/**
	 * 是否通过
	 * 
	 * @return isPass
	 */
	public Integer getIsPass() {
		return isPass;
	}

	/**
	 * 是否通过
	 * 
	 * @param isPass
	 */
	public void setIsPass(Integer isPass) {
		this.isPass = isPass;
	}

	/**
	 * 状态（0.否1.是）
	 * 
	 * @return state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 状态（0.否1.是）
	 * 
	 * @param state
	 */
	public void setState(Integer state) {
		this.state = state;
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

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}
}