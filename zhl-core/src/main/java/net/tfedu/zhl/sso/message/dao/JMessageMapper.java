package net.tfedu.zhl.sso.message.dao;

import java.util.List;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.message.entity.JMessage;

public interface JMessageMapper extends CoreMapper<JMessage> {
	
	/**
	 * 统计用户新消息的个数
	 * @param userId
	 * @return
	 */
	public int getUserNewMessageNumber(Long userId);
	
	
	/**
	 * 获取用户的新消息
	 * @param userId
	 * @return
	 */
	public List<JMessage> queryMessage(Long userId);
	
	

}