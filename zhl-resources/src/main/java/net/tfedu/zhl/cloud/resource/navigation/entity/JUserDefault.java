package net.tfedu.zhl.cloud.resource.navigation.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 用户历史选择信息实体类
 * @author WeiCuicui
 *
 */
@Table(name = "j_syscourse_user_default")
public class JUserDefault implements Serializable {
    private static final long serialVersionUID = 8160030266758656476L;
    /**
     * 主键id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "userId")
    private Long userid;

    /**
     * 默认资源目录code
     */
    private String tfcode;

    // 用户历史选择学段
    @Transient
    private Long termId;

    // 用户历史选择学科
    @Transient
    private Long subjectId;

    // 用户历史选择版本
    @Transient
    private Long editionId;

    // 用户历史选择教材
    @Transient
    private Long bookId;

    /**
     * 资源目录类型 1、系统教学资源目录 2、自建目录
     */
    private Integer type;

    @Column(name = "createTime")
    private Date createtime;

    private Boolean flag;

    public JUserDefault(Long id, Long userid, String tfcode, Integer type, Date createtime, Boolean flag) {
        this.id = id;
        this.userid = userid;
        this.tfcode = tfcode;
        this.type = type;
        this.createtime = createtime;
        this.flag = flag;
    }

    public JUserDefault() {
        super();
    }

    /**
     * 获取主键id
     *
     * @return id - 主键id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键id
     *
     * @param id
     *            主键id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return userId - 用户id
     */
    public Long getUserid() {
        return userid;
    }

    /**
     * 设置用户id
     *
     * @param userid
     *            用户id
     */
    public void setUserid(Long userid) {
        this.userid = userid;
    }

    /**
     * 获取默认资源目录code
     *
     * @return tfcode - 默认资源目录code
     */
    public String getTfcode() {
        return tfcode;
    }

    /**
     * 设置默认资源目录code
     *
     * @param tfcode
     *            默认资源目录code
     */
    public void setTfcode(String tfcode) {
        this.tfcode = tfcode == null ? null : tfcode.trim();
    }

    /**
     * 获取资源目录类型 1、系统教学资源目录 2、自建目录
     *
     * @return type - 资源目录类型 1、系统教学资源目录 2、自建目录
     */
    public Integer getType() {
        return type;
    }

    /**
     * 设置资源目录类型 1、系统教学资源目录 2、自建目录
     *
     * @param type
     *            资源目录类型 1、系统教学资源目录 2、自建目录
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * @return createTime
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
     * @return flag
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * @param flag
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Long getTermId() {
        return termId;
    }

    public void setTermId(Long termId) {
        this.termId = termId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getEditionId() {
        return editionId;
    }

    public void setEditionId(Long editionId) {
        this.editionId = editionId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Override
    public String toString() {
        return "userDefault[Id: + " + id + " + ,tfcode: + " + tfcode + " + ,termId: + " + termId
                + " + ,subjectId: + " + subjectId + " + ,editionid: + " + editionId + " + ,bookId: + " + bookId + "]";
    }
}
