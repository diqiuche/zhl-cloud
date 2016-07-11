package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;

@Table(name = "z_resource")
public class SysResource implements Serializable {
    /**
     * 序列号
     */
    private static final long serialVersionUID = 8160030266758656476L;
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ResCode")
    private String rescode;

    @Column(name = "Provider")
    private String provider;

    @Column(name = "Title")
    private String title;

    @Column(name = "keyWord")
    private String keyword;

    @Column(name = "FPath")
    private String fpath;

    @Column(name = "Fname")
    private String fname;

    @Column(name = "Creator")
    private String creator;

    @Column(name = "Author")
    private String author;

    /**
     * 创建时间
     */
    @Column(name = "CreateDT")
    private Date createdt;

    /**
     * 更新时间
     */
    @Column(name = "UpdateDT")
    private Date updatedt;

    /**
     * Դ
     */
    @Column(name = "FSize")
    private String fsize;

    @Column(name = "TypeLean")
    private String typelean;

    /**
     * 资源类型的外键
     */
    @Column(name = "oldMType")
    private Integer oldmtype;

    /**
     * 是否网络资源(0-网络资源,1-本地资源)
     */
    @Column(name = "IsLocal")
    private Boolean islocal;

    @Column(name = "Editor")
    private String editor;

    @Column(name = "ThumbnailName")
    private String thumbnailname;

    @Column(name = "ThumbnailNote")
    private String thumbnailnote;

    @Column(name = "ThumbnailPath")
    private String thumbnailpath;

    @Column(name = "EduPlace")
    private String eduplace;

    @Column(name = "SuitTerm")
    private String suitterm;

    @Column(name = "Copyright")
    private String copyright;

    /**
     * 上传资源所获积分
     */
    @Column(name = "UpLoadScore")
    private Integer uploadscore;

    /**
     * 该资源被下载次数
     */
    @Column(name = "DLoadTimes")
    private Integer dloadtimes;

    /**
     * 规定下载该条资源所需积分
     */
    @Column(name = "DLoadScore")
    private Integer dloadscore;

    /**
     * 资源点击次数
     */
    @Column(name = "ClickTimes")
    private Integer clicktimes;

    /**
     * 该资源被收藏次数
     */
    @Column(name = "SCTimes")
    private Integer sctimes;

    @Column(name = "Rdes")
    private String rdes;

    /**
     * 是否删除(0-未删除,1-删除)
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 资源来源0 平台资源 1 专家辅导资源 2三年无忧资源
     */
    private Integer fromflag;

    /**
     * 是否是多文件资源
     */
    @Column(name = "isDWJ")
    private Boolean isdwj;

    @Column(name = "FileExt")
    private String fileext;

    private String authorunit;

    /**
     * 评级0-5（0不要，最高5)
     */
    @Column(name = "displayLevel")
    private Integer displaylevel;

    @Column(name = "NewTeachingtype")
    private String newteachingtype;

    @Column(name = "MType")
    private Integer mtype;

    /**
     * 搜索结果的素材显示顺序，增序，数小的排在前面
     */
    @Column(name = "displayIndex")
    private Integer displayindex;

    /**
     * 全路径
     */
    @Column(name = "Fullpath")
    private String fullpath;

    private String speaker;

    @Column(name = "speakerUnit")
    private String speakerunit;

    /**
     * 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    @Column(name = "Resolution")
    private Integer resolution;

    /**
     * 新版3.1资源类型
     */
    @Column(name = "unifyTypeid")
    private String unifytypeid;

    @Column(name = "Des")
    private String des;

    /**
     * 课程表
     */
    @Transient
    private JSyscourse syscourse;

    public JSyscourse getSyscourse() {
        return syscourse;
    }

    public void setSyscourse(JSyscourse syscourse) {
        this.syscourse = syscourse;
    }

