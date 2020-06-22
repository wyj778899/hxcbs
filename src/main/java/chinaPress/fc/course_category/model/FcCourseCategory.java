package chinaPress.fc.course_category.model;

import java.util.Date;

/**
 * fc_course_category
 * @author Administrator
 * @date 2020-06-17 17:44:46
 */
public class FcCourseCategory {
    /**
     * 课程分类
     */
    private Integer id;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 分类名称
     */
    private String name;

    /**
     * 分类编码
     */
    private String code;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 是否末级(0.否.1.是)
     */
    private Integer isLast;

    /**
     * 级别类型
     */
    private Integer isLevel;

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
     * 课程分类
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 课程分类
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 父级id
     * @return pid
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * 父级id
     * @param pid
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     * 分类名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 分类名称
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 分类编码
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 分类编码
     * @param code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 备注
     * @return remarks
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注
     * @param remarks
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 是否末级(0.否.1.是)
     * @return isLast
     */
    public Integer getIsLast() {
        return isLast;
    }

    /**
     * 是否末级(0.否.1.是)
     * @param isLast
     */
    public void setIsLast(Integer isLast) {
        this.isLast = isLast;
    }

    /**
     * 级别类型
     * @return isLevel
     */
    public Integer getIsLevel() {
        return isLevel;
    }

    /**
     * 级别类型
     * @param isLevel
     */
    public void setIsLevel(Integer isLevel) {
        this.isLevel = isLevel;
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