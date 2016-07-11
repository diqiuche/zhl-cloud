package net.tfedu.zhl.cloud.teaching.teachCases.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TSubject;
import net.tfedu.zhl.cloud.teaching.teachCases.entity.Term;
import net.tfedu.zhl.helper.CoreMapper;

public interface TermMapper extends CoreMapper<Term> {
	
	/**
	 * 查询所有学段
	 * @return
	 */
	public List<Term> getAllTerms();
	
	/**
	 * 查询学段下的学科
	 * @param termId
	 * @return
	 */
	public List<TSubject> getSubjectsByTerm(@Param("termId") int termId);
}