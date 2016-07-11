package net.tfedu.zhl.sso.district.dao;

import java.util.List;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.district.entity.District;

import org.apache.ibatis.annotations.Param;

public interface DistrictMapper extends CoreMapper<District> {
	
	/**
	 * 查询市下的区
	 * @param cityId
	 * @return
	 */
	public List<District> queryDistirctByCityId(@Param("cityId")long cityId);
	
	/**
	 * 查询市下的区
	 * @param cityId
	 * @param name
	 * @return
	 */
	public List<District> queryDistirctByCityIdANDName(@Param("cityId")long cityId,@Param("name")String name);
}