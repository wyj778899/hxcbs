package chinaPress.fc.apply.model;

import java.util.Date;

/**
 * fc_apply_person
 * @author Chaoqun
 * @date 2020-06-22 11:03:15
 */
public class FcApplyPerson {
    /**
     * 报名关联人员
     */
    private Integer id;

    /**
     * 主表id
     */
    private Integer applyId;

    /**
     * 角色id
     */
    private Integer roleId;

    /**
     * 角色类型（1.家长2.从业者）
     */
    private Integer roleType;

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

    
    /**
     *20200827 wyj    add    机构报名导出用户信息不完整
     *姓名
     */
    private String personName;
    
    /**
     * 性别
     */
    private Integer personSex;
    
    /**
     * 年龄
     */
    private Integer personAge;
    
    /**
     * 学历
     */
    private String personEducation;
    
    /**
     *身份证号 
     */
    private String certificateNumber;
    
    /**
     * 手机号
     */
    private String tellPhone;
    
    /**
     * 岗位
     */
    private String post;
    
    /**
     * 工作年限
     */
    private Integer workYear;
    
    /**
     * 省市区
     */
    private String proviceCityArea;
    
    /**
     * 详细地址
     */
    private String address;
    
    /**
     * 邮寄地址
     */
    private String mailingAddress;
    
    /**
     * 用户名
     */
    private String userName;
    
    /**
	 * 民族
	 */
	private String personEthnic;
	
	/**
	 * 籍贯
	 */
	private String nativePlace;
	
	/**
	 * 机构名称
	 */
    private String institutionName;
    
    
    public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}


	public String getPersonEthnic() {
		return personEthnic;
	}

	public void setPersonEthnic(String personEthnic) {
		this.personEthnic = personEthnic;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getMailingAddress() {
		return mailingAddress;
	}

	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public Integer getPersonSex() {
		return personSex;
	}

	public void setPersonSex(Integer personSex) {
		this.personSex = personSex;
	}

	public Integer getPersonAge() {
		return personAge;
	}

	public void setPersonAge(Integer personAge) {
		this.personAge = personAge;
	}

	public String getPersonEducation() {
		return personEducation;
	}

	public void setPersonEducation(String personEducation) {
		this.personEducation = personEducation;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getTellPhone() {
		return tellPhone;
	}

	public void setTellPhone(String tellPhone) {
		this.tellPhone = tellPhone;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Integer getWorkYear() {
		return workYear;
	}

	public void setWorkYear(Integer workYear) {
		this.workYear = workYear;
	}

	public String getProviceCityArea() {
		return proviceCityArea;
	}

	public void setProviceCityArea(String proviceCityArea) {
		this.proviceCityArea = proviceCityArea;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/**
     * 报名关联人员
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 报名关联人员
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 主表id
     * @return applyId
     */
    public Integer getApplyId() {
        return applyId;
    }

    /**
     * 主表id
     * @param applyId
     */
    public void setApplyId(Integer applyId) {
        this.applyId = applyId;
    }

    /**
     * 角色id
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色id
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 角色类型（1.家长2.从业者）
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 角色类型（1.家长2.从业者）
     * @param roleType
     */
	public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * 创建人
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人
     * @param createId
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 创建时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 更新人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 更新时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}