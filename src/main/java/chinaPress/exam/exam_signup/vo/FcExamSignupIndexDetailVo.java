package chinaPress.exam.exam_signup.vo;

import java.util.List;

public class FcExamSignupIndexDetailVo extends FcExamSignupIndexVo {
	/**
	 * 考试报名id
	 */
	private Integer id;
	/**
	 * 考试介绍
	 */
	private String remarks;
	/**
	 * 考试区域
	 */
	private List<FcExamSignupIndexDetailAreaVo> areaList;

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
	public List<FcExamSignupIndexDetailAreaVo> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList the areaList to set
	 */
	public void setAreaList(List<FcExamSignupIndexDetailAreaVo> areaList) {
		this.areaList = areaList;
	}

}
