package chinaPress.common.tree.model;

import java.util.List;

public class TreeNode {
	/**
	 * 节点id
	 */
	private Integer id;
	/**
	 * 父级节点id
	 */
	private Integer pId;
	/**
	 * 节点名称
	 */
	private String name;
	/**
	 * 节点编码
	 */
	private String code;
	/**
	 * 节点图片
	 */
	private String picture;
	/**
	 * 节点等级
	 */
	private Integer level;
	/**
	 * 子节点
	 */
	private List<TreeNode> children;

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
	 * 获取：code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置：code
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * 获取：level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * 设置：level
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * 获取：children
	 */
	public List<TreeNode> getChildren() {
		return children;
	}

	/**
	 * 设置：children
	 */
	public void setChildren(List<TreeNode> children) {
		this.children = children;
	}
}
