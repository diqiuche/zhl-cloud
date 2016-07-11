package net.tfedu.zhl.cloud.resource.other;


import javax.annotation.Resource;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

public class AdditionalControllerTest extends BaseControllerTestCase{

	
	@Resource
	AdditionalController controller;
	
	ResultJSON result ;
	
	
	
	
	@Override
	public void onSetUp() {
		// TODO Auto-generated method stub
		super.onSetUp();
		request.setServerName("192.168.111.204");
		request.setServerPort(8880);
		request.setContextPath("/resources");
		request.setScheme("http");
	}

	@Test
	public void testSceneEnglish() throws Exception {
		
		
		result = controller.sceneEnglish(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}

	@Test
	public void testQuestionLibrary()throws Exception  {
		result = controller.questionLibrary(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}

	@Test
	public void testForum3()throws Exception  {
		result = controller.forum3(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	
	@Test
	public void testforum3_old() throws Exception{
		result = controller.forum3_old(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}

}
