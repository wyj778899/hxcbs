package chinaPress.fc.question.vo;
/**
 * 试题的名称信息
 * @author wyj
 *
 */
public class QuestionNameVo {

	/**
	 * 试题分类名称
	 */
	private String catalogName;
	
	/**
	 * 试题类型名称
	 */
	private String questionTypeName;
	
	/**
	 * 试题难度名称
	 */
	private String taskDifficultyName;
	
	/**
	 * 试题个数
	 */
	private Integer count;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getCatalogName() {
		return catalogName;
	}

	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}

	public String getQuestionTypeName() {
		return questionTypeName;
	}

	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}

	public String getTaskDifficultyName() {
		return taskDifficultyName;
	}

	public void setTaskDifficultyName(String taskDifficultyName) {
		this.taskDifficultyName = taskDifficultyName;
	}
	
}
