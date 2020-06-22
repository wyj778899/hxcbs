package chinaPress.fc.coupon.vo;

public class FcDiscountCouponListVo {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 优惠券名称
	 */
	private String name;
	/**
	 * 优惠券有效期开始日期
	 */
	private String startTime;
	/**
	 * 优惠券有效期结束日期
	 */
	private String endTime;
	/**
	 * 优惠券类型1.满减券2.观看券
	 */
	private String typeName;
	/**
	 * 关联课程
	 */
	private String courseName;
	/**
	 * 优惠券数量
	 */
	private Integer count;

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
	 * 获取：typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 设置：typeName
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
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
}
