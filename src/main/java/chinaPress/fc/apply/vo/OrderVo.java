package chinaPress.fc.apply.vo;

import java.util.Date;

public class OrderVo {

	/**
	 * 订单状态   1.未支付2.已支付3.已关闭
	 */
	private Integer payStatus;
	
	/**
	 * 订单时间
	 */
	private Date createTime;

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
}
