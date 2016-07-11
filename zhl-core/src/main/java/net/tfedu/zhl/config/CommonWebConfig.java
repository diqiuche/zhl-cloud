package net.tfedu.zhl.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


/**
 * 通用web端的配置项：
 * 主要用于各个内部平台之间的访问配置
 * 不用的话，可以不调用
 * @author wangwr
 *
 */
@Component("commonWebConfig")
public class CommonWebConfig {
	
	

	/**
	 * 应用的访问地址，可以为多个，以逗号分隔
	 */
	@Value("#{configProperties['host']}")
	public String host;
	
	/**
	 * 应用的内网访问地址，可以为多个，以逗号分隔，但是第一个必须是文件服务器可以调用的（localhost\127.0.0.1不可以）
	 */
	@Value("#{configProperties['hostLocal']}")
	public String hostLocal ;
	
	
	@Value("#{configProperties['resService']}")
	public String resService ;
	
	
	
	@Value("#{configProperties['resServiceLocal']}")
	public String resServiceLocal ;
	
	
	@Value("#{configProperties['fdHost']}")
	public String fdHost ;
	
	
	
	@Value("#{configProperties['fdHostLocal']}")
	public String fdHostLocal ;


	
	/**
	 * 是否允许一个账号使用不同的客户端同时登录
	 */
	@Value("#{configProperties['isRepeatLogin']}")
	public Boolean isRepeatLogin;
	
	
	/**
	 * 是否为云模式,默认为false
	 * 
	 * false: 根据浏览器url 和 host、hostlocal的配置,判断currentResPath使用文件服务的内外网地址
	 * 
	 * true: 云模式，直接返回文件服务的外网地址(currentResPath)
	 * 
	 */
	@Value("#{configProperties['isCloudModel']}")
	public Boolean isCloudModel;
	

	
	
	
	
	
	
	/**
	 * 题库的对接地址
	 */
	@Value("#{configProperties['tkHost']}")
	public String tkHost;
	/**
	 * 题库的对接地址local
	 */
	@Value("#{configProperties['tkHostLocal']}")
	public String tkHostLocal;
	
	/**
	 * 情景英语的对接地址
	 */
	@Value("#{configProperties['sceneEnglish']}")
	public String sceneEnglish;
	/**
	 * 情景英语的对接地址local
	 */
	@Value("#{configProperties['sceneEnglishLocal']}")
	public String sceneEnglishLocal;
	
	
	/**
	 * 论坛3.0的对接地址
	 */
	@Value("#{configProperties['forum3Host']}")
	public String forum3Host;
	/**
	 *  论坛3.0的对接地址local
	 */
	@Value("#{configProperties['forum3HostLocal']}")
	public String forum3HostLocal;
	
	
	
	
	
	
	/**
	 *获取配置的host
	 * @return
	 */
	public String getHost() {
		return host;
	}


	/**
	 * 
	 * @param host
	 */
	public void setHost(String host) {
		this.host = host;
	}



	/**
	 * 获取配置的hostlocal
	 * @return
	 */
	public String getHostLocal() {
		return hostLocal;
	}



	public void setHostLocal(String hostLocal) {
		this.hostLocal = hostLocal;
	}



	/**
	 * 获取配置的ResService
	 * @return
	 */
	public String getResService() {
		return resService;
	}



	public void setResService(String resService) {
		this.resService = resService;
	}



	/**
	 * 获取配置的resServiceLocal
	 * @return
	 */
	public String getResServiceLocal() {
		return resServiceLocal;
	}



	public void setResServiceLocal(String resServiceLocal) {
		this.resServiceLocal = resServiceLocal;
	}


	/**
	 * 获取配置的fdHost
	 * @return
	 */
	public String getFdHost() {
		return fdHost;
	}


	
	public void setFdHost(String fdHost) {
		this.fdHost = fdHost;
	}



	/**
	 * 获取配置的fdHostLocal
	 * @return
	 */
	public String getFdHostLocal() {
		return fdHostLocal;
	}



