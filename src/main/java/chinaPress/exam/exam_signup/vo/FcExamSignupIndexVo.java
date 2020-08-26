package chinaPress.exam.exam_signup.vo;

public class FcExamSignupIndexVo {
	/**
	 * 考试报名id
	 */
	private Integer id;
	/**
	 * 考试报名封面
	 */
	private String cover;
	/**
	 * 考试报名名称
	 */
	private String name;
	/**
	 * 考试形式
	 */
	private String form;
	/**
	 * 考试报名人数
	 */
	private Integer count;

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
	 * @return the cover
	 */
	public String getCover() {
		return cover;
	}

	/**
	 * @param cover the cover to set
	 */
	public void setCover(String cover) {
		this.cover = cover;
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
	 * 获取：form
	 */
	public String getForm() {
		return form;
	}

	/**
	 * 设置：form
	 */
	public void setForm(String form) {
		this.form = form;
	}

	/**
	 * 获取：count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 设置：count
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
