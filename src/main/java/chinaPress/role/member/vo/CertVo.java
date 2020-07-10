package chinaPress.role.member.vo;


/**
 * 证书信息    20200709     add
 * @author wyj
 *
 */
public class CertVo {

	/**
	 * 证书图片
	 */
	private String photo;
	
	/**
	 * 证书编码
	 */
	private String code;
	
	/**
	 * 分数
	 */
	private String grade;
	
	/**
	 * 证书编号
	 */
	private Integer id;
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
}
