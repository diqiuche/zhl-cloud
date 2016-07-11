package net.tfedu.zhl.cloud.resource.poolTypeFormat.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResType;

/**
 * 资源类型 service
 * 
 * @author WeiCuicui
 *
 */
public interface ResTypeService {
	
	
	/**
     * 系统资源：查询资源类型
     */
    public List<ResType> getSysResTypes(long poolId, String pTfcode,List<Integer> sys_from);
    
    /**
     * 系统资源：查询资源类型，e备课
     */
    public List<ResType> getSysResTypes_EPrepare(long poolId, String pTfcode,List<Integer> removeTypeIds,List<Integer> sys_from); 
    
    /**
     * 区本校本资源：查询资源类型
     * 
     * @return
     */
    public List<ResType> getDisResTypes(String tfcode, int fromFlag,long userId);

    /**
     * 区本校本资源：查询资源类型，e备课
     * 
     * @return
     */
    public List<ResType> getDisResType_EPrepare(String tfcode, int fromFlag,long userId,List<Integer> removeTypeIds);
    
    
    /**
     * 自建资源 ： 查询全部一级资源类型
     */
    public List<FirstLevelResType> getAllFirstLevelResType();

}