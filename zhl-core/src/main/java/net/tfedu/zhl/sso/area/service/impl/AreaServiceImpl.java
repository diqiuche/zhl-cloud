package net.tfedu.zhl.sso.area.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.area.service.AreaService;
import net.tfedu.zhl.sso.city.dao.CityMapper;
import net.tfedu.zhl.sso.city.entity.City;
import net.tfedu.zhl.sso.district.dao.DistrictMapper;
import net.tfedu.zhl.sso.district.entity.District;
import net.tfedu.zhl.sso.grade.dao.GradeMapper;
import net.tfedu.zhl.sso.grade.entity.Grade;
import net.tfedu.zhl.sso.province.dao.ProvinceMapper;
import net.tfedu.zhl.sso.province.entity.Province;
import net.tfedu.zhl.sso.school.dao.JSchoolMapper;
import net.tfedu.zhl.sso.school.entity.JSchool;


@Service("areaServiceImpl")
public class AreaServiceImpl implements AreaService {
	@Resource
	ProvinceMapper provinceMapper;
	@Resource
	CityMapper cityMapper;
	@Resource
	DistrictMapper districtMapper;
	@Resource
	JSchoolMapper jSchoolMapper;
	
	@Resource
	GradeMapper gradeMapper;

	
	

	@Override
	public ResultJSON queryProvince() {
		List<Province> provinces = provinceMapper.queryProvince();
		return ResultJSON.getSuccess(provinces);
	}

	@Override
	public ResultJSON queryCityByProvinceId(long provinceId) {
		List<City> cities = cityMapper.queryCityByProvinceId(provinceId);
		return ResultJSON.getSuccess(cities);
	}

	@Override
	public ResultJSON queryDistirctByCityId(long cityId) {
		List<District> districts = districtMapper.queryDistirctByCityId(cityId);
		return ResultJSON.getSuccess(districts);
	}

	@Override
	public ResultJSON querySchoolByDistrictId(long districtId) {
		List<JSchool> schools = jSchoolMapper
				.querySchoolByDistrictId(districtId);
		return ResultJSON.getSuccess(schools);
	}

	@Override
	public ResultJSON queryClassBySchoolId(long schoolId) {
		// TODO Auto-generated method stub
		List<Grade> list = gradeMapper.queryGradeBySchoolId(schoolId);
		return ResultJSON.getSuccess(list);
	}

}
