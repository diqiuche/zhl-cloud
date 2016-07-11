package net.tfedu.zhl.cloud.resource.userlog.entity;

import javax.persistence.*;

@Table(name = "j_useroper")
public class JUserOper {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作类型编码
     */
    private String code;

    /**
     * 操作名称
     */
    private String name;

    /**
     * 0 前台 1 后台
     */
    private Integer isflag;

    /**
     * 除删标识
     */
    private Boolean flag;

    public JUserOper(Long id, String code, String name, Integer isflag, Boolean flag) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.isflag = isflag;
        this.flag = flag;
    }

    public JUserOper() {
        super();
    }

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id
     *            主键
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取操作类型编码
     *
     * @return code - 操作类型编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置操作类型编码
     *
     * @param code
     *            操作类型编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取操作名称
     *
     * @return name - 操作名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置操作名称
     *
     * @param name
     *            操作名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取0 前台 1 后台
     *
     * @return isflag - 0 前台 1 后台
     */
    public Integer getIsflag() {
        return isflag;
    }

    /**
     * 设置0 前台 1 后台
     *
     * @param isflag
     *            0 前台 1 后台
     */
    public void setIsflag(Integer isflag) {
        this.isflag = isflag;
    }

    /**
     * 获取除删标识
     *
     * @return flag - 除删标识
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置除删标识
     *
     * @param flag
     *            除删标识
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}