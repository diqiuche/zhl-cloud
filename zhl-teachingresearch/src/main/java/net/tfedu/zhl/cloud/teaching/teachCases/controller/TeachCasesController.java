package net.tfedu.zhl.cloud.teaching.teachCases.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TCaseContents;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TContents;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TeachCases;
import net.tfedu.zhl.cloud.teaching.teachCases.service.TeachCasesService;
import net.tfedu.zhl.helper.PaginationHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 教学案例相关的接口
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/teachingServiceRestAPI")
public class TeachCasesController {

	@Resource TeachCasesService teachCasesService;
	
	/**
	 * 查询所有的教学案例
	 * @param request
	 * @param fromFlag  所属平台  0 双课堂 1 资源中心
	 * @param termId  学科id
	 * @param subjectId 学科id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllTeachCases(HttpServletRequest request,int fromFlag,int termId)throws Exception{
		
		int curPage = 1; //当前页，默认为第1页
		int perPageNum = 10; //每页记录数目，默认为10
		int subject = 0; //学科id，默认0，表示全部
		
		if(request.getParameter("page") != null )//若有传递页码
		    curPage = Integer.parseInt(request.getParameter("page").toString().trim());
		if(request.getParameter("perPage") != null )//若有传递每页记录数目
			perPageNum = Integer.parseInt(request.getParameter("perPage").toString().trim());
		if(request.getParameter("subjectId") != null )//若有传递页码
			subject = Integer.parseInt(request.getParameter("subjectId").toString().trim());
		
		PaginationHelper<TeachCases> pagination = teachCasesService.selectAllCases(fromFlag, termId, subject, curPage,perPageNum);
		
		return ResultJSON.getSuccess(pagination);
	}
	
	/**
	 * 新建一个教学案例
	 * @param request
	 * @param teachCase 上传一个教学案例的json字符串
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON createOneTeachCase(HttpServletRequest request,String teachCase)throws Exception{
		//当前用户
		Long userId = (Long) request.getAttribute("currentUserId");
		
		teachCasesService.createOneTeachCase(teachCase, userId);
		
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 编辑一个教学案例
	 * @param teachCase  编辑的一个教学案例的json字符串
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCasesEdit", method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON editOneTeachCase(HttpServletRequest request,String teachCase)throws Exception{
		//当前用户
	    Long userId = (Long) request.getAttribute("currentUserId");
		teachCasesService.editOneTeachCase(teachCase, userId);	
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 删除一条教学案例
	 * @param id  要删除的案例id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCasesDelete",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteOneTeachCase(long id)throws Exception{
		teachCasesService.deleteOneTeachCase(id);
		return ResultJSON.getSuccess(null);
	}
	
	
	/**
	 * 预览一条教学案例
	 * @param id  预览的案例id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/previewInfo",method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getOneTeachCasePreview(long id)throws Exception{
		
		//根据id查询一条案例的信息
		TeachCases item = teachCasesService.selectOneTeachCase(id);
		return ResultJSON.getSuccess(item);
	}
	
	/**
	 * 查询一个教学案例下的所有内容
	 * @param id  案例id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/contents", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getContentsInOneTeachCase(long id)throws Exception{
		List<TCaseContents> list = teachCasesService.getAllContents(id);
		return ResultJSON.getSuccess(list);		
	}

	
	/**
	 * 增加一个内容
	 * @param request
	 * @param caseId  所属案例id
	 * @param typeId  内容类型id
	 * @param fname   上传的文件名
	 * @param title   内容标题
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/contents",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON createOneContent(HttpServletRequest request,long caseId,int typeId,String fname,String title)throws Exception{
		//当前用户
	    Long userId = (Long) request.getAttribute("currentUserId");
		String result = teachCasesService.addOneContent(caseId, typeId, fname, title,userId);
		return ResultJSON.getSuccess(result);
	}
	
	/**
	 * 删除一个内容
	 * @param id 内容id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/contentsDelete",method = RequestMethod.POST)
	@ResponseBody
	public ResultJSON deleteOneContent(long id)throws Exception{
		teachCasesService.deleteOneContent(id);
		return ResultJSON.getSuccess(null);
	}
	
	/**
	 * 查询所有内容类型
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/teachCases/contentTypes",method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getAllTypes(HttpServletRequest request)throws Exception{
		List<TContents> list = teachCasesService.getAllContentTypes();
		return ResultJSON.getSuccess(list);
	}
}
