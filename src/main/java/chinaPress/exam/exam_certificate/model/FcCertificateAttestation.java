package chinaPress.exam.exam_certificate.model;

import java.util.Date;

/**
 * fc_certificate_attestation
 * @author wyj
 * @date 2020-09-01 21:10:33
 */
public class FcCertificateAttestation {
    /**
     * 证书认证档案
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
     * 创建人
     */
    private Integer createId;

    /**
     * CURRENT_TIMESTAMP
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
     * 证书认证档案
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 证书认证档案
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 证书名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 证书名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 证书图片
     * @return photo
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * 证书图片
     * @param photo
     */
    public void setPhoto(String photo) {
        this.photo = photo;
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
     * CURRENT_TIMESTAMP
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * CURRENT_TIMESTAMP
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