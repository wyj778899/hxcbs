package chinaPress.exam.paper.vo;
/**
 * 试卷信息展示
 * @author wyj
 *
 */
public class PaperStemVo {

	/**
	 * 试卷id
	 */
	private Integer paperId;
	
	/**
	 * 试卷名称
	 */
	private String paperName;
	
	/**
	 * 试卷类型
	 */
	private String paperType;
	
	/**
	 * 试卷分数
	 */
	private String papergrade;
	
	/**
	 * 试卷试题个数
	 */
	private Integer count;

	public String getPaperName() {
		return paperName;
	}

	public void setPaperName(String paperName) {
		this.paperName = paperName;
	}

	public String getPaperType() {
		return paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getPapergrade() {
		return papergrade;
	}

	public void setPapergrade(String papergrade) {
		this.papergrade = papergrade;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPaperId() {
		return paperId;
	}

	public void setPaperId(Integer paperId) {
		this.paperId = paperId;
	}
	
	
}
