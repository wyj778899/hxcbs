package chinaPress.exam.exam.vo;

import java.util.List;

public class FcExamManageDetailVo {
	/**
	 * 考试id
	 */
	private Integer id;
	/**
	 * 考试名称
	 */
	private String name;
	/**
	 * 考试地点省
	 */
	private String province;
	/**
	 * 考试地点市
	 */
	private String city;
	/**
	 * 考试地点区
	 */
	private String district;
	/**
	 * 考试详细地址
	 */
	private String address;
	/**
	 * 关联报名信息
	 */
	private Integer signupId;
	/**
	 * 考试报名名称
	 */
	private String signupName;
	/**
	 * 关联试卷
	 */
	private Integer paperId;
	/**
	 * 关联试卷名称
	 */
	private String paperName;
	/**
	 * 试卷分数
	 */
	private Double grade;
	/**
	 * 试卷总分
	 */
	private Double totalGrade;
	/**
	 * 考试及格评语
	 */
	private String passComment;
	/**
	 * 考试不及格评语
	 */
	private String failComment;

	/**
	 * 提前入场时间分钟数
	 */
	private Integer advanceTime;

	/**
	 * 考试报名区域时间
	 */
	private List<FcExamManageDetailAreaVo> areaList;
	/**
	 * 关联人员
	 */
	private List<FcExamManageDetailUserVo> userList;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the signupId
	 */
	public Integer getSignupId() {
		return signupId;
	}

	/**
	 * @param signupId the signupId to set
	 */
	public void setSignupId(Integer signupId) {
		this.signupId = signupId;
	}

	/**
	 * @return the signupName
	 */
	public String getSignupName() {
		return signupName;
	}

	/**
	 * @param signupName the signupName to set
	 */
	public void setSignupName(String signupName) {
		this.signupName = signupName;
	}

	/**
	 * @return the paperId
	 */
	public Integer getPaperId() {
		return paperId;
	}

	/**
	 * @param paperId the paperId to set
	 */
	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	/**
	 * @return the paperName
	 */
	public String getPaperName() {
		return paperName;
	}

	/**
	 * @param paperName the paperName to set
	 */
	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	/**
	 * @return the grade
	 */
	public Double getGrade() {
		return grade;
	}

	/**
	 * @param grade the grade to set
	 */
	public void setGrade(Double grade) {
		this.grade = grade;
	}

	/**
	 * @return the totalGrade
	 */
	public Double getTotalGrade() {
		return totalGrade;
	}

	/**
	 * @param totalGrade the totalGrade to set
	 */
	public void setTotalGrade(Double totalGrade) {
		this.totalGrade = totalGrade;
	}

	/**
	 * @return the passComment
	 */
	public String getPassComment() {
		return passComment;
	}

	/**
	 * @param passComment the passComment to set
	 */
	public void setPassComment(String passComment) {
		this.passComment = passComment;
	}

	/**
	 * @return the failComment
	 */
	public String getFailComment() {
		return failComment;
	}

	/**
	 * @param failComment the failComment to set
	 */
	public void setFailComment(String failComment) {
		this.failComment = failComment;
	}

	/**
	 * @return the advanceTime
	 */
	public Integer getAdvanceTime() {
		return advanceTime;
	}

	/**
	 * @param advanceTime the advanceTime to set
	 */
	public void setAdvanceTime(Integer advanceTime) {
		this.advanceTime = advanceTime;
	}

	/**
	 * @return the areaList
	 */
	public List<FcExamManageDetailAreaVo> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList the areaList to set
	 */
	public void setAreaList(List<FcExamManageDetailAreaVo> areaList) {
		this.areaList = areaList;
	}

	/**
	 * @return the userList
	 */
	public List<FcExamManageDetailUserVo> getUserList() {
		return userList;
	}

	/**
	 * @param userList the userList to set
	 */
	public void setUserList(List<FcExamManageDetailUserVo> userList) {
		this.userList = userList;
	}
}
