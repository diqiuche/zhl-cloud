package net.tfedu.zhl.sso.term.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "j_term")
public class JTerm implements Serializable {
    /**
     * 自增id
     */
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 学段名称
     */
    @Column(name = "Name")
    private String name;

    /**
     * 备注
     */
    @Column(name = "Notes")
    private String notes;

    /**
     * 是否删除标示，0-----未删除；1----删除
     */
    private Boolean flag;

    private String code;

    public JTerm(Long id, String name, String notes, Boolean flag, String code) {
        this.id = id;
        this.name = name;
        this.notes = notes;
        this.flag = flag;
        this.code = code;
    }

    public JTerm() {
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
     * 获取学段名称
     *
     * @return Name - 学段名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学段名称
     *
     * @param name
     *            学段名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 获取备注
     *
     * @return Notes - 备注
     */
    public String getNotes() {
        return notes;
    }

    /**
     * 设置备注
     *
     * @param notes
     *            备注
     */
    public void setNotes(String notes) {
        this.notes = notes == null ? null : notes.trim();
    }

    /**
     * 获取是否删除标示，0-----未删除；1----删除
     *
     * @return flag - 是否删除标示，0-----未删除；1----删除
     */
    public Boolean getFlag() {
        return flag;
    }

    /**
     * 设置是否删除标示，0-----未删除；1----删除
     *
     * @param flag
     *            是否删除标示，0-----未删除；1----删除
     */
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    /**
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}