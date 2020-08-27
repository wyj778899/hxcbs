package chinaPress.exam.exam_signup.vo;

public class FcExamSignupListVo {
	/**
	 * 考试报名id
	 */
	private Integer id;
	/**
	 * 考试报名名称
	 */
	private String signupName;
	/**
	 * 考试报名人数
	 */
	private Integer signupCount;
	/**
	 * 考试形式(1现场0非现场)
	 */
	private Integer examForm;
	/**
	 * 是否上架1.上架0.下架
	 */
	private Integer isPutaway;

	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：signupName
	 */
	public String getSignupName() {
		return signupName;
	}

	/**
	 * 设置：signupName
	 */
	public void setSignupName(String signupName) {
		this.signupName = signupName;
	}

	/**
	 * 获取：signupCount
	 */
	public Integer getSignupCount() {
		return signupCount;
	}

	/**
	 * 设置：signupCount
	 */
	public void setSignupCount(Integer signupCount) {
		this.signupCount = signupCount;
	}

	/**
	 * 获取：examForm
	 */
	public Integer getExamForm() {
		return examForm;
	}

	/**
	 * 设置：examForm
	 */
	public void setExamForm(Integer examForm) {
		this.examForm = examForm;
	}

	/**
	 * 获取：isPutaway
	 */
	public Integer getIsPutaway() {
		return isPutaway;
	}

	/**
	 * 设置：isPutaway
	 */
	public void setIsPutaway(Integer isPutaway) {
		this.isPutaway = isPutaway;
	}
}
