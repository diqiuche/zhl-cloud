package net.tfedu.zhl.cloud.resource.asset.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;

import net.tfedu.zhl.cloud.resource.asset.dao.ZAssetMapper;
import net.tfedu.zhl.cloud.resource.asset.dao.ZAssetSyscourseMapper;
import net.tfedu.zhl.cloud.resource.asset.dao.ZAssetValuateMapper;
import net.tfedu.zhl.cloud.resource.asset.dao.ZTypeConvertMapper;
import net.tfedu.zhl.cloud.resource.asset.entity.ResourceReview;
import net.tfedu.zhl.cloud.resource.asset.entity.ReviewResultStatis;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAsset;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetEditInfo;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetSyscourse;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetValuate;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetView;
import net.tfedu.zhl.cloud.resource.asset.entity.ZTypeConvert;
import net.tfedu.zhl.cloud.resource.asset.service.ZAssetService;
import net.tfedu.zhl.cloud.resource.asset.util.AssetTypeConvertConstant;
import net.tfedu.zhl.cloud.resource.extrelativeteachingtype.dao.ExtRelativeTeachingTypeMapper;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.dao.FileFormatMapper;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.dao.ResTypeMapper;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.cloud.resource.prepare.entity.JPrepareContentView;
import net.tfedu.zhl.cloud.resource.resourceList.dao.DistrictResMapper;
import net.tfedu.zhl.cloud.resource.resourceList.dao.DistrictsResNavMapper;
import net.tfedu.zhl.cloud.resource.resourceList.entity.DisResourceEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.DistrictRes;
import net.tfedu.zhl.cloud.resource.resourceList.entity.DistrictsResNav;
import net.tfedu.zhl.cloud.resource.resourceList.entity.PageInfoToPagination;
import net.tfedu.zhl.cloud.resource.resourceList.entity.Pagination;
import net.tfedu.zhl.cloud.resource.share.dao.XPlatFormShareMapper;
import net.tfedu.zhl.cloud.resource.share.dao.XShareResNavMapper;
import net.tfedu.zhl.cloud.resource.share.entity.XPlatFormShare;
import net.tfedu.zhl.cloud.resource.share.entity.XShareResNav;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.core.exception.ParamsException;
import net.tfedu.zhl.core.service.BaseService;
import net.tfedu.zhl.core.service.impl.BaseServiceImpl;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.user.dao.JUserMapper;

@Service("zAssetService")
public class ZAssetServiceImpl  extends BaseServiceImpl<ZAsset> implements ZAssetService {
	
	
	Logger logger = LoggerFactory.getLogger(ZAssetServiceImpl.class);

	
	@Autowired
	ResTypeMapper typeMapper;
	
	@Autowired
	FileFormatMapper formatMapper;
	
	/**
	 * 评论service
	 */
	@Autowired
	ZAssetValuateMapper reviewMapper;
	
	@Autowired
	ZAssetSyscourseMapper syscourseMapper;
	
	
	@Autowired
	ZAssetMapper assetMapper;
	
	
	@Autowired
	ZTypeConvertMapper convertMapper; 
	
	@Autowired
	JUserMapper userMapper;
	
	
	@Autowired
	DistrictResMapper districtMapper;
	
	@Autowired
	ZAssetSyscourseMapper asMapper;
	
	@Autowired
	DistrictsResNavMapper districtResNavMapper;
	
	
	@Autowired
	ExtRelativeTeachingTypeMapper relateTypeMapper;
	
	
	@Autowired
	XShareResNavMapper shareResnavMapper;
	
	@Autowired
	XPlatFormShareMapper shareMapper;
	
	
	@Override
	public List<FirstLevelResType> getAllFirstLevelResType() {
		// TODO Auto-generated method stub
		
		List<FirstLevelResType> list =typeMapper.getAllFirstLevelResType();
		FirstLevelResType e  = new FirstLevelResType();
		e.setId(0l);
		e.setCode("all");
		e.setMtype("全部");
		list.add(0, e);
		return list;
	}




