package net.tfedu.zhl.cloud.resource.customizeres.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.customizeres.entity.CustomizeResResult;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomizeResServiceTest extends BaseControllerTestCase {

	
	@Autowired
	CustomizeResService service ;
	
	
	@Test
	public void test() {
		List<CustomizeResResult> result =  service.getCustomizeResResult();
		
		System.out.println(result.size());
		
	}

}
