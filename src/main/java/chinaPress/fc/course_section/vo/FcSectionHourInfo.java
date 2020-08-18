package chinaPress.fc.course_section.vo;

/**
 * 课程关联章节展示
 * @author wyj
 * 展示课程的id,章节的名称
 */
public class FcSectionHourInfo {

	/**
	 * 课程id
	 */
	private Integer id;
	
	/**
	 * 章节名称
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
