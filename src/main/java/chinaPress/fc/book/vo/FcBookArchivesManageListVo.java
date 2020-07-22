package chinaPress.fc.book.vo;

import java.math.BigDecimal;

public class FcBookArchivesManageListVo {
	/**
	 * id
	 */
	private Integer id;

	/**
	 * 书籍名称
	 */
	private String name;

	/**
	 * 书籍图片
	 */
	private String picture;

	/**
	 * 书籍价格
	 */
	private BigDecimal price;

	/**
	 * 作者
	 */
	private String author;

	/**
	 * 开本
	 */
	private Integer size;

	/**
	 * 页码
	 */
	private Integer page;

	/**
	 * isbn
	 */
	private String isbn;

	/**
	 * 版次
	 */
	private String edition;

	/**
	 * 出版社
	 */
	private String press;

	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 获取：name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 设置：name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 获取：picture
	 */
	public String getPicture() {
		return picture;
	}

	/**
	 * 设置：picture
	 */
	public void setPicture(String picture) {
		this.picture = picture;
	}

	/**
	 * 获取：price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * 设置：price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	/**
	 * 获取：author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * 设置：author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * 获取：size
	 */
	public Integer getSize() {
		return size;
	}

	/**
	 * 设置：size
	 */
	public void setSize(Integer size) {
		this.size = size;
	}

	/**
	 * 获取：page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * 设置：page
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * 获取：isbn
	 */
	public String getIsbn() {
		return isbn;
	}

	/**
	 * 设置：isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	/**
	 * 获取：edition
	 */
	public String getEdition() {
		return edition;
	}

	/**
	 * 设置：edition
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}

	/**
	 * 获取：press
	 */
	public String getPress() {
		return press;
	}

	/**
	 * 设置：press
	 */
	public void setPress(String press) {
		this.press = press;
	}
}
