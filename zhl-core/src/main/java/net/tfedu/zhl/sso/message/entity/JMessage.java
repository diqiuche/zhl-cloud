package net.tfedu.zhl.sso.message.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "j_message")
public class JMessage implements Serializable{
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户ID（接收者）
     */
    private Long userid;

    /**
     * 发送者  0 系统
     */
    @Column(name = "sendUserId")
    private Long senduserid;

    @Column(name = "CreateTime")
    private Date createtime;

    @Column(name = "objId")
    private Long objid;

    /**
     * 对象类型  item topic work  test
     */
    @Column(name = "objType")
    private String objtype;

    /**
     * 消息的栏目
     */
    private String nagivation;

    /**
     * 下载标识
     */
    @Column(name = "downFlag")
    private Boolean downflag;

    /**
     * 已读标识
     */
    private Boolean readflag;

    /**
     * 消息发送类别 （"填写0，表示该消息为公共消息并推送到门户首页填写1，表示该消息为公共消息并推送到全部空间首页 填写2，表示该消息为公共消息并推送到门户首页与全部空间空页 3，表示该消息为私有）
     */
    private Integer category;

    /**
     * 消息级别（填写0，普通消息填写1，紧急消息（重要消息）消息级别填写1的时候，门户空间中该条消息将以弹出框的形式提醒用户处理）
     */
    private Integer level;

    /**
     * 删除标识
     */
    private Boolean flag;

    /**
     * 消息/操作类型(j_message_oper中的Id)
     */
    @Column(name = "operId")
    private Long operid;

    /**
     * 消息内容
     */
    private String msg;

    public JMessage(Long id, Long userid, Long senduserid, Date createtime, Long objid, String objtype, String nagivation, Boolean downflag, Boolean readflag, Integer category, Integer level, Boolean flag, Long operid, String msg) {
        this.id = id;
        this.userid = userid;
        this.senduserid = senduserid;
        this.createtime = createtime;
        this.objid = objid;
        this.objtype = objtype;
        this.nagivation = nagivation;
        this.downflag = downflag;
        this.readflag = readflag;
        this.category = category;
        this.level = level;
        this.flag = flag;
        this.operid = operid;
        this.msg = msg;
    }

    public JMessage() {
        super();
    }

    /**
     * 获取ID
     *
     * @return id - ID
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户ID（接收者）
     *
     * @return userid - 用户ID（接收者）
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户ID（接收者）
     *
     * @param userid 用户ID（接收者）
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取发送者  0 系统
     *
     * @return sendUserId - 发送者  0 系统
     */
    public Long getSenduserid() {
        return senduserid;
    }

    /**
     * 设置发送者  0 系统
     *
     * @param senduserid 发送者  0 系统
     */
    public void setSenduserid(Long senduserid) {
        this.senduserid = senduserid;
    }

    /**
     * @return CreateTime
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
     * @return objId
     */
    public Long getObjid() {
        return objid;
    }

    /**
     * @param objid
     */
    public void setObjid(Long objid) {
        this.objid = objid;
    }

    /**
     * 获取对象类型  item topic work  test
     *
     * @return objType - 对象类型  item topic work  test
     */
    public String getObjtype() {
        return objtype;
    }

    /**
     * 设置对象类型  item topic work  test
     *
     * @param objtype 对象类型  item topic work  test
     */
    public void setObjtype(String objtype) {
        this.objtype = objtype == null ? null : objtype.trim();
    }

    /**
     * 获取消息的栏目
     *
     * @return nagivation - 消息的栏目
     */
    public String getNagivation() {
        return nagivation;
    }

    /**
     * 设置消息的栏目
     *
     * @param nagivation 消息的栏目
     */
    public void setNagivation(String nagivation) {
        this.nagivation = nagivation == null ? null : nagivation.trim();
    }

    /**
     * 获取下载标识
     *
     * @return downFlag - 下载标识
     */
    public Boolean getDownflag() {
        return downflag;
    }

    /**
     * 设置下载标识
     *
     * @param downflag 下载标识
     */
    public void setDownflag(Boolean downflag) {
        this.downflag = downflag;
    }

    /**
     * 获取已读标识
     *
     * @return readflag - 已读标识
     */
    public Boolean getReadflag() {
        return readflag;
    }

    /**
     * 设置已读标识
     *
     * @param readflag 已读标识
     */
    public void setReadflag(Boolean readflag) {
        this.readflag = readflag;
    }

    /**
     * 获取消息发送类别 （"填写0，表示该消息为公共消息并推送到门户首页填写1，表示该消息为公共消息并推送到全部空间首页 填写2，表示该消息为公共消息并推送到门户首页与全部空间空页 3，表示该消息为私有）
     *
     * @return category - 消息发送类别 （"填写0，表示该消息为公共消息并推送到门户首页填写1，表示该消息为公共消息并推送到全部空间首页 填写2，表示该消息为公共消息并推送到门户首页与全部空间空页 3，表示该消息为私有）
     */
    public Integer getCategory() {
        return category;
    }

    /**
     * 设置消息发送类别 （"填写0，表示该消息为公共消息并推送到门户首页填写1，表示该消息为公共消息并推送到全部空间首页 填写2，表示该消息为公共消息并推送到门户首页与全部空间空页 3，表示该消息为私有）
     *
     * @param category 消息发送类别 （"填写0，表示该消息为公共消息并推送到门户首页填写1，表示该消息为公共消息并推送到全部空间首页 填写2，表示该消息为公共消息并推送到门户首页与全部空间空页 3，表示该消息为私有）
     */
    public void setCategory(Integer category) {
        this.category = category;
    }

    /**
     * 获取消息级别（填写0，普通消息填写1，紧急消息（重要消息）消息级别填写1的时候，门户空间中该条消息将以弹出框的形式提醒用户处理）
     *
     * @return level - 消息级别（填写0，普通消息填写1，紧急消息（重要消息）消息级别填写1的时候，门户空间中该条消息将以弹出框的形式提醒用户处理）
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 设置消息级别（填写0，普通消息填写1，紧急消息（重要消息）消息级别填写1的时候，门户空间中该条消息将以弹出框的形式提醒用户处理）
     *
     * @param level 消息级别（填写0，普通消息填写1，紧急消息（重要消息）消息级别填写1的时候，门户空间中该条消息将以弹出框的形式提醒用户处理）
     */
    public void setLevel(Integer level) {
        this.level = level;
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
     * @param flag 删除标识
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取消息/操作类型(j_message_oper中的Id)
     *
     * @return operId - 消息/操作类型(j_message_oper中的Id)
     */
    public Long getOperid() {
        return operid;
    }

    /**
     * 设置消息/操作类型(j_message_oper中的Id)
     *
     * @param operid 消息/操作类型(j_message_oper中的Id)
     */
    public void setOperid(Long operid) {
        this.operid = operid;
    }

    /**
     * 获取消息内容
     *
     * @return msg - 消息内容
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置消息内容
     *
     * @param msg 消息内容
     */
    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }
}