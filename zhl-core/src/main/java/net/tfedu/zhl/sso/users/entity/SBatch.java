package net.tfedu.zhl.sso.users.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_batch")
public class SBatch implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 批次号，有时间和批次号数目组成
     */
    @Column(name = "BatchName")
    private String batchname;

    /**
     * 批次号产生的时间
     */
    @Column(name = "CreateTime")
    private Date createtime;

    /**
     * 一个批次产生多少个卡号
     */
    @Column(name = "NumberCard")
    private Integer numbercard;

    /**
     * 备注
     */
    @Column(name = "Remark")
    private String remark;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    public SBatch(Long id, String batchname, Date createtime, Integer numbercard, String remark, Boolean flag) {
        this.id = id;
        this.batchname = batchname;
        this.createtime = createtime;
        this.numbercard = numbercard;
        this.remark = remark;
        this.flag = flag;
    }

    public SBatch() {
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
     * @param id
     *            自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取批次号，有时间和批次号数目组成
     *
     * @return BatchName - 批次号，有时间和批次号数目组成
     */
    public String getBatchname() {
        return batchname;
    }

    /**
     * 设置批次号，有时间和批次号数目组成
     *
     * @param batchname
     *            批次号，有时间和批次号数目组成
     */
    public void setBatchname(String batchname) {
        this.batchname = batchname == null ? null : batchname.trim();
    }

    /**
     * 获取批次号产生的时间
     *
     * @return CreateTime - 批次号产生的时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置批次号产生的时间
     *
     * @param createtime
     *            批次号产生的时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取一个批次产生多少个卡号
     *
     * @return NumberCard - 一个批次产生多少个卡号
     */
    public Integer getNumbercard() {
        return numbercard;
    }

    /**
     * 设置一个批次产生多少个卡号
     *
     * @param numbercard
     *            一个批次产生多少个卡号
     */
    public void setNumbercard(Integer numbercard) {
        this.numbercard = numbercard;
    }

    /**
     * 获取备注
     *
     * @return Remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark
     *            备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
     * @param flag
     *            是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}