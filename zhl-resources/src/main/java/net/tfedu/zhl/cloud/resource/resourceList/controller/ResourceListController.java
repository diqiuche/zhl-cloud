package net.tfedu.zhl.cloud.resource.resourceList.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.config.ResourceWebConfig;
import net.tfedu.zhl.cloud.resource.navigation.service.UserDefaultService;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.service.ResTypeService;
import net.tfedu.zhl.cloud.resource.resourceList.entity.DisResourceEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.SysResourceEntity;
import net.tfedu.zhl.cloud.resource.resourceList.service.DisResService;
import net.tfedu.zhl.cloud.resource.resourceList.service.SysResourceService;
import net.tfedu.zhl.cloud.resource.resourceList.util.ResThumbnailPathUtil;
import net.tfedu.zhl.config.CommonWebConfig;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 查询系统、区本、校本资源列表
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/resRestAPI")
public class ResourceListController {

	@Resource
    SysResourceService sysResourceService;
	
    @Resource
    ResTypeService resTypeService;
    
    @Resource
    DisResService disResService;
    
    @Resource
    private CommonWebConfig commonWebConfig;
    
    @Resource
    private ResourceWebConfig resourceWebConfig;
    
    
	 @Resource
	 UserDefaultService userDefaultService;
    
    //写入日志
    Logger logger = LoggerFactory.getLogger(ResourceListController.class);

    /**
     * 查询系统资源列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/sysResource", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getSysResources(HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 查询结果，封装为pagination
        Pagination<SysResourceEntity> pagination = null;
        // 当前登录用户id
    	long userId = (Long) request.getAttribute("currentUserId");
       
        //获取文件服务器的访问url 
		String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);
		
		//e备课排除的资源类型
		List<Integer> removeTypeIds = resourceWebConfig.getRemoveTypes(request);
		
		//判断是否为最新资源的期限
		int expire = resourceWebConfig.getExpire(request);
		
		//资源来源
		List<Integer> sys_from = resourceWebConfig.getSys_from(request);
		
		 // 资源库id
		long poolId = ControllerHelper.getLongParameter(request, "poolId");
		// 类型Id
		int mTypeId = ControllerHelper.getIntParameter(request, "mTypeId");
		 // 资源格式
		String fileFormat= ControllerHelper.getParameter(request, "fileFormat");
		 // 课程tfcode
		String tfcode = ControllerHelper.getParameter(request, "tfcode");
		// 排序方式（综合排序；最多下载；最新发布）
		int orderBy = ControllerHelper.getIntParameter(request, "orderBy");
		// 页码
		int page = ControllerHelper.getIntParameter(request, "page");
		 // 每页的记录数
		int perPage = ControllerHelper.getIntParameter(request, "perPage");
		
        if(request.getParameter("isEPrepare") != null){//若当前访问的是 e备课
        	//模糊查询的关键字
        	String searchWord = request.getParameter("searchWord");
        	//e备课查询系统资源
        	pagination = sysResourceService.getAllSysRes_EPrepare(poolId, mTypeId, fileFormat, tfcode, orderBy, page, perPage, searchWord, removeTypeIds,sys_from,expire);
        	//生成文件的缩略图路径
            ResThumbnailPathUtil.convertToPurpos_sys(pagination.getList(), resServiceLocal, currentResPath);
        } else {
        	 // 查询出的系统资源信息
            pagination = sysResourceService.getAllSysRes(poolId, mTypeId, fileFormat, tfcode, orderBy, page,
                    perPage,sys_from,expire);
            //生成文件的缩略图路径
            ResThumbnailPathUtil.convertToPurpos_sys(pagination.getList(), resServiceLocal, currentResPath);   
		}
       
        
        /**
         * 修改用户的节点选择
         */
        userDefaultService.updateUserHistoryDefault(userId, tfcode, 1);
        
        logger.debug("系统资源的课程id：" + tfcode);
        logger.debug("系统资源的资源格式：" + fileFormat);
        if(pagination != null){
        	 logger.debug("查询结果的当前页：" + pagination.getPage());
             logger.debug("查询结果每页资源数目：" + pagination.getPerPage());
             logger.debug("查询到的资源总页：" + pagination.getTotal());
             logger.debug("查询到的资源总数：" + pagination.getTotalLines());
        }
        
        return ResultJSON.getSuccess(pagination);
    }
    
    /**
     * 查询区本、校本资源列表
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/districtResource", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getDisResource(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        // 当前登录用户id
    	long userId = (Long) request.getAttribute("currentUserId");
        Pagination<DisResourceEntity> pagination = null;
        
        //获取文件服务器的访问url 
    	String resServiceLocal = commonWebConfig.getResServiceLocal();
		String currentResPath = commonWebConfig.getCurrentResPath(request);
		List<Integer> removeTypeIds = resourceWebConfig.getRemoveTypes(request);
		int expire = resourceWebConfig.getExpire(request);

		// 类型Id
		int mTypeId = ControllerHelper.getIntParameter(request, "mTypeId");
		 // 资源格式
		String fileFormat= ControllerHelper.getParameter(request, "fileFormat");
		 // 课程tfcode
		String tfcode = ControllerHelper.getParameter(request, "tfcode");
		// 排序方式（综合排序；最多下载；最新发布）
		int orderBy = ControllerHelper.getIntParameter(request, "orderBy");
		// 页码
		int page = ControllerHelper.getIntParameter(request, "page");
		 // 每页的记录数
		int perPage = ControllerHelper.getIntParameter(request, "perPage");
		 // 资源来源
        int fromFlag = ControllerHelper.getIntParameter(request, "fromFlag");
      
        if(request.getParameter("isEPrepare") != null){//若当前访问的是 e备课
        	//e备课 模糊查询的关键字
        	String searchWord = request.getParameter("searchWord");
        	pagination = disResService.selectAllDisRes_EPrepare(userId, mTypeId, fileFormat, tfcode, orderBy, page, perPage, fromFlag, searchWord, removeTypeIds,expire);
        	//生成文件的缩略图路径
            ResThumbnailPathUtil.convertToPurpos_dis(pagination.getList(), resServiceLocal, currentResPath); 
        } else { //普通区本校本资源接口
        	 pagination = disResService.selectAllDisRes(userId, mTypeId, fileFormat, tfcode, orderBy, page, perPage,
                     fromFlag,expire);
        	 //生成文件的缩略图路径
             ResThumbnailPathUtil.convertToPurpos_dis(pagination.getList(), resServiceLocal, currentResPath);
		}

        /**
         * 修改用户的节点选择
         */
        userDefaultService.updateUserHistoryDefault(userId, tfcode, 1);
        
        
        if(fromFlag == 3)
        	logger.debug(fromFlag + " : 校本资源");
        else if(fromFlag == 4)
        	logger.debug(fromFlag + " : 区本资源");
        
        logger.debug("校本 / 区本资源的资源格式：" + fileFormat);
        if(pagination != null){
       	    logger.debug("查询结果的当前页：" + pagination.getPage());
            logger.debug("查询结果每页资源数目：" + pagination.getPerPage());
            logger.debug("查询到的资源总页：" + pagination.getTotal());
            logger.debug("查询到的资源总数：" + pagination.getTotalLines());
        }
        return ResultJSON.getSuccess(pagination);
    }
}
