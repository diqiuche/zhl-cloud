package net.tfedu.zhl.cloud.resource.prepare.util;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.util.AssetTypeConvertConstant;
import net.tfedu.zhl.cloud.resource.prepare.entity.ResourceSimpleInfo;
import net.tfedu.zhl.fileservice.HttpUtil;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;

import com.alibaba.fastjson.JSONObject;

/**
 * （资源中心）备课夹 常量
 * 
 * @author wangwr
 *
 */
public class JPrepareConstant {
	
	
	
	
	/**
	 * 日志类型： 自建资源
	 */
	public static final String LOGTYPE_ASSET = "asset";
	
	
	/**
	 * 日志类型： 自建资源
	 */
	public static final String LOGTYPE_RESOURCE = "resource";
	
	/**
	 * 日志类型： 共享资源
	 */
	public static final String LOGTYPE_SHARE_RES = "sharedres";
	

	/**
	 * 日志类型： 区本资源
	 */
	public static final String LOGTYPE_DISTRICT_RES = "districtres";
	
	/**
	 * 日志类型： 校本资源
	 */
	public static final String LOGTYPE_SCHOOL_RES = "schoolres";
	
	
	 /**
     * 将fromFlag转换成 备课夹中的conttype 1自建资源，2共享资源,3校本资源,4区本资源
     * 
     * @param conttype
     * @return
     */
    public static String getLogTypeByFromflag(Integer fromFlag) {
    	 switch (fromFlag) {
         case fromFlag_sysRes:
             return LOGTYPE_RESOURCE;
         case fromFlag_localRes:
             return LOGTYPE_ASSET;
         case fromFlag_sharedRes:
             return LOGTYPE_SHARE_RES;
         case fromFlag_schoolRes:
             return LOGTYPE_SCHOOL_RES;
         case fromFlag_districtRes:
             return LOGTYPE_DISTRICT_RES;
         default:
             return null;
         }
    }
	
	
    /**
     * 本地资源
     */
    public static final int CONTTYPE_LOCALRES_OLD = 1;
    /**
     * 系统资源
     */
    public static final int CONTTYPE_SYSRES_OLD = 2;

    /**
     * 本地资源
     */
    public static final int CONTTYPE_LOCALRES = 9;
    /**
     * 系统资源
     */
    public static final int CONTTYPE_SYSRES = 10;

    /**
     * 区本资源
     */
    public static final int CONTTYPE_DISTRICT_RES = 11;

    /**
     * 校本资源
     */
    public static final int CONTTYPE_SCHOOL_RES = 12;

    /**
     * 系统资源的来源表示
     */
    public static final int fromFlag_sysRes = 0;
    /**
     * 自建资源的来源表示
     */
    public static final int fromFlag_localRes = 1;

    /**
     * 共享资源的来源表示
     */
    public static final int fromFlag_sharedRes = 2;

    /**
     * 校本资源的来源表示
     */
    public static final int fromFlag_schoolRes = 3;

    /**
     * 区本资源的来源表示
     */
    public static final int fromFlag_districtRes = 4;

    /**
     * 将fromFlag转换成 备课夹中的conttype 0系统资源，1自建资源，2共享资源,3校本资源,4区本资源
     * 
     * @param fromFlag
     * @return
     */
    public static Integer getContTypeByFromFlag(Integer fromFlag) {
        switch (fromFlag) {
        case fromFlag_sysRes:
            return CONTTYPE_SYSRES;
        case fromFlag_localRes:
            return CONTTYPE_LOCALRES;
        case fromFlag_sharedRes:
            return CONTTYPE_LOCALRES;
        case fromFlag_schoolRes:
            return CONTTYPE_SCHOOL_RES;
        case fromFlag_districtRes:
            return CONTTYPE_DISTRICT_RES;
        default:
            return null;
        }
    }

    /**
     * 将fromFlag转换成 备课夹中的conttype 1自建资源，2共享资源,3校本资源,4区本资源
     * 
     * @param conttype
     * @return
     */
    public static Integer getFromFlagByContType(Integer conttype) {
        switch (conttype) {
        case CONTTYPE_SYSRES:
        case CONTTYPE_SYSRES_OLD:
            return fromFlag_sysRes;

        case CONTTYPE_LOCALRES:
        case CONTTYPE_LOCALRES_OLD:
            return fromFlag_localRes;

        case CONTTYPE_SCHOOL_RES:
            return fromFlag_schoolRes;
        case CONTTYPE_DISTRICT_RES:

            return fromFlag_districtRes;
        default:
            return null;
        }
    }