	public void setFdHostLocal(String fdHostLocal) {
		this.fdHostLocal = fdHostLocal;
	}
	
	
	/**
	 * 获取当前浏览器下的文件服务路径
	 * @param request
	 * @return
	 */
	public String getCurrentResPath(HttpServletRequest request){
        String URI = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + request.getContextPath() + "/";
        // 当前文件 资源服务器地址
        String currentResPath = "";
        
        //云模式，直接返回文件服务的外网地址
        if(isCloudModel){
        	currentResPath = resService;
        	return currentResPath;
        }
        
		
        if (host.contains(URI)) {
            currentResPath = resService;
        }
        else if (hostLocal.contains(URI)) {
            currentResPath = resServiceLocal;
        }
       
        return currentResPath;
	}
	
	
	/**
	 * 获取当前浏览器下的自主学习平台的路径
	 * @param request
	 * @return
	 */
	public String getCurrentFdHost(HttpServletRequest request){
        String URI = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + request.getContextPath() + "/";
        // 当前  自主学习平台服务器地址
        String currentFdHost = "";
        
        
      //云模式，直接返回自主学习平台服务器地址的外网地址
        if(isCloudModel){
        	currentFdHost = fdHost;
        	return currentFdHost;
        }
        
		
        if (host.contains(URI)) {
        	currentFdHost = fdHost;
        }
        else if (hostLocal.contains(URI)) {
        	currentFdHost = fdHostLocal;
        }

        return currentFdHost;
	}
	
	
	/**
	 * 获取一个用于内部调用的host的地址
	 * @return
	 */
	public String getHostLocalOne(){
		// 如果内网地址有多个的话 取第一个
        if (hostLocal.indexOf(",") > 0) {
           return  hostLocal.split(",")[0];
        }
		return hostLocal;

	}


	public Boolean getIsRepeatLogin() {
		return isRepeatLogin;
	}


	public void setIsRepeatLogin(Boolean isRepeatLogin) {
		this.isRepeatLogin = isRepeatLogin;
	}


	public Boolean getIsCloudModel() {
		return isCloudModel;
	}

	public void setIsCloudModel(Boolean isCloudModel) {
		this.isCloudModel = isCloudModel;
	}


	public String getTkHost() {
		return tkHost;
	}


	public void setTkHost(String tkHost) {
		this.tkHost = tkHost;
	}


	public String getTkHostLocal() {
		return tkHostLocal;
	}


	public void setTkHostLocal(String tkHostLocal) {
		this.tkHostLocal = tkHostLocal;
	}


	public String getSceneEnglish() {
		return sceneEnglish;
	}


	public void setSceneEnglish(String sceneEnglish) {
		this.sceneEnglish = sceneEnglish;
	}


	public String getSceneEnglishLocal() {
		return sceneEnglishLocal;
	}


	public void setSceneEnglishLocal(String sceneEnglishLocal) {
		this.sceneEnglishLocal = sceneEnglishLocal;
	}


	public String getForum3Host() {
		return forum3Host;
	}


	public void setForum3Host(String forum3Host) {
		this.forum3Host = forum3Host;
	}


	public String getForum3HostLocal() {
		return forum3HostLocal;
	}


	public void setForum3HostLocal(String forum3HostLocal) {
		this.forum3HostLocal = forum3HostLocal;
	}
	
	
	/**
	 * 获取当前浏览器下的题库的路径
	 * @param request
	 * @return
	 */
	public String getCurrentTkHost(HttpServletRequest request){
        String URI = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + request.getContextPath() + "/";
        // 当前 题库服务器地址
        String currentTkHost = "";
        
        
      //云模式，直接返回题库服务器地址的外网地址
        if(isCloudModel){
        	currentTkHost = tkHost;
        	return currentTkHost;
        }
        
		
        if (host.contains(URI)) {
        	currentTkHost = tkHost;
        }
        else if (hostLocal.contains(URI)) {
        	currentTkHost = tkHostLocal;
        }

        return currentTkHost;
	}
	
	/**
	 * 获取当前浏览器下的情景英语的对接路径
	 * @param request
	 * @return
	 */
	public String getCurrentSceneEnglish(HttpServletRequest request){
        String URI = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + request.getContextPath() + "/";
        // 当前 情景英语服务器地址
        String currentSceneEnglish = "";
        
        
      //云模式，直接返回情景英语服务器地址的外网地址
        if(isCloudModel){
        	currentSceneEnglish = sceneEnglish;
        	return currentSceneEnglish;
        }
        
		
        if (host.contains(URI)) {
        	currentSceneEnglish = sceneEnglish;
        }
        else if (hostLocal.contains(URI)) {
        	currentSceneEnglish = sceneEnglishLocal;
        }

        return currentSceneEnglish;
	}
	
	/**
	 * 获取当前浏览器下的论坛3.0的路径
	 * @param request
	 * @return
	 */
	public String getCurrentForum3(HttpServletRequest request){
        String URI = request.getScheme() + "://" + request.getServerName() + (request.getServerPort() == 80 ? "" : (":" + request.getServerPort())) + request.getContextPath() + "/";
        // 当前  论坛3.0台服务器地址
        String currentForum3 = "";
        
        
      //云模式，直接返回论坛3.0服务器地址的外网地址
        if(isCloudModel){
        	currentForum3 = forum3Host;
        	return currentForum3;
        }
        
		
        if (host.contains(URI)) {
        	currentForum3 = forum3Host;
        }
        else if (hostLocal.contains(URI)) {
        	currentForum3 = forum3HostLocal;
        }

        return currentForum3;
	}
	
	
}
