package net.tfedu.zhl.cloud.resource.navigation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 课程实体类
 * @author WeiCuicui
 *
 */
@Table(name = "j_syscourse")
public class JSyscourse implements Serializable {

    private static final long serialVersionUID = 8160030266758656476L;

    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 科目id
     */
    @Column(name = "SubjectId")
    private Long subjectid;

    /**
     * 学段id
     */
    @Column(name = "TermId")
    private Long termid;

    /**
     * 父节点
     */
    @Column(name = "PnodeId")
    private Long pnodeid;

    @Column(name = "Name")
    private String name;

    /**
     * ͬ
     */
    @Column(name = "TFcode")
    private String tfcode;

    /**
     * N-----
     */
    @Column(name = "IsArea")
    private String isarea;

    /**
     * 第一页
     */
    @Column(name = "FirstPage")
    private Integer firstpage;

    /**
     * 最后一页
     */
    @Column(name = "EndPage")
    private Integer endpage;

    /**
     * 系统资源
     */
    @Column(name = "ResourceId")
    private Long resourceid;

    @Column(name = "EbookPath")
    private String ebookpath;

    @Column(name = "EbookDic")
    private String ebookdic;

    /**
     * 是否删除，0-----否；1----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 0 共用 1平台教材 2 三年无忧
     */
    @Column(name = "typeFlag")
    private Integer typeflag;

    /**
     * 序排字段
     */
    @Column(name = "orderNum")
    private Long ordernum;

    /**
     * 是否可见（三年无忧） 1 可见 0 不可见
     */
    private Boolean visible;

    /**
     * 年级代码：1-12；分别代表十二个年级。0代表无年级信息
     */
    @Column(name = "Grade")
    private Short grade;

    /**
     * 更新时间
     */
    @Column(name = "UpdateTime")
    private Date updatetime;

    @Column(name = "CreateDT")
    private Date createdt;

    private Date createtime;

    @Column(name = "isSpec")
    private Boolean isspec;

    private Boolean enabled;

    /**
     * c
     */
    private String createman;

    @Column(name = "scopeType")
    private Integer scopetype;

    public JSyscourse(Long id, Long subjectid, Long termid, Long pnodeid, String name, String tfcode, String isarea,
            Integer firstpage, Integer endpage, Long resourceid, String ebookpath, String ebookdic, Boolean flag,
            Integer typeflag, Long ordernum, Boolean visible, Short grade, Date updatetime, Date createdt,
            Date createtime, Boolean isspec, Boolean enabled, String createman, Integer scopetype) {
        this.id = id;
        this.subjectid = subjectid;
        this.termid = termid;
        this.pnodeid = pnodeid;
        this.name = name;
        this.tfcode = tfcode;
        this.isarea = isarea;
        this.firstpage = firstpage;
        this.endpage = endpage;
        this.resourceid = resourceid;
        this.ebookpath = ebookpath;
        this.ebookdic = ebookdic;
        this.flag = flag;
        this.typeflag = typeflag;
        this.ordernum = ordernum;
        this.visible = visible;
        this.grade = grade;
        this.updatetime = updatetime;
        this.createdt = createdt;
        this.createtime = createtime;
        this.isspec = isspec;
        this.enabled = enabled;
        this.createman = createman;
        this.scopetype = scopetype;
    }

