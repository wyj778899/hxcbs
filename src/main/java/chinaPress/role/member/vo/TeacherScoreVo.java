package chinaPress.role.member.vo;


/**
 * 教师成绩显示字段      20200709 add
 * @author wyj
 * 
 */
public class TeacherScoreVo {

	
	/**
	 *教师id 
	 */
	private Integer teaId;
	
	
	/**
	 * 证书id
	 */
	private Integer cerId;
	
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
	private String grade;
	
	public Integer getTeaId() {
		return teaId;
	}

	public void setTeaId(Integer teaId) {
		this.teaId = teaId;
	}

	public Integer getCerId() {
		return cerId;
	}

	public void setCerId(Integer cerId) {
		this.cerId = cerId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
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
	
}
