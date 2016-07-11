package net.tfedu.zhl.cloud.resource.questionbank.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;
import net.tfedu.zhl.cloud.resource.navigation.service.BookService;
import net.tfedu.zhl.cloud.resource.questionbank.service.QuestionBankService;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.users.entity.SRegister;
import net.tfedu.zhl.sso.users.service.RegisterService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 题库对接接口
 * 
 * （复写3.0接口，原有的规范不变）
 * 
 * @author wangwr service 中返回ResultJSON 对象 通过切面编程 将 之转换成ResultQuestion 对象
 * 
 */
@Controller
public class QuestionBankController {

	@Resource
	QuestionBankService questionBankService;

	@Resource
	BookService bookService;

	@Resource
	RegisterService registerService;

	/**
	 * 根据user_name,查询用户信息
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_queryUserBasicInfo.action", method = RequestMethod.GET)
	@ResponseBody
	public Object getBasicUserInfo(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String userName = ControllerHelper.getParameter(request, "user_name")
				.toString().trim();

		return ResultJSON.getSuccess(questionBankService
				.queryUserBasicInfo(userName));
	}

	/**
	 * 查询所有省份信息
	 * 
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_queryProvince.action", method = RequestMethod.GET)
	@ResponseBody
	public Object getProvince(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		return ResultJSON.getSuccess(questionBankService.queryProvince());
	}

	/**
	 * 根据省份，查询所有的市
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_queryCityByProvinceId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object queryCityByProvinceId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long provinceId = ControllerHelper.getLongParameter(request, "pro_id");
		return ResultJSON.getSuccess(questionBankService
				.queryCityByProvinceId(provinceId));
	}

	/**
	 * 根据市，查询所有的区
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_queryDistirctByCityId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object queryDistirctByCityId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int cityId = ControllerHelper.getIntParameter(request, "city_id");
		return ResultJSON.getSuccess(questionBankService
				.queryDistirctByCityId(cityId));
	}

	/**
	 * 根据区，查询所有的学校
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_querySchoolByDistrictId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object querySchoolByDistrictId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int districtId = ControllerHelper.getIntParameter(request, "dist_id");
		return ResultJSON.getSuccess(questionBankService
				.querySchoolByDistrictId(districtId));
	}

	/**
	 * 查询所有的学段
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_queryTerm.action", method = RequestMethod.GET)
	@ResponseBody
	public Object queryTerm(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		return ResultJSON.getSuccess(questionBankService.queryTerm());
	}

	/**
	 * 根据学段，查询学科
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "questionbankajax_querySubjectByTermId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object querySubjectByTermId(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long termId = ControllerHelper.getLongParameter(request, "term_id");
		return ResultJSON.getSuccess(questionBankService
				.querySubjectByTermId(termId));
	}

	/**
	 * 根据版本、产品编码，查询所有教材（通用接口，产品编码默认为tk）
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/resRestAPI/v1.0/product/books", method = RequestMethod.GET)
	@ResponseBody
	public Object getAllBooksByEdition_product(HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		List<JSyscourse> books = null;

		String proCode = "tk";

		if (StringUtils.isNotEmpty(request.getParameter("proCode")))
			proCode = ControllerHelper.getParameter(request, "proCode");

		// 父结点id
		long pnodeId = ControllerHelper.getLongParameter(request, "pnodeId");

		// 根据所属版本和产品编码，查询所有的教材
		books = bookService.getAllBooks(pnodeId, proCode);
		return ResultJSON.getSuccess(books);
	}

	/**
	 * 查询学校学科列表接口
	 * 
	 * @param sch_id
	 * @return
	 */
	@RequestMapping(value = "questionbankajax_querySubjectBySchoolId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object getSchoolSubject(String sch_id) throws Exception {

		return questionBankService.getSchoolSubject(sch_id);

	}

	/**
	 * 按学段学科查询教材列表接口
	 * 
	 * @param sch_id
	 * @return
	 */
	@RequestMapping(value = "questionbankajax_queryCourseByTermIdSubjectId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object queryCourseByTermIdSubjectId(String term_id, String subj_id)
			throws Exception {

		return questionBankService.queryCourseByTermIdSubjectId(term_id,
				subj_id);

	}

	/**
	 * 查询教材下的所有教材目录树接口
	 * 
	 * @param sch_id
	 * @return
	 */
	@RequestMapping(value = "questionbankajax_queryCourseTree.action", method = RequestMethod.GET)
	@ResponseBody
	public Object queryCourseTree(String cour_id) throws Exception {

		return questionBankService.queryCourseTree(cour_id);

	}

	/**
	 * 按学段科目查询知识点目录树接口
	 * 
	 * @param sch_id
	 * @return
	 */
	@RequestMapping(value = "questionbankajax_queryKnowlagePointTree.action", method = RequestMethod.GET)
	@ResponseBody
	public Object queryKnowlagePointTree(String term_id, String subj_id)
			throws Exception {

		return questionBankService.queryKnowlagePointTree(term_id, subj_id);

	}

	/**
	 * 用户登录接口
	 * 
	 * @param sch_id
	 * @return
	 */
	@RequestMapping(value = "questionbankajax_userLogin.action", method = RequestMethod.GET)
	@ResponseBody
	public Object userLogin(String user_name, String user_pwd) throws Exception {
		if (StringUtils.isEmpty(user_name) || StringUtils.isEmpty(user_pwd)) {
			throw new ParamsException();
		}

		SRegister register = registerService.login(user_name, user_pwd);

		return questionBankService
				.queryUserBasicInfo(register.getName().trim());

	}

	/**
	 * 查询地区学科列表接口
	 * 
	 * @param sch_id
	 * @return
	 */
	@RequestMapping(value = "questionbankajax_querySubjectByDistrictId.action", method = RequestMethod.GET)
	@ResponseBody
	public Object querySubjectByDistrictId(String dist_id) throws Exception {

		return questionBankService.querySubjectByDistrictId(dist_id);

	}

}
