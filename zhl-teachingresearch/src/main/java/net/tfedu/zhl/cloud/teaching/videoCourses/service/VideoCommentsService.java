package net.tfedu.zhl.cloud.teaching.videoCourses.service;

import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoComments;
import net.tfedu.zhl.helper.PaginationHelper;

public interface VideoCommentsService {

	/**
	 * 插入一条用户评论信息
	 * @param videoId
	 * @param comment
	 * @param userId
	 */
	public void insertOneComment(long videoId,String comment,int isScore,long userId);
	
	/**
	 * 查询一个视频课程的所有评论
	 * @param videoId  课程id
	 * @param page
	 * @param perPage
	 */
	public PaginationHelper<TVideoComments> getAllComments(long videoId,int page,int perPage);
	
	/**
	 * 编辑一个评论
	 * @param content
	 * @param videoId
	 */
	public void editOneComment(String content,long commentId);
	
	/**
	 * 删除一条评论信息
	 * @param commentId
	 */
	public void deleteOneComment(long commentId);
}
