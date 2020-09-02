package chinaPress.exam.paper.vo;

import java.util.List;

/**
 * 试题和答案信息
 * @author wyj
 *
 */
public class StemOption {
	
	/**
	 * 试卷id
	 */
	private Integer paperId;
	
	/**
	 * 试题id
	 */
	private Integer stemId;
	
	/**
	 * 试题分数
	 */
	private String grade;
	
	/**
	 * 正确答案的id
	 */
	private List<Integer> options;
	

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}

	public Integer getStemId() {
		return stemId;
	}

	public void setStemId(Integer stemId) {
		this.stemId = stemId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public List<Integer> getOptions() {
		return options;
	}

	public void setOptions(List<Integer> options) {
		this.options = options;
	}


}
