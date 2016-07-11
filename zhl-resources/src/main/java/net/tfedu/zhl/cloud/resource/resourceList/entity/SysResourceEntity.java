package net.tfedu.zhl.cloud.resource.resourceList.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统资源查询结果的一条记录实体类
 * 
 * @author WeiCuicui
 *
 */

public class SysResourceEntity implements Serializable {
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
     * 盘符序号
     */
    private int diskorder;

    /**
     * 搜索结果的素材显示顺序，增序，数小的排在前面
     */
    private Integer Displayindex;

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
     * 文件缩略图地址
     */
    private String thumbnailpath;
    
    /**
     * 全路径
     */
    private String fullpath;


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

	/**
     * 资源来源
     */
    private int fromFlag;

    public int getFromFlag() {
        return fromFlag;
    }

    public void setFromFlag(int fromFlag) {
        this.fromFlag = fromFlag;
    }

    public boolean isNew() {
        return isNew;
    }

    public void setNew(boolean isNew) {
        this.isNew = isNew;
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

    public int getDiskorder() {
        return diskorder;
    }

    public void setDiskorder(int diskorder) {
        this.diskorder = diskorder;
    }

    public Integer getDisplayindex() {
        return Displayindex;
    }

    public void setDisplayindex(Integer displayindex) {
        Displayindex = displayindex;
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

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "sysResEntity[id=" + Id + " fpath=" + Fpath + " fname= " + Fname + " fileExt=" + FileExt + " fzise = "
                + FSize + "]";
    }

}
