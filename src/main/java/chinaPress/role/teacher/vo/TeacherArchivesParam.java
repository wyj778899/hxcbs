package chinaPress.role.teacher.vo;

import java.util.List;

import chinaPress.role.member.model.CertificateInfo;

public class TeacherArchivesParam {
	private Integer id;
	private String photo;
	private String name;
	private String idCard;
	private String grade;
	private List<CertificateInfo> certificateList;
	public List<CertificateInfo> getCertificateList() {
		return certificateList;
	}
	public void setCertificateList(List<CertificateInfo> certificateList) {
		this.certificateList = certificateList;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

}