	@Override
	public List<String> getAllFileFormat() {
		// TODO Auto-generated method stub
		List<String> list = formatMapper.getAllFileFormat();
		list.add(0,"全部");
		return list;
	}




	@Override
	public Pagination getMyReview(Long userId, Integer reviewType,Integer page,Integer perPage) {
		PageHelper.startPage(page, perPage);
		List<ResourceReview> list  = reviewMapper.getMyReview(userId, reviewType);
		Pagination p = new PageInfoToPagination().transfer(list);
		return p ;
	}




	@Override
	public void removeMyReview(String ids) {
		if(StringUtils.isNotEmpty(ids)){
			String id[] = ids.split(",");
			for (String string : id) {
				ZAssetValuate z = new ZAssetValuate();
				z.setId(Long.parseLong(string));
				z.setFlag(true);
				reviewMapper.updateByPrimaryKeySelective(z);
			}
		}
	}




	@Override
	public ReviewResultStatis getReviewStatis(Long userId) {
		/**
		 * 已经评价的资源数
		 */
		Integer reviewNumber  = reviewMapper.getReviewedNum(userId);
		
		/**
		 * 未评价的资源数
		 */
		Integer unReviewNumber = reviewMapper.getUnReviewedNum(userId);
		
		ReviewResultStatis obj = new ReviewResultStatis();
		obj.setReviewNumber(reviewNumber);
		obj.setUnReviewNumber(unReviewNumber);
		return obj;
	}




