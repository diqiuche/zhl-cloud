package net.tfedu.zhl.sso.role.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "j_role")
public class JRole implements Serializable {
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 角色名
     */
    private String name;

    /**
     * 角色说明
     */
    private String description;

    /**
     * 系统模块
     */
    private String model;

    /**
     * 0-公共角色,1-子系统自定义角色
     */
    private Boolean tag;

    public JRole(Long id, String name, String description, String model, Boolean tag) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.model = model;
        this.tag = tag;
    }

    public JRole() {
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
     * 获取角色名
     *
     * @return name - 角色名
     */
    public String getName() {
        return name;
    }

    /**
     * 设置角色名
     *
     * @param name 角色名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取角色说明
     *
     * @return description - 角色说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置角色说明
     *
     * @param description 角色说明
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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
     * @param model 系统模块
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 获取0-公共角色,1-子系统自定义角色
     *
     * @return tag - 0-公共角色,1-子系统自定义角色
     */
    public Boolean getTag() {
        return tag;
    }

    /**
     * 设置0-公共角色,1-子系统自定义角色
     *
     * @param tag 0-公共角色,1-子系统自定义角色
     */
    public void setTag(Boolean tag) {
        this.tag = tag;
    }
}