package net.tfedu.zhl.cloud.resource.userComment.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.userComment.entity.UserComment;

public interface UserCommentService {

    /**
     * 增加一条用户评论 / 评分
     * @param resId
     * @param userId
     * @param displayContent
     * @param score
     * @param fromFlag
     * @param isScore
     */
    public void insertUserComment(long resId, long userId, String displayContent, int score, int fromFlag, int isScore);

    /**
     * 修改用户评论
     * @param displayContent
     * @param commentId
     */
    public void updateUserComment(String displayContent, long commentId);

    /**
     * 删除用户评论
     * @param commentId
     */
    public void deleteUserComment(long commentId);

    /**
     * 查询我的评论
     * @param fromFlag
     * @param resId
     * @param userId
     * @return
     */
    public List<UserComment> getMyComments(int fromFlag, long resId, long userId);

    /**
     * 查询他人评论
     * @param fromFlag
     * @param resId
     * @param userId
     * @return
     */
    public List<UserComment> getOtherComments(int fromFlag, long resId, long userId);

}
