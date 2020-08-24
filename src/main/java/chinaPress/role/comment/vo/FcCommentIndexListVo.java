package chinaPress.role.comment.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcCommentIndexListVo {
	/**
	 * 评论id
	 */
	private Integer id;
	/**
	 * 父级id，在哪条评论下
	 */
	private Integer pId;
	/**
	 * 评论用户
	 */
	private Integer fromRoleId;
	/**
	 * 评论用户的角色类型
	 */
	private Integer fromRoleType;
	/**
	 * 评论用户名字
	 */
	private String fromUserName;
	/**
	 * 评论用户头像
	 */
	private String fromUserPhoto;
	/**
	 * 评论用户
	 */
	private Integer toRoleId;
	/**
	 * 评论用户的角色类型
	 */
	private Integer toRoleType;
	/**
	 * 被评论用户名字
	 */
	private String toUserName;
	/**
	 * 被评论用户头像
	 */
	private String toUserPhoto;
	/**
	 * 评论内容
	 */
	private String content;
	/**
	 * 评论时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date time;

	private List<FcCommentIndexListVo> children = new ArrayList<FcCommentIndexListVo>();

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
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
	 * @return the fromRoleId
	 */
	public Integer getFromRoleId() {
		return fromRoleId;
	}

	/**
	 * @param fromRoleId the fromRoleId to set
	 */
	public void setFromRoleId(Integer fromRoleId) {
		this.fromRoleId = fromRoleId;
	}

	/**
	 * @return the fromRoleType
	 */
	public Integer getFromRoleType() {
		return fromRoleType;
	}

	/**
	 * @param fromRoleType the fromRoleType to set
	 */
	public void setFromRoleType(Integer fromRoleType) {
		this.fromRoleType = fromRoleType;
	}

	/**
	 * @return the fromUserName
	 */
	public String getFromUserName() {
		return fromUserName;
	}

	/**
	 * @param fromUserName the fromUserName to set
	 */
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}

	/**
	 * @return the fromUserPhoto
	 */
	public String getFromUserPhoto() {
		return fromUserPhoto;
	}

	/**
	 * @param fromUserPhoto the fromUserPhoto to set
	 */
	public void setFromUserPhoto(String fromUserPhoto) {
		this.fromUserPhoto = fromUserPhoto;
	}

	/**
	 * @return the toRoleId
	 */
	public Integer getToRoleId() {
		return toRoleId;
	}

	/**
	 * @param toRoleId the toRoleId to set
	 */
	public void setToRoleId(Integer toRoleId) {
		this.toRoleId = toRoleId;
	}

	/**
	 * @return the toRoleType
	 */
	public Integer getToRoleType() {
		return toRoleType;
	}

	/**
	 * @param toRoleType the toRoleType to set
	 */
	public void setToRoleType(Integer toRoleType) {
		this.toRoleType = toRoleType;
	}

	/**
	 * @return the toUserName
	 */
	public String getToUserName() {
		return toUserName;
	}

	/**
	 * @param toUserName the toUserName to set
	 */
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}

	/**
	 * @return the toUserPhoto
	 */
	public String getToUserPhoto() {
		return toUserPhoto;
	}

	/**
	 * @param toUserPhoto the toUserPhoto to set
	 */
	public void setToUserPhoto(String toUserPhoto) {
		this.toUserPhoto = toUserPhoto;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	/**
	 * @return the children
	 */
	public List<FcCommentIndexListVo> getChildren() {
		return children;
	}

	/**
	 * @param children the children to set
	 */
	public void setChildren(List<FcCommentIndexListVo> children) {
		this.children = children;
	}

}
