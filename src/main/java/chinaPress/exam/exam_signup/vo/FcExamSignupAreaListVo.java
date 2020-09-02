package chinaPress.exam.exam_signup.vo;

public class FcExamSignupAreaListVo {
	/**
	 * 考试报名区域时间id
	 */
	private Integer id;
	/**
	 * 考试报名区域时间名称
	 */
	private String address;
	/**
	 * 考试时间
	 */
	private String time;
	/**
	 * 考试报名人数
	 */
	private Integer count;
	/**
	 * 考试已报名人数
	 */
	private Integer haveCount;
	/**
	 * 上下架状态1.上架0.下架
	 */
	private Integer isPutaway;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the haveCount
	 */
	public Integer getHaveCount() {
		return haveCount;
	}

	/**
	 * @param haveCount the haveCount to set
	 */
	public void setHaveCount(Integer haveCount) {
		this.haveCount = haveCount;
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
}
