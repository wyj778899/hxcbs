package chinaPress.fc.question.vo;

import java.util.List;

import chinaPress.fc.question.model.FcQuestionOption;

public class QuestionStemDetailVo {

	/**
	 * 题库
	 */
	private Integer id;

	/**
	 * 课程
	 */
	private Integer courseId;
	private String courseName;

	/**
	 * 课时
	 */
	private Integer hourId;
	private String hourName;

	/**
	 * 试题分类
	 */
	private Integer catalogId;
	private String catalogName;

	/**
	 * 类型（1.单选2.多选3.判断）
	 */
	private Integer questionType;

	/**
	 * 题目难度(1.简单2.一般3.困难)
	 */
	private Integer taskDifficulty;

	/**
	 * 题干
	 */
	private String questionStem;

	/**
	 * 选项
	 */
	private List<FcQuestionOptionVo> optionList;

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

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Integer getHourId() {
		return hourId;
	}

	public void setHourId(Integer hourId) {
		this.hourId = hourId;
	}

	public String getHourName() {
		return hourName;
	}

	public void setHourName(String hourName) {
		this.hourName = hourName;
	}

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public Integer getTaskDifficulty() {
		return taskDifficulty;
	}

	public void setTaskDifficulty(Integer taskDifficulty) {
		this.taskDifficulty = taskDifficulty;
	}

	public String getQuestionStem() {
		return questionStem;
	}

	public void setQuestionStem(String questionStem) {
		this.questionStem = questionStem;
	}

	public List<FcQuestionOptionVo> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<FcQuestionOptionVo> optionList) {
		this.optionList = optionList;
	}

}
