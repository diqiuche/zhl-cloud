package net.tfedu.zhl.cloud.resource.navigation.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.navigation.entity.TreeNode;

/**
 * 目录树 service
 * 
 * @author WeiCuicui
 *
 */
public interface TreeService {


    /**
     * 根据提供的节点集合递归查询集合里每个节点的子节点，最终统一返回所有的子节点
     * 
     * @param topChildren
     *            是当前节点的直接子节点集合
     * @param resultTrees
     *            是最终返回的所有子节点集合
     * @return
     */
    public List<TreeNode> getAllChildren(TreeNode parentNode,List<TreeNode> topChildren, List<TreeNode> resultTrees);

    /**
     * 加载父结点及其所有的子结点
     * 
     * @return
     */
    public List<TreeNode> getTreeNodes(long pnodeId,String proCode);

}
