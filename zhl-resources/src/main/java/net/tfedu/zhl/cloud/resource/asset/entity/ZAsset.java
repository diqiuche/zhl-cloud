package net.tfedu.zhl.cloud.resource.asset.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "z_asset")
public class ZAsset {
    /**
     * 自建id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 自建资源编码，是唯一标识（也可当做系统资源的外键）
     */
    @Column(name = "ResourceId")
    private String resourceid;

    /**
     * 自建资源类型 (resourceType)（素材，还是教案，课件，学案等）
     */
    @Column(name = "TypeId")
    private Long typeid;

    /**
     * 资源创建者
     */
    @Column(name = "UserId")
    private Long userid;

    /**
     * 创建日期
     */
    @Column(name = "CreateTime")
    private Date createtime;

    /**
     * 修改时间
     */
    @Column(name = "UpdateTime")
    private Date updatetime;

    /**
     * A：资源；B：教案；C：学案；D：课件；E：作业
     */
    @Column(name = "FileType")
    private String filetype;

    /**
     * 是否发布，0---否；1---是
     */
    @Column(name = "IsIssue")
    private Boolean isissue;

    /**
     * 习学提示
     */
    @Column(name = "Notes")
    private String notes;

    /**
     * 音频
     */
    @Column(name = "Name")
    private String name;

    @Column(name = "AssetPath")
    private String assetpath;

    /**
     * 自建资源描述
     */
    @Column(name = "AssetDesc")
    private String assetdesc;

    /**
     * 关键字
     */
    @Column(name = "keyWord")
    private String keyword;

    @Column(name = "FileName")
    private String filename;

    /**
     * 文件路径
     */
    @Column(name = "FilePath")
    private String filepath;

    /**
     * 是否是系统资源，资源路径加以区分；0：系统资源；1：用户上传资源
     */
    @Column(name = "IsSysRes")
    private Boolean issysres;

    /**
     * 附件
     */
    @Column(name = "Attachement")
    private String attachement;

    @Column(name = "AttachPath")
    private String attachpath;

    /**
     * 自建资源的大小
     */
    @Column(name = "AssetSize")
    private String assetsize;

    /**
     * 审核通过时间
     */
    @Column(name = "CheckTime")
    private Date checktime;

    /**
     * 审核人
     */
    @Column(name = "CheckMan")
    private String checkman;

    /**
     * 审核标识，0---未通过；1---通过
     */
    @Column(name = "CheckFlag")
    private Boolean checkflag;

    /**
     * 学生端显示答案的时机，0--测试已提交；1----测试已批阅
     */
    @Column(name = "StuState")
    private Boolean stustate;

    /**
     * 是否删除标识，0------否；1---是
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 文件格式
     */
    @Column(name = "FileCode")
    private String filecode;

    /**
     * 是否为文件包，0---不 是；1---是）
     */
    @Column(name = "IsWjb")
    private Boolean iswjb;

    /**
     * 主文件名
     */
    @Column(name = "WjbName")
    private String wjbname;

    /**
     * 是否是本地资源 0为本地资源1为网络资源
     */
    @Column(name = "IsLocal")
    private Integer islocal;

    /**
     * 是否是课件，默认为0 否 1是
     */
    private Boolean iscourseware;

    /**
     * 文件转码，0：转码完成，1：未完成
     */
    @Column(name = "IsFinished")
    private Integer isfinished;

    /**
     * v3.1新版资源中心类型
     */
    @Column(name = "unifyTypeId")
    private Integer unifytypeid;
    


    /**
     * 上传资源的文档内容
     */
    @Column(name = "Content")
    private String content;

