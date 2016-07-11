package net.tfedu.zhl.cloud.resource.navigation.service;

import java.util.List;

import net.tfedu.zhl.sso.term.entity.JTerm;

/**
 * 查询所有学段 service
 */
public interface TermService {

    /**
     *  查询所有学段
     * @return
     */
    public List<JTerm> selectAll();
}
