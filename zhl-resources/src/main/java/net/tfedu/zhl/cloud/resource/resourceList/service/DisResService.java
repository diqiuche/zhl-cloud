package net.tfedu.zhl.cloud.resource.resourceList.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.resourceList.entity.DisResourceEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;

/**
 * 区本、校本资源的service
 * 
 * @author WeiCuicui
 *
 */
public interface DisResService {

    /**
     * 查询区本、校本资源信息
     * @param userId
     * @param mTypeId
     * @param fileFormat
     * @param tfcode
     * @param orderBy
     * @param page
     * @param perPage
     * @param fromFlag
     * @param expire
     * @return
     */
    public Pagination<DisResourceEntity> selectAllDisRes(long userId, int mTypeId, String fileFormat, String tfcode,
            int orderBy, int page, int perPage, int fromFlag,int expire);
    

    /**
     * 查询区本、校本资源信息，e备课
     * @param userId
     * @param mTypeId
     * @param fileFormat
     * @param tfcode
     * @param orderBy
     * @param page
     * @param perPage
     * @param fromFlag
     * @param searchWord
     * @param removeTypeIds
     * @param expire
     * @return
     */
    public Pagination<DisResourceEntity> selectAllDisRes_EPrepare(long userId, int mTypeId, String fileFormat, String tfcode,
            int orderBy, int page, int perPage, int fromFlag,String searchWord,List<Integer> removeTypeIds,int expire);

}
