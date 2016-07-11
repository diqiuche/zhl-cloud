package net.tfedu.zhl.cloud.resource.prepare.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

/**
 * 前端展示de 备课夹内容（资源）信息
 * 
 * @author wangwr
 * 
 */
public class JPrepareContentView implements Serializable {

    @Id
    private Long id;

    private String title;

    private Long resId;

    private Integer fromFlag;

    private String unifyType;

    private String size;

    private String timeline;

    private Date time;

    private String imgPath;
    
    private String fpath ;

    private String fileSuffix;

    public JPrepareContentView(Long id, String title, Long resId, Integer fromFlag, String unifyType, String size,
            String timeline, Date time, String imgPath, String fileSuffix) {
        this.id = id;
        this.title = title;
        this.resId = resId;
        this.fromFlag = fromFlag;
        this.unifyType = unifyType;
        this.size = size;
        this.timeline = timeline;
        this.time = time;
        this.imgPath = imgPath;
        this.fileSuffix = fileSuffix;
    }

    public JPrepareContentView() {
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
     * @return size
     */
    public String getSize() {
        return size;
    }

    /**
     * @param size
     */
    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    /**
     * @return timeline
     */
    public String getTimeline() {
        return timeline;
    }

    /**
     * @param timeline
     */
    public void setTimeline(String timeline) {
        this.timeline = timeline == null ? null : timeline.trim();
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

    public String getUnifyType() {
        return unifyType;
    }

    public void setUnifyType(String unifyType) {
        this.unifyType = unifyType;
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

    
    public String getFpath() {
		return fpath;
	}

	public void setFpath(String fpath) {
		this.fpath = fpath;
	}

	@Override
    public String toString() {
        return "[prepareContentView:{id:" + id + ";title:" + title + ";resId:" + resId + ";fromFlag:" + fromFlag
                + ";unifyType:" + unifyType + ";imgPath:" + imgPath + ";fileSuffix:" + fileSuffix + "}]";
    }

}
