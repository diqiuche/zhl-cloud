package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "z_districts_resource")
public class DistrictRes implements Serializable {
    private static final long serialVersionUID = 8160030266758656476L;
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 编码
     */
    @Column(name = "ResCode")
    private String rescode;

    /**
     * 资源提供商
     */
    @Column(name = "Provider")
    private String provider;

    /**
     * 资源标题
     */
    @Column(name = "Title")
    private String title;

    /**
     * 关键字
     */
    @Column(name = "keyWord")
    private String keyword;

    /**
     * 资源路径
     */
    @Column(name = "FPath")
    private String fpath;

    /**
     * 文件名
     */
    @Column(name = "Fname")
    private String fname;

    /**
     * 创建者
     */
    @Column(name = "CreatorId")
    private Long creatorid;

    /**
     * 作者
     */
    @Column(name = "AuthorId")
    private Long authorid;

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
     * 源资大小
     */
    @Column(name = "FSize")
    private String fsize;

    /**
     * 上传的资源，A----学案；B----测试；C--作业；D---教案；E-----课件
     */
    @Column(name = "TypeLean")
    private String typelean;

    /**
     * 是否网络资源(1-网络资源,0-本地资源)
     */
    @Column(name = "IsLocal")
    private Integer islocal;

    /**
     * 编辑者
     */
    @Column(name = "EditorId")
    private Long editorid;

    /**
     * 缩略图名称
     */
    @Column(name = "ThumbnailName")
    private String thumbnailname;

    /**
     * 缩略图描述
     */
    @Column(name = "ThumbnailNote")
    private String thumbnailnote;

    /**
     * 缩略图路径
     */
    @Column(name = "ThumbnailPath")
    private String thumbnailpath;

    /**
     * 教学场所，比如是：A,多媒体教室、B,礼堂、C,教室
     */
    @Column(name = "EduPlace")
    private String eduplace;

    /**
     * 适合的学段
     */
    @Column(name = "SuitTerm")
    private String suitterm;

    /**
     * 版权
     */
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
     * 自建资源来源id
     */
    @Column(name = "assetId")
    private Long assetid;

    /**
     * 该资源被收藏次数
     */
    @Column(name = "SCTimes")
    private Integer sctimes;

    /**
     * 备注
     */
    @Column(name = "Rdes")
    private String rdes;

    /**
     * 是否删除(0-未删除,1-删除)
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 资源来源 3校本资源 4 区本资源
     */
    @Column(name = "fromFlag")
    private Integer fromflag;

    /**
     * 是否是多文件资源
     */
    @Column(name = "isDWJ")
    private Boolean isdwj;

    @Column(name = "FileExt")
    private String fileext;

    /**
     * 作者单位
     */
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

    /**
     * 主讲人
     */
    private String speaker;

    /**
     * 主讲人单位
     */
    @Column(name = "speakerUnit")
    private String speakerunit;

    /**
     * 视频清晰度 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    @Column(name = "Resolution")
    private Integer resolution;

    /**
     * 0-管理员自己上传，1-共享资源 2-投稿资源
     */
    @Column(name = "AuthorFromFlag")
    private Integer authorfromflag;

    /**
     * 资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
     */
    @Column(name = "Scope")
    private Integer scope;

    /**
     * 范围Id
     */
    @Column(name = "ScopeId")
    private Long scopeid;

    /**
     * 资源状态 1 教师未答复 2 教师拒绝 3教师同意 4 待审核 5 审核失败 6 审核成功 7 存疑
     */
    @Column(name = "State")
    private Integer state;

    /**
     * 审核意见
     */
    @Column(name = "AuditOpinion")
    private String auditopinion;

    @Column(name = "isFinished")
    private Integer isfinished;


    /**
     * 资源描述
     */
    @Column(name = "Des")
    private String des;

