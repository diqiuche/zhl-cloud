package net.tfedu.zhl.cloud.resource.sysRes.resPreview;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.resPreview.controller.ResPreviewController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * 资源预览页面的controller单元测试
 * @author WeiCuicui
 *
 */
public class ResPreviewControllerTest extends BaseControllerTestCase{

	@Resource ResPreviewController  controller;

	/**
	 * 查询一条资源的详细信息controller单元测试
	 * @throws Exception
	 *//*
	@Test
	public void testGetOneResController() throws Exception {

		request.setParameter("resId", "870537");
		request.setParameter("fromFlag", "3");
		//request.setParameter("isEPrepare", "1");
		
		ResultJSON json =  controller.getResPreviewInfo(request, response);
		
        JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
		
	}
	
	*//**
	 * 根据resId，查询资源的所有版本目录
	 * @throws Exception
	 *//*
	@Test
	public void testGetAllLists()throws Exception{
		request.setParameter("resId", "12");
		request.setParameter("fromFlag", "0");
		request.setParameter("curTfcode", "RJCZ010109");
		
		ResultJSON json =  controller.getAllLists(request, response);
		
        JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}*/
	
	/**
	 * 资源检索结果   的资源推荐列表
	 * @throws Exception
	 */
	@Test
	public void testGetResRecommendation_search()throws Exception{
		
		request.setParameter("resId", "1");
		request.setParameter("fromFlag", "3");
		request.setParameter("page", "1");
		request.setParameter("perPage", "20");
		request.setParameter("isSearch", "1");
		request.setParameter("searchKeyword", "p");
		request.setParameter("format", "全部");

		ResultJSON json =  controller.getResRecommendation(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 系统资源   的资源推荐列表
	 * @throws Exception
	 */
	@Test
	public void testGetSysResRecommendation()throws Exception{
		
		request.setParameter("resId", "3");
		request.setParameter("fromFlag", "0");
		request.setParameter("page", "1");
		request.setParameter("perPage", "20");
		
		request.setParameter("poolId", "0");
		request.setParameter("tfcode", "RJCZ010109");
		request.setParameter("typeId", "0");
		request.setParameter("orderBy", "0");
		request.setParameter("format", "全部");

		ResultJSON json =  controller.getResRecommendation(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 区本、校本资源     的资源推荐列表
	 * @throws Exception
	 */
	@Test
	public void testGetDisResRecommendation()throws Exception{
		
		request.setParameter("currentUserId", "390440126");
		request.setParameter("resId", "870234");
		request.setParameter("fromFlag", "3");
		request.setParameter("page", "1");
		request.setParameter("perPage", "20");
		
		request.setParameter("tfcode", "CZYW010101");
		request.setParameter("typeId", "0");
		request.setParameter("orderBy", "0");
		request.setParameter("format", "全部");

		ResultJSON json =  controller.getResRecommendation(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 个人中心-我的上传  的资源推荐列表
	 * @throws Exception
	 */
	@Test
	public void testGetResRecommendation_upload()throws Exception{
		
		request.setParameter("currentUserId", "390440126");
		request.setParameter("resId", "1");
		request.setParameter("fromFlag", "1");
		request.setParameter("page", "1");
		request.setParameter("perPage", "20");

		ResultJSON json =  controller.getResRecommendation(request, response);
		
		JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
}
