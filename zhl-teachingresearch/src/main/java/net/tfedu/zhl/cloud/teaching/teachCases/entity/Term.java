package net.tfedu.zhl.cloud.teaching.teachCases.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "t_term")
public class Term implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学段名称
     */
    private String name;

    public Term(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Term() {
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
     * 获取学段名称
     *
     * @return name - 学段名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学段名称
     *
     * @param name 学段名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}