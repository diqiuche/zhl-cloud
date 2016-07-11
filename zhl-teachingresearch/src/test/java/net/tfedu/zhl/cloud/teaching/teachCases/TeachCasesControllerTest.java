package net.tfedu.zhl.cloud.teaching.teachCases;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.teachCases.controller.TeachCasesController;
import net.tfedu.zhl.cloud.teaching.teachCases.controller.TeachCasesTermSubjectController;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

/**
 * 教学案例相关接口单元测试
 * @author WeiCuicui
 *
 */
public class TeachCasesControllerTest extends BaseControllerTestCase {

	
	@Resource TeachCasesTermSubjectController teachCasesTermSubjectController;
	@Resource TeachCasesController teachCasesController;
	ResultJSON result ;
	
	//获取所有年级
	@Test
	public void testAllGrades() throws Exception{
	
		result = teachCasesTermSubjectController.getAllGrades();
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	//查询学段下的学科
	@Test
    public void testSubjectsByTerm() throws Exception{
    	int termId = 1;
    	result = teachCasesTermSubjectController.getSubjectsByTerm(termId);
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
    
	//查询所有学段
	@Test
    public void testAllTerms()throws Exception{
    	result = teachCasesTermSubjectController.getTerms();
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	//查询所有的教学案例
	@Test
	public void getAllTeachCases()throws Exception{
		int fromFlag = 1;
		int termId = 1;
		
		result = teachCasesController.getAllTeachCases(request,fromFlag, termId);
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	/*//预览一个教学案例的信息
	@Test
	public void getOneTeachCaseInfo()throws Exception{
		long id = 1;
		result = teachCasesController.getOneTeachCasePreview(id);
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	//删除一个教学案例
	@Test
	public void deleteOneTeachCase()throws Exception{
		long id = 1;
		result = teachCasesController.deleteOneTeachCase(id);
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	//查询一个教学案例下的所有内容
	@Test
	public void getAllContents()throws Exception{
		long id = 1;
		result = teachCasesController.getContentsInOneTeachCase(id);
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}
	
	//删除一个内容
	@Test
	public void deleteOneContent()throws Exception{
		long id = 1;
		result = teachCasesController.deleteOneContent(id);
		Assert.isTrue("OK".equalsIgnoreCase(result.getCode()));
		log.info(JSONObject.toJSONString(result));
	}*/
	
}
