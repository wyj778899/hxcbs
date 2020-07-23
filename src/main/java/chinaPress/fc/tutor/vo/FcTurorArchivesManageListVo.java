package chinaPress.fc.tutor.vo;

public class FcTurorArchivesManageListVo {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * 导师姓名
	 */
	private String name;
	/**
	 * 导师图片
	 */
	private String picture;
	/**
	 * 上级
	 */
	private String parent;

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
	 * 获取：parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * 设置：parent
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

}
