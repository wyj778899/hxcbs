package chinaPress.exam.exam_signup.vo;

import java.math.BigDecimal;
import java.util.List;

public class FcExamSignupManageDetailVo {
	/**
	 * 考试报名表
	 */
	private Integer id;

	/**
	 * 考试报名名称
	 */
	private String signupName;

	/**
	 * 关联课程id
	 */
	private Integer courseId;

	/**
	 * 关联课程名称
	 */
	private String courseName;

	/**
	 * 关联证书
	 */
	private Integer certId;

	/**
	 * 关联证书名称
	 */
	private String certName;

	/**
	 * 考试形式(1现场0非现场)
	 */
	private Integer examForm;

	/**
	 * 是否允许补考(1允许,0不允许)
	 */
	private Integer againType;

	/**
	 * 补考价格
	 */
	private BigDecimal againPrice;

	/**
	 * 报名log图片
	 */
	private String bannerPhoto;

	/**
	 * 上架/下架(1上架，0下架)
	 */
	private Integer isPutaway;

	/**
	 * 备注
	 */
	private String remarks;

	/**
	 * 区域
	 */
	private List<FcExamSignupManageDetailAreaVo> areaList;

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
	 * @return the courseId
	 */
	public Integer getCourseId() {
		return courseId;
	}

	/**
	 * @param courseId the courseId to set
	 */
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
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
	 * @return the certId
	 */
	public Integer getCertId() {
		return certId;
	}

	/**
	 * @param certId the certId to set
	 */
	public void setCertId(Integer certId) {
		this.certId = certId;
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
	 * @return the examForm
	 */
	public Integer getExamForm() {
		return examForm;
	}

	/**
	 * @param examForm the examForm to set
	 */
	public void setExamForm(Integer examForm) {
		this.examForm = examForm;
	}

	/**
	 * @return the againType
	 */
	public Integer getAgainType() {
		return againType;
	}

	/**
	 * @param againType the againType to set
	 */
	public void setAgainType(Integer againType) {
		this.againType = againType;
	}

	/**
	 * @return the againPrice
	 */
	public BigDecimal getAgainPrice() {
		return againPrice;
	}

	/**
	 * @param againPrice the againPrice to set
	 */
	public void setAgainPrice(BigDecimal againPrice) {
		this.againPrice = againPrice;
	}

	/**
	 * @return the bannerPhoto
	 */
	public String getBannerPhoto() {
		return bannerPhoto;
	}

	/**
	 * @param bannerPhoto the bannerPhoto to set
	 */
	public void setBannerPhoto(String bannerPhoto) {
		this.bannerPhoto = bannerPhoto;
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
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * @return the areaList
	 */
	public List<FcExamSignupManageDetailAreaVo> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList the areaList to set
	 */
	public void setAreaList(List<FcExamSignupManageDetailAreaVo> areaList) {
		this.areaList = areaList;
	}

}
