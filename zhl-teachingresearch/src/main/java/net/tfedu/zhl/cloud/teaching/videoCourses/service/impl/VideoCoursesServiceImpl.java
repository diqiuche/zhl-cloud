package net.tfedu.zhl.cloud.teaching.videoCourses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.videoCourses.dao.TVideoResourcesMapper;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoResources;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.VideoPreviewEntity;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoCoursesService;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.PaginationHelper;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 视频课程的serviceImpl
 * @author WeiCuicui
 *
 */
@Service("videoCoursesService")
public class VideoCoursesServiceImpl implements VideoCoursesService {

	@Resource TVideoResourcesMapper tVideoResourcesMapper;
	
	/**
	 * 分页查询视频课程资源
	 */
	public PaginationHelper<TVideoResources> getAllVideoCourses(int fromFlag,int typeId,int subjectId,int orderBy,int page,int perPage,long userId){
		
		// Page插件必须放在查询语句之前紧挨的第一个位置
        PageHelper.startPage(page, perPage);
		
		//查询视频课程
		List<TVideoResources> list = tVideoResourcesMapper.getAllVideoCourses(userId, fromFlag, typeId, subjectId,orderBy);
		
		//某类视频课程总数
		int count = tVideoResourcesMapper.getVideoNums(fromFlag, typeId);
		
		//将查询结果集转换为分页的封装类型
		return PaginationHelper.transferVideoCourse(list, count); 
	}
	
	/**
	 * 预览一条视频课程的预览信息
	 */
	public VideoPreviewEntity getOneVideoCourse(long videoId,long userId){
		
		return tVideoResourcesMapper.getOneVideoCourse(videoId, userId);
	}
	
	/**
	 * 新建一个视频课程
	 * @param video
	 * @param userId
	 */
	public void insertOneVideoCourse(String video,long userId){
		
		//将json字符串转换为实例对象
		TVideoResources videoCourse = new TVideoResources();
		
		//将json字符串中的" 替换为 '
		video = video.replace('"', '\'');
		
		videoCourse = JsonUtil.getInstance().fromJson(video,TVideoResources.class);
		
		videoCourse.setCreator(userId);
		if(videoCourse.getSubjectid() == null) //若没有学科，则表示是初级视频课程，学科id为0
			videoCourse.setSubjectid(0);
		
		tVideoResourcesMapper.insertOneVideoCourse(videoCourse);
	}
	
	/**
	 * 编辑一个视频课程
	 * @param video
	 * @param userId
	 */
	public void editOneVideoCourse(String video,long userId){
		//将json字符串转换为实例对象
		TVideoResources videoCourse = new TVideoResources();
		
		//将json字符串中的" 替换为 '
		video = video.replace('"', '\'');
		videoCourse = JsonUtil.getInstance().fromJson(video,TVideoResources.class);
		
		videoCourse.setCreator(userId);
		if(videoCourse.getSubjectid() == null) //若没有学科，则表示是初级视频课程，学科id为0
			videoCourse.setSubjectid(0);
		
		tVideoResourcesMapper.editOneVideoCourse(videoCourse);
	}
	
	/**
	 * 批量删除视频课程
	 */
	public void delVideoCourses(String ids){
	    
		//将传递的字符串转换为整型
		String[] videoIds = ids.split(",");
		long[] vIds = new long[videoIds.length];
		for(int i = 0; i < videoIds.length; i++)
			vIds[i] = Long.parseLong(videoIds[i].trim());
		
		tVideoResourcesMapper.delVideoCourses(vIds);
	}
	
	/**
	 * 根据输入的关键字检索视频课程
	 */
	public PaginationHelper<TVideoResources> getVideoSearchResults(String keyWord,int fromFlag,int orderBy,int page,int perPage){
		
		PageHelper.startPage(page, perPage);
		
		List<TVideoResources> list = tVideoResourcesMapper.getVideoSearchResults(keyWord, fromFlag,orderBy);
		
		//上传总量
		int count = tVideoResourcesMapper.getVideoNumsByFromflag(fromFlag);
		
		return PaginationHelper.transferVideoCourse(list, count);
	}
	
	/**
     * 插入一条视频课程预览信息
     * @param userId
     * @param videoId
     */
	public void addOneVisitItem(long userId,long videoId){
		
		tVideoResourcesMapper.addOneVisitedItem(userId, videoId);
	}
}