    public SysResource(Long id, String rescode, String provider, String title, String keyword, String fpath,
            String fname, String creator, String author, Date createdt, Date updatedt, String fsize, String typelean,
            Integer oldmtype, Boolean islocal, String editor, String thumbnailname, String thumbnailnote,
            String thumbnailpath, String eduplace, String suitterm, String copyright, Integer uploadscore,
            Integer dloadtimes, Integer dloadscore, Integer clicktimes, Integer sctimes, String rdes, Boolean flag,
            Integer fromflag, Boolean isdwj, String fileext, String authorunit, Integer displaylevel,
            String newteachingtype, Integer mtype, Integer displayindex, String fullpath, String speaker,
            String speakerunit, Integer resolution, String unifytypeid, String des) {
        this.id = id;
        this.rescode = rescode;
        this.provider = provider;
        this.title = title;
        this.keyword = keyword;
        this.fpath = fpath;
        this.fname = fname;
        this.creator = creator;
        this.author = author;
        this.createdt = createdt;
        this.updatedt = updatedt;
        this.fsize = fsize;
        this.typelean = typelean;
        this.oldmtype = oldmtype;
        this.islocal = islocal;
        this.editor = editor;
        this.thumbnailname = thumbnailname;
        this.thumbnailnote = thumbnailnote;
        this.thumbnailpath = thumbnailpath;
        this.eduplace = eduplace;
        this.suitterm = suitterm;
        this.copyright = copyright;
        this.uploadscore = uploadscore;
        this.dloadtimes = dloadtimes;
        this.dloadscore = dloadscore;
        this.clicktimes = clicktimes;
        this.sctimes = sctimes;
        this.rdes = rdes;
        this.flag = flag;
        this.fromflag = fromflag;
        this.isdwj = isdwj;
        this.fileext = fileext;
        this.authorunit = authorunit;
        this.displaylevel = displaylevel;
        this.newteachingtype = newteachingtype;
        this.mtype = mtype;
        this.displayindex = displayindex;
        this.fullpath = fullpath;
        this.speaker = speaker;
        this.speakerunit = speakerunit;
        this.resolution = resolution;
        this.unifytypeid = unifytypeid;
        this.des = des;
    }

