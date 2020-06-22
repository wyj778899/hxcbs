package chinaPress.fc.coupon.model;

import java.util.Date;

/**
 * fc_discount_coupon_course
 * @author Administrator
 * @date 2020-06-19 14:50:01
 */
public class FcDiscountCouponCourse {
    /**
     * 优惠券关联课程
     */
    private Integer id;

    /**
     * 优惠券配置id
     */
    private Integer couponId;

    /**
     * 关联课程id
     */
    private Integer courseId;

    /**
     * 状态（0.否1.是）
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
     * 优惠券关联课程
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 优惠券关联课程
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 优惠券配置id
     * @return couponId
     */
    public Integer getCouponId() {
        return couponId;
    }

    /**
     * 优惠券配置id
     * @param couponId
     */
    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    /**
     * 关联课程id
     * @return courseId
     */
    public Integer getCourseId() {
        return courseId;
    }

    /**
     * 关联课程id
     * @param courseId
     */
    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    /**
     * 状态（0.否1.是）
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态（0.否1.是）
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
}