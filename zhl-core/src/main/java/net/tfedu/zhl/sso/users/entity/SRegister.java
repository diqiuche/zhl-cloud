package net.tfedu.zhl.sso.users.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_register")
public class SRegister implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键id,现在作为用户id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 卡号id
     */
    @Column(name = "CardId")
    private Long cardid;

    /**
     * 角色类型
     */
    @Column(name = "RoleId")
    private Long roleid;

    /**
     * 用户名
     */
    @Column(name = "Name")
    private String name;

    /**
     * 邮箱
     */
    @Column(name = "Email")
    private String email;

    /**
     * 注册时间
     */
    @Column(name = "RegisterTime")
    private Date registertime;

    /**
     * 节点id
     */
    @Column(name = "NodeId")
    private Integer nodeid;

    /**
     * 是否删除标识，0----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 账号使用的最后期限
     */
    @Column(name = "reEndTime")
    private Date reendtime;

    /**
     * 登录密码
     */
    @Column(name = "Pwd")
    private byte[] pwd;

    public SRegister(Long id, Long cardid, Long roleid, String name, String email, Date registertime, Integer nodeid, Boolean flag, Date reendtime, byte[] pwd) {
        this.id = id;
        this.cardid = cardid;
        this.roleid = roleid;
        this.name = name;
        this.email = email;
        this.registertime = registertime;
        this.nodeid = nodeid;
        this.flag = flag;
        this.reendtime = reendtime;
        this.pwd = pwd;
    }

    public SRegister() {
        super();
    }

    /**
     * 获取主键id,现在作为用户id
     *
     * @return Id - 主键id,现在作为用户id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id,现在作为用户id
     *
     * @param id
     *            主键id,现在作为用户id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取卡号id
     *
     * @return CardId - 卡号id
     */
    public Long getCardid() {
        return cardid;
    }

    /**
     * 设置卡号id
     *
     * @param cardid
     *            卡号id
     */
    public void setCardid(Long cardid) {
        this.cardid = cardid;
    }

    /**
     * 获取角色类型
     *
     * @return RoleId - 角色类型
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * 设置角色类型
     *
     * @param roleid
     *            角色类型
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取用户名
     *
     * @return Name - 用户名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置用户名
     *
     * @param name
     *            用户名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取邮箱
     *
     * @return Email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email
     *            邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 获取注册时间
     *
     * @return RegisterTime - 注册时间
     */
    public Date getRegistertime() {
        return registertime;
    }

    /**
     * 设置注册时间
     *
     * @param registertime
     *            注册时间
     */
    public void setRegistertime(Date registertime) {
        this.registertime = registertime;
    }

    /**
     * 获取节点id
     *
     * @return NodeId - 节点id
     */
    public Integer getNodeid() {
        return nodeid;
    }

    /**
     * 设置节点id
     *
     * @param nodeid
     *            节点id
     */
    public void setNodeid(Integer nodeid) {
        this.nodeid = nodeid;
    }

    /**
     * 获取是否删除标识，0----未删除；1----删除
     *
     * @return Flag - 是否删除标识，0----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标识，0----未删除；1----删除
     *
     * @param flag
     *            是否删除标识，0----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取账号使用的最后期限
     *
     * @return reEndTime - 账号使用的最后期限
     */
    public Date getReendtime() {
        return reendtime;
    }

    /**
     * 设置账号使用的最后期限
     *
     * @param reendtime
     *            账号使用的最后期限
     */
    public void setReendtime(Date reendtime) {
        this.reendtime = reendtime;
    }

    /**
     * 获取登录密码
     *
     * @return Pwd - 登录密码
     */
    public byte[] getPwd() {
        return pwd;
    }

    /**
     * 设置登录密码
     *
     * @param pwd
     *            登录密码
     */
    public void setPwd(byte[] pwd) {
        this.pwd = pwd;
    }
}