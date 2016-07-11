package net.tfedu.zhl.cloud.teaching.teachCases.entity;

import java.io.Serializable;

import javax.persistence.*;

@Table(name = "t_subject")
public class TSubject implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 学科名称
     */
    private String name;

    public TSubject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TSubject() {
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
     * 获取学科名称
     *
     * @return name - 学科名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置学科名称
     *
     * @param name 学科名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}