package chinaPress.exam.group.model;

/**
 * fc_group_user
 * @author wyj
 * @date 2020-08-26 11:37:32
 */
public class FcGroupUser {
    /**
     * 分组和家长/从业者关联表
     */
    private Integer id;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 家长/从业者id
     */
    private Integer roleId;

    /**
     * 分组和家长/从业者关联表
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 分组和家长/从业者关联表
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 分组id
     * @return groupId
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 分组id
     * @param groupId
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 家长/从业者id
     * @return roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 家长/从业者id
     * @param roleId
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}