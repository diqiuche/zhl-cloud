package net.tfedu.zhl.sso.user.controller;

import java.util.Arrays;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.cloud.utils.security.PWDEncrypt;
import net.tfedu.zhl.cloud.utils.security.VerificationCodeGenerator;
import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.core.exception.InvalidAccessTokenException;
import net.tfedu.zhl.core.exception.InvalidPasswordException;
import net.tfedu.zhl.core.exception.NoTokenException;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.core.exception.WithoutUserException;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.UserTokenCacheUtil;
import net.tfedu.zhl.sso.user.UserImageCheckUtil;
import net.tfedu.zhl.sso.user.entity.JUser;
import net.tfedu.zhl.sso.user.entity.UserSimple;
import net.tfedu.zhl.sso.user.service.UserService;
import net.tfedu.zhl.sso.users.entity.SRegister;
import net.tfedu.zhl.sso.users.service.RegisterService;

@Controller
@RequestMapping("/*RestAPI")
public class UserController {

	@Resource
	private UserService userService;

	@Resource
	private RegisterService registerService;

	@Resource
	private CommonWebConfig commonWebConfig;

	@Autowired
	CacheManager cacheManager;

	Logger logger = LoggerFactory.getLogger(UserController.class);

	/**
	 * 登录获取验证码 不用登录
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/verificationcode", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getVerificationCode(HttpServletRequest request,
			HttpServletResponse response) {

		// 当前登录用户id
//		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = VerificationCodeGenerator.getCode();

		return ResultJSON.getSuccess(data);

	}

	/**
	 * 登陆、注销
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/v1.0/users/login")
	@ResponseBody
	public ResultJSON Login(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Object data = null;
		boolean isRepeatLogin = commonWebConfig.getIsRepeatLogin();
		
		
		String _method = request.getParameter("_method");

		// 不同的子系统，使用不同的model参数
		String model = ControllerHelper.getModel(request);

		// 注销
		if (StringUtils.isNotEmpty(_method)
				&& HttpMethod.DELETE.name().equals(_method)) {
			// 用户登录状态相关检查
			String token = request.getHeader("Authorization");
			if (StringUtils.isEmpty(token)) {
				// 缺少token
				throw new NoTokenException();
			} else {
				
				UserSimple us = UserTokenCacheUtil.getUserInfoValueWrapper(cacheManager
						, token, isRepeatLogin);
				if (us == null || StringUtils.isEmpty(us.getToken())) {
					// token 无效
					throw new InvalidAccessTokenException();
				}
				
				userService.logout(token, isRepeatLogin);
			}
		} else {
			String userName = request.getParameter("user_name");
			String userPwd = request.getParameter("user_pwd");
			// 返回用户的信息
			UserSimple user = null;

			// 用户登录
			SRegister reg = registerService.login(userName, userPwd);
			// 获取用户信息
			user = userService.getUserSimpleById(reg.getId(), model,isRepeatLogin);
			//检测用户的头像
			UserImageCheckUtil.checkUserImage(user, commonWebConfig, request);
			
			data = user;

		}
		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/users/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getUserInfo(@PathVariable Long id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// 不同的子系统，使用不同的model参数
		String model = request.getParameter("model") == null ? " " : request
				.getParameter("model");
		// 返回
		UserSimple user = userService.getUserSimpleById(id, model);
		if (user.getUserImage() != null
				&& user.getUserImage()
						.trim()
						.contains(
								ZhlResourceCenterWrap.userimage_upload_prefix)) {

			// 获取文件服务器的访问url
			String resServiceLocal = commonWebConfig.getResServiceLocal();
			String currentResPath = commonWebConfig
					.getCurrentResPath(request);

			String temp = ZhlResourceCenterWrap.getDownUrl(resServiceLocal,
					user.getUserImage());
			temp = temp.replace(resServiceLocal, currentResPath);
			user.setUserImage(temp);
		}

		return ResultJSON.getSuccess(user);
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/users/{id}", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON updateUserInfo(@PathVariable Long id,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		if (currentUserId != null) {
			long userId = currentUserId;
			boolean male = false;
			long termId = 0;
			long subjectId = 0;
			String trueName = request.getParameter("trueName");
			String _termId = request.getParameter("termId");
			String _subjectId = request.getParameter("subjectId");
			String _male = request.getParameter("male");
			String _method = request.getParameter("_method");

			if (StringUtils.isNotEmpty(_male)
					&& ("Y".equalsIgnoreCase(_male) || "true"
							.equalsIgnoreCase(_male))) {
				male = true;
			}
			if (StringUtils.isNotEmpty(_termId)) {
				termId = Long.parseLong(_termId);
			}
			if (StringUtils.isNotEmpty(_subjectId)) {
				subjectId = Long.parseLong(_subjectId);
			}

			if (!RequestMethod.PATCH.name().equals(_method)) {// _method!=patch
				throw new ParamsException();
			} else {
				userService.updateUserInfo(userId, trueName, male, termId,
						subjectId);
			}
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 修改用户信息
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/users/userimage/{userid}", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON updateUserImage(@PathVariable Long userid,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		if (currentUserId != null) {
			long userId = currentUserId;
			String userImage = request.getParameter("userImage");
			userService.updateUserImage(userId, userImage);

			//返回检查后的头像信息
			data = UserImageCheckUtil.checkUserImage(userImage, commonWebConfig, request);
			
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 修改用户密码
	 * 
	 * @return
	 */
	@RequestMapping(value = "/v1.0/users/password", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON updateUserPwd(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		if (currentUserId != null) {
			long userId = currentUserId;
			String oldPassword = request.getParameter("oldPassword");
			String newPassword = request.getParameter("newPassword");
			String _method = request.getParameter("_method");
			byte[] temp = PWDEncrypt.doEncryptByte(oldPassword);

			if (!RequestMethod.PATCH.name().equals(_method)) {// _method!=patch
				throw new ParamsException();
			} else {
				SRegister register = registerService.getRegister(userId);
				if (register != null) {
					// 旧密码是否匹配
					if (register != null
							&& !Arrays.equals(register.getPwd(), temp)) {
						throw new InvalidPasswordException();
					} else {
						registerService.modifyRegisterPassword(userId,
								newPassword);

					}
				} else {
					throw new WithoutUserException();
				}

			}
		}

		return ResultJSON.getSuccess(data);
	}

	/**
	 * 获取用户头像的专用上传链接
	 * 
	 * 
	 * 
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/v1.0/users/userImageUploadUrl", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getUserImageUrl(HttpServletRequest request,
			HttpServletResponse response) {
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		// 返回
		Object data = null;

		// 获取文件服务器的访问url
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);
		String hostLocal = commonWebConfig.getHostLocalOne();

		long userId = currentUserId;
		JUser user = userService.getUserById(userId);
		long schoolId = user.getSchoolid();
		// 组装上传路径
		String uploadPath = ZhlResourceCenterWrap.getUserImageUploadPath(
				userId, schoolId);
		// 获取上传文件路径
		String uploadUrl = ZhlResourceCenterWrap.getUploadUrlConvert(
				uploadPath, resServiceLocal, currentResPath, hostLocal, userId);

		HashMap<String, String> map = new HashMap<String, String>();
		map.put("uploadUrl", uploadUrl);
		map.put("uploadPath", uploadPath);
		data = map;

		return ResultJSON.getSuccess(data);
	}
	
	
	
	
	
	
	/**
	 * 获取用户的缓存
	 * 
	 * 
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ParamsException 
	 */
	@RequestMapping(value = "/v1.0/users/userCache", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getUserCache(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 当前登录用户id
		String userId = ControllerHelper.getParameter(request, "userId");
		String model = request.getParameter("model"); 
		
		String key_token = UserTokenCacheUtil.getUserTokenCacheKey(model, userId);
		String token = cacheManager.getCache("TokenCache").get(key_token,String.class);
		UserSimple us = UserTokenCacheUtil.getUserInfoValueWrapper(cacheManager, token, false);
		return ResultJSON.getSuccess(us);
	}
	
	
	
	/**
	 * 
	 * 根据角色、姓名分页获取用户列表
	 * @param request
	 * @param response
	 * @return
	 * @throws ParamsException 
	 */
	@RequestMapping(value = "/v1.0/users/teaching_search", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON queryUserWithRoleAndName(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// 不同的子系统，使用不同的model参数
		String model = ControllerHelper.getModel(request);
		long roleId = ControllerHelper.getOptionalLongParameter(request, "roleId");
		String name = ControllerHelper.getOptionalParameter(request, "name");
		
		int page = ControllerHelper.getPage(request);
		int perPage= ControllerHelper.getPageSize(request);
		
		
		return userService.queryUserWithRoleAndName(roleId, name, model, page, perPage);
	}
	
	
	
	
	
	
	
	
	

}
