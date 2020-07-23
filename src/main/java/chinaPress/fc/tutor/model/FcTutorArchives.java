package chinaPress.fc.tutor.model;

import java.util.Date;

/**
 * fc_tutor_archives
 * @author Administrator
 * @date 2020-07-23 10:37:48
 */
public class FcTutorArchives {
    /**
     */
    private Integer id;

    /**
     * 上级导师
     */
    private Integer pid;

    /**
     * 导师姓名
     */
    private String name;

    /**
     * 导师图片
     */
    private String picture;

    /**
     * 导师介绍
     */
    private String produce;

    /**
     * 创建人
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改人
     */
    private Integer updateId;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 上级导师
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 上级导师
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 导师姓名
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 导师姓名
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 导师图片
     * @return picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     * 导师图片
     * @param picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    /**
     * 导师介绍
     * @return produce
     */
    public String getProduce() {
        return produce;
    }

    /**
     * 导师介绍
     * @param produce
     */
    public void setProduce(String produce) {
        this.produce = produce;
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
     * 修改人
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 修改人
     * @param updateId
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     * 修改时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 修改时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}