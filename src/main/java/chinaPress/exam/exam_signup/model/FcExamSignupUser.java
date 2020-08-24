package chinaPress.exam.exam_signup.model;

import java.util.Date;

/**
 * fc_exam_signup_user
 * @author Administrator
 * @date 2020-08-17 14:37:25
 */
public class FcExamSignupUser {
    /**
     * 考生信息表
     */
    private Integer id;

    /**
     * 考试报名id
     */
    private Integer signupId;

    /**
     * 考生头像
     */
    private String userHead;

    /**
     * 考生名称
     */
    private String userName;

    /**
     * 学历
     */
    private String education;

    /**
     * 手机号
     */
    private String tellPhone;

    /**
     * 身份证号
     */
    private String certificateNumber;

    /**
     * 身份证照片正面
     */
    private String certificateFront;

    /**
     * 身份证照片反面
     */
    private String certificateBehind;

    /**
     * 手持身份证照片
     */
    private String handCertificate;

    /**
     * 省
     */
    private String province;

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
     * 职务/职称
     */
    private String post;

    /**
     * 所在机构
     */
    private String institutionName;

    /**
     * 审核状态(0未审核,1已审核,2已驳回,3已报考)
     */
    private Integer examineType;

    /**
     * 报名区域id
     */
    private Integer areaId;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 归属角色id
     */
    private Integer roleId;

    /**
     * 归属角色类型（1.家长2.从业者）
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
     * 考生信息表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考生信息表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 考试报名id
     * @return signupId
     */
    public Integer getSignupId() {
        return signupId;
    }

    /**
     * 考试报名id
     * @param signupId
     */
    public void setSignupId(Integer signupId) {
        this.signupId = signupId;
    }

    /**
     * 考生头像
     * @return userHead
     */
    public String getUserHead() {
        return userHead;
    }

    /**
     * 考生头像
     * @param userHead
     */
    public void setUserHead(String userHead) {
        this.userHead = userHead;
    }

    /**
     * 考生名称
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 考生名称
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 学历
     * @return education
     */
    public String getEducation() {
        return education;
    }

    /**
     * 学历
     * @param education
     */
    public void setEducation(String education) {
        this.education = education;
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
     * 身份证号
     * @return certificateNumber
     */
    public String getCertificateNumber() {
        return certificateNumber;
    }

    /**
     * 身份证号
     * @param certificateNumber
     */
    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    /**
     * 身份证照片正面
     * @return certificateFront
     */
    public String getCertificateFront() {
        return certificateFront;
    }

    /**
     * 身份证照片正面
     * @param certificateFront
     */
    public void setCertificateFront(String certificateFront) {
        this.certificateFront = certificateFront;
    }

    /**
     * 身份证照片反面
     * @return certificateBehind
     */
    public String getCertificateBehind() {
        return certificateBehind;
    }

    /**
     * 身份证照片反面
     * @param certificateBehind
     */
    public void setCertificateBehind(String certificateBehind) {
        this.certificateBehind = certificateBehind;
    }

    /**
     * 手持身份证照片
     * @return handCertificate
     */
    public String getHandCertificate() {
        return handCertificate;
    }

    /**
     * 手持身份证照片
     * @param handCertificate
     */
    public void setHandCertificate(String handCertificate) {
        this.handCertificate = handCertificate;
    }

    /**
     * 省
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province
     */
    public void setProvince(String province) {
        this.province = province;
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
     * 职务/职称
     * @return post
     */
    public String getPost() {
        return post;
    }

    /**
     * 职务/职称
     * @param post
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 所在机构
     * @return institutionName
     */
    public String getInstitutionName() {
        return institutionName;
    }

    /**
     * 所在机构
     * @param institutionName
     */
    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    /**
     * 审核状态(0未审核,1已审核,2已驳回,3已报考)
     * @return examineType
     */
    public Integer getExamineType() {
        return examineType;
    }

    /**
     * 审核状态(0未审核,1已审核,2已驳回,3已报考)
     * @param examineType
     */
    public void setExamineType(Integer examineType) {
        this.examineType = examineType;
    }

    /**
     * 报名区域id
     * @return areaId
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 报名区域id
     * @param areaId
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 备注
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 归属角色id
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 归属角色id
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 归属角色类型（1.家长2.从业者）
     * @return roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * 归属角色类型（1.家长2.从业者）
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