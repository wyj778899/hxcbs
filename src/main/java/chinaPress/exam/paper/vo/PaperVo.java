package chinaPress.exam.paper.vo;


/**
 * 试卷抽取试题配置封装
 * @author wyj
 *
 */
public class PaperVo {

	/**
	 * 试题分类
	 */
	private Integer catalogId;
	
	/**
	 * 试题难度 1.简单2.一般3.困难
	 */
	private Integer taskDifficulty;
	
	/**
	 * 试题类型 1.单选2.多选3.判断
	 */
	private Integer questionType;
	
    /**
     * 试题抽取个数
     */
	private Integer count;
	
	/**
	 * 试题分数
	 */
	private String grade;

	public Integer getCatalogId() {
		return catalogId;
	}

	public void setCatalogId(Integer catalogId) {
		this.catalogId = catalogId;
	}

	public Integer getTaskDifficulty() {
		return taskDifficulty;
	}

	public void setTaskDifficulty(Integer taskDifficulty) {
		this.taskDifficulty = taskDifficulty;
	}

	public Integer getQuestionType() {
		return questionType;
	}

	public void setQuestionType(Integer questionType) {
		this.questionType = questionType;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((catalogId == null) ? 0 : catalogId.hashCode());
		result = prime * result + ((count == null) ? 0 : count.hashCode());
		result = prime * result + ((grade == null) ? 0 : grade.hashCode());
		result = prime * result + ((questionType == null) ? 0 : questionType.hashCode());
		result = prime * result + ((taskDifficulty == null) ? 0 : taskDifficulty.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaperVo other = (PaperVo) obj;
		if (catalogId == null) {
			if (other.catalogId != null)
				return false;
		} else if (!catalogId.equals(other.catalogId))
			return false;
		if (count == null) {
			if (other.count != null)
				return false;
		} else if (!count.equals(other.count))
			return false;
		if (grade == null) {
			if (other.grade != null)
				return false;
		} else if (!grade.equals(other.grade))
			return false;
		if (questionType == null) {
			if (other.questionType != null)
				return false;
		} else if (!questionType.equals(other.questionType))
			return false;
		if (taskDifficulty == null) {
			if (other.taskDifficulty != null)
				return false;
		} else if (!taskDifficulty.equals(other.taskDifficulty))
			return false;
		return true;
	}
	
	
}
