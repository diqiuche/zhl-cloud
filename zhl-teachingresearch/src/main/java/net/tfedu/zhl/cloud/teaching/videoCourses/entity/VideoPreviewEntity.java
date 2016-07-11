package net.tfedu.zhl.cloud.teaching.videoCourses.entity;

import java.io.Serializable;

/**
 * 一条视频课程的预览信息
 * @author WeiCuicui
 *
 */
public class VideoPreviewEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private long id;
	/**
	 * 视频课程标题
	 */
	private String title;
	
	/**
	 * 当前用户对该视频的评分
	 */
	private int score;
	
	/**
	 * 视频文件名称
	 */
	private String fname;
	
	/**
	 * 视频课程缩略图路径
	 */
	private String thumbnailpath;
	
	public String getThumbnailpath() {
		return thumbnailpath;
	}
	public void setThumbnailpath(String thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	
}
