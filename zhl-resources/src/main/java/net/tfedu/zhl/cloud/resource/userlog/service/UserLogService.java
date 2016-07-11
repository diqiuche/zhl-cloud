package net.tfedu.zhl.cloud.resource.userlog.service;

import com.github.pagehelper.PageInfo;

/**
 * 用户日志记录的service
 * 
 * @author wangwr
 *
 */
public interface UserLogService {

    /**
     * 分页获取(新版资源中心)我的浏览记录
     * 
     * @param userId
     * @param unifyTypeId
     * @param fileFormat
     * @param page
     * @param prePage
     * @return
     */
    public PageInfo getMyViewLogFroResource(Long userId, Long unifyTypeId, String fileFormat, Integer page, Integer prePage);

}
