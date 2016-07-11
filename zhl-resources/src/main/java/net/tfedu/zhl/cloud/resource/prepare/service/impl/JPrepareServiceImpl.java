package net.tfedu.zhl.cloud.resource.prepare.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.downloadrescord.dao.ResDownRecordMapper;
import net.tfedu.zhl.cloud.resource.downloadrescord.entity.ResDownRecord;
import net.tfedu.zhl.cloud.resource.prepare.dao.JPrepareContentMapper;
import net.tfedu.zhl.cloud.resource.prepare.dao.JPrepareMapper;
import net.tfedu.zhl.cloud.resource.prepare.entity.FirstNavigationInfo;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepare;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContent;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareView;
import net.tfedu.zhl.cloud.resource.prepare.entity.ResourceSimpleInfo;
import net.tfedu.zhl.cloud.resource.prepare.entity.UserPrepareStatisInfo;
import net.tfedu.zhl.cloud.resource.prepare.service.JPrepareService;
import net.tfedu.zhl.cloud.resource.prepare.util.JPrepareConstant;
import net.tfedu.zhl.cloud.resource.resourceList.dao.DistrictResMapper;
import net.tfedu.zhl.cloud.resource.resourceList.dao.SysResourceMapper;
import net.tfedu.zhl.cloud.resource.resourceList.entity.PageInfoToPagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.resource.userlog.dao.JUserlogMapper;
import net.tfedu.zhl.cloud.resource.userlog.entity.JUserlog;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.core.exception.PrepareContentExistException;
import net.tfedu.zhl.helper.ResultJSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;

@Service("jPrepareService")
public class JPrepareServiceImpl implements JPrepareService {

	/**
	 * 备课夹
	 */
    @Autowired
    JPrepareMapper mapper;

	/**
	 * 备课夹内容
	 */
    @Autowired
    JPrepareContentMapper contMapper;
    
	/**
	 * 区校本资源
	 */    
    @Autowired
    DistrictResMapper disResMapper; 
    
    
    /**
     * 系统资源
     */
    @Autowired
    SysResourceMapper sysResMapper;
    
    /**
     * 下载
     */
    @Autowired
    ResDownRecordMapper downMapper;
    
    
    @Autowired
    JUserlogMapper logMapper;

    @Override
    public JPrepare addPrepare(JPrepare obj) {
    	
//    	int repeatTimes = mapper.getRepeatTimes(obj.getTfcode(), obj.getTitle(), obj.getUserid());
    	
    	int repeatTimes = mapper.getAllRepeatTimes(obj.getTitle()+"%", obj.getUserid());
    	
    	if(repeatTimes>0){
    		obj.setTitle(obj.getTitle()+"("+repeatTimes+")");
    	}
    	
        mapper.insert(obj);
        return obj;
    }

