package chinaPress.fc.self_test.vo;

import java.math.BigDecimal;

public class FcSelfTestListVo {

	/**
	 * 自测
	 */
	private Integer id;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 分数
	 */
	private BigDecimal score;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

}
