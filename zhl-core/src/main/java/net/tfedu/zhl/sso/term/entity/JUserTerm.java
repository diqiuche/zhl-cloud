package net.tfedu.zhl.sso.term.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "j_userterm")
public class JUserTerm implements Serializable {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户
     */
    @Column(name = "UserId")
    private Long userid;

    /**
     * 学段
     */
    @Column(name = "TermId")
    private Long termid;

    /**
     * 是否是删除标识，0----否；1-----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    public JUserTerm(Long id, Long userid, Long termid, Boolean flag) {
        this.id = id;
        this.userid = userid;
        this.termid = termid;
        this.flag = flag;
    }

    public JUserTerm() {
        super();
    }

    /**
     * @return Id
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
     * 获取用户
     *
     * @return UserId - 用户
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户
     *
     * @param userid
     *            用户
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取学段
     *
     * @return TermId - 学段
     */
    public Long getTermid() {
        return termid;
    }

    /**
     * 设置学段
     *
     * @param termid
     *            学段
     */
    public void setTermid(Long termid) {
        this.termid = termid;
    }

    /**
     * 获取是否是删除标识，0----否；1-----是
     *
     * @return Flag - 是否是删除标识，0----否；1-----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否是删除标识，0----否；1-----是
     *
     * @param flag
     *            是否是删除标识，0----否；1-----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}