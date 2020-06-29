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
	private String stemName;

	/**
	 * 类型（1.单选2.多选3.判断）
	 */
	private Integer stemType;

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

	public String getStemName() {
		return stemName;
	}

	public void setStemName(String stemName) {
		this.stemName = stemName;
	}

	public Integer getStemType() {
		return stemType;
	}

	public void setStemType(Integer stemType) {
		this.stemType = stemType;
	}

	public List<FcSelfTestStemOptionDetailVo> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<FcSelfTestStemOptionDetailVo> optionList) {
		this.optionList = optionList;
	}
}
