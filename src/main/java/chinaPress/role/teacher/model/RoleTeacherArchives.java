package chinaPress.role.teacher.model;

import java.util.Date;

/**
 * role_teacher_archives
 * 
 * @author Administrator
 * @date 2020-06-29 11:12:33
 */
public class RoleTeacherArchives {
	/**
	 * 教师档案
	 */
	private Integer id;

	/**
	 * 头像
	 */
	private String photo;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 性别（1.男2.女）
	 */
	private Integer sex;

	/**
	 * 身份证
	 */
	private String idCard;

	/**
	 * 分数
	 */
	private String grade;

	/**
	 * 工作单位
	 */
	private String workAddress;

	/**
	 * 学历
	 */
	private String education;

	/**
	 * 职务
	 */
	private String position;

	/**
	 * 住址
	 */
	private String address;

	/**
	 * 电话
	 */
	private String tellPhone;

	/**
	 * 创建人
	 */
	private Integer createId;

	/**
	 * 创建时间
	 */
	private Date createTime;

	/**
	 * 更新人
	 */
	private Integer updateId;

	/**
	 * 更新时间
	 */
	private Date updateTime;

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	/**
	 * 教师档案
	 * 
	 * @return id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 教师档案
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 名称
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * 名称
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 身份证
	 * 
	 * @return idCard
	 */
	public String getIdCard() {
		return idCard;
	}

	/**
	 * 身份证
	 * 
	 * @param idCard
	 */
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	/**
	 * 分数
	 * 
	 * @return grade
	 */
	public String getGrade() {
		return grade;
	}

	/**
	 * 分数
	 * 
	 * @param grade
	 */
	public void setGrade(String grade) {
		this.grade = grade;
	}

	/**
	 * 创建人
	 * 
	 * @return createId
	 */
	public Integer getCreateId() {
		return createId;
	}

	/**
	 * 创建人
	 * 
	 * @param createId
	 */
	public void setCreateId(Integer createId) {
		this.createId = createId;
	}

	/**
	 * 创建时间
	 * 
	 * @return createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 * 
	 * @param createTime
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * 更新人
	 * 
	 * @return updateId
	 */
	public Integer getUpdateId() {
		return updateId;
	}

	/**
	 * 更新人
	 * 
	 * @param updateId
	 */
	public void setUpdateId(Integer updateId) {
		this.updateId = updateId;
	}

	/**
	 * 更新时间
	 * 
	 * @return updateTime
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * 更新时间
	 * 
	 * @param updateTime
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getWorkAddress() {
		return workAddress;
	}

	public void setWorkAddress(String workAddress) {
		this.workAddress = workAddress;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

}