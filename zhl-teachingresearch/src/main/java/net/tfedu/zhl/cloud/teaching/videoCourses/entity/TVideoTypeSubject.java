package net.tfedu.zhl.cloud.teaching.videoCourses.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_videotype_subject")
public class TVideoTypeSubject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 视频课程类型id
     */
    @Column(name = "typeId")
    private Integer typeid;

    /**
     * 学科id
     */
    @Column(name = "subjectId")
    private Integer subjectid;

    public TVideoTypeSubject(Integer id, Integer typeid, Integer subjectid) {
        this.id = id;
        this.typeid = typeid;
        this.subjectid = subjectid;
    }

    public TVideoTypeSubject() {
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
     * 获取视频课程类型id
     *
     * @return typeId - 视频课程类型id
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置视频课程类型id
     *
     * @param typeid 视频课程类型id
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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