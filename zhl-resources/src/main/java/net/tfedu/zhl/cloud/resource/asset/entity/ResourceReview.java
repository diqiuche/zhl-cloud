package net.tfedu.zhl.cloud.resource.asset.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;

/**
 * 资源评论Bean
 * 
 * @author wangwr
 * 
 */
public class ResourceReview implements Serializable {

    /**
     * 评论id
     */
    @Id
    private Long id;

    private Long resId;

    private String resCode;

    private String title;

    /**
     * 转换为新版的fromflag输出
     */
    private Integer fromFlag;

    private String content;

    /**
     * 评论时间
     */
    private Date time;

    private String imgPath;

    private String fileSuffix;

    public ResourceReview(Long id, String title, Long resId, Integer fromFlag, String content, Date time,
            String imgPath, String fileSuffix, String resCode) {
        this.id = id;
        this.title = title;
        this.resId = resId;
        this.fromFlag = fromFlag;
        this.content = content;
        this.time = time;
        this.imgPath = imgPath;
        this.fileSuffix = fileSuffix;
        this.resCode = resCode;
    }

    public ResourceReview() {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        return "[ResourceReview:{id:" + id + ";title:" + title + ";resId:" + resId + ";fromFlag:" + fromFlag
                + ";content:" + content + ";imgPath:" + imgPath + ";fileSuffix:" + fileSuffix + "}]";
    }

}
