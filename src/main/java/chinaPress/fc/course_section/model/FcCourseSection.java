package chinaPress.fc.course_section.model;

import java.util.Date;
import java.util.List;

/**
 * fc_course_section
 * 
 * @author Administrator
 * @date 2020-06-18 11:26:37
 */
public class FcCourseSection {
	/**
	 * 课程章节
	 */
	private Integer id;

	/**
	 * 课程id
	 */
	private Integer courseId;

	/**
	 * 父级id
	 */
	private Integer pid;

	/**
	 * 章节名称
	 */
	private String name;

	/**
	 * 主讲人
	 */
	private String speaker;

	/**
	 * 时长
	 */
	private String duration;

	/**
	 * 章节编码
	 */
	private String code;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 是否末级(0.否.1.是)
	 */
	private Integer isLast;

	/**
	 * 级别类型
	 */
	private Integer isLevel;

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

	private List<FcCourseSection> sectionList;
	private List<FcCourseHour> hourList;

	public List<FcCourseSection> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<FcCourseSection> sectionList) {
		this.sectionList = sectionList;
	}

	public List<FcCourseHour> getHourList() {
		return hourList;
	}

	public void setHourList(List<FcCourseHour> hourList) {
		this.hourList = hourList;
	}

	/**
	 * 课程章节
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 课程章节
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
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
	 * 父级id
	 * 
	 * @return pid
	 */
	public Integer getPid() {
		return pid;
	}

	/**
	 * 父级id
	 * 
	 * @param pid
	 */
	public void setPid(Integer pid) {
		this.pid = pid;
	}

	/**
	 * 章节名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 章节名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：speaker
	 */
	public String getSpeaker() {
		return speaker;
	}

	/**
	 * 设置：speaker
	 */
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	/**
	 * 获取：duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * 设置：duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * 章节编码
	 * 
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 章节编码
	 * 
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 备注
	 * 
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 备注
	 * 
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 是否末级(0.否.1.是)
	 * 
	 * @return isLast
	 */
	public Integer getIsLast() {
		return isLast;
	}

	/**
	 * 是否末级(0.否.1.是)
	 * 
	 * @param isLast
	 */
	public void setIsLast(Integer isLast) {
		this.isLast = isLast;
	}

	/**
	 * 级别类型
	 * 
	 * @return isLevel
	 */
	public Integer getIsLevel() {
		return isLevel;
	}

	/**
	 * 级别类型
	 * 
	 * @param isLevel
	 */
	public void setIsLevel(Integer isLevel) {
		this.isLevel = isLevel;
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