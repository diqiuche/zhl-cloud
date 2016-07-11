package net.tfedu.zhl.cloud.teaching.discuss.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.tfedu.zhl.cloud.teaching.discuss.dao.TDiscussLogMapper;
import net.tfedu.zhl.cloud.teaching.discuss.entity.TDiscussLog;
import net.tfedu.zhl.cloud.teaching.discuss.service.DiscussLogService;
import net.tfedu.zhl.core.service.impl.BaseServiceImpl;
import net.tfedu.zhl.helper.ResultJSON;


@Service("discussLogService")
public class DiscussLogServiceImpl extends BaseServiceImpl<TDiscussLog> implements
		DiscussLogService {
	
	
	@Resource
	TDiscussLogMapper mapper;
	
	
	
	/**
	 * 获取最新访问列表
	 * @param userId
	 * @return
	 */
	public ResultJSON getReadLog(Long userId) throws Exception{
		
		
		return  defaultSuccess(mapper.getReadLog(userId)) ;
	}

}
