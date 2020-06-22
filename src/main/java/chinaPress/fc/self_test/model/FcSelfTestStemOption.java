package chinaPress.fc.self_test.model;

import java.util.Date;

/**
 * fc_self_test_stem_option
 * @author Chaoqun
 * @date 2020-06-19 16:10:02
 */
public class FcSelfTestStemOption {
    /**
     * 自测题干选项
     */
    private Integer id;

    /**
     * 主表id
     */
    private Integer testStemId;

    /**
     * 选项id
     */
    private Integer optionId;

    /**
     * 是否选中（0.否1.是）
     */
    private Integer isSelect;

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
     * 自测题干选项
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 自测题干选项
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 主表id
     * @return testStemId
     */
    public Integer getTestStemId() {
        return testStemId;
    }

    /**
     * 主表id
     * @param testStemId
     */
    public void setTestStemId(Integer testStemId) {
        this.testStemId = testStemId;
    }

    /**
     * 选项id
     * @return optionId
     */
    public Integer getOptionId() {
        return optionId;
    }

    /**
     * 选项id
     * @param optionId
     */
    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    /**
     * 是否选中（0.否1.是）
     * @return isSelect
     */
    public Integer getIsSelect() {
        return isSelect;
    }

    /**
     * 是否选中（0.否1.是）
     * @param isSelect
     */
    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
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