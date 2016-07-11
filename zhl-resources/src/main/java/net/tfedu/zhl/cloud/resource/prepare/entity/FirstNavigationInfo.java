package net.tfedu.zhl.cloud.resource.prepare.entity;

import java.io.Serializable;

/**
 * 系统资源的第一个关联节点的信息
 * 
 * @author wangwr
 *
 */
public class FirstNavigationInfo implements Serializable {
    /**
     * 节点的标题
     */
    private String title;

    /**
     * 节点的编码
     */
    private String tfcode;

    /**
     * 资源id
     */
    private Long resId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTfcode() {
        return tfcode;
    }

    public void setTfcode(String tfcode) {
        this.tfcode = tfcode;
    }

    public Long getResId() {
        return resId;
    }

    public void setResId(Long resId) {
        this.resId = resId;
    }

}
