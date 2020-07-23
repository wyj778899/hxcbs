package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户订单发票信息    管理端发票展示
 * @author wyj
 *
 */
public class UserInvoiceInfo {

	/**
	 * 订单编号
	 */
	private Integer id;
	
	/**
	 * 发票类型
	 */
	private String invoiceType;
	
	/**
	 * 发癖金额
	 */
	private BigDecimal payAmount;
	
	/**
	 * 用户名
	 */
	private String userName;
	
	/**
	 * 申请时间，用户发起发癖申请会更新时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date updateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
