package net.tfedu.zhl.cloud.resource.navigation.service;

import java.util.List;

import net.tfedu.zhl.sso.subject.entity.JSubject;

/**
 * 查询学段下的所有学科
 * 
 * @author WeiCuicui
 *
 */
public interface TermSubjectService {

    /**
     *  查询学段下的所有学科
     * @param termId
     * @return
     */
    public List<JSubject> getAllSubjectsByTerm(Long termId);

}
