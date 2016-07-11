package net.tfedu.zhl.cloud.resource.navigation.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.dao.JSyscourseMapper;
import net.tfedu.zhl.cloud.resource.navigation.entity.TreeNode;
import net.tfedu.zhl.cloud.resource.navigation.service.TreeService;

import org.springframework.stereotype.Service;

/**
 * 目录树 serviceImpl
 * 
 * @author WeiCuicui
 *
 */
@Service("sysCourseTreeService")
public class TreeServiceImpl implements TreeService {

    @Resource
    JSyscourseMapper jSyscourseMapper;
    
    /**
     * 根据提供的节点集合递归查询集合里每个节点的子节点，最终统一返回所有的子节点
     * @param parentNode
     *     父结点
     * @param topChildren
     *     是当前节点的直接子节点集合
     * @param resultTrees
     *     是最终返回的所有子节点集合
     * @return
     */
    @Override
    public List<TreeNode> getAllChildren(TreeNode parentNode,List<TreeNode> topChildren, List<TreeNode> resultTrees) {
        for (int i = 0; i < topChildren.size(); i++) {
            TreeNode node = topChildren.get(i);


            // 如果当前节点是叶子节点，跳过不进行递归查询子节点
            if (node.isLeaf()) {
                continue;
            }
            
            // 设置当前结点属于第几个结点
            int sort = i + 1;
            node.setI(parentNode.getI() + "." + sort );

            // 查询children
            List<TreeNode> children = jSyscourseMapper.getTopChildrenResultMap(node.getId());
            if (children == null || children.size() == 0) {
                node.setLeaf(true);
            } else {
                // 设置children
                node.setChildren(children);
            }

            // 递归调用
            getAllChildren(node,children, resultTrees);
        }

        return resultTrees;
    }

    /**
     * 加载父结点及其所有的子结点
     * 
     * @return
     */
    @Override
    public List<TreeNode> getTreeNodes(long pnodeId,String proCode) {

        // 查询父结点下的直接子结点
        List<TreeNode> topChildren = jSyscourseMapper.getOneCourseInfo(pnodeId,proCode);
        
        //父结点及其所有的子结点
        List<TreeNode> resultNodes = new ArrayList<TreeNode>();

        // 查询所有的子结点
        for (int i = 0; i < topChildren.size(); i++) {
            TreeNode node = topChildren.get(i);

            // 加入到结果集中
            resultNodes.add(node);

            // 如果当前节点是叶子节点，跳过不进行递归查询子节点
            if (node.isLeaf()) {
                continue;
            }
            
            // 设置当前结点属于第几个结点
            int sort = i + 1;
            node.setI(sort + "");

            // 查询children
            List<TreeNode> children = jSyscourseMapper.getTopChildrenResultMap(node.getId());
            if (children == null || children.size() == 0) {
                node.setLeaf(true);
            } else {
                // 设置children
                node.setChildren(children);
            }

            // 递归调用，node是父结点
            getAllChildren(node,children, resultNodes);
        }

        return resultNodes;
    }
}