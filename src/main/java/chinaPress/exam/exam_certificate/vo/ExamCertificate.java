package chinaPress.exam.exam_certificate.vo;

/**
 * 考试证书信息数据回显
 * @author wyj
 *
 */
public class ExamCertificate {

	private Integer id;
	
	
	private String name;
	
	
	private String photo;

	
	public String getPhoto() {
		return photo;
	}


	public void setPhoto(String photo) {
		this.photo = photo;
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
	
}
