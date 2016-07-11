package net.tfedu.zhl.sso.province.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.province.entity.Province;

public interface ProvinceMapper extends CoreMapper<Province> {
	/**
	 * 查询所有省份信息
	 * @return
	 */
	public List<Province> queryProvince();
	
	
	
	/**
	 * 查询省
	 * @param name
	 * @return
	 */
	public List<Province> queryProvinceByName(@Param("name")String name);
	
	
	
}