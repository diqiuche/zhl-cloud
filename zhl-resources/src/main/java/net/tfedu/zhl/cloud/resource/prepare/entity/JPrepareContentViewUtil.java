package net.tfedu.zhl.cloud.resource.prepare.entity;

import java.util.HashMap;
import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.entity.CourseWareView;
import net.tfedu.zhl.cloud.resource.asset.entity.ResourceReview;
import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetView;
import net.tfedu.zhl.cloud.resource.userlog.entity.ResourceViewLog;
import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;

import com.alibaba.fastjson.JSONObject;

/**
 * 工具类 mapper 中获取的 JPrepareContentView 中的 imagePath,fileSuffix 都不是最终的有效的数据
 * 在此工具类中处理，生成有效数据， 其中 imagePath的值 实为 资源主文件的 （数据库中的相对全）路径
 * 
 * @author wangwr
 *
 */
public class JPrepareContentViewUtil {

    /**
     * 将 JPrepareContentView 转换生成有效数据 注意网络资源的处理
     * 
     * @param <T>
     * @param list
     * @param resUrlLocal
     *            文件服务器的内网地址
     * @param currnetResUrl
     *            浏览器上的当前的（可用内、外网文件服务器）地址
     */
    public static void convertToPurpose(List<JPrepareContentView> list, String resUrlLocal, String currnetResUrl) {

        // JPrepareContentView ResourceReview ResourceViewLog

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {

                JPrepareContentView view = list.get(i);
                String imgPath = view.getImgPath();
                String size = view.getSize();
                String fpath = view.getFpath();
                if(StringUtils.isEmpty(fpath)){//
                	fpath = imgPath;
                	view.setFpath(fpath);
                }
                
                
                // imgPath 以http开头 并且size 为0或空
                if ((StringUtils.isEmpty(size) || "0".equals(size))
                        && (imgPath.startsWith("http") || imgPath.startsWith("HTTP"))) {
                    // 设置文件后缀 html
                    view.setFileSuffix("html");
                } else {
                    // 设置文件后缀
					if(imgPath.lastIndexOf(".")>0){
						//设置文件后缀
						view.setFileSuffix(imgPath.substring(imgPath.lastIndexOf(".")+1,imgPath.length()));
						 // 组装缩略图路径(约定)
	                    imgPath = imgPath.substring(0, imgPath.lastIndexOf("."))
	                            + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
	                    // 判断是否存在
	                    String s = ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, imgPath);
	                    if (StringUtils.isNotEmpty(s)) {
	                        HashMap m = JSONObject.parseObject(s, HashMap.class);
	                        if (m != null && ((Integer) m.get("FileSize") > 0)) {
	                            // 获取缩略图的地址（内网）
	                            imgPath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, imgPath);
	                            // 替换
	                            imgPath = imgPath.replace(resUrlLocal, currnetResUrl);
	                            view.setImgPath(imgPath);

	                        }
	                    } else {
	                        view.setImgPath("");
	                    }
					}
                }
            }
        }
    }

    /**
     * 将 ResourceReview (资源评论记录) 中的imagePath 转换生成有效数据 注意网络资源的处理
     * 
     * @param list
     * @param resUrlLocal
     *            文件服务器的内网地址
     * @param currnetResUrl
     *            浏览器上的当前的（可用内、外网文件服务器）地址
     */
    public static void convertToPurpose_Review(List<ResourceReview> list, String resUrlLocal, String currnetResUrl) {

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ResourceReview view = list.get(i);
                String imgPath = view.getImgPath();
                // imgPath 以http开头 并且size 为0或空
                if ((imgPath.startsWith("http") || imgPath.startsWith("HTTP"))) {
                    // 设置文件后缀 html
                    view.setFileSuffix("html");
                } else {
                    // 设置文件后缀
					if(imgPath.lastIndexOf(".")>0){
						//设置文件后缀
						view.setFileSuffix(imgPath.substring(imgPath.lastIndexOf(".")+1,imgPath.length()));
	                    // 组装缩略图路径(约定)
	                    imgPath = imgPath.substring(0, imgPath.lastIndexOf("."))
	                            + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;

	                    // 判断是否存在
	                    String s = ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, imgPath);
	                    if (StringUtils.isNotEmpty(s)) {
	                        HashMap m = JSONObject.parseObject(s, HashMap.class);
	                        if (m != null && ((Integer) m.get("FileSize") > 0)) {
	                            // 获取缩略图的地址（内网）
	                            imgPath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, imgPath);
	                            // 替换
	                            imgPath = imgPath.replace(resUrlLocal, currnetResUrl);
	                            view.setImgPath(imgPath);

	                        }
	                    } else {
	                        view.setImgPath("");
	                    }
	                }

                }
            }
        }
    }

    /**
     * 将 ResourceReview (资源评论记录) 中的imagePath 转换生成有效数据 注意网络资源的处理
     * 
     * @param list
     * @param resUrlLocal
     *            文件服务器的内网地址
     * @param currnetResUrl
     *            浏览器上的当前的（可用内、外网文件服务器）地址
     */
    public static void convertToPurpose_view(List<ResourceViewLog> list, String resUrlLocal, String currnetResUrl) {

        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                ResourceViewLog view = list.get(i);
                String imgPath = view.getImgPath();
                // imgPath 以http开头 并且size 为0或空
                if ((imgPath.startsWith("http") || imgPath.startsWith("HTTP"))) {
                    // 设置文件后缀 html
                    view.setFileSuffix("html");
                } else {
                    // 设置文件后缀
					if(imgPath.lastIndexOf(".")>0){
						//设置文件后缀
						view.setFileSuffix(imgPath.substring(imgPath.lastIndexOf(".")+1,imgPath.length()));
	                    // 组装缩略图路径(约定)
	                    imgPath = imgPath.substring(0, imgPath.lastIndexOf("."))
	                            + ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;

	                    // 判断是否存在
	                    String s = ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, imgPath);
	                    if (StringUtils.isNotEmpty(s)) {
	                        HashMap m = JSONObject.parseObject(s, HashMap.class);
	                        if (m != null && ((Integer) m.get("FileSize") > 0)) {
	                            // 获取缩略图的地址（内网）
	                            imgPath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, imgPath);
	                            // 替换
	                            imgPath = imgPath.replace(resUrlLocal, currnetResUrl);
	                            view.setImgPath(imgPath);

	                        }
	                    } else {
	                        view.setImgPath("");
	                    }
					
					}

                }
            }
        }
    }
	
    /**
	 * 将 ResourceReview (资源评论记录) 中的imagePath 转换生成有效数据
	 * ,并对未完成转换的资源重新处理
	 * 
	 * 
	 * 
	 * 注意网络资源的处理
	 * @param list
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 * 
	 * 
	 * 
	 */
	public static void convertToPurpose_Asset(List<ZAssetView> list,String resUrlLocal,String currnetResUrl){
		
		
		
		if(list!=null && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				ZAssetView view = list.get(i);
				String imgPath = view.getImgPath();
				if(imgPath==null){
					continue;
				}
				
				
				
				// imgPath 以http开头 并且size 为0或空
				if(( imgPath.startsWith("http")|| imgPath.startsWith("HTTP"))){
					//设置文件后缀  html
					view.setFileSuffix("html");
				}else{
					if(imgPath.lastIndexOf(".")>0){
						//设置文件后缀
						view.setFileSuffix(imgPath.substring(imgPath.lastIndexOf(".")+1,imgPath.length()));
						//组装缩略图路径(约定)
						imgPath = imgPath.substring(0, imgPath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
						
						//判断是否存在
						String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, imgPath);
						if(StringUtils.isNotEmpty(s)){
							HashMap m = JSONObject.parseObject(s, HashMap.class);
							if(m!=null && ((Integer)m.get("FileSize")>0)){
								//获取缩略图的地址（内网）
								imgPath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, imgPath);
								//替换
								imgPath = imgPath.replace(resUrlLocal, currnetResUrl);
								view.setImgPath(imgPath);
								
							}
						}else{
							view.setImgPath("");
						}
					}

				}
				
			}
		}		
	}
	/**
	 * 将 ResourceReview (资源评论记录) 中的imagePath 转换生成有效数据
	 * 注意网络资源的处理
	 * @param list
	 * @param resUrlLocal  文件服务器的内网地址
	 * @param currnetResUrl    浏览器上的当前的（可用内、外网文件服务器）地址
	 */
	public static void convertToPurpose_CourseWare(List<CourseWareView> list,String resUrlLocal,String currnetResUrl){
		
		if(list!=null && list.size()>0){
			for (int i = 0; i < list.size(); i++) {
				CourseWareView view = list.get(i);
				String imgPath = view.getImgPath();
				// imgPath 以http开头 并且size 为0或空
				if(( imgPath.startsWith("http")|| imgPath.startsWith("HTTP"))){
					//设置文件后缀  html
					view.setFileSuffix("html");
				}else{
					//设置文件后缀
					view.setFileSuffix(imgPath.substring(imgPath.lastIndexOf(".")+1,imgPath.length()));
					
					if(imgPath.lastIndexOf(".")>0){
						//组装缩略图路径(约定)
						imgPath = imgPath.substring(0, imgPath.lastIndexOf("."))+ZhlResourceCenterWrap.THUMBNAILS_IMG_TYPE;
						
						//判断是否存在
						String s =  ZhlResourceCenterWrap.GetFileInfo(resUrlLocal, imgPath);
						if(StringUtils.isNotEmpty(s)){
							HashMap m = JSONObject.parseObject(s, HashMap.class);
							if(m!=null && ((Integer)m.get("FileSize")>0)){
								//获取缩略图的地址（内网）
								imgPath = ZhlResourceCenterWrap.getWebThumbnail(resUrlLocal, imgPath);
								//替换
								imgPath = imgPath.replace(resUrlLocal, currnetResUrl);
								view.setImgPath(imgPath);
								
							}
						}else{
							view.setImgPath("");
						}						
					}
				}
			}
		}		
	}
}