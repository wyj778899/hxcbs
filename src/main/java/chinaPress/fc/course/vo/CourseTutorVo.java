package chinaPress.fc.course.vo;

import java.util.List;

public class CourseTutorVo {
	/**
	 * 导师id
	 */
	private Integer id;
	/**
	 * 父级id
	 */
	private Integer pId;
	/**
	 * 导师姓名
	 */
	private String name;
	/**
	 * 导师图片
	 */
	private String picture;
	/**
	 * 子级
	 */
	private List<CourseTutorVo> children;

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
	 * 获取：pId
	 */
	public Integer getpId() {
		return pId;
	}

	/**
	 * 设置：pId
	 */
	public void setpId(Integer pId) {
		this.pId = pId;
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
	 * 获取：children
	 */
	public List<CourseTutorVo> getChildren() {
		return children;
	}

	/**
	 * 设置：children
	 */
	public void setChildren(List<CourseTutorVo> children) {
		this.children = children;
	}

}
