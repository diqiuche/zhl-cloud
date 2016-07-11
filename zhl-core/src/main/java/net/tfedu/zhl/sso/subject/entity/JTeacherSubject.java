package net.tfedu.zhl.sso.subject.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "j_teachersubject")
public class JTeacherSubject implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "UserId")
    private Long userid;

    /**
     * 科目id
     */
    @Column(name = "SubjectId")
    private Long subjectid;

    /**
     * 是否删除标识，0------否；1-----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    public JTeacherSubject(Long id, Long userid, Long subjectid, Boolean flag) {
        this.id = id;
        this.userid = userid;
        this.subjectid = subjectid;
        this.flag = flag;
    }

    public JTeacherSubject() {
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
     * 获取用户id
     *
     * @return UserId - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid
     *            用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
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
     * 获取是否删除标识，0------否；1-----是
     *
     * @return Flag - 是否删除标识，0------否；1-----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标识，0------否；1-----是
     *
     * @param flag
     *            是否删除标识，0------否；1-----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}