    @Override
    public void editPrepare(JPrepare obj) {
        mapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public void deletePrepareById(Long id) {
        Date currentDate = Calendar.getInstance().getTime();

    	JPrepare p = new JPrepare();
    	p.setFlag(true);
    	p.setId(id);
    	p.setUpdatetime(currentDate);
        mapper.updateByPrimaryKeySelective(p);
    }

    @Override
    public void addPrepareContent(JPrepareContent content) throws Exception{
       
        //排重
        Boolean isExist = contMapper.isPrepareContentExist(content.getPreid(), content.getContid(), content.getConttype());
        if(isExist!=null &&true==isExist){
        	throw new PrepareContentExistException();
        }
        
        JPrepareContent record = new JPrepareContent();
        record.setPreid(content.getPreid());
        int count =  contMapper.selectCount(record);
        content.setOrderidx(count+1);

        //增加内容
    	contMapper.insert(content);
        
        //更新备课夹的更新时间
        Date currentDate = Calendar.getInstance().getTime();
        JPrepare obj = new JPrepare();
        obj.setId(content.getPreid());
        obj.setUpdatetime(currentDate);
        mapper.updateByPrimaryKeySelective(obj);
    }

    @Override
    public void editPrepareContent(JPrepareContent content) {
    	
        contMapper.updateByPrimaryKeySelective(content);
    }

    @Override
    public void deletePrepareContentById(Long id) throws Exception{
    	JPrepareContent record = new JPrepareContent();
    	record.setId(id);
    	record.setFlag(true);
        contMapper.updateByPrimaryKeySelective(record);
        
        
        JPrepareContent content =  contMapper.selectByPrimaryKey(id);

        if(content!=null){
            Date currentDate = Calendar.getInstance().getTime();
            //更新备课夹的更新时间
             JPrepare obj = new JPrepare();
             obj.setId(content.getPreid());
             obj.setUpdatetime(currentDate);
             mapper.updateByPrimaryKeySelective(obj);
        }else{
        	throw new ParamsException();
        }
   
        
    }

    @Override
    public void clearPrepareContentByPrepareId(Long prepareId) {
        Date currentDate = Calendar.getInstance().getTime();
       //更新备课夹的更新时间
        JPrepare obj = new JPrepare();
        obj.setId(prepareId);
        obj.setUpdatetime(currentDate);
        mapper.updateByPrimaryKeySelective(obj);
        
        mapper.clearPrepareContentByPrepareId(prepareId);
    }

    @Override
    public List<JPrepareView> queryPrepareList(String tfcode, Long userId) {
        // TODO Auto-generated method stub
        return mapper.queryPrepareList(tfcode + "%", userId);
    }

    @Override
    public List<JPrepareView> querySelfPrepareList(String tfcode, Long userId){
    	return mapper.querySelfPrepareList(tfcode, userId);
    }
    
    
    @Override
    public List<JPrepareView> queryPrepareAndTimeScopeList(String tfcode,String title, Long userId) {
        // TODO Auto-generated method stub
        return mapper.queryPrepareAndTimeScopeList(tfcode + "%",StringUtils.isEmpty(title)?"":("%"+title+"%"), userId);
    }

    @Override
    public List<JPrepareContentView> queryPrepareContentList(Long prepareId) {
        // TODO Auto-generated method stub

        List<JPrepareContentView> list = mapper.queryPrepareContentList(prepareId);
        return list;
    }

    @Override
    public void removeResourceFromPrepare(Long prepareId, Integer contType, Long contId) {
        // TODO Auto-generated method stub
    	mapper.removeResourceFromPrepare(prepareId, contType, contId);
    	
    	
        Date currentDate = Calendar.getInstance().getTime();
       //更新备课夹的更新时间
        JPrepare obj = new JPrepare();
        obj.setId(prepareId);
        obj.setUpdatetime(currentDate);
        mapper.updateByPrimaryKeySelective(obj);

    }

    @Override
    public void addToPrepareWithOnlySysResource(String resCode, Long userId) {
        // TODO Auto-generated method stub
        // 获取资源的第一个导航节点
        FirstNavigationInfo nav = mapper.getFirstNavigationForSysResource(resCode);
        if (nav != null) {
            String tfcode = nav.getTfcode();
            // 获取节点下的备课夹
            List<JPrepareView> list = mapper.queryPrepareList(tfcode, userId);
            // 如果有则 加入到备课夹
            // 没有则 新建备课夹 加入
            Date currentDate = Calendar.getInstance().getTime();
            long prepareId = 0;
            if (list != null && list.size() > 0) {
            	JPrepareView _prepare = list.get(0);
            	prepareId = _prepare.getId();
                // 将资源加入备课夹
                JPrepareContent cont = new JPrepareContent();
                cont.setPreid(_prepare.getId());
                cont.setContid(nav.getResId());
                cont.setConttype(JPrepareConstant.CONTTYPE_SYSRES);
                cont.setCreatetime(currentDate);
                contMapper.insert(cont);
                
              //更新备课夹的更新时间
                JPrepare obj = new JPrepare();
                obj.setId(prepareId);
                obj.setUpdatetime(currentDate);
                mapper.updateByPrimaryKeySelective(obj);
            } else {
                String title = nav.getTitle();
                // 新建备课夹
                JPrepare  prepare = new JPrepare();
                prepare.setUserid(userId);
                prepare.setCreatetime(currentDate);
                prepare.setTfcode(tfcode);
                prepare.setTitle(title);
                mapper.insert(prepare);
                prepareId = prepare.getId();
                
                // 将资源加入备课夹
                JPrepareContent cont = new JPrepareContent();
                cont.setPreid(prepare.getId());
                cont.setContid(nav.getResId());
                cont.setConttype(JPrepareConstant.CONTTYPE_SYSRES);
                cont.setCreatetime(currentDate);
                contMapper.insert(cont);
            }
        }
    }

    @Override
    public void exchangeContOrderIdx(long prevId, long nextId) {
        JPrepareContent p = contMapper.selectByPrimaryKey(prevId);
        JPrepareContent n = contMapper.selectByPrimaryKey(nextId);

        int prev_idx = p.getOrderidx();
        int next_idx = n.getOrderidx();

        p.setOrderidx(next_idx);
        n.setOrderidx(prev_idx);

        contMapper.updateByPrimaryKey(p);
        contMapper.updateByPrimaryKey(n);

    }

    @Override
    public List<ResourceSimpleInfo> getResourceSimpleInfo(String[] ids, String[] fromFlags) {
        List<ResourceSimpleInfo> list = new ArrayList<ResourceSimpleInfo>();
        for (int i = 0; i < fromFlags.length; i++) {
            ResourceSimpleInfo info = null;
            switch (Integer.parseInt(fromFlags[i])) {
            case JPrepareConstant.fromFlag_localRes:
            case JPrepareConstant.fromFlag_sharedRes:
                info = mapper.getAssetInfo(Long.parseLong(ids[i]));
                break;

            case JPrepareConstant.fromFlag_sysRes:

                info = mapper.getResourceInfo(Long.parseLong(ids[i]));
                break;

            case JPrepareConstant.fromFlag_districtRes:
            case JPrepareConstant.fromFlag_schoolRes:
                info = mapper.getDistrictORSchoolResInfo(Long.parseLong(ids[i]));
                break;
            }
            list.add(info);
        }
        return list;
    }

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
    @Override
    public Pagination getPrepareContentListByUserId(Long userId, Long unifyTypeId, String fileFormat, Integer page,
            Integer prePage) {
        PageHelper.startPage(page, prePage);
        List<JPrepareContentView> list = contMapper.getPrepareContentListByUserId(userId, unifyTypeId, fileFormat);
        Pagination p = new PageInfoToPagination().transfer(list);
        return p;
    }

    /**
     * 将指定资源从我的备课夹中清除
     * 
     * @param userId
     * @param resIds
     * @param fromFlags
     */
    @Override
    public void removeMyPrepareContentResource(Long userId, String resIds, String fromFlags) 
    throws Exception{
        // 非空判断
        if (StringUtils.isEmpty(resIds) || StringUtils.isEmpty(fromFlags)) {
			throw new ParamsException();
		}
        String[] resId = resIds.split(",");
        String[] fromFlag = fromFlags.split(",");
        if (resId.length != fromFlag.length) {
			throw new ParamsException();        }
        for (int i = 0; i < fromFlag.length; i++) {
            long _resId = Long.parseLong(resId[i]);
            int _contType = JPrepareConstant.getContTypeByFromFlag(Integer.parseInt(fromFlag[i]));
            contMapper.removeMyPrepareContentResource(userId, _resId, _contType);
        }
    }

    @Override
    public List<UserPrepareStatisInfo> getMyPrepareStatis(Long userId) {

        List<UserPrepareStatisInfo> list = mapper.getUserPrepareStatisButPartResult(userId);
        for (UserPrepareStatisInfo info : list) {
            UserPrepareStatisInfo temp = mapper.getBookPrepareStatis(userId, info.getTfcode() + "%");
            info.setNodeFinishedNums(temp.getNodeFinishedNums());
            info.setNodeOmitNums(temp.getNodeOmitNums());
            info.setPrepareNums(temp.getPrepareNums());
            info.setResourceNums(temp.getResourceNums());
        }
        return list;
    }

	@Override
	public List<ResourceSimpleInfo> getResourceSimpleInfoForView(String[] ids,
			String[] fromFlags,Long userId) {
		// TODO Auto-generated method stub		
		List<ResourceSimpleInfo>  list = this.getResourceSimpleInfo(ids, fromFlags);
		
		List<JUserlog> logList = new ArrayList<JUserlog>();
		
		Date time = Calendar.getInstance().getTime();
		
		String logTypeCode = "";
		
		//增加浏览记录、点击数  自建资源不处理
		for (ResourceSimpleInfo resourceSimpleInfo : list) {

			if(null == resourceSimpleInfo){
				continue;
			}
			
			
			
			String rescode = resourceSimpleInfo.getRescode();
			switch(resourceSimpleInfo.getFromflag()){
			
			
			//校本资源
			case JPrepareConstant.fromFlag_schoolRes:
				disResMapper.updateClickTime(rescode);
				
				break;
			//区本资源
			case JPrepareConstant.fromFlag_districtRes:
				disResMapper.updateClickTime(rescode);
				break;	
			//系统资源
			case JPrepareConstant.fromFlag_sysRes:
				sysResMapper.updateClickTime(rescode);
				break;	
			}			
			
			
			String  opertypecode = "view";
			
			JUserlog log = new JUserlog();
			log.setUserid(userId);
			log.setDownflag(false);
			log.setCreatetime(time);
			log.setAlltestnum(0);
			log.setCorrtestnum(0);
			log.setDuration("");
			log.setFlag(false);
			log.setIsflag(0);
			log.setLogtypecode(JPrepareConstant.getLogTypeByFromflag(resourceSimpleInfo.getFromflag()));
			log.setObjid(resourceSimpleInfo.getResid());
			log.setObjname(resourceSimpleInfo.getTitle());
			log.setOpertypecode(opertypecode);
			log.setSubjectid(0l);
			logList.add(log);
		}
		
		if(logList.size()>0){
			//批量插入浏览日志
			logMapper.insertList(logList);
		}
		return list;
	}

	@Override
	public List<ResourceSimpleInfo> getResourceSimpleInfoForDownload(
			String[] ids, String[] fromFlags ,Long userId) {
		// TODO Auto-generated method stub
		List<ResourceSimpleInfo>  list = this.getResourceSimpleInfo(ids, fromFlags);		
		List<ResDownRecord> downList =new ArrayList<ResDownRecord>();
		Date time = Calendar.getInstance().getTime();
		//增加下载记录、下载数   自建资源不处理
		for (ResourceSimpleInfo resourceSimpleInfo : list) {
			if(null == resourceSimpleInfo){
				continue;
			}
			String rescode = resourceSimpleInfo.getRescode();

			switch(resourceSimpleInfo.getFromflag()){			
			//校本资源
			case JPrepareConstant.fromFlag_schoolRes:
				disResMapper.updateDownloadTime(rescode);
				break;
			//区本资源
			case JPrepareConstant.fromFlag_districtRes:
				disResMapper.updateDownloadTime(rescode);
				break;	
			//系统资源
			case JPrepareConstant.fromFlag_sysRes:
				sysResMapper.updateDownloadTime(rescode);				
				break;					
			}	
			
			//自建资源不处理
			if(JPrepareConstant.fromFlag_localRes!=resourceSimpleInfo.getFromflag()){
				//准备添加下载记录
				ResDownRecord  record = new ResDownRecord();
				record.setUserid(userId);
				record.setFromflag(resourceSimpleInfo.getFromflag());
				record.setResid(resourceSimpleInfo.getResid());
				record.setDowndate(time);
				record.setDowntime(time);
				downList.add(record);
			}
		}
		if(downList.size()>0){
			//批量插入下载记录
			downMapper.insertList(downList);
		}
		
		return list;
	}

	@Override
	public List<JPrepareView> getLatestPrepare(Long userId) {
		// TODO Auto-generated method stub
		return mapper.getLatestPrepare(userId);
	}

	@Override
	public List<JPrepareView> queryPrepareAndTimeScopeList(Long termId,
			Long subjectId, String title, Long userId,String timeLabel) {
		
		//withinweek、withinmonth、moreearly
		//timeLabel = timeLabel==null?"withinweek":timeLabel.trim();
		timeLabel = timeLabel==null?"":timeLabel.trim();

		return mapper.queryPrepareByTermAndSubject(termId, subjectId, StringUtils.isEmpty(title)?"":("%"+title+"%"), userId,timeLabel);
	
	}

	@Override
	public Pagination queryPreparePage(String tfcode, Long userId,
			Integer page, Integer perPage) {
		
		PageHelper.startPage(page, perPage);
		List<JPrepareView> list= queryPrepareList(tfcode, userId);
		
		Pagination _page = new PageInfoToPagination().transfer(list);
		
		
		return _page;
	}

	@Override
	public void addPrepareContentList(List<JPrepareContent> list) throws Exception{
		if(list!=null && list.size()>0){
			if(list.size()==1){
				addPrepareContent(list.get(0));
			}else{
				//批量sql排重
				
		        JPrepareContent record = new JPrepareContent();
		        record.setPreid(list.get(0).getPreid());
		        int count =  contMapper.selectCount(record);

		        
				List<Long> preIds = new ArrayList<Long>();
				List<JPrepareContent> ls_remove = new ArrayList<JPrepareContent>();
		        for (JPrepareContent content : list) {
					if(!preIds.contains(content.getPreid())){
						preIds.add(content.getPreid());					
					}
					//排重
			        Boolean isExist = contMapper.isPrepareContentExist(content.getPreid(), content.getContid(), content.getConttype());
			        if(isExist!=null &&true==isExist){
			        	ls_remove.add(content);
			        }	else{
			        	content.setOrderidx(++count);
			        }
				}
				
				

				for (JPrepareContent jPrepareContent : ls_remove) {
					list.remove(jPrepareContent);
				}
		        
		        if(list.size()>0){
		        	//增加内容
			    	contMapper.insertList(list);
			        //更新备课夹的更新时间
			        Date currentDate = Calendar.getInstance().getTime();
			        for (Long id : preIds) {
				        JPrepare obj = new JPrepare();
				        obj.setId(id);
				        obj.setUpdatetime(currentDate);
				        mapper.updateByPrimaryKeySelective(obj);
					}
		        }

		        
			}
		}
		// TODO Auto-generated method stub
	}

	@Override
	public Pagination<JPrepareContentView> queryPrepareContentPage(Long prepareId, Integer page,
			Integer perPage) {
		PageHelper.startPage(page, perPage);
		List<JPrepareContentView> list =  queryPrepareContentList(prepareId);
		return new PageInfoToPagination<JPrepareContentView>().transfer(list);
	}

	@Override
	public Pagination<JPrepareView> queryPrepareByTermSubject(Long termId,
			Long subjectId, String title, Long userId, Integer page,
			Integer perPage,String timeLabel) {

		PageHelper.startPage(page, perPage);
		List<JPrepareView>  list = queryPrepareAndTimeScopeList(termId, subjectId, title, userId,timeLabel);
		return new PageInfoToPagination<JPrepareView>().transfer(list);
	}

	@Override
	public ResultJSON copyPrepare(Long prepareId,String tfcode) throws Exception {
		Date time = Calendar.getInstance().getTime();
		
		JPrepare obj =  mapper.selectByPrimaryKey(prepareId);
		obj.setId(null);
		obj.setUpdatetime(time);
		obj.setTfcode(tfcode);
		mapper.insert(obj);

		contMapper.copyPrepareContent(prepareId.toString(), obj.getId().toString());
		
		return ResultJSON.getSuccess(obj.getId());
	
	}

	@Override
	public ResultJSON movePrepare(Long prepareId,String tfcode) throws Exception {
		
		JPrepare obj = new JPrepare();
		obj.setId(prepareId);
		obj.setTfcode(tfcode);
		editPrepare(obj);
		
		return ResultJSON.getSuccess("");
	}

	@Override
	public Pagination<JPrepareContentView> queryLimitedPrepareContentPage(
			Long prepareId, Integer page, Integer perPage,
			String[] removeTypeIds) {
		PageHelper.startPage(page, perPage);
		List<JPrepareContentView> list =  mapper.queryLimitedPrepareContentList(prepareId, removeTypeIds);
//		List<JPrepareContentView> list =  mapper.queryPrepareContentList(prepareId);
		return new PageInfoToPagination<JPrepareContentView>().transfer(list);
	}
	

	public Pagination<JPrepareContentView> queryLimitedPrepareContentListWithoutNet(
			Long prepareId, Integer page, Integer perPage,
			String[] removeTypeIds) {
		PageHelper.startPage(page, perPage);
		List<JPrepareContentView> list =  mapper.queryLimitedPrepareContentListWithoutNet(prepareId, removeTypeIds);
		return new PageInfoToPagination<JPrepareContentView>().transfer(list);
	}
	
	@Override
	public Pagination<JPrepareContentView> queryLimitedPrepareContentPage(
			Long prepareId, Integer page, Integer perPage,
			String[] removeTypeIds, boolean ifGetNet) {
		if(ifGetNet){
			return queryLimitedPrepareContentPage(prepareId, page, perPage, removeTypeIds);
		}else{
			return queryLimitedPrepareContentListWithoutNet(prepareId, page, perPage, removeTypeIds);
		}
	}
	
	
	
	

	@Override
	public ResultJSON getPrepareNodeInfo(Long prepareId,int perPage) {
		//默认分页10条
		perPage = perPage==0?10:perPage;

		String tfcode = "";
		
		int page = 1 ;
		
		//获取节点信息 
		JPrepare obj = mapper.selectByPrimaryKey(prepareId);
		
		tfcode = obj.getTfcode();
		//获取分页页面信息
		Integer rowno = mapper.getPrepareIndxInfo(tfcode, prepareId);
		if(rowno!=null && rowno>0){
			page = rowno/perPage + (rowno%perPage==0?0:1);
		}
		
		HashMap nodeInfo = mapper.getNodeInfo(tfcode);
		
		nodeInfo.put("page", page);
		nodeInfo.put("tfcode", tfcode);
		
		return ResultJSON.getSuccess(nodeInfo);
	}
	
	
	public HashMap getNodeInfo(String tfcode){
		HashMap map = mapper.getNodeInfo(tfcode);
		map.put("tfcode", tfcode);
		return  map;

	}
	
	public static void main(String[] args) {
		int page = 1 ;
		int rowno = 11 ;
		int perPage = 10 ;
		System.out.println(page = rowno/perPage + (rowno%perPage==0?0:1));
	}

	

}