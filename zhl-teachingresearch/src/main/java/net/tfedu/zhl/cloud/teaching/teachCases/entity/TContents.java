package net.tfedu.zhl.cloud.teaching.teachCases.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "t_contents")
public class TContents implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 案例内容类型名
     */
    @Column(name = "contentType")
    private String contenttype;

    /**
     * 类型对应的缩略图路径
     */
    private String thumbnailpath;

    public TContents(Integer id, String contenttype, String thumbnailpath) {
        this.id = id;
        this.contenttype = contenttype;
        this.thumbnailpath = thumbnailpath;
    }

    public TContents() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取案例内容类型名
     *
     * @return contentType - 案例内容类型名
     */
    public String getContenttype() {
        return contenttype;
    }

    /**
     * 设置案例内容类型名
     *
     * @param contenttype 案例内容类型名
     */
    public void setContenttype(String contenttype) {
        this.contenttype = contenttype == null ? null : contenttype.trim();
    }

    /**
     * 获取类型对应的缩略图路径
     *
     * @return thumbnailpath - 类型对应的缩略图路径
     */
    public String getThumbnailpath() {
        return thumbnailpath;
    }

    /**
     * 设置类型对应的缩略图路径
     *
     * @param thumbnailpath 类型对应的缩略图路径
     */
    public void setThumbnailpath(String thumbnailpath) {
        this.thumbnailpath = thumbnailpath == null ? null : thumbnailpath.trim();
    }
}