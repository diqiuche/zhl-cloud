package net.tfedu.zhl.cloud.resource.sysRes.resSearch;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.resSearch.controller.ResSearchController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * 资源检索页面的controller单元测试
 * @author WeiCuicui
 *
 */
public class ResSearchControllerTest extends BaseControllerTestCase{

	@Resource ResSearchController resSearchController;
	
	/**
	 * 资源检索结果列表
	 * @throws Exception
	 */
	@Test
	public void testResSearchResult()throws Exception{
		
		request.setParameter("fromFlag", "0");
		request.setParameter("format", "全部");
		request.setParameter("searchKeyword", "数学");
		request.setParameter("userId", "699230735");
		request.setParameter("page", "1");
		request.setParameter("perPage", "20");
		
		ResultJSON json = resSearchController.getAllResources(request, response);
		
        JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
		
	}
	
	/**
	 * 资源检索结果的格式
	 * @throws Exception
	 */
	@Test
	public void testResSearchResultFormats()throws Exception{
		
		request.setParameter("searchKeyword", "数学");
		request.setParameter("fromFlag", "0");
		request.setParameter("userId", "699230735");
	
		ResultJSON json = resSearchController.getResFormats(request, response);
		
        JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
	}
}
