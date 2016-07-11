package net.tfedu.zhl.cloud.resource.customizeres.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "j_customizeres")
public class CustomizeRes {
    @Id
    private String rescode;

    /**
     * 学科
     */
    private String subjiect;

    /**
     * 学段
     */
    private String period;

    /**
     * 资源的教学类型id
     */
    private Byte typeid;

    /**
     * 资源的标题
     */
    private String title;

    /**
     * 创建时间
     */
    @Column(name = "createDT")
    private Date createdt;

    /**
     * 更新时间
     */
    @Column(name = "updateDT")
    private Date updatedt;

    public CustomizeRes(String rescode, String subjiect, String period, Byte typeid, String title, Date createdt, Date updatedt) {
        this.rescode = rescode;
        this.subjiect = subjiect;
        this.period = period;
        this.typeid = typeid;
        this.title = title;
        this.createdt = createdt;
        this.updatedt = updatedt;
    }

    public CustomizeRes() {
        super();
    }

    /**
     * @return rescode
     */
    public String getRescode() {
        return rescode;
    }

    /**
     * @param rescode
     */
    public void setRescode(String rescode) {
        this.rescode = rescode == null ? null : rescode.trim();
    }

    /**
     * 获取学科
     *
     * @return subjiect - 学科
     */
    public String getSubjiect() {
        return subjiect;
    }

    /**
     * 设置学科
     *
     * @param subjiect 学科
     */
    public void setSubjiect(String subjiect) {
        this.subjiect = subjiect == null ? null : subjiect.trim();
    }

    /**
     * 获取学段
     *
     * @return period - 学段
     */
    public String getPeriod() {
        return period;
    }

    /**
     * 设置学段
     *
     * @param period 学段
     */
    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    /**
     * 获取资源的教学类型id
     *
     * @return typeid - 资源的教学类型id
     */
    public Byte getTypeid() {
        return typeid;
    }

    /**
     * 设置资源的教学类型id
     *
     * @param typeid 资源的教学类型id
     */
    public void setTypeid(Byte typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取资源的标题
     *
     * @return title - 资源的标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置资源的标题
     *
     * @param title 资源的标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createDT - 创建时间
     */
    public Date getCreatedt() {
        return createdt;
    }

    /**
     * 设置创建时间
     *
     * @param createdt 创建时间
     */
    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    /**
     * 获取更新时间
     *
     * @return updateDT - 更新时间
     */
    public Date getUpdatedt() {
        return updatedt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedt 更新时间
     */
    public void setUpdatedt(Date updatedt) {
        this.updatedt = updatedt;
    }
}