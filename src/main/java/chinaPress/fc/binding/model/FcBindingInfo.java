package chinaPress.fc.binding.model;

import java.util.Date;

/**
 * fc_binding_info
 * @author Administrator
 * @date 2020-06-24 14:49:02
 */
public class FcBindingInfo {
    /**
     *  id
     */
    private Integer id;

    /**
     * 机构id
     */
    private Integer institutionId;

    /**
     * 绑定角色id
     */
    private Integer bindingRoleId;

    /**
     * 绑定角色类型（1.家长2.从业者）
     */
    private Integer bindingRoleType;

    /**
     * 是否处于绑定关系1.绑定0.取消绑定
     */
    private Integer bindingStatus;

    /**
     * 回复状态1.等待中2.已同意3.已拒绝
     */
    private Integer replyStatus;

    /**
     * 绑定时间
     */
    private Date bindingTime;

    /**
     * 取消绑定时间
     */
    private Date cancelBindingTime;

    /**
     * 发起时间
     */
    private Date createTime;

    /**
     *  id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     *  id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 机构id
     * @return institutionId
     */
    public Integer getInstitutionId() {
        return institutionId;
    }

    /**
     * 机构id
     * @param institutionId
     */
    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * 绑定角色id
     * @return bindingRoleId
     */
    public Integer getBindingRoleId() {
        return bindingRoleId;
    }

    /**
     * 绑定角色id
     * @param bindingRoleId
     */
    public void setBindingRoleId(Integer bindingRoleId) {
        this.bindingRoleId = bindingRoleId;
    }

    /**
     * 绑定角色类型（1.家长2.从业者）
     * @return bindingRoleType
     */
    public Integer getBindingRoleType() {
        return bindingRoleType;
    }

    /**
     * 绑定角色类型（1.家长2.从业者）
     * @param bindingRoleType
     */
    public void setBindingRoleType(Integer bindingRoleType) {
        this.bindingRoleType = bindingRoleType;
    }

    /**
     * 是否处于绑定关系1.绑定0.取消绑定
     * @return bindingStatus
     */
    public Integer getBindingStatus() {
        return bindingStatus;
    }

    /**
     * 是否处于绑定关系1.绑定0.取消绑定
     * @param bindingStatus
     */
    public void setBindingStatus(Integer bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    /**
     * 回复状态1.等待中2.已同意3.已拒绝
     * @return replyStatus
     */
    public Integer getReplyStatus() {
        return replyStatus;
    }

    /**
     * 回复状态1.等待中2.已同意3.已拒绝
     * @param replyStatus
     */
    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    /**
     * 绑定时间
     * @return bindingTime
     */
    public Date getBindingTime() {
        return bindingTime;
    }

    /**
     * 绑定时间
     * @param bindingTime
     */
    public void setBindingTime(Date bindingTime) {
        this.bindingTime = bindingTime;
    }

    /**
     * 取消绑定时间
     * @return cancelBindingTime
     */
    public Date getCancelBindingTime() {
        return cancelBindingTime;
    }

    /**
     * 取消绑定时间
     * @param cancelBindingTime
     */
    public void setCancelBindingTime(Date cancelBindingTime) {
        this.cancelBindingTime = cancelBindingTime;
    }

    /**
     * 发起时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 发起时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}