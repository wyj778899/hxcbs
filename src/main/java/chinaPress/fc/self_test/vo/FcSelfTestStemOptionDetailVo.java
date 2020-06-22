package chinaPress.fc.self_test.vo;

public class FcSelfTestStemOptionDetailVo {

	/**
	 * 自测题干选项
	 */
	private Integer id;

	/**
	 * 选项id
	 */
	private Integer optionId;

	/**
	 * 选项类型（数字1.2.3.4.....对应ABCD）
	 */
	private Integer optionType;

	/**
	 * 选项名称
	 */
	private Integer optionName;

	/**
	 * 是否选中（0.否1.是）
	 */
	private Integer isSelect;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOptionId() {
		return optionId;
	}

	public void setOptionId(Integer optionId) {
		this.optionId = optionId;
	}

	public Integer getOptionType() {
		return optionType;
	}

	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
	}

	public Integer getOptionName() {
		return optionName;
	}

	public void setOptionName(Integer optionName) {
		this.optionName = optionName;
	}

	public Integer getIsSelect() {
		return isSelect;
	}

	public void setIsSelect(Integer isSelect) {
		this.isSelect = isSelect;
	}
}
