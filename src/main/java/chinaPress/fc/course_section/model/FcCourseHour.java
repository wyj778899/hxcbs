package chinaPress.fc.course_section.model;

import java.util.Date;
import java.util.List;

import chinaPress.fc.question.model.FcQuestionStem;

/**
 * fc_course_hour
 * 
 * @author Administrator
 * @date 2020-06-18 11:26:37
 */
public class FcCourseHour {
	/**
	 * 课时
	 */
	private Integer id;

	/**
	 * 课时名称
	 */
	private String name;

	/**
	 * 课时地址
	 */
	private String address;

	/**
	 * 视频流地址
	 */
	private String url;

	/**
	 * 视频格式（1.mp4）
	 */
	private Integer format;

	/**
	 * 是否试看（0.否1.是）
	 */
	private Integer isLook;

	/**
	 * 1.删除0.不可以删除
	 */
	private Integer isDelete;

	/**
	 * 状态(0.否,1.是)
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
	 * 章节id
	 */
	private Integer sectionId;

	/**
	 * 排序
	 */
	private Integer order;

	/**
	 * 题干集合
	 */
	private List<FcQuestionStem> stemList;

	public List<FcQuestionStem> getStemList() {
		return stemList;
	}

	public void setStemList(List<FcQuestionStem> stemList) {
		this.stemList = stemList;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	/**
	 * 课时
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 课时
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 课时名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 课时名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 课时地址
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 课时地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 视频流地址
	 * 
	 * @return url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 视频流地址
	 * 
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 视频格式（1.mp4）
	 * 
	 * @return format
	 */
	public Integer getFormat() {
		return format;
	}

	/**
	 * 视频格式（1.mp4）
	 * 
	 * @param format
	 */
	public void setFormat(Integer format) {
		this.format = format;
	}

	/**
	 * 是否试看（0.否1.是）
	 * 
	 * @return isLook
	 */
	public Integer getIsLook() {
		return isLook;
	}

	/**
	 * 是否试看（0.否1.是）
	 * 
	 * @param isLook
	 */
	public void setIsLook(Integer isLook) {
		this.isLook = isLook;
	}

	/**
	 * 1.删除0.不可以删除
	 * 
	 * @return isDelete
	 */
	public Integer getIsDelete() {
		return isDelete;
	}

	/**
	 * 1.删除0.不可以删除
	 * 
	 * @param isDelete
	 */
	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 状态(0.否,1.是)
	 * 
	 * @return state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 状态(0.否,1.是)
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
	 * 获取：order
	 */
	public Integer getOrder() {
		return order;
	}

	/**
	 * 设置：order
	 */
	public void setOrder(Integer order) {
		this.order = order;
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
}