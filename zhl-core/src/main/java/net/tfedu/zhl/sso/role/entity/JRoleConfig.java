package net.tfedu.zhl.sso.role.entity;

import javax.persistence.*;

@Table(name = "j_roleconfig")
public class JRoleConfig {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "RoleId")
    private Long roleid;

    /**
     * 功能id
     */
    @Column(name = "FuncId")
    private Long funcid;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 系统模块
     */
    private String model;

    /**
     * 0-公共,1-子系统自定义
     */
    private Boolean tag;

    public JRoleConfig(Long id, Long roleid, Long funcid, Boolean flag, String model, Boolean tag) {
        this.id = id;
        this.roleid = roleid;
        this.funcid = funcid;
        this.flag = flag;
        this.model = model;
        this.tag = tag;
    }

    public JRoleConfig() {
        super();
    }

    /**
     * 获取自增id
     *
     * @return Id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return RoleId - 用户id
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * 设置用户id
     *
     * @param roleid 用户id
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取功能id
     *
     * @return FuncId - 功能id
     */
    public Long getFuncid() {
        return funcid;
    }

    /**
     * 设置功能id
     *
     * @param funcid 功能id
     */
    public void setFuncid(Long funcid) {
        this.funcid = funcid;
    }

    /**
     * 获取是否删除标示，0-----未删除；1----删除
     *
     * @return Flag - 是否删除标示，0-----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标示，0-----未删除；1----删除
     *
     * @param flag 是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
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