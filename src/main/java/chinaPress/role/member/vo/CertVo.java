package chinaPress.role.member.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 终端证书详情信息
 * @author wyj
 *
 */
public class CertVo {

	/**
	 * 证书头像
	 */
	private String visibleDeImg;
	
	/**
	 * 证书编码
	 */
	private String code;
	
	/**
	 * 证书分数
	 */
	private String grade;
	
	/**
	 * 发证地址
	 */
	private String testAddress;
	
	/**
	 * 发证时间
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date certificateTime;
	
	/**
	 * 教师资格证所属类别
	 */
	private String courseType;

	public String getVisibleDeImg() {
		return visibleDeImg;
	}

	public void setVisibleDeImg(String visibleDeImg) {
		this.visibleDeImg = visibleDeImg;
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

	public String getTestAddress() {
		return testAddress;
	}

	public void setTestAddress(String testAddress) {
		this.testAddress = testAddress;
	}

	public Date getCertificateTime() {
		return certificateTime;
	}

	public void setCertificateTime(Date certificateTime) {
		this.certificateTime = certificateTime;
	}

	public String getCourseType() {
		return courseType;
	}

	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
}
