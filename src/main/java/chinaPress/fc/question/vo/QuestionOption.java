package chinaPress.fc.question.vo;

/**
 * 答案信息
 * @author wyj
 *
 */
public class QuestionOption{
	
	/**
	 * 答案id
	 */
	private Integer oId;
	
	/**
	 * 选项类型
	 */
	private Integer optionType;
	
	/**
	 * 选项名称
	 */
	private String optionName; 
	
	/**
	 * 是否正确
	 */
	private Integer isCorrect;

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
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
