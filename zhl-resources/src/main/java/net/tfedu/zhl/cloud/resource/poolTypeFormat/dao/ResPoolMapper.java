package net.tfedu.zhl.cloud.resource.poolTypeFormat.dao;

import java.util.List;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResPool;
import net.tfedu.zhl.helper.CoreMapper;

/**
 * 查询所有资源库
 * 
 * @author WeiCuicui
 *
 */
public interface ResPoolMapper extends CoreMapper<ResPool> {

    /**
     * 查询所有资源库
     * @return
     */
    public List<ResPool> getAllPools();
}