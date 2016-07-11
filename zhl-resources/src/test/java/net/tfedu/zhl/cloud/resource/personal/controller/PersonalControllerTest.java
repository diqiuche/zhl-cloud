package net.tfedu.zhl.cloud.resource.personal.controller;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

public class PersonalControllerTest extends BaseControllerTestCase {

	
	
	@Autowired
	PersonalController controller;
	
	
  /*  
    @Test
    public void testGetResTypeForPersonal(){
//    	request.setParameter("", "");
    	
    	request.setAttribute("currentUserId", 390320126l);
    	request.setAttribute("tabCode", "myPrepareRes");
    	
    	
    	ResultJSON json =  controller.getResTypeForPersonal(request, response);
    	System.out.println(json.toString());
    	
    	
    }
    @Test
    public void testGetResTypeForPersonal2(){
//    	request.setParameter("", "");
    	
    	request.setAttribute("currentUserId", 390320126l);
    	request.setAttribute("tabCode", "myUpload");
    	
    	
    	ResultJSON json =  controller.getResTypeForPersonal(request, response);
    	System.out.println(json.toString());
    	
    	
    }
    @Test
    public void testGetResTypeForPersonal3(){
//    	request.setParameter("", "");
    	
    	request.setAttribute("currentUserId", 390320126l);
    	request.setAttribute("tabCode", "myDownload");
    	
    	
    	ResultJSON json =  controller.getResTypeForPersonal(request, response);
    	System.out.println(json.toString());
    	
    	
    }
    @Test
    public void testGetResTypeForPersonal4(){
//    	request.setParameter("", "");
    	
    	request.setAttribute("currentUserId", 390320126l);
    	request.setAttribute("tabCode", "myView");
    	
    	
    	ResultJSON json =  controller.getResTypeForPersonal(request, response);
    	System.out.println(json.toString());
    	
    	
    }

    
    
    
    @Test
    public void testGetAutolearning(){
    	request.setAttribute("currentUserId", 1l);
    	ResultJSON json = this.controller.autoLearning(request, response);
    	System.out.println(json.toString());
    	
    }
    
    
    @Test
    public void testgetUnReview(){
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        request.setAttribute("currentUserId", 390320126l);
        
        ResultJSON result = controller.getUnReview(request, response);
    	
        System.out.println(result.toString());
        
    	
    }
    
    
    @Test
    public void testcustomizeRes(){
    	
        ResultJSON result = controller.getCustomizeRes(request, response);
        System.out.println(result.toString());
    	
    }*/
    
    @Test
    public void testgetMyPrepareResource(){
    	
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        request.setAttribute("currentUserId", 390320126l);
        request.setParameter("unifyTypeId", "1");

        ResultJSON result = controller.getMyPrepareResource(request, response);
        
        System.out.println(result.toString());

    	
    }
    @Test
    public void testgetMyDown(){
    	
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        request.setAttribute("currentUserId", 390410126l);
        request.setParameter("unifyTypeId", "1");
        ResultJSON result = controller.getMyDownload(request, response);
        System.out.println(JSONObject.toJSONString(result.getData()));

    	
    }
    
    
    @Test
    public void testgetMyreview(){
    	
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        request.setAttribute("currentUserId", 390320126l);
        request.setParameter("reviewType", "3");
        ResultJSON result = controller.getMyReview(request, response);
        System.out.println(result.toString());

    	
    }
    
    @Test
    public void testgetMyview(){
    	
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        request.setAttribute("currentUserId", 390320126l);
        request.setParameter("unifyTypeId", "1");
        ResultJSON result = controller.getMyViewList(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
    	
    }
    
    
    /**
     * 
     */
    @Test
    public void testGetUnifyType(){
    	
        ResultJSON result = controller.getUnifyType(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    	
    	
    }
    /**
     * @throws Exception 
     * 
     */
    @Test
    public void testGetUnifyType4ext() throws Exception{
    	
    	String ext = ".doc";
        ResultJSON result = controller.getUnifyType4ext(ext);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

    	
    	
    } 
    
    
    
    @Test
    public void testPrepareStatis()throws Exception{
    	
    	request.setAttribute("currentUserId", 390410126l);
        ResultJSON result = controller.prepareStatis(request, response);

        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
        System.out.println(JSONObject.toJSONString(result));

    }
    
    @Test
    public void testgetMyReviewComment() throws Exception{
    	
        request.setServerName("192.168.111.160");
        request.setServerPort(8080);
        request.setContextPath("/zhl-resources");
        request.setScheme("http");
        request.setAttribute("currentUserId", 390320126l);
        request.setParameter("reviewType", "1");
        ResultJSON result = controller.getMyReviewComment(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
        
        request.setParameter("reviewType", "3");
        result = controller.getMyReviewComment(request, response);
        Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
    	
    }
}