	@Override
	public void setTypeConvertSucceed(String resServiceLocal,Long userId, String resPath) {
		ZTypeConvert obj = new ZTypeConvert();
		obj.setUserid(userId);
		obj.setRespath(resPath);
		obj.setCreatetime(Calendar.getInstance().getTime());
		convertMapper.insert(obj);
		
		assetMapper.updateAssetFinished(userId, resPath);
		
		
		
		
		
		Integer scope = syscourseMapper.getAssetShareScope(String.valueOf(userId), resPath);
		
		logger.debug("自建资源“"+resPath+"”更新状态，scope = "+scope);
		
		//共享范围   0 个人可见 1 校本共享 2 区本共享
		if(scope!=null && scope>0){
			long schoolid = 0 ;
			long districtid=  0;
			HashMap<String,Object> map =  userMapper.getUserAreaInfo(userId);
			if(map!=null){
				districtid =  (map.get("districtid") instanceof java.lang.String )
								?Long.parseLong(map.get("districtid").toString())
								:Long.parseLong(String.valueOf(map.get("districtid")));
				schoolid = (map.get("schoolid") instanceof java.lang.String )
						?Long.parseLong(map.get("schoolid").toString())
						:Long.parseLong(String.valueOf(map.get("schoolid")));
			}	
			
			//查询记录
			ZAsset record = assetMapper.selectOneByPath(String.valueOf(userId), resPath);
			
			//获取同一时间 user 创建的区校本资源 
			DisResourceEntity res = districtMapper.selectOneByTime(String.valueOf(userId), record.getCreatetime());
		

			logger.debug("对应的区本、校本资源："+res.getFullpath());

			//拷贝缩略图和转换后的文件
			String _fullpath = res.getFullpath();
			//格式转换完成，拷贝缩略图
			ZhlResourceCenterWrap.copyFile(resServiceLocal, 
					resPath.substring(0, resPath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE
					,_fullpath.substring(0, _fullpath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);
			
			logger.debug("THUMBNAILS_IMG_TYPE1："+resPath.substring(0, resPath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);
			logger.debug("THUMBNAILS_IMG_TYPE2："+_fullpath.substring(0, _fullpath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);

			if( AssetTypeConvertConstant.isNeedConvert(resPath)){
				//格式转换完成，拷贝转换后的文件
				ZhlResourceCenterWrap.copyFile(resServiceLocal
						, AssetTypeConvertConstant.convertType(resPath)
						, AssetTypeConvertConstant.convertType(_fullpath));
				logger.debug("convertType："+AssetTypeConvertConstant.convertType(resPath));
				logger.debug("convertType2："+AssetTypeConvertConstant.convertType(_fullpath));
				
			}
		
		
		}
	}




	@Override
	public void addAssetBatch(List<ZAsset> list,List<String>codes,ArrayList<Integer> scope_list,String resServiceLocal, String currentResPath, String hostLocal) throws Exception {
		long schoolid = 0 ;
		long districtid=  0;
		
		
		
		
		List<DistrictRes> dResList = new ArrayList();
		List<DistrictsResNav> dResNavList = new ArrayList();
		

		
		List<XShareResNav> shareResnavList = new ArrayList();
		List<XPlatFormShare> shareList = new ArrayList();
		
		List<String> source_4_copy = new ArrayList<String>();
		List<String> target_4_copy = new ArrayList<String>();
		
		
		//如果需要共享到区校
		if(scope_list.contains(1)||scope_list.contains(2)){
			HashMap<String,Object> map =  userMapper.getUserAreaInfo(list.get(0).getUserid());
			if(map!=null){
				districtid =  (map.get("districtid") instanceof java.lang.String )
								?Long.parseLong(map.get("districtid").toString())
								:Long.parseLong(String.valueOf(map.get("districtid")));
				schoolid = (map.get("schoolid") instanceof java.lang.String )
						?Long.parseLong(map.get("schoolid").toString())
						:Long.parseLong(String.valueOf(map.get("schoolid")));
			}			
		}
		
		Date time = Calendar.getInstance().getTime();
		
		//检测是否
		for (int i=0;i<list.size();i++) {
			ZAsset asset = list.get(i);
			//共享范围   0 个人可见 1 校本共享 2 区本共享
			int scope = scope_list.get(i);
			
			
			//0：转码完成，1：未完成
			int isfinished = 1 ;
			//如果更新了文件且需要格式转换
			if(AssetTypeConvertConstant.isNeedConvert(asset.getAssetpath())){
				//检测是否已经完成格式转换
				ZTypeConvert obj =  convertMapper.getConvertRecord(asset.getUserid(), asset.getAssetpath());				
				if(null == obj){
					isfinished = 1 ;	
				}else{
					//格式转换完成
					isfinished = 0 ;
				}				
			}else{
				isfinished = 0 ;
			}
			asset.setIsfinished(isfinished);
			
			if(scope>0){
				
				//区本资源表中的  资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
				int _scope = scope==1?5:4;
				long _scopeId = _scope==5?schoolid:districtid;

				
				
				
				String assetPath =asset.getAssetpath();
				String tfcode = codes.get(i);
				//组装区本、校本路径
				assetPath =  assetPath.replaceAll("\\\\", "/");
				//是否为本地资源：0为本地资源1为网络资源
				String _name = asset.getIslocal() ==1 ?"":assetPath.substring(assetPath.lastIndexOf("/")+1,assetPath.length());
				
				String _path = asset.getIslocal() ==1 ?assetPath:AssetTypeConvertConstant.getAreaPathPrefix(scope, schoolid, districtid, tfcode);
				String _fullpath = _path+_name;
				
				
				
				String rescode = AssetTypeConvertConstant.getResCodeForDistrictRes(scope, tfcode);
				//复制到区本校本资源
				DistrictRes res = new DistrictRes();
				
				res.setScope(_scope);
				res.setScopeid(_scopeId);
				res.setFromflag(scope==1?3:4);
				res.setRescode(rescode);
				res.setCreatedt(time);
				//作者
				res.setAuthorid(asset.getUserid());
				res.setFname(_name);
				res.setFpath(_path);
				res.setFullpath(_fullpath);
				
				//创建者（后台管理员）
				res.setCreatorid(0l);
				res.setDes(asset.getAssetdesc());
				res.setMtype(asset.getUnifytypeid());
				res.setTitle(asset.getName());
				res.setKeyword(asset.getKeyword());	
				res.setRdes("");
				
				res.setTypelean("");
				res.setAuditopinion("");
				res.setAuthorfromflag(1);
				res.setAuthorunit("");
				res.setClicktimes(0);
				res.setCopyright("");
				res.setDisplayindex(0);
				res.setDisplaylevel(0);
				res.setDloadscore(0);
				res.setDloadtimes(0);
				res.setEditorid(0l);
				res.setEduplace("");
				//后缀
				String  fileext =assetPath.substring(assetPath.lastIndexOf(".") + 1, assetPath.length());
				res.setFileext(asset.getIslocal()==0?fileext:"html");
				res.setFlag(false);
				res.setFsize(asset.getAssetsize());
				res.setIsdwj(asset.getIswjb());
				res.setIsfinished(isfinished);
				//区本资源中的网络资源islocal为0，上传资源为1
				res.setIslocal(1-asset.getIslocal());
				res.setSuitterm("");
				res.setSctimes(0);
				//待审核
				res.setState(4);
				res.setCopyright("");
				res.setAuthorfromflag(1);
				
				res.setUploadscore(0);
				res.setUpdatedt(time);
				dResList.add(res);
				
				
				
				DistrictsResNav resNav = new DistrictsResNav();
				resNav.setFlag(false);
				resNav.setRescode(rescode);
				resNav.setStructcode(tfcode);				
				dResNavList.add(resNav);
				
				
				
				if(isfinished == 0 && asset.getIslocal() == 0 ){
					
					//格式转换完成，拷贝缩略图
					source_4_copy.add(assetPath.substring(0, assetPath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);
					target_4_copy.add(_fullpath.substring(0, _fullpath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);
					if( AssetTypeConvertConstant.isNeedConvert(asset.getAssetpath())){
						//格式转换完成，拷贝转换后的文件
						source_4_copy.add(AssetTypeConvertConstant.convertType(assetPath));
						target_4_copy.add(AssetTypeConvertConstant.convertType(_fullpath));
					}
				}

				//非网络资源复制
				if(asset.getIslocal() == 0 ){
					//复制（源文件）到目标目录
					source_4_copy.add(assetPath);
					target_4_copy.add(_fullpath);
				}
			}
			
		}
		
		logger.debug("start  to save data to database ...... ");
		assetMapper.insertList(list);

		logger.debug("insert asset to database batch ");

		//批量添加资源的导航信息
		List<ZAssetSyscourse> asList = new ArrayList<ZAssetSyscourse>();
		for (int i=0;i<list.size();i++) {
			int scope = scope_list.get(i);
			
			ZAsset asset = list.get(i);
			String  tfcode = codes.get(i);
			long resid= asset.getId();
			ZAssetSyscourse  as = new ZAssetSyscourse();
			as.setAssetid(resid);
			as.setTfcode(tfcode);
			as.setFlag(false);
			as.setSharescope(scope);
			asList.add(as);
			
			//取消资源添加
			if(dResList.size()>0){
				dResList.get(i).setAssetid(resid);
			}
			
			
			
			
			//共享范围   0 个人可见 1 校本共享 2 区本共享  增加共享
			if(scope>0){
				
				XShareResNav shareResNav = new XShareResNav();
				shareResNav.setCodetype(0);
				shareResNav.setFlag(false);
				shareResNav.setResid(resid);
				shareResNav.setStructcode(tfcode);
				shareResnavList.add(shareResNav);

				XPlatFormShare fShare = new XPlatFormShare(); 
				fShare.setClicks(0);
				fShare.setCreatetime(time);
				fShare.setDownloads(0);
				fShare.setFlag(false);
				fShare.setQuotes(0);
				fShare.setScope(1==scope?"D":"C");
				fShare.setScopeid(1==scope?schoolid:districtid);
				fShare.setSharedtype(1);
				fShare.setShareid(resid);
				fShare.setStudycourseid("");
				fShare.setSysresourcetype(new Long(asset.getUnifytypeid()));
				fShare.setUserid(asset.getUserid());				
				shareList.add(fShare);
			}

			
			
			
			
		}
		if(asList.size()>0){
			logger.debug("add asset_syscourse to database batch .....");
			asMapper.insertList(asList);
		}
		if(shareResnavList.size()>0){
			shareResnavMapper.insertList(shareResnavList);
		}
		if(shareList.size()>0){
			shareMapper.insertList(shareList);
		}
		
		//如果需要共享到dResList
		if(scope_list.contains(1)||scope_list.contains(2)){
			//批量增加资源
			logger.debug("add districtRes to database batch .....");
			districtMapper.insertList(dResList);
			for (DistrictsResNav nav : dResNavList) {
				logger.debug("add districtResNav to database .....");
				districtResNavMapper.insertWithoutSyscourseId(nav);
			}
		}
		
		
		
		//最后拷贝文件
		ZhlResourceCenterWrap.copyFile(resServiceLocal, source_4_copy, target_4_copy);


	}




	@Override
	public void delAsset(String resIds) {
		if(StringUtils.isNotEmpty(resIds)){
			String[]ids = resIds.split(",");
			for (String id : ids) {
				
				ZAsset  z = new ZAsset();
				z.setId(Long.parseLong(id));
				z.setFlag(true);
				
				assetMapper.updateByPrimaryKeySelective(z);
			}
		}
	}




	@Override
	public void updateAsset(ZAsset asset,String tfcode,Integer scope, String resServiceLocal, String currentResPath, String hostLocal) throws Exception {
		Date time = Calendar.getInstance().getTime();
		ZAsset _history = assetMapper.selectByPrimaryKey(asset.getId());
		
		asset.setIslocal(_history.getIslocal());
		asset.setUpdatetime(time);
		//获取资源、判断是否路径出现变化
		//0：转码完成，1：未完成
		int isfinished = 1 ;		
		ZAsset temp = assetMapper.selectByPrimaryKey(asset.getId());
		if(!temp.getAssetpath().equals(asset.getAssetpath())){
			
			//如果更新了文件且需要格式转换
			if(AssetTypeConvertConstant.isNeedConvert(asset.getAssetpath())){
				//检测是否已经完成格式转换
				ZTypeConvert obj =  convertMapper.getConvertRecord(asset.getUserid(), asset.getAssetpath());				
				if(null == obj){
					isfinished = 1 ;	
				}else{
					isfinished = 0 ;
				}				
			}else{
				isfinished = 0 ;
			}
			asset.setIsfinished(isfinished);
		}else{
			isfinished = 0 ;
		}

		
		if(scope>0){
			List<String> source_4_copy = new ArrayList<String>();
			List<String> target_4_copy = new ArrayList<String>();
			long schoolid = 0 ;
			long districtid=  0;
			HashMap<String,Object> map =  userMapper.getUserAreaInfo(asset.getUserid());
			if(map!=null){
				districtid =  (map.get("districtid") instanceof java.lang.String )
								?Long.parseLong(map.get("districtid").toString())
								:Long.parseLong(String.valueOf(map.get("districtid")));
				schoolid = (map.get("schoolid") instanceof java.lang.String )
						?Long.parseLong(map.get("schoolid").toString())
						:Long.parseLong(String.valueOf(map.get("schoolid")));
			}	
			
			//区本资源表中的  资源范围 1全国资源 2省资源 3市资源 4区资源 5校资源
			int _scope = scope==1?5:4;
			long _scopeId = _scope==5?schoolid:districtid;
			
			String assetPath =asset.getAssetpath();
			//组装区本、校本路径
			assetPath =  assetPath.replaceAll("\\\\", "/");
			//注意网络资源的处理
			String _name = asset.getIslocal() ==1 ?"":assetPath.substring(assetPath.lastIndexOf("/")+1,assetPath.length());
			//注意网络资源的处理
			String _path = asset.getIslocal() ==1 ?assetPath:AssetTypeConvertConstant.getAreaPathPrefix(scope, schoolid, districtid, tfcode);

			String _fullpath = _path+_name;
			
			
			
			String rescode = AssetTypeConvertConstant.getResCodeForDistrictRes(scope, tfcode);
			//复制到区本校本资源
			DistrictRes res = new DistrictRes();
			
			res.setAssetid(asset.getId());
			res.setScope(_scope);
			res.setScopeid(_scopeId);
			res.setFromflag(scope==1?3:4);
			res.setRescode(rescode);
			res.setCreatedt(time);
			//作者
			res.setAuthorid(asset.getUserid());
			res.setFname(_name);
			res.setFpath(_path);
			res.setFullpath(_fullpath);
			
			//创建者（后台管理员）
			res.setCreatorid(0l);
			res.setDes(asset.getAssetdesc());
			res.setMtype(asset.getUnifytypeid());
			res.setTitle(asset.getName());
			res.setKeyword(asset.getKeyword());	
			res.setRdes("");
			
			res.setTypelean("");
			res.setAuditopinion("");
			res.setAuthorfromflag(1);
			res.setAuthorunit("");
			res.setClicktimes(0);
			res.setCopyright("");
			res.setDisplayindex(0);
			res.setDisplaylevel(0);
			res.setDloadscore(0);
			res.setDloadtimes(0);
			res.setEditorid(0l);
			res.setEduplace("");
			//后缀
			String  fileext =assetPath.substring(assetPath.lastIndexOf(".") + 1, assetPath.length());
			res.setFileext(asset.getIslocal()==0?fileext:"html");
			res.setFlag(false);
			res.setFsize(asset.getAssetsize());
			res.setIsdwj(asset.getIswjb());
			res.setIsfinished(isfinished);
			//区本资源中的网络资源islocal为0，上传资源为1
			res.setIslocal(1-asset.getIslocal());
			res.setSuitterm("");
			res.setSctimes(0);
			//待审核
			res.setState(4);
			res.setCopyright("");
			res.setAuthorfromflag(1);
			
			res.setUploadscore(0);
			res.setUpdatedt(time);
			
			
			
			DistrictsResNav resNav = new DistrictsResNav();
			resNav.setFlag(false);
			resNav.setRescode(rescode);
			resNav.setStructcode(tfcode);				
			
			
			
			if(isfinished == 0 && asset.getIslocal() ==0 ){
				
				//格式转换完成，拷贝缩略图
				source_4_copy.add(assetPath.substring(0, assetPath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);
				target_4_copy.add(_fullpath.substring(0, _fullpath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE);
				if( AssetTypeConvertConstant.isNeedConvert(asset.getAssetpath())){
					//格式转换完成，拷贝转换后的文件
					source_4_copy.add(AssetTypeConvertConstant.convertType(assetPath));
					target_4_copy.add(AssetTypeConvertConstant.convertType(_fullpath));
				}
			}
			
			
			XShareResNav shareResNav = new XShareResNav();
			shareResNav.setCodetype(0);
			shareResNav.setFlag(false);
			shareResNav.setResid(asset.getId());
			shareResNav.setStructcode(tfcode);

			XPlatFormShare fShare = new XPlatFormShare(); 
			fShare.setClicks(0);
			fShare.setCreatetime(time);
			fShare.setDownloads(0);
			fShare.setFlag(false);
			fShare.setQuotes(0);
			fShare.setScope(1==scope?"D":"C");
			fShare.setScopeid(1==scope?schoolid:districtid);
			fShare.setSharedtype(1);
			fShare.setShareid(asset.getId());
			fShare.setStudycourseid("");
			fShare.setSysresourcetype(new Long(asset.getUnifytypeid()));
			fShare.setUserid(asset.getUserid());				
			
			shareResnavMapper.insert(shareResNav);
			shareMapper.insert(fShare);	
			districtMapper.insert(res);
			districtResNavMapper.insert(resNav);
			
			//复制（源文件）到目标目录
			source_4_copy.add(assetPath);
			target_4_copy.add(_fullpath);
			ZhlResourceCenterWrap.copyFile(resServiceLocal, source_4_copy, target_4_copy);
		}
		assetMapper.updateByPrimaryKeySelective(asset);
		//修改自建资源的关联目录节点
		asMapper.updateAssetSyscourse(asset.getId().toString(), tfcode, String.valueOf(scope));
	}




	@Override
	public Pagination queryMyAssets(Long userId, Long unifyTypeId,
			String fileFormat, Integer page, Integer perPage,String hostLocal,String resServiceLocal) {
		PageHelper.startPage(page, perPage);
		List<ZAssetView> list  = assetMapper.queryMyAssets(userId, unifyTypeId, fileFormat);
		
		//格式转换检查
		for (ZAssetView view : list) {

			//(需要转换的)是否已经完成格式转换  0：转码完成，1：未完成
			int isFinished = view.getIsFinished() ;
			if(1== isFinished){					
				//是否需要转格式，否 直接更新状态，是  创建转换任务
				if(AssetTypeConvertConstant.isNeedConvert(view.getImgPath())){
					
					//检测是否已经完成格式转换
					ZTypeConvert obj =  convertMapper.getConvertRecord(userId, view.getImgPath());				
					if(null == obj){
						//检测是否存在转换完成后的文件
						String path  = AssetTypeConvertConstant.convertType(view.getImgPath());
	                    // 判断是否存在
	                    String s = ZhlResourceCenterWrap.GetFileInfo(resServiceLocal, path);
	                    if (StringUtils.isNotEmpty(s)) {
	                        HashMap m = JSONObject.parseObject(s, HashMap.class);
	                        if (m != null && ((Integer) m.get("FileSize") > 0)) {
	                            
	                        	isFinished = 0 ;
	                        }
	                    } 
	                    
	                    if(1==isFinished){
	                    	ZhlResourceCenterWrap.sendFileToConvert(view.getImgPath(),userId, hostLocal, resServiceLocal);	
	                    }
						
					}else{
						isFinished = 0 ;
					}
				}else{
					isFinished =  0 ;
					
				}
				if(isFinished==0){
					view.setIsFinished(isFinished);
					ZAsset z = new ZAsset();
					z.setId(view.getResId());
					z.setIsfinished(isFinished);
					assetMapper.updateByPrimaryKeySelective(z);
				}
			}
		}
		
		Pagination p = new PageInfoToPagination().transfer(list);		
		return p ;
	}




	@Override
	public List<FirstLevelResType> getResTypeForPersonalTab(String tabCode,
			Long userId) {
		//myPrepareRes,myUpload,myDownload,myView。不传递该参数时默认为myPrepareRes
		tabCode = tabCode==null?"myPrepareRes":tabCode.trim();
		List<FirstLevelResType>  list = null;
		if("myPrepareRes".equals(tabCode)){
			list =  assetMapper.getResTypeForMyPrepareRes(userId);
		} else		
		if("myUpload".equals(tabCode)){
			list =  assetMapper.getResTypeForMyUpload(userId);
		}else
		if("myDownload".equals(tabCode)){
			list =  assetMapper.getResTypeForMyDownload(userId);
		}else
		if("myView".equals(tabCode)){
			list =  assetMapper.getResTypeForMyView(userId);
		}
		
		if(null == list){
			list =  new ArrayList<FirstLevelResType>();
		}
		
		FirstLevelResType e  = new FirstLevelResType();
		e.setId(0l);
		e.setCode("all");
		e.setMtype("全部");
		list.add(0, e);		
		return list;
	}


    /**
     * 分页获取我的资源评论
     * @param userId
     * @param reviewType
     * @param page
     * @param perPage
     * @return
     */
	@Override
	public Pagination getMyReviewComment(Long userId, Integer reviewType,Integer page,Integer perPage) {
		PageHelper.startPage(page, perPage);
		List<ResourceReview> list  = reviewMapper.getMyReviewComment(userId, reviewType);
		Pagination p = new PageInfoToPagination().transfer(list);
		return p ;
	}
	
	/**
	 * 批量复制    自建资源
	 * @param resIds
	 * @param tfcode
	 */
	@Override
	public void patchCopyAsset(List<Long> resIds,String tfcode){
		if(resIds != null || resIds.size() > 0)
			for(int i = 0; i < resIds.size();i++){
				long resId = resIds.get(i);
				assetMapper.copyAsset(resId, tfcode);
			}
	}
	
	/**
	 * 批量剪切    自建资源
	 * @param resIds
	 * @param tfcode 要剪切到的目标tfcode
	 */
	@Override
	public void patchCutAsset(List<Long> resIds,String tfcode,String des_tfcode){
		if(resIds != null && resIds.size() > 0)
			for(int i = 0; i < resIds.size();i++){
				long resId = resIds.get(i);
				
				//首先，将该资源从原来课程目录结点下删除
				while(true){ //同步
					assetMapper.delAsset(resId,tfcode);
					break;
				}
				
				//然后，复制资源到目标课程目录
				assetMapper.copyAsset(resId, des_tfcode);
			}
	}




	@Override
	public Pagination getUnReview(Long userId, Integer page, Integer perPage) {

		
		
		PageHelper.startPage(page, perPage);
		List<HashMap<String, Object>> list = reviewMapper.getUnReviewedRes(userId);
		
		
		List<Long> sysList = new ArrayList<Long>();//所有的系统资源
		List<Long> disList = new ArrayList<Long>();//所有的区本、校本资源
		
		List<ResourceReview> result = null ;
		if(list!=null){
			for (int i = 0; i < list.size(); i++) {
				HashMap<String, Object> hashMap = list.get(i);
				long _id = (Long)hashMap.get("contid");
				int _conttype = (Integer)hashMap.get("conttype");
				if(_conttype==2||_conttype==10){
					sysList.add(_id);
				}else if(_conttype==11 ||_conttype==12){
					disList.add(_id);
				}
			}
			result = reviewMapper.getUnReviewedResPager(userId, sysList, disList);
		}
		
		
		Pagination pa = new PageInfoToPagination().transfer(list);
		pa.setList(result);
		return pa;
	}
	
	/**
	 * 批量删除    自建资源
	 * @param resIds
	 * @param tfcode
	 */
	@Override
	public void patchDelAsset(List<Long> resIds,String tfcode){
		if(resIds != null && resIds.size() > 0)
			for(int i = 0; i < resIds.size();i++){
				long resId = resIds.get(i);
				
				//删除一条资源
				assetMapper.delAsset(resId,tfcode);
			}
	}




	@Override
	public ZAssetEditInfo getEditInfo(Long id) {
		// TODO Auto-generated method stub
		ZAssetEditInfo info = assetMapper.getEditInfo(id);
		
		
		
		
		
		return info;
	}




	@Override
	public List<FirstLevelResType> getAllResType() {
		// TODO Auto-generated method stub
		return typeMapper.getAllResType();
	}




	@Override
	public List<FirstLevelResType> getTypeForExt(String ext)throws Exception {
		// TODO Auto-generated method stub
		if(StringUtils.isEmpty(ext) || (!ext.startsWith("."))){
			throw new ParamsException();
		}
		
		
		
		
		return relateTypeMapper.getTypeForExt(ext);
	}




	@Override
	public ResultJSON getCourseAssetUnifyType(boolean ifGetNet, Long userId, String tfcode,
			String title) {
		
		return ResultJSON.getSuccess(assetMapper.getCourseAssetUnifyType(ifGetNet, userId, tfcode+"%", "%"+title+"%"));
	}




	@Override
	public Pagination<JPrepareContentView> getCourseAssetPage(boolean ifGetNet, Integer unifyTypeId,Long userId, String tfcode,
			String title, Integer page, Integer perPage) {
		PageHelper.startPage(page, perPage);
		List<JPrepareContentView>  list = assetMapper.getCourseAssetPage(ifGetNet, unifyTypeId,userId, tfcode+"%", "%"+title+"%");
		return new PageInfoToPagination<JPrepareContentView>().transfer(list);
	}
	
	
	public static void main(String[] args) {
		String s = "123456.jpg";
		System.out.println(s.substring(0, s.lastIndexOf("."))+"_icon.jpg");
		
		
	}




	@Override
	public void updateAssetPath(String path, String newPath) {
		assetMapper.updateAssetPath(path, newPath);
	}
}

