package net.tfedu.zhl.cloud.teaching.videoCourses.service;

import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoResources;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.VideoPreviewEntity;
import net.tfedu.zhl.helper.PaginationHelper;



/**
 * 视频课程的service
 * @author WeiCuicui
 *
 */
public interface VideoCoursesService {

	/**
	 * 分页查询视频课程资源
	 * @param fromFlag 所属平台：0 双课堂；1 资源中心
	 * @param typeId  视频类型
	 * @param subjectId  学科类型
	 * @param orderBy 排序方式
	 * @param page  当前页
	 * @param perPage 每页记录数
	 * @param userId
	 * @return
	 */
	public PaginationHelper<TVideoResources> getAllVideoCourses(int fromFlag,int typeId,int subjectId,int orderBy,int page,int perPage,long userId);
	
	/**
	 * 一条视频课程的预览信息
	 * @param videoId
	 * @param userId
	 * @return
	 */
	public VideoPreviewEntity getOneVideoCourse(long videoId,long userId);
	
	/**
	 * 新建一个视频课程
	 * @param video   json格式的视频课程info
	 * @param userId  当前用户id
	 */
	public void insertOneVideoCourse(String video,long userId);
	
	/**
	 * 编辑一个视频课程
	 * @param video    json格式的视频课程info
	 * @param userId   当前用户id
	 */
	public void editOneVideoCourse(String video,long userId);
	
	/**
	 * 批量删除视频课程
	 * @param ids  要删除的视频课程id集合
	 */
	public void delVideoCourses(String ids);
	
	/**
	 * 根据输入的关键字检索视频课程
	 * @param keyWord
	 * @param fromFlag
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PaginationHelper<TVideoResources> getVideoSearchResults(String keyWord,int fromFlag,int orderBy,int page,int perPage);

    /**
     * 插入一条视频课程预览信息
     * @param userId
     * @param videoId
     */
	public void addOneVisitItem(long userId,long videoId);
}
