package net.tfedu.zhl.sso.users.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "j_group")
public class Group {
    /**
     * 编号
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 系统模块
     */
    private String model;

    /**
     * 0-公共1-子系统自定义
     */
    private Boolean tag;

    public Group(Long id, String name, String model, Boolean tag) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.tag = tag;
    }

    public Group() {
        super();
    }

    /**
     * 获取编号
     *
     * @return id - 编号
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置编号
     *
     * @param id
     *            编号
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取系统模块
     *
     * @return model - 系统模块
     */
    public String getModel() {
        return model;
    }

    /**
     * 设置系统模块
     *
     * @param model
     *            系统模块
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取0-公共1-子系统自定义
     *
     * @return tag - 0-公共1-子系统自定义
     */
    public Boolean getTag() {
        return tag;
    }

    /**
     * 设置0-公共1-子系统自定义
     *
     * @param tag
     *            0-公共1-子系统自定义
     */
    public void setTag(Boolean tag) {
        this.tag = tag;
    }
}