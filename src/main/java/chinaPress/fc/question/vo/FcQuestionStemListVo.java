package chinaPress.fc.question.vo;

import java.util.List;

public class FcQuestionStemListVo {
	
	private Integer id;
	//类型（1.单选2.多选3.判断）
	private Integer questionType;
	//题目难度(1.简单2.一般3.困难)
	private Integer taskDifficulty;
	//题干
	private String questionStem;
	//分数
	private String grade;
	//选项
	private List<FcQuestionOptionVo> optionList;
	public List<FcQuestionOptionVo> getOptionList() {
		return optionList;
	}
	public void setOptionList(List<FcQuestionOptionVo> optionList) {
		this.optionList = optionList;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
