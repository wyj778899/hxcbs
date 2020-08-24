package chinaPress.role.praise.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * fc_comment_praise
 * @author Administrator
 * @date 2020-08-21 11:20:57
 */
public class FcCommentPraise {
    /**
     */
    private Integer id;

    /**
     * 评论id
     */
    private Integer commentId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色类型
     */
    private Integer roleType;

    /**
     * 1.点赞0.取消点赞
     */
    private Integer status;

    /**
     * 点赞时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date okTime;

    /**
     * 取消点赞时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cancelTime;

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
     * 评论id
     * @return commentId
     */
    public Integer getCommentId() {
        return commentId;
    }

    /**
     * 评论id
     * @param commentId
     */
    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
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
     * 角色类型
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 角色类型
     * @param roleType
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * 1.点赞0.取消点赞
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 1.点赞0.取消点赞
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 点赞时间
     * @return okTime
     */
    public Date getOkTime() {
        return okTime;
    }

    /**
     * 点赞时间
     * @param okTime
     */
    public void setOkTime(Date okTime) {
        this.okTime = okTime;
    }

    /**
     * 取消点赞时间
     * @return cancelTime
     */
    public Date getCancelTime() {
        return cancelTime;
    }

    /**
     * 取消点赞时间
     * @param cancelTime
     */
    public void setCancelTime(Date cancelTime) {
        this.cancelTime = cancelTime;
    }
}