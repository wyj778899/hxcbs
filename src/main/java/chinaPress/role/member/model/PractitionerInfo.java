package chinaPress.role.member.model;

import java.util.Date;

/**
 * role_practitioner_archives
 * @author Administrator
 * @date 2020-06-17 13:13:47
 */
public class PractitionerInfo {
    /**
     * 家长/从业者
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 姓名
     */
    private String name;

    /**
     * 手机号
     */
    private String tellPhone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 证件号码
     */
    private String certificateNumber;

    /**
     * 性别（1.男2.女）
     */
    private Integer sex;

    /**
     * 省
     */
    private String provice;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 1.家长2.从业者
     */
    private Integer type;

    /**
     * 是否是个人（0.否1.是）
     */
    private Integer isIndividual;

    /**
     * 所属单位
     */
    private Integer institutionId;

    /**
     * 状态（0.无效1.有效）
     */
    private Integer state;

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
     * 企业编码
     */
    private String enterpriseCode;

    /**
     * 当前页数
     */
    private Integer page;
    
    /**
     * 每页条数
     */
    private Integer limit;
    
    /**
     * 验证码   用于添加注册
     */
    private String verificationCode;
    
    /**
     * 真实姓名
     */
    private String realName;
    
    /**
     * 公司姓名
     */
    private String institutionName;
    
    
    /**
     * 孩子生日
     */
    private Date birthdayTime;
    
    
    /**
     * 公司地址
     */
    private String institutionAddress;
    
    
    
    
    
    
    public String getInstitutionAddress() {
		return institutionAddress;
	}

	public void setInstitutionAddress(String institutionAddress) {
		this.institutionAddress = institutionAddress;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	public Date getBirthdayTime() {
		return birthdayTime;
	}

	public void setBirthdayTime(Date birthdayTime) {
		this.birthdayTime = birthdayTime;
	}

	/**
     * 验证码
     * @return verificationCode
     */
    public String getVerificationCode() {
		return verificationCode;
	}

    /**
     * 验证码
     * @param verificationCode
     */
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	
	
    /**
     * 当前页数
     * @return page
     */
    public Integer getPage() {
		return page;
	}

    /**
     * 当前页数
     * @param page
     */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
     * 显示的条数
     * @return limit
     */
	public Integer getLimit() {
		return limit;
	}

	/**
     * 显示的条数
     * @param limit
     */
	public void setLimit(Integer limit) {
		this.limit = limit;
	}
    
    /**
     * 家长/从业者
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 家长/从业者
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 密码
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 姓名
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 手机号
     * @return tellPhone
     */
    public String getTellPhone() {
        return tellPhone;
    }

    /**
     * 手机号
     * @param tellPhone
     */
    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    /**
     * 邮箱
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 证件号码
     * @return certificateNumber
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * 证件号码
     * @param certificateNumber
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    /**
     * 性别（1.男2.女）
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 性别（1.男2.女）
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 省
     * @return provice
     */
    public String getProvice() {
        return provice;
    }

    /**
     * 省
     * @param provice
     */
    public void setProvice(String provice) {
        this.provice = provice;
    }

    /**
     * 市
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 区
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 区
     * @param area
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 详细地址
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 1.家长2.从业者
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1.家长2.从业者
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 是否是个人（0.否1.是）
     * @return isIndividual
     */
    public Integer getIsIndividual() {
        return isIndividual;
    }

    /**
     * 是否是个人（0.否1.是）
     * @param isIndividual
     */
    public void setIsIndividual(Integer isIndividual) {
        this.isIndividual = isIndividual;
    }

    /**
     * 所属单位
     * @return institutionId
     */
    public Integer getInstitutionId() {
        return institutionId;
    }

    /**
     * 所属单位
     * @param institutionId
     */
    public void setInstitutionId(Integer institutionId) {
        this.institutionId = institutionId;
    }

    /**
     * 状态（0.无效1.有效）
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态（0.无效1.有效）
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
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

    /**
     * 企业编码
     * @return enterpriseCode
     */
    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    /**
     * 企业编码
     * @param enterpriseCode
     */
    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }
}