    /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的播放路径
     * 
     * @param list
     */
    public static void resetResourceViewUrl(List<ResourceSimpleInfo> list, String resServiceLocal,
            String currentResService,Boolean isEprepare) {

    	
    	for (ResourceSimpleInfo resourceSimpleInfo : list) {
    		if(null == resourceSimpleInfo){
    			continue;
    		}
            resetResourceViewUrl(resourceSimpleInfo, resServiceLocal, currentResService,isEprepare);
		}
    	

    }

    /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的相对路径 加密文件为exe的相对路径
     * 
     * @param list
     */
    public static void resetResourceDownLoadForZip(List<ResourceSimpleInfo> list, String resServiceLocal) {
        for (int i = 0; i < list.size(); i++) {
            resetResourceDownLoadForZip(list.get(i), resServiceLocal);
        }
    }
    
    
    

    /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的播放路径
     * 
     * 自建资源、区本、校本 播放原文件或转码后的文件
     * 
     * 资源来源0系统资源，1自建资源，2共享资源,3校本资源,4区本资源 
     * @param info
     */
    public static void resetResourceViewUrl(ResourceSimpleInfo info, String resServiceLocal, String currentResService,Boolean isEprepare) {

        String rescode = info.getRescode();
        //资源来源0系统资源，1自建资源，2共享资源,3校本资源,4区本资源 
        Integer fromflag = info.getFromflag();
        Boolean isnet = info.getIsnet();
        Boolean isdwj = info.getIsdwj();
        String path = info.getPath();
        Boolean isebook = info.getIsebook();
        
        
        if(!isnet){
    		String flag = path.substring(path.lastIndexOf("."),path.length());
    	      
            //如果是系统资源 
            if(0==fromflag){
            	
            	if(isebook){
            			
            	}
            	
        		//文本文件的处理
        		else if(ZhlResourceCenterWrap.file_pattern_pdf.indexOf(flag)>=0){
        			//转码文件的处理
        			path = path.substring(0,path.lastIndexOf("."))+".pdf";
        		}
        		
            	
            }else{
            	//自建资源、区本、校本 播放原文件或转码后的文件
            	if(AssetTypeConvertConstant.isNeedConvert(path)	){
            		path = AssetTypeConvertConstant.convertType(path);
            	}
            }
            
    		if(isebook){
    	        path = isEprepare
    	        		?ZhlResourceCenterWrap.GetEBookPlayerURL_EPREPARE(path, resServiceLocal)
    	        		:ZhlResourceCenterWrap.GetEBookPlayerURL(path, resServiceLocal);
    		}else{
    	        path = 
    	        		isEprepare
    	        		?ZhlResourceCenterWrap.getWebPlayUrl_EPREPARE(resServiceLocal, path, isdwj)
    	        		:ZhlResourceCenterWrap.getWebPlayUrl(resServiceLocal, path, isdwj);
    		}
            

            path = path.replace(resServiceLocal, currentResService);

            info.setPath(path);        	
        }
        

    }
    
    
	/**
 * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的下载路径
 * 用于打包下载
 * @param info
 */
public static void resetResourceDownLoadForZip(ResourceSimpleInfo info,String resServiceLocal){
    String rescode = info.getRescode();
    Integer fromflag= info.getFromflag();		
    Boolean isnet = info.getIsnet();	    
    Boolean isdwj= info.getIsdwj();	    
    String path = info.getPath();

    //如果是系统资源 
    if(fromflag==fromFlag_sysRes){
		String flag = path.substring(path.lastIndexOf("."),path.length());
		
		
		//如果是加密swf\mp4的文件
		if(ZhlResourceCenterWrap.FileType_EXE.equals(flag) 
        		|| ZhlResourceCenterWrap.FileType_encrypt.indexOf(flag)>=0){
			String  url = "";
			if(isdwj){
				String _path =  path.replaceAll("\\\\", "/");
				String _name = _path.substring(_path.lastIndexOf("/")+1,_path.length());
				_path = _path.substring(0,_path.lastIndexOf("/"));
				url = ZhlResourceCenterWrap.InvokeExePackageTaskURL(_name,_path, resServiceLocal);
			}else{
				url = ZhlResourceCenterWrap.InvokeExePackageTaskURL(path, "", resServiceLocal);
			}
			//获取exe文件的路径
			String result =  HttpUtil.PostHttpWebRequest(url);
			HashMap obj =  JSONObject.parseObject(result, HashMap.class);
			path = (String)obj.get("filename");
		}else{
			if(isdwj){
				path = path.substring(0, path.indexOf(rescode))+File.separator+rescode+".zip";
			}
		}
    }
	
    
    //重新赋值path
    info.setPath(path);
	
}

