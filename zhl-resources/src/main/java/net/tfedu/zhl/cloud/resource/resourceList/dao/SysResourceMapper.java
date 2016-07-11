package net.tfedu.zhl.cloud.resource.resourceList.dao;

import java.util.List;

import net.tfedu.zhl.cloud.resource.resPreview.entity.ResNavEntity;
import net.tfedu.zhl.cloud.resource.resPreview.entity.ResPreviewInfo;
import net.tfedu.zhl.cloud.resource.resPreview.entity.ResRecommendationEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.SysResource;
import net.tfedu.zhl.cloud.resource.resourceList.entity.SysResourceEntity;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

/**
 * 系统资源 mapper
 * 
 * @author WeiCuicui
 *
 */
public interface SysResourceMapper extends CoreMapper<SysResource> {

	
	/**
     * 查询系统资源列表
     */
    public List<SysResourceEntity> getAllSysRes(@Param("sys_from") List<Integer> sys_from,@Param("fileFormat") String fileFormat, 
            @Param("tfcode") String tfcode, @Param("orderBy") int orderBy,@Param("typeIds")List<Integer> typeIds);
    
    
    /**
     * e备课：查询系统资源（限制资源类型，资源title模糊查询）
     */
    public List<SysResourceEntity> getAllSysRes_EPrepare(@Param("sys_from") List<Integer> sys_from,@Param("fileFormat") String fileFormat, 
            @Param("tfcode") String tfcode, @Param("orderBy") int orderBy,@Param("searchWord")String searchWord,@Param("typeIds")List<Integer> typeIds);

        
    /**
     * 资源预览页面：系统资源推荐
     */
    public List<ResRecommendationEntity> getAllSysRes_Preview(@Param("sys_from") List<Integer> sys_from,
    		@Param("tfcode") String tfcode,@Param("resId")long resId,@Param("orderBy")int orderBy,@Param("typeIds")List<Integer> typeIds,@Param("fileFormat") String fileFormat);
    
    
    /**
     * 根据自建资源resId、tfcode，查询tfcode下的系统、区本、校本资源
     */
    public List<ResRecommendationEntity> getAllResByTfcode(@Param("resId") long resId,@Param("sys_from") List<Integer> sys_from,@Param("tfcode") String tfcode,@Param("schoolId") long schoolId,@Param("districtId") long districtId);
    
    
    /**
     * 获取一条系统资源的详细信息
     */
    public ResPreviewInfo getSysResInfo(@Param("resId") long resId,@Param("userId")long userId);

    /**
     * 根据structCode，查询一个版本的目录
     */
    public List<ResNavEntity> getSysNav(@Param("structCode") String structCode);

    /**
     * 根据资源id，获得所有版本的structCode
     */
    public List<String> getAllRescodes(@Param("resId") long resId, @Param("curTfcode") String curTfcode);
    
    /**
     * 更新点击次数（+1）
     * @param rescode
     */
    public void updateClickTime(@Param("rescode") String rescode);
    
    
    /**
     * 更新下载次数（+1）
     * @param rescode
     */
    public void updateDownloadTime(@Param("rescode") String rescode);

}
