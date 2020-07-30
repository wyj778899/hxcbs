package chinaPress.fc.course.vo;

import java.math.BigDecimal;

public class PageIndexCourseVo {
	private Integer id;
	private String courseName;// 课程名称
	private Integer courseType;// 课程类型
	private BigDecimal coursePrice;// 课程价格
	private String remarks;// 课程描述
	private String photo;// 课程图
	private String categoryName;// 分类名称
	private String attribute;// 课程属性

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

	public BigDecimal getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(BigDecimal coursePrice) {
		this.coursePrice = coursePrice;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
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

}
