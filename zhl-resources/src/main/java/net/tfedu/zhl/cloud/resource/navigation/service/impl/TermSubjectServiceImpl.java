package net.tfedu.zhl.cloud.resource.navigation.service.impl;

import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.service.TermSubjectService;
import net.tfedu.zhl.sso.subject.entity.JSubject;
import net.tfedu.zhl.sso.term.dao.JTermMapper;

import org.springframework.stereotype.Service;

/**
 * 查询学段下的所有学科 serviceImpl
 * @author WeiCuicui
 *
 */
@Service("termSubjectService")
public class TermSubjectServiceImpl implements TermSubjectService {

    @Resource
    JTermMapper termMapper;

    /**
     *  查询学段下的所有学科
     */
    @Override
    public List<JSubject> getAllSubjectsByTerm(Long termId) {
    	return termMapper.getSubjectsByTerm(termId);
    }
}
