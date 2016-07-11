package net.tfedu.zhl.sso.userinfo.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "j_userinfo")
public class JUserInfo {
    /**
     * 非自增的主键id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "UserId")
    private Long userid;

    /**
     * 个人总积分
     */
    @Column(name = "ScoureSum")
    private Integer scouresum;

    /**
     * 日常操作得分
     */
    @Column(name = "OperateScore")
    private Integer operatescore;

    /**
     * 给分
     */
    @Column(name = "GiveScore")
    private Integer givescore;

    /**
     * 得分
     */
    @Column(name = "GetScore")
    private Integer getscore;

    /**
     * 回答得分
     */
    @Column(name = "AnswerScore")
    private Integer answerscore;

    /**
     * 发帖数量（论坛）
     */
    @Column(name = "PublishCnt")
    private Integer publishcnt;

    /**
     * 回帖数量（论坛）
     */
    @Column(name = "ResponseCnt")
    private Integer responsecnt;

    @Column(name = "Address")
    private String address;

    @Column(name = "Duty")
    private String duty;

    /**
     * 论坛中的星值
     */
    @Column(name = "StarCount")
    private Integer starcount;

    @Column(name = "IsVisible")
    private String isvisible;

    @Column(name = "ForumType")
    private String forumtype;

    @Column(name = "IdCard")
    private String idcard;

    @Column(name = "IdType")
    private String idtype;

    /**
     * 生日
     */
    @Column(name = "BirthDate")
    private Date birthdate;

    @Column(name = "MobileNumber")
    private String mobilenumber;

    /**
     * �ֻ�����
     */
    @Column(name = "PhoneNumber")
    private String phonenumber;

    @Column(name = "QQ")
    private String qq;

    @Column(name = "MSN")
    private String msn;

    /**
     * ������ҳ
     */
    @Column(name = "PhPage")
    private String phpage;

    @Column(name = "Deskpic")
    private String deskpic;

    @Column(name = "UserImage")
    private String userimage;

    /**
     * ��������
     */
    @Column(name = "Music")
    private String music;

    /**
     * 1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     */
    @Column(name = "IsSee")
    private Integer issee;

    /**
     * 辅导答疑积分
     */
    @Column(name = "Qascore")
    private Integer qascore;

    /**
     * 是否删除，0----否；1------是
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * 个人栏目数目
     */
    @Column(name = "forumPartNum")
    private Integer forumpartnum;

    /**
     * 个人论题数目
     */
    @Column(name = "forumTopicNum")
    private Integer forumtopicnum;

    /**
     * 个人主题数目
     */
    @Column(name = "forumItemNum")
    private Integer forumitemnum;

    /**
     * 个人回帖数目
     */
    @Column(name = "forumReItemNum")
    private Integer forumreitemnum;

    /**
     * 个人评论数目
     */
    @Column(name = "forumOpinionNum")
    private Integer forumopinionnum;

    /**
     * 个人鲜花数目
     */
    @Column(name = "forumFlowerNum")
    private Integer forumflowernum;

    @Column(name = "Resume")
    private String resume;

    public JUserInfo(Long id, Long userid, Integer scouresum, Integer operatescore, Integer givescore, Integer getscore, Integer answerscore, Integer publishcnt, Integer responsecnt, String address, String duty, Integer starcount, String isvisible, String forumtype, String idcard, String idtype, Date birthdate, String mobilenumber, String phonenumber, String qq, String msn, String phpage, String deskpic, String userimage, String music, Integer issee, Integer qascore, Boolean flag, Integer forumpartnum, Integer forumtopicnum, Integer forumitemnum, Integer forumreitemnum, Integer forumopinionnum, Integer forumflowernum, String resume) {
        this.id = id;
        this.userid = userid;
        this.scouresum = scouresum;
        this.operatescore = operatescore;
        this.givescore = givescore;
        this.getscore = getscore;
        this.answerscore = answerscore;
        this.publishcnt = publishcnt;
        this.responsecnt = responsecnt;
        this.address = address;
        this.duty = duty;
        this.starcount = starcount;
        this.isvisible = isvisible;
        this.forumtype = forumtype;
        this.idcard = idcard;
        this.idtype = idtype;
        this.birthdate = birthdate;
        this.mobilenumber = mobilenumber;
        this.phonenumber = phonenumber;
        this.qq = qq;
        this.msn = msn;
        this.phpage = phpage;
        this.deskpic = deskpic;
        this.userimage = userimage;
        this.music = music;
        this.issee = issee;
        this.qascore = qascore;
        this.flag = flag;
        this.forumpartnum = forumpartnum;
        this.forumtopicnum = forumtopicnum;
        this.forumitemnum = forumitemnum;
        this.forumreitemnum = forumreitemnum;
        this.forumopinionnum = forumopinionnum;
        this.forumflowernum = forumflowernum;
        this.resume = resume;
    }

