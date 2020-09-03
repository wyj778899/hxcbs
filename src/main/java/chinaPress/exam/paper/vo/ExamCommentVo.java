package chinaPress.exam.paper.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	
	/**
	 * 考试名称
	 */
	private String examName;
	
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date startTime;
	
	/**
	 * 交卷时间
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date endTime;

	/**
	 * 总分
	 */
	private String examGrade;
	
	/**
	 * 及格分数
	 */
	private String passGrade;
	
	
	public String getExamGrade() {
		return examGrade;
	}

	public void setExamGrade(String examGrade) {
		this.examGrade = examGrade;
	}

	public String getPassGrade() {
		return passGrade;
	}

	public void setPassGrade(String passGrade) {
		this.passGrade = passGrade;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

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

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}
	
}
