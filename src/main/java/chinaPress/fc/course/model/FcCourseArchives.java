package chinaPress.fc.course.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_course_archives
 * 
 * @author Administrator
 * @date 2020-06-17 17:43:53
 */
public class FcCourseArchives {
	/**
	 * 课程档案
	 */
	private Integer id;

	/**
	 * 课程名称
	 */
	private String name;

	/**
	 * 类型：1.免费2.付费3.认证课程
	 */
	private Integer type;

	/**
	 * 分类id
	 */
	private Integer categoryId;

	/**
	 * 课程价格
	 */
	private BigDecimal coursePrice;

	/**
	 * 课程使用天数
	 */
	private Integer courseNumber;

	/**
	 * 续费价格
	 */
	private BigDecimal renewPrice;

	/**
	 * 课程概述
	 */
	private String remarks;

	/**
	 * 课程封面
	 */
	private String photo;

	/**
	 * 讲师
	 */
	private String speaker;

	/**
	 * 是否上架（0.否1.是）
	 */
	private Integer isPutaway;

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

	private Integer isDelete;

	public Integer getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	/**
	 * 课程档案
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 课程档案
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 课程名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 课程名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 类型：1.免费2.付费3.认证课程
	 * 
	 * @return type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 类型：1.免费2.付费3.认证课程
	 * 
	 * @param type
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 分类id
	 * 
	 * @return categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * 分类id
	 * 
	 * @param categoryId
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * 课程价格
	 * 
	 * @return coursePrice
	 */
	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	/**
	 * 课程价格
	 * 
	 * @param coursePrice
	 */
	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	/**
	 * 课程使用天数
	 * 
	 * @return courseNumber
	 */
	public Integer getCourseNumber() {
		return courseNumber;
	}

	/**
	 * 课程使用天数
	 * 
	 * @param courseNumber
	 */
	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	/**
	 * 续费价格
	 * 
	 * @return renewPrice
	 */
	public BigDecimal getRenewPrice() {
		return renewPrice;
	}

	/**
	 * 续费价格
	 * 
	 * @param renewPrice
	 */
	public void setRenewPrice(BigDecimal renewPrice) {
		this.renewPrice = renewPrice;
	}

	/**
	 * 课程概述
	 * 
	 * @return remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 课程概述
	 * 
	 * @param remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 课程封面
	 * 
	 * @return photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * 课程封面
	 * 
	 * @param photo
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 是否上架（0.否1.是）
	 * 
	 * @return isPutaway
	 */
	public Integer getIsPutaway() {
		return isPutaway;
	}

	/**
	 * 是否上架（0.否1.是）
	 * 
	 * @param isPutaway
	 */
	public void setIsPutaway(Integer isPutaway) {
		this.isPutaway = isPutaway;
	}

	/**
	 * 状态（0.无效1.有效）
	 * 
	 * @return state
	 */
	public Integer getState() {
		return state;
	}

	/**
	 * 状态（0.无效1.有效）
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
}