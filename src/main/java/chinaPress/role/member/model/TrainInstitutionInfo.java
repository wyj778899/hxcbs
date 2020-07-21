package chinaPress.role.member.model;

import java.util.Date;

/**
 * role_institution_archives
 * @author Administrator
 * @date 2020-06-17 13:11:25
 */
public class TrainInstitutionInfo {
    /**
     * 培训机构
     */
    private Integer id;

    /**
     * 公司名称
     */
    private String name;

    /**
     * 公司编码
     */
    private String code;

    /**
     * 法人
     */
    private String legalPerson;

    /**
     * 证件号码
     */
    private String certificateNumber;

    /**
     * 注册人姓名
     */
    private String registerName;

    /**
     * 注册人手机号
     */
    private String registerTell;

    /**
     * 注册人证件号
     */
    private String registerCertificate;

    /**
     * 注册省
     */
    private String registerProvice;

    /**
     * 注册市
     */
    private String registerCity;

    /**
     * 注册区
     */
    private String registerArea;

    /**
     * 注册详细地址
     */
    private String registerAddress;

    /**
     * 办公省
     */
    private String businessProvice;

    /**
     * 办公市
     */
    private String businessCity;

    /**
     * 办公区
     */
    private String businessArea;

    /**
     * 办公详细地址
     */
    private String businessAddress;

    /**
     * 营业执照
     */
    private String businessPhoto;

    /**
     * 从业执照
     */
    private String practitionerPhoto;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 审核状态（1.未审核2.已审核3.已拒绝）
     */
    private Integer auditStatus;

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
     * 用户头像
     */
    private String userHead;
    
    /**
     * 20200707   wyj   add
     * 注册人机构职位
     */
    private String registerPost;
    
    /**
     * 业务范围
     */
    private String scopeBusiness;
    
    /**
     * 机构简介
     */
    private String orgProfile;
    
    /**
     * 服务内容
     */
    private String serviceContent;
    
    /**
     * 办学特色
     */
    private String schoolStyle;
    
    /**
     * 教师队伍
     */
    private String teacherRanks;
    
    /**
     * 其他展示
     */
    private String otherReveal;
    
    
	/**
     * 是否为中国残联定点机构
     */
    private Integer isFlag;
    
    /** 
	 * 注册来源   1华夏      2恩起
	 */
	private Integer source;

	
	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

    
    public String getScopeBusiness() {
		return scopeBusiness;
	}

	public void setScopeBusiness(String scopeBusiness) {
		this.scopeBusiness = scopeBusiness;
	}

	public String getOrgProfile() {
		return orgProfile;
	}

	public void setOrgProfile(String orgProfile) {
		this.orgProfile = orgProfile;
	}

	public String getServiceContent() {
		return serviceContent;
	}

	public void setServiceContent(String serviceContent) {
		this.serviceContent = serviceContent;
	}

	public String getSchoolStyle() {
		return schoolStyle;
	}

	public void setSchoolStyle(String schoolStyle) {
		this.schoolStyle = schoolStyle;
	}

	public String getTeacherRanks() {
		return teacherRanks;
	}

	public void setTeacherRanks(String teacherRanks) {
		this.teacherRanks = teacherRanks;
	}

	public String getOtherReveal() {
		return otherReveal;
	}

	public void setOtherReveal(String otherReveal) {
		this.otherReveal = otherReveal;
	}

	public String getRegisterPost() {
		return registerPost;
	}

	public void setRegisterPost(String registerPost) {
		this.registerPost = registerPost;
	}
	
    public Integer getIsFlag() {
		return isFlag;
	}

	public void setIsFlag(Integer isFlag) {
		this.isFlag = isFlag;
	}

	public String getUserHead() {
		return userHead;
	}

