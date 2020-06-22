package chinaPress.fc.course.vo;

import java.util.List;

import chinaPress.fc.course_section.model.FcCourseHour;

public class SectionHourVo {
	private Integer id;
	private	Integer courseId;
	private Integer PId;
	private String name;
	private List<SectionHourVo> sectionList;
	private List<FcCourseHour> hourList;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public Integer getPId() {
		return PId;
	}
	public void setPId(Integer pId) {
		PId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<SectionHourVo> getSectionList() {
		return sectionList;
	}
	public void setSectionList(List<SectionHourVo> sectionList) {
		this.sectionList = sectionList;
	}
	public List<FcCourseHour> getHourList() {
		return hourList;
	}
	public void setHourList(List<FcCourseHour> hourList) {
		this.hourList = hourList;
	}
	

}
