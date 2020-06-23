package chinaPress.fc.question.vo;

public class FcQuestionOptionVo {
	
	private Integer id;
	//题干id
	private Integer stemId;
	//选项类型（数字1.2.3.4.....对应ABCD）
	private Integer optionType;
	//选项名称
	private String optionName;
	//是否正确（0.错误1.正确）
	private Integer isCorrect;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getStemId() {
		return stemId;
	}
	public void setStemId(Integer stemId) {
		this.stemId = stemId;
	}
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
