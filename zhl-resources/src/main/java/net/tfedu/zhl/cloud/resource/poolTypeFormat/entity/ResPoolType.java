package net.tfedu.zhl.cloud.resource.poolTypeFormat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "z_res_pooltype")
public class ResPoolType implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 8160030266758656476L;
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 系统资源库id
     */
    @Column(name = "poolId")
    private Long poolid;

    /**
     * 系统资源类型id
     */
    @Column(name = "resTypeId")
    private Long restypeid;

    /**
     * 资源库下的资源类型
     */
    @Transient
    private ResType types;

    public ResType getTypes() {
        return types;
    }

    public void setTypes(ResType types) {
        this.types = types;
    }

    /**
     * 删除标记
     */
    private Boolean flag;

    public ResPoolType(Long id, Long poolid, Long restypeid, Boolean flag) {
        this.id = id;
        this.poolid = poolid;
        this.restypeid = restypeid;
        this.flag = flag;
    }

    public ResPoolType() {
        super();
    }

    /**
     * 获取 主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置 主键id
     *
     * @param id
     *            主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取系统资源库id
     *
     * @return poolId - 系统资源库id
     */
    public Long getPoolid() {
        return poolid;
    }

    /**
     * 设置系统资源库id
     *
     * @param poolid
     *            系统资源库id
     */
    public void setPoolid(Long poolid) {
        this.poolid = poolid;
    }

    /**
     * 获取系统资源类型id
     *
     * @return resTypeId - 系统资源类型id
     */
    public Long getRestypeid() {
        return restypeid;
    }

    /**
     * 设置系统资源类型id
     *
     * @param restypeid
     *            系统资源类型id
     */
    public void setRestypeid(Long restypeid) {
        this.restypeid = restypeid;
    }

    /**
     * 获取删除标记
     *
     * @return flag - 删除标记
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置删除标记
     *
     * @param flag
     *            删除标记
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 重写toString方法，方便单元测试输出
     */
    @Override
    public String toString() {

        return "PoolType [id = " + id + ",poolId = " + poolid + ",types = " + types + "]";
    }
}