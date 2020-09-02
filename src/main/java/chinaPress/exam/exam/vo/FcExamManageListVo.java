package chinaPress.exam.exam.vo;

import java.util.List;

public class FcExamManageListVo {
	/**
	 * 考试设置id
	 */
	private Integer id;
	/**
	 * 考试设置名称
	 */
	private String name;
	/**
	 * 考试类型
	 */
	private String typeName;
	/**
	 * 考试形式
	 */
	private String formName;

	/**
	 * 区域
	 */
	private List<FcExamManageListAreaVo> areaList;

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

	/**
	 * @return the formName
	 */
	public String getFormName() {
		return formName;
	}

	/**
	 * @param formName the formName to set
	 */
	public void setFormName(String formName) {
		this.formName = formName;
	}

	/**
	 * @return the areaList
	 */
	public List<FcExamManageListAreaVo> getAreaList() {
		return areaList;
	}

	/**
	 * @param areaList the areaList to set
	 */
	public void setAreaList(List<FcExamManageListAreaVo> areaList) {
		this.areaList = areaList;
	}
}
