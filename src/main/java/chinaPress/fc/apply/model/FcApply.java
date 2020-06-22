package chinaPress.fc.apply.model;

import java.util.Date;

/**
 * fc_apply
 * @author Chaoqun
 * @date 2020-06-22 11:02:18
 */
public class FcApply {
    /**
     * 报名
     */
    private Integer id;

    /**
     * 申请人
     */
    private Integer applyId;

    /**
     * 申请类型（1.机构2.家长3.从业人员）
     */
    private Integer applyType;

    /**
     * 课程id
     */
    private Integer courseId;

    /**
     * 申请人数
     */
    private Integer applyCount;

    /**
     * 申请时间
     */
    private Date applyTime;

    /**
     * 报名进度1.已报名2.已缴费
     */
    private Integer applySchedule;

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
     * 报名
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 报名
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 申请人
     * @return applyId
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * 申请人
     * @param applyId
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * 申请类型（1.机构2.家长3.从业人员）
     * @return applyType
     */
    public Integer getApplyType() {
        return applyType;
    }

    /**
     * 申请类型（1.机构2.家长3.从业人员）
     * @param applyType
     */
    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    /**
     * 课程id
     * @return courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 课程id
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 申请人数
     * @return applyCount
     */
    public Integer getApplyCount() {
        return applyCount;
    }

    /**
     * 申请人数
     * @param applyCount
     */
    public void setApplyCount(Integer applyCount) {
        this.applyCount = applyCount;
    }

    /**
     * 申请时间
     * @return applyTime
     */
    public Date getApplyTime() {
        return applyTime;
    }

    /**
     * 申请时间
     * @param applyTime
     */
    public void setApplyTime(Date applyTime) {
        this.applyTime = applyTime;
    }

    /**
     * 报名进度1.已报名2.已缴费
     * @return applySchedule
     */
    public Integer getApplySchedule() {
        return applySchedule;
    }

    /**
     * 报名进度1.已报名2.已缴费
     * @param applySchedule
     */
    public void setApplySchedule(Integer applySchedule) {
        this.applySchedule = applySchedule;
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
}