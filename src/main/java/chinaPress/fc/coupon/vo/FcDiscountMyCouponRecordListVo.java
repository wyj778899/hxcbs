package chinaPress.fc.coupon.vo;

public class FcDiscountMyCouponRecordListVo {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 优惠券名称
	 */
	private String name;
	/**
	 * 优惠券编码
	 */
	private String code;
	/**
	 * 优惠券有效期开始日期
	 */
	private String startTime;
	/**
	 * 优惠券有效期结束日期
	 */
	private String endTime;
	/**
	 * 关联课程
	 */
	private String courseName;

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
	 * 获取：name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置：code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 获取：startTime
	 */
	public String getStartTime() {
		return startTime;
	}

	/**
	 * 设置：startTime
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * 获取：endTime
	 */
	public String getEndTime() {
		return endTime;
	}

	/**
	 * 设置：endTime
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	/**
	 * 获取：courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * 设置：courseName
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
