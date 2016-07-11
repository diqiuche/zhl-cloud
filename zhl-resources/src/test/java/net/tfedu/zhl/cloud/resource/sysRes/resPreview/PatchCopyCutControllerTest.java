package net.tfedu.zhl.cloud.resource.sysRes.resPreview;

import java.io.IOException;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.asset.controller.AssetController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

public class PatchCopyCutControllerTest extends BaseControllerTestCase {

	@Resource AssetController assetController;

	/**
	 * 批量复制
	 * @throws IOException
	 */
	@Test
	public void testPatchCopy()throws IOException{
		request.setParameter("tfcode", "RJCZ01010501");
		request.setParameter("resIds", "164882427,164882428");
		
		ResultJSON json = assetController.patchCopyAsset(request, response);
		
		JsonUtil.toJsonString(json);
		
		Assert.isTrue("OK".equals(json.getCode()));
	}
	
	
	/**
	 * 批量剪切
	 * @throws IOException
	 */
	@Test
	public void testPatchCut()throws IOException{
		
		request.setParameter("_method", "CUT");
		request.setParameter("tfcode", "RJCZ01010501"); //原来所在tfcode
		request.setParameter("des_tfcode", "CXCZ01010101");
		request.setParameter("resIds", "164882422,164882423"); //目标tfcode
		
		ResultJSON json = assetController.patchCopyAsset(request, response);
		
		JsonUtil.toJsonString(json);
	        
	    Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 批量删除
	 * @throws IOException
	 */
	@Test
	public void testPatchDel()throws IOException{
		
		request.setParameter("_method", "DELETE");
		request.setParameter("tfcode", "CXCZ01010101");
		request.setParameter("resIds", "164882422,164882423");
		
		ResultJSON json = assetController.patchDelAsset(request, response);
		
		JsonUtil.toJsonString(json);
	        
	    Assert.isTrue("OK".equals(json.getCode()));
	}
}