    public JUserInfo() {
        super();
    }

    /**
     * 获取非自增的主键id
     *
     * @return Id - 非自增的主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置非自增的主键id
     *
     * @param id 非自增的主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return UserId
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * @param userid
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取个人总积分
     *
     * @return ScoureSum - 个人总积分
     */
    public Integer getScouresum() {
        return scouresum;
    }

    /**
     * 设置个人总积分
     *
     * @param scouresum 个人总积分
     */
    public void setScouresum(Integer scouresum) {
        this.scouresum = scouresum;
    }

    /**
     * 获取日常操作得分
     *
     * @return OperateScore - 日常操作得分
     */
    public Integer getOperatescore() {
        return operatescore;
    }

    /**
     * 设置日常操作得分
     *
     * @param operatescore 日常操作得分
     */
    public void setOperatescore(Integer operatescore) {
        this.operatescore = operatescore;
    }

    /**
     * 获取给分
     *
     * @return GiveScore - 给分
     */
    public Integer getGivescore() {
        return givescore;
    }

    /**
     * 设置给分
     *
     * @param givescore 给分
     */
    public void setGivescore(Integer givescore) {
        this.givescore = givescore;
    }

    /**
     * 获取得分
     *
     * @return GetScore - 得分
     */
    public Integer getGetscore() {
        return getscore;
    }

    /**
     * 设置得分
     *
     * @param getscore 得分
     */
    public void setGetscore(Integer getscore) {
        this.getscore = getscore;
    }

    /**
     * 获取回答得分
     *
     * @return AnswerScore - 回答得分
     */
    public Integer getAnswerscore() {
        return answerscore;
    }

    /**
     * 设置回答得分
     *
     * @param answerscore 回答得分
     */
    public void setAnswerscore(Integer answerscore) {
        this.answerscore = answerscore;
    }

    /**
     * 获取发帖数量（论坛）
     *
     * @return PublishCnt - 发帖数量（论坛）
     */
    public Integer getPublishcnt() {
        return publishcnt;
    }

    /**
     * 设置发帖数量（论坛）
     *
     * @param publishcnt 发帖数量（论坛）
     */
    public void setPublishcnt(Integer publishcnt) {
        this.publishcnt = publishcnt;
    }

    /**
     * 获取回帖数量（论坛）
     *
     * @return ResponseCnt - 回帖数量（论坛）
     */
    public Integer getResponsecnt() {
        return responsecnt;
    }

    /**
     * 设置回帖数量（论坛）
     *
     * @param responsecnt 回帖数量（论坛）
     */
    public void setResponsecnt(Integer responsecnt) {
        this.responsecnt = responsecnt;
    }

    /**
     * @return Address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * @return Duty
     */
    public String getDuty() {
        return duty;
    }

    /**
     * @param duty
     */
    public void setDuty(String duty) {
        this.duty = duty == null ? null : duty.trim();
    }

    /**
     * 获取论坛中的星值
     *
     * @return StarCount - 论坛中的星值
     */
    public Integer getStarcount() {
        return starcount;
    }

    /**
     * 设置论坛中的星值
     *
     * @param starcount 论坛中的星值
     */
    public void setStarcount(Integer starcount) {
        this.starcount = starcount;
    }

    /**
     * @return IsVisible
     */
    public String getIsvisible() {
        return isvisible;
    }

    /**
     * @param isvisible
     */
    public void setIsvisible(String isvisible) {
        this.isvisible = isvisible == null ? null : isvisible.trim();
    }

    /**
     * @return ForumType
     */
    public String getForumtype() {
        return forumtype;
    }

    /**
     * @param forumtype
     */
    public void setForumtype(String forumtype) {
        this.forumtype = forumtype == null ? null : forumtype.trim();
    }

    /**
     * @return IdCard
     */
    public String getIdcard() {
        return idcard;
    }

    /**
     * @param idcard
     */
    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    /**
     * @return IdType
     */
    public String getIdtype() {
        return idtype;
    }

    /**
     * @param idtype
     */
    public void setIdtype(String idtype) {
        this.idtype = idtype == null ? null : idtype.trim();
    }

    /**
     * 获取生日
     *
     * @return BirthDate - 生日
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * 设置生日
     *
     * @param birthdate 生日
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return MobileNumber
     */
    public String getMobilenumber() {
        return mobilenumber;
    }

    /**
     * @param mobilenumber
     */
    public void setMobilenumber(String mobilenumber) {
        this.mobilenumber = mobilenumber == null ? null : mobilenumber.trim();
    }

    /**
     * 获取�ֻ�����
     *
     * @return PhoneNumber - �ֻ�����
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 设置�ֻ�����
     *
     * @param phonenumber �ֻ�����
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    /**
     * @return QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     */
    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    /**
     * @return MSN
     */
    public String getMsn() {
        return msn;
    }

