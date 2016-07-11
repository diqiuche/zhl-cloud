package net.tfedu.zhl.sso.message.service;

import com.github.pagehelper.PageInfo;

public interface JMessageService {
	/**
	 * 统计用户新消息的个数
	 * @param userId
	 * @return
	 */
	public int getUserNewMessageNumber(Long userId);
	
	
	/**
	 * 分页获取用户的新消息
	 * @param userId
	 * @param page
	 * @param perPage
	 * @return
	 */
	public PageInfo queryMessage(Long userId,Integer page,Integer perPage);
	
	
	
	/**
	 * 根据消息id设置状态为已读
	 * @param id
	 */
	public void updateMessageReaded(Long id);
}
