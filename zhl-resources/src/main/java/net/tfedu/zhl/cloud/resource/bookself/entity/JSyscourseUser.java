package net.tfedu.zhl.cloud.resource.bookself.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "j_syscourse_user")
public class JSyscourseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userid;

    @Column(name = "syscourseId")
    private Long syscourseid;

    @Column(name = "SubjectId")
    private Long subjectid;

    @Column(name = "createTime")
    private Date createtime;

    @Column(name = "Flag")
    private Boolean flag;

    public JSyscourseUser(Long id, Long userid, Long syscourseid, Long subjectid, Date createtime, Boolean flag) {
        this.id = id;
        this.userid = userid;
        this.syscourseid = syscourseid;
        this.subjectid = subjectid;
        this.createtime = createtime;
        this.flag = flag;
    }

    public JSyscourseUser() {
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
     * @return userId
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * @return syscourseId
     */
    public Long getSyscourseid() {
        return syscourseid;
    }

    /**
     * @param syscourseid
     */
    public void setSyscourseid(Long syscourseid) {
        this.syscourseid = syscourseid;
    }

    /**
     * @return SubjectId
     */
    public Long getSubjectid() {
        return subjectid;
    }

    /**
     * @param subjectid
     */
    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    /**
     * @return createTime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return Flag
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}