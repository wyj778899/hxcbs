package chinaPress.fc.question.model;

import java.util.Date;

/**
 * fc_question_option
 * @author Administrator
 * @date 2020-06-18 16:48:19
 */
public class FcQuestionOption {
    /**
     * 选项
     */
    private Integer id;

    /**
     * 关联题干id
     */
    private Integer stemId;

    /**
     * 选项类型（数字1.2.3.4.....对应ABCD）
     */
    private Integer optionType;

    /**
     * 选项名称
     */
    private String optionName;

    /**
     * 是否正确（0.错误1.正确）
     */
    private Integer isCorrect;

    /**
     * 1.删除0.不可以删除
     */
    private Integer isDelete;

    /**
     * 状态(0.否,1.是)
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
     * 选项
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 选项
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 关联题干id
     * @return stemId
     */
    public Integer getStemId() {
        return stemId;
    }

    /**
     * 关联题干id
     * @param stemId
     */
    public void setStemId(Integer stemId) {
        this.stemId = stemId;
    }

    /**
     * 选项类型（数字1.2.3.4.....对应ABCD）
     * @return optionType
     */
    public Integer getOptionType() {
        return optionType;
    }

    /**
     * 选项类型（数字1.2.3.4.....对应ABCD）
     * @param optionType
     */
    public void setOptionType(Integer optionType) {
        this.optionType = optionType;
    }

    /**
     * 选项名称
     * @return optionName
     */
    public String getOptionName() {
        return optionName;
    }

    /**
     * 选项名称
     * @param optionName
     */
    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    /**
     * 是否正确（0.错误1.正确）
     * @return isCorrect
     */
    public Integer getIsCorrect() {
        return isCorrect;
    }

    /**
     * 是否正确（0.错误1.正确）
     * @param isCorrect
     */
    public void setIsCorrect(Integer isCorrect) {
        this.isCorrect = isCorrect;
    }

    /**
     * 1.删除0.不可以删除
     * @return isDelete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 1.删除0.不可以删除
     * @param isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 状态(0.否,1.是)
     * @return state
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态(0.否,1.是)
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