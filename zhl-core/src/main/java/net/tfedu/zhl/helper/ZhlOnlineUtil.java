package net.tfedu.zhl.helper;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.fileservice.MD5;

/**
 * 在线用户工具
 * 记录在 j_online_users 表中
 * 
 * @author wangwr
 *
 */
public class ZhlOnlineUtil {

    /**
     * 客户端web浏览器方式
     */
    public static final int ONLINE_CLIENTTYPE_BROWSER = 1;
    /**
     * 客户端ANDROID方式
     */
    public static final int ONLINE_CLIENTTYPE_ANDROID = 2;
    /**
     * 客户端WINPAD方式
     */
    public static final int ONLINE_CLIENTTYPE_WINPAD = 3;

    /**
     * 在线
     */
    public static final int ONLINE_STATUS_ONLINE = 1;
    /**
     * 离线
     */
    public static final int ONLINE_STATUS_LOGOUT = 2;
    /**
     * 超时
     */
    public static final int ONLINE_STATUS_TIMEOUT = 3;
    /**
     * 被踢
     */
    public static final int ONLINE_STATUS_OTHERLOG = 4;

    /**
     * 获token的有效时间，从登录时间时间开始计时 默认是两个小时 可以在web.xml中配置
     * 
     * @param request
     * @return
     */
    public static int getTokenValidTime(HttpServletRequest request) {
        int timeout = 4;// 有效时间两个小时 单位为小时
        String time = request.getServletContext().getInitParameter("TOKEN_VALID_TIME");
        if (StringUtils.isNotEmpty(time) && Integer.parseInt(time) > 0) {
            timeout = Integer.parseInt(time);
        }
        return timeout;
    }

    /**
     * 获取设备信息(浏览器的)
     * 
     * @param request
     * @param userid
     * @param nodeid
     * @param clientType
     * @return
     */
    public static String getDeviceInfoWeb(HttpServletRequest request, long userid, long nodeid, int clientType) {
        // 由request获取浏览器版本、ip地址
        String clientVersion = request.getHeader("user-agent");
        String loginIP = getIpAddr(request);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String curTime = format.format(Calendar.getInstance().getTime());
        StringBuffer sb = new StringBuffer();
        sb.append(curTime).append("_").append(userid).append("_").append(nodeid).append("_").append(clientType).append("_").append(loginIP).append("_").append(clientVersion).append("_")
                .append(curTime);
        return MD5.MD5(sb.toString());
    }

    /** 获取IP地址 */
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("http_client_ip");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        // 如果是多级代理，那么取第一个ip为客户ip
        if (ip != null && ip.indexOf(",") != -1) {
            ip = ip.substring(ip.lastIndexOf(",") + 1, ip.length()).trim();
        }
        return ip;
    }

}
