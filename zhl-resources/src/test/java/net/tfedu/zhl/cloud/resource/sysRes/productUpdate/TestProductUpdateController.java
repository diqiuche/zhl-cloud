package net.tfedu.zhl.cloud.resource.sysRes.productUpdate;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.productUpdate.controller.ProductUpdateController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

public class TestProductUpdateController extends BaseControllerTestCase{

	@Resource ProductUpdateController productUpdateController;
	
	@Test
	public void testProductUpdate() throws Exception{
		request.setParameter("productCode", "HDKT");
		request.setParameter("versionCode", "1000");
		request.setParameter("productType", "1");
		
		ResultJSON json = productUpdateController.selectVersionsByCode(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
}
