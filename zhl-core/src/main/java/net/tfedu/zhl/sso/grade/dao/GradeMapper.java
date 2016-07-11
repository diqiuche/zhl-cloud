package net.tfedu.zhl.sso.grade.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.grade.entity.Grade;
import net.tfedu.zhl.sso.grade.entity.GradeAreaInfo;

public interface GradeMapper extends CoreMapper<Grade> {
	
	
	
	/**
	 * 查询学校下的审核的班级
	 * @param schoolId
	 * @return
	 */
	public List<Grade> queryGradeBySchoolId(@Param("schoolId") long schoolId);
	
	
	/**
	 * 查询班级的地区信息
	 * @param classId
	 * @return
	 */
	public GradeAreaInfo getGradeAreaInfo(@Param("classId") String classId);
	
	
	
	
}