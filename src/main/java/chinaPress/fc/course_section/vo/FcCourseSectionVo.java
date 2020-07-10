package chinaPress.fc.course_section.vo;

import java.util.List;

public class FcCourseSectionVo {
	/**
	 * id
	 */
	private Integer id;
	/**
	 * pId
	 */
	private Integer pId;
	/**
	 * 名称
	 */
	private String name;
	/**
	 * 编码
	 */
	private String code;
	/**
	 * 主讲人
	 */
	private String speaker;
	/**
	 * 时长
	 */
	private String duration;
	/**
	 * 有没有小节题
	 */
	private Integer isHaveQuestion;

	private List<FcCourseSectionVo> children;

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
	 * 获取：speaker
	 */
	public String getSpeaker() {
		return speaker;
	}

	/**
	 * 设置：speaker
	 */
	public void setSpeaker(String speaker) {
		this.speaker = speaker;
	}

	/**
	 * 获取：duration
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * 设置：duration
	 */
	public void setDuration(String duration) {
		this.duration = duration;
	}

	/**
	 * 获取：isHaveQuestion
	 */
	public Integer getIsHaveQuestion() {
		return isHaveQuestion;
	}

	/**
	 * 设置：isHaveQuestion
	 */
	public void setIsHaveQuestion(Integer isHaveQuestion) {
		this.isHaveQuestion = isHaveQuestion;
	}

	/**
	 * 获取：children
	 */
	public List<FcCourseSectionVo> getChildren() {
		return children;
	}

	/**
	 * 设置：children
	 */
	public void setChildren(List<FcCourseSectionVo> children) {
		this.children = children;
	}
}
