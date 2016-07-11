package net.tfedu.zhl.cloud.resource.userlog.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

/**
 * 资源浏览记录
 * 
 * @author wangwr
 * 
 */
public class ResourceViewLog implements Serializable {

	/**
	 * 评论id
	 */
	@Id
	private Long id;

	private Long resId;

	private String resCode;

	private String title;

	/**
	 * fromflag输出
	 */
	private Integer fromFlag;

	/**
	 * 浏览时间
	 */
	private Date time;

	private String imgPath;

	private String fileSuffix;

	private String unifyType;

	public ResourceViewLog(Long id, String title, Long resId, Integer fromFlag,
			Date time, String imgPath, String fileSuffix, String resCode,
			String unifyType) {
		this.id = id;
		this.title = title;
		this.resId = resId;
		this.fromFlag = fromFlag;
		this.time = time;
		this.imgPath = imgPath;
		this.fileSuffix = fileSuffix;
		this.resCode = resCode;
		this.unifyType = unifyType;
	}

	public ResourceViewLog() {
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
	 * @return title
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
	 * @return time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time
	 */
	public void setTime(Date time) {
		this.time = time;
	}

	public Long getResId() {
		return resId;
	}

	public void setResId(Long resId) {
		this.resId = resId;
	}

	public Integer getFromFlag() {
		return fromFlag;
	}

	public void setFromFlag(Integer fromFlag) {
		this.fromFlag = fromFlag;
	}

	public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getFileSuffix() {
		return fileSuffix;
	}

	public void setFileSuffix(String fileSuffix) {
		this.fileSuffix = fileSuffix;
	}

	public String getUnifyType() {
		return unifyType;
	}

	public void setUnifyType(String unifyType) {
		this.unifyType = unifyType;
	}

	@Override
	public String toString() {
		return "[ResourceViewLog:{id:" + id + ";title:" + title + ";resId:"
				+ resId + ";fromFlag:" + fromFlag + ";imgPath:" + imgPath
				+ ";fileSuffix:" + fileSuffix + ";unifyType:" + unifyType
				+ "}]";
	}

}
