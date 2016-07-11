package net.tfedu.zhl.cloud.resource.questionbank.controller;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.questionbank.aop.ResultQuestion;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.helper.tests.BaseControllerTestCase;

import org.junit.Test;
import org.springframework.util.Assert;

import com.alibaba.fastjson.JSONObject;

public class QuestionBankControllerTest extends BaseControllerTestCase{

	
	
	@Resource
	QuestionBankController controller;
	
	
	Object result ;

	/**
	 * 根据name，查询用户信息
	 * @throws Exception
	 */
	@Test
	public void testGetBasicUserInfo() throws Exception {
		request.setParameter("user_name", "csls01");
		result = controller.getBasicUserInfo(request,response);
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}

	/**
	 * 查询省份
	 * @throws Exception
	 */
	@Test
	public void testGetProvince() throws Exception {
		result = controller.getProvince(request, response);
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}
	
	/**
	 * 查询省下的市
	 * @throws Exception
	 */
	@Test
	public void testGetCities() throws Exception {
		request.setParameter("pro_id", "1");
		result = controller.queryCityByProvinceId(request, response);
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}
	
	/**
	 * 查询市下的区
	 * @throws Exception
	 */
	@Test
	public void testGetDistricts() throws Exception {
		request.setParameter("city_id", "1");
		result = controller.queryDistirctByCityId(request, response);
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}
	
	/**
	 * 查询区下的学校
	 * @throws Exception
	 */
	@Test
	public void testGetSchools() throws Exception {
		request.setParameter("dist_id", "10");
		result = controller.querySchoolByDistrictId(request, response);
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}
	
	/**
	 * 查询学段
	 * @throws Exception
	 */
	@Test
	public void testGetTerms() throws Exception {

		result = controller.queryTerm(request, response);
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}
	
	/**
	 * 查询学段下的学科
	 * @throws Exception
	 */
	@Test
	public void testGetSubjects() throws Exception {
		request.setParameter("term_id", "2");
		result = controller.querySubjectByTermId(request, response);
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}
	
	/**
	 * 根据版本id，查询教材，通用controller的单元测试
	 * @throws Exception
	 */
	@Test
    public void testBooksController_product() throws Exception {
       
        request.setParameter("pnodeId", "101140105");
        
        result = controller.getAllBooksByEdition_product(request, response);
       
        if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}

    }
	

	@Test
	public void testGetSchoolSubject() throws Exception {
		
		
		result = controller.getSchoolSubject("278");
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
		
	}

	@Test
	public void testQueryCourseByTermIdSubjectId() throws Exception {
		result = controller.queryCourseByTermIdSubjectId("1", "1");
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}

	@Test
	public void testQueryCourseTree() throws Exception {
		
		result = controller.queryCourseTree("16646");
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
		
	}

	@Test
	public void testQueryKnowlagePointTree() throws Exception {
		result = controller.queryKnowlagePointTree("1", "1");
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}

	@Test
	public void testUserLogin() throws Exception {
		result = controller.userLogin("csls10", "111111");
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}

	@Test
	public void testQuerySubjectByDistrictId() throws Exception {
		result = controller.querySubjectByDistrictId("10");
		System.out.println(JSONObject.toJSONString(result));
		if(result instanceof ResultJSON){
			ResultJSON  json = (ResultJSON)result;
			Assert.isTrue("ok".equalsIgnoreCase(json.getCode()));
		}else if(result instanceof ResultQuestion){
			ResultQuestion json = (ResultQuestion)result;
			Assert.isTrue("success".equals(json.getMessage()));
		}else{
			Assert.isTrue(false);
		}
	}

}
