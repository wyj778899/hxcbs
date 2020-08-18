package chinaPress.fc.question.vo;

import java.util.List;

/**
 * 试题信息   用于查询展示试题信息
 * @author wyj
 *
 */
public class FcQuestionAndOption {

	/**
	 * 试题id
	 */
	private Integer id;
	
	/**
	 * 试题名称
	 */
	private String questionStem;
	
	/**
	 * 试题类型   单选，多选，判断
	 */
	private Integer questionType;
	
	/**
	 * 题目难度 简单，一般，困难
	 */
	private Integer taskDifficulty; 
	
	/**
	 * 试题分类
	 */
	private Integer catalogId; 
	
	/**
	 * 课程id
	 */
	private Integer courseId;
	
	/**
	 * 课时id
	 */
	private Integer hourId;
	
	/**
	 * 答案信息
	 */
	private List<QuestionOption> options;

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

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public Integer getCourseId() {
		return courseId;
	}

	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}

	public Integer getHourId() {
		return hourId;
	}

	public void setHourId(Integer hourId) {
		this.hourId = hourId;
	}

	public List<QuestionOption> getOptions() {
		return options;
	}

	public void setOptions(List<QuestionOption> options) {
		this.options = options;
	}
	
	
}
