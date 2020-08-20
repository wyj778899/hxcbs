package chinaPress.exam.exam_signup.vo;

import java.util.List;

public class FcExamSignupIndexDetailVo extends FcExamSignupIndexVo {
	/**
	 * 考试报名id
	 */
	private Integer id;
	/**
	 * 考试报名名称
	 */
	private String name;
	/**
	 * 考试报名封面
	 */
	private String banner;
	/**
	 * 考试形式
	 */
	private String form;
	/**
	 * 考试报名人数
	 */
	private Integer count;
	/**
	 * 考试介绍
	 */
	private String remarks;
	/**
	 * 考试区域
	 */
	private List<FcExamSignupIndexDetailAreaVo> areaList;

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
	 * 获取：banner
	 */
	public String getBanner() {
		return banner;
	}

	/**
	 * 设置：banner
	 */
	public void setBanner(String banner) {
		this.banner = banner;
	}

	/**
	 * 获取：form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * 设置：form
	 */
	public void setForm(String form) {
		this.form = form;
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
	 * 获取：remarks
	 */
	public String getRemarks() {
		return remarks;
	}

	/**
	 * 设置：remarks
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 * 获取：areaList
	 */
	public List<FcExamSignupIndexDetailAreaVo> getAreaList() {
		return areaList;
	}

	/**
	 * 设置：areaList
	 */
	public void setAreaList(List<FcExamSignupIndexDetailAreaVo> areaList) {
		this.areaList = areaList;
	}
}
