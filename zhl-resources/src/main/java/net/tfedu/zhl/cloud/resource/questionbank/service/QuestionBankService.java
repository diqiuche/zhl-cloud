package net.tfedu.zhl.cloud.resource.questionbank.service;

import net.tfedu.zhl.helper.ResultJSON;

public interface QuestionBankService {

	/**
	 * 根据用户名，查询用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public ResultJSON queryUserBasicInfo(String userName);

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
	 * 查询所有学段信息
	 * 
	 * @return
	 */
	public ResultJSON queryTerm();

	/**
	 * 查询学段下的学科列表
	 * 
	 * @param termId
	 * @return
	 */
	public ResultJSON querySubjectByTermId(long termId);

	/**
	 * 查询学校学科列表接口
	 * 
	 * @param sch_id
	 * @return
	 */
	public ResultJSON getSchoolSubject(String sch_id);

	/**
	 * 按学段学科查询教材列表接口
	 * 
	 * @param sch_id
	 * @return
	 */
	public ResultJSON queryCourseByTermIdSubjectId(String term_id,
			String subj_id) throws Exception;

	/**
	 * 查询教材下的所有教材目录树接口
	 * 
	 * @param sch_id
	 * @return
	 */
	public ResultJSON queryCourseTree(String cour_id) throws Exception;

	/**
	 * 按学段科目查询知识点目录树接口
	 * 
	 * @param sch_id
	 * @return
	 */
	public ResultJSON queryKnowlagePointTree(String term_id, String subj_id)
			throws Exception;

	/**
	 * 查询地区学科列表接口
	 * 
	 * @param sch_id
	 * @return
	 */

	public ResultJSON querySubjectByDistrictId(String dist_id) throws Exception;

}