    /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的下载路径 用于打包下载
     * 
     * @param info
     * @param currentResService 
     * @throws UnsupportedEncodingException 
     */
    public static void resetResourceDownLoadUrlWeb(ResourceSimpleInfo info, String resServiceLocal, String currentResService) throws UnsupportedEncodingException {
        String rescode = info.getRescode();
        Integer fromflag = info.getFromflag();
        Boolean isnet = info.getIsnet();
        Boolean isdwj = info.getIsdwj();
        String path = info.getPath();
        String title = info.getTitle();
        String fileext = info.getFileext();

        // 如果是系统资源
        if (fromflag == fromFlag_sysRes) {
            String flag = path.substring(path.lastIndexOf("."), path.length());

            // 如果是加密swf\mp4的文件
            if (ZhlResourceCenterWrap.FileType_EXE.equals(fileext) 
            		||
            		ZhlResourceCenterWrap.FileType_encrypt.indexOf(flag) >= 0) {
                String url = "";
                if (isdwj) {
                    String _path = path.replaceAll("\\\\", "/");
                    String _name = _path.substring(_path.lastIndexOf("/") + 1, _path.length());
                    _path = _path.substring(0, _path.lastIndexOf("/"));
                    url = ZhlResourceCenterWrap.InvokeExePackageTaskURL(_name, _path, resServiceLocal);
                    path = ZhlResourceCenterWrap.GetExePackageURL(resServiceLocal, _name, _path);
                } else {
                	path = ZhlResourceCenterWrap.GetExePackageURL(resServiceLocal, path, "");
                }
            } else {
                if (isdwj) {
                    path = path.substring(0, path.indexOf(rescode)) + File.separator + rescode + ".zip";
                }
                
                path = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, path);
            }
        }else{
        	path = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, path);
        }
        
		//增加title,支持下载文件的重命名
		if(title!=null && !"".equals(title.trim())){
			path +=   (path.indexOf("?")>0?"&":"?")+ "title="+URLEncoder.encode(title, "utf-8");
		}
		path = path.replace(resServiceLocal, currentResService);
        // 重新赋值path
        info.setPath(path);

    }

    /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的下载路径 
     * @param info
     * @throws UnsupportedEncodingException 
     */
	public static void resetResourceDownLoadURLWeb(List<ResourceSimpleInfo> list,
			String resServiceLocal, String currentResService) throws UnsupportedEncodingException {
		for (int i = 0; i < list.size(); i++) {
			resetResourceDownLoadUrlWeb(list.get(i), resServiceLocal,currentResService);
        }

	}
	 /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的下载路径 用于客户端下载
     * @param info
     */
	public static void resetResourceDownLoadURLForEPrepareClient(List<ResourceSimpleInfo> list,
			String resServiceLocal, String currentResService) {
		for (int i = 0; i < list.size(); i++) {
			resetResourceDownLoadURLForEPrepareClient(list.get(i), resServiceLocal,currentResService);
        }

	}
	  /**
     * 将 ResourceSimpleInfo 中的path（主文件路径） 切换为 资源的下载路径 用于客户端下载
     * 
     * @param info
     * @param currentResService 
     */
    public static void resetResourceDownLoadURLForEPrepareClient(ResourceSimpleInfo info, String resServiceLocal, String currentResService) {
        String rescode = info.getRescode();
        Integer fromflag = info.getFromflag();
        Boolean isnet = info.getIsnet();
        Boolean isdwj = info.getIsdwj();
        String path = info.getPath();

        // 如果是系统资源
        if (fromflag == fromFlag_sysRes) {
            String flag = path.substring(path.lastIndexOf("."), path.length());

            if (isdwj) {
                path = path.substring(0, path.indexOf(rescode)) + File.separator + rescode + ".zip";
                path = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, path);
            }else  if (ZhlResourceCenterWrap.FileType_encrypt.indexOf(flag) >= 0) {
                // 如果是加密swf\mp4的文件
            	path = path.replace(".swf", ".tfswf").replace(".mp4", ".tfmp4");
            	path = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, path);
            } else {
                path = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, path);
            }
        }else{
        	path = ZhlResourceCenterWrap.getDownUrl(resServiceLocal, path);
        }
        
		path = path.replace(resServiceLocal, currentResService);
        // 重新赋值path
        info.setPath(path);

    }
    
}