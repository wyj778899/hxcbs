package chinaPress.fc.course_section.vo;

public class FcCourseHourVo {

	private Integer id;
	private Integer sectionId;// 章节id
	private String name;// 视频名称
	private String address;// 视频地址
	private String url;// 视频流地址
	private Integer format;// 视频类型
	private Integer isLook;// 是否试看0否1是
	private Integer isHaveStem;// 是否有题1.有题0.没题

	public FcCourseHourVo() {
		super();
	}

	public FcCourseHourVo(Integer id, Integer sectionId, String name, String address, String url, Integer format,
			Integer isLook, Integer isHaveStem) {
		super();
		this.id = id;
		this.sectionId = sectionId;
		this.name = name;
		this.address = address;
		this.url = url;
		this.format = format;
		this.isLook = isLook;
		this.isHaveStem = isHaveStem;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getFormat() {
		return format;
	}

	public void setFormat(Integer format) {
		this.format = format;
	}

	public Integer getIsLook() {
		return isLook;
	}

	public void setIsLook(Integer isLook) {
		this.isLook = isLook;
	}

	/**
	 * 获取：isHaveStem
	 */
	public Integer getIsHaveStem() {
		return isHaveStem;
	}

	/**
	 * 设置：isHaveStem
	 */
	public void setIsHaveStem(Integer isHaveStem) {
		this.isHaveStem = isHaveStem;
	}

}
