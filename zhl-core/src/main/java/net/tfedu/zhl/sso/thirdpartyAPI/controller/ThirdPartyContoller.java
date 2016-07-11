package net.tfedu.zhl.sso.thirdpartyAPI.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLEncoder;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONObject;

import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.CustomException;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.httpclient.HttpClientUtils;
import net.tfedu.zhl.sso.thirdpartyAPI.jnzx.entity.ZXCheckResult;
import net.tfedu.zhl.sso.thirdpartyAPI.jnzx.entity.ZXUserInfoResult;
import net.tfedu.zhl.sso.users.entity.RegisterAddForm;
import net.tfedu.zhl.sso.users.entity.SRegister;
import net.tfedu.zhl.sso.users.service.RegisterService;




/**
 * 第三方对接的工具
 * @author wangwr
 *
 */
@Controller
@RequestMapping("/resRestAPI/thirdparty")
public class ThirdPartyContoller {
	
	
	
	Logger log = LoggerFactory.getLogger(ThirdPartyContoller.class);
	
	
	
	@Resource 
	RegisterService registerService;
	
	
	
	
	
	
	/**
	 * 登录页面
	 * @param request
	 * @param response
	 * @param platformcode 请求来源
	 * @param targetPage   登录后首页面地址
	 * @param thirdPartyToken   第三方登录的token
	 *       /thirdparty/login/jnzx/res_dhjj/xxx       济宁中兴访问资源动画教具库
	 * @return
	 * @throws URISyntaxException 
	 * @throws CustomException 
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	@RequestMapping(value="/v1.0/login/{platformcode}/{targetPage}/{thirdPartyToken}")	
	public Object login(HttpServletRequest request ,HttpServletResponse response
			,@PathVariable String platformcode
			,@PathVariable String targetPage
			,@PathVariable String thirdPartyToken
			) throws ClientProtocolException, IOException,Exception{
		
		
		
		/** 
		 * 传递Token   Token=Default--31d04cf9638240cd968425fdcae80e93
		 */
		String  Token = ControllerHelper.checkEmpty(thirdPartyToken);
		Token = Token.replace("--", "-");
		System.out.println("token="+Token);

		//接口中传递json数据
		String url = "http://edu.myjining.cn/serviceProxy/servlet/?json=";
        // 接收参数json列表  
        JSONObject json = new JSONObject();  
        json.put("SERVICE_CODE", "zteict.proxy.user.LoginStatus");
        json.put("CONSUMER_ID", Token);

		String result = HttpClientUtils.doGET(url+URLEncoder.encode(json.toJSONString(), "utf-8"));
		
		ZXCheckResult _result = JSONObject.parseObject(result, ZXCheckResult.class);
		//USER_ID不为空，就说明验证成功
		if(_result!=null && null!=_result.getBODY() && StringUtils.isNotEmpty(_result.getBODY().getUSER_ID())){
			String userName = _result.getBODY().getUSER_ID();
			
			//获取用户信息 
			
	        json.put("SERVICE_CODE", "com.zte.space.homework.business.BusinessCenter4Homework.open__getUserInfo");
	        json.put("CONSUMER_ID", Token);
	        json.put("USER_ID", userName);
	        
	        
	        result = HttpClientUtils.doGET(url+URLEncoder.encode(json.toJSONString(), "utf-8"));
			log.debug(result);
			ZXUserInfoResult info = JSONObject.parseObject(result, ZXUserInfoResult.class);
	        
	        String _userName = info.getBODY().getUSER_ID();
	        String _trueName = info.getBODY().getUSER_NAME();
	        String _nickName = info.getBODY().getNICKNAME();
	        String _sex = info.getBODY().getSEX();
	    	/**
	    	 * USER_TYPE是用户类型，00代表学生，01代表老师，02代表家长，11代表管理员。
	    	 */
	    	String _userType = info.getBODY().getUSER_TYPE();
	    	String _motto = info.getBODY().getMOTTO();
	    	
	    	/**
	    	 * 生日
	    	 */
	    	String _birthDate = info.getBODY().getBIRTH_DATE();

	    	/**
	    	 * 省
	    	 */
	    	String provinceName= info.getBODY().getPROVINCE_NAME();
	    	/**
	    	 * 市
	    	 */
	    	String cityName= info.getBODY().getCITY_NAME();
	    	/**
	    	 * 区
	    	 */
	    	String arealName= info.getBODY().getAREAL_NAME();
	    	/**
	    	 * 校
	    	 */
	    	String schoolName= info.getBODY().getSCHOOL_NAME();
	    	
	        
	    	SRegister register =  registerService.getRegister(_userName);
	    	if(register ==null || register.getId()<1){//用户不存在
	    		
	    		RegisterAddForm form = new RegisterAddForm();
	    		form.setProvinceName(provinceName);
	        	form.setCityName(cityName);
	        	form.setArealName(arealName);
	        	form.setSchoolName(schoolName);
	        	form.setMotto(_motto);
	        	form.setNickName(_nickName);
	        	form.setRole("00".equals(_userType)?1:2);
	        	form.setSex("0".equals(_sex)?false:true);
	        	form.setSubjectName("语文");
	        	form.setTermName("初中");
	        	form.setTrueName(_userName);
	        	form.setUserName(_trueName);
	        	register =  registerService.addRegister(form);
	    	}
			
			
			
			
			
			
			
			
			
			
		}else{
			log.error("校验第三方登录用户失败,平台编码("+platformcode+"),目标页面("+targetPage+"),thirdPartyToken("+thirdPartyToken+")");
			//校验失败
			response.sendRedirect("http://edu.myjining.cn/portal/login.html");
			return null;
		}
		return ResultJSON.getSuccess("") ;
	}
	
	
	
	
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		String url = "http://192.168.111.160:8080/zhl-resources/resRestAPI/thirdparty/v1.0/login/jnzx/res_dhjj/";
		
		System.out.println(URLEncoder.encode(url, "utf-8"));
		
	}
	
	

}
