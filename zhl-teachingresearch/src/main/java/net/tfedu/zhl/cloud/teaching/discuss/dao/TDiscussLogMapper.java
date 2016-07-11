package net.tfedu.zhl.cloud.teaching.discuss.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussLog;
import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussRecommend;
import net.tfedu.zhl.helper.CoreMapper;

public interface TDiscussLogMapper extends CoreMapper<TDiscussLog> {
	
	
	/**
	 * 获取最新访问列表
	 * @param userId
	 * @return
	 */
	public List<TDiscussRecommend> getReadLog(@Param("userId") Long userId) throws Exception;
	
}