    public ZAsset(Long id, String resourceid, Long typeid, Long userid, Date createtime, Date updatetime,
            String filetype, Boolean isissue, String notes, String name, String assetpath, String assetdesc,
            String keyword, String filename, String filepath, Boolean issysres, String attachement, String attachpath,
            String assetsize, Date checktime, String checkman, Boolean checkflag, Boolean stustate, Boolean flag,
            String filecode, Boolean iswjb, String wjbname, Integer islocal, Boolean iscourseware, Integer isfinished,
            Integer unifytypeid, String content) {
        this.id = id;
        this.resourceid = resourceid;
        this.typeid = typeid;
        this.userid = userid;
        this.createtime = createtime;
        this.updatetime = updatetime;
        this.filetype = filetype;
        this.isissue = isissue;
        this.notes = notes;
        this.name = name;
        this.assetpath = assetpath;
        this.assetdesc = assetdesc;
        this.keyword = keyword;
        this.filename = filename;
        this.filepath = filepath;
        this.issysres = issysres;
        this.attachement = attachement;
        this.attachpath = attachpath;
        this.assetsize = assetsize;
        this.checktime = checktime;
        this.checkman = checkman;
        this.checkflag = checkflag;
        this.stustate = stustate;
        this.flag = flag;
        this.filecode = filecode;
        this.iswjb = iswjb;
        this.wjbname = wjbname;
        this.islocal = islocal;
        this.iscourseware = iscourseware;
        this.isfinished = isfinished;
        this.unifytypeid = unifytypeid;
        this.content = content;
    }

    public ZAsset() {
        super();
    }

    /**
     * 获取自建id
     *
     * @return Id - 自建id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自建id
     *
     * @param id
     *            自建id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取自建资源编码，是唯一标识（也可当做系统资源的外键）
     *
     * @return ResourceId - 自建资源编码，是唯一标识（也可当做系统资源的外键）
     */
    public String getResourceid() {
        return resourceid;
    }

    /**
     * 设置自建资源编码，是唯一标识（也可当做系统资源的外键）
     *
     * @param resourceid
     *            自建资源编码，是唯一标识（也可当做系统资源的外键）
     */
    public void setResourceid(String resourceid) {
        this.resourceid = resourceid == null ? null : resourceid.trim();
    }

    /**
     * 获取自建资源类型 (resourceType)（素材，还是教案，课件，学案等）
     *
     * @return TypeId - 自建资源类型 (resourceType)（素材，还是教案，课件，学案等）
     */
    public Long getTypeid() {
        return typeid;
    }

    /**
     * 设置自建资源类型 (resourceType)（素材，还是教案，课件，学案等）
     *
     * @param typeid
     *            自建资源类型 (resourceType)（素材，还是教案，课件，学案等）
     */
    public void setTypeid(Long typeid) {
        this.typeid = typeid;
    }

    /**
     * 获取资源创建者
     *
     * @return UserId - 资源创建者
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置资源创建者
     *
     * @param userid
     *            资源创建者
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取创建日期
     *
     * @return CreateTime - 创建日期
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置创建日期
     *
     * @param createtime
     *            创建日期
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取修改时间
     *
     * @return UpdateTime - 修改时间
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * 设置修改时间
     *
     * @param updatetime
     *            修改时间
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    /**
     * 获取A：资源；B：教案；C：学案；D：课件；E：作业
     *
     * @return FileType - A：资源；B：教案；C：学案；D：课件；E：作业
     */
    public String getFiletype() {
        return filetype;
    }

    /**
     * 设置A：资源；B：教案；C：学案；D：课件；E：作业
     *
     * @param filetype
     *            A：资源；B：教案；C：学案；D：课件；E：作业
     */
    public void setFiletype(String filetype) {
        this.filetype = filetype == null ? null : filetype.trim();
    }

    /**
     * 获取是否发布，0---否；1---是
     *
     * @return IsIssue - 是否发布，0---否；1---是
     */
    public Boolean getIsissue() {
        return isissue==null?false:true;
    }

    /**
     * 设置是否发布，0---否；1---是
     *
     * @param isissue
     *            是否发布，0---否；1---是
     */
    public void setIsissue(Boolean isissue) {
        this.isissue = isissue;
    }

    /**
     * 获取习学提示
     *
     * @return Notes - 习学提示
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置习学提示
     *
     * @param notes
     *            习学提示
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * 获取音频
     *
     * @return Name - 音频
     */
    public String getName() {
        return name== null ? null : name.trim();
    }

    /**
     * 设置音频
     *
     * @param name
     *            音频
     */
    public void setName(String name) {
        this.name = name ;
    }

    /**
     * @return AssetPath
     */
    public String getAssetpath() {
        return assetpath == null ? null : assetpath.trim();
    }

