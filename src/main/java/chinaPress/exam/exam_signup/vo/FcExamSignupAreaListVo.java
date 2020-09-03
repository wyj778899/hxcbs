package chinaPress.exam.exam_signup.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

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
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;
	/**
	 * 考试时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date endTime;
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
	 * 关联课程
	 */
	private String courseName;
	/**
	 * 关联证书
	 */
	private String certName;
	/**
	 * 考试形式
	 */
	private String typeName;

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
	 * @return the startTime
	 */
	public Date getStartTime() {
		return startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the endTime
	 */
	public Date getEndTime() {
		return endTime;
	}

	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
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

	/**
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}

	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	/**
	 * @return the certName
	 */
	public String getCertName() {
		return certName;
	}

	/**
	 * @param certName the certName to set
	 */
	public void setCertName(String certName) {
		this.certName = certName;
	}

	/**
	 * @return the typeName
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
}
