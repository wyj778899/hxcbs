package chinaPress.fc.course.vo;

import java.math.BigDecimal;

/**
 * 首页上岗课程和评估课程
 * 
 * @author maguoliang
 *
 */
public class CourseIndexVo {
	/**
	 * 课程id
	 */
	private Integer id;
	/**
	 * 课程封面
	 */
	private String cover;
	/**
	 * 课程名称
	 */
	private String courseName;
	/**
	 * 课程属性
	 */
	private String attribute;
	/**
	 * 课程介绍
	 */
	private String remarks;
	/**
	 * 主讲老师
	 */
	private String speaker;
	/**
	 * 课时视频数量
	 */
	private Integer courseCount;
	/**
	 * 价格
	 */
	private BigDecimal coursePrice;
	/**
	 * 当前课程是正在学习中1.是0.不是
	 */
	private Integer isLearning;
	/**
	 * 如果正在学习中，学习课时id
	 */
	private Integer learningHourId;

	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：cover
	 */
	public String getCover() {
		return cover;
	}

	/**
	 * 设置：cover
	 */
	public void setCover(String cover) {
		this.cover = cover;
	}

	/**
	 * 获取：courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * 设置：courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * 获取：attribute
	 */
	public String getAttribute() {
		return attribute;
	}

	/**
	 * 设置：attribute
	 */
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}

	/**
	 * 获取：remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 设置：remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	 * 获取：courseCount
	 */
	public Integer getCourseCount() {
		return courseCount;
	}

	/**
	 * 设置：courseCount
	 */
	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	/**
	 * 获取：coursePrice
	 */
	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	/**
	 * 设置：coursePrice
	 */
	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	/**
	 * 获取：isLearning
	 */
	public Integer getIsLearning() {
		return isLearning;
	}

	/**
	 * 设置：isLearning
	 */
	public void setIsLearning(Integer isLearning) {
		this.isLearning = isLearning;
	}

	/**
	 * 获取：learningHourId
	 */
	public Integer getLearningHourId() {
		return learningHourId;
	}

	/**
	 * 设置：learningHourId
	 */
	public void setLearningHourId(Integer learningHourId) {
		this.learningHourId = learningHourId;
	}
}