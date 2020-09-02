package chinaPress.exam.exam.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FcExamManageListAreaVo {
	/**
	 * 考试关联区域id
	 */
	private Integer id;
	/**
	 * 考试报名区域id
	 */
	private Integer singupAreaId;
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
	private String district;
	/**
	 * 开始时间
	 */
	@JsonFormat(pattern = "YYYY-MM-dd HH:mm:ss", timezone = "GMT+8")
	private Date startTime;

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
	 * @return the singupAreaId
	 */
	public Integer getSingupAreaId() {
		return singupAreaId;
	}

	/**
	 * @param singupAreaId the singupAreaId to set
	 */
	public void setSingupAreaId(Integer singupAreaId) {
		this.singupAreaId = singupAreaId;
	}

	/**
	 * @return the province
	 */
	public String getProvince() {
		return province;
	}

	/**
	 * @param province the province to set
	 */
	public void setProvince(String province) {
		this.province = province;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the district
	 */
	public String getDistrict() {
		return district;
	}

	/**
	 * @param district the district to set
	 */
	public void setDistrict(String district) {
		this.district = district;
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

}
