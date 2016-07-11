package net.tfedu.zhl.cloud.teaching.teachingdesign.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.users.entity.SRegister;
import net.tfedu.zhl.sso.users.service.RegisterService;



/**
 * 教学设计研究
 * @author wangwr
 *
 */
@Controller
@RequestMapping("/teachingServiceRestAPI")
public class TeachingDesignController {
	
	
	@Resource
	RegisterService regSerivce;
	
	
	@Resource
	CommonWebConfig config ;
	
	/**
	 * 返回 论坛3.0的访问url
	 * @return
	 */
	@RequestMapping(value="/v1.0/discuss",method= RequestMethod.GET)
	@ResponseBody
	public ResultJSON  discuss(HttpServletRequest request,
			HttpServletResponse response){		
		
		// 当前登录用户id
		Long currentUserId = (Long) request.getAttribute("currentUserId");
		SRegister register = regSerivce.getRegister(currentUserId);
		String userName = register.getName();

		String  forum3 =  config.getCurrentForum3(request);		
		String url = forum3+"/auth/process?username="+userName;		
		return ResultJSON.getSuccess(url) ;
	}
	
	
	
	
	
	
	
	
	
	

}
