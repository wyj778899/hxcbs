package chinaPress.exam.exam_signup.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * fc_exam_signup_area
 * 
 * @author Administrator
 * @date 2020-08-17 14:37:25
 */
public class FcExamSignupArea {
	/**
	 * 考试报名区域
	 */
	private Integer id;

	/**
	 * 考试报名id
	 */
	private Integer signupId;

	/**
	 * 省
	 */
	private String province;

	/**
	 * 市
	 */
	private String city;

	/**
	 * 区
	 */
	private String area;

	/**
	 * 详细地址
	 */
	private String address;

	/**
	 * 考试开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date startTime;

	/**
	 * 考试结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date endTime;

	/**
	 * 报名开始时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date signupStartTime;

	/**
	 * 报名结束时间
	 */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date signupEndTime;

	/**
	 * 报名人数
	 */
	private Integer maxCount;

	/**
	 * 上下架1.上架0.下架
	 */
	private Integer isPutaway;

	/**
	 * 考试报名区域
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 考试报名区域
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 考试报名id
	 * 
	 * @return signupId
	 */
	public Integer getSignupId() {
		return signupId;
	}

	/**
	 * 考试报名id
	 * 
	 * @param signupId
	 */
	public void setSignupId(Integer signupId) {
		this.signupId = signupId;
	}

	/**
	 * 省
	 * 
	 * @return province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * 省
	 * 
	 * @param province
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * 市
	 * 
	 * @return city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 市
	 * 
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * 区
	 * 
	 * @return area
	 */
	public String getArea() {
		return area;
	}

	/**
	 * 区
	 * 
	 * @param area
	 */
	public void setArea(String area) {
		this.area = area;
	}

	/**
	 * 详细地址
	 * 
	 * @return address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * 详细地址
	 * 
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * 考试开始时间
	 * 
	 * @return startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * 考试开始时间
	 * 
	 * @param startTime
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * 考试结束时间
	 * 
	 * @return endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * 考试结束时间
	 * 
	 * @param endTime
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	/**
	 * 报名开始时间
	 */
	public Date getSignupStartTime() {
		return signupStartTime;
	}

	/**
	 * 报名开始时间
	 */
	public void setSignupStartTime(Date signupStartTime) {
		this.signupStartTime = signupStartTime;
	}

	/**
	 * 报名结束时间
	 */
	public Date getSignupEndTime() {
		return signupEndTime;
	}

	/**
	 * 报名结束时间
	 */
	public void setSignupEndTime(Date signupEndTime) {
		this.signupEndTime = signupEndTime;
	}

	/**
	 * 报名人数
	 */
	public Integer getMaxCount() {
		return maxCount;
	}

	/**
	 * 报名人数
	 */
	public void setMaxCount(Integer maxCount) {
		this.maxCount = maxCount;
	}

	/**
	 * 上下架1.上架0.下架
	 */
	public Integer getIsPutaway() {
		return isPutaway;
	}

	/**
	 * 上下架1.上架0.下架
	 */
	public void setIsPutaway(Integer isPutaway) {
		this.isPutaway = isPutaway;
	}
}