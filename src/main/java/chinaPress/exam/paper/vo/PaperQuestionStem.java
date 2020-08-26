package chinaPress.exam.paper.vo;

import java.util.List;

import chinaPress.fc.question.vo.QuestionVo;

/**
 * 考试试卷试题信息
 * @author wyj
 *
 */
public class PaperQuestionStem {

	
	/**
	 * 试卷id
	 */
	private Integer examId;
	
	/**
	 * 试卷分数
	 */
	private String grade;
	
	/**
	 * 试卷类型
	 */
	private Integer type;
	
	
	
	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


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
	 * 试卷试题信息  多选
	 */
	private List<QuestionVo> checkboxQuestions;

	
	/**
	 * 判断题总分数
	 */
	private String judgeGrade;

	
	/**
	 * 试卷试题信息  判断
	 */
	private List<QuestionVo> judgeQuestions;

	/**
	 * 所有试题信息
	 */
	private List<QuestionVo> questions;
	

	public List<QuestionVo> getQuestions() {
		return questions;
	}


	public void setQuestions(List<QuestionVo> questions) {
		this.questions = questions;
	}


	public Integer getExamId() {
		return examId;
	}


	public void setExamId(Integer examId) {
		this.examId = examId;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getRadioGrade() {
		return radioGrade;
	}


	public void setRadioGrade(String radioGrade) {
		this.radioGrade = radioGrade;
	}


	public List<QuestionVo> getRadioQuestions() {
		return radioQuestions;
	}


	public void setRadioQuestions(List<QuestionVo> radioQuestions) {
		this.radioQuestions = radioQuestions;
	}


	public String getCheckboxGrade() {
		return checkboxGrade;
	}


	public void setCheckboxGrade(String checkboxGrade) {
		this.checkboxGrade = checkboxGrade;
	}


	public List<QuestionVo> getCheckboxQuestions() {
		return checkboxQuestions;
	}


	public void setCheckboxQuestions(List<QuestionVo> checkboxQuestions) {
		this.checkboxQuestions = checkboxQuestions;
	}


	public String getJudgeGrade() {
		return judgeGrade;
	}


	public void setJudgeGrade(String judgeGrade) {
		this.judgeGrade = judgeGrade;
	}


	public List<QuestionVo> getJudgeQuestions() {
		return judgeQuestions;
	}


	public void setJudgeQuestions(List<QuestionVo> judgeQuestions) {
		this.judgeQuestions = judgeQuestions;
	}
	
}
