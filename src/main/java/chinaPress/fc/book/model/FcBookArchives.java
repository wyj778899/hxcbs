package chinaPress.fc.book.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * fc_book_archives
 * @author Administrator
 * @date 2020-07-02 14:28:41
 */
public class FcBookArchives {
    /**
     * id
     */
    private Integer id;

    /**
     * 书籍名称
     */
    private String name;

    /**
     * 书籍图片
     */
    private String picture;

    /**
     * 书籍价格
     */
    private BigDecimal price;

    /**
     * 书籍二维码
     */
    private String qrcode;

    /**
     * 几套
     */
    private String sets;

    /**
     * 书籍创建人
     */
    private Integer createId;

    /**
     * 书籍创建时间
     */
    private Date createTime;

    /**
     * 书籍最后更新人
     */
    private Integer updateId;

    /**
     * 书籍最后更新时间
     */
    private Date updateTime;

    /**
     * id
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 书籍名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 书籍名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 书籍图片
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 书籍图片
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 书籍价格
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 书籍价格
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 书籍二维码
     * @return qrcode
     */
    public String getQrcode() {
        return qrcode;
    }

    /**
     * 书籍二维码
     * @param qrcode
     */
    public void setQrcode(String qrcode) {
        this.qrcode = qrcode;
    }

    /**
     * 几套
     * @return sets
     */
    public String getSets() {
        return sets;
    }

    /**
     * 几套
     * @param sets
     */
    public void setSets(String sets) {
        this.sets = sets;
    }

    /**
     * 书籍创建人
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 书籍创建人
     * @param createId
     */
    public void setCreateId(Integer createId) {
        this.createId = createId;
    }

    /**
     * 书籍创建时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 书籍创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 书籍最后更新人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 书籍最后更新人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 书籍最后更新时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 书籍最后更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}