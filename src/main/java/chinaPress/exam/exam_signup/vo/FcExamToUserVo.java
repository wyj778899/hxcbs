package chinaPress.exam.exam_signup.vo;

/**
 * 用户考试信息
 * @author wyj
 *
 */
public class FcExamToUserVo {

	/**
	 * 考试id
	 */
	private Integer id;
	
	/**
	 * 考试名称
	 */
	private String examName;
	
	/**
	 * 考试时间
	 */
	private String time;
	
	/**
	 * 考试分数
	 */
	private String grade;
	
	/**
	 * 课程名称
	 */
	private String courseName;
	
	/**
	 * 证书名称
	 */
	private String certName;
	
	/**
	 * 报名id
	 */
	private Integer signupId;
	
	/**
	 * 报名区域id
	 */
	private Integer signupAreaId;
	
	/**
	 * 是否为现场考试 1 是   0 否
	 */
	private Integer examForm;
	
	public Integer getExamForm() {
		return examForm;
	}

	public void setExamForm(Integer examForm) {
		this.examForm = examForm;
	}

	public Integer getSignupId() {
		return signupId;
	}

	public void setSignupId(Integer signupId) {
		this.signupId = signupId;
	}

	public Integer getSignupAreaId() {
		return signupAreaId;
	}

	public void setSignupAreaId(Integer signupAreaId) {
		this.signupAreaId = signupAreaId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getExamName() {
		return examName;
	}

	public void setExamName(String examName) {
		this.examName = examName;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCertName() {
		return certName;
	}

	public void setCertName(String certName) {
		this.certName = certName;
	}
	
}
