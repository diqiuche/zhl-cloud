package net.tfedu.zhl.cloud.resource.resSearch.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.config.ResourceWebConfig;
import net.tfedu.zhl.cloud.resource.resSearch.entity.ResSearchResultEntity;
import net.tfedu.zhl.cloud.resource.resSearch.service.ResSearchService;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.resource.resourceList.util.ResThumbnailPathUtil;
import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 资源跨库检索的controller
 * 
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/resRestAPI")
public class ResSearchController {

    @Resource
    ResSearchService resSearchService;
    
    @Resource
    private CommonWebConfig commonWebConfig;
    
    @Resource
    private ResourceWebConfig resourceWebConfig;
    
    //写入日志
    Logger logger = LoggerFactory.getLogger(ResSearchController.class);

    /**
     * 根据检索内容，跨库检索所有资源
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/v1.0/resSearchResults")
    @ResponseBody
    public ResultJSON getAllResources(HttpServletRequest request, HttpServletResponse response) throws Exception {
       
        // 分页查询结果
        Pagination<ResSearchResultEntity> pagination = null;

        //获取文件服务器的访问url 
    	String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);
		List<Integer> sys_from = resourceWebConfig.getSys_from(request);
		int expire = resourceWebConfig.getExpire(request);
		
		// 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
		
		// 检索范围 0 全部资源 1 系统资源 3 校本资源 4 区本资源
		int fromFlag = ControllerHelper.getIntParameter(request, "fromFlag");
		
		 // 检索的关键词
        String searchKeyword = ControllerHelper.getParameter(request, "searchKeyword");
		
        // 资源格式：全部，文本，图片......
        String format = ControllerHelper.getParameter(request, "format");
        
        // 页码
        int page = ControllerHelper.getIntParameter(request, "page");
        
        // 每页记录数目
        int perPage = ControllerHelper.getIntParameter(request, "perPage");
        
        searchKeyword = searchKeyword.toString().trim();
    	pagination = resSearchService.getResources(fromFlag, sys_from, searchKeyword, format, page,
                perPage,currentUserId,expire);
        
        //生成文件的缩略图路径
        ResThumbnailPathUtil.convertToPurpos_resSearch(pagination.getList(), resServiceLocal, currentResPath);
        
        logger.debug("检索关键字：" + searchKeyword);
        logger.debug("资源格式：" + format);
        logger.debug("资源来源fromFlag：" + fromFlag);
        logger.debug("检索结果的当前页：" + pagination.getPage());
        logger.debug("检索结果每页资源数目：" + pagination.getPerPage());
        logger.debug("检索到的资源总页：" + pagination.getTotal());
        logger.debug("检索到的资源总数：" + pagination.getTotalLines());
        
        return ResultJSON.getSuccess(pagination);
    }
    
    /**
     * 查询资源检索结果中的格式
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/v1.0/resSearchResults/formats")
    @ResponseBody
    public ResultJSON getResFormats(HttpServletRequest request,HttpServletResponse response)throws Exception{
   
        // 当前登录用户id
        Long currentUserId = (Long) request.getAttribute("currentUserId");
        
        List<String> resultList = new ArrayList<String>();
        
        // 检索范围 -1 全部  0 全部资源 1 系统资源 3 校本资源 4 区本资源
    	int fromFlag = ControllerHelper.getIntParameter(request, "fromFlag");
    	List<Integer> sys_from = resourceWebConfig.getSys_from(request);
        // 检索的关键词
    	String searchKeyword = ControllerHelper.getParameter(request, "searchKeyword");
    	
    	searchKeyword = searchKeyword.toString().trim();
    	resultList = resSearchService.getFileFormats(searchKeyword, fromFlag, sys_from,currentUserId);
        
        return ResultJSON.getSuccess(resultList);
    }

}
