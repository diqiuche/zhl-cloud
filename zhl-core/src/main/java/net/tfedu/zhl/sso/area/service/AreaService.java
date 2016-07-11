package net.tfedu.zhl.sso.area.service;

import net.tfedu.zhl.helper.ResultJSON;

public interface AreaService {
	
	
	/**
	 * 查询所有省份
	 * 
	 * @return
	 */
	public ResultJSON queryProvince();

	/**
	 * 查询省份下的所有市
	 * 
	 * @param provinceId
	 * @return
	 */
	public ResultJSON queryCityByProvinceId(long provinceId);

	/**
	 * 根据所在市，查询所有区
	 * 
	 * @return
	 */
	public ResultJSON queryDistirctByCityId(long cityId);

	/**
	 * 根据所在区，查询所有学校
	 * 
	 * @param districtIds
	 * @return
	 */
	public ResultJSON querySchoolByDistrictId(long districtId);
	
	/**
	 * 根据学校，查询所有班级
	 * 
	 * @param schoolId
	 * @return
	 */
	public ResultJSON queryClassBySchoolId(long schoolId);
	
	
	
	
	

}
