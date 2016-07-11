package net.tfedu.zhl.cloud.resource.prepare.controller;

import javax.annotation.Resource;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;



public class PrepareControllerTest extends BaseControllerTestCase {

    @Resource
    PrepareController controller;

    /**
     * 返回json的结果对象
     */
    private ResultJSON result = new ResultJSON();

    @Test
    public void testAddPrepare() {
        request.addParameter("tfcode", "RJCZ010109");
        request.addParameter("title", "title_RJCZ010109");

        result = controller.addPrepare(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    @Test
    public void testEditPrepare() {
        request.addParameter("id", "525");
        request.addParameter("title", "140252_title_RJCZ010109");
        request.addParameter("_method", "PATCH");

        result = controller.addPrepare(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }
    
    
    @Test
    @Rollback
    public void testAddPrepareContent() throws Exception {
        long prepareId = 525;
//        request.addParameter("resIds", "4319500105");
//        request.addParameter("fromFlags", "0");
        request.addParameter("resIds", "4319500105,212992,212991");
        request.addParameter("fromFlags", "0,0,0");
        result = controller.addPrepareContent(prepareId, request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }
  
    
    @Test
    public void testGetlatestPrepare(){
    	
    	request.setAttribute("currentUserId", 390400126l);
    	result = controller.getLatestPrepare(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
    	
    }
    
    
    
    @Test
    public void testGetPrepare4BookList() throws Exception {

    	request.setAttribute("currentUserId", 390400126l);
    	request.setParameter("termId", "3");
    	request.setParameter("subjectId", "1");
       // <!-- timeLabel:withinweek、withinmonth、moreearly  -->  

    	request.setParameter("timeLabel", "moreearly");
    	
        result = controller.getPrepare4book(1, 8, request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
    }
    
    

    @Test
    public void testDEletePrepare() {
        request.addParameter("id", "140253");
        request.addParameter("_method", "DELETE");

        result = controller.addPrepare(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

  

    @Test
    @Rollback
    public void testdelPrepareContent() throws Exception {
        request.addParameter("ids", "1365");
        result = controller.delPrepareContent(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    @Test
    public void testclearPrepareContent() throws Exception {
        request.addParameter("id", "140252");
        request.addParameter("_method", "CLEAR");
        result = controller.delPrepareContent(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    public void testFillREsource() throws Exception {

        String rescode = "newzy020101806612";
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");

        request.addParameter("rescode", rescode);
        request.addParameter("_method", "RESOURCEFILL");
        result = controller.fillPrepareContent(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));


    }

  
    
 
    @Test
    public void testgetViewUrl() throws Exception {
        request.addParameter("resIds", "181110105");
        request.addParameter("fromFlags", "0");
//        request.addParameter("clientType", "ePrepareClient");
//        request.addParameter("resIds", "870142");
//        request.addParameter("fromFlags", "4");
        request.setServerName("192.168.111.204");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        
        result = controller.getResViewUrl(request, response);
        log.info(JSONObject.toJSONString(result));
        request.addParameter("clientType", "ePrepareClient");
        result = controller.getResViewUrl(request, response);
        log.info(JSONObject.toJSONString(result));

        
        
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    @Test
    public void testGetPrepareList() throws Exception {

        request.addParameter("tfcode", "RJCZ010109");
    	request.setAttribute("currentUserId", 390400126l);

        result = controller.getPrepare(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }
    @Test
    public void testGetSelefPrepareList() throws Exception {

        request.addParameter("tfcode", "RJGZ04020101");
    	request.setAttribute("currentUserId", 390400126l);

        result = controller.getSelfPrepare(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }
    
    @Test
    public void testGetPreparePage() throws Exception {

    	request.setAttribute("currentUserId", 390400126l);
        request.addParameter("tfcode", "RJCZ010109");
        
        result = controller.getPreparePage(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }
    

    
    
    
    
    
    @Test
    public void testGetPrepareContent() throws Exception {
        long prepareId = 140249;
        result = controller.queryPrepareContent(prepareId, request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    
    
    
    
    @Test
    public void testGetPrepareContentPage() throws Exception {
        long prepareId = 140249;
        result = controller.queryPrepareContentPage(prepareId, 2, 1, request);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    @Test
    public void testGetLimitedPrepareContentPage() throws Exception {
        long prepareId = 140249;
        
        request.setParameter("isEPrepare", "1");
        result = controller.querylimitedPrepareContentPage(prepareId, 1, 10, request);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    }

    
    
    @Test
    public void testgetDown() throws Exception{
    	
        request.setServerName("192.168.111.204");
        request.setServerPort(8880);
        request.setContextPath("/resources");
        request.setScheme("http");
    	
    
    	
    	request.setParameter("resIds", "382950105,150400105,151960105");
    	request.setParameter("fromFlags", "0,0,0");
//    	request.setParameter("clientType", "ePrepareClient");
        result = controller.getDown(request, response);
        System.out.println(JSONObject.toJSONString(result));
        
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	
    }
    
    
    @Test
    public void copyPrepare() throws Exception {
		
    	long prepareId = 828l;
    	String tfcode = "CCXX0101090104";
    	
    	result = controller.copyPrepare(prepareId, tfcode);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	}
	

    @Test
	public void movePrepare() throws Exception {

    	long prepareId = 828l;
    	String tfcode = "CCXX0101090103";
		result =  controller.movePrepare(prepareId, tfcode);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

	}
    
    @Test
    public void testgetPrepareNodeInfo()throws Exception {
    	long prepareId = 828l;

    	result =  controller.getPrepareNodeInfo(prepareId, 10);
    	
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
        
        System.out.println(JSONObject.toJSONString(result));

    }
    
    
}
