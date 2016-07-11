package net.tfedu.zhl.cloud.resource.userComment.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.asset.entity.FromFlagForReview;
import net.tfedu.zhl.cloud.resource.userComment.dao.UserCommentMapper;
import net.tfedu.zhl.cloud.resource.userComment.entity.UserComment;
import net.tfedu.zhl.cloud.resource.userComment.service.UserCommentService;
import net.tfedu.zhl.sso.user.dao.JUserMapper;

import org.hamcrest.core.IsCollectionContaining;
import org.springframework.stereotype.Service;

/**
 * 用户评论service
 * 
 * @author WeiCuicui
 *
 */
@Service("userCommentService")
public class UserCommentServiceImpl implements UserCommentService {

    @Resource
    UserCommentMapper userCommentMapper;
    
    @Resource JUserMapper jUserMapper;

    /**
     * 增加一条用户评论/评分
     */
    @Override
    public void insertUserComment(long resId, long userId, String displayContent, int ascore, int fromFlag,
            int isScore) {
        // 转换fromFlag同资源评论表中一致
        fromFlag = FromFlagForReview.getAtypeByFromFlag(fromFlag);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("resId", resId);
        map.put("userId", userId);
        
        map.put("ascore", ascore);
        map.put("fromFlag", fromFlag);
        map.put("isScore", isScore);

        if(isScore == 1){//若是评论
        	map.put("displayContent", displayContent);
        	userCommentMapper.insertMyComment(map);
        } 
        
        if(isScore == 0){//若是评分，则不插入评论信息
        	userCommentMapper.insertMyScore(map);
        }
    }

    /**
     *  修改用户评论
     */
    @Override
    public void updateUserComment(String displayContent, long commentId) {
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("displayContent", displayContent);
        map.put("commentId", commentId);
        userCommentMapper.updateComment(map);
    }

    /**
     * 删除用户评论
     */
    @Override
    public void deleteUserComment(long commentId) {
    	
    	
    	UserComment record = new UserComment();
    	record.setId(commentId);
    	record.setFlag(true);
        userCommentMapper.updateByPrimaryKeySelective(record);
    }

    /**
     * 查询我的评论
     */
    @Override
    public List<UserComment> getMyComments(int fromFlag, long resId, long userId) {

        // 转换fromFlag同资源评论表中一致
        fromFlag = FromFlagForReview.getAtypeByFromFlag(fromFlag);
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("fromFlag", fromFlag);
        map.put("resId", resId);
        map.put("userId", userId);
        
        //根据userId查询用户的truename
        String trueName = jUserMapper.getTrueNameById(userId);
        
        //查询我的评论
        List<UserComment> comments = userCommentMapper.getMyComments(map);

        for(int i = 0; i  < comments.size();i++){ 
        	comments.get(i).setUserName(trueName);
        }
        
        return comments;
    }

    /**
     *  查询他人评论
     */
    @Override
    public List<UserComment> getOtherComments(int fromFlag, long resId, long userId) {

        // 转换fromFlag同资源评论表中一致
        fromFlag = FromFlagForReview.getAtypeByFromFlag(fromFlag);
        HashMap<String, Object> map = new HashMap<String, Object>();

        map.put("fromFlag", fromFlag);
        map.put("resId", resId);
        map.put("userId", userId);
        
        //查询他人的评论
        List<UserComment> comments = userCommentMapper.getOtherComments(map);

        for(int i = 0; i  < comments.size();i++){ 
        	UserComment user = comments.get(i);
        	long uId = user.getUserid();
        	String trueName = jUserMapper.getTrueNameById(uId);
        	user.setUserName(trueName);
        }
        
        return comments;
    }

}
