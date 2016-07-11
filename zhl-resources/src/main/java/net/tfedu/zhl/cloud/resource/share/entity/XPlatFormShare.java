package net.tfedu.zhl.cloud.resource.share.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "x_platform_share")
public class XPlatFormShare {
    /**
     * 自增主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 知识点导航code
     */
    @Column(name = "studyCourseId")
    private String studycourseid;

    /**
     * 共享对象类型 1  资源 2 学案 3 作业  4 测试
     */
    @Column(name = "sharedType")
    private Integer sharedtype;

    /**
     * 共享对象Id
     */
    @Column(name = "shareId")
    private Long shareid;

    /**
     * 共享范围    W：站，A：省，B：市，C：县（区），  D：校，E：级，F：班，G：组 
     */
    private String scope;

    /**
     * 共享范围Id
     */
    @Column(name = "scopeId")
    private Long scopeid;

    /**
     * 共享人
     */
    private Long userid;

    /**
     * 共享时间
     */
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 点击数
     */
    private Integer clicks;

    /**
     * 引用数
     */
    private Integer quotes;

    /**
     * 资源下载次数
     */
    private Integer downloads;

    /**
     * 删除标示
     */
    private Boolean flag;

    /**
     * 系统资源类型Id
     */
    @Column(name = "sysResourceType")
    private Long sysresourcetype;

    public XPlatFormShare(Long id, String studycourseid, Integer sharedtype, Long shareid, String scope, Long scopeid, Long userid, Date createtime, Integer clicks, Integer quotes, Integer downloads, Boolean flag, Long sysresourcetype) {
        this.id = id;
        this.studycourseid = studycourseid;
        this.sharedtype = sharedtype;
        this.shareid = shareid;
        this.scope = scope;
        this.scopeid = scopeid;
        this.userid = userid;
        this.createtime = createtime;
        this.clicks = clicks;
        this.quotes = quotes;
        this.downloads = downloads;
        this.flag = flag;
        this.sysresourcetype = sysresourcetype;
    }

    public XPlatFormShare() {
        super();
    }

    /**
     * 获取自增主键
     *
     * @return id - 自增主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增主键
     *
     * @param id 自增主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取知识点导航code
     *
     * @return studyCourseId - 知识点导航code
     */
    public String getStudycourseid() {
        return studycourseid;
    }

    /**
     * 设置知识点导航code
     *
     * @param studycourseid 知识点导航code
     */
    public void setStudycourseid(String studycourseid) {
        this.studycourseid = studycourseid == null ? null : studycourseid.trim();
    }

    /**
     * 获取共享对象类型 1  资源 2 学案 3 作业  4 测试
     *
     * @return sharedType - 共享对象类型 1  资源 2 学案 3 作业  4 测试
     */
    public Integer getSharedtype() {
        return sharedtype;
    }

    /**
     * 设置共享对象类型 1  资源 2 学案 3 作业  4 测试
     *
     * @param sharedtype 共享对象类型 1  资源 2 学案 3 作业  4 测试
     */
    public void setSharedtype(Integer sharedtype) {
        this.sharedtype = sharedtype;
    }

    /**
     * 获取共享对象Id
     *
     * @return shareId - 共享对象Id
     */
    public Long getShareid() {
        return shareid;
    }

    /**
     * 设置共享对象Id
     *
     * @param shareid 共享对象Id
     */
    public void setShareid(Long shareid) {
        this.shareid = shareid;
    }

    /**
     * 获取共享范围    W：站，A：省，B：市，C：县（区），  D：校，E：级，F：班，G：组 
     *
     * @return scope - 共享范围    W：站，A：省，B：市，C：县（区），  D：校，E：级，F：班，G：组 
     */
    public String getScope() {
        return scope;
    }

    /**
     * 设置共享范围    W：站，A：省，B：市，C：县（区），  D：校，E：级，F：班，G：组 
     *
     * @param scope 共享范围    W：站，A：省，B：市，C：县（区），  D：校，E：级，F：班，G：组 
     */
    public void setScope(String scope) {
        this.scope = scope == null ? null : scope.trim();
    }

    /**
     * 获取共享范围Id
     *
     * @return scopeId - 共享范围Id
     */
    public Long getScopeid() {
        return scopeid;
    }

    /**
     * 设置共享范围Id
     *
     * @param scopeid 共享范围Id
     */
    public void setScopeid(Long scopeid) {
        this.scopeid = scopeid;
    }

    /**
     * 获取共享人
     *
     * @return userid - 共享人
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置共享人
     *
     * @param userid 共享人
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取共享时间
     *
     * @return createTime - 共享时间
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置共享时间
     *
     * @param createtime 共享时间
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取点击数
     *
     * @return clicks - 点击数
     */
    public Integer getClicks() {
        return clicks;
    }

    /**
     * 设置点击数
     *
     * @param clicks 点击数
     */
    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    /**
     * 获取引用数
     *
     * @return quotes - 引用数
     */
    public Integer getQuotes() {
        return quotes;
    }

    /**
     * 设置引用数
     *
     * @param quotes 引用数
     */
    public void setQuotes(Integer quotes) {
        this.quotes = quotes;
    }

    /**
     * 获取资源下载次数
     *
     * @return downloads - 资源下载次数
     */
    public Integer getDownloads() {
        return downloads;
    }

    /**
     * 设置资源下载次数
     *
     * @param downloads 资源下载次数
     */
    public void setDownloads(Integer downloads) {
        this.downloads = downloads;
    }

    /**
     * 获取删除标示
     *
     * @return flag - 删除标示
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置删除标示
     *
     * @param flag 删除标示
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取系统资源类型Id
     *
     * @return sysResourceType - 系统资源类型Id
     */
    public Long getSysresourcetype() {
        return sysresourcetype;
    }

    /**
     * 设置系统资源类型Id
     *
     * @param sysresourcetype 系统资源类型Id
     */
    public void setSysresourcetype(Long sysresourcetype) {
        this.sysresourcetype = sysresourcetype;
    }
}