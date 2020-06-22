package chinaPress.fc.self_test.model;

import java.util.Date;

/**
 * fc_self_test_stem
 * @author Chaoqun
 * @date 2020-06-19 16:09:41
 */
public class FcSelfTestStem {
    /**
     * 自测关联题干
     */
    private Integer id;

    /**
     * 关联主表id
     */
    private Integer testId;

    /**
     * 题干id
     */
    private Integer stemId;

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
     * 自测关联题干
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自测关联题干
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 关联主表id
     * @return testId
     */
    public Integer getTestId() {
        return testId;
    }

    /**
     * 关联主表id
     * @param testId
     */
    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    /**
     * 题干id
     * @return stemId
     */
    public Integer getStemId() {
        return stemId;
    }

    /**
     * 题干id
     * @param stemId
     */
    public void setStemId(Integer stemId) {
        this.stemId = stemId;
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