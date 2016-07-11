package net.tfedu.zhl.cloud.resource.share.entity;

import javax.persistence.*;

@Table(name = "x_share_resnav")
public class XShareResNav {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源id
     */
    @Column(name = "resId")
    private Long resid;

    /**
     * 共享导航目录
     */
    @Column(name = "structCode")
    private String structcode;

    /**
     * 目录类型 0教材目录 1知识点目录
     */
    @Column(name = "codeType")
    private Integer codetype;

    /**
     * 删除标记 0未删除 1删除
     */
    private Boolean flag;

    public XShareResNav(Long id, Long resid, String structcode, Integer codetype, Boolean flag) {
        this.id = id;
        this.resid = resid;
        this.structcode = structcode;
        this.codetype = codetype;
        this.flag = flag;
    }

    public XShareResNav() {
        super();
    }

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源id
     *
     * @return resId - 资源id
     */
    public Long getResid() {
        return resid;
    }

    /**
     * 设置资源id
     *
     * @param resid 资源id
     */
    public void setResid(Long resid) {
        this.resid = resid;
    }

    /**
     * 获取共享导航目录
     *
     * @return structCode - 共享导航目录
     */
    public String getStructcode() {
        return structcode;
    }

    /**
     * 设置共享导航目录
     *
     * @param structcode 共享导航目录
     */
    public void setStructcode(String structcode) {
        this.structcode = structcode == null ? null : structcode.trim();
    }

    /**
     * 获取目录类型 0教材目录 1知识点目录
     *
     * @return codeType - 目录类型 0教材目录 1知识点目录
     */
    public Integer getCodetype() {
        return codetype;
    }

    /**
     * 设置目录类型 0教材目录 1知识点目录
     *
     * @param codetype 目录类型 0教材目录 1知识点目录
     */
    public void setCodetype(Integer codetype) {
        this.codetype = codetype;
    }

    /**
     * 获取删除标记 0未删除 1删除
     *
     * @return flag - 删除标记 0未删除 1删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置删除标记 0未删除 1删除
     *
     * @param flag 删除标记 0未删除 1删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}