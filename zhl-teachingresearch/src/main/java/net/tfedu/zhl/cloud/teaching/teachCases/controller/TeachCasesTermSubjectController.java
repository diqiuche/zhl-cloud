package net.tfedu.zhl.cloud.teaching.teachCases.controller;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.teaching.teachCases.service.TeachCasesTermSubjectService;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 教学案例涉及学段、学科、年级的接口
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/teachingServiceRestAPI")
public class TeachCasesTermSubjectController {

@Resource TeachCasesTermSubjectService teachCasesTermSubjectService;
	
	/**
	 * 查询所有的年级
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/grades", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllGrades()throws Exception{
		
		return ResultJSON.getSuccess(teachCasesTermSubjectService.getAllGrades());
	}
	
	/**
	 * 查询所有学段
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/terms", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getTerms()throws Exception{
		
		return ResultJSON.getSuccess(teachCasesTermSubjectService.getAllTerms());
	}
	
	/**
	 * 查询学段下的学科
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/subjects", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getSubjectsByTerm(int termId)throws Exception{
		
		return ResultJSON.getSuccess(teachCasesTermSubjectService.getSubjectsByTerm(termId));
	}
}
