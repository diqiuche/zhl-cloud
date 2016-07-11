package net.tfedu.zhl.cloud.resource.asset.controller;

import java.io.IOException;

import javax.annotation.Resource;

import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

public class AssetControllerTest  extends BaseControllerTestCase{

	
    @Resource
	AssetController assetController;
	
    private ResultJSON result = new ResultJSON();
	
	
	@Test
	public void testGetUploadUrl() {
		
    	request.setAttribute("currentUserId", 390320126l);
		result = assetController.getUploadUrl(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));

		
		
	}

	@Test
	public void testUploadConvertCallBack() {
		request.setAttribute("currentUserId", 390410126l);
		request.setParameter("file", "upFile\\2016\\390410126\\10105\\2016051015414738198-88.docx");
		request.setParameter("ext", "rename&userId=390410126");
		
		String _result = assetController.uploadConvertCallBack(request, response);
		
		Assert.isTrue("SUCCESS".equals(_result)) ;
		
	}

	@Test
	public void testAddAsset() throws Exception {
    	request.setAttribute("currentUserId", 390320126l);
    	//网络资源
		
		request.setParameter("names", "网络资源测试");
		request.setParameter("unifTypeIds", "2");
		request.setParameter("tfcodes", "CZYW010101");
		request.setParameter("scopes", "1");
		request.setParameter("keywords", "java");
		request.setParameter("descs", "");
		request.setParameter("paths", "http://bug.tfedu.net/mantis/images/mantis_logo.png");
		request.setParameter("sizes", "1111111");
		request.setParameter("iscoursewares", "0");
		request.setParameter("islocals", "1");
		result = assetController.deleteAsset(request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	
		
		
	}
	
	@Test
	public void testDeleteAsset() throws Exception {
    	request.setAttribute("currentUserId", 390320126l);
	
		
		request.setParameter("names", "证照登记");
		request.setParameter("unifTypeIds", "2");
		request.setParameter("tfcodes", "CZYW010101");
		request.setParameter("scopes", "1");
		request.setParameter("keywords", "java");
		request.setParameter("descs", "123");
		request.setParameter("paths", "upFile\\2016\\390410126\\10105\\2016051015350940900-81.xlsx");
		request.setParameter("sizes", "1111111");
		request.setParameter("iscoursewares", "0");
		request.setParameter("islocals", "0");
		result = assetController.deleteAsset(request, response);

		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	
		
		
	}

	@Test
	public void testQueryAsset() {
		
		request.setAttribute("currentUserId", 390320126l);

		result = assetController.queryAsset(request, response);
		
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		
	}

	@Test
	public void testGetAssetOne() throws Exception {
		result =  assetController.getAssetOne(164883600l, request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
	}

	@Test
	public void testUpdateAsset() throws Exception {
		
		
		request.setAttribute("currentUserId", 390320126l);

    	
    	
    	long id  = 164882966;
		request.setParameter("_method", "PUT");
		request.setParameter("name", "QQ截图20160422103031");
		request.setParameter("unifTypeId", "1");
		request.setParameter("scope", "1");
		request.setParameter("tfcode", "CXCZ01010101");
		request.setParameter("keyword", "QQ截图20160422103031");
		request.setParameter("desc", "QQ截图20160422103031");
		request.setParameter("path", "upFile\\2016\\390440126\\10105\\2016042715433678613-48.png");
		request.setParameter("size", "683695");
		
		result = 	assetController.updateAsset(id, request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		
	}

	@Test
	public void testPatchCopyAsset() {
		//fail("Not yet implemented");
	}

	@Test
	public void testPatchDelAsset() {
		//fail("Not yet implemented");
	}

	@Test
	public void testGetCourseAssetType() throws ParamsException, IOException {

        request.setParameter("isEPrepare", "1");
		request.setAttribute("currentUserId", 390330126l);
    	request.setParameter("tfcode", "CZYW010101");
    	request.setParameter("title", "2");
		result =  assetController.getCourseAssetType(request, response);
		Assert.isTrue("ok".equalsIgnoreCase(result.getCode()));
		
	}

	@Test
	public void testGetCourseAsset() throws ParamsException, IOException {
        request.setParameter("isEPrepare", "1");

    	request.setAttribute("currentUserId", 390320126l);
    	request.setParameter("tfcode", "CZYW010101");
    	request.setParameter("title", "");

		result = assetController.getCourseAsset(request, response);
		
		Assert.isTrue("OK".equals(result.getCode()));
		
	}

}
