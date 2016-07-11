package net.tfedu.zhl.message.service;

import javax.annotation.Resource;


import org.junit.Test;

import com.github.pagehelper.PageInfo;
import net.tfedu.zhl.helper.tests.BaseServiceTestCase;
import net.tfedu.zhl.sso.message.service.JMessageService;

public class JMessageServiceTest extends BaseServiceTestCase {
	
	@Resource 
	JMessageService jMessageService;
	
	
	long userId = 390370126;
	
	@Test
	public void testNUm() {
		jMessageService.getUserNewMessageNumber(userId);
	}
	
	@Test
	public void testQuery(){
		
		int page =1 ;
		int perPage = 10 ;
		PageInfo obj =  jMessageService.queryMessage(userId, page, perPage);
		
		System.out.println(obj.getList().size());
	}


	@Test
	public void testUpdate(){
		
		long id = 521039;
		
		jMessageService.updateMessageReaded(id);
		
	}
	
	
	@Test
	public void testAdd(){
		

		//jMessageService.updateMessageReaded(521039l);
		
	}
	
	

	@Test
	public void testDel(){
		
		
	}
	
}

