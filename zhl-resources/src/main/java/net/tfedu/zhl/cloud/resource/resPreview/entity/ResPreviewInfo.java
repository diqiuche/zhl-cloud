package net.tfedu.zhl.cloud.resource.resPreview.entity;

import java.io.Serializable;

/**
 * 预览的一条资源的详细信息
 * 
 * @author WeiCuicui
 *
 */
public class ResPreviewInfo implements Serializable {

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
     * 关键字
     */
    private String keyWord;

    /**
     * 简介
     */
    private String Des;

    /**
     * 资源大小
     */
    private String fSize;

    /**
     * 资源类型
     */
    private String MType;
    /**
     * 类型id
     */
    private Integer typeId;

    /**
     * 下载次数
     */
    private Integer DLoadTimes;
    /**
     * 浏览次数
     */
    private Integer ClickTimes;

    /**
     * 资源来源
     */
    private int fromflag;

    /**
     * 文件名
     */
    private String fname;

    /**
     * 文件路径
     */
    private String Fpath;

    /**
     * 评论的用户数
     */
    private int userNum;

    /**
     * 总的评分
     */
    private Integer score;

    /**
     * 平均评分
     */
    private int avgScore;

    /**
     * 文件扩展名
     */
    private String FileExt;

    /**
     * 是否为多文件（0：否 ；1：是）
     */
    private boolean isDWJ;

    /**
     * 是否为本地文件（0：否 ；1：是）
     */
    private boolean isLocal;

    public boolean isLocal() {
        return isLocal;
    }

    public void setLocal(boolean isLocal) {
        this.isLocal = isLocal;
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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getDes() {
        return Des;
    }

    public void setDes(String des) {
        Des = des;
    }

    public String getfSize() {
        return fSize;
    }

    public void setfSize(String fSize) {
        this.fSize = fSize;
    }

    public String getMType() {
        return MType;
    }

    public void setMType(String mType) {
        MType = mType;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getDLoadTimes() {
        return DLoadTimes;
    }

    public void setDLoadTimes(Integer dLoadTimes) {
        DLoadTimes = dLoadTimes;
    }

    public Integer getClickTimes() {
        return ClickTimes;
    }

    public void setClickTimes(Integer clickTimes) {
        ClickTimes = clickTimes;
    }

    public int getFromflag() {
        return fromflag;
    }

    public void setFromflag(int fromflag) {
        this.fromflag = fromflag;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getFpath() {
        return Fpath;
    }

    public void setFpath(String fpath) {
        Fpath = fpath;
    }

    public int getUserNum() {
        return userNum;
    }

    public void setUserNum(int userNum) {
        this.userNum = userNum;
    }

    public int getScore() {
    	return score == null ? 0 : score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getAvgScore() {
        return avgScore;
    }

    public void setAvgScore(int avgScore) {
        this.avgScore = avgScore;
    }

    public String getFileExt() {
        return FileExt;
    }

    public void setFileExt(String fileExt) {
        FileExt = fileExt;
    }

    public boolean isDWJ() {
        return isDWJ;
    }

    public void setDWJ(boolean isDWJ) {
        this.isDWJ = isDWJ;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "previewInfo[resId=" + id + ",title=" + Title + ",keyword=" + keyWord + ",des=" + Des + ",fpath="+ Fpath +",fname="+ fname +"]";
    }

}
