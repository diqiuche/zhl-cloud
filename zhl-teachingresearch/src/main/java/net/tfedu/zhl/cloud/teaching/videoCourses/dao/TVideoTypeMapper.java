package net.tfedu.zhl.cloud.teaching.videoCourses.dao;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TSubject;
import net.tfedu.zhl.cloud.teaching.videoCourses.entity.TVideoType;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface TVideoTypeMapper extends CoreMapper<TVideoType> {
	
	/**
	 * 查询所有的视频课程类型
	 * @return
	 */
	public List<TVideoType> getAllTypes();
	
	/**
	 * 查询特定类型下的所有学科
	 * @param typeId
	 * @return
	 */
	public List<TSubject> getSubjectsByType(@Param("typeId")int typeId);
}