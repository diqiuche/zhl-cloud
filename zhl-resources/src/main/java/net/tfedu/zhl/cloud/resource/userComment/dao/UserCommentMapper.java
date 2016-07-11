package net.tfedu.zhl.cloud.resource.userComment.dao;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.userComment.entity.UserComment;
import net.tfedu.zhl.helper.CoreMapper;

public interface UserCommentMapper extends CoreMapper<UserComment> {

    /**
     *  插入一条评论
     * @param map
     */
    public void insertMyComment(HashMap<String, Object> map);
    
    /**
     * 插入一个评分
     * @param map
     */
    public void insertMyScore(HashMap<String, Object> map);

    /**
     * 修改我的评论
     * @param map
     */
    public void updateComment(HashMap<String, Object> map);

    /**
     *  删除我的评论
     * @param commentId
     */
    public void deleteComment(long commentId);

    /**
     * 查询我的评论
     * @param map
     * @return
     */
    public List<UserComment> getMyComments(HashMap<String, Object> map);

    /**
     * 查询我的评论
     * @param map
     * @return
     */
    public List<UserComment> getOtherComments(HashMap<String, Object> map);

}