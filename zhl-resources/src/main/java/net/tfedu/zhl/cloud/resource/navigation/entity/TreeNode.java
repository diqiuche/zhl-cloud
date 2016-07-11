package net.tfedu.zhl.cloud.resource.navigation.entity;

import java.io.Serializable;
import java.util.List;

/**
 * 定义treeNode
 * 
 * @author WeiCuicui
 *
 */
public class TreeNode implements Serializable {
    private static final long serialVersionUID = 8160030266758656476L;

    // 主键id
    private Long id;

    // 节点名称
    private String label;

    // 是否为叶子节点(即没有子节点)
    private boolean leaf;

    // 子节点集合
    private List<TreeNode> children;

    // 当前层的第几个结点
    private String i;

    // 结点的tfcode
    private String tfcode;

    public String getTfcode() {
        return tfcode;
    }

    public void setTfcode(String tfcode) {
        this.tfcode = tfcode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    /**
     * 提供toString方法，方便单元测试时，直接输出对象。
     */
    @Override
    public String toString() {
        return "TreeNode [id=" + id + ", label=" + label + ", i=" + i + ", leaf=" + leaf + ", children=" + children
                + "]";

    }
}
