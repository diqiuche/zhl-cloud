package net.tfedu.zhl.cloud.teaching.videoCourses.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_videocomments")
public class TVideoComments implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 视频课程id
     */
    @Column(name = "videoId")
    private Long videoid;

    /**
     * 0 评论，1 评分
     */
    @Column(name = "isScore")
    private Boolean isscore;

    /**
     * 评分，默认为0
     */
    private Integer score;

    /**
     * 评论内容，默认为空
     */
    private String content;
    
    /**
     * 评论者的真实姓名
     */
    private String trueName;
    
    /**
     * 评论者所在学校
     */
    private String userSchool;
    
    /**
     * 用户缩略图路径
     */
    private String userImage;
    

    public String getUserImage() {
		return userImage;
	}

	public void setUserImage(String userImage) {
		this.userImage = userImage;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getUserSchool() {
		return userSchool;
	}

	public void setUserSchool(String userSchool) {
		this.userSchool = userSchool;
	}

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

    public TVideoComments(Long id, Long userid, Long videoid, Boolean isscore, Integer score, String content, Date createdate, Date updatedate, Boolean flag) {
        this.id = id;
        this.userid = userid;
        this.videoid = videoid;
        this.isscore = isscore;
        this.score = score;
        this.content = content;
        this.createdate = createdate;
        this.updatedate = updatedate;
        this.flag = flag;
    }

    public TVideoComments() {
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
     * 获取用户id
     *
     * @return userId - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid 用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取视频课程id
     *
     * @return videoId - 视频课程id
     */
    public Long getVideoid() {
        return videoid;
    }

    /**
     * 设置视频课程id
     *
     * @param videoid 视频课程id
     */
    public void setVideoid(Long videoid) {
        this.videoid = videoid;
    }

    /**
     * 获取0 评论，1 评分
     *
     * @return isScore - 0 评论，1 评分
     */
    public Boolean getIsscore() {
        return isscore;
    }

    /**
     * 设置0 评论，1 评分
     *
     * @param isscore 0 评论，1 评分
     */
    public void setIsscore(Boolean isscore) {
        this.isscore = isscore;
    }

    /**
     * 获取评分，默认为0
     *
     * @return score - 评分，默认为0
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 设置评分，默认为0
     *
     * @param score 评分，默认为0
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 获取评论内容，默认为空
     *
     * @return content - 评论内容，默认为空
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置评论内容，默认为空
     *
     * @param content 评论内容，默认为空
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
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