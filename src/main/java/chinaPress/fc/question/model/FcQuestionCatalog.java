package chinaPress.fc.question.model;

import java.util.Date;

/**
 * fc_question_catalog
 * @author wyj
 * @date 2020-07-24 18:49:54
 */
public class FcQuestionCatalog {
    /**
     * 试题分类
     */
    private Integer id;

    /**
     * 分类名称
     */
    private String catalogName;

    /**
     * 分类序号
     */
    private Integer catalogSort;

    /**
     * 是否有效0无效,1有效
     */
    private Integer state;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者id
     */
    private Integer updateId;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 试题分类
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 试题分类
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 分类名称
     * @return catalogName
     */
    public String getCatalogName() {
        return catalogName;
    }

    /**
     * 分类名称
     * @param catalogName
     */
    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    /**
     * 分类序号
     * @return catalogSort
     */
    public Integer getCatalogSort() {
        return catalogSort;
    }

    /**
     * 分类序号
     * @param catalogSort
     */
    public void setCatalogSort(Integer catalogSort) {
        this.catalogSort = catalogSort;
    }

    /**
     * 是否有效0无效,1有效
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 是否有效0无效,1有效
     * @param state
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 创建人id
     * @return createId
     */
    public Integer getCreateId() {
        return createId;
    }

    /**
     * 创建人id
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
     * 更新者id
     * @return updateId
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     * 更新者id
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