    /**
     * @param assetpath
     */
    public void setAssetpath(String assetpath) {
        this.assetpath = assetpath ;
    }

    /**
     * 获取自建资源描述
     *
     * @return AssetDesc - 自建资源描述
     */
    public String getAssetdesc() {
        return assetdesc == null ? null : assetdesc.trim();
    }

    /**
     * 设置自建资源描述
     *
     * @param assetdesc
     *            自建资源描述
     */
    public void setAssetdesc(String assetdesc) {
        this.assetdesc = assetdesc;
    }

    /**
     * 获取关键字
     *
     * @return keyWord - 关键字
     */
    public String getKeyword() {
        return keyword== null ? null : keyword.trim();
    }

    /**
     * 设置关键字
     *
     * @param keyword
     *            关键字
     */
    public void setKeyword(String keyword) {
        this.keyword = keyword ;
    }

    /**
     * @return FileName
     */
    public String getFilename() {
        return filename== null ? null : filename.trim();
    }

    /**
     * @param filename
     */
    public void setFilename(String filename) {
        this.filename = filename ;
    }

    /**
     * 获取文件路径
     *
     * @return FilePath - 文件路径
     */
    public String getFilepath() {
        return filepath== null ? null : filepath.trim();
    }

    /**
     * 设置文件路径
     *
     * @param filepath
     *            文件路径
     */
    public void setFilepath(String filepath) {
        this.filepath = filepath ;
    }

    /**
     * 获取是否是系统资源，资源路径加以区分；0：系统资源；1：用户上传资源
     *
     * @return IsSysRes - 是否是系统资源，资源路径加以区分；0：系统资源；1：用户上传资源
     */
    public Boolean getIssysres() {
        return issysres ==null?false:true;
    }

    /**
     * 设置是否是系统资源，资源路径加以区分；0：系统资源；1：用户上传资源
     *
     * @param issysres
     *            是否是系统资源，资源路径加以区分；0：系统资源；1：用户上传资源
     */
    public void setIssysres(Boolean issysres) {
        this.issysres = issysres;
    }

    /**
     * 获取附件
     *
     * @return Attachement - 附件
     */
    public String getAttachement() {
        return attachement == null?"":attachement.trim();
    }

    /**
     * 设置附件
     *
     * @param attachement
     *            附件
     */
    public void setAttachement(String attachement) {
        this.attachement = attachement;
    }

    /**
     * @return AttachPath
     */
    public String getAttachpath() {
        return attachpath== null ? "" : attachpath.trim();
    }

    /**
     * @param attachpath
     */
    public void setAttachpath(String attachpath) {
        this.attachpath = attachpath ;
    }

    /**
     * 获取自建资源的大小
     *
     * @return AssetSize - 自建资源的大小
     */
    public String getAssetsize() {
        return assetsize == null ? "" : assetsize.trim();
    }

    /**
     * 设置自建资源的大小
     *
     * @param assetsize
     *            自建资源的大小
     */
    public void setAssetsize(String assetsize) {
        this.assetsize = assetsize ;
    }

    /**
     * 获取审核通过时间
     *
     * @return CheckTime - 审核通过时间
     */
    public Date getChecktime() {
        return checktime;
    }

    /**
     * 设置审核通过时间
     *
     * @param checktime
     *            审核通过时间
     */
    public void setChecktime(Date checktime) {
        this.checktime = checktime;
    }

    /**
     * 获取审核人
     *
     * @return CheckMan - 审核人
     */
    public String getCheckman() {
        return checkman  == null ? "" : checkman.trim();
    }

    /**
     * 设置审核人
     *
     * @param checkman
     *            审核人
     */
    public void setCheckman(String checkman) {
        this.checkman = checkman;
    }

    /**
     * 获取审核标识，0---未通过；1---通过
     *
     * @return CheckFlag - 审核标识，0---未通过；1---通过
     */
    public Boolean getCheckflag() {
        return checkflag == null?false:true;
    }

    /**
     * 设置审核标识，0---未通过；1---通过
     *
     * @param checkflag
     *            审核标识，0---未通过；1---通过
     */
    public void setCheckflag(Boolean checkflag) {
        this.checkflag = checkflag;
    }

