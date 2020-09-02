package chinaPress.exam.paper.vo;

/**
 * 考试评语信息
 * @author wyj
 *
 */
public class ExamCommentVo {

	/**
	 * 分数
	 */
	private String grade;
	
	/**
	 * 评语
	 */
	private String comment;

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
