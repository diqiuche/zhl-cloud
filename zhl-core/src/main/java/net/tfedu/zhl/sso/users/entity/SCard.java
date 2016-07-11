package net.tfedu.zhl.sso.users.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "s_card")
public class SCard implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 批次id
     */
    @Column(name = "BatchId")
    private Long batchid;

    /**
     * 卡号
     */
    @Column(name = "CardNumber")
    private String cardnumber;

    /**
     * 卡密码
     */
    @Column(name = "CardPwd")
    private String cardpwd;

    /**
     * 制定日期
     */
    @Column(name = "CreateTime")
    private Date createtime;

    /**
     * 制定人
     */
    @Column(name = "CreateMan")
    private String createman;

    /**
     * 角色类型
     */
    @Column(name = "RoleId")
    private Long roleid;

    /**
     * 注册码类型 （教师客户端M，还是网络注册账号P，充值卡类型）
     */
    @Column(name = "RegistKeyType")
    private String registkeytype;

    /**
     * 注册的开始时间
     */
    @Column(name = "StartTime")
    private Date starttime;

    /**
     * 注册结束时间
     */
    @Column(name = "EndTime")
    private Date endtime;

    /**
     * 0----未注册l；1-----已注册
     */
    private Integer state;

    /**
     * 注册期限（这卡必须在什么时间注册，过期则视为无效卡）多少个月
     * 
     */
    @Column(name = "Exp_num")
    private Integer expNum;

    @Column(name = "Section")
    private String section;

    /**
     * 标明卡号的位置定位到学校还是区县
     */
    @Column(name = "PositionId")
    private Long positionid;

    /**
     * 区县定位的标识
     */
    @Column(name = "DisPositionId")
    private Long dispositionid;

    /**
     * 是否删除标识；0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    @Column(name = "Count")
    private Integer count;

    /**
     * 市
     */
    @Column(name = "cityId")
    private Long cityid;

    /**
     * 省
     */
    @Column(name = "provinceId")
    private Long provinceid;

    public SCard(Long id, Long batchid, String cardnumber, String cardpwd, Date createtime, String createman, Long roleid, String registkeytype, Date starttime, Date endtime, Integer state,
            Integer expNum, String section, Long positionid, Long dispositionid, Boolean flag, Integer count, Long cityid, Long provinceid) {
        this.id = id;
        this.batchid = batchid;
        this.cardnumber = cardnumber;
        this.cardpwd = cardpwd;
        this.createtime = createtime;
        this.createman = createman;
        this.roleid = roleid;
        this.registkeytype = registkeytype;
        this.starttime = starttime;
        this.endtime = endtime;
        this.state = state;
        this.expNum = expNum;
        this.section = section;
        this.positionid = positionid;
        this.dispositionid = dispositionid;
        this.flag = flag;
        this.count = count;
        this.cityid = cityid;
        this.provinceid = provinceid;
    }

    public SCard() {
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
     * 获取批次id
     *
     * @return BatchId - 批次id
     */
    public Long getBatchid() {
        return batchid;
    }

    /**
     * 设置批次id
     *
     * @param batchid
     *            批次id
     */
    public void setBatchid(Long batchid) {
        this.batchid = batchid;
    }

    /**
     * 获取卡号
     *
     * @return CardNumber - 卡号
     */
    public String getCardnumber() {
        return cardnumber;
    }

    /**
     * 设置卡号
     *
     * @param cardnumber
     *            卡号
     */
    public void setCardnumber(String cardnumber) {
        this.cardnumber = cardnumber == null ? null : cardnumber.trim();
    }

    /**
     * 获取卡密码
     *
     * @return CardPwd - 卡密码
     */
    public String getCardpwd() {
        return cardpwd;
    }

    /**
     * 设置卡密码
     *
     * @param cardpwd
     *            卡密码
     */
    public void setCardpwd(String cardpwd) {
        this.cardpwd = cardpwd == null ? null : cardpwd.trim();
    }

    /**
     * 获取制定日期
     *
     * @return CreateTime - 制定日期
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * 设置制定日期
     *
     * @param createtime
     *            制定日期
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * 获取制定人
     *
     * @return CreateMan - 制定人
     */
    public String getCreateman() {
        return createman;
    }

    /**
     * 设置制定人
     *
     * @param createman
     *            制定人
     */
    public void setCreateman(String createman) {
        this.createman = createman == null ? null : createman.trim();
    }

    /**
     * 获取角色类型
     *
     * @return RoleId - 角色类型
     */
    public Long getRoleid() {
        return roleid;
    }

    /**
     * 设置角色类型
     *
     * @param roleid
     *            角色类型
     */
    public void setRoleid(Long roleid) {
        this.roleid = roleid;
    }

    /**
     * 获取注册码类型 （教师客户端M，还是网络注册账号P，充值卡类型）
     *
     * @return RegistKeyType - 注册码类型 （教师客户端M，还是网络注册账号P，充值卡类型）
     */
    public String getRegistkeytype() {
        return registkeytype;
    }

    /**
     * 设置注册码类型 （教师客户端M，还是网络注册账号P，充值卡类型）
     *
     * @param registkeytype
     *            注册码类型 （教师客户端M，还是网络注册账号P，充值卡类型）
     */
    public void setRegistkeytype(String registkeytype) {
        this.registkeytype = registkeytype == null ? null : registkeytype.trim();
    }

    /**
     * 获取注册的开始时间
     *
     * @return StartTime - 注册的开始时间
     */
    public Date getStarttime() {
        return starttime;
    }

    /**
     * 设置注册的开始时间
     *
     * @param starttime
     *            注册的开始时间
     */
    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    /**
     * 获取注册结束时间
     *
     * @return EndTime - 注册结束时间
     */
    public Date getEndtime() {
        return endtime;
    }

    /**
     * 设置注册结束时间
     *
     * @param endtime
     *            注册结束时间
     */
    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }

    /**
     * 获取0----未注册l；1-----已注册
     *
     * @return state - 0----未注册l；1-----已注册
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置0----未注册l；1-----已注册
     *
     * @param state
     *            0----未注册l；1-----已注册
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取注册期限（这卡必须在什么时间注册，过期则视为无效卡）多少个月
     *
     * 
     * @return Exp_num - 注册期限（这卡必须在什么时间注册，过期则视为无效卡）多少个月
     * 
     */
    public Integer getExpNum() {
        return expNum;
    }

    /**
     * 设置注册期限（这卡必须在什么时间注册，过期则视为无效卡）多少个月
     *
     * 
     * @param expNum
     *            注册期限（这卡必须在什么时间注册，过期则视为无效卡）多少个月
     * 
     */
    public void setExpNum(Integer expNum) {
        this.expNum = expNum;
    }

    /**
     * @return Section
     */
    public String getSection() {
        return section;
    }

    /**
     * @param section
     */
    public void setSection(String section) {
        this.section = section == null ? null : section.trim();
    }

    /**
     * 获取标明卡号的位置定位到学校还是区县
     *
     * @return PositionId - 标明卡号的位置定位到学校还是区县
     */
    public Long getPositionid() {
        return positionid;
    }

    /**
     * 设置标明卡号的位置定位到学校还是区县
     *
     * @param positionid
     *            标明卡号的位置定位到学校还是区县
     */
    public void setPositionid(Long positionid) {
        this.positionid = positionid;
    }

    /**
     * 获取区县定位的标识
     *
     * @return DisPositionId - 区县定位的标识
     */
    public Long getDispositionid() {
        return dispositionid;
    }

    /**
     * 设置区县定位的标识
     *
     * @param dispositionid
     *            区县定位的标识
     */
    public void setDispositionid(Long dispositionid) {
        this.dispositionid = dispositionid;
    }

    /**
     * 获取是否删除标识；0-----未删除；1----删除
     *
     * @return Flag - 是否删除标识；0-----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标识；0-----未删除；1----删除
     *
     * @param flag
     *            是否删除标识；0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @return Count
     */
    public Integer getCount() {
        return count;
    }

    /**
     * @param count
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取市
     *
     * @return cityId - 市
     */
    public Long getCityid() {
        return cityid;
    }

    /**
     * 设置市
     *
     * @param cityid
     *            市
     */
    public void setCityid(Long cityid) {
        this.cityid = cityid;
    }

    /**
     * 获取省
     *
     * @return provinceId - 省
     */
    public Long getProvinceid() {
        return provinceid;
    }

    /**
     * 设置省
     *
     * @param provinceid
     *            省
     */
    public void setProvinceid(Long provinceid) {
        this.provinceid = provinceid;
    }
}