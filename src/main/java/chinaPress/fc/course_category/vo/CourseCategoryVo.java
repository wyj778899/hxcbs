package chinaPress.fc.course_category.vo;

import java.util.List;


public class CourseCategoryVo {
	private Integer id;
	private Integer pid;
	private String name;
	private String code;
	private List<CourseCategoryVo> children;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public List<CourseCategoryVo> getChildren() {
		return children;
	}
	public void setChildren(List<CourseCategoryVo> children) {
		this.children = children;
	}

}
