package net.tfedu.zhl.cloud.teaching.videoCourses.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TSubject;
import net.tfedu.zhl.cloud.teaching.videoCourses.dao.TVideoTypeMapper;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoType;
import net.tfedu.zhl.cloud.teaching.videoCourses.service.VideoTypesService;

import org.springframework.stereotype.Service;

/**
 * 视频课程类型 及 类型下的相关课程
 * @author WeiCuicui
 *
 */
@Service("videoTypesService")
public class VideoTypesServiceImpl implements VideoTypesService{

    @Resource TVideoTypeMapper tVideoTypeMapper;
	
	/**
	 * 查询所有的视频课程类型
	 * @return
	 */
    @Override
	public List<TVideoType> getAllTypes(){
  
		return tVideoTypeMapper.getAllTypes();
	}
	
	/**
	 * 查询特定类型下的视频课程
	 */
    @Override
	public List<TSubject> getSubjectsByType(int typeId){
    	
    	List<TSubject> list = tVideoTypeMapper.getSubjectsByType(typeId);
    	
		return list;
	}
}
