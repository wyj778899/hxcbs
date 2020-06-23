package chinaPress.role.member.model;

import java.util.Date;

/**
 * role_register_archives
 * @author Administrator
 * @date 2020-06-17 13:12:12
 */
public class UserInfo {
    /**
     * 注册用户
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
     * 验证码   用于添加注册
     */
    private String verificationCode;
    
    
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
     * 注册用户
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 注册用户
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