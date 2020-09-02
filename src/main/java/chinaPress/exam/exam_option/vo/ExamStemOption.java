package chinaPress.exam.exam_option.vo;

/**
 * 考生已完成的考试试题以及答案信息
 * @author wyj
 *
 */
public class ExamStemOption {

	/**
	 * 考试的试题id
	 */
	private Integer stemId;
	
	/**
	 * 考试的试题答案
	 */
	private String optionId;

	public Integer getStemId() {
		return stemId;
	}

	public void setStemId(Integer stemId) {
		this.stemId = stemId;
	}

	public String getOptionId() {
		return optionId;
	}

	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	
}