    public DistrictRes(Long id, String rescode, String provider, String title, String keyword, String fpath,
            String fname, Long creatorid, Long authorid, Date createdt, Date updatedt, String fsize, String typelean,
            Integer islocal, Long editorid, String thumbnailname, String thumbnailnote, String thumbnailpath,
            String eduplace, String suitterm, String copyright, Integer uploadscore, Integer dloadtimes,
            Integer dloadscore, Integer clicktimes, Long assetid, Integer sctimes, String rdes, Boolean flag,
            Integer fromflag, Boolean isdwj, String fileext, String authorunit, Integer displaylevel,
            String newteachingtype, Integer mtype, Integer displayindex, String fullpath, String speaker,
            String speakerunit, Integer resolution, Integer authorfromflag, Integer scope, Long scopeid, Integer state,
            String auditopinion, Integer isfinished, String des) {
        this.id = id;
        this.rescode = rescode;
        this.provider = provider;
        this.title = title;
        this.keyword = keyword;
        this.fpath = fpath;
        this.fname = fname;
        this.creatorid = creatorid;
        this.authorid = authorid;
        this.createdt = createdt;
        this.updatedt = updatedt;
        this.fsize = fsize;
        this.typelean = typelean;
        this.islocal = islocal;
        this.editorid = editorid;
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
        this.assetid = assetid;
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
        this.authorfromflag = authorfromflag;
        this.scope = scope;
        this.scopeid = scopeid;
        this.state = state;
        this.auditopinion = auditopinion;
        this.isfinished = isfinished;
        this.des = des;
    }

