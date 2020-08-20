package chinaPress.exam.group.model;

import java.util.Date;

/**
 * fc_group
 * @author Administrator
 * @date 2020-08-20 19:07:57
 */
public class FcGroup {
    /**
     * 从业人员分组表
     */
    private Integer id;

    /**
     * 分组名称
     */
    private String groupName;

    /**
     * 备注
     */
    private String remarks;

    /**
     * 分组序号
     */
    private Integer groupSort;

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
     * 从业人员分组表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 从业人员分组表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 分组名称
     * @return groupName
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 分组名称
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
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
     * 分组序号
     * @return groupSort
     */
    public Integer getGroupSort() {
        return groupSort;
    }

    /**
     * 分组序号
     * @param groupSort
     */
    public void setGroupSort(Integer groupSort) {
        this.groupSort = groupSort;
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