package net.tfedu.zhl.cloud.resource.downloadrescord.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "z_resdown_record")
public class ResDownRecord implements Serializable {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源在表中的id
     */
    @Column(name = "resId")
    private Long resid;

    /**
     * 下载资源的来源 0 系统资源 1 自建资源 2 共享资源 3校本资源,4区本资源 
     */
    private Integer fromflag;

    /**
     * 下载用户
     */
    private Long userid;

    /**
     * 下载日期
     */
    private Date downdate;

    /**
     * 下载的时分秒
     */
    private Date downtime;

    public ResDownRecord(Long id, Long resid, Integer fromflag, Long userid, Date downdate, Date downtime) {
        this.id = id;
        this.resid = resid;
        this.fromflag = fromflag;
        this.userid = userid;
        this.downdate = downdate;
        this.downtime = downtime;
    }

    public ResDownRecord() {
        super();
    }

    /**
     * 获取id
     *
     * @return id - id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id
     *            id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源在表中的id
     *
     * @return resId - 资源在表中的id
     */
    public Long getResid() {
        return resid;
    }

    /**
     * 设置资源在表中的id
     *
     * @param resid
     *            资源在表中的id
     */
    public void setResid(Long resid) {
        this.resid = resid;
    }

    /**
     * 获取下载资源的来源 0 系统资源 1 区校资源 2 共享资源
     *
     * @return fromflag - 下载资源的来源 0 系统资源 1 区校资源 2 共享资源
     */
    public Integer getFromflag() {
        return fromflag;
    }

    /**
     * 设置下载资源的来源 0 系统资源 1 区校资源 2 共享资源
     *
     * @param fromflag
     *            下载资源的来源 0 系统资源 1 区校资源 2 共享资源
     */
    public void setFromflag(Integer fromflag) {
        this.fromflag = fromflag;
    }

    /**
     * 获取下载用户
     *
     * @return userid - 下载用户
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置下载用户
     *
     * @param userid
     *            下载用户
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取下载日期
     *
     * @return downdate - 下载日期
     */
    public Date getDowndate() {
        return downdate;
    }

    /**
     * 设置下载日期
     *
     * @param downdate
     *            下载日期
     */
    public void setDowndate(Date downdate) {
        this.downdate = downdate;
    }

    /**
     * 获取下载的时分秒
     *
     * @return downtime - 下载的时分秒
     */
    public Date getDowntime() {
        return downtime;
    }

    /**
     * 设置下载的时分秒
     *
     * @param downtime
     *            下载的时分秒
     */
    public void setDowntime(Date downtime) {
        this.downtime = downtime;
    }
}