    public DistrictRes() {
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
     * 获取编码
     *
     * @return ResCode - 编码
     */
    public String getRescode() {
        return rescode;
    }

    /**
     * 设置编码
     *
     * @param rescode
     *            编码
     */
    public void setRescode(String rescode) {
        this.rescode = rescode == null ? null : rescode.trim();
    }

    /**
     * 获取资源提供商
     *
     * @return Provider - 资源提供商
     */
    public String getProvider() {
        return provider;
    }

    /**
     * 设置资源提供商
     *
     * @param provider
     *            资源提供商
     */
    public void setProvider(String provider) {
        this.provider = provider == null ? null : provider.trim();
    }

    /**
     * 获取资源标题
     *
     * @return Title - 资源标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置资源标题
     *
     * @param title
     *            资源标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取关键字
     *
     * @return keyWord - 关键字
     */
    public String getKeyword() {
        return keyword;
    }

    /**
     * 设置关键字
     *
     * @param keyword
     *            关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword == null ? null : keyword.trim();
    }

    /**
     * 获取资源路径
     *
     * @return FPath - 资源路径
     */
    public String getFpath() {
        return fpath;
    }

    /**
     * 设置资源路径
     *
     * @param fpath
     *            资源路径
     */
    public void setFpath(String fpath) {
        this.fpath = fpath == null ? null : fpath.trim();
    }

    /**
     * 获取文件名
     *
     * @return Fname - 文件名
     */
    public String getFname() {
        return fname;
    }

    /**
     * 设置文件名
     *
     * @param fname
     *            文件名
     */
    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    /**
     * 获取创建者
     *
     * @return CreatorId - 创建者
     */
    public Long getCreatorid() {
        return creatorid;
    }

    /**
     * 设置创建者
     *
     * @param creatorid
     *            创建者
     */
    public void setCreatorid(Long creatorid) {
        this.creatorid = creatorid;
    }

    /**
     * 获取作者
     *
     * @return AuthorId - 作者
     */
    public Long getAuthorid() {
        return authorid;
    }

    /**
     * 设置作者
     *
     * @param authorid
     *            作者
     */
    public void setAuthorid(Long authorid) {
        this.authorid = authorid;
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
     * 获取源资大小
     *
     * @return FSize - 源资大小
     */
    public String getFsize() {
        return fsize;
    }

    /**
     * 设置源资大小
     *
     * @param fsize
     *            源资大小
     */
    public void setFsize(String fsize) {
        this.fsize = fsize == null ? null : fsize.trim();
    }

    /**
     * 获取上传的资源，A----学案；B----测试；C--作业；D---教案；E-----课件
     *
     * @return TypeLean - 上传的资源，A----学案；B----测试；C--作业；D---教案；E-----课件
     */
    public String getTypelean() {
        return typelean;
    }

    /**
     * 设置上传的资源，A----学案；B----测试；C--作业；D---教案；E-----课件
     *
     * @param typelean
     *            上传的资源，A----学案；B----测试；C--作业；D---教案；E-----课件
     */
    public void setTypelean(String typelean) {
        this.typelean = typelean == null ? "A" : typelean.trim();
    }

    /**
     * 获取是否网络资源(1-网络资源,0-本地资源)
     *
     * @return IsLocal - 是否网络资源(1-网络资源,0-本地资源)
     */
    public Integer getIslocal() {
        return islocal;
    }

    /**
     * 设置是否网络资源(1-网络资源,0-本地资源)
     *
     * @param islocal
     *            是否网络资源(1-网络资源,0-本地资源)
     */
    public void setIslocal(Integer islocal) {
        this.islocal = islocal;
    }

    /**
     * 获取编辑者
     *
     * @return EditorId - 编辑者
     */
    public Long getEditorid() {
        return editorid;
    }

    /**
     * 设置编辑者
     *
     * @param editorid
     *            编辑者
     */
    public void setEditorid(Long editorid) {
        this.editorid = editorid ==null?this.authorid:editorid;
    }

    /**
     * 获取缩略图名称
     *
     * @return ThumbnailName - 缩略图名称
     */
    public String getThumbnailname() {
        return thumbnailname;
    }

    /**
     * 设置缩略图名称
     *
     * @param thumbnailname
     *            缩略图名称
     */
    public void setThumbnailname(String thumbnailname) {
        this.thumbnailname = thumbnailname == null ? null : thumbnailname.trim();
    }

    /**
     * 获取缩略图描述
     *
     * @return ThumbnailNote - 缩略图描述
     */
    public String getThumbnailnote() {
        return thumbnailnote;
    }

    /**
     * 设置缩略图描述
     *
     * @param thumbnailnote
     *            缩略图描述
     */
    public void setThumbnailnote(String thumbnailnote) {
        this.thumbnailnote = thumbnailnote == null ? null : thumbnailnote.trim();
    }

    /**
     * 获取缩略图路径
     *
     * @return ThumbnailPath - 缩略图路径
     */
    public String getThumbnailpath() {
        return thumbnailpath;
    }

    /**
     * 设置缩略图路径
     *
     * @param thumbnailpath
     *            缩略图路径
     */
    public void setThumbnailpath(String thumbnailpath) {
        this.thumbnailpath = thumbnailpath == null ? null : thumbnailpath.trim();
    }

    /**
     * 获取教学场所，比如是：A,多媒体教室、B,礼堂、C,教室
     *
     * @return EduPlace - 教学场所，比如是：A,多媒体教室、B,礼堂、C,教室
     */
    public String getEduplace() {
        return eduplace;
    }

    /**
     * 设置教学场所，比如是：A,多媒体教室、B,礼堂、C,教室
     *
     * @param eduplace
     *            教学场所，比如是：A,多媒体教室、B,礼堂、C,教室
     */
    public void setEduplace(String eduplace) {
        this.eduplace = eduplace == null ? null : eduplace.trim();
    }

    /**
     * 获取适合的学段
     *
     * @return SuitTerm - 适合的学段
     */
    public String getSuitterm() {
        return suitterm;
    }

    /**
     * 设置适合的学段
     *
     * @param suitterm
     *            适合的学段
     */
    public void setSuitterm(String suitterm) {
        this.suitterm = suitterm == null ? null : suitterm.trim();
    }

    /**
     * 获取版权
     *
     * @return Copyright - 版权
     */
    public String getCopyright() {
        return copyright;
    }

    /**
     * 设置版权
     *
     * @param copyright
     *            版权
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
     * 获取自建资源来源id
     *
     * @return assetId - 自建资源来源id
     */
    public Long getAssetid() {
        return assetid;
    }

    /**
     * 设置自建资源来源id
     *
     * @param assetid
     *            自建资源来源id
     */
    public void setAssetid(Long assetid) {
        this.assetid = assetid;
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
     * 获取备注
     *
     * @return Rdes - 备注
     */
    public String getRdes() {
        return rdes;
    }

    /**
     * 设置备注
     *
     * @param rdes
     *            备注
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
     * 获取资源来源 3校本资源 4 区本资源
     *
     * @return fromFlag - 资源来源 3校本资源 4 区本资源
     */
    public Integer getFromflag() {
        return fromflag;
    }

    /**
     * 设置资源来源 3校本资源 4 区本资源
     *
     * @param fromflag
     *            资源来源 3校本资源 4 区本资源
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
     * 获取作者单位
     *
     * @return authorunit - 作者单位
     */
    public String getAuthorunit() {
        return authorunit;
    }

    /**
     * 设置作者单位
     *
     * @param authorunit
     *            作者单位
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
     * 获取主讲人
     *
     * @return speaker - 主讲人
     */
    public String getSpeaker() {
        return speaker;
    }

    /**
     * 设置主讲人
     *
     * @param speaker
     *            主讲人
     */
    public void setSpeaker(String speaker) {
        this.speaker = speaker == null ? null : speaker.trim();
    }

    /**
     * 获取主讲人单位
     *
     * @return speakerUnit - 主讲人单位
     */
    public String getSpeakerunit() {
        return speakerunit;
    }

    /**
     * 设置主讲人单位
     *
     * @param speakerunit
     *            主讲人单位
     */
    public void setSpeakerunit(String speakerunit) {
        this.speakerunit = speakerunit == null ? null : speakerunit.trim();
    }

    /**
     * 获取视频清晰度 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     *
     * @return Resolution - 视频清晰度 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    public Integer getResolution() {
        return resolution;
    }

    /**
     * 设置视频清晰度 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     *
     * @param resolution
     *            视频清晰度 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    public void setResolution(Integer resolution) {
        this.resolution = resolution;
    }

    /**
     * 获取0-管理员自己上传，1-共享资源 2-投稿资源
     *
     * @return AuthorFromFlag - 0-管理员自己上传，1-共享资源 2-投稿资源
     */
    public Integer getAuthorfromflag() {
        return authorfromflag;
    }

    /**
     * 设置0-管理员自己上传，1-共享资源 2-投稿资源
     *
     * @param authorfromflag
     *            0-管理员自己上传，1-共享资源 2-投稿资源
     */
    public void setAuthorfromflag(Integer authorfromflag) {
        this.authorfromflag = authorfromflag;
    }

    /**
     * 获取资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
     *
     * @return Scope - 资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
     */
    public Integer getScope() {
        return scope;
    }

    /**
     * 设置资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
     *
     * @param scope
     *            资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
     */
    public void setScope(Integer scope) {
        this.scope = scope;
    }

    /**
     * 获取范围Id
     *
     * @return ScopeId - 范围Id
     */
    public Long getScopeid() {
        return scopeid;
    }

    /**
     * 设置范围Id
     *
     * @param scopeid
     *            范围Id
     */
    public void setScopeid(Long scopeid) {
        this.scopeid = scopeid;
    }

    /**
     * 获取资源状态 1 教师未答复 2 教师拒绝 3教师同意 4 待审核 5 审核失败 6 审核成功 7 存疑
     *
     * @return State - 资源状态 1 教师未答复 2 教师拒绝 3教师同意 4 待审核 5 审核失败 6 审核成功 7 存疑
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置资源状态 1 教师未答复 2 教师拒绝 3教师同意 4 待审核 5 审核失败 6 审核成功 7 存疑
     *
     * @param state
     *            资源状态 1 教师未答复 2 教师拒绝 3教师同意 4 待审核 5 审核失败 6 审核成功 7 存疑
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取审核意见
     *
     * @return AuditOpinion - 审核意见
     */
    public String getAuditopinion() {
        return auditopinion;
    }

    /**
     * 设置审核意见
     *
     * @param auditopinion
     *            审核意见
     */
    public void setAuditopinion(String auditopinion) {
        this.auditopinion = auditopinion == null ? null : auditopinion.trim();
    }

    /**
     * @return isFinished
     */
    public Integer getIsfinished() {
        return isfinished;
    }

    /**
     * @param isfinished
     */
    public void setIsfinished(Integer isfinished) {
        this.isfinished = isfinished;
    }

   
    /**
     * 获取资源描述
     *
     * @return Des - 资源描述
     */
    public String getDes() {
        return des;
    }

    /**
     * 设置资源描述
     *
     * @param des
     *            资源描述
     */
    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }
}

