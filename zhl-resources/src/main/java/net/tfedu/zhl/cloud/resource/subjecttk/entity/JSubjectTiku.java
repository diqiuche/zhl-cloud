package net.tfedu.zhl.cloud.resource.subjecttk.entity;

import javax.persistence.*;

@Table(name = "j_subject_tiku")
public class JSubjectTiku {
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

    @Column(name = "provinceId")
    private Integer provinceid;

    @Column(name = "cityId")
    private Integer cityid;

    @Column(name = "districtId")
    private Integer districtid;

    @Column(name = "schoolId")
    private Integer schoolid;

    private Boolean ishistory;

    private Integer scopetype;

    public JSubjectTiku(Long id, String name, String code, String abbrev, Boolean subflag, Boolean flag, Integer provinceid, Integer cityid, Integer districtid, Integer schoolid, Boolean ishistory, Integer scopetype) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.abbrev = abbrev;
        this.subflag = subflag;
        this.flag = flag;
        this.provinceid = provinceid;
        this.cityid = cityid;
        this.districtid = districtid;
        this.schoolid = schoolid;
        this.ishistory = ishistory;
        this.scopetype = scopetype;
    }

    public JSubjectTiku() {
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
     * @param name 科目名称
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
     * @param subflag 0-----系统科目；1------学校科目
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
     * @param flag 是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @return provinceId
     */
    public Integer getProvinceid() {
        return provinceid;
    }

    /**
     * @param provinceid
     */
    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
    }

    /**
     * @return cityId
     */
    public Integer getCityid() {
        return cityid;
    }

    /**
     * @param cityid
     */
    public void setCityid(Integer cityid) {
        this.cityid = cityid;
    }

    /**
     * @return districtId
     */
    public Integer getDistrictid() {
        return districtid;
    }

    /**
     * @param districtid
     */
    public void setDistrictid(Integer districtid) {
        this.districtid = districtid;
    }

    /**
     * @return schoolId
     */
    public Integer getSchoolid() {
        return schoolid;
    }

    /**
     * @param schoolid
     */
    public void setSchoolid(Integer schoolid) {
        this.schoolid = schoolid;
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
}