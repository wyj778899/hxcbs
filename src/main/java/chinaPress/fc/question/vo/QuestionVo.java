package chinaPress.fc.question.vo;

import java.util.List;

import chinaPress.fc.question.model.FcQuestionOption;

/**
 * 试题信息封装   
 * @author wyj
 *
 */
public class QuestionVo {
	
	/**
	 * 试题id
	 */
	private Integer id;
	
	/**
	 * 试题名称
	 */
	private String questionStem;
	
	/**
	 * 试题类型 1.单选2.多选3.判断
	 */
	private Integer questionType;
	
	
	/**
	 * 试题难度 1.简单2.一般3.困难
	 */
	private Integer taskDifficulty;
	
	/**
	 * 分数
	 */
	private String grade;
	
	/**
	 * 试题分类名称
	 */
	private String catalogName;
	
	/**
	 * 试题分类id
	 */
	private Integer catalogId;
	
	/**
	 * 答案信息
	 */
	private List<FcQuestionOption> options;
	
	
	public List<FcQuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<FcQuestionOption> options) {
		this.options = options;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestionStem() {
		return questionStem;
	}

	public void setQuestionStem(String questionStem) {
		this.questionStem = questionStem;
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

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	
}
