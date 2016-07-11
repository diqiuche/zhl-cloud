package net.tfedu.zhl.cloud.resource.resPreview.service;

import java.util.List;

import net.tfedu.zhl.cloud.resource.resPreview.entity.ResNavEntity;
import net.tfedu.zhl.cloud.resource.resPreview.entity.ResPreviewInfo;
import net.tfedu.zhl.cloud.resource.resPreview.entity.ResRecommendationEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;

/**
 * 资源预览service接口
 * 
 * @author WeiCuicui
 *
 */
public interface ResPreviewService {

    /**
     *  根据resId和fromFlag，查询资源具体信息
     * @param resId
     * @param userId
     * @param fromFlag
     * @return
     */
    public ResPreviewInfo getResPreviewInfo(long resId, long userId,int fromFlag);
    
    /**
     *  e备课   根据resId和fromFlag，查询资源具体信息
     * @param resId
     * @param userId
     * @param fromFlag
     * @return
     */
    public ResPreviewInfo getResPreviewInfo_ePrepare(long resId, long userId,int fromFlag);

    /**
     *  对一个资源进行预览时，查询该资源所在目录
     * @param resId
     * @param fromFlag
     * @param curTfcode
     * @return
     */
    public List<List<ResNavEntity>> getAllResNavs(long resId, int fromFlag, String curTfcode);

    
    /**
     * 系统资源推荐列表
     * @param tfcode
     * @param typeId
     * @param page
     * @param perPage
     * @param resId
     * @param poolId
     * @return
     */
    public Pagination<ResRecommendationEntity> sysRecommendation(String tfcode,int typeId,long resId,long poolId,int page,int perPage,List<Integer> sys_from,int orderBy,String format);
    
    /**
     * 区本、校本资源推荐列表
     * @param tfcode
     * @param typeId
     * @param fromFlag
     * @param resId
     * @param userId
     * @param page
     * @param perPage
     * @return
     */
    public Pagination<ResRecommendationEntity> disRecommendation(String tfcode,int typeId,int fromFlag,long resId,long userId,int page,int perPage,int orderBy,String format);
    
    /**
     * 资源检索结果的推荐列表
     * @param tfcode
     * @param fromFlag
     * @param resId
     * @param searchWord
     * @param page
     * @param perPage
     * @return
     */
    public Pagination<ResRecommendationEntity> searchRecommendation(int fromFlag,long resId,long userId,String searchKeyword,List<Integer> sys_from,int page,int perPage,String format);
    
    /**
     * 个人中心 - 我的上传  资源推荐（推荐 相同课程结点下的系统、区本、校本资源）
     * @param resId
     * @param sys_from
     * @param page
     * @param perPage
     * @return
     */
    public Pagination<ResRecommendationEntity> myResByUploadRecommendation(long userId,long resId,List<Integer> sys_from,int page,int perPage);
}
