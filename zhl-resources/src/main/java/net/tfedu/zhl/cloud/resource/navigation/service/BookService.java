package net.tfedu.zhl.cloud.resource.navigation.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;

/**
 * 获得特定版本下的所有教材
 * 
 * @author WeiCuicui
 *
 */
public interface BookService {

    /**
     *  根据特定版本，获得版本下的所有教材
     * @param pnodeId
     * @param proCode
     * @return
     */
    public List<JSyscourse> getAllBooks(long pnodeId, String proCode);
}
