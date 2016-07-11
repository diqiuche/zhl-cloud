package net.tfedu.zhl.cloud.resource.asset.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "z_type_convert")
public class ZTypeConvert {
    /**
     * 转换资源id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源路径
     */
    @Column(name = "ResPath")
    private String respath;

    /**
     * 资源创建者
     */
    @Column(name = "UserId")
    private Long userid;

    /**
     * 创建日期
     */
    @Column(name = "CreateTime")
    private Date createtime;

    public ZTypeConvert(Long id, String respath, Long userid, Date createtime) {
        this.id = id;
        this.respath = respath;
        this.userid = userid;
        this.createtime = createtime;
    }

    public ZTypeConvert() {
        super();
    }

    /**
     * 获取转换资源id
     *
     * @return Id - 转换资源id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置转换资源id
     *
     * @param id
     *            转换资源id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取资源路径
     *
     * @return ResPath - 资源路径
     */
    public String getRespath() {
        return respath;
    }

    /**
     * 设置资源路径
     *
     * @param respath
     *            资源路径
     */
    public void setRespath(String respath) {
        this.respath = respath == null ? null : respath.trim();
    }

    /**
     * 获取资源创建者
     *
     * @return UserId - 资源创建者
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置资源创建者
     *
     * @param userid
     *            资源创建者
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取创建日期
     *
     * @return CreateTime - 创建日期
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建日期
     *
     * @param createtime
     *            创建日期
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}