package net.tfedu.zhl.sso.grade.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "j_grade")
public class Grade {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SchoolId")
    private Long schoolid;

    /**
     * 学段id
     */
    @Column(name = "TermId")
    private Long termid;

    @Column(name = "Name")
    private String name;

    @Column(name = "ClassName")
    private String classname;

    /**
     * �������
     */
    @Column(name = "NickName")
    private String nickname;

    /**
     * �༶����Ա
     */
    @Column(name = "Manager")
    private String manager;

    @Column(name = "CreateMan")
    private String createman;

    /**
     * N ʹ���С�C �ر� 
     */
    @Column(name = "Status")
    private String status;

    @Column(name = "Year")
    private Date year;

    /**
     * 创建时间
     */
    @Column(name = "CreateTime")
    private Date createtime;

    /**
     * 标识是行政班级，还是课程班级，0-----行政班级；1------课程班级
     */
    @Column(name = "IsFlag")
    private Boolean isflag;

    /**
     * �Ƿ����ͨ����3-----��1----�ǣ�2----����ˣ�
     */
    @Column(name = "IsChank")
    private String ischank;

    /**
     * 删除时间
     */
    @Column(name = "DeleteTime")
    private Date deletetime;

    @Column(name = "Note")
    private String note;

    /**
     * 标识是否限制聊天，0------不限制；1-------限制
     */
    @Column(name = "ChannelLimit")
    private Long channellimit;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 班级栏目数目
     */
    @Column(name = "forumPartNum")
    private Integer forumpartnum;

    /**
     * 班级论题数目
     */
    @Column(name = "forumTopicNum")
    private Integer forumtopicnum;

    /**
     * 班级主题数目
     */
    @Column(name = "forumItemNum")
    private Integer forumitemnum;

    /**
     * 班级回帖数目
     */
    @Column(name = "forumReItemNum")
    private Integer forumreitemnum;

    /**
     * 班级评论数目
     */
    @Column(name = "forumOpinionNum")
    private Integer forumopinionnum;

    /**
     * 学期Id
     */
    @Column(name = "studyTermId")
    private Long studytermid;

    /**
     * 地区编码
     */
    @Column(name = "districtId")
    private Long districtid;

    /**
     * 是否是三年无忧班级 0 否  1 是
     */
    @Column(name = "isThree")
    private Boolean isthree;

    /**
     * 班级人数
     */
    @Column(name = "stuNum")
    private Integer stunum;

    @Column(name = "ClassImage")
    private String classimage;

    /**
     * 0已读  1未读
     */
    @Column(name = "isRead")
    private Integer isread;

    public Grade(Long id, Long schoolid, Long termid, String name, String classname, String nickname, String manager, String createman, String status, Date year, Date createtime, Boolean isflag, String ischank, Date deletetime, String note, Long channellimit, Boolean flag, Integer forumpartnum, Integer forumtopicnum, Integer forumitemnum, Integer forumreitemnum, Integer forumopinionnum, Long studytermid, Long districtid, Boolean isthree, Integer stunum, String classimage, Integer isread) {
        this.id = id;
        this.schoolid = schoolid;
        this.termid = termid;
        this.name = name;
        this.classname = classname;
        this.nickname = nickname;
        this.manager = manager;
        this.createman = createman;
        this.status = status;
        this.year = year;
        this.createtime = createtime;
        this.isflag = isflag;
        this.ischank = ischank;
        this.deletetime = deletetime;
        this.note = note;
        this.channellimit = channellimit;
        this.flag = flag;
        this.forumpartnum = forumpartnum;
        this.forumtopicnum = forumtopicnum;
        this.forumitemnum = forumitemnum;
        this.forumreitemnum = forumreitemnum;
        this.forumopinionnum = forumopinionnum;
        this.studytermid = studytermid;
        this.districtid = districtid;
        this.isthree = isthree;
        this.stunum = stunum;
        this.classimage = classimage;
        this.isread = isread;
    }

