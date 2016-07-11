package net.tfedu.zhl.sso.message.controller;


import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMethod;

@Transactional
public class MessageControllerTest extends BaseControllerTestCase {
	
	@Autowired
	MessageController controller;
	
	ResultJSON result ; 

	@Test
	public void testGetNewMessageNum() {
		request.setAttribute("currentUserId", 390320126l);
		result = controller.getNewMessageNum(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	}

	
	
	@Test
	public void testGetUserNewMessage() {
		request.setAttribute("currentUserId", 390320126l);
		result = controller.getUserNewMessage(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	}

	
	
	@Test
	public void testUpdateMessageStatus() throws Exception {
		request.setAttribute("currentUserId", 390320126l);
		request.setParameter("_method", RequestMethod.PATCH.name());
		result = controller.updateMessageStatus(1l,request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	}

	
	
	
}
