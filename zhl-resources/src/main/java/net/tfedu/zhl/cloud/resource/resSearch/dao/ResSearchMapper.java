package net.tfedu.zhl.cloud.resource.resSearch.dao;

import java.util.List;

import net.tfedu.zhl.cloud.resource.resPreview.entity.ResRecommendationEntity;
import net.tfedu.zhl.cloud.resource.resSearch.entity.ResSearchResultEntity;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface ResSearchMapper extends CoreMapper<ResSearchResultEntity> {

	/**
     * 当资源来源为全部时，查询所有满足条件的资源
     */
    public List<ResSearchResultEntity> getAllResources(@Param("searchKeyword") String searchKeyword,
            @Param("format") String format, @Param("sys_from") List<Integer> sys_from,@Param("schoolId") long schoolId,@Param("districtId") long districtId);

    /**
     * 根据检索关键字查询所有符合条件的系统资源
     */
    public List<ResSearchResultEntity> getAllSysResources(@Param("searchKeyword") String searchKeyword,
            @Param("format") String format, @Param("sys_from") List<Integer> sys_from);

    /**
     * 根据检索关键字查询所有符合条件的区本、校本资源
     */
    public List<ResSearchResultEntity> getAllDisResources(@Param("searchKeyword") String searchKeyword,
            @Param("fromFlag") int fromFlag, @Param("format") String format,@Param("schoolId") long schoolId,@Param("districtId") long districtId);
    
    /**
     * 根据关键字，查询所有资源查询结果的格式
     */
    public List<String> getAllFileFormats(@Param("searchKeyword") String searchKeyword,@Param("sys_from") List<Integer> sys_from,@Param("schoolId") long schoolId,@Param("districtId") long districtId);
    
    /**
     * 根据关键字，fromFlag，查询区本、校本资源的格式
     */
    public List<String> getDisFileFormats(@Param("searchKeyword") String searchKeyword,@Param("fromFlag") int fromFlag,@Param("schoolId") long schoolId,@Param("districtId") long districtId);
    
    /**
     * 根据关键字，查询系统资源的格式
     */
    public List<String> getSysFileFormats(@Param("searchKeyword") String searchKeyword,@Param("sys_from") List<Integer> sys_from);
    
   
    /**
     * 检索范围为全部时，查询推荐列表
     */
    public List<ResRecommendationEntity> getAllResources_preview(@Param("searchKeyword") String searchKeyword,
             @Param("sys_from") List<Integer> sys_from,@Param("schoolId") long schoolId,@Param("districtId") long districtId,@Param("resId")long resId,
             @Param("fileFormat") String format);

    /**
     * 检索范围为系统资源时，查询推荐列表
     */
    public List<ResRecommendationEntity> getAllSysResources_preview(@Param("searchKeyword") String searchKeyword,@Param("sys_from") List<Integer> sys_from,@Param("resId")long resId,
            @Param("fileFormat") String format);
            

    /**
     * 检索范围为区本、校本资源时，查询推荐列表
     */
    public List<ResRecommendationEntity> getAllDisResources_preview(@Param("searchKeyword") String searchKeyword,
            @Param("fromFlag") int fromFlag,@Param("schoolId") long schoolId,@Param("districtId") long districtId,@Param("resId")long resId,
            @Param("fileFormat") String format);
}
