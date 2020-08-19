package chinaPress.fc.question.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 每个分类下的所有试题信息
 * @author wyj
 *
 */
public class FcQuestionInfo {

	/**
	 * 试题id
	 */
	private Integer id;
	
	
	/**
	 * 试题名称
	 */
	private String questionStem;
	
	
	/**
	 * 试题分类
	 */
	private String catalogName;
	
	
	/**
	 * 创建人
	 */
	private String userName;
	
	
	/**
	 * 创建时间
	 */
	@JsonFormat(pattern ="yyyy-MM-dd")
	private String createTime;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getQuestionStem() {
		return questionStem;
	}


	public void setQuestionStem(String questionStem) {
		this.questionStem = questionStem;
	}


	public String getCatalogName() {
		return catalogName;
	}


	public void setCatalogName(String catalogName) {
		this.catalogName = catalogName;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getCreateTime() {
		return createTime;
	}


	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	
	
}