    public JSyscourse() {
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
     * @param termid
     *            学段id
     */
    public void setTermid(Long termid) {
        this.termid = termid;
    }

    /**
     * 获取父节点
     *
     * @return PnodeId - 父节点
     */
    public Long getPnodeid() {
        return pnodeid;
    }

    /**
     * 设置父节点
     *
     * @param pnodeid
     *            父节点
     */
    public void setPnodeid(Long pnodeid) {
        this.pnodeid = pnodeid;
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
     * 获取ͬ
     *
     * @return TFcode - ͬ
     */
    public String getTfcode() {
        return tfcode;
    }

    /**
     * 设置ͬ
     *
     * @param tfcode
     *            ͬ
     */
    public void setTfcode(String tfcode) {
        this.tfcode = tfcode == null ? null : tfcode.trim();
    }

    /**
     * 获取N-----
     *
     * @return IsArea - N-----
     */
    public String getIsarea() {
        return isarea;
    }

    /**
     * 设置N-----
     *
     * @param isarea
     *            N-----
     */
    public void setIsarea(String isarea) {
        this.isarea = isarea == null ? null : isarea.trim();
    }

    /**
     * 获取第一页
     *
     * @return FirstPage - 第一页
     */
    public Integer getFirstpage() {
        return firstpage;
    }

    /**
     * 设置第一页
     *
     * @param firstpage
     *            第一页
     */
    public void setFirstpage(Integer firstpage) {
        this.firstpage = firstpage;
    }

    /**
     * 获取最后一页
     *
     * @return EndPage - 最后一页
     */
    public Integer getEndpage() {
        return endpage;
    }

    /**
     * 设置最后一页
     *
     * @param endpage
     *            最后一页
     */
    public void setEndpage(Integer endpage) {
        this.endpage = endpage;
    }

    /**
     * 获取系统资源
     *
     * @return ResourceId - 系统资源
     */
    public Long getResourceid() {
        return resourceid;
    }

    /**
     * 设置系统资源
     *
     * @param resourceid
     *            系统资源
     */
    public void setResourceid(Long resourceid) {
        this.resourceid = resourceid;
    }

    /**
     * @return EbookPath
     */
    public String getEbookpath() {
        return ebookpath;
    }

    /**
     * @param ebookpath
     */
    public void setEbookpath(String ebookpath) {
        this.ebookpath = ebookpath == null ? null : ebookpath.trim();
    }

    /**
     * @return EbookDic
     */
    public String getEbookdic() {
        return ebookdic;
    }

    /**
     * @param ebookdic
     */
    public void setEbookdic(String ebookdic) {
        this.ebookdic = ebookdic == null ? null : ebookdic.trim();
    }

    /**
     * 获取是否删除，0-----否；1----是
     *
     * @return Flag - 是否删除，0-----否；1----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除，0-----否；1----是
     *
     * @param flag
     *            是否删除，0-----否；1----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取0 共用 1平台教材 2 三年无忧
     *
     * @return typeFlag - 0 共用 1平台教材 2 三年无忧
     */
    public Integer getTypeflag() {
        return typeflag;
    }

    /**
     * 设置0 共用 1平台教材 2 三年无忧
     *
     * @param typeflag
     *            0 共用 1平台教材 2 三年无忧
     */
    public void setTypeflag(Integer typeflag) {
        this.typeflag = typeflag;
    }

    /**
     * 获取序排字段
     *
     * @return orderNum - 序排字段
     */
    public Long getOrdernum() {
        return ordernum;
    }

    /**
     * 设置序排字段
     *
     * @param ordernum
     *            序排字段
     */
    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    /**
     * 获取是否可见（三年无忧） 1 可见 0 不可见
     *
     * @return visible - 是否可见（三年无忧） 1 可见 0 不可见
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * 设置是否可见（三年无忧） 1 可见 0 不可见
     *
     * @param visible
     *            是否可见（三年无忧） 1 可见 0 不可见
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * 获取年级代码：1-12；分别代表十二个年级。0代表无年级信息
     *
     * @return Grade - 年级代码：1-12；分别代表十二个年级。0代表无年级信息
     */
    public Short getGrade() {
        return grade;
    }

    /**
     * 设置年级代码：1-12；分别代表十二个年级。0代表无年级信息
     *
     * @param grade
     *            年级代码：1-12；分别代表十二个年级。0代表无年级信息
     */
    public void setGrade(Short grade) {
        this.grade = grade;
    }

    /**
     * 获取更新时间
     *
     * @return UpdateTime - 更新时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置更新时间
     *
     * @param updatetime
     *            更新时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * @return CreateDT
     */
    public Date getCreatedt() {
        return createdt;
    }

    /**
     * @param createdt
     */
    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    /**
     * @return createtime
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
     * @return isSpec
     */
    public Boolean getIsspec() {
        return isspec;
    }

    /**
     * @param isspec
     */
    public void setIsspec(Boolean isspec) {
        this.isspec = isspec;
    }

    /**
     * @return enabled
     */
    public Boolean getEnabled() {
        return enabled;
    }

    /**
     * @param enabled
     */
    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * 获取c
     *
     * @return createman - c
     */
    public String getCreateman() {
        return createman;
    }

    /**
     * 设置c
     *
     * @param createman
     *            c
     */
    public void setCreateman(String createman) {
        this.createman = createman == null ? null : createman.trim();
    }

    /**
     * @return scopeType
     */
    public Integer getScopetype() {
        return scopetype;
    }

    /**
     * @param scopetype
     */
    public void setScopetype(Integer scopetype) {
        this.scopetype = scopetype;
    }
}
