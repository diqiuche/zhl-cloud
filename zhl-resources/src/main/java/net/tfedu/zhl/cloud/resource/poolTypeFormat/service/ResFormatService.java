package net.tfedu.zhl.cloud.resource.poolTypeFormat.service;

import java.util.List;


/**
 * 资源格式 service
 * 
 * @author WeiCuicui
 *
 */
public interface ResFormatService {


    /**
     * 查询区本校本资源格式
     * @param tfcode
     * @param fromFlag
     * @return
     */
    public List<String> getDisResFormats(int mtype,String tfcode,int fromFlag,long userId);

    /**
     * 获得系统资源格式
     * @param poolId
     * @param pTfcode
     * @param typeId
     * @param sys_from
     * @return
     */
    public List<String> getSysResFormats(String pTfcode, int typeId,List<Integer> sys_from,long poolId);
    
}
