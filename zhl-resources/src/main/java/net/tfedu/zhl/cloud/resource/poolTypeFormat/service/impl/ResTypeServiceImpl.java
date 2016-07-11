package net.tfedu.zhl.cloud.resource.poolTypeFormat.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.dao.ResTypeMapper;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.ResType;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.service.ResTypeService;
import net.tfedu.zhl.cloud.resource.resourceList.dao.DistrictResMapper;
import net.tfedu.zhl.sso.user.dao.JUserMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 资源类型的serviceImpl
 * 
 * @author WeiCuicui
 *
 */
@Service("resTypeService")
public class ResTypeServiceImpl implements ResTypeService {

	// 资源类型的mapper
    @Resource
    ResTypeMapper resTypeMapper;
    
    @Resource DistrictResMapper districtResMapper;
    
    @Resource JUserMapper jUserMapper;
    
    //写入日志
    Logger logger = LoggerFactory.getLogger(ResTypeServiceImpl.class);
    
    
    /**
     * 系统资源：查询资源类型
     */
    @Override
    public List<ResType> getSysResTypes(long poolId, String pTfcode,List<Integer> sys_from) {
        
    	//资源类型查询结果
    	List<ResType> types = new ArrayList<ResType>();
        
    	//根据资源库，查询所有的一级、二级类型
        List<Integer> typeIds = resTypeMapper.getTypesByPool(poolId);

        if(typeIds != null && typeIds.size() > 0){
        	/**
             * 当资源库选择 “全部” 或 “教学素材” 时 显示所有一级类型
             */
            if (poolId == 0 || poolId == 4 || poolId == 5) {
            	
                types = resTypeMapper.getSysFirstLevelType(typeIds, pTfcode,sys_from);

            } else { // 当资源库选择 “动画教具”、“名师微课”、“教学案例”
                     // 时，显示所有二级类型；当资源库为“理化生实验”时，只显示“全部”。
                types = resTypeMapper.getSysSecondLevelType(typeIds, pTfcode, sys_from);
            }
        }
        
        // 资源类型中增加一个“全部”
        ResType all = new ResType();
        all.setId(0);
        all.setMtype("全部");
        types.add(0,all);

        return types;
    }
    
    /**
     * 系统资源：查询资源类型，e备课
     */
    @Override
    public List<ResType> getSysResTypes_EPrepare(long poolId, String pTfcode,List<Integer> removeTypeIds,List<Integer> sys_from) {
        
    	List<ResType> types = new ArrayList<ResType>();
    	
    	//查询受限类型及其子类型
    	List<Integer> removeTypes = resTypeMapper.getLimitedResTypes(removeTypeIds);
    	
    	//根据资源库id，查询所有的一级、二级类型
    	List<Integer> typeIds = resTypeMapper.getTypesByPool_EPrepare(removeTypes,poolId);
    	
    	//除去需要排除的类型
    	for(int i = 0; i < removeTypeIds.size(); i++){
    		int tmp = removeTypeIds.get(i);
    		if(typeIds.contains(tmp))
    			typeIds.remove(tmp);
    	}
    	
    	if(typeIds != null && typeIds.size() > 0){
    		/**
             * 当资源库选择 “全部” 或 “教学素材” 时 显示所有一级类型
             */
            if (poolId == 0 || poolId == 4 || poolId == 5) {
              
            	types = resTypeMapper.getSysFirstLevelType_EPrepare(typeIds, pTfcode,sys_from);

            } else { // 当资源库选择 “动画教具”、“名师微课”、“教学案例”
                     // 时，显示所有二级类型；当资源库为“理化生实验”时，只显示“全部”。
                types = resTypeMapper.getSysSecondLevelType_EPrepare(typeIds, pTfcode, sys_from);
            }
    	}

        // 资源类型中增加一个“全部”
        ResType all = new ResType();
        all.setId(0);
        all.setMtype("全部");
        types.add(0,all);

        return types;
    }
    
    /**
     * 区本校本资源：查询资源类型
     * 
     * @return
     */
    @Override
    public List<ResType> getDisResTypes(String tfcode, int fromFlag,long userId) {
        // 定义类型结果集
        List<ResType> types = new ArrayList<ResType>();
        
        long schoolId = 0;
        long districtId = 0;

        // 根据userId查询schoolId 和 districtId
        HashMap<String,Object> map =  jUserMapper.getUserAreaInfo(userId);
		if(map!=null){
			districtId = (map.get("districtid") instanceof java.lang.String)
							? Long.parseLong(map.get("districtid").toString())
							: Long.parseLong(String.valueOf(map.get("districtid")));
			schoolId = (map.get("schoolid") instanceof java.lang.String)
					?Long.parseLong(map.get("schoolid").toString())
					:Long.parseLong(String.valueOf(map.get("schoolid")));
		}
        
        logger.debug("schoolId: " + schoolId);
        logger.debug("districtId: " + districtId);

        // 查询资源类型
        types = resTypeMapper.getDisResType(fromFlag,tfcode,schoolId,districtId);

        // 资源类型中增加一个“全部”
        ResType all = new ResType();
        all.setId(0);
        all.setMtype("全部");
        types.add(0,all);

        return types;
    }
    
    /**
     * 区本校本资源：查询资源类型，e备课
     * 
     * @return
     */
    @Override
    public List<ResType> getDisResType_EPrepare(String tfcode, int fromFlag,long userId,List<Integer> removeTypeIds) {
        // 定义类型结果集
        List<ResType> types = new ArrayList<ResType>();
        
        long schoolId = 0;
        long districtId = 0;

        // 根据userId查询schoolId 和 districtId
        HashMap<String,Object> map =  jUserMapper.getUserAreaInfo(userId);
		if(map!=null){
			districtId = (map.get("districtid") instanceof java.lang.String)
							? Long.parseLong(map.get("districtid").toString())
							: Long.parseLong(String.valueOf(map.get("districtid")));
			schoolId = (map.get("schoolid") instanceof java.lang.String)
					?Long.parseLong(map.get("schoolid").toString())
					:Long.parseLong(String.valueOf(map.get("schoolid")));
		}

        logger.debug("schoolId: " + schoolId);
        logger.debug("districtId: " + districtId);
        
        //查询受限类型及其子类型
    	List<Integer> removeTypes = resTypeMapper.getLimitedResTypes(removeTypeIds);
        
        // 查询资源类型
        types = resTypeMapper.getDisResType_EPrepare(fromFlag,tfcode, schoolId,districtId,removeTypes);

        // 资源类型中增加一个“全部”
        ResType all = new ResType();
        all.setId(0);
        all.setMtype("全部");
        types.add(0,all);

        return types;
    }

    @Override
    public List<FirstLevelResType> getAllFirstLevelResType() {
        return resTypeMapper.getAllFirstLevelResType();
    }
}
