package net.tfedu.zhl.cloud.teaching.teachCases.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "t_grade")
public class TGrade implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 年级名称
     */
    private String name;

    public TGrade(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TGrade() {
        super();
    }

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取年级名称
     *
     * @return name - 年级名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置年级名称
     *
     * @param name 年级名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}