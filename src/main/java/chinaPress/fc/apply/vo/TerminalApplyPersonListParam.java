package chinaPress.fc.apply.vo;

import chinaPress.common.param.PageParam;

public class TerminalApplyPersonListParam extends PageParam {

	/**
	 * 申请id
	 */
	private Integer applyId;

	/**
	 * 姓名
	 */
	private String name;

	public Integer getApplyId() {
		return applyId;
	}

	public void setApplyId(Integer applyId) {
		this.applyId = applyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
