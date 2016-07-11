package net.tfedu.zhl.cloud.resource.prepare.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.*;

@Table(name = "j_lession_prepare")
public class JPrepare implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "userId")
    private Long userid;

    private Date createtime;

    private Date updatetime;

    
    private String title;

    /**
     * 自建目录
     */
    @Column(name = "courseId")
    private Long courseid;

    /**
     * 逻辑删除
     */
    private Boolean flag;

    /**
     * 排序字段-备用
     */
    private Long ordernum;

    private String tfcode;

    @Column(name = "subjectId")
    private Long subjectid;

    public JPrepare(Long id, Long userid, Date createtime, Date updatetime, String title, Long courseid, Boolean flag, Long ordernum,
            String tfcode, Long subjectid) {
        this.id = id;
        this.userid = userid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.title = title;
        this.courseid = courseid;
        this.flag = flag;
        this.ordernum = ordernum;
        this.tfcode = tfcode;
        this.subjectid = subjectid;
    }

    public JPrepare() {
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
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime == null ? Calendar.getInstance().getTime() : createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取自建目录
     *
     * @return courseId - 自建目录
     */
    public Long getCourseid() {
        return courseid == null ? 0 : courseid;
    }

    /**
     * 设置自建目录
     *
     * @param courseid
     *            自建目录
     */
    public void setCourseid(Long courseid) {
        this.courseid = courseid;
    }

    /**
     * 获取逻辑删除
     *
     * @return flag - 逻辑删除
     */
    public Boolean getFlag() {
        return flag == null ? false : flag;
    }

    /**
     * 设置逻辑删除
     *
     * @param flag
     *            逻辑删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取排序字段-备用
     *
     * @return ordernum - 排序字段-备用
     */
    public Long getOrdernum() {
        return ordernum == null ? 0 : ordernum;
    }

    /**
     * 设置排序字段-备用
     *
     * @param ordernum
     *            排序字段-备用
     */
    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    /**
     * @return tfcode
     */
    public String getTfcode() {
        return tfcode;
    }

    /**
     * @param tfcode
     */
    public void setTfcode(String tfcode) {
        this.tfcode = tfcode == null ? null : tfcode.trim();
    }

    /**
     * @return subjectId
     */
    public Long getSubjectid() {
        return subjectid == null ? 0 : subjectid;
    }

    /**
     * @param subjectid
     */
    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

	public Date getUpdatetime() {
		return updatetime;
	}

	public void setUpdatetime(Date updatetime) {
		this.updatetime = updatetime;
	}
    
}