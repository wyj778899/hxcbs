package chinaPress.fc.order.vo;

public class TerminalInstitutionOrderPersonVo {

	private Integer id;

	/**
	 * 姓名
	 */
	private String name;

	/**
	 * 性别（1.男2，女）
	 */
	private Integer sex;

	/**
	 * 手机号
	 */
	private String tellPhone;

	/**
	 * 总章节数
	 */
	private Integer totalCount;

	/**
	 * 已经看过的数量
	 */
	private Integer haveCount;

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

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getHaveCount() {
		return haveCount;
	}

	public void setHaveCount(Integer haveCount) {
		this.haveCount = haveCount;
	}
}