	public void setUserHead(String userHead) {
		this.userHead = userHead;
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
     * 培训机构
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 培训机构
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 公司名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 公司名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 公司编码
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 公司编码
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 法人
     * @return legalPerson
     */
    public String getLegalPerson() {
        return legalPerson;
    }

    /**
     * 法人
     * @param legalPerson
     */
    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
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
     * 注册人姓名
     * @return registerName
     */
    public String getRegisterName() {
        return registerName;
    }

    /**
     * 注册人姓名
     * @param registerName
     */
    public void setRegisterName(String registerName) {
        this.registerName = registerName;
    }

    /**
     * 注册人手机号
     * @return registerTell
     */
    public String getRegisterTell() {
        return registerTell;
    }

    /**
     * 注册人手机号
     * @param registerTell
     */
    public void setRegisterTell(String registerTell) {
        this.registerTell = registerTell;
    }

    /**
     * 注册人证件号
     * @return registerCertificate
     */
    public String getRegisterCertificate() {
        return registerCertificate;
    }

    /**
     * 注册人证件号
     * @param registerCertificate
     */
    public void setRegisterCertificate(String registerCertificate) {
        this.registerCertificate = registerCertificate;
    }

    /**
     * 注册省
     * @return registerProvice
     */
    public String getRegisterProvice() {
        return registerProvice;
    }

    /**
     * 注册省
     * @param registerProvice
     */
    public void setRegisterProvice(String registerProvice) {
        this.registerProvice = registerProvice;
    }

    /**
     * 注册市
     * @return registerCity
     */
    public String getRegisterCity() {
        return registerCity;
    }

    /**
     * 注册市
     * @param registerCity
     */
    public void setRegisterCity(String registerCity) {
        this.registerCity = registerCity;
    }

    /**
     * 注册区
     * @return registerArea
     */
    public String getRegisterArea() {
        return registerArea;
    }

    /**
     * 注册区
     * @param registerArea
     */
    public void setRegisterArea(String registerArea) {
        this.registerArea = registerArea;
    }

    /**
     * 注册详细地址
     * @return registerAddress
     */
    public String getRegisterAddress() {
        return registerAddress;
    }

    /**
     * 注册详细地址
     * @param registerAddress
     */
    public void setRegisterAddress(String registerAddress) {
        this.registerAddress = registerAddress;
    }

    /**
     * 办公省
     * @return businessProvice
     */
    public String getBusinessProvice() {
        return businessProvice;
    }

    /**
     * 办公省
     * @param businessProvice
     */
    public void setBusinessProvice(String businessProvice) {
        this.businessProvice = businessProvice;
    }

    /**
     * 办公市
     * @return businessCity
     */
    public String getBusinessCity() {
        return businessCity;
    }

    /**
     * 办公市
     * @param businessCity
     */
    public void setBusinessCity(String businessCity) {
        this.businessCity = businessCity;
    }

    /**
     * 办公区
     * @return businessArea
     */
    public String getBusinessArea() {
        return businessArea;
    }

    /**
     * 办公区
     * @param businessArea
     */
    public void setBusinessArea(String businessArea) {
        this.businessArea = businessArea;
    }

    /**
     * 办公详细地址
     * @return businessAddress
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * 办公详细地址
     * @param businessAddress
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    /**
     * 营业执照
     * @return businessPhoto
     */
    public String getBusinessPhoto() {
        return businessPhoto;
    }

    /**
     * 营业执照
     * @param businessPhoto
     */
    public void setBusinessPhoto(String businessPhoto) {
        this.businessPhoto = businessPhoto;
    }

    /**
     * 从业执照
     * @return practitionerPhoto
     */
    public String getPractitionerPhoto() {
        return practitionerPhoto;
    }

    /**
     * 从业执照
     * @param practitionerPhoto
     */
    public void setPractitionerPhoto(String practitionerPhoto) {
        this.practitionerPhoto = practitionerPhoto;
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
     * 审核状态（1.未审核2.已审核3.已拒绝）
     * @return auditStatus
     */
    public Integer getAuditStatus() {
        return auditStatus;
    }

    /**
     * 审核状态（1.未审核2.已审核3.已拒绝）
     * @param auditStatus
     */
    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
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