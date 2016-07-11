package net.tfedu.zhl.cloud.teaching.teachCases.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "t_term_subject")
public class TermSubject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学段id
     */
    @Column(name = "termId")
    private Integer termid;

    /**
     * 学科id
     */
    @Column(name = "subjectId")
    private Integer subjectid;

    public TermSubject(Integer id, Integer termid, Integer subjectid) {
        this.id = id;
        this.termid = termid;
        this.subjectid = subjectid;
    }

    public TermSubject() {
        super();
    }

    /**
     * @return id
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
     * 获取学段id
     *
     * @return termId - 学段id
     */
    public Integer getTermid() {
        return termid;
    }

    /**
     * 设置学段id
     *
     * @param termid 学段id
     */
    public void setTermid(Integer termid) {
        this.termid = termid;
    }

    /**
     * 获取学科id
     *
     * @return subjectId - 学科id
     */
    public Integer getSubjectid() {
        return subjectid;
    }

    /**
     * 设置学科id
     *
     * @param subjectid 学科id
     */
    public void setSubjectid(Integer subjectid) {
        this.subjectid = subjectid;
    }
}