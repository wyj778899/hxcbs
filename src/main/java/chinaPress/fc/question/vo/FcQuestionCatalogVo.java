package chinaPress.fc.question.vo;

/**
 * 试题分类目录
 * @author wyj
 *
 */
public class FcQuestionCatalogVo {

	/**
	 * 分类id
	 */
	private Integer id;
	
	/**
	 * 分类名称
	 */
	private String name;
	
	/**
	 * 分类试题个数
	 */
	private Integer count;
	
	/**
	 * 简单单选
	 */
	private Integer simpleRadioCount;
	
	/**
	 * 简单多选
	 */
	private Integer simpleCheckboxCount;
	
	/**
	 * 简单判断
	 */
	private Integer simpleJudgeCount;
	
	/**
	 * 一般单选
	 */
	private Integer commonlyRadioCount;
	
	/**
	 * 一般多选
	 */
	private Integer commonlyCheckboxCount;
	
	/**
	 * 一般判断
	 */
	private Integer commonlyJudgeCount;
	
	/**
	 * 困难单选
	 */
	private Integer difficultyRadioCount;
	
	/**
	 * 困难多选
	 */
	private Integer difficultyCheckboxCount;
	
	/**
	 * 困难判断
	 */
	private Integer difficultyJudgeCount;

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

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

	public Integer getSimpleRadioCount() {
		return simpleRadioCount;
	}

	public void setSimpleRadioCount(Integer simpleRadioCount) {
		this.simpleRadioCount = simpleRadioCount;
	}

	public Integer getSimpleCheckboxCount() {
		return simpleCheckboxCount;
	}

	public void setSimpleCheckboxCount(Integer simpleCheckboxCount) {
		this.simpleCheckboxCount = simpleCheckboxCount;
	}

	public Integer getSimpleJudgeCount() {
		return simpleJudgeCount;
	}

	public void setSimpleJudgeCount(Integer simpleJudgeCount) {
		this.simpleJudgeCount = simpleJudgeCount;
	}

	public Integer getCommonlyRadioCount() {
		return commonlyRadioCount;
	}

	public void setCommonlyRadioCount(Integer commonlyRadioCount) {
		this.commonlyRadioCount = commonlyRadioCount;
	}

	public Integer getCommonlyCheckboxCount() {
		return commonlyCheckboxCount;
	}

	public void setCommonlyCheckboxCount(Integer commonlyCheckboxCount) {
		this.commonlyCheckboxCount = commonlyCheckboxCount;
	}

	public Integer getCommonlyJudgeCount() {
		return commonlyJudgeCount;
	}

	public void setCommonlyJudgeCount(Integer commonlyJudgeCount) {
		this.commonlyJudgeCount = commonlyJudgeCount;
	}

	public Integer getDifficultyRadioCount() {
		return difficultyRadioCount;
	}

	public void setDifficultyRadioCount(Integer difficultyRadioCount) {
		this.difficultyRadioCount = difficultyRadioCount;
	}

	public Integer getDifficultyCheckboxCount() {
		return difficultyCheckboxCount;
	}

	public void setDifficultyCheckboxCount(Integer difficultyCheckboxCount) {
		this.difficultyCheckboxCount = difficultyCheckboxCount;
	}

	public Integer getDifficultyJudgeCount() {
		return difficultyJudgeCount;
	}

	public void setDifficultyJudgeCount(Integer difficultyJudgeCount) {
		this.difficultyJudgeCount = difficultyJudgeCount;
	}

}