    /**
     * @param msn
     */
    public void setMsn(String msn) {
        this.msn = msn == null ? null : msn.trim();
    }

    /**
     * 获取������ҳ
     *
     * @return PhPage - ������ҳ
     */
    public String getPhpage() {
        return phpage;
    }

    /**
     * 设置������ҳ
     *
     * @param phpage ������ҳ
     */
    public void setPhpage(String phpage) {
        this.phpage = phpage == null ? null : phpage.trim();
    }

    /**
     * @return Deskpic
     */
    public String getDeskpic() {
        return deskpic;
    }

    /**
     * @param deskpic
     */
    public void setDeskpic(String deskpic) {
        this.deskpic = deskpic == null ? null : deskpic.trim();
    }

    /**
     * @return UserImage
     */
    public String getUserimage() {
        return userimage;
    }

    /**
     * @param userimage
     */
    public void setUserimage(String userimage) {
        this.userimage = userimage == null ? null : userimage.trim();
    }

    /**
     * 获取��������
     *
     * @return Music - ��������
     */
    public String getMusic() {
        return music;
    }

    /**
     * 设置��������
     *
     * @param music ��������
     */
    public void setMusic(String music) {
        this.music = music == null ? null : music.trim();
    }

    /**
     * 获取1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     *
     * @return IsSee - 1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     */
    public Integer getIssee() {
        return issee;
    }

    /**
     * 设置1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     *
     * @param issee 1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     */
    public void setIssee(Integer issee) {
        this.issee = issee;
    }

    /**
     * 获取辅导答疑积分
     *
     * @return Qascore - 辅导答疑积分
     */
    public Integer getQascore() {
        return qascore;
    }

    /**
     * 设置辅导答疑积分
     *
     * @param qascore 辅导答疑积分
     */
    public void setQascore(Integer qascore) {
        this.qascore = qascore;
    }

    /**
     * 获取是否删除，0----否；1------是
     *
     * @return Flag - 是否删除，0----否；1------是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除，0----否；1------是
     *
     * @param flag 是否删除，0----否；1------是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取个人栏目数目
     *
     * @return forumPartNum - 个人栏目数目
     */
    public Integer getForumpartnum() {
        return forumpartnum;
    }

    /**
     * 设置个人栏目数目
     *
     * @param forumpartnum 个人栏目数目
     */
    public void setForumpartnum(Integer forumpartnum) {
        this.forumpartnum = forumpartnum;
    }

    /**
     * 获取个人论题数目
     *
     * @return forumTopicNum - 个人论题数目
     */
    public Integer getForumtopicnum() {
        return forumtopicnum;
    }

    /**
     * 设置个人论题数目
     *
     * @param forumtopicnum 个人论题数目
     */
    public void setForumtopicnum(Integer forumtopicnum) {
        this.forumtopicnum = forumtopicnum;
    }

    /**
     * 获取个人主题数目
     *
     * @return forumItemNum - 个人主题数目
     */
    public Integer getForumitemnum() {
        return forumitemnum;
    }

    /**
     * 设置个人主题数目
     *
     * @param forumitemnum 个人主题数目
     */
    public void setForumitemnum(Integer forumitemnum) {
        this.forumitemnum = forumitemnum;
    }

    /**
     * 获取个人回帖数目
     *
     * @return forumReItemNum - 个人回帖数目
     */
    public Integer getForumreitemnum() {
        return forumreitemnum;
    }

    /**
     * 设置个人回帖数目
     *
     * @param forumreitemnum 个人回帖数目
     */
    public void setForumreitemnum(Integer forumreitemnum) {
        this.forumreitemnum = forumreitemnum;
    }

    /**
     * 获取个人评论数目
     *
     * @return forumOpinionNum - 个人评论数目
     */
    public Integer getForumopinionnum() {
        return forumopinionnum;
    }

    /**
     * 设置个人评论数目
     *
     * @param forumopinionnum 个人评论数目
     */
    public void setForumopinionnum(Integer forumopinionnum) {
        this.forumopinionnum = forumopinionnum;
    }

    /**
     * 获取个人鲜花数目
     *
     * @return forumFlowerNum - 个人鲜花数目
     */
    public Integer getForumflowernum() {
        return forumflowernum;
    }

    /**
     * 设置个人鲜花数目
     *
     * @param forumflowernum 个人鲜花数目
     */
    public void setForumflowernum(Integer forumflowernum) {
        this.forumflowernum = forumflowernum;
    }

    /**
     * @return Resume
     */
    public String getResume() {
        return resume;
    }

    /**
     * @param resume
     */
    public void setResume(String resume) {
        this.resume = resume == null ? null : resume.trim();
    }
}