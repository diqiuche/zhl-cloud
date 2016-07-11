package net.tfedu.zhl.helper;

import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.InvalidAccessTokenException;
import net.tfedu.zhl.core.exception.KickOutTokenException;
import net.tfedu.zhl.sso.user.entity.UserSimple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;


/**
 * 用户缓存工具类型
 * @author wangwr
 *
 */
public class UserTokenCacheUtil {
	
	
	/***
	 * 登录产品类型: web端资源中心
	 */
	private static final String LOGIN_PRODUCTION_TYPE_WEB = "RESOURCEWEB";
	
	/***
	 * 登录产品类型: e备课客户端
	 */
	private static final String LOGIN_PRODUCTION_TYPE_EPREPARE = "EPREPARE";
	
	
	
	/**
	 * 缓存用户信息的命名空间
	 */
	private static final String USERINFO_CACHE_NAMESPACE = "UserSimpleCache"; 
	
	/**
	 * 缓存用户token的命名空间
	 */
	private static final String Token_CACHE_NAMESPACE = "TokenCache"; 
	
	/**
	 * 缓存被踢出的token的命名空间
	 */
	private static final String kickOutTokenCache_NAMESPACE = "KickOutTokenCache";
	
	
	/**
	 * 用户token的缓存前缀
	 */
	private static final String USERTOKEN_CACHE_PREFIX = "USERTOKEN_CACHE_PREFIX_";
	
	
	private static  Logger logger = LoggerFactory.getLogger(UserTokenCacheUtil.class.getName());
	

	/**
	 * 获取用户token信息的缓存key
	 * @param userId
	 * @return
	 */
	public static String getUserTokenCacheKey(String model,String userId){
		String productionKey = getProductionKey(model);
		return  new StringBuffer().append(USERTOKEN_CACHE_PREFIX)
				.append(productionKey)
				.append("_")
				.append(userId).toString().trim();
	}
	
	
	/**
	 * 获取缓存的value
	 * @param token
	 * @return
	 * @throws InvalidAccessTokenException 
	 */
	private static UserSimple getValueWrapper(CacheManager cacheManager,String token) throws InvalidAccessTokenException{
		ValueWrapper o = cacheManager.getCache(USERINFO_CACHE_NAMESPACE).get(token);
		if(null == o ){
			throw  new InvalidAccessTokenException();
		}
		UserSimple us  = (UserSimple)o.get();
		return us;
	}
	/**
	 * 获取缓存的value（检测是否被踢出）
	 * @param token
	 * @return
	 * @throws InvalidAccessTokenException 
	 * @throws KickOutTokenException 
	 */
	private static UserSimple getValueWrapperAndCheck(CacheManager cacheManager,String token) throws InvalidAccessTokenException, KickOutTokenException{
		ValueWrapper o = cacheManager.getCache(USERINFO_CACHE_NAMESPACE).get(token);
		//找不到对应的用户信息，检查缓存的被踢出的头肯
		if(null == o ){
			ValueWrapper temp = cacheManager.getCache(kickOutTokenCache_NAMESPACE).get(token);
			if(null!=temp){
				throw new KickOutTokenException();
			}
			//不是被踢出，则为超时或无效
			throw new InvalidAccessTokenException();
		}
		UserSimple us  = (UserSimple)o.get();
		return us;
	}
	
	
	private static String getProductionKey(String model){
		if(LOGIN_PRODUCTION_TYPE_EPREPARE.equalsIgnoreCase(model)){
			return LOGIN_PRODUCTION_TYPE_EPREPARE;
		}
			return LOGIN_PRODUCTION_TYPE_WEB;
	}
	
