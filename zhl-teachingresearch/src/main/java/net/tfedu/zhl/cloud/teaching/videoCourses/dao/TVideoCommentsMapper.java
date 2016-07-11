package net.tfedu.zhl.cloud.teaching.videoCourses.dao;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoComments;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

/**
 * 视频课程的评论相关
 * @author WeiCuicui
 *
 */
public interface TVideoCommentsMapper extends CoreMapper<TVideoComments> {
	
	/**
	 * 插入一条评论
	 * @param userId
	 * @param videoId
	 */
	public void insertOneComment(@Param("content")String comment,@Param("videoId")long videoId,@Param("userId")long userId);
	
	/**
	 * 插入一条评分
	 * @param level
	 * @param videoId
	 * @param userId
	 */
	public void insertOneCommentLevel(@Param("score")int score,@Param("videoId")long videoId,@Param("userId")long userId);

	/**
	 * 查询一个视频课程的所有评论
	 * @return
	 */
	public List<TVideoComments> getAllComments(@Param("videoId") long videoId);
	
	/**
	 * 编辑一个评论
	 * @param content
	 * @param commentId
	 */
	public void editOneComment(@Param("content")String content,@Param("id")long commentId);
	
	/**
	 * 删除一条评论信息
	 * @param commentId
	 */
	public void deleteOneComment(@Param("id")long commentId);

}