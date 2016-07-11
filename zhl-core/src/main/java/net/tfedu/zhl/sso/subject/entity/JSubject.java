package net.tfedu.zhl.sso.subject.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "j_subject")
public class JSubject implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 科目名称
     */
    private String name;

    private String code;

    private String abbrev;

    /**
     * 0-----系统科目；1------学校科目
     */
    @Column(name = "subFlag")
    private Boolean subflag;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    private Boolean ishistory;

    private Integer scopetype;

    /**
     * 省管理员id
     */
    @Column(name = "provinceId")
    private Integer provinceid;

    /**
     * 市管理员id
     */
    @Column(name = "cityId")
    private Integer cityid;

    /**
     * 区管理员id
     */
    @Column(name = "districtId")
    private Integer districtid;

    /**
     * 校管理员id
     */
    @Column(name = "schoolId")
    private Integer schoolid;

    public JSubject(Long id, String name, String code, String abbrev, Boolean subflag, Boolean flag, Boolean ishistory, Integer scopetype, Integer provinceid, Integer cityid, Integer districtid,
            Integer schoolid) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.abbrev = abbrev;
        this.subflag = subflag;
        this.flag = flag;
        this.ishistory = ishistory;
        this.scopetype = scopetype;
        this.provinceid = provinceid;
        this.cityid = cityid;
        this.districtid = districtid;
        this.schoolid = schoolid;
    }

    public JSubject() {
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
     * 获取科目名称
     *
     * @return name - 科目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置科目名称
     *
     * @param name
     *            科目名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * @return abbrev
     */
    public String getAbbrev() {
        return abbrev;
    }

    /**
     * @param abbrev
     */
    public void setAbbrev(String abbrev) {
        this.abbrev = abbrev == null ? null : abbrev.trim();
    }

    /**
     * 获取0-----系统科目；1------学校科目
     *
     * @return subFlag - 0-----系统科目；1------学校科目
     */
    public Boolean getSubflag() {
        return subflag;
    }

    /**
     * 设置0-----系统科目；1------学校科目
     *
     * @param subflag
     *            0-----系统科目；1------学校科目
     */
    public void setSubflag(Boolean subflag) {
        this.subflag = subflag;
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

    /**
     * @return ishistory
     */
    public Boolean getIshistory() {
        return ishistory;
    }

    /**
     * @param ishistory
     */
    public void setIshistory(Boolean ishistory) {
        this.ishistory = ishistory;
    }

    /**
     * @return scopetype
     */
    public Integer getScopetype() {
        return scopetype;
    }

    /**
     * @param scopetype
     */
    public void setScopetype(Integer scopetype) {
        this.scopetype = scopetype;
    }

    /**
     * 获取省管理员id
     *
     * @return provinceId - 省管理员id
     */
    public Integer getProvinceid() {
        return provinceid;
    }

    /**
     * 设置省管理员id
     *
     * @param provinceid
     *            省管理员id
     */
    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    /**
     * 获取市管理员id
     *
     * @return cityId - 市管理员id
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * 设置市管理员id
     *
     * @param cityid
     *            市管理员id
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * 获取区管理员id
     *
     * @return districtId - 区管理员id
     */
    public Integer getDistrictid() {
        return districtid;
    }

    /**
     * 设置区管理员id
     *
     * @param districtid
     *            区管理员id
     */
    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    /**
     * 获取校管理员id
     *
     * @return schoolId - 校管理员id
     */
    public Integer getSchoolid() {
        return schoolid;
    }

    /**
     * 设置校管理员id
     *
     * @param schoolid
     *            校管理员id
     */
    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
    }
}