package chinaPress.role.teacher.vo;

import java.util.List;

public class StemParam {

	private Integer type;//类型（1.单选2.多选3.判断）
	private Integer courseId;//课程id
	private String stemName;//题干
	private String taskDifficulty;//题目难度(1.简单2.一般3.困难)
	private List<OptionParam> optionList;
	public List<OptionParam> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<OptionParam> optionList) {
		this.optionList = optionList;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getStemName() {
		return stemName;
	}
	public void setStemName(String stemName) {
		this.stemName = stemName;
	}
	public String getTaskDifficulty() {
		return taskDifficulty;
	}
	public void setTaskDifficulty(String taskDifficulty) {
		this.taskDifficulty = taskDifficulty;
	}
	
}
