package net.tfedu.zhl.cloud.resource.poolTypeFormat.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "x_resourcetype")
public class ResType implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 8160030266758656476L;
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 类型名称
     */
    @Column(name = "MType")
    private String mtype;

    /**
     * 类型代码
     */
    private String code;

    /**
     * 类型说明
     */
    private String description;

    /**
     * 是否删除标识，0----否；1------是
     */
    private Boolean flag;

    /**
     * 父id
     */
    @Column(name = "PId")
    private Long pid;

    /**
     * 类型级别
     */
    @Column(name = "Level")
    private Integer level;

    /**
     * 分区是系统类型，还是自定义类型0-----系统；1----自定义，系统类型不允许修改
     */
    @Column(name = "TypeFlag")
    private Boolean typeflag;

    /**
     * 角色标识
     */
    @Column(name = "RoleId")
    private Long roleid;

    /**
     * 自定义类型所属学校
     */
    @Column(name = "SchoolId")
    private Long schoolid;

    /**
     * 科目id
     */
    @Column(name = "SubjectId")
    private Long subjectid;

    /**
     * 类型的显示顺序
     */
    @Column(name = "DisplayIndex")
    private Byte displayindex;

    public ResType(Integer id, String mtype, String code, String description, Boolean flag, Long pid, Integer level,
            Boolean typeflag, Long roleid, Long schoolid, Long subjectid, Byte displayindex) {
        this.id = id;
        this.mtype = mtype;
        this.code = code;
        this.description = description;
        this.flag = flag;
        this.pid = pid;
        this.level = level;
        this.typeflag = typeflag;
        this.roleid = roleid;
        this.schoolid = schoolid;
        this.subjectid = subjectid;
        this.displayindex = displayindex;
    }

    public ResType() {
        super();
    }

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取类型名称
     *
     * @return MType - 类型名称
     */
    public String getMtype() {
        return mtype;
    }

    /**
     * 设置类型名称
     *
     * @param mtype
     *            类型名称
     */
    public void setMtype(String mtype) {
        this.mtype = mtype == null ? null : mtype.trim();
    }

    /**
     * 获取类型代码
     *
     * @return code - 类型代码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置类型代码
     *
     * @param code
     *            类型代码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取类型说明
     *
     * @return description - 类型说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置类型说明
     *
     * @param description
     *            类型说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 获取是否删除标识，0----否；1------是
     *
     * @return flag - 是否删除标识，0----否；1------是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标识，0----否；1------是
     *
     * @param flag
     *            是否删除标识，0----否；1------是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取父id
     *
     * @return PId - 父id
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父id
     *
     * @param pid
     *            父id
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取类型级别
     *
     * @return Level - 类型级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置类型级别
     *
     * @param level
     *            类型级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 获取分区是系统类型，还是自定义类型0-----系统；1----自定义，系统类型不允许修改
     *
     * @return TypeFlag - 分区是系统类型，还是自定义类型0-----系统；1----自定义，系统类型不允许修改
     */
    public Boolean getTypeflag() {
        return typeflag;
    }

    /**
     * 设置分区是系统类型，还是自定义类型0-----系统；1----自定义，系统类型不允许修改
     *
     * @param typeflag
     *            分区是系统类型，还是自定义类型0-----系统；1----自定义，系统类型不允许修改
     */
    public void setTypeflag(Boolean typeflag) {
        this.typeflag = typeflag;
    }

    /**
     * 获取角色标识
     *
     * @return RoleId - 角色标识
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * 设置角色标识
     *
     * @param roleid
     *            角色标识
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取自定义类型所属学校
     *
     * @return SchoolId - 自定义类型所属学校
     */
    public Long getSchoolid() {
        return schoolid;
    }

    /**
     * 设置自定义类型所属学校
     *
     * @param schoolid
     *            自定义类型所属学校
     */
    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }

    /**
     * 获取科目id
     *
     * @return SubjectId - 科目id
     */
    public Long getSubjectid() {
        return subjectid;
    }

    /**
     * 设置科目id
     *
     * @param subjectid
     *            科目id
     */
    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    /**
     * 获取类型的显示顺序
     *
     * @return DisplayIndex - 类型的显示顺序
     */
    public Byte getDisplayindex() {
        return displayindex;
    }

    /**
     * 设置类型的显示顺序
     *
     * @param displayindex
     *            类型的显示顺序
     */
    public void setDisplayindex(Byte displayindex) {
        this.displayindex = displayindex;
    }

    /**
     * 重写toString方法，方便单元测试输出
     */
    @Override
    public String toString() {

        return "Type [id = " + id + ",pid = " + pid + ",mtype = " + mtype + "]";
    }
}