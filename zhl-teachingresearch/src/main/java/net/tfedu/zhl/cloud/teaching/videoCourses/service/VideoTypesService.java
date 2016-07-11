package net.tfedu.zhl.cloud.teaching.videoCourses.service;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TSubject;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoType;

public interface VideoTypesService {

	/**
	 * 查询所有的视频课程类型
	 * @return
	 */
	public List<TVideoType> getAllTypes();
	
	/**
	 * 查询特定视频课程类型下的学科
	 * @param typeId
	 * @return
	 */
	public List<TSubject> getSubjectsByType(int typeId);
}
