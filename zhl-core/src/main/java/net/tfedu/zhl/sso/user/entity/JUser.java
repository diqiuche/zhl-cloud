package net.tfedu.zhl.sso.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import net.tfedu.zhl.sso.role.entity.JRole;
import net.tfedu.zhl.sso.school.entity.JSchool;
import net.tfedu.zhl.sso.subject.entity.JSubject;
import net.tfedu.zhl.sso.term.entity.JTerm;

/**
 * 用户
 * 
 * @author wangwr
 *
 */
@Table(name = "j_user")
public class JUser implements Serializable {
    /**
     * 非自增的主键id，来保存sso中registerId
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "RoleId")
    private String roleid;

    /**
     * scoket聊天id
     */
    @Column(name = "ChannelId")
    private Long channelid;

    /**
     * 标识是否限制聊天，0------不限制；1-------限制
     */
    @Column(name = "ChannelLimit")
    private Long channellimit;

    /**
     * 最后登录时间
     */
    @Column(name = "LoginTime")
    private Date logintime;

    /**
     * 退出时间
     */
    @Column(name = "LogoutTime")
    private Date logouttime;

    @Column(name = "SchoolId")
    private Long schoolid;

    @Column(name = "TrueName")
    private String truename;

    @Column(name = "NickName")
    private String nickname;

    /**
     * 1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     */
    @Column(name = "IsSee")
    private Integer issee;

    /**
     * （true或1)女 （false或0）男
     */
    @Column(name = "Male")
    private Boolean male;

    /**
     * 是否删除标识，0----否；1-----是
     */
    @Column(name = "Flag")
    private Boolean flag;

    /**
     * web登录时间
     */
    @Column(name = "webLoginTime")
    private Date weblogintime;

    /**
     * web退出时间
     */
    @Column(name = "webLogoutTime")
    private Date weblogouttime;

    /**
     * 上一次查看论题消息的时间
     * 
     */
    @Column(name = "forumLastSeeTime")
    private Date forumlastseetime;

    /**
     * 上一次查看论题消息的时间
     * 
     */
    @Column(name = "qaLastSeeTime")
    private Date qalastseetime;

    /**
     * 学期
     */
    @Column(name = "studyTermId")
    private Long studytermid;

    /**
     * 用户是否停用 0启用 1停用
     */
    private Integer status;

    /**
     * 用户查看的最后提示ID
     */
    @Column(name = "lastTipId")
    private Long lasttipid;

    /**
     * 级年 1一年级 2二年级 3三年级 4四年级 5五年级 6六年级 7七年级 8八年级 9九年级 10十年级 11十一年级 12十二年级
     */
    private Integer grade;

    @Column(name = "isFirstLogin")
    private Boolean isfirstlogin;

    /**
     * 用户角色
     */
    private String roleName;

    /**
     * 用户学段
     */
    private String termName;

    private Long termId;

    /**
     * 用户学校
     */
    private String schoolName;

    /**
     * 获取用户学科ids
     */
    private String subjectIds;

    /**
     * 获取用户学科
     */
    private String subjectNames;

    public JUser(Long id, String name, String roleid, Long channelid, Long channellimit, Date logintime,
            Date logouttime, Long schoolid, String truename, String nickname, Integer issee, Boolean male, Boolean flag,
            Date weblogintime, Date weblogouttime, Date forumlastseetime, Date qalastseetime, Long studytermid,
            Integer status, Long lasttipid, Integer grade, Boolean isfirstlogin) {
        this.id = id;
        this.name = name;
        this.roleid = roleid;
        this.channelid = channelid;
        this.channellimit = channellimit;
        this.logintime = logintime;
        this.logouttime = logouttime;
        this.schoolid = schoolid;
        this.truename = truename;
        this.nickname = nickname;
        this.issee = issee;
        this.male = male;
        this.flag = flag;
        this.weblogintime = weblogintime;
        this.weblogouttime = weblogouttime;
        this.forumlastseetime = forumlastseetime;
        this.qalastseetime = qalastseetime;
        this.studytermid = studytermid;
        this.status = status;
        this.lasttipid = lasttipid;
        this.grade = grade;
        this.isfirstlogin = isfirstlogin;
    }

    public JUser() {
        super();
    }

    /**
     * 获取非自增的主键id，来保存sso中registerId
     *
     * @return Id - 非自增的主键id，来保存sso中registerId
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置非自增的主键id，来保存sso中registerId
     *
     * @param id
     *            非自增的主键id，来保存sso中registerId
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * @return RoleId
     */
    public String getRoleid() {
        return roleid;
    }

    /**
     * @param roleid
     */
    public void setRoleid(String roleid) {
        this.roleid = roleid == null ? null : roleid.trim();
    }

    /**
     * 获取scoket聊天id
     *
     * @return ChannelId - scoket聊天id
     */
    public Long getChannelid() {
        return channelid;
    }

    /**
     * 设置scoket聊天id
     *
     * @param channelid
     *            scoket聊天id
     */
    public void setChannelid(Long channelid) {
        this.channelid = channelid;
    }

    /**
     * 获取标识是否限制聊天，0------不限制；1-------限制
     *
     * @return ChannelLimit - 标识是否限制聊天，0------不限制；1-------限制
     */
    public Long getChannellimit() {
        return channellimit;
    }

    /**
     * 设置标识是否限制聊天，0------不限制；1-------限制
     *
     * @param channellimit
     *            标识是否限制聊天，0------不限制；1-------限制
     */
    public void setChannellimit(Long channellimit) {
        this.channellimit = channellimit;
    }

    /**
     * 获取最后登录时间
     *
     * @return LoginTime - 最后登录时间
     */
    public Date getLogintime() {
        return logintime;
    }

