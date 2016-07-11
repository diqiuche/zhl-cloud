package net.tfedu.zhl.sso.online.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import net.tfedu.zhl.core.exception.InvalidAccessTokenException;
import net.tfedu.zhl.helper.ZhlOnlineUtil;
import net.tfedu.zhl.sso.online.dao.JOnlineUsersMapper;
import net.tfedu.zhl.sso.online.entity.JOnlineUsers;
import net.tfedu.zhl.sso.online.service.JOnlineUsersService;
import net.tfedu.zhl.sso.users.dao.SRegisterMapper;
import net.tfedu.zhl.sso.users.entity.SRegister;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("jOnlineUsersService")
public class JOnlineUsersServiceImpl implements JOnlineUsersService {

	@Autowired
	JOnlineUsersMapper mapper;

	@Autowired
	SRegisterMapper registerMapper;

	@Override
	public JOnlineUsers getUserOnlines(Long userId, HttpServletRequest request,
			Boolean repeatLoginValidFlag) {
		// 1 web 2 android 3 winpad 客户端类型
		int clientType = 1;

		// -----------排除超时
		mapper.setTimeOut();

		// 资源中心没有多级部署的情况： 使用注册站点作为登录站点
		SRegister register = registerMapper.selectByPrimaryKey(userId);
		long registerNodeId = register.getNodeid();

		// ---------------不允许重复登录时
		if (!repeatLoginValidFlag) {
			mapper.clearRepeatUserLogin(userId, clientType, registerNodeId);
		}

		// token的有效时间
		int validTime = ZhlOnlineUtil.getTokenValidTime(request);
		// 获取设备信息
		String deviceInfo = ZhlOnlineUtil.getDeviceInfoWeb(request, userId,
				registerNodeId, clientType);

		// token 由UUID 生成
		String token = UUID.randomUUID().toString();
		// 从工具类中获取ip
		String loginIP = ZhlOnlineUtil.getIpAddr(request);

		Date currentDate = Calendar.getInstance().getTime();

		JOnlineUsers user = new JOnlineUsers();
		user.setUserid(userId);
		user.setClienttype(clientType);
		user.setClientversion(request.getHeader("user-agent"));
		user.setDeviceinfo(deviceInfo);
		user.setLoginip(loginIP);
		user.setLoginnodeid(registerNodeId);
		user.setLogintime(currentDate);
		user.setLastopertime(currentDate);
		user.setFlag(false);
		user.setStatus(ZhlOnlineUtil.ONLINE_STATUS_ONLINE);
		user.setToken(token);
		mapper.insert(user);
		return user;
	}

	@Override
	public void addUserOnline(JOnlineUsers user) {
		mapper.insert(user);
	}

	@Override
	public void updateOnlineStatus(String token, Integer status) {
		mapper.updateOnlineStatus(token, status);
	}

	@Override
	public void updateLastOperTime(String token, Date date) {
		if (date == null) {
			Calendar c = Calendar.getInstance();
			date = c.getTime();
		}
		mapper.updateLastOperTime(token, date);
	}

	@Override
	public void logout(String token) {
		updateOnlineStatus(token, ZhlOnlineUtil.ONLINE_STATUS_LOGOUT);
	}

	@Override
	public JOnlineUsers getUserOnlinesByToken(String token, Integer validTime)throws Exception
{

		JOnlineUsers obj = mapper.getOnlineByToken(token, validTime);
		if (obj == null) {
			throw new InvalidAccessTokenException();
		}
		return obj;
	}

	@Override
	public JOnlineUsers getUserOnlinesByToken(String token) throws Exception{
		return getUserOnlinesByToken(token, 2);
	}

}
