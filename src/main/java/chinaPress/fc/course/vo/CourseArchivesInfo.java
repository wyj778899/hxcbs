package chinaPress.fc.course.vo;

/**
 * 有效课程信息   用于试题关联
 * @author wyj
 *
 */
public class CourseArchivesInfo {

	/**
	 * 课程编号
	 */
	private Integer id;
	
	/**
	 * 课程名称
	 */
	private String name;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
