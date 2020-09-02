package chinaPress.exam.exam_signup.vo;

public class FcExamSignupIndexDetailAreaVo {
	/**
	 * 考试报名区域时间id
	 */
	private Integer id;
	/**
	 * 区域
	 */
	private String address;
	/**
	 * 时间
	 */
	private String time;
	/**
	 * 报名时间
	 */
	private String signupTime;
	/**
	 * 人数
	 */
	private Integer count;
	/**
	 * 是否上架1.上架0.下架
	 */
	private Integer isPutaway;
	/**
	 * 是否可报名1.可以报名-1.不在报名时间范围内-2.该区域还未上架
	 */
	private Integer isSignup;

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
	 * 获取：address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 设置：address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 获取：time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * 设置：time
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the signupTime
	 */
	public String getSignupTime() {
		return signupTime;
	}

	/**
	 * @param signupTime the signupTime to set
	 */
	public void setSignupTime(String signupTime) {
		this.signupTime = signupTime;
	}

	/**
	 * 获取：count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 设置：count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the isPutaway
	 */
	public Integer getIsPutaway() {
		return isPutaway;
	}

	/**
	 * @param isPutaway the isPutaway to set
	 */
	public void setIsPutaway(Integer isPutaway) {
		this.isPutaway = isPutaway;
	}

	/**
	 * @return the isSignup
	 */
	public Integer getIsSignup() {
		return isSignup;
	}

	/**
	 * @param isSignup the isSignup to set
	 */
	public void setIsSignup(Integer isSignup) {
		this.isSignup = isSignup;
	}
}
