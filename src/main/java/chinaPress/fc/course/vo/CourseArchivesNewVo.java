package chinaPress.fc.course.vo;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import chinaPress.common.tree.model.TreeNode;

public class CourseArchivesNewVo {
	private Integer id;
	private String courseName;//课程名称
	private Integer courseType;//课程类型
	private String categoryName;//分类名称
	private BigDecimal coursePrice;//课程价格
	private Integer courseNumber;//使用天数
	private BigDecimal renewPrice;//续费价格
	private String remarks;//描述
	private String photo;//封面
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;//更新时间
	private List<TreeNode> sectionList;
	public List<TreeNode> getSectionList() {
		return sectionList;
	}
	public void setSectionList(List<TreeNode> sectionList) {
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

}
