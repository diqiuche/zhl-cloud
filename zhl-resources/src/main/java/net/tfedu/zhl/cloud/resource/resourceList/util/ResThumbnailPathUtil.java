package net.tfedu.zhl.cloud.resource.resourceList.util;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.resPreview.entity.ResPreviewInfo;
import net.tfedu.zhl.cloud.resource.resPreview.entity.ResRecommendationEntity;
import net.tfedu.zhl.cloud.resource.resSearch.entity.ResSearchResultEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.DisResourceEntity;
import net.tfedu.zhl.cloud.resource.resourceList.entity.SysResourceEntity;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;

import com.alibaba.fastjson.JSONObject;

/**
 * 系统资源、区本资源、校本资源、资源检索结果的缩略图路径获取
 * @author WeiCuicui
 *
 * @param <T>
 */
public class ResThumbnailPathUtil {

	/**
	 * 系统资源的缩略图
	 * 
	 * 将资源查询结果中的 thumbnailpath 转换成有效数据
	 * 注意网络资源的处理
	 * @param list 资源集合
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 */
	public static void convertToPurpos_sys(List<SysResourceEntity> list,String resUrlLocal,String currnetResUrl){

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				SysResourceEntity view = list.get(i);
				//获取全路径
				String thumbnailpath = view.getFullpath();
				// imgPath 以http开头 并且size 为0或空
				if(( thumbnailpath.startsWith("http") || thumbnailpath.startsWith("HTTP"))){
					//设置文件后缀  html
					view.setFileExt("html");
				} else {
					if(thumbnailpath.lastIndexOf(".") != -1){
						//设置文件后缀
						view.setFileExt(thumbnailpath.substring(thumbnailpath.lastIndexOf(".") + 1,thumbnailpath.length()));
						//组装缩略图路径(约定)
						thumbnailpath = thumbnailpath.substring(0, thumbnailpath.lastIndexOf(".")) + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
						
						//判断是否存在
						String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, thumbnailpath);
						if(StringUtils.isNotEmpty(s)){
							HashMap m = JSONObject.parseObject(s, HashMap.class);
							if(m != null && ((Integer)m.get("FileSize") > 0)){
								//获取缩略图的地址（内网）
								thumbnailpath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, thumbnailpath);
								//替换
								thumbnailpath = thumbnailpath.replace(resUrlLocal, currnetResUrl);
								view.setThumbnailpath(thumbnailpath);
								
							}
						} else {
							view.setThumbnailpath("");
						}
					}
				}
			}
		}		
	}
	
	/**
	 * 校本、区本资源的缩略图
	 * 
	 * 将资源查询结果中的 thumbnailpath 转换成有效数据
	 * 注意网络资源的处理
	 * @param list 资源集合
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 */
	public static void convertToPurpos_dis(List<DisResourceEntity> list,String resUrlLocal,String currnetResUrl){

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				DisResourceEntity view = list.get(i);
				//获取全路径
				String thumbnailpath = view.getFullpath();
				// imgPath 以http开头 并且size 为0或空
				if(( thumbnailpath.startsWith("http") || thumbnailpath.startsWith("HTTP"))){
					//设置文件后缀  html
					view.setFileExt("html");
				} else {
					if(thumbnailpath.lastIndexOf(".") != -1){
						//设置文件后缀
						view.setFileExt(thumbnailpath.substring(thumbnailpath.lastIndexOf(".") + 1,thumbnailpath.length()));
						//组装缩略图路径(约定)
						thumbnailpath = thumbnailpath.substring(0, thumbnailpath.lastIndexOf(".")) + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
						
						//判断是否存在
						String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, thumbnailpath);
						if(StringUtils.isNotEmpty(s)){
							HashMap m = JSONObject.parseObject(s, HashMap.class);
							if(m != null && ((Integer)m.get("FileSize") > 0)){
								//获取缩略图的地址（内网）
								thumbnailpath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, thumbnailpath);
								//替换
								thumbnailpath = thumbnailpath.replace(resUrlLocal, currnetResUrl);
								view.setThumbnailpath(thumbnailpath);
								
							}
						} else {
							view.setThumbnailpath("");
						}
					}
				}
			}
		}		
	}
	
	/**
	 * 资源检索结果的缩略图
	 * 
	 * 将资源查询结果中的 thumbnailpath 转换成有效数据
	 * 注意网络资源的处理
	 * @param list 资源集合
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 */
	public static void convertToPurpos_resSearch(List<ResSearchResultEntity> list, String resUrlLocal,String currnetResUrl){

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				
				ResSearchResultEntity view = list.get(i);
				
				//获取全路径
				String thumbnailpath = view.getFullpath();
				
				// imgPath 以http开头 并且size 为0或空
				if(( thumbnailpath.startsWith("http") || thumbnailpath.startsWith("HTTP"))){
					//设置文件后缀  html
					view.setFileExt("html");
				} else {
					if(thumbnailpath.lastIndexOf(".") != -1){
						//设置文件后缀
						view.setFileExt(thumbnailpath.substring(thumbnailpath.lastIndexOf(".") + 1,thumbnailpath.length()));
						//组装缩略图路径(约定)
						thumbnailpath = thumbnailpath.substring(0, thumbnailpath.lastIndexOf(".")) + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
						
						//判断是否存在
						String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, thumbnailpath);
						if(StringUtils.isNotEmpty(s)){
							HashMap m = JSONObject.parseObject(s, HashMap.class);
							if(m != null && ((Integer)m.get("FileSize") > 0)){
								//获取缩略图的地址（内网）
								thumbnailpath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, thumbnailpath);
								//替换
								thumbnailpath = thumbnailpath.replace(resUrlLocal, currnetResUrl);
								view.setThumbnailpath(thumbnailpath);
								
							}
						} else {
							view.setThumbnailpath("");
						}
					}
					
				}
			}
		}		
	}
	
	/**
	 * 预览页面资源推荐列表的缩略图
	 * 
	 * 将资源查询结果中的 thumbnailpath 转换成有效数据
	 * 注意网络资源的处理
	 * @param list 资源集合
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 */
	public static void convertToPurpos_recommendation(List<ResRecommendationEntity> list, String resUrlLocal,String currnetResUrl){

		if(list != null && list.size() > 0){
			for (int i = 0; i < list.size(); i++) {
				
				ResRecommendationEntity view = list.get(i);
				
				//获取全路径
				String thumbnailpath = view.getFullPath();
				
				// imgPath 以http开头 并且size 为0或空
				if(( thumbnailpath.startsWith("http") || thumbnailpath.startsWith("HTTP"))){
					//设置文件后缀  html
					view.setFileExt("html");
				} else {
					
					if(thumbnailpath.lastIndexOf(".") != -1){
						//设置文件后缀
						view.setFileExt(thumbnailpath.substring(thumbnailpath.lastIndexOf(".") + 1,thumbnailpath.length()));
						//组装缩略图路径(约定)
						thumbnailpath = thumbnailpath.substring(0, thumbnailpath.lastIndexOf(".")) + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
						
						//判断是否存在
						String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, thumbnailpath);
						if(StringUtils.isNotEmpty(s)){
							HashMap m = JSONObject.parseObject(s, HashMap.class);
							if(m != null && ((Integer)m.get("FileSize") > 0)){
								//获取缩略图的地址（内网）
								thumbnailpath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, thumbnailpath);
								//替换
								thumbnailpath = thumbnailpath.replace(resUrlLocal, currnetResUrl);
								view.setThumbnailpath(thumbnailpath);
								
							}
						} else {
							view.setThumbnailpath("");
						}
					}
				}
			}
		}		
	}
	
	/**
	 * 预览一条详细资源，生成缩略图
	 * 
	 * 将资源查询结果中的 thumbnailpath 转换成有效数据
	 * 注意网络资源的处理
	 * @param list 资源集合
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 */
	public static void convertToPurpos_resPreview(ResPreviewInfo info, String resUrlLocal,String currnetResUrl){

		if(info != null){
			
			//获取全路径
			String thumbnailpath = info.getFpath();
			
			// imgPath 以http开头 并且size 为0或空
			if(( thumbnailpath.startsWith("http") || thumbnailpath.startsWith("HTTP"))){
				//设置文件后缀  html
				info.setFileExt("html");
			} else {
				if(thumbnailpath.lastIndexOf(".") != -1){
					//设置文件后缀
					info.setFileExt(thumbnailpath.substring(thumbnailpath.lastIndexOf(".") + 1,thumbnailpath.length()));
					//组装缩略图路径(约定)
					thumbnailpath = thumbnailpath.substring(0, thumbnailpath.lastIndexOf(".")) + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
					
					//判断是否存在
					String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, thumbnailpath);
					if(StringUtils.isNotEmpty(s)){
						HashMap m = JSONObject.parseObject(s, HashMap.class);
						if(m != null && ((Integer)m.get("FileSize") > 0)){
							//获取缩略图的地址（内网）
							thumbnailpath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, thumbnailpath);
							//替换
							thumbnailpath = thumbnailpath.replace(resUrlLocal, currnetResUrl);
							info.setFpath(thumbnailpath);
							
						}
					} else {
						info.setFpath("");
					}
				}
			}
		}		
	}

}
