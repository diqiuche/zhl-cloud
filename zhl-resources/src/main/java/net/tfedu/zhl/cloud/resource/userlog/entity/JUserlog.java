package net.tfedu.zhl.cloud.resource.userlog.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "j_userlog")
public class JUserlog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 日志类型
     */
    private String logtypecode;

    /**
     * 操作类型
     */
    private String opertypecode;

    /**
     * 对象名称
     */
    private String objname;

    /**
     * 对象ID
     */
    @Column(name = "objId")
    private Long objid;

    /**
     * 科目Id
     */
    @Column(name = "subjectId")
    private Long subjectid;

    private Date createtime;

    /**
     * 时长
     */
    private String duration;

    /**
     * 下载标识
     */
    private Boolean downflag;

    /**
     * 做题数
     */
    private Integer alltestnum;

    /**
     * 正确数
     */
    private Integer corrtestnum;

    /**
     * 删除标识
     */
    private Boolean flag;

    /**
     * 0 前台日志 1 后台日志
     */
    @Column(name = "isFlag")
    private Integer isflag;

    public JUserlog(Long id, Long userid, String logtypecode, String opertypecode, String objname, Long objid, Long subjectid, Date createtime, String duration, Boolean downflag, Integer alltestnum,
            Integer corrtestnum, Boolean flag, Integer isflag) {
        this.id = id;
        this.userid = userid;
        this.logtypecode = logtypecode;
        this.opertypecode = opertypecode;
        this.objname = objname;
        this.objid = objid;
        this.subjectid = subjectid;
        this.createtime = createtime;
        this.duration = duration;
        this.downflag = downflag;
        this.alltestnum = alltestnum;
        this.corrtestnum = corrtestnum;
        this.flag = flag;
        this.isflag = isflag;
    }

    public JUserlog() {
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
     * 获取用户ID
     *
     * @return userId - 用户ID
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户ID
     *
     * @param userid
     *            用户ID
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取日志类型
     *
     * @return logtypecode - 日志类型
     */
    public String getLogtypecode() {
        return logtypecode;
    }

    /**
     * 设置日志类型
     *
     * @param logtypecode
     *            日志类型
     */
    public void setLogtypecode(String logtypecode) {
        this.logtypecode = logtypecode == null ? null : logtypecode.trim();
    }

    /**
     * 获取操作类型
     *
     * @return opertypecode - 操作类型
     */
    public String getOpertypecode() {
        return opertypecode;
    }

    /**
     * 设置操作类型
     *
     * @param opertypecode
     *            操作类型
     */
    public void setOpertypecode(String opertypecode) {
        this.opertypecode = opertypecode == null ? null : opertypecode.trim();
    }

    /**
     * 获取对象名称
     *
     * @return objname - 对象名称
     */
    public String getObjname() {
        return objname;
    }

    /**
     * 设置对象名称
     *
     * @param objname
     *            对象名称
     */
    public void setObjname(String objname) {
        this.objname = objname == null ? null : objname.trim();
    }

    /**
     * 获取对象ID
     *
     * @return objId - 对象ID
     */
    public Long getObjid() {
        return objid;
    }

    /**
     * 设置对象ID
     *
     * @param objid
     *            对象ID
     */
    public void setObjid(Long objid) {
        this.objid = objid;
    }

    /**
     * 获取科目Id
     *
     * @return subjectId - 科目Id
     */
    public Long getSubjectid() {
        return subjectid;
    }

    /**
     * 设置科目Id
     *
     * @param subjectid
     *            科目Id
     */
    public void setSubjectid(Long subjectid) {
        this.subjectid = subjectid;
    }

    /**
     * @return createtime
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * @param createtime
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取时长
     *
     * @return duration - 时长
     */
    public String getDuration() {
        return duration;
    }

    /**
     * 设置时长
     *
     * @param duration
     *            时长
     */
    public void setDuration(String duration) {
        this.duration = duration == null ? null : duration.trim();
    }

    /**
     * 获取下载标识
     *
     * @return downflag - 下载标识
     */
    public Boolean getDownflag() {
        return downflag;
    }

    /**
     * 设置下载标识
     *
     * @param downflag
     *            下载标识
     */
    public void setDownflag(Boolean downflag) {
        this.downflag = downflag;
    }

    /**
     * 获取做题数
     *
     * @return alltestnum - 做题数
     */
    public Integer getAlltestnum() {
        return alltestnum;
    }

    /**
     * 设置做题数
     *
     * @param alltestnum
     *            做题数
     */
    public void setAlltestnum(Integer alltestnum) {
        this.alltestnum = alltestnum;
    }

    /**
     * 获取正确数
     *
     * @return corrtestnum - 正确数
     */
    public Integer getCorrtestnum() {
        return corrtestnum;
    }

    /**
     * 设置正确数
     *
     * @param corrtestnum
     *            正确数
     */
    public void setCorrtestnum(Integer corrtestnum) {
        this.corrtestnum = corrtestnum;
    }

    /**
     * 获取删除标识
     *
     * @return flag - 删除标识
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置删除标识
     *
     * @param flag
     *            删除标识
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取0 前台日志 1 后台日志
     *
     * @return isFlag - 0 前台日志 1 后台日志
     */
    public Integer getIsflag() {
        return isflag;
    }

    /**
     * 设置0 前台日志 1 后台日志
     *
     * @param isflag
     *            0 前台日志 1 后台日志
     */
    public void setIsflag(Integer isflag) {
        this.isflag = isflag;
    }
}