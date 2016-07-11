package net.tfedu.zhl.cloud.resource.prepare.entity;

import java.io.Serializable;

/**
 * 前端展示的（部分）备课夹信息
 * 
 * @author wangwr
 *
 */
public class JPrepareView implements Serializable {

    /**
     * id
     */
    private Long id;

    /**
     * 标题
     */
    private String title;

    /**
     * 时间范围
     */
    private String timeLabel;
    
    
    /**
     * 内容（资源）条数
     */
    private Integer contentNumber;
    
    
    
    

    public Integer getContentNumber() {
		return contentNumber;
	}

	public void setContentNumber(Integer contentNumber) {
		this.contentNumber = contentNumber;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTimeLabel() {
        return timeLabel;
    }

    public void setTimeLabel(String timeLabel) {
        this.timeLabel = timeLabel;
    }

    @Override
    public String toString() {
        return "[ prepareView: { id:" + this.id + "; title:" + title + ";timeLabel:" + timeLabel + ";contentNumber:" + contentNumber+ " } ]";
    }

}
