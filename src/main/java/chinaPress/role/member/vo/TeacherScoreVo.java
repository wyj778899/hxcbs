package chinaPress.role.member.vo;


/**
 * 教师成绩显示字段      20200709 add
 * @author wyj
 * 
 */
public class TeacherScoreVo {

	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 证件号
	 */
	private String certificateNumber;
	
	/**
	 * 成绩
	 */
	private String score;
	
	/**
	 * 头像
	 */
	private String photo;
	

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}
	
	
	
	
}
