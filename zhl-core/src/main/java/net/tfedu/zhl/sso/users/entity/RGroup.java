package net.tfedu.zhl.sso.users.entity;

import java.util.Date;
import javax.persistence.*;

/**
 * 角色权限用的用户分组
 * @author bruce
 *
 */
@Table(name = "r_group")
public class RGroup {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 创建人
     */
    @Column(name = "UserId")
    private Long userid;

    /**
     * 班级id
     */
    @Column(name = "ClassId")
    private Long classid;

    /**
     * 学校id
     */
    @Column(name = "SchoolId")
    private Long schoolid;

    /**
     * 小组名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 审核通过时间
     */
    @Column(name = "ChkTime")
    private Date chktime;

    /**
     * 是否删除，0-----否；1------是
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 系统模块
     */
    private String model;

    /**
     * 0-公共,1-子系统自定义
     */
    private Boolean tag;

    public RGroup(Long id, Long userid, Long classid, Long schoolid, String name, Date chktime, Boolean flag, String model, Boolean tag) {
        this.id = id;
        this.userid = userid;
        this.classid = classid;
        this.schoolid = schoolid;
        this.name = name;
        this.chktime = chktime;
        this.flag = flag;
        this.model = model;
        this.tag = tag;
    }

    public RGroup() {
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
     * 获取创建人
     *
     * @return UserId - 创建人
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置创建人
     *
     * @param userid 创建人
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取班级id
     *
     * @return ClassId - 班级id
     */
    public Long getClassid() {
        return classid;
    }

    /**
     * 设置班级id
     *
     * @param classid 班级id
     */
    public void setClassid(Long classid) {
        this.classid = classid;
    }

    /**
     * 获取学校id
     *
     * @return SchoolId - 学校id
     */
    public Long getSchoolid() {
        return schoolid;
    }

    /**
     * 设置学校id
     *
     * @param schoolid 学校id
     */
    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }

    /**
     * 获取小组名称
     *
     * @return Name - 小组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置小组名称
     *
     * @param name 小组名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取审核通过时间
     *
     * @return ChkTime - 审核通过时间
     */
    public Date getChktime() {
        return chktime;
    }

    /**
     * 设置审核通过时间
     *
     * @param chktime 审核通过时间
     */
    public void setChktime(Date chktime) {
        this.chktime = chktime;
    }

    /**
     * 获取是否删除，0-----否；1------是
     *
     * @return Flag - 是否删除，0-----否；1------是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除，0-----否；1------是
     *
     * @param flag 是否删除，0-----否；1------是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取系统模块
     *
     * @return model - 系统模块
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置系统模块
     *
     * @param model 系统模块
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取0-公共,1-子系统自定义
     *
     * @return tag - 0-公共,1-子系统自定义
     */
    public Boolean getTag() {
        return tag;
    }

    /**
     * 设置0-公共,1-子系统自定义
     *
     * @param tag 0-公共,1-子系统自定义
     */
    public void setTag(Boolean tag) {
        this.tag = tag;
    }
}