    /**
     * 设置最后登录时间
     *
     * @param logintime
     *            最后登录时间
     */
    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }

    /**
     * 获取退出时间
     *
     * @return LogoutTime - 退出时间
     */
    public Date getLogouttime() {
        return logouttime;
    }

    /**
     * 设置退出时间
     *
     * @param logouttime
     *            退出时间
     */
    public void setLogouttime(Date logouttime) {
        this.logouttime = logouttime;
    }

    /**
     * @return SchoolId
     */
    public Long getSchoolid() {
        return schoolid;
    }

    /**
     * @param schoolid
     */
    public void setSchoolid(Long schoolid) {
        this.schoolid = schoolid;
    }

    /**
     * @return TrueName
     */
    public String getTruename() {
        return truename;
    }

    /**
     * @param truename
     */
    public void setTruename(String truename) {
        this.truename = truename == null ? null : truename.trim();
    }

    /**
     * @return NickName
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
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
     * @param issee
     *            1为只有我自己可见，2为只有我的好友可见，3好友及同学校的人可见，4为所有人可见
     */
    public void setIssee(Integer issee) {
        this.issee = issee;
    }

    /**
     * 获取（true或1)女 （false或0）男
     *
     * @return Male - （true或1)女 （false或0）男
     */
    public Boolean getMale() {
        return male;
    }

    /**
     * 设置（true或1)女 （false或0）男
     *
     * @param male
     *            （true或1)女 （false或0）男
     */
    public void setMale(Boolean male) {
        this.male = male;
    }

    /**
     * 获取是否删除标识，0----否；1-----是
     *
     * @return Flag - 是否删除标识，0----否；1-----是
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标识，0----否；1-----是
     *
     * @param flag
     *            是否删除标识，0----否；1-----是
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * 获取web登录时间
     *
     * @return webLoginTime - web登录时间
     */
    public Date getWeblogintime() {
        return weblogintime;
    }

    /**
     * 设置web登录时间
     *
     * @param weblogintime
     *            web登录时间
     */
    public void setWeblogintime(Date weblogintime) {
        this.weblogintime = weblogintime;
    }

    /**
     * 获取web退出时间
     *
     * @return webLogoutTime - web退出时间
     */
    public Date getWeblogouttime() {
        return weblogouttime;
    }

    /**
     * 设置web退出时间
     *
     * @param weblogouttime
     *            web退出时间
     */
    public void setWeblogouttime(Date weblogouttime) {
        this.weblogouttime = weblogouttime;
    }

    /**
     * 获取上一次查看论题消息的时间
     *
     * 
     * @return forumLastSeeTime - 上一次查看论题消息的时间
     * 
     */
    public Date getForumlastseetime() {
        return forumlastseetime;
    }

    /**
     * 设置上一次查看论题消息的时间
     *
     * 
     * @param forumlastseetime
     *            上一次查看论题消息的时间
     * 
     */
    public void setForumlastseetime(Date forumlastseetime) {
        this.forumlastseetime = forumlastseetime;
    }

    /**
     * 获取上一次查看论题消息的时间
     *
     * 
     * @return qaLastSeeTime - 上一次查看论题消息的时间
     * 
     */
    public Date getQalastseetime() {
        return qalastseetime;
    }

    /**
     * 设置上一次查看论题消息的时间
     *
     * 
     * @param qalastseetime
     *            上一次查看论题消息的时间
     * 
     */
    public void setQalastseetime(Date qalastseetime) {
        this.qalastseetime = qalastseetime;
    }

    /**
     * 获取学期
     *
     * @return studyTermId - 学期
     */
    public Long getStudytermid() {
        return studytermid;
    }

    /**
     * 设置学期
     *
     * @param studytermid
     *            学期
     */
    public void setStudytermid(Long studytermid) {
        this.studytermid = studytermid;
    }

    /**
     * 获取用户是否停用 0启用 1停用
     *
     * @return status - 用户是否停用 0启用 1停用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户是否停用 0启用 1停用
     *
     * @param status
     *            用户是否停用 0启用 1停用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取用户查看的最后提示ID
     *
     * @return lastTipId - 用户查看的最后提示ID
     */
    public Long getLasttipid() {
        return lasttipid;
    }

    /**
     * 设置用户查看的最后提示ID
     *
     * @param lasttipid
     *            用户查看的最后提示ID
     */
    public void setLasttipid(Long lasttipid) {
        this.lasttipid = lasttipid;
    }

    /**
     * 获取级年 1一年级 2二年级 3三年级 4四年级 5五年级 6六年级 7七年级 8八年级 9九年级 10十年级 11十一年级 12十二年级
     *
     * @return grade - 级年 1一年级 2二年级 3三年级 4四年级 5五年级 6六年级 7七年级 8八年级 9九年级 10十年级
     *         11十一年级 12十二年级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 设置级年 1一年级 2二年级 3三年级 4四年级 5五年级 6六年级 7七年级 8八年级 9九年级 10十年级 11十一年级 12十二年级
     *
     * @param grade
     *            级年 1一年级 2二年级 3三年级 4四年级 5五年级 6六年级 7七年级 8八年级 9九年级 10十年级 11十一年级
     *            12十二年级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * @return isFirstLogin
     */
    public Boolean getIsfirstlogin() {
        return isfirstlogin;
    }

    /**
     * @param isfirstlogin
     */
    public void setIsfirstlogin(Boolean isfirstlogin) {
        this.isfirstlogin = isfirstlogin;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(String subjectIds) {
        this.subjectIds = subjectIds;
    }

    public String getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(String subjectNames) {
        this.subjectNames = subjectNames;
    }

}