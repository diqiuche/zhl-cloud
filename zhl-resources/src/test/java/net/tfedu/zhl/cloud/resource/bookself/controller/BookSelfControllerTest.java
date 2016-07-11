package net.tfedu.zhl.cloud.resource.bookself.controller;

import javax.annotation.Resource;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;

public class BookSelfControllerTest extends BaseControllerTestCase {

	
	@Resource
	BookSelfController controller;
	
	

	@Test
	public void test() {
		
		ResultJSON json =  controller.getUserCourseware(request, response);
		System.out.println(json.toString());
		
	}
	
	@Test
	public void testGETMYbook() {
		
    	request.setAttribute("currentUserId", 390320126l);
		ResultJSON json =  controller.getMyBook(request, response);
		System.out.println(json.toString());
		
	}
	@Test
	public void testGETSysBook() {
		
		request.setParameter("tfcode", "CXCZ01010101");
		ResultJSON json =  controller.getSysBook(request, response);
		System.out.println(json.toString());
		
	}
	
	
	@Test
	public void testqueryUserCoursewareAll(){
    	request.setAttribute("currentUserId", 390320126l);	
    	request.setParameter("title", "3");
    	request.setParameter("orderby", "title");
		ResultJSON json =  controller.getUserCoursewareAll(request, response);
		System.out.println(json.toString());

	}
	

}
