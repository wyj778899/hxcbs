package chinaPress.fc.order.vo;

import chinaPress.common.param.PageParam;

public class TerminalInstitutionOrderPersonParam extends PageParam {

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 订单id
	 */
	private Integer orderId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
}
