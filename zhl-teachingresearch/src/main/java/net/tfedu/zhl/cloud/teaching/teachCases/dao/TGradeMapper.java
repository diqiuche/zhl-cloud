package net.tfedu.zhl.cloud.teaching.teachCases.dao;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TGrade;
import net.tfedu.zhl.helper.CoreMapper;

public interface TGradeMapper extends CoreMapper<TGrade> {
	
	/**
	 * 查询所有的班级
	 * @return
	 */
	public List<TGrade> getAllGrades();
}