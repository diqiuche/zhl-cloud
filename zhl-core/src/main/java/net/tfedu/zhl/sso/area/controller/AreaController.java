package net.tfedu.zhl.sso.area.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.area.service.impl.AreaServiceImpl;

/**
 * 查询地区信息
 * 省市区县
 * @author wangwr
 *
 */
@Controller
@RequestMapping("/*RestAPI")
public class AreaController {
	
	
	@Resource
	AreaServiceImpl areaServiceImpl;
	
	/**
	 * 获取全部的省份列表
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/v1.0/provinceList" ,method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getProvinceList() throws Exception {
		
		return  areaServiceImpl.queryProvince() ;
	}
	
	/**
	 * 获取省份下的所有市
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/v1.0/cityList" ,method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getProvinceList(long provinceId) throws Exception {
		
		return  areaServiceImpl.queryCityByProvinceId(provinceId);
	}
	
	
	/**
	 * 获取市的全部地区
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/v1.0/districtList" ,method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getDistrictList(long cityId) throws Exception {		
		return  areaServiceImpl.queryDistirctByCityId(cityId);
	}
	
	
	/**
	 * 获取地区下的学校
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/v1.0/schoolList" ,method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getSchoolList(long districtId) throws Exception {		
		return  areaServiceImpl.querySchoolByDistrictId(districtId);
	}
	
	/**
	 * 获取学校下的班级
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/v1.0/classList" ,method = RequestMethod.GET)
	@ResponseBody
	public ResultJSON getClassList(long schoolId) throws Exception {		
		return  areaServiceImpl.queryClassBySchoolId(schoolId);
	}
	

}
