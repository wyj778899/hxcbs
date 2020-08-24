package chinaPress.role.comment.model;

import java.util.Date;

/**
 * fc_comment
 * 
 * @author Administrator
 * @date 2020-07-15 09:57:53
 */
public class FcCommentInfo {
	/**
	 */
	private Integer id;

	/**
	 * 评论父级id
	 */
	private Integer pId;

	/**
	 * 评论对象1.评论章节2.评论课程3.评论书籍
	 */
	private Integer type;

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
	 * 审核状态0.未审核1.通过2.驳回
	 */
	private Integer status;

	/**
	 * 点赞数量
	 */
	private Integer praiseCount;

	/**
	 * 驳回原因
	 */
	private String rejectReason;

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
	 * @return the pId
	 */
	public Integer getpId() {
		return pId;
	}

	/**
	 * @param pId the pId to set
	 */
	public void setpId(Integer pId) {
		this.pId = pId;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 章节id
	 * 
	 * @return sectionId
	 */
	public Integer getSectionId() {
		return sectionId;
	}

	/**
	 * 章节id
	 * 
	 * @param sectionId
	 */
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * 1.匿名0.不是匿名
	 * 
	 * @return isAnonymous
	 */
	public Integer getIsAnonymous() {
		return isAnonymous;
	}

	/**
	 * 1.匿名0.不是匿名
	 * 
	 * @param isAnonymous
	 */
	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	/**
	 * 评论内容
	 * 
	 * @return content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 评论内容
	 * 
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
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
	 * 角色类型1.员工2.机构3.家长4.从业者5.注册用户
	 * 
	 * @return roleType
	 */
	public Integer getRoleType() {
		return roleType;
	}

	/**
	 * 角色类型1.员工2.机构3.家长4.从业者5.注册用户
	 * 
	 * @param roleType
	 */
	public void setRoleType(Integer roleType) {
		this.roleType = roleType;
	}

	/**
	 * 接收角色id
	 * 
	 * @return receiveId
	 */
	public Integer getReceiveId() {
		return receiveId;
	}

	/**
	 * 接收角色id
	 * 
	 * @param receiveId
	 */
	public void setReceiveId(Integer receiveId) {
		this.receiveId = receiveId;
	}

	/**
	 * 接收角色类型1.员工2.机构3.家长4.从业者5.注册用户
	 * 
	 * @return receiveRoleType
	 */
	public Integer getReceiveRoleType() {
		return receiveRoleType;
	}

	/**
	 * 接收角色类型1.员工2.机构3.家长4.从业者5.注册用户
	 * 
	 * @param receiveRoleType
	 */
	public void setReceiveRoleType(Integer receiveRoleType) {
		this.receiveRoleType = receiveRoleType;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the praiseCount
	 */
	public Integer getPraiseCount() {
		return praiseCount;
	}

	/**
	 * @param praiseCount the praiseCount to set
	 */
	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
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
	 * 修改时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 修改时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 修改人
	 * 
	 * @return updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * 修改人
	 * 
	 * @param updateId
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	/**
	 * @return the rejectReason
	 */
	public String getRejectReason() {
		return rejectReason;
	}

	/**
	 * @param rejectReason the rejectReason to set
	 */
	public void setRejectReason(String rejectReason) {
		this.rejectReason = rejectReason;
	}
}