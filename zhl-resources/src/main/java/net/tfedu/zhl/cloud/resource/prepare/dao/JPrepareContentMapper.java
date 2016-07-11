package net.tfedu.zhl.cloud.resource.prepare.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContent;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.helper.CoreMapper;

public interface JPrepareContentMapper extends CoreMapper<JPrepareContent> {

    /**
     * 分页获取我的备课资源
     * 
     * @param userId
     * @param unifyTypeId
     * @param fileFormat
     * @param page
     * @param prePage
     * @return
     */
    public List<JPrepareContentView> getPrepareContentListByUserId(@Param("userId") Long userId,
            @Param("unifyTypeId") Long unifyTypeId, @Param("fileFormat") String fileFormat);

    /**
     * 将指定资源从我的备课夹中清除
     * 
     * @param userId
     * @param resIds
     * @param fromFlags
     */
    public void removeMyPrepareContentResource(Long userId, Long contId, Integer contType);

    
    
    
    
    /**
     * 备课夹内容是否已经存在
     * @return
     */
    public Boolean isPrepareContentExist( @Param("prepareId") Long prepareId,@Param("contId") Long contId, @Param("contType")  Integer contType);
    
    
    
    /**
     * 复制备课夹内容  将prepareId的内容复制到 targetPrepareId
     * @param prepareId
     * @param targetPrepareId
     */
    public void copyPrepareContent(@Param("prepareId")String prepareId,@Param("targetPrepareId")String targetPrepareId);
    
    
    
    
}