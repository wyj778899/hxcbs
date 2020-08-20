package chinaPress.exam.exam_signup.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_exam_signup
 * @author Administrator
 * @date 2020-08-17 14:37:25
 */
public class FcExamSignup {
    /**
     * 考试报名表
     */
    private Integer id;

    /**
     * 考试报名名称
     */
    private String signupName;

    /**
     * 考试报名人数
     */
    private Integer signupCount;

    /**
     * 关联课程
     */
    private Integer courseId;

    /**
     * 关联证书
     */
    private Integer certId;

    /**
     * 考试形式(1现场0非现场)
     */
    private Integer examForm;

    /**
     * 是否允许补考(1允许,0不允许)
     */
    private Integer againType;

    /**
     * 补考价格
     */
    private BigDecimal againPrice;

    /**
     * 报名log图片
     */
    private String bannerPhoto;

    /**
     * 上架/下架(1上架，0下架)
     */
    private Integer isPutaway;

    /**
     * 备注
     */
    private String remarks;

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
     * 考试报名表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 考试报名表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 考试报名名称
     * @return signupName
     */
    public String getSignupName() {
        return signupName;
    }

    /**
     * 考试报名名称
     * @param signupName
     */
    public void setSignupName(String signupName) {
        this.signupName = signupName;
    }

    /**
     * 考试报名人数
     * @return signupCount
     */
    public Integer getSignupCount() {
        return signupCount;
    }

    /**
     * 考试报名人数
     * @param signupCount
     */
    public void setSignupCount(Integer signupCount) {
        this.signupCount = signupCount;
    }

    /**
     * 关联课程
     * @return courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 关联课程
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 关联证书
     * @return certId
     */
    public Integer getCertId() {
        return certId;
    }

    /**
     * 关联证书
     * @param certId
     */
    public void setCertId(Integer certId) {
        this.certId = certId;
    }

    /**
     * 考试形式(1现场0非现场)
     * @return examForm
     */
    public Integer getExamForm() {
        return examForm;
    }

    /**
     * 考试形式(1现场0非现场)
     * @param examForm
     */
    public void setExamForm(Integer examForm) {
        this.examForm = examForm;
    }

    /**
     * 是否允许补考(1允许,0不允许)
     * @return againType
     */
    public Integer getAgainType() {
        return againType;
    }

    /**
     * 是否允许补考(1允许,0不允许)
     * @param againType
     */
    public void setAgainType(Integer againType) {
        this.againType = againType;
    }

    /**
     * 补考价格
     * @return againPrice
     */
    public BigDecimal getAgainPrice() {
        return againPrice;
    }

    /**
     * 补考价格
     * @param againPrice
     */
    public void setAgainPrice(BigDecimal againPrice) {
        this.againPrice = againPrice;
    }

    /**
     * 报名log图片
     * @return bannerPhoto
     */
    public String getBannerPhoto() {
        return bannerPhoto;
    }

    /**
     * 报名log图片
     * @param bannerPhoto
     */
    public void setBannerPhoto(String bannerPhoto) {
        this.bannerPhoto = bannerPhoto;
    }

    /**
     * 上架/下架(1上架，0下架)
     * @return isPutaway
     */
    public Integer getIsPutaway() {
        return isPutaway;
    }

    /**
     * 上架/下架(1上架，0下架)
     * @param isPutaway
     */
    public void setIsPutaway(Integer isPutaway) {
        this.isPutaway = isPutaway;
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