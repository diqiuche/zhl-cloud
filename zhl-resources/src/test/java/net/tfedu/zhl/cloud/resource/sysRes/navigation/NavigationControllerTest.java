package net.tfedu.zhl.cloud.resource.sysRes.navigation;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.controller.NavigationController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

/**
 * 目录controller 单元测试
 * @author WeiCuicui
 *
 */
public class NavigationControllerTest extends BaseControllerTestCase{

	@Resource NavigationController navigationController;
	
	/**
	 * 学段controller单元测试
	 * @throws Exception
	 */
	@Test
	public void getAllTermsTest()throws Exception{
		
        ResultJSON json = navigationController.selectAllTerms(request, response);

        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 学科controller单元测试
	 * @throws Exception
	 */
	@Test
    public void testGetAllSubjectsByTerm() throws Exception {
        request.setParameter("termId", "1");
      
        ResultJSON json = navigationController.getAllSubjectsByTerm(request, response);
        
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }
	
	/**
	 * 根据学段、学科查询版本controller单元测试
	 * @throws Exception
	 */
	@Test
    public void testEditionController() throws Exception {

        request.setParameter("termId", "1");
        request.setParameter("subjectId", "1");
        
        ResultJSON json = navigationController.getAllEditions(request, response);
        
        
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }
	
	/**
	 * 根据版本id，查询教材controller单元测试
	 * @throws Exception
	 */
	@Test
    public void testBooksController() throws Exception {
       
        request.setParameter("pnodeId", "101140105");
        

        ResultJSON json = navigationController.getAllBooksByEdition(request, response);
       
        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));

    }
	
	
	/**
	 * 根据父结点id，目录树
	 * @throws Exception
	 */
	@Test
    public void testTreesController() throws Exception {
		
		request.setParameter("pnodeId", "67475");

        ResultJSON json = navigationController.getTreeNodes(request, response);

        JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
    }
}
