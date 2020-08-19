package chinaPress.exam.paper.vo;

import java.math.BigDecimal;

/**
 * 试卷关联试题参数封装 
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
	private BigDecimal grade;

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

	public BigDecimal getGrade() {
		return grade;
	}

	public void setGrade(BigDecimal grade) {
		this.grade = grade;
	}
	
}
