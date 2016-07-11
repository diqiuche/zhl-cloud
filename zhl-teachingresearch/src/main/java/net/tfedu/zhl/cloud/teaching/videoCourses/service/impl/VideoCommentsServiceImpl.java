package net.tfedu.zhl.cloud.teaching.videoCourses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.videoCourses.dao.TVideoCommentsMapper;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoComments;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoCommentsService;
import net.tfedu.zhl.helper.PaginationHelper;
import net.tfedu.zhl.sso.user.dao.JUserMapper;
import net.tfedu.zhl.sso.user.entity.JUser;
import net.tfedu.zhl.sso.user.entity.UserSimple;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 视频课程评论的相关接口
 * @author WeiCuicui
 *
 */
@Service("videoCommentsService")
public class VideoCommentsServiceImpl implements VideoCommentsService{
	
	@Resource TVideoCommentsMapper tVideoCommentsMapper;
	
	@Resource JUserMapper jUserMapper;
	
	/**
	 * 插入一条用户评论信息
	 * @param videoId
	 * @param comment
	 * @param userId
	 */
	public void insertOneComment(long videoId,String comment,int isScore,long userId){
		
		if(isScore == 0){ //评论
			tVideoCommentsMapper.insertOneComment(comment, videoId, userId);
		} else { //评分
			int score = Integer.parseInt(comment.trim());
			tVideoCommentsMapper.insertOneCommentLevel(score, videoId, userId);
		}
	}
	
	/**
	 * 查询一个视频课程的所有评论
	 * @param videoId  课程id
	 * @param page
	 * @param perPage
	 */
	public PaginationHelper<TVideoComments> getAllComments(long videoId,int page,int perPage){
		
		PageHelper.startPage(page,perPage);
		
		List<TVideoComments> list = tVideoCommentsMapper.getAllComments(videoId);
		
		for(int i = 0; i < list.size(); i++){
			TVideoComments item = list.get(i);
			long userId = item.getUserid();
			
			//根据用户id，查询其真实姓名、所在学校，用户头像路径
			UserSimple user = jUserMapper.getUserSimpleById(userId);
			item.setTrueName(user.getTrueName());
			item.setUserSchool(user.getSchoolName());
			item.setUserImage(user.getUserImage());
			
		}
		
		return PaginationHelper.transfer(list);
	}
	
	/**
	 * 编辑一个评论
	 * @param content
	 * @param videoId
	 */
	public void editOneComment(String content,long commentId){
		tVideoCommentsMapper.editOneComment(content, commentId);
	}
	
	/**
	 * 删除一条评论信息
	 * @param commentId
	 */
	public void deleteOneComment(long commentId){
		tVideoCommentsMapper.deleteOneComment(commentId);
	}
}
