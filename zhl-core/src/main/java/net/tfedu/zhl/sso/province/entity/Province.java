package net.tfedu.zhl.sso.province.entity;

import javax.persistence.*;

@Table(name = "q_province")
public class Province {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * ʡ
     */
    @Column(name = "Code")
    private String code;

    /**
     * ʡ
     */
    @Column(name = "Name")
    private String name;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    @Column(name = "Flag")
    private Boolean flag;

    public Province(Long id, String code, String name, Boolean flag) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.flag = flag;
    }

    public Province() {
        super();
    }

    /**
     * @return Id
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
     * 获取ʡ
     *
     * @return Code - ʡ
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置ʡ
     *
     * @param code ʡ
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 获取ʡ
     *
     * @return Name - ʡ
     */
    public String getName() {
        return name;
    }

    /**
     * 设置ʡ
     *
     * @param name ʡ
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