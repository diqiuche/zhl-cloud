package net.tfedu.zhl.cloud.resource.navigation.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;

/**
 * 根据学段、学科获得所有版本
 * 
 * @author WeiCuicui
 *
 */
public interface EditionService {

    /**
     * 根据学段、学科，获得所有版本
     */
    public List<JSyscourse> getAllEditionsByTermAndSub(long termId,long subjectId);
}
