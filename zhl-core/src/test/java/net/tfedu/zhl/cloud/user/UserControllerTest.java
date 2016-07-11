package net.tfedu.zhl.cloud.user;

import javax.annotation.Resource;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.UserTokenCacheUtil;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;
import net.tfedu.zhl.sso.user.controller.UserController;
import net.tfedu.zhl.sso.user.entity.UserSimple;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;


@Transactional
public class UserControllerTest extends BaseControllerTestCase {

	@Resource
	UserController controller;

	

	@Resource
	CacheManager  cacheManager;
	
	Logger logger = LoggerFactory.getLogger(UserControllerTest.class);
	
	ResultJSON result = null;

	@Test
	public void testGetUserInfo() throws Exception {

		result = controller.getUserInfo(1l, request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	@Test
	public void testUpdateUserInfo() throws Exception {

		request.setParameter("trueName", "admin_trueName_trueName");
		request.setParameter("termId", "2");
		request.setParameter("subjectId", "3");
		request.setParameter("male", "true");
		request.setParameter("userImage", "/person/head/Icon10.jpg");
		request.setParameter("_method", "PATCH");

		result = controller.updateUserInfo(1l, request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	@Test
	public void testUpdatePwd() throws Exception {

		request.setParameter("oldPassword", "000000");
		request.setParameter("newPassword", "000000");
		request.setParameter("_method", "PATCH");

		result = controller.updateUserPwd(request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	@Test
	public void testLogin() throws Exception {
		request.setParameter("user_name", "tfgaolican");
		request.setParameter("user_pwd", "000000");
		result = controller.Login(request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	@Test
	public void testLogout() throws Exception {
		request.setParameter("_method", "DELETE");
		result = controller.Login(request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	}

	@Test
	public void testUpdateImage() throws Exception {

		long userId = 390320126l;
		request.setAttribute("currentUserId", 390320126l);

		request.setParameter("userImage", "/person/head/Icon10.jpg");
		result = controller.updateUserImage(userId, request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	@Test
	public void testGetUserImageUrl() {

		request.setAttribute("currentUserId", 390320126l);
		result = controller.getUserImageUrl(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	@Test
	public void testGetVerificationCode() {
		result = controller.getVerificationCode(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}

	/**
	 * 测试不同产品使用登录接口缓存的token，UserSimple对象
	 * @throws Exception
	 * 
	 * 
	 * 
	 * 
	 */
	@Test
	public void testLoginCache() throws Exception {
		String userId = "390410126 ";
		
		request.setParameter("user_name", "csls10");
		request.setParameter("user_pwd", "111111");
		result = controller.Login(request, response);
		String token = 	 ((UserSimple)result.getData()).getToken();
		
		request.setParameter("model", "eprepare");
		
		result = controller.Login(request, response);
		String token2 = 	 ((UserSimple)result.getData()).getToken();
		logger.info("接口返回web登录时的token:"+token);
		logger.info("接口返回e备课登录时的token:"+token2);

		
		
	
		String key1 = UserTokenCacheUtil.getUserTokenCacheKey("", userId);
		String key2 = UserTokenCacheUtil.getUserTokenCacheKey("eprepare", userId);
		
		ValueWrapper v1=  cacheManager.getCache("TokenCache").get(key1);
		ValueWrapper v2=  cacheManager.getCache("TokenCache").get(key2);
		String result1 =  (String)v1.get();
		String result2 =  (String)v2.get();
		logger.info("web登录时的token:"+result1);
		logger.info("e备课登录时的token:"+result2);
		
		
		UserSimple us1 = UserTokenCacheUtil.getUserInfoValueWrapper(cacheManager, result1, false);
		UserSimple us2 = UserTokenCacheUtil.getUserInfoValueWrapper(cacheManager, result2, false);
		
		logger.info("web登录时缓存对象的model:"+us1.getModel());
		logger.info("e备课登录时缓存对象的model:"+us2.getModel());
		
		
		
	}
	
	
	@Test
	public void testQueryUserWithRoleAndName() throws Exception {
		request.setParameter("name", "刘珍珍");
		
		result = controller.queryUserWithRoleAndName(request, response);
		
		logger.info(JSONObject.toJSONString(result));
		Assert.isTrue(result!=null && "ok".equalsIgnoreCase(result.getCode()));
		
	}
}
