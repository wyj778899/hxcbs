package chinaPress.fc.self_test.vo;

import java.math.BigDecimal;
import java.util.List;

public class FcSelfTestDetailVo {

	/**
	 * 自测
	 */
	private Integer id;

	/**
	 * 分数
	 */
	private BigDecimal score;

	/**
	 * 课程名称
	 */
	private String courseName;

	/**
	 * 题干集合
	 */
	private List<FcSelfTestStemDetailVo> stemList;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getScore() {
		return score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public List<FcSelfTestStemDetailVo> getStemList() {
		return stemList;
	}

	public void setStemList(List<FcSelfTestStemDetailVo> stemList) {
		this.stemList = stemList;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
