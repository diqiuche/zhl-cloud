package net.tfedu.zhl.cloud.teaching.discuss.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "t_discuss_recommend")
public class TDiscussRecommend {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 班级名称
     */
    private String classname;

    /**
     * 学校的id或主键
     */
    private String classid;

    /**
     * 班级图片
     */
    private String classimage;

    /**
     * 学校名称
     */
    private String schoolname;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 资源的推荐人
     */
    private Long creator;

    /**
     * 0有效；1逻辑删除
     */
    private Boolean flag;

    /**
     * 访问链接默认为空
     */
    private String classurl;

    private String note;

    public TDiscussRecommend(Long id, String classname, String classid, String classimage, String schoolname, Date createtime, Long creator, Boolean flag, String classurl, String note) {
        this.id = id;
        this.classname = classname;
        this.classid = classid;
        this.classimage = classimage;
        this.schoolname = schoolname;
        this.createtime = createtime;
        this.creator = creator;
        this.flag = flag;
        this.classurl = classurl;
        this.note = note;
    }

    public TDiscussRecommend() {
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
     * 获取班级名称
     *
     * @return classname - 班级名称
     */
    public String getClassname() {
        return classname;
    }

    /**
     * 设置班级名称
     *
     * @param classname 班级名称
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * 获取学校的id或主键
     *
     * @return classid - 学校的id或主键
     */
    public String getClassid() {
        return classid;
    }

    /**
     * 设置学校的id或主键
     *
     * @param classid 学校的id或主键
     */
    public void setClassid(String classid) {
        this.classid = classid == null ? null : classid.trim();
    }

    /**
     * 获取班级图片
     *
     * @return classimage - 班级图片
     */
    public String getClassimage() {
        return classimage;
    }

    /**
     * 设置班级图片
     *
     * @param classimage 班级图片
     */
    public void setClassimage(String classimage) {
        this.classimage = classimage == null ? null : classimage.trim();
    }

    /**
     * 获取学校名称
     *
     * @return schoolname - 学校名称
     */
    public String getSchoolname() {
        return schoolname;
    }

    /**
     * 设置学校名称
     *
     * @param schoolname 学校名称
     */
    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname == null ? null : schoolname.trim();
    }

    /**
     * 获取创建时间
     *
     * @return createtime - 创建时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建时间
     *
     * @param createtime 创建时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取资源的推荐人
     *
     * @return creator - 资源的推荐人
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置资源的推荐人
     *
     * @param creator 资源的推荐人
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取0有效；1逻辑删除
     *
     * @return flag - 0有效；1逻辑删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置0有效；1逻辑删除
     *
     * @param flag 0有效；1逻辑删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取访问链接默认为空
     *
     * @return classurl - 访问链接默认为空
     */
    public String getClassurl() {
        return classurl;
    }

    /**
     * 设置访问链接默认为空
     *
     * @param classurl 访问链接默认为空
     */
    public void setClassurl(String classurl) {
        this.classurl = classurl == null ? null : classurl.trim();
    }

    /**
     * @return note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note
     */
    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}