package net.tfedu.zhl.cloud.resource.questionbank.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.dao.JSyscourseMapper;
import net.tfedu.zhl.cloud.resource.navigation.entity.CourseViewTk;
import net.tfedu.zhl.cloud.resource.navigation.entity.EditionViewTK;
import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;
import net.tfedu.zhl.cloud.resource.questionbank.service.QuestionBankService;
import net.tfedu.zhl.cloud.resource.subjecttk.dao.JSubjectTikuMapper;
import net.tfedu.zhl.cloud.resource.subjecttk.entity.JSubjectTiku;
import net.tfedu.zhl.cloud.resource.subjecttk.entity.SubjectViewTK;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.city.dao.CityMapper;
import net.tfedu.zhl.sso.city.entity.City;
import net.tfedu.zhl.sso.district.dao.DistrictMapper;
import net.tfedu.zhl.sso.district.entity.District;
import net.tfedu.zhl.sso.province.dao.ProvinceMapper;
import net.tfedu.zhl.sso.province.entity.Province;
import net.tfedu.zhl.sso.school.dao.JSchoolMapper;
import net.tfedu.zhl.sso.school.entity.JSchool;
import net.tfedu.zhl.sso.subject.entity.JSubject;
import net.tfedu.zhl.sso.term.dao.JTermMapper;
import net.tfedu.zhl.sso.term.entity.JTerm;
import net.tfedu.zhl.sso.user.dao.JUserMapper;
import net.tfedu.zhl.sso.user.entity.UsersEntity;
import net.tfedu.zhl.sso.users.dao.SRegisterMapper;

import org.springframework.stereotype.Service;

/**
 * 题库对接的service
 * 
 * @author WeiCuicui
 * 
 */
@Service("questionBankService")
public class QuestionBankServiceImpl implements QuestionBankService {

	@Resource
	JUserMapper jUserMapper;
	@Resource
	ProvinceMapper provinceMapper;
	@Resource
	CityMapper cityMapper;
	@Resource
	DistrictMapper districtMapper;
	@Resource
	JSchoolMapper jSchoolMapper;
	@Resource
	JTermMapper jTermMapper;
	@Resource
	JSubjectTikuMapper subjectTkMapper;
	@Resource
	JSyscourseMapper jSyscourseMapper;

	/**
	 * 根据用户名，查询用户信息
	 * 
	 * @param userName
	 * @return
	 */
	@Override
	public ResultJSON queryUserBasicInfo(String userName) {

		List<UsersEntity> users = jUserMapper.queryUserBasicInfo(userName);
		return ResultJSON.getSuccess(users);
	}

	/**
	 * 查询所有省份
	 * 
	 * @return
	 */
	@Override
	public ResultJSON queryProvince() {
		List<Province> provinces = provinceMapper.queryProvince();
		return ResultJSON.getSuccess(provinces);
	}

	/**
	 * 查询省份下的所有市
	 * 
	 * @param provinceId
	 * @return
	 */
	@Override
	public ResultJSON queryCityByProvinceId(long provinceId) {
		List<City> cities = cityMapper.queryCityByProvinceId(provinceId);
		return ResultJSON.getSuccess(cities);
	}

	/**
	 * 根据所在市，查询所有区
	 * 
	 * @return
	 */
	@Override
	public ResultJSON queryDistirctByCityId(long cityId) {
		List<District> districts = districtMapper.queryDistirctByCityId(cityId);
		return ResultJSON.getSuccess(districts);
	}

	/**
	 * 根据所在区，查询所有学校
	 * 
	 * @param districtIds
	 * @return
	 */
	@Override
	public ResultJSON querySchoolByDistrictId(long districtId) {
		List<JSchool> schools = jSchoolMapper
				.querySchoolByDistrictId(districtId);
		return ResultJSON.getSuccess(schools);
	}

	/**
	 * 查询所有学段信息
	 * 
	 * @return
	 */
	@Override
	public ResultJSON queryTerm() {
		List<JTerm> terms = jTermMapper.getAllTerms();
		return ResultJSON.getSuccess(terms);
	}

	/**
	 * 查询学段下的学科列表
	 * 
	 * @param termId
	 * @return
	 */
	@Override
	public ResultJSON querySubjectByTermId(long termId) {
		List<JSubject> subjects = jTermMapper.querySubjectByTermId(termId);
		return ResultJSON.getSuccess(subjects);
	}

	@Override
	public ResultJSON getSchoolSubject(String sch_id) {
		// TODO Auto-generated method stub

		List<JSubjectTiku> list = subjectTkMapper.selectAll();
		List<SubjectViewTK> result = new ArrayList<SubjectViewTK>();
		for (Iterator<JSubjectTiku> iterator = list.iterator(); iterator.hasNext();) {
			JSubjectTiku view = iterator.next();
			SubjectViewTK obj = new SubjectViewTK();
			obj.setSubj_id(view.getId().toString());
			obj.setSubj_name(view.getName());
			result.add(obj);
		}
		return ResultJSON.getSuccess(result);
	}

	@Override
	public ResultJSON queryCourseByTermIdSubjectId(String term_id,
			String subj_id) throws Exception {
		if (StringUtils.isEmpty(term_id) || StringUtils.isEmpty(subj_id)) {
			throw new ParamsException();
		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("termId", term_id);
		map.put("subjectId", subj_id);
		List<JSyscourse> list = jSyscourseMapper.getAllEditions2(map);
		List<EditionViewTK> result = new ArrayList<EditionViewTK>();
		for (Iterator<JSyscourse> iterator = list.iterator(); iterator.hasNext();) {
			JSyscourse view =  iterator.next();
			EditionViewTK obj = new EditionViewTK();
			obj.setCour_id(view.getId().toString());
			obj.setCour_name(view.getName());
			obj.setCour_tf_code(view.getTfcode());
			obj.setOrderNum(view.getOrdernum());
			result.add(obj);
		}
		return ResultJSON.getSuccess(result);
	}

	@Override
	public ResultJSON queryCourseTree(String cour_id) throws Exception {
		if (StringUtils.isEmpty(cour_id)) {
			throw new ParamsException();
		}

		JSyscourse obj = jSyscourseMapper.selectByPrimaryKey(Long
				.parseLong(cour_id));
		String proCode = "tk";
		String tfcode = obj.getTfcode();
		String _tfcode = tfcode+"%";
		List<String> tfcodeList = jSyscourseMapper.getProductTfcode(_tfcode, proCode);
		
		List<CourseViewTk> list = new ArrayList<CourseViewTk>();
		for (Iterator<String> iterator = tfcodeList.iterator(); iterator.hasNext();) {
			String temp_tfcode = iterator.next();
			list.addAll(jSyscourseMapper.getAllCourseTreeInfo(temp_tfcode+"%",
					proCode));
		}
		return ResultJSON.getSuccess(list);
	}

	@Override
	public ResultJSON queryKnowlagePointTree(String term_id, String subj_id)
			throws Exception {
		if (StringUtils.isEmpty(term_id) || StringUtils.isEmpty(subj_id)) {
			throw new ParamsException();
		}
		return ResultJSON.getSuccess(jSyscourseMapper.getKnowladgeTree(term_id,
				subj_id));
	}

	@Override
	public ResultJSON querySubjectByDistrictId(String dist_id) throws Exception {
		return getSchoolSubject(null);
	}
}
