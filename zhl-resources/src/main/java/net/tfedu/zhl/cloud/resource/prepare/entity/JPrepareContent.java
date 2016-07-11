package net.tfedu.zhl.cloud.resource.prepare.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "j_prepare_content")
public class JPrepareContent implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 添加日期
     */
    private Date createtime;

    /**
     * 备课夹ID
     */
    @Column(name = "preId")
    private Long preid;

    /**
     * 内容ID
     */
    @Column(name = "contId")
    private Long contid;

    /**
     * 内容类型（1本地资源2系统资源3 学案 4练习5测试6讨论 7 校本资源，8 区本资源，9新版资源中心个人资源，10新版资源中心系统 资源 11
     * 新版资源中心区本资源 12新版资源中心校本资源） 插入时新版资源中心都使用 9 ；10； 11； 12 查询是 查询 1、9；
     * 2、10；11；12
     * 
     */
    @Column(name = "contType")
    private Integer conttype;

    /**
     * 逻辑删除
     */
    private Boolean flag;

    @Column(name = "orderIdx")
    private Integer orderidx;

    public JPrepareContent(Long id, Date createtime, Long preid, Long contid, Integer conttype, Boolean flag,
            Integer orderidx) {
        this.id = id;
        this.createtime = createtime;
        this.preid = preid;
        this.contid = contid;
        this.conttype = conttype;
        this.flag = flag;
        this.orderidx = orderidx;
    }

    public JPrepareContent() {
        super();
    }

    /**
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取添加日期
     *
     * @return createtime - 添加日期
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置添加日期
     *
     * @param createtime
     *            添加日期
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取备课夹ID
     *
     * @return preId - 备课夹ID
     */
    public Long getPreid() {
        return preid;
    }

    /**
     * 设置备课夹ID
     *
     * @param preid
     *            备课夹ID
     */
    public void setPreid(Long preid) {
        this.preid = preid;
    }

    /**
     * 获取内容ID
     *
     * @return contId - 内容ID
     */
    public Long getContid() {
        return contid;
    }

    /**
     * 设置内容ID
     *
     * @param contid
     *            内容ID
     */
    public void setContid(Long contid) {
        this.contid = contid;
    }

    /**
     * 获取内容类型（1本地资源2系统资源3 学案 4练习5测试6讨论 7 校本资源，8 区本资源，9新版资源中心个人资源，10新版资源中心系统 资源）
     *
     * @return contType - 内容类型（1本地资源2系统资源3 学案 4练习5测试6讨论 7 校本资源，8
     *         区本资源，9新版资源中心个人资源，10新版资源中心系统 资源）
     */
    public Integer getConttype() {
        return conttype;
    }

    /**
     * 设置内容类型（1本地资源2系统资源3 学案 4练习5测试6讨论 7 校本资源，8 区本资源，9新版资源中心个人资源，10新版资源中心系统 资源）
     *
     * @param conttype
     *            内容类型（1本地资源2系统资源3 学案 4练习5测试6讨论 7 校本资源，8
     *            区本资源，9新版资源中心个人资源，10新版资源中心系统 资源）
     */
    public void setConttype(Integer conttype) {
        this.conttype = conttype;
    }

    /**
     * 获取逻辑删除
     *
     * @return flag - 逻辑删除
     */
    public Boolean getFlag() {
        return flag == null ? false : flag;
    }

    /**
     * 设置逻辑删除
     *
     * @param flag
     *            逻辑删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @return orderIdx
     */
    public Integer getOrderidx() {
        return orderidx == null ? 0 : orderidx;
    }

    /**
     * @param orderidx
     */
    public void setOrderidx(Integer orderidx) {
        this.orderidx = orderidx;
    }
}