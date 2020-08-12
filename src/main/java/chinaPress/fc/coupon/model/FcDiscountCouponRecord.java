package chinaPress.fc.coupon.model;

import java.util.Date;

/**
 * fc_discount_coupon_record
 * @author Administrator
 * @date 2020-06-19 14:50:01
 */
public class FcDiscountCouponRecord {
    /**
     * 优惠券
     */
    private Integer id;

    /**
     * 优惠劵配置id
     */
    private Integer couponId;

    /**
     * 优惠券编码
     */
    private String code;

    /**
     * 发放角色id
     */
    private Integer grantRoleId;

    /**
     * 发放角色类型（2.机构3.家长4.从业者）
     */
    private Integer grantRoleType;

    /**
     * 1.未发放2.已发放3.已核销
     */
    private Integer status;

    /**
     * 发放时间
     */
    private Date grantTime;

    /**
     * 核销时间
     */
    private Date useTime;

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
     * 优惠券
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 优惠券
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 优惠劵配置id
     * @return couponId
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * 优惠劵配置id
     * @param couponId
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 优惠券编码
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 优惠券编码
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 发放角色id
     * @return grantRoleId
     */
    public Integer getGrantRoleId() {
        return grantRoleId;
    }

    /**
     * 发放角色id
     * @param grantRoleId
     */
    public void setGrantRoleId(Integer grantRoleId) {
        this.grantRoleId = grantRoleId;
    }

    /**
     * 发放角色类型（1.机构2.家长3.从业者）
     * @return grantRoleType
     */
    public Integer getGrantRoleType() {
        return grantRoleType;
    }

    /**
     * 发放角色类型（2.机构3.家长4.从业者）
     * @param grantRoleType
     */
    public void setGrantRoleType(Integer grantRoleType) {
        this.grantRoleType = grantRoleType;
    }

    /**
     * 1.未发放2.已发放3.已核销
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 1.未发放2.已发放3.已核销
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 发放时间
     * @return grantTime
     */
    public Date getGrantTime() {
        return grantTime;
    }

    /**
     * 发放时间
     * @param grantTime
     */
    public void setGrantTime(Date grantTime) {
        this.grantTime = grantTime;
    }

    /**
     * 核销时间
     * @return useTime
     */
    public Date getUseTime() {
        return useTime;
    }

    /**
     * 核销时间
     * @param useTime
     */
    public void setUseTime(Date useTime) {
        this.useTime = useTime;
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