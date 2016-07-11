package net.tfedu.zhl.sso.role.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

public class RoleControllerTest  extends BaseControllerTestCase{

	
	@Resource
	RoleController  controller;
	
	ResultJSON result ; 
	
	@Test
	public void testQueryRolesForTeachingResearch() throws Exception  {
		result = controller.queryRolesForTeachingResearch();
		Assert.isTrue(null!=result && "ok".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
		
	}
	
	
	@Test
	public void testAddUserRole() throws Exception  {
		result = controller.addUserRole(request, 17,new long[]{1,23});
		Assert.isTrue(null!=result && "ok".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
		
	}

}
