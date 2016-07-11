package net.tfedu.zhl.sso.users.entity;

import javax.persistence.*;

/**
 * 角色授权表
 * @author bruce
 *
 */
@Table(name = "j_roleconfig")
public class RoleFunc {
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

    public RoleFunc(Long id, Long roleid, Long funcid, Boolean flag) {
        this.id = id;
        this.roleid = roleid;
        this.funcid = funcid;
        this.flag = flag;
    }

    public RoleFunc() {
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
}