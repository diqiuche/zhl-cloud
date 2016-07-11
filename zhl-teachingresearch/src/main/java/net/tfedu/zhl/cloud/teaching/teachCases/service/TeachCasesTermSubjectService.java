package net.tfedu.zhl.cloud.teaching.teachCases.service;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TGrade;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.TSubject;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.Term;

public interface TeachCasesTermSubjectService {

	/**
	 * 查询所有学段
	 * @return
	 */
	public List<Term> getAllTerms();
	
	/**
	 * 查询学段下的学科
	 * @return
	 */
	public List<TSubject> getSubjectsByTerm(int termId);
	
	
	/**
	 * 查询所有年级
	 * @return
	 */
	public List<TGrade> getAllGrades();
}
