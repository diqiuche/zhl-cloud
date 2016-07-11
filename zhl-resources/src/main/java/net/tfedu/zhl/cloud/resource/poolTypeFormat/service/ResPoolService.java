package net.tfedu.zhl.cloud.resource.poolTypeFormat.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResPool;

/**
 * 查询所有资源库 service
 * 
 * @author WeiCuicui
 *
 */
public interface ResPoolService {

    /**
     * 查询所有资源库
     * @return
     */
    public List<ResPool> getAllPools();
}
