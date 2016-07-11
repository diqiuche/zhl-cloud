package net.tfedu.zhl.cloud.resource.prepare.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tfedu.zhl.cloud.resource.downloadrescord.entity.ResZipDownRecord;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepare;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContent;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareView;
import net.tfedu.zhl.cloud.resource.prepare.entity.ResourceSimpleInfo;
import net.tfedu.zhl.cloud.resource.prepare.entity.UserPrepareStatisInfo;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.helper.ResultJSON;

public interface JPrepareService {

    /**
     * 增加备课夹
     * 
     * @param obj
     * @return
     */
    public JPrepare addPrepare(JPrepare obj);

    /**
     * 修改备课夹
     * 
     * @param obj
     */
    public void editPrepare(JPrepare obj);

    /**
     * 删除备课夹
     * 
     * @param id
     */
    public void deletePrepareById(Long id);

    /**
     * 增加备课夹内容
     * 
     * @param content
     * @return
     */
    public void addPrepareContent(JPrepareContent content)throws Exception;
    
    
    /**
     * 批量增加备课夹内容
     * 
     * @param content
     * @return
     */
    public void addPrepareContentList(List<JPrepareContent> list)throws Exception;
    
    

    /**
     * 修改备课夹内容
     * 
     * @param content
     * @return
     */
    public void editPrepareContent(JPrepareContent content);

    /**
     * 删除备课夹内容
     * 
     * @param content
     * @return
     */
    public void deletePrepareContentById(Long id) throws Exception;

    /**
     * 清空目标备课夹下的所有备课夹
     * 
     * @param prepareId
     */
    public void clearPrepareContentByPrepareId(Long prepareId);

    /**
     * 获取当前节点及其以下节点的备课夹
     * 
     * @param tfcode
     * @return
     */
    public List<JPrepareView> queryPrepareList(String tfcode, Long userId);
    
    /**
     * 仅获取当前节点下备课夹
     * 
     * @param tfcode
     * @return
     */
    public List<JPrepareView> querySelfPrepareList(String tfcode, Long userId);
    /**
     * 分页获取备课夹
     * @param tfcode
     * @param userId
     * @param page
     * @param perPage
     * @return
     */
    public Pagination queryPreparePage(String tfcode, Long userId,Integer page,Integer perPage);

    /**
     * 获取备课夹及其时间范围
     * 
     * @param tfcode
     * @return
     */
    public List<JPrepareView> queryPrepareAndTimeScopeList(String tfcode,String title, Long userId);


    /**
     * 获取学段学科下的备课夹及其时间范围
     * 
     * @param termId
     * @param subjectId
     * @param title
     * @param userId
     * @return
     */
    public List<JPrepareView> queryPrepareAndTimeScopeList(Long termId,Long subjectId,String title, Long userId,String timeLabel);

    
    /**
     * 分页获取学段学科下的备课夹及其时间范围
     * @param termId
     * @param subjectId
     * @param title
     * @param userId
     * @param page
     * @param perPage
     * @return
     */
    public Pagination<JPrepareView> queryPrepareByTermSubject(Long termId,Long subjectId,String title, Long userId
    		,Integer page,Integer perPage,String timeLabel);
    
    
    /**
     * 获取备课夹内容列表
     * 
     * @param prepareId
     * @return
     */
    public List<JPrepareContentView> queryPrepareContentList(Long prepareId);
    
    
    /**
     * 分页获取备课夹内容列表
     * 
     * @param prepareId
     * @return
     */
    public Pagination<JPrepareContentView> queryPrepareContentPage(Long prepareId,Integer page,Integer perPage);

    
    /**
     * 分页获取备课夹内容列表(受限的，排除e备课不能使用的部分(类型)资源)
     * @param prepareId
     * @param page
     * @param perPage
     * @param removeTypeIds 受限的，排除e备课不能使用的部分(类型)资源
     * @return
     */
    public Pagination<JPrepareContentView> queryLimitedPrepareContentPage(Long prepareId,Integer page,Integer perPage,String[]removeTypeIds);

    /**
     * 分页获取备课夹内容列表(受限的，排除e备课不能使用的部分(类型)资源)
     * @param prepareId
     * @param page
     * @param perPage
     * @param removeTypeIds 受限的，排除e备课不能使用的部分(类型)资源
     * @param ifGetNet 是否获取网络资源
     * @return
     */
    public Pagination<JPrepareContentView> queryLimitedPrepareContentPage(Long prepareId,Integer page,Integer perPage,String[]removeTypeIds,boolean ifGetNet);
  
    
    
    
    /**
     * 删除备课夹中指定的类型的资源
     * @param prepareId
     * @param contType
     * @param contId
     */
    public void removeResourceFromPrepare(Long prepareId, Integer contType, Long contId);

    /**
     * 无节点选择时系统资源加入备课夹接口
     * 
     * @param resCode
     */
    public void addToPrepareWithOnlySysResource(String resCode, Long userId);

    /**
     * 相互交换内容的排序字段
     * 
     * @param prevId
     * @param nextId
     */
    public void exchangeContOrderIdx(long prevId, long nextId);

    /**
     * 根据资源fromflag获取相应的 info
     * 
     * @param ids
     * @param fromFlags
     * @return
     */
    public List<ResourceSimpleInfo> getResourceSimpleInfo(String[] ids, String[] fromFlags);
    
    
    
    /**
     * 预览使用 
     * 根据资源fromflag获取相应的 info
     * 
     * @param ids
     * @param fromFlags
     * @return
     */
    public List<ResourceSimpleInfo> getResourceSimpleInfoForView(String[] ids, String[] fromFlags,Long userId);
    
    
    /**
     * 下载使用 
     * 根据资源fromflag获取相应的 info
     * 
     * @param ids
     * @param fromFlags
     * @return
     */
    public List<ResourceSimpleInfo> getResourceSimpleInfoForDownload(String[] ids, String[] fromFlags,Long userId);

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
    public Pagination getPrepareContentListByUserId(Long userId, Long unifyTypeId, String fileFormat, Integer page,
            Integer prePage);

    /**
     * 将指定资源从我的备课夹中清除
     * 
     * @param userId
     * @param resIds
     * @param fromFlags
     */
    public void removeMyPrepareContentResource(Long userId, String resIds, String fromFlags)throws Exception;

    /**
     * 获取我的备课夹的信息统计
     * 
     * @param userId
     * @return
     */
    public List<UserPrepareStatisInfo> getMyPrepareStatis(Long userId);

    
    /**
     * 获取最新更新的备课夹（3个）
     * @param userId
     * @return
     */
    public List<JPrepareView>  getLatestPrepare(Long userId);
    
    
    /**
     * 复制备课夹
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ResultJSON copyPrepare(Long prepareId,String tfcode) throws Exception;
    
    
    /**
     * 移动备课夹
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ResultJSON movePrepare(Long prepareId,String tfcode) throws Exception;

    /**
     * 备课夹导航节点的信息（包括分页页码信息）
     * @param prepareId
     * @return
     */
	public ResultJSON getPrepareNodeInfo(Long prepareId,int perPage);
	
	
	/**
	 * 获取节点的信息(版本、教材)
	 * @param tfcode
	 * @return
	 */
	public HashMap getNodeInfo(String tfcode);
    
}

