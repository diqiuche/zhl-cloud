package net.tfedu.zhl.sso.online.service;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import net.tfedu.zhl.sso.online.entity.JOnlineUsers;

public interface JOnlineUsersService {

	/**
	 * 新建或获取用户的有效的在线信息
	 * 
	 * @param userId
	 * @param request
	 * @param repeatLoginValidFlag
	 *            重复登录是否有效的标识： 资源中心不允许重复登登录(同一个用户、同一种登录client、同一个站点)
	 * @return
	 */
	public JOnlineUsers getUserOnlines(Long userId, HttpServletRequest request,
			Boolean repeatLoginValidFlag);

	/**
	 * 根据token获取用户的在线信息
	 * 
	 * @param token
	 * @return
	 */
	public JOnlineUsers getUserOnlinesByToken(String token, Integer validTime)throws Exception;

	/**
	 * 根据token获取用户的在线信息
	 * 
	 * @param token
	 * @return
	 */
	public JOnlineUsers getUserOnlinesByToken(String token) throws Exception;

	/**
	 * 增加用户的在线信息
	 * 
	 * @param user
	 */
	public void addUserOnline(JOnlineUsers user);

	/**
	 * 修改用户在线状态
	 * 
	 * @param token
	 * @param status
	 */
	public void updateOnlineStatus(String token, Integer status);

	/**
	 * 根据token设置用户的最后操作时间
	 * 
	 * @param token
	 */
	public void updateLastOperTime(String token, Date date);

	/**
	 * 设置用户退出
	 * 
	 * @param token
	 */
	public void logout(String token);

}
