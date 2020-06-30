package chinaPress.role.teacher.vo;

public class OptionParam {
	
	private Integer optionType;//选项类型（数字1.2.3.4.....对应ABCD）
	private String optionName;//选项名称
	private Integer isCorrect;//是否正确（0.错误1.正确）
	public Integer getOptionType() {
		return optionType;
	}
	public void setOptionType(Integer optionType) {
		this.optionType = optionType;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public Integer getIsCorrect() {
		return isCorrect;
	}
	public void setIsCorrect(Integer isCorrect) {
		this.isCorrect = isCorrect;
	}

}
