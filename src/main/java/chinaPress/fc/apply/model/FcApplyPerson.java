package chinaPress.fc.apply.model;

import java.util.Date;

/**
 * fc_apply_person
 * @author Chaoqun
 * @date 2020-06-22 11:03:15
 */
public class FcApplyPerson {
    /**
     * 报名关联人员
     */
    private Integer id;

    /**
     * 主表id
     */
    private Integer applyId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色类型（1.家长2.从业者）
     */
    private Integer roleType;

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
     * 报名关联人员
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 报名关联人员
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 主表id
     * @return applyId
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * 主表id
     * @param applyId
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * 角色id
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色类型（1.家长2.从业者）
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 角色类型（1.家长2.从业者）
     * @param roleType
     */
	public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * 创建人
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人
     * @param createId
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 创建时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 更新人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 更新时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}