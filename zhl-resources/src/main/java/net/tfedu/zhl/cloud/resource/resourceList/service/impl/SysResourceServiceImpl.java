package net.tfedu.zhl.cloud.resource.resourceList.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.dao.ResTypeMapper;
import net.tfedu.zhl.cloud.resource.resourceList.dao.SysResourceMapper;
import net.tfedu.zhl.cloud.resource.resourceList.entity.PageInfoToPagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.SysResourceEntity;
import net.tfedu.zhl.cloud.resource.resourceList.service.SysResourceService;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 系统资源 serviceImpl
 * 
 * @author WeiCuicui
 *
 */
@Service("sysResourceService")
public class SysResourceServiceImpl implements SysResourceService {

	@Resource
    SysResourceMapper sysResourceMapper;

    @Resource
    ResTypeMapper resTypeMapper;

   
    /**
     * 查询系统资源列表
     */
    @Override
    public Pagination<SysResourceEntity> getAllSysRes(long poolId, int mTypeId, String fileFormat, String tfcode,
            int orderBy, int page, int perPage,List<Integer> sys_from,int expire) {
      
    	//根据资源库id、父类型id，获取父类型及其子类型
    	List<Integer> typeIds = resTypeMapper.getTypesByPMTypeAndPool(poolId, mTypeId);
    	
        List<SysResourceEntity> list = new ArrayList<SysResourceEntity>();
    	
    	if(typeIds != null && typeIds.size() > 0){
    		// Page插件必须放在查询语句之前紧挨的第一个位置
            PageHelper.startPage(page, perPage);

            // 查询系统资源
            list = sysResourceMapper.getAllSysRes(sys_from, fileFormat,tfcode, orderBy,typeIds);
    	}
               
        // 判断资源是否为最新
        for (int i = 0; i < list.size(); i++) {
        	
            // 最后更新日期
            Date date = list.get(i).getUpdateDT();
            // 得到当前日期的前多少天
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -expire);
            Date expireDate = calendar.getTime();
            // 比较
            if (date.getTime() >= expireDate.getTime())
                list.get(i).setNew(true);
        }

        // 封装结果集
        PageInfoToPagination<SysResourceEntity> transfer = new PageInfoToPagination<SysResourceEntity>();

        return transfer.transfer(list);
    }
    
    
    /**
     * e备课，查询系统资源（限制资源类型，资源title模糊查询）
     */
    @Override
	public Pagination<SysResourceEntity> getAllSysRes_EPrepare(long poolId, int mTypeId, String fileFormat, String tfcode,
            int orderBy, int page, int perPage,String searchWord,List<Integer> removeTypeIds,List<Integer> sys_from,int expire){
    	
    	//查询受限类型及其子类型
    	List<Integer> removeTypes = resTypeMapper.getLimitedResTypes(removeTypeIds);
    
    	List<Integer> typeIds = resTypeMapper.getTypesByPMTypeAndPool_EPrepare(poolId, mTypeId, removeTypes);
    	
    	List<SysResourceEntity> list = new ArrayList<SysResourceEntity>();
    	
    	if(typeIds != null && typeIds.size() > 0){
    		// Page插件必须放在查询语句之前紧挨的第一个位置
            PageHelper.startPage(page, perPage);

            // 查询系统资源
            list = sysResourceMapper.getAllSysRes_EPrepare(sys_from, fileFormat,tfcode, orderBy, searchWord,typeIds);
    	}
               
        // 判断资源是否为最新
        for (int i = 0; i < list.size(); i++) {

            // 最后更新日期
            Date date = list.get(i).getUpdateDT();
            // 得到当前日期的前多少天
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -expire);
            Date expireDate = calendar.getTime();
            // 比较
            if (date.getTime() >= expireDate.getTime())
                list.get(i).setNew(true);
        }

        // 封装结果集
        PageInfoToPagination<SysResourceEntity> transfer = new PageInfoToPagination<SysResourceEntity>();

        return transfer.transfer(list);
    }
}