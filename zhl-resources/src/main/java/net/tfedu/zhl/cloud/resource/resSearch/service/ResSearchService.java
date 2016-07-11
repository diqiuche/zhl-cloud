package net.tfedu.zhl.cloud.resource.resSearch.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.resSearch.entity.ResSearchResultEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;

public interface ResSearchService {

    /**
     * 跨库检索资源
     * @param fromFlag
     * @param sys_from
     * @param searchKeyword
     * @param format
     * @param page
     * @param perPage
     * @return
     */

    public Pagination<ResSearchResultEntity> getResources(int fromFlag, List<Integer> sys_from, String searchKeyword,
            String format, int page, int perPage,long userId,int expire);
    
   
    /**
     * 查询资源格式
     * @param searchKeyword
     * @param fromFlag
     * @param sys_from
     * @return
     */
    public List<String> getFileFormats(String searchKeyword,int fromFlag,List<Integer> sys_from,long userId);
    
}
