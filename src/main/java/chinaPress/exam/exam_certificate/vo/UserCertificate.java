package chinaPress.exam.exam_certificate.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 用户的证书信息
 * @author wyj
 *
 */
public class UserCertificate {

	/**
	 * 证书id
	 */
	private Integer id;
	
	/**
	 * 证书名称
	 */
	private String name;
	
	/**
	 * 证书图片
	 */
	private String photo;
	
	/**
	 * 关联课程
	 */
	private String courseName;
	
	/**
	 * 分数
	 */
	private String grade;
	
	/**
	 * 发证时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	private Date createTime;

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

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}
