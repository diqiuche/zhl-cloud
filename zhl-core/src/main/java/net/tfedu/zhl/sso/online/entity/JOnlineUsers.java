package net.tfedu.zhl.sso.online.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "j_online_users")
public class JOnlineUsers implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    private Long userid;

    /**
     * 登录时间
     */
    @Column(name = "loginTime")
    private Date logintime;

    /**
     * 登录节点号
     */
    @Column(name = "loginNodeId")
    private Long loginnodeid;

    /**
     * 最后操作时间
     */
    private Date lastopertime;

    /**
     * 1 web 2 android 3 winpad
     */
    @Column(name = "clientType")
    private Integer clienttype;

    /**
     * 设备信息
     */
    @Column(name = "deviceInfo")
    private String deviceinfo;

    /**
     * 状态 1 在线 2 退出 3 超时 4 被踢出
     */
    private Integer status;

    /**
     * 登录IP地址
     */
    @Column(name = "loginIp")
    private String loginip;

    /**
     * 客户端版本
     */
    @Column(name = "clientVersion")
    private String clientversion;

    private Boolean flag;

    private String token;

    public JOnlineUsers(Long id, Long userid, Date logintime, Long loginnodeid, Date lastopertime, Integer clienttype, String deviceinfo, Integer status, String loginip, String clientversion,
            Boolean flag, String token) {
        this.id = id;
        this.userid = userid;
        this.logintime = logintime;
        this.loginnodeid = loginnodeid;
        this.lastopertime = lastopertime;
        this.clienttype = clienttype;
        this.deviceinfo = deviceinfo;
        this.status = status;
        this.loginip = loginip;
        this.clientversion = clientversion;
        this.flag = flag;
        this.token = token;
    }

    public JOnlineUsers() {
        super();
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id
     *            ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID
     *
     * @return userid - 用户ID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户ID
     *
     * @param userid
     *            用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取登录时间
     *
     * @return loginTime - 登录时间
     */
    public Date getLogintime() {
        return logintime;
    }

    /**
     * 设置登录时间
     *
     * @param logintime
     *            登录时间
     */
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    /**
     * 获取登录节点号
     *
     * @return loginNodeId - 登录节点号
     */
    public Long getLoginnodeid() {
        return loginnodeid;
    }

    /**
     * 设置登录节点号
     *
     * @param loginnodeid
     *            登录节点号
     */
    public void setLoginnodeid(Long loginnodeid) {
        this.loginnodeid = loginnodeid;
    }

    /**
     * 获取最后操作时间
     *
     * @return lastopertime - 最后操作时间
     */
    public Date getLastopertime() {
        return lastopertime;
    }

    /**
     * 设置最后操作时间
     *
     * @param lastopertime
     *            最后操作时间
     */
    public void setLastopertime(Date lastopertime) {
        this.lastopertime = lastopertime;
    }

    /**
     * 获取1 web 2 android 3 winpad
     *
     * @return clientType - 1 web 2 android 3 winpad
     */
    public Integer getClienttype() {
        return clienttype;
    }

    /**
     * 设置1 web 2 android 3 winpad
     *
     * @param clienttype
     *            1 web 2 android 3 winpad
     */
    public void setClienttype(Integer clienttype) {
        this.clienttype = clienttype;
    }

    /**
     * 获取设备信息
     *
     * @return deviceInfo - 设备信息
     */
    public String getDeviceinfo() {
        return deviceinfo;
    }

    /**
     * 设置设备信息
     *
     * @param deviceinfo
     *            设备信息
     */
    public void setDeviceinfo(String deviceinfo) {
        this.deviceinfo = deviceinfo == null ? null : deviceinfo.trim();
    }

    /**
     * 获取状态 1 在线 2 退出 3 超时 4 被踢出
     *
     * @return status - 状态 1 在线 2 退出 3 超时 4 被踢出
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 1 在线 2 退出 3 超时 4 被踢出
     *
     * @param status
     *            状态 1 在线 2 退出 3 超时 4 被踢出
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取登录IP地址
     *
     * @return loginIp - 登录IP地址
     */
    public String getLoginip() {
        return loginip;
    }

    /**
     * 设置登录IP地址
     *
     * @param loginip
     *            登录IP地址
     */
    public void setLoginip(String loginip) {
        this.loginip = loginip == null ? null : loginip.trim();
    }

    /**
     * 获取客户端版本
     *
     * @return clientVersion - 客户端版本
     */
    public String getClientversion() {
        return clientversion;
    }

    /**
     * 设置客户端版本
     *
     * @param clientversion
     *            客户端版本
     */
    public void setClientversion(String clientversion) {
        this.clientversion = clientversion == null ? null : clientversion.trim();
    }

    /**
     * @return flag
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @return token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     */
    public void setToken(String token) {
        this.token = token == null ? null : token.trim();
    }
}