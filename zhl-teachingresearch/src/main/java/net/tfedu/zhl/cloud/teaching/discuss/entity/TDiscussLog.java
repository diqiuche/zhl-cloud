package net.tfedu.zhl.cloud.teaching.discuss.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_discuss_log")
public class TDiscussLog  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 访问记录主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 访问用户
     */
    private Long userid;

    /**
     * 访问时间
     */
    private Date createtime;

    /**
     * 访问的班级id
     */
    private String classid;

    public TDiscussLog(Long id, Long userid, Date createtime, String classid) {
        this.id = id;
        this.userid = userid;
        this.createtime = createtime;
        this.classid = classid;
    }

    public TDiscussLog() {
        super();
    }

    /**
     * 获取访问记录主键
     *
     * @return id - 访问记录主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置访问记录主键
     *
     * @param id 访问记录主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取访问用户
     *
     * @return userid - 访问用户
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置访问用户
     *
     * @param userid 访问用户
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取访问时间
     *
     * @return createtime - 访问时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置访问时间
     *
     * @param createtime 访问时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取访问的班级id
     *
     * @return classid - 访问的班级id
     */
    public String getClassid() {
        return classid;
    }

    /**
     * 设置访问的班级id
     *
     * @param classid 访问的班级id
     */
    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }
}