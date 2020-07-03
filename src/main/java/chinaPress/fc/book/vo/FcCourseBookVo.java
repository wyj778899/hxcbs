package chinaPress.fc.book.vo;

import java.math.BigDecimal;

public class FcCourseBookVo {
	/**
	 * 书籍档案id
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
	 * 内含几套
	 */
	private String sets;

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
	 * 获取：sets
	 */
	public String getSets() {
		return sets;
	}

	/**
	 * 设置：sets
	 */
	public void setSets(String sets) {
		this.sets = sets;
	}

}
