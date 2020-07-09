package chinaPress.fc.order.model;

/**
 * fc_order_book
 * 
 * @author 53129
 * @date 2020-07-03 20:26:19
 */
public class FcOrderBook {
	/**
	 * 订单书籍id
	 */
	private Integer id;

	/**
	 * 订单id
	 */
	private Integer orderId;

	/**
	 * 书籍id
	 */
	private Integer bookId;

	/**
	 * 订单书籍id
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 订单书籍id
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 订单id
	 * 
	 * @return orderId
	 */
	public Integer getOrderId() {
		return orderId;
	}

	/**
	 * 订单id
	 * 
	 * @param orderId
	 */
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	/**
	 * 书籍id
	 * 
	 * @return bookId
	 */
	public Integer getBookId() {
		return bookId;
	}

	/**
	 * 书籍id
	 * 
	 * @param bookId
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}

	public FcOrderBook() {
		super();
	}

	public FcOrderBook(Integer orderId, Integer bookId) {
		super();
		this.orderId = orderId;
		this.bookId = bookId;
	}
}