package net.tfedu.zhl.cloud.teaching.videoCourses.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_videotype")
public class TVideoType implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 视频课程类型名称
     */
    private String name;

    public TVideoType(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TVideoType() {
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
     * 获取视频课程类型名称
     *
     * @return name - 视频课程类型名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置视频课程类型名称
     *
     * @param name 视频课程类型名称
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}