package chinaPress.fc.self_test.vo;

import java.util.List;

public class FcSelfTestStemDetailVo {

	/**
	 * 自测关联题干
	 */
	private Integer id;

	/**
	 * 题干id
	 */
	private Integer stemId;

	/**
	 * 题干名称
	 */
	private Integer stemName;

	/**
	 * 选项集合
	 */
	private List<FcSelfTestStemOptionDetailVo> optionList;

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

	public Integer getStemName() {
		return stemName;
	}

	public void setStemName(Integer stemName) {
		this.stemName = stemName;
	}

	public List<FcSelfTestStemOptionDetailVo> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<FcSelfTestStemOptionDetailVo> optionList) {
		this.optionList = optionList;
	}
}
