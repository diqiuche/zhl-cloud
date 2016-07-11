package net.tfedu.zhl.sso.school.dao;

import java.util.List;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.school.entity.JSchool;

import org.apache.ibatis.annotations.Param;

public interface JSchoolMapper extends CoreMapper<JSchool> {
	/**
	 * 查询区下的所有学校
	 * @param districtId
	 * @return
	 */
	public List<JSchool> querySchoolByDistrictId(@Param("districtId")long districtId);
	
	/**
	 * 查询区下的所有学校
	 * @param districtId
	 * @param name
	 * @return
	 */
	public List<JSchool> querySchoolByDistrictIdAndName(@Param("districtId")long districtId,@Param("name")String name);
	
	
	
}