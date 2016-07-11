package net.tfedu.zhl.core.interceptor;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cache.Cache.ValueWrapper;
import org.springframework.cache.CacheManager;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import net.tfedu.zhl.core.exception.InvalidAccessTokenException;
import net.tfedu.zhl.core.exception.NoAuthorizationException;
import net.tfedu.zhl.core.exception.NoLoginException;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ZhlOnlineUtil;
import net.tfedu.zhl.sso.user.entity.UserSimple;

/**
 * 授权拦截器
 * 
 * @author Bruce
 *
 */
public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
    @Resource
    CacheManager cacheManager;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 1判断是否请求是否需要拦截, 拦截器自动处理，配置一下excludedUrls
        // 获取参数
        String token = ControllerHelper.getHeaderParameter(request, "Authorization");
        // 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");

        // 2判断是否登录
        ValueWrapper obj = cacheManager.getCache("UserSimpleCache").get(token);
        if (obj == null) {
            throw new NoLoginException();
        }

        // 3判断用户token是否有效
        int validTime = ZhlOnlineUtil.getTokenValidTime(request);
        UserSimple us = (UserSimple) obj.get();
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        Calendar loginTime = Calendar.getInstance();
        loginTime.setTime(us.getLogintime());
        loginTime.add(Calendar.HOUR_OF_DAY, validTime);

        if (now.before(loginTime)) {            
            cacheManager.getCache("UserSimpleCache").evict(token);
            throw new InvalidAccessTokenException();
        }

        // 4判断是否有权限
        Set<String> funcs = us.getFuncPaths();
        String url = request.getRequestURI();

        // 直接匹配
        if (funcs.contains(url)) {
            request.setAttribute("currentUserId", currentUserId);
            return true;
        }

        // 支持*号
        for (String fun : funcs) {
            if (fun.indexOf("*") > 0) {
                if (url.startsWith(fun.substring(0, fun.length() - 1))) {
                    request.setAttribute("currentUserId", currentUserId);
                    return true;
                }
            }
        }

        // 无匹配
        throw new NoAuthorizationException();
    }

}
