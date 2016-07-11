package net.tfedu.zhl.cloud.resource.poolTypeFormat.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.config.ResourceWebConfig;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResPool;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResType;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.service.ResFormatService;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.service.ResPoolService;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.service.ResTypeService;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 系统、区本、校本资源的类型、格式查询
 * 
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/resRestAPI")
public class TypesAndFormatsController {

	@Resource
    ResTypeService resTypeService;
	
	@Resource
    ResFormatService resFormatService;
	
	@Resource
    ResPoolService resPoolService;
	
	@Resource
    private ResourceWebConfig resourceWebConfig;
	
	/**
     * 查询所有的资源库
     * 
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/v1.0/pools", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getAllPools(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
        List<ResPool> pools = resPoolService.getAllPools();
      
        return ResultJSON.getSuccess(pools);
    }
	
	
	/**
	 * 查询系统资源的类型
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/sysResource/types", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getSysResTypesByPool(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
        //查询结果
        List<ResType> types = new ArrayList<ResType>();
        
        //资源来源
        List<Integer> sys_from = resourceWebConfig.getSys_from(request);

        //父结点tfcode
    	String pTfcode = ControllerHelper.getParameter(request, "pTfcode");
    	
    	//e备课需要排除的类型
    	List<Integer> removeTypeIds = resourceWebConfig.getRemoveTypes(request);
    	
    	//资源库id
    	long poolId = ControllerHelper.getLongParameter(request, "poolId");
    	
        if(request.getParameter("isEPrepare") != null){//e备课
        	//新的类型查询方法（去除一些类型）
        	types = resTypeService.getSysResTypes_EPrepare(poolId, pTfcode,removeTypeIds,sys_from);
        } else {
        	types = resTypeService.getSysResTypes(poolId, pTfcode,sys_from);
		}
        
        return ResultJSON.getSuccess(types);
    }
	
	/**
	 * 查询系统资源的格式
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/sysResource/formats", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getSysResFormatsByMtype(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
      
        List<String> formats = new ArrayList<String>();
        
        //系统资源来源
        List<Integer> sys_from = resourceWebConfig.getSys_from(request);
        
    	String pTfcode = ControllerHelper.getParameter(request, "pTfcode");
    	int typeId = ControllerHelper.getIntParameter(request, "typeId");
    	long poolId = ControllerHelper.getLongParameter(request, "poolId");

        // 根据 resourceIds和typeIds，查询资源格式
        //formats = resFormatService.getSysResFormats(poolId,pTfcode,typeId,sys_from);
    	formats = resFormatService.getSysResFormats(pTfcode,typeId,sys_from,poolId);
        return ResultJSON.getSuccess(formats);
    }
	
	/**
	 * 查询区本、校本资源的类型
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/districtResource/types", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getDisResTypesByPool(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
		
		List<ResType> types = null;
		
		long userId = (Long) request.getAttribute("currentUserId");
       
        //e备课需要排除的资源类型
        List<Integer> removeTypeIds = resourceWebConfig.getRemoveTypes(request);

    	String tfcode = ControllerHelper.getParameter(request, "tfcode");

    	//资源来源 3 校本；4 区本
    	int fromFlag = ControllerHelper.getIntParameter(request, "fromFlag");
   
        if(request.getParameter("isEPrepare") != null){//而备课
        	//新的类型查询方法（去除一些类型）
        	types = resTypeService.getDisResType_EPrepare(tfcode, fromFlag,userId, removeTypeIds);
        	
        } else {
        	 types = resTypeService.getDisResTypes(tfcode, fromFlag,userId);
		}
        
        return ResultJSON.getSuccess(types);
    }
	
	/**
	 * 查询区本、校本资源的格式
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/districtResource/formats", method = RequestMethod.GET)
    @ResponseBody
    public ResultJSON getDisFormats(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
		long userId = (Long) request.getAttribute("currentUserId");
        // 格式
        List<String> formats = new ArrayList<String>();
        String tfcode = ControllerHelper.getParameter(request, "tfcode");
    	int fromFlag = ControllerHelper.getIntParameter(request, "fromFlag");
    	int mtype = ControllerHelper.getIntParameter(request, "typeId");
    	
        //formats = resFormatService.getDisResFormats(tfcode,fromFlag,mtype);
    	formats = resFormatService.getDisResFormats(mtype,tfcode,fromFlag,userId);
        
        return ResultJSON.getSuccess(formats);
    }
}
