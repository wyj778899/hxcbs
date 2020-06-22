package chinaPress.fc.self_test.vo;

import java.util.List;

public class FcSelfTestStemInsertParam {

	/**
	 * 题干id
	 */
	private Integer stemId;

	/**
	 * 选项集合
	 */
	private List<FcSelfTestStemOptionInsertParam> optionList;

	public Integer getStemId() {
		return stemId;
	}

	public void setStemId(Integer stemId) {
		this.stemId = stemId;
	}

	public List<FcSelfTestStemOptionInsertParam> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<FcSelfTestStemOptionInsertParam> optionList) {
		this.optionList = optionList;
	}
}
