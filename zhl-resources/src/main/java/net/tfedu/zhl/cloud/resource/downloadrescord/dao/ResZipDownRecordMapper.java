package net.tfedu.zhl.cloud.resource.downloadrescord.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.cloud.resource.downloadrescord.entity.ResZipDownRecord;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.helper.CoreMapper;

public interface ResZipDownRecordMapper extends CoreMapper<ResZipDownRecord> {

    /**
     * 分页获取我的下载
     * 
     * @param userId
     * @param unifyTypeId
     * @param fileFormat
     * @return
     */
    public List<JPrepareContentView> getMydownload(@Param("userId") Long userId, @Param("unifyTypeId") Long unifyTypeId,
            @Param("fileFormat") String fileFormat);

}