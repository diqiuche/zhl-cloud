package net.tfedu.zhl.cloud.resource.asset.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "z_assetevaluate")
public class ZAssetValuate {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 相关联的资源id
     */
    @Column(name = "AssetId")
    private Long assetid;

    /**
     * 评论人
     */
    @Column(name = "UserId")
    private Long userid;

    /**
     * 评价时间
     */
    @Column(name = "Atime")
    private Date atime;

    @Column(name = "Acontent")
    private String acontent;

    /**
     * 评分
     */
    @Column(name = "Ascore")
    private Integer ascore;

    /**
     * 0共享资源评论,1系统资源评论 3,4校区本资源评论
     */
    @Column(name = "Atype")
    private String atype;

    /**
     * 是否删除此记录，0------否；1----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 0 评分 1评论
     */
    @Column(name = "IsScore")
    private Integer isscore;

    public ZAssetValuate(Long id, Long assetid, Long userid, Date atime, String acontent, Integer ascore, String atype,
            Boolean flag, Integer isscore) {
        this.id = id;
        this.assetid = assetid;
        this.userid = userid;
        this.atime = atime;
        this.acontent = acontent;
        this.ascore = ascore;
        this.atype = atype;
        this.flag = flag;
        this.isscore = isscore;
    }

    public ZAssetValuate() {
        super();
    }

    /**
     * 获取自增id
     *
     * @return Id - 自增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id
     *            自增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取相关联的资源id
     *
     * @return AssetId - 相关联的资源id
     */
    public Long getAssetid() {
        return assetid;
    }

    /**
     * 设置相关联的资源id
     *
     * @param assetid
     *            相关联的资源id
     */
    public void setAssetid(Long assetid) {
        this.assetid = assetid;
    }

    /**
     * 获取评论人
     *
     * @return UserId - 评论人
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置评论人
     *
     * @param userid
     *            评论人
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取评价时间
     *
     * @return Atime - 评价时间
     */
    public Date getAtime() {
        return atime;
    }

    /**
     * 设置评价时间
     *
     * @param atime
     *            评价时间
     */
    public void setAtime(Date atime) {
        this.atime = atime;
    }

    /**
     * @return Acontent
     */
    public String getAcontent() {
        return acontent;
    }

    /**
     * @param acontent
     */
    public void setAcontent(String acontent) {
        this.acontent = acontent == null ? null : acontent.trim();
    }

    /**
     * 获取评分
     *
     * @return Ascore - 评分
     */
    public Integer getAscore() {
        return ascore;
    }

    /**
     * 设置评分
     *
     * @param ascore
     *            评分
     */
    public void setAscore(Integer ascore) {
        this.ascore = ascore;
    }

    /**
     * 获取0共享资源评论,1系统资源评论 3,4校区本资源评论
     *
     * @return Atype - 0共享资源评论,1系统资源评论 3,4校区本资源评论
     */
    public String getAtype() {
        return atype;
    }

    /**
     * 设置0共享资源评论,1系统资源评论 3,4校区本资源评论
     *
     * @param atype
     *            0共享资源评论,1系统资源评论 3,4校区本资源评论
     */
    public void setAtype(String atype) {
        this.atype = atype == null ? null : atype.trim();
    }

    /**
     * 获取是否删除此记录，0------否；1----是
     *
     * @return Flag - 是否删除此记录，0------否；1----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除此记录，0------否；1----是
     *
     * @param flag
     *            是否删除此记录，0------否；1----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取0 评分 1评论
     *
     * @return IsScore - 0 评分 1评论
     */
    public Integer getIsscore() {
        return isscore;
    }

    /**
     * 设置0 评分 1评论
     *
     * @param isscore
     *            0 评分 1评论
     */
    public void setIsscore(Integer isscore) {
        this.isscore = isscore;
    }
}