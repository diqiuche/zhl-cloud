package net.tfedu.zhl.cloud.resource.resPreview.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * 资源预览页面的资源推荐列表信息
 * @author WeiCuicui
 *
 */
public class ResRecommendationEntity implements Serializable{

	private static final long serialVersionUID = 8160030266758656476L;
	
	 /**
     * 资源id
     */
    private Long id;

    /**
     * 资源标题
     */
    private String Title;
    
    /**
     * 资源来源
     */
    private int fromFlag;
    
    /**
     * 全路径
     */
    private String fullPath;
    
    
    /**
     * 文件缩略图地址
     */
    private String thumbnailpath;
    
    /**
     * 更新日期
     */
    private Date UpdateDT;
    
    /**
     * 下载次数
     */
    private Integer DLoadTimes;
    
    /**
     * 评论的平均分
     */
    private int avgScore;
    
    public Date getUpdateDT() {
		return UpdateDT;
	}


	public void setUpdateDT(Date updateDT) {
		UpdateDT = updateDT;
	}


	public Integer getDLoadTimes() {
		return DLoadTimes;
	}


	public void setDLoadTimes(Integer dLoadTimes) {
		DLoadTimes = dLoadTimes;
	}


	public int getAvgScore() {
		return avgScore;
	}


	public void setAvgScore(int avgScore) {
		this.avgScore = avgScore;
	}


	/**
     * 文件扩展名
     */
    private String FileExt;


	public String getFileExt() {
		return FileExt;
	}


	public void setFileExt(String fileExt) {
		FileExt = fileExt;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return Title;
	}


	public void setTitle(String title) {
		Title = title;
	}


	public int getFromFlag() {
		return fromFlag;
	}


	public void setFromFlag(int fromFlag) {
		this.fromFlag = fromFlag;
	}


	public String getFullPath() {
		return fullPath;
	}


	public void setFullPath(String fullPath) {
		this.fullPath = fullPath;
	}


	public String getThumbnailpath() {
		return thumbnailpath;
	}


	public void setThumbnailpath(String thumbnailpath) {
		this.thumbnailpath = thumbnailpath;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
