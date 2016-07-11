package net.tfedu.zhl.cloud.resource.prepare.entity;

/**
 * 用户备课夹统计
 * 
 * @author wangwr
 *
 */
public class UserPrepareStatisInfo {

    /**
     * 备课使用的教材的code
     */
    String tfcode;
    /**
     * 备课使用的教材的标题
     */
    String title;

    /**
     * 该教材中的备课夹数目
     */
    Integer prepareNums;

    /**
     * 该教材备课夹使用的资源数目
     */
    Integer resourceNums;

    /**
     * 该教材已经创建备课夹的叶节点（无子节点）数目
     */
    Integer nodeFinishedNums;

    /**
     * 该教材叶节点（无子节点）中没有备课夹的数目
     */
    Integer nodeOmitNums;

    public String getTfcode() {
        return tfcode;
    }

    public void setTfcode(String tfcode) {
        this.tfcode = tfcode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrepareNums() {
        return prepareNums;
    }

    public void setPrepareNums(Integer prepareNums) {
        this.prepareNums = prepareNums;
    }

    public Integer getResourceNums() {
        return resourceNums;
    }

    public void setResourceNums(Integer resourceNums) {
        this.resourceNums = resourceNums;
    }

    public Integer getNodeFinishedNums() {
        return nodeFinishedNums;
    }

    public void setNodeFinishedNums(Integer nodeFinishedNums) {
        this.nodeFinishedNums = nodeFinishedNums;
    }

    public Integer getNodeOmitNums() {
        return nodeOmitNums;
    }

    public void setNodeOmitNums(Integer nodeOmitNums) {
        this.nodeOmitNums = nodeOmitNums;
    }

}
