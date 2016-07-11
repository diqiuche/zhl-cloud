package net.tfedu.zhl.cloud.resource.asset.dao;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.entity.ResourceReview;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetValuate;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface ZAssetValuateMapper extends CoreMapper<ZAssetValuate> {

    /**
     * 查询用户的 评论
     * 
     * @param userId
     * @param reviewType
     *            评论级别 0 全部 1 好 2 中3 差
     * @return
     */
    public List<ResourceReview> getMyReview(@Param("userId") Long userId, @Param("reviewType") Integer reviewType);

    /**
     * 获取当前用户评论的资源数目
     * 
     * @param userId
     * @return
     */
    public Integer getReviewedNum(Long userId);

    /**
     * 获取当前用户所有备课夹中未进行评论的资源数目
     * 
     * @param userId
     * @return
     */
    public Integer getUnReviewedNum(Long userId);
    
    
    
    /**
     * 查询用户的 评论
     * 
     * @param userId
     * @param reviewType
     *            评论级别 0 全部 1 好 2 中3 差
     * @return
     */
    public List<ResourceReview> getMyReviewComment(@Param("userId") Long userId, @Param("reviewType") Integer reviewType);

    
    
    /**
     * 获取当前用户所有备课夹中未进行评论的系统、区本、校本资源
     * 
     * @param userId
     * @return
     */
    public List<HashMap<String, Object>> getUnReviewedRes(Long userId);
    
    
    
    /**
     * 获取当前的为评论的资源
     * @param userId
     * @param sysList
     * @param disList
     * @return
     */
    public List<ResourceReview> getUnReviewedResPager(@Param("userId")Long userId,@Param("sysList")List sysList,@Param("disList")List disList);
    
    
}