package net.tfedu.zhl.cloud.resource.navigation.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.config.ResourceWebConfig;
import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;
import net.tfedu.zhl.cloud.resource.navigation.entity.JUserDefault;
import net.tfedu.zhl.cloud.resource.navigation.entity.TreeNode;
import net.tfedu.zhl.cloud.resource.navigation.service.BookService;
import net.tfedu.zhl.cloud.resource.navigation.service.EditionService;
import net.tfedu.zhl.cloud.resource.navigation.service.TermService;
import net.tfedu.zhl.cloud.resource.navigation.service.TermSubjectService;
import net.tfedu.zhl.cloud.resource.navigation.service.TreeService;
import net.tfedu.zhl.cloud.resource.navigation.service.UserDefaultService;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.subject.entity.JSubject;
import net.tfedu.zhl.sso.term.entity.JTerm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 系统、区本、校本
 * 资源导航页面的controller
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/resRestAPI")
public class NavigationController {
	
	 @Resource
	 TermService termService;
	 
	 @Resource
	 TermSubjectService termSubjectService;
	 
	 @Resource
	 EditionService editionService;
	 
	 @Resource
	 BookService bookService;
	 
	 @Resource
	 TreeService treeService;
	 
	 @Resource
	 UserDefaultService userDefaultService;
	 
	 @Resource
	 private ResourceWebConfig resourceWebConfig;
	 
	/**
	 *  查询所有学段
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/terms", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON selectAllTerms(HttpServletRequest request, HttpServletResponse response) throws Exception {
     
        List<JTerm> terms = termService.selectAll();

        return ResultJSON.getSuccess(terms);
	 }
	
	 /**
	  *  查询学段下的所有学科
	  * @param request
	  * @param response
	  * @return
	  * @throws Exception
	  */
    @RequestMapping(value = "/v1.0/subjects", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getAllSubjectsByTerm(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
        List<JSubject> subjects = null;
        
        long termId = ControllerHelper.getLongParameter(request, "termId");
        subjects = termSubjectService.getAllSubjectsByTerm(termId);
    	return ResultJSON.getSuccess(subjects);
    }
    
    /**
     *  根据学段、学科，查询所有版本教材
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/editions", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getAllEditions(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
    	List<JSyscourse> editions = null;
    	
    	long termId = ControllerHelper.getLongParameter(request, "termId");
    	long subjectId = ControllerHelper.getLongParameter(request, "subjectId");
    	editions = editionService.getAllEditionsByTermAndSub(termId, subjectId);
    	return ResultJSON.getSuccess(editions);
    }

	 /**
     * 根据版本、产品编码，获得所有教材
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/books", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getAllBooksByEdition(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	
    	List<JSyscourse> books = null;

    	//产品码
    	String proCode = resourceWebConfig.getProCode();
    	
    	//父结点id
    	long pnodeId = ControllerHelper.getLongParameter(request, "pnodeId");
    
    	// 根据所属版本和产品编码，查询所有的教材
        books = bookService.getAllBooks(pnodeId, proCode);
        return ResultJSON.getSuccess(books);
    }
    
    
    /**
     * 查询系统课程目录结点
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/contents", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getTreeNodes(HttpServletRequest request, HttpServletResponse response) throws Exception {
    	
    	List<TreeNode> nodes = null;
    	//产品码
    	String proCode = resourceWebConfig.getProCode();
    	// 接收传递过来的父结点id
        long pnodeId = ControllerHelper.getLongParameter(request, "pnodeId");
        // 加载父结点的所有子结点（递归）
        nodes = treeService.getTreeNodes(pnodeId,proCode);
        return ResultJSON.getSuccess(nodes);
    }
    
    /**
     * 查询用户历史选择 使用GET方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/history", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getUserDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	//课程目录类型
    	int type = resourceWebConfig.getType(request);
    	// 当前登录用户id
    	long userId = (Long) request.getAttribute("currentUserId");
       
    	JUserDefault userDefault = userDefaultService.getUserHistoryDefault(userId,type);
    	
    	return ResultJSON.getSuccess(userDefault);
    }

    /**
     * 修改、增加用户历史选择
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/history", method = RequestMethod.POST)
    @ResponseBody
    public ResultJSON updateUserDefault(HttpServletRequest request, HttpServletResponse response) throws Exception {

    	// 用户id
        long userId = (Long) request.getAttribute("currentUserId");
        
        int type = resourceWebConfig.getType(request);

        // 结点tfcode
        String tfcode = ControllerHelper.getParameter(request, "tfcode");
        
        // 修改用户历史选择
        userDefaultService.updateUserHistoryDefault(userId,tfcode,type);
        return ResultJSON.getSuccess("");
    }

}
