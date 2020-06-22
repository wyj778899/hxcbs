package chinaPress.role.member.model;

import java.util.Date;

/**
 * fc_certificate_archives
 * @author Administrator
 * @date 2020-06-18 16:42:41
 */
public class CertificateInfo {
    /**
     * 证书
     */
    private Integer id;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 证书类型（1.教师资格证2.学历证书3.认证行为分析治疗室）
     */
    private Integer certificateType;

    /**
     * 证书图片
     */
    private String photo;

    /**
     * 审核状态（1.待审核2.已审核3.已驳回）
     */
    private Integer auditStatus;

    /**
     * 状态（0.无效1.有效）
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
     * 角色类型（1.机构2.家长3.从业者）
     */
    private Integer roleType;

    /**
     * 证书
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 证书
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * 证书类型（1.教师资格证2.学历证书3.认证行为分析治疗室）
     * @return certificateType
     */
    public Integer getCertificateType() {
        return certificateType;
    }

    /**
     * 证书类型（1.教师资格证2.学历证书3.认证行为分析治疗室）
     * @param certificateType
     */
    public void setCertificateType(Integer certificateType) {
        this.certificateType = certificateType;
    }

    /**
     * 证书图片
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 证书图片
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * 审核状态（1.待审核2.已审核3.已驳回）
     * @return auditStatus
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态（1.待审核2.已审核3.已驳回）
     * @param auditStatus
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    /**
     * 状态（0.无效1.有效）
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态（0.无效1.有效）
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
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

    /**
     * 角色类型（1.机构2.家长3.从业者）
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 角色类型（1.机构2.家长3.从业者）
     * @param roleType
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
    
    
}