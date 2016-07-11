package net.tfedu.zhl.cloud.resource.downloadrescord.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "z_res_zip_down_record")
public class ResZipDownRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 下载人
     */
    private Long userid;

    /**
     * 下载时间
     */
    private Date time;

    /**
     * 下载资源来源集合,逗号分隔
     */
    private String fromflags;

    /**
     * 生成的压缩包的保存路径
     */
    private String zippath;
    
    
    /**
     * 压缩包的下载名称
     */
    private String zipname;

    /**
     * 是否打包完成 false 为完成 true 已经完成
     */
    private Boolean status;

    /**
     * 下载资源id集合,逗号分隔
     */
    private String ids;

    public ResZipDownRecord(Long id, Long userid, Date time, String fromflags, String zippath, Boolean status,
            String ids,String zipname) {
        this.id = id;
        this.userid = userid;
        this.time = time;
        this.fromflags = fromflags;
        this.zippath = zippath;
        this.status = status;
        this.ids = ids;
        this.zipname = zipname;
    }

    public ResZipDownRecord() {
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
     * 获取下载人
     *
     * @return userid - 下载人
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置下载人
     *
     * @param userid
     *            下载人
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取下载时间
     *
     * @return time - 下载时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 设置下载时间
     *
     * @param time
     *            下载时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 获取下载资源来源集合,逗号分隔
     *
     * @return fromflags - 下载资源来源集合,逗号分隔
     */
    public String getFromflags() {
        return fromflags;
    }

    /**
     * 设置下载资源来源集合,逗号分隔
     *
     * @param fromflags
     *            下载资源来源集合,逗号分隔
     */
    public void setFromflags(String fromflags) {
        this.fromflags = fromflags == null ? null : fromflags.trim();
    }

    /**
     * 获取生成的压缩包的保存路径
     *
     * @return zippath - 生成的压缩包的保存路径
     */
    public String getZippath() {
        return zippath;
    }

    /**
     * 设置生成的压缩包的保存路径
     *
     * @param zippath
     *            生成的压缩包的保存路径
     */
    public void setZippath(String zippath) {
        this.zippath = zippath == null ? null : zippath.trim();
    }

    /**
     * 获取是否打包完成 false 为完成 true 已经完成
     *
     * @return status - 是否打包完成 false 为完成 true 已经完成
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置是否打包完成 false 为完成 true 已经完成
     *
     * @param status
     *            是否打包完成 false 为完成 true 已经完成
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取下载资源id集合,逗号分隔
     *
     * @return ids - 下载资源id集合,逗号分隔
     */
    public String getIds() {
        return ids;
    }

    /**
     * 设置下载资源id集合,逗号分隔
     *
     * @param ids
     *            下载资源id集合,逗号分隔
     */
    public void setIds(String ids) {
        this.ids = ids == null ? null : ids.trim();
    }

	public String getZipname() {
		return zipname;
	}

	public void setZipname(String zipname) {
		this.zipname = zipname;
	}
    
    
}