    public SysResource() {
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
     * @return ResCode
     */
    public String getRescode() {
        return rescode;
    }

    /**
     * @param rescode
     */
    public void setRescode(String rescode) {
        this.rescode = rescode == null ? null : rescode.trim();
    }

    /**
     * @return Provider
     */
    public String getProvider() {
        return provider;
    }

    /**
     * @param provider
     */
    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    /**
     * @return Title
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
     * @return keyWord
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * @param keyword
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * @return FPath
     */
    public String getFpath() {
        return fpath;
    }

    /**
     * @param fpath
     */
    public void setFpath(String fpath) {
        this.fpath = fpath == null ? null : fpath.trim();
    }

    /**
     * @return Fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname
     */
    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    /**
     * @return Creator
     */
    public String getCreator() {
        return creator;
    }

    /**
     * @param creator
     */
    public void setCreator(String creator) {
        this.creator = creator == null ? null : creator.trim();
    }

    /**
     * @return Author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author == null ? null : author.trim();
    }

    /**
     * 获取创建时间
     *
     * @return CreateDT - 创建时间
     */
    public Date getCreatedt() {
        return createdt;
    }

    /**
     * 设置创建时间
     *
     * @param createdt
     *            创建时间
     */
    public void setCreatedt(Date createdt) {
        this.createdt = createdt;
    }

    /**
     * 获取更新时间
     *
     * @return UpdateDT - 更新时间
     */
    public Date getUpdatedt() {
        return updatedt;
    }

    /**
     * 设置更新时间
     *
     * @param updatedt
     *            更新时间
     */
    public void setUpdatedt(Date updatedt) {
        this.updatedt = updatedt;
    }

    /**
     * 获取Դ
     *
     * @return FSize - Դ
     */
    public String getFsize() {
        return fsize;
    }

    /**
     * 设置Դ
     *
     * @param fsize
     *            Դ
     */
    public void setFsize(String fsize) {
        this.fsize = fsize == null ? null : fsize.trim();
    }

    /**
     * @return TypeLean
     */
    public String getTypelean() {
        return typelean;
    }

    /**
     * @param typelean
     */
    public void setTypelean(String typelean) {
        this.typelean = typelean == null ? null : typelean.trim();
    }

    /**
     * 获取资源类型的外键
     *
     * @return oldMType - 资源类型的外键
     */
    public Integer getOldmtype() {
        return oldmtype;
    }

    /**
     * 设置资源类型的外键
     *
     * @param oldmtype
     *            资源类型的外键
     */
    public void setOldmtype(Integer oldmtype) {
        this.oldmtype = oldmtype;
    }

    /**
     * 获取是否网络资源(0-网络资源,1-本地资源)
     *
     * @return IsLocal - 是否网络资源(0-网络资源,1-本地资源)
     */
    public Boolean getIslocal() {
        return islocal;
    }

    /**
     * 设置是否网络资源(0-网络资源,1-本地资源)
     *
     * @param islocal
     *            是否网络资源(0-网络资源,1-本地资源)
     */
    public void setIslocal(Boolean islocal) {
        this.islocal = islocal;
    }

    /**
     * @return Editor
     */
    public String getEditor() {
        return editor;
    }

    /**
     * @param editor
     */
    public void setEditor(String editor) {
        this.editor = editor == null ? null : editor.trim();
    }

    /**
     * @return ThumbnailName
     */
    public String getThumbnailname() {
        return thumbnailname;
    }

    /**
     * @param thumbnailname
     */
    public void setThumbnailname(String thumbnailname) {
        this.thumbnailname = thumbnailname == null ? null : thumbnailname.trim();
    }

    /**
     * @return ThumbnailNote
     */
    public String getThumbnailnote() {
        return thumbnailnote;
    }

    /**
     * @param thumbnailnote
     */
    public void setThumbnailnote(String thumbnailnote) {
        this.thumbnailnote = thumbnailnote == null ? null : thumbnailnote.trim();
    }

    /**
     * @return ThumbnailPath
     */
    public String getThumbnailpath() {
        return thumbnailpath;
    }

    /**
     * @param thumbnailpath
     */
    public void setThumbnailpath(String thumbnailpath) {
        this.thumbnailpath = thumbnailpath == null ? null : thumbnailpath.trim();
    }

    /**
     * @return EduPlace
     */
    public String getEduplace() {
        return eduplace;
    }

    /**
     * @param eduplace
     */
    public void setEduplace(String eduplace) {
        this.eduplace = eduplace == null ? null : eduplace.trim();
    }

    /**
     * @return SuitTerm
     */
    public String getSuitterm() {
        return suitterm;
    }

    /**
     * @param suitterm
     */
    public void setSuitterm(String suitterm) {
        this.suitterm = suitterm == null ? null : suitterm.trim();
    }

    /**
     * @return Copyright
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * @param copyright
     */
    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    /**
     * 获取上传资源所获积分
     *
     * @return UpLoadScore - 上传资源所获积分
     */
    public Integer getUploadscore() {
        return uploadscore;
    }

    /**
     * 设置上传资源所获积分
     *
     * @param uploadscore
     *            上传资源所获积分
     */
    public void setUploadscore(Integer uploadscore) {
        this.uploadscore = uploadscore;
    }

    /**
     * 获取该资源被下载次数
     *
     * @return DLoadTimes - 该资源被下载次数
     */
    public Integer getDloadtimes() {
        return dloadtimes;
    }

    /**
     * 设置该资源被下载次数
     *
     * @param dloadtimes
     *            该资源被下载次数
     */
    public void setDloadtimes(Integer dloadtimes) {
        this.dloadtimes = dloadtimes;
    }

    /**
     * 获取规定下载该条资源所需积分
     *
     * @return DLoadScore - 规定下载该条资源所需积分
     */
    public Integer getDloadscore() {
        return dloadscore;
    }

    /**
     * 设置规定下载该条资源所需积分
     *
     * @param dloadscore
     *            规定下载该条资源所需积分
     */
    public void setDloadscore(Integer dloadscore) {
        this.dloadscore = dloadscore;
    }

    /**
     * 获取资源点击次数
     *
     * @return ClickTimes - 资源点击次数
     */
    public Integer getClicktimes() {
        return clicktimes;
    }

    /**
     * 设置资源点击次数
     *
     * @param clicktimes
     *            资源点击次数
     */
    public void setClicktimes(Integer clicktimes) {
        this.clicktimes = clicktimes;
    }

    /**
     * 获取该资源被收藏次数
     *
     * @return SCTimes - 该资源被收藏次数
     */
    public Integer getSctimes() {
        return sctimes;
    }

    /**
     * 设置该资源被收藏次数
     *
     * @param sctimes
     *            该资源被收藏次数
     */
    public void setSctimes(Integer sctimes) {
        this.sctimes = sctimes;
    }

    /**
     * @return Rdes
     */
    public String getRdes() {
        return rdes;
    }

    /**
     * @param rdes
     */
    public void setRdes(String rdes) {
        this.rdes = rdes == null ? null : rdes.trim();
    }

    /**
     * 获取是否删除(0-未删除,1-删除)
     *
     * @return Flag - 是否删除(0-未删除,1-删除)
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除(0-未删除,1-删除)
     *
     * @param flag
     *            是否删除(0-未删除,1-删除)
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取资源来源0 平台资源 1 专家辅导资源 2三年无忧资源
     *
     * @return fromflag - 资源来源0 平台资源 1 专家辅导资源 2三年无忧资源
     */
    public Integer getFromflag() {
        return fromflag;
    }

    /**
     * 设置资源来源0 平台资源 1 专家辅导资源 2三年无忧资源
     *
     * @param fromflag
     *            资源来源0 平台资源 1 专家辅导资源 2三年无忧资源
     */
    public void setFromflag(Integer fromflag) {
        this.fromflag = fromflag;
    }

    /**
     * 获取是否是多文件资源
     *
     * @return isDWJ - 是否是多文件资源
     */
    public Boolean getIsdwj() {
        return isdwj;
    }

    /**
     * 设置是否是多文件资源
     *
     * @param isdwj
     *            是否是多文件资源
     */
    public void setIsdwj(Boolean isdwj) {
        this.isdwj = isdwj;
    }

    /**
     * @return FileExt
     */
    public String getFileext() {
        return fileext;
    }

    /**
     * @param fileext
     */
    public void setFileext(String fileext) {
        this.fileext = fileext == null ? null : fileext.trim();
    }

    /**
     * @return authorunit
     */
    public String getAuthorunit() {
        return authorunit;
    }

    /**
     * @param authorunit
     */
    public void setAuthorunit(String authorunit) {
        this.authorunit = authorunit == null ? null : authorunit.trim();
    }

    /**
     * 获取评级0-5（0不要，最高5)
     *
     * @return displayLevel - 评级0-5（0不要，最高5)
     */
    public Integer getDisplaylevel() {
        return displaylevel;
    }

    /**
     * 设置评级0-5（0不要，最高5)
     *
     * @param displaylevel
     *            评级0-5（0不要，最高5)
     */
    public void setDisplaylevel(Integer displaylevel) {
        this.displaylevel = displaylevel;
    }

    /**
     * @return NewTeachingtype
     */
    public String getNewteachingtype() {
        return newteachingtype;
    }

    /**
     * @param newteachingtype
     */
    public void setNewteachingtype(String newteachingtype) {
        this.newteachingtype = newteachingtype == null ? null : newteachingtype.trim();
    }

    /**
     * @return MType
     */
    public Integer getMtype() {
        return mtype;
    }

    /**
     * @param mtype
     */
    public void setMtype(Integer mtype) {
        this.mtype = mtype;
    }

    /**
     * 获取搜索结果的素材显示顺序，增序，数小的排在前面
     *
     * @return displayIndex - 搜索结果的素材显示顺序，增序，数小的排在前面
     */
    public Integer getDisplayindex() {
        return displayindex;
    }

    /**
     * 设置搜索结果的素材显示顺序，增序，数小的排在前面
     *
     * @param displayindex
     *            搜索结果的素材显示顺序，增序，数小的排在前面
     */
    public void setDisplayindex(Integer displayindex) {
        this.displayindex = displayindex;
    }

    /**
     * 获取全路径
     *
     * @return Fullpath - 全路径
     */
    public String getFullpath() {
        return fullpath;
    }

    /**
     * 设置全路径
     *
     * @param fullpath
     *            全路径
     */
    public void setFullpath(String fullpath) {
        this.fullpath = fullpath == null ? null : fullpath.trim();
    }

    /**
     * @return speaker
     */
    public String getSpeaker() {
        return speaker;
    }

    /**
     * @param speaker
     */
    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
    }

    /**
     * @return speakerUnit
     */
    public String getSpeakerunit() {
        return speakerunit;
    }

    /**
     * @param speakerunit
     */
    public void setSpeakerunit(String speakerunit) {
        this.speakerunit = speakerunit == null ? null : speakerunit.trim();
    }

    /**
     * 获取0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     *
     * @return Resolution - 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    public Integer getResolution() {
        return resolution;
    }

    /**
     * 设置0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     *
     * @param resolution
     *            0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    public void setResolution(Integer resolution) {
        this.resolution = resolution;
    }

    /**
     * 获取新版3.1资源类型
     *
     * @return unifyTypeid - 新版3.1资源类型
     */
    public String getUnifytypeid() {
        return unifytypeid;
    }

    /**
     * 设置新版3.1资源类型
     *
     * @param unifytypeid
     *            新版3.1资源类型
     */
    public void setUnifytypeid(String unifytypeid) {
        this.unifytypeid = unifytypeid == null ? null : unifytypeid.trim();
    }

    /**
     * @return Des
     */
    public String getDes() {
        return des;
    }

    /**
     * @param des
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
}