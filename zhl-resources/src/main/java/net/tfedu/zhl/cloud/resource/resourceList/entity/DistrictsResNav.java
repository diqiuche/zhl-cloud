package net.tfedu.zhl.cloud.resource.resourceList.entity;

import javax.persistence.*;

@Table(name = "z_districts_resnav")
public class DistrictsResNav {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 资源编码
     */
    @Column(name = "ResCode")
    private String rescode;

    /**
     * 结构编码（同方code）记录必修一节点，教材详细节点
     */
    @Column(name = "StructCode")
    private String structcode;

    /**
     * 系统课程id（记录课程节点）
     */
    @Column(name = "SysCourseId")
    private Long syscourseid;

    /**
     * 是否删除数据标识；0----否；1-----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    public DistrictsResNav(Long id, String rescode, String structcode, Long syscourseid, Boolean flag) {
        this.id = id;
        this.rescode = rescode;
        this.structcode = structcode;
        this.syscourseid = syscourseid;
        this.flag = flag;
    }

    public DistrictsResNav() {
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
     * 获取资源编码
     *
     * @return ResCode - 资源编码
     */
    public String getRescode() {
        return rescode;
    }

    /**
     * 设置资源编码
     *
     * @param rescode 资源编码
     */
    public void setRescode(String rescode) {
        this.rescode = rescode == null ? null : rescode.trim();
    }

    /**
     * 获取结构编码（同方code）记录必修一节点，教材详细节点
     *
     * @return StructCode - 结构编码（同方code）记录必修一节点，教材详细节点
     */
    public String getStructcode() {
        return structcode;
    }

    /**
     * 设置结构编码（同方code）记录必修一节点，教材详细节点
     *
     * @param structcode 结构编码（同方code）记录必修一节点，教材详细节点
     */
    public void setStructcode(String structcode) {
        this.structcode = structcode == null ? null : structcode.trim();
    }

    /**
     * 获取系统课程id（记录课程节点）
     *
     * @return SysCourseId - 系统课程id（记录课程节点）
     */
    public Long getSyscourseid() {
        return syscourseid;
    }

    /**
     * 设置系统课程id（记录课程节点）
     *
     * @param syscourseid 系统课程id（记录课程节点）
     */
    public void setSyscourseid(Long syscourseid) {
        this.syscourseid = syscourseid;
    }

    /**
     * 获取是否删除数据标识；0----否；1-----是
     *
     * @return Flag - 是否删除数据标识；0----否；1-----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除数据标识；0----否；1-----是
     *
     * @param flag 是否删除数据标识；0----否；1-----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}