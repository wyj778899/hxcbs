package chinaPress.fc.course_section.vo;

public class FcCourseHourVo {
	
	private Integer id;
	private Integer sectionId;//章节id
	private String name;//视频名称
	private String address;//视频地址
	private String url;//视频流地址
	private Integer format;//视频类型
	private Integer isLook;//是否试看0否1是
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
	

}
