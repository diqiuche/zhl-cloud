package net.tfedu.zhl.cloud.resource.sysRes.typeAndFormats;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.controller.TypesAndFormatsController;
import net.tfedu.zhl.cloud.utils.datatype.JsonUtil;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

public class TypeAndFormatControllerTest extends BaseControllerTestCase{

	@Resource TypesAndFormatsController typesAndFormatsController;
	
	/**
	 * 查询所有的资源库 controller单元测试
	 * @throws Exception
	 */
	@Test
    public void testGetAllPools() throws Exception {
      
        ResultJSON json = typesAndFormatsController.getAllPools(request, response);

        JsonUtil.toJsonString(json);
        
        Assert.isTrue("OK".equals(json.getCode()));
    }
	
	/**
	 * 系统资源   类型
	 */
	@Test
	public void testGetSysTypes()throws Exception{
		
		request.setParameter("pTfcode", "CZYW0101"); //设置课程结点tfcode
		request.setParameter("poolId", "0");
		
		ResultJSON json = typesAndFormatsController.getSysResTypesByPool(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 系统资源   类型  e备课
	 */
	@Test
	public void testGetSysTypes_ePrepare()throws Exception{
		
		request.setParameter("pTfcode", "CZYW0101"); //设置课程结点tfcode
		request.setParameter("poolId", "0");
		request.setParameter("isEPrepare", "1");
		
		ResultJSON json = typesAndFormatsController.getSysResTypesByPool(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 系统资源   格式
	 * @throws Exception
	 */
	@Test
	public void testGetSysFormats()throws Exception{
		request.setParameter("pTfcode", "CZYW0101");
		request.setParameter("typeId", "0");
		request.setParameter("poolId", "5");
		
		ResultJSON json = typesAndFormatsController.getSysResFormatsByMtype(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 区本、校本资源   类型
	 * @throws Exception
	 */
	@Test
	public void testGetDisTypes()throws Exception{
		request.setParameter("tfcode", "CZYW0101");
		request.setParameter("fromFlag", "3");
		
		ResultJSON json = typesAndFormatsController.getDisResTypesByPool(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 区本、校本资源   类型 e备课
	 * @throws Exception
	 */
	@Test
	public void testGetDisTypes_ePrepare()throws Exception{
		request.setParameter("tfcode", "CZYW0101");
		request.setParameter("fromFlag", "3");
		request.setParameter("isEPrepare", "1");
		
		ResultJSON json = typesAndFormatsController.getDisResTypesByPool(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
	
	/**
	 * 区本、校本资源   格式
	 * @throws Exception
	 */
	@Test
	public void testGetDisFormats()throws Exception{
		request.setParameter("tfcode", "CZYW0101");
		request.setParameter("fromFlag", "3");
		request.setParameter("typeId", "0");
		
		ResultJSON json = typesAndFormatsController.getDisFormats(request, response);
		JsonUtil.toJsonString(json);
        Assert.isTrue("OK".equals(json.getCode()));
	}
}
