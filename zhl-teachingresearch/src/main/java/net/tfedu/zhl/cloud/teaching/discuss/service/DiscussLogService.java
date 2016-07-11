package net.tfedu.zhl.cloud.teaching.discuss.service;

import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussLog;
import net.tfedu.zhl.core.service.BaseService;
import net.tfedu.zhl.helper.ResultJSON;

public interface DiscussLogService extends BaseService<TDiscussLog> {
	
	
	
	/**
	 * 获取最新访问列表
	 * @param userId
	 * @return
	 */
	public ResultJSON getReadLog(Long userId) throws Exception;
	
	

}
