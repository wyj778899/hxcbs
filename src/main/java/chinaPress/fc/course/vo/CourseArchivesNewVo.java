package chinaPress.fc.course.vo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import chinaPress.fc.book.vo.FcCourseBookVo;
import chinaPress.fc.course_section.vo.FcCourseSectionVo;

public class CourseArchivesNewVo {
	private Integer id;
	private String courseName;// 课程名称
	private Integer courseType;// 课程类型
	private String categoryName;// 分类名称
	private BigDecimal coursePrice;// 课程价格
	private Integer courseNumber;// 使用天数
	private BigDecimal renewPrice;// 续费价格
	private String remarks;// 描述
	private String photo;// 封面
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;// 更新时间
	private Integer courseCount;// 视频数量
	private List<FcCourseSectionVo> sectionList;
	private List<FcCourseBookVo> bookList;// 推荐书籍
	private Integer studyDay;// 学习天数
	private String speaker;// 讲师
	private Integer isLearning;// 当前课程是正在学习中1.是0.不是
	private Integer learningHourId;// 当前课程正在学习的最新课时id
	private String attribute;// 课程属性
	private List<CourseTutorVo> tutorList;// 课程关联导师

	public Integer getCourseCount() {
		return courseCount;
	}

	public void setCourseCount(Integer courseCount) {
		this.courseCount = courseCount;
	}

	public List<FcCourseSectionVo> getSectionList() {
		return sectionList;
	}

	public void setSectionList(List<FcCourseSectionVo> sectionList) {
		this.sectionList = sectionList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getCourseType() {
		return courseType;
	}

	public void setCourseType(Integer courseType) {
		this.courseType = courseType;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
	}

	public Integer getCourseNumber() {
		return courseNumber;
	}

	public void setCourseNumber(Integer courseNumber) {
		this.courseNumber = courseNumber;
	}

	public BigDecimal getRenewPrice() {
		return renewPrice;
	}

	public void setRenewPrice(BigDecimal renewPrice) {
		this.renewPrice = renewPrice;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * 获取：bookList
	 */
	public List<FcCourseBookVo> getBookList() {
		return bookList;
	}

	/**
	 * 设置：bookList
	 */
	public void setBookList(List<FcCourseBookVo> bookList) {
		this.bookList = bookList;
	}

	/**
	 * 获取：studyDay
	 */
	public Integer getStudyDay() {
		return studyDay;
	}

	/**
	 * 设置：studyDay
	 */
	public void setStudyDay(Integer studyDay) {
		this.studyDay = studyDay;
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
	 * 获取：tutorList
	 */
	public List<CourseTutorVo> getTutorList() {
		return tutorList;
	}

	/**
	 * 设置：tutorList
	 */
	public void setTutorList(List<CourseTutorVo> tutorList) {
		this.tutorList = tutorList;
	}

}
