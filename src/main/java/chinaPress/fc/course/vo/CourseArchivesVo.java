package chinaPress.fc.course.vo;

public class CourseArchivesVo {
	// 课程id
	private Integer id;
	// 课程名称
	private String CourseName;
	// 类型
	private String type;
	// 分类名称
	private String categoryName;
	// 是否上架（0.否1.是）
	private Integer isPutaway;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getIsPutaway() {
		return isPutaway;
	}

	public void setIsPutaway(Integer isPutaway) {
		this.isPutaway = isPutaway;
	}

}
