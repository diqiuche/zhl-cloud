package net.tfedu.zhl.cloud.resource.productUpdate.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.productUpdate.service.ProductUpdateService;
import net.tfedu.zhl.helper.ControllerHelper;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 产品升级controller
 * @author WeiCuicui
 *
 */
@Controller
@RequestMapping("/resRestAPI")
public class ProductUpdateController {

	@Resource ProductUpdateService productUpdateService;
	
	/**
	 * 根据产品编码、版本编码，查询升级文件及升级说明
	 * @param request
	 * @param response
	 */
	@RequestMapping(value = "/v1.0/versionsByCode", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON selectVersionsByCode(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String productCode = ControllerHelper.getParameter(request, "productCode");
		long versionCode = Long.parseLong(ControllerHelper.getParameter(request, "versionCode"));
		int productType = Integer.parseInt(ControllerHelper.getParameter(request, "productType"));
		return productUpdateService.selectVersionsByCode(productCode, versionCode, productType);
	}
	
	/**
	 * 根据产品编码、版本名称，查询升级文件及升级说明
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/v1.0/versionsByName", method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON selectVersionsByName(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String productCode = ControllerHelper.getParameter(request, "productCode");
		String versionName = ControllerHelper.getParameter(request, "versionName");
		int productType = Integer.parseInt(ControllerHelper.getParameter(request, "productType"));
		return productUpdateService.selectVersionsByName(productCode, versionName, productType);
	}
}
