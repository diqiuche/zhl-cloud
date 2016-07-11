package net.tfedu.zhl.cloud.resource.resourceList.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

public class ResourceListControllerTest  extends BaseControllerTestCase{
	
	@Resource
	ResourceListController controller;
	

	@Test
	public void testGetSysResources() throws Exception {
		
		request.setParameter("poolId", "0");
		request.setParameter("mTypeId", "0");
		request.setParameter("fileFormat", "全部");
		request.setParameter("tfcode", "RJGZ010201");
		request.setParameter("orderBy", "0");
		request.setParameter("page", "1");
		request.setParameter("perPage", "10");
		
		
		ResultJSON result =  controller.getSysResources(request, response);
		
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		
		log.info(JSONObject.toJSONString(result));
		
	}

	@Test
	public void testGetDisResource() throws Exception {
		
		
		request.setAttribute("currentUserId", 390320126l);
		
		request.setParameter("poolId", "0");
		request.setParameter("mTypeId", "0");
		request.setParameter("fileFormat", "全部");
		request.setParameter("tfcode", "RJGZ010201");
		request.setParameter("orderBy", "0");
		request.setParameter("page", "1");
		request.setParameter("perPage", "10");
		request.setParameter("fromFlag", "0");
		ResultJSON result =  controller.getDisResource(request, response);
		
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		
		log.info(JSONObject.toJSONString(result));
		
	}

}
