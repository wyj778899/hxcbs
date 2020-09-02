package chinaPress.exam.paper.vo;

import java.util.List;

/**
 * 考试信息
 * @author wyj
 *
 */
public class ExamVo {

	/**
	 * 考试id
	 */
	private Integer examId;
	
	/**
	 * 考试分数
	 */
	private String sumGrade;
	
	/**
	 * 及格评语
	 */
	private String passComment;
	
	/**
	 * 不及格评语
	 */
	private String failComment;
	
	/**
	 * 试卷试题答案信息
	 */
	private List<StemOption> stems;

	public Integer getExamId() {
		return examId;
	}

	public void setExamId(Integer examId) {
		this.examId = examId;
	}

	public String getSumGrade() {
		return sumGrade;
	}

	public void setSumGrade(String sumGrade) {
		this.sumGrade = sumGrade;
	}

	public String getPassComment() {
		return passComment;
	}

	public void setPassComment(String passComment) {
		this.passComment = passComment;
	}

	public String getFailComment() {
		return failComment;
	}

	public void setFailComment(String failComment) {
		this.failComment = failComment;
	}

	public List<StemOption> getStems() {
		return stems;
	}

	public void setStems(List<StemOption> stems) {
		this.stems = stems;
	}
	
	
}
