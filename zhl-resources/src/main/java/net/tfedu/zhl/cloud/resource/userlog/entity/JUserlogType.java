package net.tfedu.zhl.cloud.resource.userlog.entity;

import javax.persistence.*;

@Table(name = "j_userlog_type")
public class JUserlogType {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    /**
     * 除删标识
     */
    private Boolean flag;

    public JUserlogType(Long id, String code, String name, Boolean flag) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.flag = flag;
    }

    public JUserlogType() {
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
     * 获取编码
     *
     * @return code - 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置编码
     *
     * @param code
     *            编码
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name
     *            名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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