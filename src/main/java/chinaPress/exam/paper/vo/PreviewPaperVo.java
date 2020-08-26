package chinaPress.exam.paper.vo;

import java.util.List;

import chinaPress.fc.question.vo.QuestionVo;

/**
 * 预览试卷信息
 * 
 * @author wyj
 *
 */
public class PreviewPaperVo {
	

	/**
	 * 试卷分数
	 */
	private String grade;

	/**
	 * 单选题总分数
	 */
	private String radioGrade;

	/**
	 * 试卷试题信息单选
	 */
	private List<QuestionVo> radioQuestions;

	/**
	 * 多选题总分数
	 */
	private String checkboxGrade;

	/**
	 * 试卷试题信息 多选
	 */
	private List<QuestionVo> checkboxQuestions;

	/**
	 * 判断题总分数
	 */
	private String judgeGrade;

	/**
	 * 试卷试题信息 判断
	 */
	private List<QuestionVo> judgeQuestions;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<QuestionVo> getRadioQuestions() {
		return radioQuestions;
	}

	public void setRadioQuestions(List<QuestionVo> radioQuestions) {
		this.radioQuestions = radioQuestions;
	}

	public List<QuestionVo> getCheckboxQuestions() {
		return checkboxQuestions;
	}

	public void setCheckboxQuestions(List<QuestionVo> checkboxQuestions) {
		this.checkboxQuestions = checkboxQuestions;
	}

	public List<QuestionVo> getJudgeQuestions() {
		return judgeQuestions;
	}

	public void setJudgeQuestions(List<QuestionVo> judgeQuestions) {
		this.judgeQuestions = judgeQuestions;
	}

	public String getRadioGrade() {
		return radioGrade;
	}

	public void setRadioGrade(String radioGrade) {
		this.radioGrade = radioGrade;
	}

	public String getCheckboxGrade() {
		return checkboxGrade;
	}

	public void setCheckboxGrade(String checkboxGrade) {
		this.checkboxGrade = checkboxGrade;
	}

	public String getJudgeGrade() {
		return judgeGrade;
	}

	public void setJudgeGrade(String judgeGrade) {
		this.judgeGrade = judgeGrade;
	}

}
