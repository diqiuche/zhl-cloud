package net.tfedu.zhl.cloud.resource.prepare.dao;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.prepare.entity.FirstNavigationInfo;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepare;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareView;
import net.tfedu.zhl.cloud.resource.prepare.entity.ResourceSimpleInfo;
import net.tfedu.zhl.cloud.resource.prepare.entity.UserPrepareStatisInfo;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface JPrepareMapper extends CoreMapper<JPrepare> {
	
	
	
	/**
	 * 查询标题是否重名
	 * @param title
	 * @param userid
	 * @return
	 */
	public Integer getRepeatTimes(@Param("tfcode")String tfcode,@Param("title")String title,@Param("userId")Long userId );
	
	/**
	 * 查询标题是否重名(用户的全部备课夹)
	 * @param title
	 * @param userid
	 * @return
	 */
	public Integer getAllRepeatTimes(@Param("title")String title,@Param("userId")Long userId );
	
	

    /**
     * 清空目标备课夹下的所有备课夹内容
     * 
     * @param prepareId
     */
    public void clearPrepareContentByPrepareId(Long prepareId);

    /**
     * 将默认0的排序字段设置为id的值
     */
    public void update_default_prepare_order();

    /**
     * 删除备课夹中指定的类型的资源
     * 
     * @param prepareId
     * @param contType
     * @param contId
     */
    public void removeResourceFromPrepare(Long prepareId, Integer contType, Long contId);

    /**
     * （已经废弃，改用updatetime排序）
     * 更新内容的排序字段
     * 
     * 
     */
    public void update_default_prepare_content_order();

    /**
     * 获取当前节点及其以下节点的备课夹
     * 
     * @param tfcode
     * @return
     */
    public List<JPrepareView> queryPrepareList(String tfcode, Long userId);
    
    /**
     * 仅获取当前节点下的备课夹
     * 
     * @param tfcode
     * @return
     */
    public List<JPrepareView> querySelfPrepareList(String tfcode, Long userId);

    /**
     * 获取备课夹及其时间范围
     * 
     * @param tfcode
     * @return
     */
    public List<JPrepareView> queryPrepareAndTimeScopeList(@Param("tfcode")String tfcode,@Param("title")String title,@Param("userId") Long userId);

  
    
    /**
     * 获取学段学科下的备课夹及其时间范围
     * 
     * @param termId
     * @param subjectId
     * @param title
     * @param userId
     * @param timeLabel  withinweek、withinmonth、moreearly
     * @return
     */
    public List<JPrepareView> queryPrepareByTermAndSubject(@Param("termId")Long termId,@Param("subjectId")Long subjectId,@Param("title")String title, @Param("userId")Long userId, @Param("timeLabel")String timeLabel);

    
    /**
     * 获取备课夹内容列表(其中缩略图、文件后缀需要工具类继续处理)
     * 
     * @param prepareId
     * @return
     */
    public List<JPrepareContentView> queryPrepareContentList(Long prepareId);
    /**
     * 获取备课夹内容列表(其中缩略图、文件后缀需要工具类继续处理)
     * 受限的，排除e备课不能使用的部分(类型)资源
     * @param prepareId
     * @return
     */
    public List<JPrepareContentView> queryLimitedPrepareContentList(@Param("prepareId")Long prepareId,@Param("removeTypeIds")String[] removeTypeIds);
    
    

    /**
     * 获取备课夹内容列表(其中缩略图、文件后缀需要工具类继续处理)
     * 受限的，排除e备课不能使用的部分(类型)资源
     * @param prepareId
     * @param removeTypeIds 排除的类型
     * @param ifGetNet     是否获取网络资源
     * @return
     */
    public List<JPrepareContentView> queryLimitedPrepareContentListWithoutNet(@Param("prepareId")Long prepareId,
    		@Param("removeTypeIds")String[] removeTypeIds);
    /**
     * 获取系统资源的第一个关联节点的信息
     * 
     * @param resCode
     */
    public FirstNavigationInfo getFirstNavigationForSysResource(String resCode);

    /**
     * 获取自建资源的信息
     * 
     * @param id
     * @return
     */
    public ResourceSimpleInfo getAssetInfo(Long id);

    /**
     * 获取系统资源的信息
     * 
     * @param id
     * @return
     */
    public ResourceSimpleInfo getResourceInfo(Long id);

    /**
     * 获取区校本资源的信息
     * 
     * @param id
     * @return
     */
    public ResourceSimpleInfo getDistrictORSchoolResInfo(Long id);

    /**
     * 获取用户的备课夹统计(部分) 只 获取tfcode、title、resourcenums
     * 
     * @param userId
     * @return
     */
    public List<UserPrepareStatisInfo> getUserPrepareStatisButPartResult(Long userId);

    /**
     * 获取教材的已经备完的课程、 需要备课的课程数
     * 
     * @param info
     * @return
     */
    public UserPrepareStatisInfo getBookPrepareStatis(@Param("userId") Long userId, @Param("tfcode") String tfcode);


    /**
     * 获取最新更新的备课夹（3个）
     * @param userId
     * @return
     */
    public List<JPrepareView>  getLatestPrepare(Long userId);
    
    
    /**
     * 获取备课夹在其所在节点下的下标信息
     * @param tfcode
     * @param prepareId
     * @return
     */
    public Integer getPrepareIndxInfo(@Param("tfcode") String tfcode,@Param("prepareId") Long prepareId);
    
   /**
    * 获取节点的版本、教材信息
    * @param tfcode
    * @return
    */
    public HashMap<String,String> getNodeInfo(@Param("tfcode") String tfcode);

}