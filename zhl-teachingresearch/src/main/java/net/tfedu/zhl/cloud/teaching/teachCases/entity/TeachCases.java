package net.tfedu.zhl.cloud.teaching.teachCases.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_teachcases")
public class TeachCases implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 教学案例名称
     */
    private String title;

    /**
     * 所在学校
     */
    private String school;

    /**
     * 执教教师
     */
    private String teacher;
    
    /**
     * 所属平台
     */
    private int fromflag;
    

    /**
     * 学段id
     */
    @Column(name = "termId")
    private Integer termid;

    /**
     * 年级id
     */
    private Integer gradeid;
    
    /**
     * 年级名称
     */
    private String gradeName;

    /**
     * 学科id
     */
    @Column(name = "subjectId")
    private Integer subjectid;

    /**
     * 授课时间
     */
    @Column(name = "teachDate")
    private String teachdate;

    /**
     * 教材版本
     */
    private String bookversion;

    /**
     * 缩略图路径
     */
    private String thumbnailpath;

    /**
     * 创建者
     */
    private Long creator;

    /**
     * 创建日期
     */
    @Column(name = "createDate")
    private Date createdate;

    /**
     * 更新日期
     */
    @Column(name = "updateDate")
    private Date updatedate;

    /**
     * 删除标记：0 未删除，1 删除
     */
    private Boolean flag;

    public TeachCases(Long id, String title, String school, String teacher, Integer termid, Integer gradeid, Integer subjectid, String teachdate, String bookversion, String thumbnailpath, Long creator, Date createdate, Date updatedate, Boolean flag,String gradeName,int fromflag) {
        this.id = id;
        this.title = title;
        this.school = school;
        this.teacher = teacher;
        this.termid = termid;
        this.gradeid = gradeid;
        this.subjectid = subjectid;
        this.teachdate = teachdate;
        this.bookversion = bookversion;
        this.thumbnailpath = thumbnailpath;
        this.creator = creator;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.flag = flag;
        this.gradeName = gradeName;
        this.fromflag = fromflag;
    }

    public TeachCases() {
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
     * 获取教学案例名称
     *
     * @return title - 教学案例名称
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置教学案例名称
     *
     * @param title 教学案例名称
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }
    
    /**
     * 获取年级名称
     * @return
     */
    public String getGradeName(){
    	return gradeName;
    }
    
    /**
     * 设置年级名称
     * @param gradeName
     */
    public void setGradeName(String gradeName){
    	this.gradeName = gradeName;
    }

    /**
     * 获取所在学校
     *
     * @return school - 所在学校
     */
    public String getSchool() {
        return school;
    }

    /**
     * 设置所在学校
     *
     * @param school 所在学校
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    /**
     * 获取执教教师
     *
     * @return teacher - 执教教师
     */
    public String getTeacher() {
        return teacher;
    }

    /**
     * 设置执教教师
     *
     * @param teacher 执教教师
     */
    public void setTeacher(String teacher) {
        this.teacher = teacher == null ? null : teacher.trim();
    }

    /**
     * 设置fromflag
     * @param fromflag
     */
    public void setFromflag(int fromflag){
    	this.fromflag = fromflag;
    }
    
    /**
     * 获取fromFlag
     * @param fromflag
     */
    public int getFromflag(){
    	return fromflag;
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
     * 获取年级id
     *
     * @return gradeid - 年级id
     */
    public Integer getGradeid() {
        return gradeid;
    }

    /**
     * 设置年级id
     *
     * @param gradeid 年级id
     */
    public void setGradeid(Integer gradeid) {
        this.gradeid = gradeid;
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

    /**
     * 获取授课时间
     *
     * @return teachDate - 授课时间
     */
    public String getTeachdate() {
        return teachdate;
    }

    /**
     * 设置授课时间
     *
     * @param teachdate 授课时间
     */
    public void setTeachdate(String teachdate) {
        this.teachdate = teachdate;
    }

    /**
     * 获取教材版本
     *
     * @return bookversion - 教材版本
     */
    public String getBookversion() {
        return bookversion;
    }

    /**
     * 设置教材版本
     *
     * @param bookversion 教材版本
     */
    public void setBookversion(String bookversion) {
        this.bookversion = bookversion == null ? null : bookversion.trim();
    }

    /**
     * 获取缩略图路径
     *
     * @return thumbnailpath - 缩略图路径
     */
    public String getThumbnailpath() {
        return thumbnailpath;
    }

    /**
     * 设置缩略图路径
     *
     * @param thumbnailpath 缩略图路径
     */
    public void setThumbnailpath(String thumbnailpath) {
        this.thumbnailpath = thumbnailpath == null ? null : thumbnailpath.trim();
    }

    /**
     * 获取创建者
     *
     * @return creator - 创建者
     */
    public Long getCreator() {
        return creator;
    }

    /**
     * 设置创建者
     *
     * @param creator 创建者
     */
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    /**
     * 获取创建日期
     *
     * @return createDate - 创建日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置创建日期
     *
     * @param createdate 创建日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    /**
     * 获取更新日期
     *
     * @return updateDate - 更新日期
     */
    public Date getUpdatedate() {
        return updatedate;
    }

    /**
     * 设置更新日期
     *
     * @param updatedate 更新日期
     */
    public void setUpdatedate(Date updatedate) {
        this.updatedate = updatedate;
    }

    /**
     * 获取删除标记：0 未删除，1 删除
     *
     * @return flag - 删除标记：0 未删除，1 删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置删除标记：0 未删除，1 删除
     *
     * @param flag 删除标记：0 未删除，1 删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}