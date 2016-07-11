package net.tfedu.zhl.sso.city.entity;

import javax.persistence.*;

@Table(name = "q_city")
public class City {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 省id（父节点）
     */
    @Column(name = "ProvinceId")
    private Integer provinceid;

    private String name;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    public City(Integer id, Integer provinceid, String name, Boolean flag) {
        this.id = id;
        this.provinceid = provinceid;
        this.name = name;
        this.flag = flag;
    }

    public City() {
        super();
    }

    /**
     * 获取自增id
     *
     * @return Id - 自增id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置自增id
     *
     * @param id 自增id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取省id（父节点）
     *
     * @return ProvinceId - 省id（父节点）
     */
    public Integer getProvinceid() {
        return provinceid;
    }

    /**
     * 设置省id（父节点）
     *
     * @param provinceid 省id（父节点）
     */
    public void setProvinceid(Integer provinceid) {
        this.provinceid = provinceid;
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
     * 获取是否删除标示，0-----未删除；1----删除
     *
     * @return Flag - 是否删除标示，0-----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标示，0-----未删除；1----删除
     *
     * @param flag 是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }
}