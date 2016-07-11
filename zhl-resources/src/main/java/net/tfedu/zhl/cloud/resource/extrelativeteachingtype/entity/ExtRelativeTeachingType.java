package net.tfedu.zhl.cloud.resource.extrelativeteachingtype.entity;

import java.io.Serializable;

import javax.persistence.*;

/**
 * 文件扩展名 和 教学类型 对照
 * @author wangwr
 *
 */
@Table(name = "j_extrelativeteachingtype")
public class ExtRelativeTeachingType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 资源的文件扩展名
     */
    private String extension;

    /**
     * 推荐的教学类型
     */
    private String teachingtype;

    /**
     * 是否为默认的教学类型，0不是，1是
     */
    @Column(name = "isDefault")
    private Boolean isdefault;

    /**
     * 上传文件的最大长度,单位M
     */
    @Column(name = "MaxSize")
    private Integer maxsize;

    public ExtRelativeTeachingType(Integer id, String extension, String teachingtype, Boolean isdefault, Integer maxsize) {
        this.id = id;
        this.extension = extension;
        this.teachingtype = teachingtype;
        this.isdefault = isdefault;
        this.maxsize = maxsize;
    }

    public ExtRelativeTeachingType() {
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
     * 获取资源的文件扩展名
     *
     * @return extension - 资源的文件扩展名
     */
    public String getExtension() {
        return extension;
    }

    /**
     * 设置资源的文件扩展名
     *
     * @param extension 资源的文件扩展名
     */
    public void setExtension(String extension) {
        this.extension = extension == null ? null : extension.trim();
    }

    /**
     * 获取推荐的教学类型
     *
     * @return teachingtype - 推荐的教学类型
     */
    public String getTeachingtype() {
        return teachingtype;
    }

    /**
     * 设置推荐的教学类型
     *
     * @param teachingtype 推荐的教学类型
     */
    public void setTeachingtype(String teachingtype) {
        this.teachingtype = teachingtype == null ? null : teachingtype.trim();
    }

    /**
     * 获取是否为默认的教学类型，0不是，1是
     *
     * @return isDefault - 是否为默认的教学类型，0不是，1是
     */
    public Boolean getIsdefault() {
        return isdefault;
    }

    /**
     * 设置是否为默认的教学类型，0不是，1是
     *
     * @param isdefault 是否为默认的教学类型，0不是，1是
     */
    public void setIsdefault(Boolean isdefault) {
        this.isdefault = isdefault;
    }

    /**
     * 获取上传文件的最大长度,单位M
     *
     * @return MaxSize - 上传文件的最大长度,单位M
     */
    public Integer getMaxsize() {
        return maxsize;
    }

    /**
     * 设置上传文件的最大长度,单位M
     *
     * @param maxsize 上传文件的最大长度,单位M
     */
    public void setMaxsize(Integer maxsize) {
        this.maxsize = maxsize;
    }
}