    /**
     * 获取学生端显示答案的时机，0--测试已提交；1----测试已批阅
     *
     * @return StuState - 学生端显示答案的时机，0--测试已提交；1----测试已批阅
     */
    public Boolean getStustate() {
        return stustate ==null?false:true;
    }

    /**
     * 设置学生端显示答案的时机，0--测试已提交；1----测试已批阅
     *
     * @param stustate
     *            学生端显示答案的时机，0--测试已提交；1----测试已批阅
     */
    public void setStustate(Boolean stustate) {
        this.stustate = stustate;
    }

    /**
     * 获取是否删除标识，0------否；1---是
     *
     * @return Flag - 是否删除标识，0------否；1---是
     */
    public Boolean getFlag() {
        return flag==null?false:true;
    }

    /**
     * 设置是否删除标识，0------否；1---是
     *
     * @param flag
     *            是否删除标识，0------否；1---是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取文件格式
     *
     * @return FileCode - 文件格式
     */
    public String getFilecode() {
        return filecode == null?"":filecode.trim();
    }

    /**
     * 设置文件格式
     *
     * @param filecode
     *            文件格式
     */
    public void setFilecode(String filecode) {
        this.filecode = filecode;
    }

    /**
     * 获取是否为文件包，0---不 是；1---是）
     *
     * @return IsWjb - 是否为文件包，0---不 是；1---是）
     */
    public Boolean getIswjb() {
        return iswjb == null ?false:true;
    }

    /**
     * 设置是否为文件包，0---不 是；1---是）
     *
     * @param iswjb
     *            是否为文件包，0---不 是；1---是）
     */
    public void setIswjb(Boolean iswjb) {
        this.iswjb = iswjb;
    }

    /**
     * 获取主文件名
     *
     * @return WjbName - 主文件名
     */
    public String getWjbname() {
        return wjbname== null ? "" : wjbname.trim();
    }

    /**
     * 设置主文件名
     *
     * @param wjbname
     *            主文件名
     */
    public void setWjbname(String wjbname) {
        this.wjbname = wjbname== null ? "" : wjbname.trim() ;
    }

    /**
     * 获取是否是本地资源 0为本地资源1为网络资源
     *
     * @return IsLocal - 是否是本地资源 0为本地资源1为网络资源
     */
    public Integer getIslocal() {
        return islocal;
    }

    /**
     * 设置是否是本地资源 0为本地资源1为网络资源
     *
     * @param islocal
     *            是否是本地资源 0为本地资源1为网络资源
     */
    public void setIslocal(Integer islocal) {
        this.islocal = islocal;
    }

    /**
     * 获取是否是课件，默认为0 否 1是
     *
     * @return iscourseware - 是否是课件，默认为0 否 1是
     */
    public Boolean getIscourseware() {
        return iscourseware;
    }

    /**
     * 设置是否是课件，默认为0 否 1是
     *
     * @param iscourseware
     *            是否是课件，默认为0 否 1是
     */
    public void setIscourseware(Boolean iscourseware) {
        this.iscourseware = iscourseware;
    }

    /**
     * 获取文件转码，0：转码完成，1：未完成
     *
     * @return IsFinished - 文件转码，0：转码完成，1：未完成
     */
    public Integer getIsfinished() {
        return isfinished;
    }

    /**
     * 设置文件转码，0：转码完成，1：未完成
     *
     * @param isfinished
     *            文件转码，0：转码完成，1：未完成
     */
    public void setIsfinished(Integer isfinished) {
        this.isfinished = isfinished;
    }

    /**
     * 获取v3.1新版资源中心类型
     *
     * @return unifyTypeId - v3.1新版资源中心类型
     */
    public Integer getUnifytypeid() {
        return unifytypeid;
    }

    /**
     * 设置v3.1新版资源中心类型
     *
     * @param unifytypeid
     *            v3.1新版资源中心类型
     */
    public void setUnifytypeid(Integer unifytypeid) {
        this.unifytypeid = unifytypeid == null ? null : unifytypeid.intValue();
    }

    /**
     * 获取上传资源的文档内容
     *
     * @return Content - 上传资源的文档内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置上传资源的文档内容
     *
     * @param content
     *            上传资源的文档内容
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

}