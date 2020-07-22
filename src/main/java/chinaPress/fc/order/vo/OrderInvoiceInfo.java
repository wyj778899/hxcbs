package chinaPress.fc.order.vo;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 订单的发票信息
 * @author wyj
 * 20200720  add
 */
public class OrderInvoiceInfo {

	
	/**
	 * 订单id
	 */
	private Integer id;
	
	/**
	 * 订单日期
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	/**
	 * 订单编号
	 */
	private String code;
	
	/**
	 * 订单金额
	 */
	private BigDecimal payAmount; 
	
	/**
	 * 订单类型
	 */
	private String invoiceType;
	
	/**
	 * 订单名称
	 */
	private String name;
	
	/**
	 * 发票抬头
	 */
	private String invoiceTitle;
	
	/**
	 * 发票税号
	 */
	private String invoiceNumber;
	
	/**
	 * 开户银行
	 */
	private String bankDeposit;

	
	/**
	 * 银行账号
	 */
	private String bankNumber;
	
	/**
	 * 备注信息
	 */
	private String remarks;
	
	/**
	 * 邮箱
	 */
	private String email;
	
	
	
	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getBankDeposit() {
		return bankDeposit;
	}

	public void setBankDeposit(String bankDeposit) {
		this.bankDeposit = bankDeposit;
	}

	public String getBankNumber() {
		return bankNumber;
	}

	public void setBankNumber(String bankNumber) {
		this.bankNumber = bankNumber;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public BigDecimal getPayAmount() {
		return payAmount;
	}

	public void setPayAmount(BigDecimal payAmount) {
		this.payAmount = payAmount;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