	/**
	 * 获取用户信息的value
	 * @param token
	 * @return
	 * @throws InvalidAccessTokenException 
	 * @throws KickOutTokenException 
	 */
	public static UserSimple getUserInfoValueWrapper(CacheManager cacheManager,String token,Boolean isRepeatLogin) throws InvalidAccessTokenException, KickOutTokenException{
		//如果允许重复登录
		if(isRepeatLogin){
			return getValueWrapper(cacheManager, token);
		}
		//检查是否被踢出
		return getValueWrapperAndCheck(cacheManager, token);
	}
	
	
	/**
	 * 增加用户的缓存(isRepeatLogin是否允许重复登陆)
	 * @param cacheManager
	 * @param token
	 * @param us
	 * @param isRepeatLogin
	 */
	public static void addUserInfoCache(String model,CacheManager cacheManager,String token,UserSimple us,Boolean isRepeatLogin ){
		
		String userId = us.getUserId().toString();	
		
		
		/**
		 * 获取缓存用户token信息的key 
		 */
		String user_token_key = getUserTokenCacheKey(model,userId);
		
		if(!isRepeatLogin){
			//如果有历史登录，踢出
			kickExistUserInfo(cacheManager,user_token_key);
		}
		
		
		//增加用户缓存
		addUserInfoCacheMethod(cacheManager, token, us, user_token_key,isRepeatLogin);
		
	}
	
	
	
	/**
	 * 退出登录,清理用户的缓存
	 * @param cacheManager
	 * @param tok en
	 */
	public static void clearUserInfoCache(CacheManager cacheManager,String token,Boolean isRepeatLogin){
		
		Cache cache = cacheManager.getCache(USERINFO_CACHE_NAMESPACE);
    	ValueWrapper o = cache.get(token);
        if(o!=null){
        	UserSimple us  = (UserSimple)(o.get());
        	if(us!=null){
                String userId = us.getUserId().toString();
                if(!isRepeatLogin){
            		String user_token_key = getUserTokenCacheKey(us.getModel(),userId);
            		//清理当前token的缓存
            		cacheManager.getCache(Token_CACHE_NAMESPACE).evict(user_token_key);
                }
                //清理用户的信息缓存
                cache.evict(token);
        	}
    	}		
	}
	
	
	
	/**
	 * 增加用户缓存
	 * @param cache
	 * @param cacheManager
	 * @param token
	 */
	private static void addUserInfoCacheMethod(CacheManager cacheManager,String token,UserSimple us,String user_token_key,Boolean isRepeatLogin){
		
		
		//不允许重复登录的话，记录最新的token
		if(!isRepeatLogin){
			logger.info("缓存当前的用户token:"+user_token_key+":"+token);
			//缓存当前的用户token
			cacheManager.getCache(Token_CACHE_NAMESPACE).put(user_token_key, token);
		}
		//缓存当前的用户登录信息
		cacheManager.getCache(USERINFO_CACHE_NAMESPACE).put(token, us);
		logger.info("缓存当前的用户登录信息,token:"+token+",UserSimple:"+us.toString());
		
	}
	
	
	
	
	
	/**
	 * 当不允许重复登录时
	 * 如果存在历史纪录，清空
	 * @param user_token_key
	 */
	private static void kickExistUserInfo(CacheManager cacheManager,String user_token_key){
		ValueWrapper o = cacheManager.getCache(Token_CACHE_NAMESPACE).get(user_token_key);
		if(o!=null){
        	String token = (String)(o.get());
        	
        	//如果历史存在token
        	if(StringUtils.isNotEmpty(token)){
        		logger.info("踢出历史用户token:"+token+",user_token_key:"+user_token_key);

        		//缓存被踢出的用户token
        		cacheManager.getCache(kickOutTokenCache_NAMESPACE).put(token, user_token_key);
        		//清理历史的用户信息缓存
        		cacheManager.getCache(USERINFO_CACHE_NAMESPACE).evict(token);
        		//清理用户当前token的缓存
        		cacheManager.getCache(Token_CACHE_NAMESPACE).evict(user_token_key);
        	}
    	}		
	}	
	
	
	
	
}
