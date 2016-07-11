package net.tfedu.zhl.sso.role.entity;

import javax.persistence.*;

@Table(name = "j_rolegroup")
public class JRoleGroup {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户组编号
     */
    @Column(name = "group_id")
    private Long groupId;

    /**
     * 用户编号
     */
    @Column(name = "role_id")
    private Long roleId;

    /**
     * 系统模块
     */
    private String model;

    /**
     * 0-公共,1-子系统自定义
     */
    private Boolean tag;

    public JRoleGroup(Long id, Long groupId, Long roleId, String model, Boolean tag) {
        this.id = id;
        this.groupId = groupId;
        this.roleId = roleId;
        this.model = model;
        this.tag = tag;
    }

    public JRoleGroup() {
        super();
    }

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id 编号
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户组编号
     *
     * @return group_id - 用户组编号
     */
    public Long getGroupId() {
        return groupId;
    }

    /**
     * 设置用户组编号
     *
     * @param groupId 用户组编号
     */
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取用户编号
     *
     * @return role_id - 用户编号
     */
    public Long getRoleId() {
        return roleId;
    }

    /**
     * 设置用户编号
     *
     * @param roleId 用户编号
     */
    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    /**
     * 获取系统模块
     *
     * @return model - 系统模块
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置系统模块
     *
     * @param model 系统模块
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取0-公共,1-子系统自定义
     *
     * @return tag - 0-公共,1-子系统自定义
     */
    public Boolean getTag() {
        return tag;
    }

    /**
     * 设置0-公共,1-子系统自定义
     *
     * @param tag 0-公共,1-子系统自定义
     */
    public void setTag(Boolean tag) {
        this.tag = tag;
    }
}