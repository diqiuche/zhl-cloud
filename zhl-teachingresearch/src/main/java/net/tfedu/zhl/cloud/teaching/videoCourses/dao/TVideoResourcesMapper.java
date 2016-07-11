package net.tfedu.zhl.cloud.teaching.videoCourses.dao;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoResources;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.VideoPreviewEntity;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface TVideoResourcesMapper extends CoreMapper<TVideoResources> {
	
	/**
	 * 分页查询视频课程
	 * @return
	 */
	public List<TVideoResources> getAllVideoCourses(@Param("userId")long userId,@Param("fromFlag")int fromFlag,
			@Param("typeId") int typeId,@Param("subjectId")int subjectId,@Param("orderBy")int orderBy);
	
	/**
	 * 根据所属平台、类型，查询视频课程总数
	 * @param userId
	 * @param fromFlag
	 * @param typeId
	 * @return
	 */
	public int getVideoNums(@Param("fromFlag")int fromFlag,@Param("typeId") int typeId);
	
	/**
	 * 根据所属平台，查询视频课程总数
	 * @param fromFlag
	 * @return
	 */
	public int getVideoNumsByFromflag(@Param("fromFlag")int fromFlag);
			
	
	/**
	 * 查询一个视频课程的信息
	 * @param userId
	 * @param videoId
	 * @return
	 */
	public VideoPreviewEntity getOneVideoCourse(@Param("videoId")long videoId,@Param("userId")long userId);
	
	
	/**
	 * 插入一条视频课程
	 * @param videoResources
	 */
	public void insertOneVideoCourse(@Param("videoCourse") TVideoResources videoResources);
	
	/**
	 * 编辑一条视频课程
	 * @param videoResources
	 */
	public void editOneVideoCourse(@Param("videoCourse") TVideoResources videoResources);
	
	
	/**
	 * 批量删除视频课程
	 * @param ids
	 */
	public void delVideoCourses(@Param("ids")long[] ids);
	
	/**
	 * 根据视频课程id查询所属平台、类型、学科
	 * @param id
	 * @return
	 */
	public HashMap selectFromflagOfOneVideo(long id);
	
	/**
	 * 根据关键字检索视频课程
	 * @param keyWord
	 * @param fromFlag   所属平台  0 双课堂 1 资源中心
	 * @return
	 */
	public List<TVideoResources> getVideoSearchResults(@Param("keyWord")String keyWord,@Param("fromFlag")int fromFlag,@Param("orderBy")int orderBy);
	
	/**
	 * 增加一条视频浏览记录
	 * @param userId
	 * @param videoId
	 */
	public void addOneVisitedItem(@Param("userId")long userId,@Param("videoId")long videoId);
}