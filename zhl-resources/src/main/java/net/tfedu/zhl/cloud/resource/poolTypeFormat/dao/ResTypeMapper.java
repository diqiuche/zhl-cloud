package net.tfedu.zhl.cloud.resource.poolTypeFormat.dao;

import java.util.List;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResType;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

/**
 * 查询资源类型 mapper
 * 
 * @author WeiCuicui
 *
 */
public interface ResTypeMapper extends CoreMapper<ResType> {
	
	/**
	 * 根据需要排除的资源类型，查询相应地所有的一级、二级类型
	 */
	public List<Integer> getLimitedResTypes(@Param("removeTypeIds")List<Integer> removeTypeIds);

	/**
     * 系统资源：根据资源库id、父类型id，查询父类型及其子类型
     */
    public List<Integer> getTypesByPMTypeAndPool(@Param("poolId") long poolId, @Param("MType") int MType);
    
    /**
     * e备课， 系统资源：根据资源库id、父类型id，查询父类型及其子类型
     */
    public List<Integer> getTypesByPMTypeAndPool_EPrepare(@Param("poolId") long poolId, @Param("MType") int MType,
    		@Param("removeTypeIds")List<Integer> removeTypeIds);

    /**
     * 系统资源：根据资源库id，查询该资源库下的所有一级、二级类型
     */
    public List<Integer> getTypesByPool(@Param("poolId") long poolId);
    
    /**
     * e备课， 系统资源：根据资源库id，查询该资源库下的所有一级、二级类型
     */
    public List<Integer> getTypesByPool_EPrepare(@Param("removeTypeIds") List<Integer> removeTypes,@Param("poolId") long poolId);
	
   /**
    * 系统资源，当资源库id为0或4时，查询所有一级类型
    */
    public List<ResType> getSysFirstLevelType(@Param("typeIds") List<Integer> typeIds,
            @Param("tfcode") String pTfcode,@Param("sys_from")List<Integer> sys_from);
    

    /**
     * 系统资源：当资源库选择 “动画焦教具”、“名师微课”、“教学案例” 时，显示所有二级类型。当资源库为“理化生实验”时，只显示“全部”
     * 
     */
    public List<ResType> getSysSecondLevelType(@Param("typeIds") List<Integer> typeIds,
            @Param("tfcode") String pTfcode,@Param("sys_from")List<Integer> sys_from);
    
    /**
     * e备课，系统资源，当资源库id为0或4时，查询所有一级类型
     */
     public List<ResType> getSysFirstLevelType_EPrepare(@Param("typeIds") List<Integer> typeIds,
             @Param("tfcode") String pTfcode,@Param("sys_from")List<Integer> sys_from);
     

     /**
      * e备课，系统资源：当资源库选择 “动画焦教具”、“名师微课”、“教学案例” 时，显示所有二级类型。当资源库为“理化生实验”时，只显示“全部”
      * 
      */
     public List<ResType> getSysSecondLevelType_EPrepare(@Param("typeIds") List<Integer> typeIds,
             @Param("tfcode") String pTfcode,@Param("sys_from")List<Integer> sys_from);

    
    /**
     * 区本校本资源：查询资源类型
     * 
     * @return
     */
    public List<ResType> getDisResType(@Param("fromFlag") int fromFlag, @Param("tfcode") String tfcode,@Param("schoolId") long schoolId, 
    		@Param("districtId") long districtId);
    
    /**
     * 区本校本资源：查询资源类型，e备课
     * 
     * @return
     */
    public List<ResType> getDisResType_EPrepare(@Param("fromFlag") int fromFlag, @Param("tfcode") String tfcode,@Param("schoolId") long schoolId, 
    		@Param("districtId") long districtId,@Param("removeTypeIds")List<Integer> removeTypes);
    
    /**
     * 
     * 区本校本资源：查询父类型及其所有子类型
     */
    public List<Integer> getDisResTypesByPMType(@Param("MType") int MType);
    
    
    /**
     * 
     * 区本校本资源：查询父类型及其所有子类型，e备课
     */
    public List<Integer> getDisResTypesByPMType_EPrepare(@Param("MType") int MType,@Param("removeTypeIds")List<Integer> removeTypeIds);
    
    
    
    /**
     * 自建资源 ： 查询全部一级资源类型
     */
    public List<FirstLevelResType> getAllFirstLevelResType();
    
    /**
     * 自建资源 ： 查询全部类型
     */
    public List<FirstLevelResType> getAllResType();
}