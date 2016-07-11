package net.tfedu.zhl.cloud.resource.asset.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

/**
 * 自建资源在前端的展示bean
 * 
 * @author wangwr
 * 
 */
public class ZAssetView implements Serializable {

    private Long resId;

    private String resCode;

    private String title;

    private String unifyType;

    private Date time;

    private String imgPath;

    private String fileSuffix;
    
    /**
     * 文件转码，0：转码完成，1：未完成
     */
    private Integer isFinished;

    public ZAssetView(Long resId, String title, String resCode, String unifyType, Date time, String imgPath,
            String fileSuffix,Integer isFinished) {
        this.title = title;
        this.resId = resId;
        this.unifyType = unifyType;
        this.time = time;
        this.imgPath = imgPath;
        this.fileSuffix = fileSuffix;
        this.isFinished = isFinished;
    }

    public ZAssetView() {
        super();
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

    
    public String getResCode() {
		return resCode;
	}

	public void setResCode(String resCode) {
		this.resCode = resCode;
	}

	public Integer getIsFinished() {
		return isFinished;
	}

	public void setIsFinished(Integer isFinished) {
		this.isFinished = isFinished;
	}

	@Override
    public String toString() {
        return "[ZAssetView:{resId:" + resId + ";title:" + title + ";resCode:" + resCode + ";unifyType:" + unifyType
                + ";imgPath:" + imgPath + ";fileSuffix:" + fileSuffix + ";isFinished:" + isFinished+ "}]";
    }

}
