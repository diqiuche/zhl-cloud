package net.tfedu.zhl.cloud.resource.asset.service;

import java.util.ArrayList;
import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.entity.ReviewResultStatis;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAsset;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetEditInfo;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.core.service.BaseService;
import net.tfedu.zhl.helper.ResultJSON;

public interface ZAssetService extends BaseService<ZAsset>{
	
	/**
	 *  自建资源 ： 查询全部一级资源类型
	 */
	public List<FirstLevelResType> getAllFirstLevelResType();
	
	
	/**
	 * 获取全部的资源类型
	 * @return
	 */
	public List<FirstLevelResType> getAllResType();
	
	/**
	 * 获取全部的资源类型
	 * @return
	 */
	public List<FirstLevelResType> getTypeForExt(String ext)throws Exception;
	
	
	
	
	
	/**
	 *  自建资源 ： 查询全部文件格式
	 */
	public List<String> getAllFileFormat();
	
	
	

	/**
	 * 查询用户的 评论
	 * @param userId
	 * @param reviewType 评论级别 0 全部 1 好 2 中3 差
	 * @param page
	 * @param perPage
	 * @return
	 */
	public Pagination getMyReview(Long userId,Integer reviewType,Integer page,Integer perPage);
	
	
	
	
	/**
	 * 删除我的资源评论
	 * @param ids   评论id的复数
	 */
	public void removeMyReview(String ids);
	
	
	
	
	/**
	 * 对用户的资源评论（评论、未评论）进行统计
	 * @param userId
	 * @return
	 */
	public ReviewResultStatis getReviewStatis(Long userId);
	
	
	
	/**
	 * 设置上传资源格式转换成功
	 * @param userId
	 * @param resPath  上传文件原始路径
	 */
	public void setTypeConvertSucceed(String resServiceLocal,Long userId,String resPath);
	
	
	
	
	
	/**
	 * 批量增加自建资源
	 * @param list
	 * @param codes
	 * @param hostLocal 
	 * @param currentResPath 
	 * @param resServiceLocal 
	 */
	public void addAssetBatch(List<ZAsset> list,List<String> codes,ArrayList<Integer> scope_list,String resServiceLocal, String currentResPath, String hostLocal) throws Exception ;
	
	
	
	
	/**
	 * 删除自建资源
	 * @param resIds
	 */
	public void delAsset(String resIds);
	
	
	
	/**
	 * 修改自建资源
	 * @param asset
	 */
	public void updateAsset(ZAsset asset,String tfcode,Integer scope, String resServiceLocal, String currentResPath, String hostLocal)throws Exception;
	
	
	
	/**
	 * 分页查询我的上传
	 * @param userId
	 * @param unifyTypeId  资源类型
	 * @param fileFormat   资源格式 
	 * @param page
	 * @param perPage
	 * @return
	 */
	public Pagination queryMyAssets(Long userId,Long unifyTypeId,String fileFormat,Integer page,Integer perPage,String hostLocal,String resServiceLocal);
	
	
	/**
	 * 根据我的空间中的tab 获取对应的资源类型查询结果	
	 * @param tabCode
	 * @param userId
	 * @return
	 */
	public List<FirstLevelResType> getResTypeForPersonalTab(String tabCode,Long userId);
	
	
	 /**
     * 分页获取我的资源评论
     * @param userId
     * @param reviewType
     * @param page
     * @param perPage
     * @return
     */
	public Pagination getMyReviewComment(Long userId, Integer reviewType,Integer page,Integer perPage);
	
	/**
	 * 批量复制    自建资源
	 * @param resIds
	 * @param tfcode
	 */
	public void patchCopyAsset(List<Long> resIds,String tfcode);
	
	/**
	 * 批量剪切    自建资源
	 * @param resIds
	 * @param tfcode
	 */
	public void patchCutAsset(List<Long> resIds,String tfcode,String des_tfcode);
	
	/**
	 * 批量删除    自建资源
	 * @param resIds
	 * @param tfcode
	 */
	public void patchDelAsset(List<Long> resIds,String tfcode);
	
	
	
	 /**
     * 分页获取（备课夹中）未评论的资源
     * @param userId
     * @param reviewType
     * @param page
     * @param perPage
     * @return
     */
	public Pagination getUnReview(Long userId,Integer page,Integer perPage);
	
	
	
	
	/**
	 * 获取资源编辑时需要的信息
	 * @param id
	 * @return
	 */
	public ZAssetEditInfo getEditInfo(Long id);
	
	/**
	 * 获取当前查询条件下的资源类型
	 * @param ifGetNet 
	 * @param userId
	 * @param tfcode
	 * @param title
	 * @return
	 */
	public ResultJSON  getCourseAssetUnifyType(boolean ifGetNet, Long userId,String tfcode,String title);
	
	
	
	/**
	 * 获取当前查询条件下的自建资源
	 * @param ifGetNet 
	 * @param userId
	 * @param tfcode
	 * @param title
	 * @param page
	 * @param perPage
	 * @return
	 */
	public Pagination<JPrepareContentView>  getCourseAssetPage(boolean ifGetNet, Integer unifyTypeId,Long userId,String tfcode,String title,Integer page,Integer perPage);
	
	
	
	/**
	 * 更新资源路径
	 * @param path
	 * @param newPath
	 */
	public void updateAssetPath(String path,String newPath);
	
}
