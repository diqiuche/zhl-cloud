package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 区本校本资源记录实体
 * 
 * @author WeiCuicui
 *
 */
public class DisResourceEntity implements Serializable {
    private static final long serialVersionUID = 8160030266758656476L;
    /**
     * 资源id
     */
    private Long Id;

    /**
     * 资源code
     */
    private String ResCode;

    /**
     * 资源标题
     */
    private String Title;

    /**
     * 文件路径
     */
    private String Fpath;

    /**
     * 文件名
     */
    private String Fname;
    /**
     * 资源类型
     */
    private String MType;
    /**
     * 类型id
     */
    private Integer typeId;
    /**
     * 资源大小
     */
    private String FSize;
    /**
     * 下载次数
     */
    private Integer DLoadTimes;
    /**
     * 浏览次数
     */
    private Integer ClickTimes;
    /**
     * 主讲人
     */
    private String speaker;
    /**
     * 播放时长
     */
    private String res_time;

    /**
     * 文件扩展名
     */
    private String FileExt;

    /**
     * 0:标清；1：高清；2：全高清；3：2k;4:4k;5:8k;
     */
    private Integer resolution;

    /**
     * 是否为多文件
     */
    private Boolean isDWJ;

    /**
     * 资源更新时间
     */
    private Date UpdateDT;

    /**
     * 排序
     */
    private int orderNum;

    /**
     * 评分的平均值
     */
    private int avgScore;

    /**
     * 是否最新资源（资源最后更新时间距离当前时间在一个月之内的）
     */
    private boolean isNew;

    /**
     * 是否为本地资源（0 否；1 是）
     */
    private boolean isLocal;

    /**
     * 资源审核状态 资源状态 1 教师未答复 2 教师拒绝 3教师同意 4 待审核 5 审核失败 6 审核成功 7 存疑
     */
    private int state;

    /**
     * 资源来源 0 系统资源；1 自建资源；2 共享资源；3 校本资源；4 区本资源
     */
    private int fromFlag;

    /**
     * 地区id 或 学校id
     * 
     */
    private int scopeId;
    
    /**
     * 文件缩略图路径
     */
    private String thumbnailpath;
    
    /**
     * 全路径
     */
    private String fullpath;
    
    /**
     * 资源上传者的trueName
     */
    private String author;
    
    /**
     * 0-管理员自己上传，1-共享资源 2-投稿资源
     */
    private Integer authorfromflag;
    
    /**
     * 资源上传者的userId
     */
    private long authorid;
    
	public long getAuthorid() {
		return authorid;
	}

	public void setAuthorid(long authorid) {
		this.authorid = authorid;
	}

	public Integer getAuthorfromflag() {
		return authorfromflag;
	}

	public void setAuthorfromflag(Integer authorfromflag) {
		this.authorfromflag = authorfromflag;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFullpath() {
		return fullpath;
	}

	public void setFullpath(String fullpath) {
		this.fullpath = fullpath;
	}
    
	public String getThumbnailpath() {
		return thumbnailpath;
	}


	public void setThumbnailpath(String thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
	}


    public Long getId() {
        return Id;
    }
	public void setId(Long id) {
        Id = id;
    }

    public String getResCode() {
        return ResCode;
    }

    public void setResCode(String resCode) {
        ResCode = resCode;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getFpath() {
        return Fpath;
    }

    public void setFpath(String fpath) {
        Fpath = fpath;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getMType() {
        return MType;
    }

    public void setMType(String mType) {
        MType = mType;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getFSize() {
        return FSize;
    }

    public void setFSize(String fSize) {
        FSize = fSize;
    }

    public Integer getDLoadTimes() {
        return DLoadTimes;
    }

    public void setDLoadTimes(Integer dLoadTimes) {
        DLoadTimes = dLoadTimes;
    }

    public Integer getClickTimes() {
        return ClickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        ClickTimes = clickTimes;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getRes_time() {
        return res_time;
    }

    public void setRes_time(String res_time) {
        this.res_time = res_time;
    }

    public String getFileExt() {
        return FileExt;
    }

    public void setFileExt(String fileExt) {
        FileExt = fileExt;
    }

    public Integer getResolution() {
        return resolution;
    }

    public void setResolution(Integer resolution) {
        this.resolution = resolution;
    }

    public Boolean getIsDWJ() {
        return isDWJ;
    }

    public void setIsDWJ(Boolean isDWJ) {
        this.isDWJ = isDWJ;
    }

    public Date getUpdateDT() {
        return UpdateDT;
    }

    public void setUpdateDT(Date updateDT) {
        UpdateDT = updateDT;
    }

    public int getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
    }

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean isLocal) {
        this.isLocal = isLocal;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getFromFlag() {
        return fromFlag;
    }

    public void setFromFlag(int fromFlag) {
        this.fromFlag = fromFlag;
    }

    public int getScopeId() {
        return scopeId;
    }

    public void setScopeId(int scopeId) {
        this.scopeId = scopeId;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "sysResEntity[id=" + Id + " fpath=" + Fpath + " fname= " + Fname + " fileExt=" + FileExt + " fzise = "
                + FSize + "]";
    }
}