    public Grade() {
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
     * @return SchoolId
     */
    public Long getSchoolid() {
        return schoolid;
    }

    /**
     * @param schoolid
     */
    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }

    /**
     * 获取学段id
     *
     * @return TermId - 学段id
     */
    public Long getTermid() {
        return termid;
    }

    /**
     * 设置学段id
     *
     * @param termid 学段id
     */
    public void setTermid(Long termid) {
        this.termid = termid;
    }

    /**
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return ClassName
     */
    public String getClassname() {
        return classname;
    }

    /**
     * @param classname
     */
    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    /**
     * 获取�������
     *
     * @return NickName - �������
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 设置�������
     *
     * @param nickname �������
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 获取�༶����Ա
     *
     * @return Manager - �༶����Ա
     */
    public String getManager() {
        return manager;
    }

    /**
     * 设置�༶����Ա
     *
     * @param manager �༶����Ա
     */
    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
    }

    /**
     * @return CreateMan
     */
    public String getCreateman() {
        return createman;
    }

    /**
     * @param createman
     */
    public void setCreateman(String createman) {
        this.createman = createman == null ? null : createman.trim();
    }

    /**
     * 获取N ʹ���С�C �ر� 
     *
     * @return Status - N ʹ���С�C �ر� 
     */
    public String getStatus() {
        return status;
    }

    /**
     * 设置N ʹ���С�C �ر� 
     *
     * @param status N ʹ���С�C �ر� 
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * @return Year
     */
    public Date getYear() {
        return year;
    }

    /**
     * @param year
     */
    public void setYear(Date year) {
        this.year = year;
    }

    /**
     * 获取创建时间
     *
     * @return CreateTime - 创建时间
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
     * 获取标识是行政班级，还是课程班级，0-----行政班级；1------课程班级
     *
     * @return IsFlag - 标识是行政班级，还是课程班级，0-----行政班级；1------课程班级
     */
    public Boolean getIsflag() {
        return isflag;
    }

    /**
     * 设置标识是行政班级，还是课程班级，0-----行政班级；1------课程班级
     *
     * @param isflag 标识是行政班级，还是课程班级，0-----行政班级；1------课程班级
     */
    public void setIsflag(Boolean isflag) {
        this.isflag = isflag;
    }

    /**
     * 获取�Ƿ����ͨ����3-----��1----�ǣ�2----����ˣ�
     *
     * @return IsChank - �Ƿ����ͨ����3-----��1----�ǣ�2----����ˣ�
     */
    public String getIschank() {
        return ischank;
    }

    /**
     * 设置�Ƿ����ͨ����3-----��1----�ǣ�2----����ˣ�
     *
     * @param ischank �Ƿ����ͨ����3-----��1----�ǣ�2----����ˣ�
     */
    public void setIschank(String ischank) {
        this.ischank = ischank == null ? null : ischank.trim();
    }

    /**
     * 获取删除时间
     *
     * @return DeleteTime - 删除时间
     */
    public Date getDeletetime() {
        return deletetime;
    }

    /**
     * 设置删除时间
     *
     * @param deletetime 删除时间
     */
    public void setDeletetime(Date deletetime) {
        this.deletetime = deletetime;
    }

    /**
     * @return Note
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

    /**
     * 获取标识是否限制聊天，0------不限制；1-------限制
     *
     * @return ChannelLimit - 标识是否限制聊天，0------不限制；1-------限制
     */
    public Long getChannellimit() {
        return channellimit;
    }

    /**
     * 设置标识是否限制聊天，0------不限制；1-------限制
     *
     * @param channellimit 标识是否限制聊天，0------不限制；1-------限制
     */
    public void setChannellimit(Long channellimit) {
        this.channellimit = channellimit;
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
     * 获取班级栏目数目
     *
     * @return forumPartNum - 班级栏目数目
     */
    public Integer getForumpartnum() {
        return forumpartnum;
    }

    /**
     * 设置班级栏目数目
     *
     * @param forumpartnum 班级栏目数目
     */
    public void setForumpartnum(Integer forumpartnum) {
        this.forumpartnum = forumpartnum;
    }

    /**
     * 获取班级论题数目
     *
     * @return forumTopicNum - 班级论题数目
     */
    public Integer getForumtopicnum() {
        return forumtopicnum;
    }

    /**
     * 设置班级论题数目
     *
     * @param forumtopicnum 班级论题数目
     */
    public void setForumtopicnum(Integer forumtopicnum) {
        this.forumtopicnum = forumtopicnum;
    }

    /**
     * 获取班级主题数目
     *
     * @return forumItemNum - 班级主题数目
     */
    public Integer getForumitemnum() {
        return forumitemnum;
    }

    /**
     * 设置班级主题数目
     *
     * @param forumitemnum 班级主题数目
     */
    public void setForumitemnum(Integer forumitemnum) {
        this.forumitemnum = forumitemnum;
    }

    /**
     * 获取班级回帖数目
     *
     * @return forumReItemNum - 班级回帖数目
     */
    public Integer getForumreitemnum() {
        return forumreitemnum;
    }

    /**
     * 设置班级回帖数目
     *
     * @param forumreitemnum 班级回帖数目
     */
    public void setForumreitemnum(Integer forumreitemnum) {
        this.forumreitemnum = forumreitemnum;
    }

    /**
     * 获取班级评论数目
     *
     * @return forumOpinionNum - 班级评论数目
     */
    public Integer getForumopinionnum() {
        return forumopinionnum;
    }

    /**
     * 设置班级评论数目
     *
     * @param forumopinionnum 班级评论数目
     */
    public void setForumopinionnum(Integer forumopinionnum) {
        this.forumopinionnum = forumopinionnum;
    }

    /**
     * 获取学期Id
     *
     * @return studyTermId - 学期Id
     */
    public Long getStudytermid() {
        return studytermid;
    }

    /**
     * 设置学期Id
     *
     * @param studytermid 学期Id
     */
    public void setStudytermid(Long studytermid) {
        this.studytermid = studytermid;
    }

    /**
     * 获取地区编码
     *
     * @return districtId - 地区编码
     */
    public Long getDistrictid() {
        return districtid;
    }

    /**
     * 设置地区编码
     *
     * @param districtid 地区编码
     */
    public void setDistrictid(Long districtid) {
        this.districtid = districtid;
    }

    /**
     * 获取是否是三年无忧班级 0 否  1 是
     *
     * @return isThree - 是否是三年无忧班级 0 否  1 是
     */
    public Boolean getIsthree() {
        return isthree;
    }

    /**
     * 设置是否是三年无忧班级 0 否  1 是
     *
     * @param isthree 是否是三年无忧班级 0 否  1 是
     */
    public void setIsthree(Boolean isthree) {
        this.isthree = isthree;
    }

    /**
     * 获取班级人数
     *
     * @return stuNum - 班级人数
     */
    public Integer getStunum() {
        return stunum;
    }

    /**
     * 设置班级人数
     *
     * @param stunum 班级人数
     */
    public void setStunum(Integer stunum) {
        this.stunum = stunum;
    }

    /**
     * @return ClassImage
     */
    public String getClassimage() {
        return classimage;
    }

    /**
     * @param classimage
     */
    public void setClassimage(String classimage) {
        this.classimage = classimage == null ? null : classimage.trim();
    }

    /**
     * 获取0已读  1未读
     *
     * @return isRead - 0已读  1未读
     */
    public Integer getIsread() {
        return isread;
    }

    /**
     * 设置0已读  1未读
     *
     * @param isread 0已读  1未读
     */
    public void setIsread(Integer isread) {
        this.isread = isread;
    }
}