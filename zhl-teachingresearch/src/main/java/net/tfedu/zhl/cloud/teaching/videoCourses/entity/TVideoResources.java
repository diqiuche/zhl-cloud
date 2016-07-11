package net.tfedu.zhl.cloud.teaching.videoCourses.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_videoresources")
public class TVideoResources implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 视频课程标题
     */
    private String title;

    /**
     * 视频时长
     */
    private Double playtime;

    /**
     * 主讲人单位 + 姓名
     */
    private String speakerinfo;

    /**
     * 浏览次数
     */
    private Integer clicktimes;

   
    /**
     * 分类id
     */
    @Column(name = "typeId")
    private Integer typeid;

    /**
     * 学科id
     */
    @Column(name = "subjectId")
    private Integer subjectid;

    /**
     * 文件名
     */
    private String fname;


    /**
     * 文件缩略图路径
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

    /**
     * 视频课程简介
     */
    private String description;
    
    /**
     * 资源平均分
     */
    private int avgScore;
    
    /**
     * 用户是否观看过
     */
    private boolean hasVisited;
    
    /**
     * 评论次数
     */
    private int commentTimes;
    
    /**
     * 所属平台：0 双课堂 1 新资源中心
     */
    private int fromflag;

    
    public int getCommentTimes() {
		return commentTimes;
	}

	public void setCommentTimes(int commentTimes) {
		this.commentTimes = commentTimes;
	}

	public int getAvgScore() {
		return avgScore;
	}

	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}

	public boolean isHasVisited() {
		return hasVisited;
	}

	public void setHasVisited(boolean hasVisited) {
		this.hasVisited = hasVisited;
	}

	public TVideoResources(Long id, String title, Double playtime, String speakerinfo, Integer clicktimes, int fromflag, Integer typeid, Integer subjectid, String fname, String fpath, String thumbnailpath, Long creator, Date createdate, Date updatedate, Boolean flag, String description,int avgScore,boolean hasVisited,int commentTimes) {
        this.id = id;
        this.title = title;
        this.playtime = playtime;
        this.speakerinfo = speakerinfo;
        this.clicktimes = clicktimes;
        this.fromflag = fromflag;
        this.typeid = typeid;
        this.subjectid = subjectid;
        this.fname = fname;
        this.thumbnailpath = thumbnailpath;
        this.creator = creator;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.flag = flag;
        this.description = description;
        this.avgScore = avgScore;
        this.hasVisited = hasVisited;
        this.commentTimes = commentTimes;
    }

    public TVideoResources() {
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
     * 获取视频课程标题
     *
     * @return title - 视频课程标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置视频课程标题
     *
     * @param title 视频课程标题
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 获取视频时长
     *
     * @return playtime - 视频时长
     */
    public Double getPlaytime() {
        return playtime;
    }

    /**
     * 设置视频时长
     *
     * @param playtime 视频时长
     */
    public void setPlaytime(Double playtime) {
        this.playtime = playtime;
    }

    /**
     * 获取主讲人单位 + 姓名
     *
     * @return speakerinfo - 主讲人单位 + 姓名
     */
    public String getSpeakerinfo() {
        return speakerinfo;
    }

    /**
     * 设置主讲人单位 + 姓名
     *
     * @param speakerinfo 主讲人单位 + 姓名
     */
    public void setSpeakerinfo(String speakerinfo) {
        this.speakerinfo = speakerinfo == null ? null : speakerinfo.trim();
    }

    /**
     * 获取浏览次数
     *
     * @return clicktimes - 浏览次数
     */
    public Integer getClicktimes() {
        return clicktimes;
    }

    /**
     * 设置浏览次数
     *
     * @param clicktimes 浏览次数
     */
    public void setClicktimes(Integer clicktimes) {
        this.clicktimes = clicktimes;
    }

    /**
     * 获取所属平台：0 双课堂 1 新资源中心
     *
     * @return fromflag - 所属平台：0 双课堂 1 新资源中心
     */
    public int getFromflag() {
        return fromflag;
    }

    /**
     * 设置所属平台：0 双课堂 1 新资源中心
     *
     * @param fromflag 所属平台：0 双课堂 1 新资源中心
     */
    public void setFromflag(int fromflag) {
        this.fromflag = fromflag;
    }

    /**
     * 获取分类id
     *
     * @return typeId - 分类id
     */
    public Integer getTypeid() {
        return typeid;
    }

    /**
     * 设置分类id
     *
     * @param typeid 分类id
     */
    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
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
     * 获取文件名
     *
     * @return fname - 文件名
     */
    public String getFname() {
        return fname;
    }

    /**
     * 设置文件名
     *
     * @param fname 文件名
     */
    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    /**
     * 获取文件缩略图路径
     *
     * @return thumbnailpath - 文件缩略图路径
     */
    public String getThumbnailpath() {
        return thumbnailpath;
    }

    /**
     * 设置文件缩略图路径
     *
     * @param thumbnailpath 文件缩略图路径
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

    /**
     * 获取视频课程简介
     *
     * @return description - 视频课程简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置视频课程简介
     *
     * @param description 视频课程简介
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}