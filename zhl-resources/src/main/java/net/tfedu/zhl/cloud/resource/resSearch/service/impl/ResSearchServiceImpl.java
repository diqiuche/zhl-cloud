package net.tfedu.zhl.cloud.resource.resSearch.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.poolTypeFormat.dao.FileFormatMapper;
import net.tfedu.zhl.cloud.resource.resSearch.dao.ResSearchMapper;
import net.tfedu.zhl.cloud.resource.resSearch.entity.ResSearchResultEntity;
import net.tfedu.zhl.cloud.resource.resSearch.service.ResSearchService;
import net.tfedu.zhl.cloud.resource.resourceList.dao.DistrictResMapper;
import net.tfedu.zhl.cloud.resource.resourceList.entity.PageInfoToPagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.sso.user.dao.JUserMapper;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

/**
 * 资源跨库检索的service
 * 
 * @author WeiCuicui
 *
 */
@Service("resSearchService")
public class ResSearchServiceImpl implements ResSearchService {

	@Resource
    ResSearchMapper resSearchMapper;
    @Resource
    FileFormatMapper fileFormatMapper;
    @Resource DistrictResMapper districtResMapper;
    
    @Resource JUserMapper jUserMapper;

    /**
     * 跨库检索资源
     */
    @Override
    public Pagination<ResSearchResultEntity> getResources(int fromFlag, List<Integer> sys_from, String searchKeyword,
            String format, int page, int perPage,long userId,int expire) {

        // 存放查询结果
        List<ResSearchResultEntity> list = new ArrayList<ResSearchResultEntity>();
        // 封装结果集
        PageInfoToPagination<ResSearchResultEntity> transfer = new PageInfoToPagination<ResSearchResultEntity>();

        
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
  
        // 查询满足条件的全部资源
        if (fromFlag == -1) {

            // Page插件必须放在查询语句之前紧挨的第一个位置
            PageHelper.startPage(page, perPage);
            list = resSearchMapper.getAllResources(searchKeyword, format, sys_from,schoolId, districtId);
        } else if (fromFlag == 0) { // 系统资源

            // Page插件必须放在查询语句之前紧挨的第一个位置
            PageHelper.startPage(page, perPage);
            list = resSearchMapper.getAllSysResources(searchKeyword, format, sys_from);
        } else if(fromFlag == 3 || fromFlag == 4){ // 校本资源、区本资源

        	
            // Page插件必须放在查询语句之前紧挨的第一个位置
            PageHelper.startPage(page, perPage);
            list = resSearchMapper.getAllDisResources(searchKeyword, fromFlag, format,schoolId, districtId);
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
        //将pageIn封装为自定义的pagination
        return transfer.transfer(list);
    }
    
    /**
     * 查询资源格式
     */
    @Override
	public List<String> getFileFormats(String searchKeyword,int fromFlag,List<Integer> sys_from,long userId){
    	 
        
        List<String> resultList = new ArrayList<String>();
        
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
        
        // 查询全部资源的格式
        if (fromFlag == -1) {

        	resultList = resSearchMapper.getAllFileFormats(searchKeyword, sys_from,schoolId,districtId);
        	
        } else if (fromFlag == 0) { // 系统资源的格式

        	resultList = resSearchMapper.getSysFileFormats(searchKeyword, sys_from);
        } else if(fromFlag == 3 || fromFlag == 4){ // 校本资源、区本资源的格式

            resultList = resSearchMapper.getDisFileFormats(searchKeyword, fromFlag,schoolId,districtId);
        }
        
        resultList.add(0,"全部"); // 增加一个全部的链接
        
        return resultList;
    }

}
