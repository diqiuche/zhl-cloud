package net.tfedu.zhl.cloud.resource.bookself.bean;

import java.util.HashMap;
import java.util.List;

import com.alibaba.fastjson.JSONObject;

import net.tfedu.zhl.cloud.utils.datatype.StringUtils;
import net.tfedu.zhl.fileservice.ZhlResourceCenterWrap;

public class BookSelfImgPathConvert {
	
	/**
	 * 获取文件服务中的路径
	 * @param list
	 * @param resServiceLocal
	 * @param currentResPath
	 */
	public static void convert(List<BookSelfView> list,String resServiceLocal,String currentResPath){
		if(list!=null && list.size()>0){
			for (BookSelfView bookSelfView : list) {
				String imgPath = bookSelfView.getImgpath();
				if(StringUtils.isNotEmpty(imgPath)){
					System.out.println("-----"+imgPath);
					
					// 判断是否存在
                    String s = ZhlResourceCenterWrap.GetFileInfo(resServiceLocal, imgPath);
                    if (StringUtils.isNotEmpty(s)) {
                        HashMap m = JSONObject.parseObject(s, HashMap.class);
                        if (m != null && ((Integer) m.get("FileSize") > 0)) {
                            // 获取缩略图的地址（内网）
                            imgPath = ZhlResourceCenterWrap.getWebThumbnail(resServiceLocal, imgPath);
                            // 替换
                            imgPath = imgPath.replace(resServiceLocal, currentResPath);
                        }
                    } else {
                    	imgPath = "";
                    }
					bookSelfView.setImgpath(imgPath);
				}
				
			}			
		}
	}

}
