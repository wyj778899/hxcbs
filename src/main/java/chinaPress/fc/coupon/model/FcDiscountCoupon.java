package chinaPress.fc.coupon.model;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * fc_discount_coupon
 * @author Administrator
 * @date 2020-06-19 14:50:01
 */
public class FcDiscountCoupon {
    /**
     * 优惠券配置
     */
    private Integer id;

    /**
     * 优惠券名称
     */
    private String name;

    /**
     * 优惠券编码规则
     */
    private String code;

    /**
     * 优惠券数量
     */
    private Integer count;

    /**
     * 类型（1.满减劵2.观影劵）
     */
    private Integer type;

    /**
     * 有效开始时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date startTime;

    /**
     * 有效结束时间
     */
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date endTime;

    /**
     * 满多少
     */
    private BigDecimal enoughMoney;

    /**
     * 减多少
     */
    private BigDecimal discountMoney;

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
     * 优惠券配置
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 优惠券配置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 优惠券名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 优惠券名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 优惠券编码规则
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 优惠券编码规则
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 优惠券数量
     * @return count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 优惠券数量
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 类型（1.满减劵2.观影劵）
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型（1.满减劵2.观影劵）
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 有效开始时间
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 有效开始时间
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 有效结束时间
     * @return endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 有效结束时间
     * @param endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * 满多少
     * @return enoughMoney
     */
    public BigDecimal getEnoughMoney() {
        return enoughMoney;
    }

    /**
     * 满多少
     * @param enoughMoney
     */
    public void setEnoughMoney(BigDecimal enoughMoney) {
        this.enoughMoney = enoughMoney;
    }

    /**
     * 减多少
     * @return discountMoney
     */
    public BigDecimal getDiscountMoney() {
        return discountMoney;
    }

    /**
     * 减多少
     * @param discountMoney
     */
    public void setDiscountMoney(BigDecimal discountMoney) {
        this.discountMoney = discountMoney;
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