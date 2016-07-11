package net.tfedu.zhl.cloud.teaching.videoCourses.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "t_viewedvideos")
public class TViewedVideos implements Serializable {
	
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
     * 浏览日期
     */
    @Column(name = "CreateDate")
    private Date createdate;

    public TViewedVideos(Long id, Long userid, Long videoid, Date createdate) {
        this.id = id;
        this.userid = userid;
        this.videoid = videoid;
        this.createdate = createdate;
    }

    public TViewedVideos() {
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
     * 获取浏览日期
     *
     * @return CreateDate - 浏览日期
     */
    public Date getCreatedate() {
        return createdate;
    }

    /**
     * 设置浏览日期
     *
     * @param createdate 浏览日期
     */
    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}