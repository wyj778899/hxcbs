package chinaPress.role.comment.model;

import java.util.Date;

/**
 * fc_comment
 * @author Administrator
 * @date 2020-07-15 09:57:53
 */
public class FcCommentInfo {
    /**
     */
    private Integer id;

    /**
     * 章节id
     */
    private Integer sectionId;

    /**
     * 1.匿名0.不是匿名
     */
    private Integer isAnonymous;

    /**
     * 评论内容
     */
    private String content;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色类型1.员工2.机构3.家长4.从业者5.注册用户
     */
    private Integer roleType;

    /**
     * 接收角色id
     */
    private Integer receiveId;

    /**
     * 接收角色类型1.员工2.机构3.家长4.从业者5.注册用户
     */
    private Integer receiveRoleType;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 章节id
     * @return sectionId
     */
    public Integer getSectionId() {
        return sectionId;
    }

    /**
     * 章节id
     * @param sectionId
     */
    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    /**
     * 1.匿名0.不是匿名
     * @return isAnonymous
     */
    public Integer getIsAnonymous() {
        return isAnonymous;
    }

    /**
     * 1.匿名0.不是匿名
     * @param isAnonymous
     */
    public void setIsAnonymous(Integer isAnonymous) {
        this.isAnonymous = isAnonymous;
    }

    /**
     * 评论内容
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 评论内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
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
     * 角色类型1.员工2.机构3.家长4.从业者5.注册用户
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 角色类型1.员工2.机构3.家长4.从业者5.注册用户
     * @param roleType
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * 接收角色id
     * @return receiveId
     */
    public Integer getReceiveId() {
        return receiveId;
    }

    /**
     * 接收角色id
     * @param receiveId
     */
    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * 接收角色类型1.员工2.机构3.家长4.从业者5.注册用户
     * @return receiveRoleType
     */
    public Integer getReceiveRoleType() {
        return receiveRoleType;
    }

    /**
     * 接收角色类型1.员工2.机构3.家长4.从业者5.注册用户
     * @param receiveRoleType
     */
    public void setReceiveRoleType(Integer receiveRoleType) {
        this.receiveRoleType = receiveRoleType;
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
     * 修改时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 修改人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 修改人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }
}