package net.tfedu.zhl.cloud.resource.asset.util;

import java.io.File;
import java.util.Calendar;
import java.util.UUID;


/**
 * 格式转换相关常量
 * @author wangwr
 *
 */
public class AssetTypeConvertConstant {
	//这些扩展名替换为.pdf
	private static final String doctypes = ".doc .docx .ppt .pptx .xls .xlsx ";
	
	//这些扩展名替换为.mp4
	private static final String shipin = ".wmv .avi .flv .mp4 ";
	
	//这些扩展名替换为.mp3
	private static final String yinpin = ".wav .wma .m4a .mp3  ";

	//扩展名mp3
	public static final String mp3 = ".mp3";

	//扩展名mp4
	public static final String mp4 = ".mp4";

	
	
	
	//对现有类型进行扩展名替换
	public static String convertType(String tempPath){
		
		int index = tempPath.lastIndexOf(".");
	    String type = tempPath.substring(index + 1, tempPath.length());
	    
	    //若当前文件属于需要转码的文本类型
	    if(doctypes.indexOf(type) >= 0)
	    	tempPath = tempPath.replace(type, "pdf");
	    
	    //若当前文件属于需要转码的视频类
	    else if(shipin.indexOf(type) >= 0){
	    	tempPath =  tempPath.replace(type, "mp4");
	    	
	    //若当前文件属于需要转码的音频类
		}else if(yinpin.indexOf(type) >= 0){
			tempPath = tempPath.replace(type, "mp3");
		}
	    
	    return tempPath;
		   
	}
	
	/**
	 * 根据上传的资源类型，判断是否需要转码
	 * @param tempPath
	 * @return
	 * @throws Exception
	 */
	public static boolean isNeedConvert(String tempPath){
		
		int index = tempPath.lastIndexOf(".");
	    String type = tempPath.substring(index + 1, tempPath.length());
	    
	    //若当前文件类型需要转码
	    if(doctypes.indexOf(type) >= 0 || shipin.indexOf(type) >= 0 || yinpin.indexOf(type) >= 0)
	    	return true;
	    else 
			return false;
	}
	
	
	
	/**
	 * 
	 * @param scope  共享范围   0 个人可见 1 校本共享 2 区本共享
	 * @param schoolid
	 * @param districtid
	 * @param tfcode
	 * @return
	 */
	public static String getAreaPathPrefix(int scope,long schoolid,long districtid,String tfcode){
		String path = "";
		int year = Calendar.getInstance().get(Calendar.YEAR);
		switch(scope){
		case  1:
			path = new StringBuffer().append("SchoolBase").append(File.separator)
			.append(schoolid).append(File.separator)
			.append(year).append(File.separator)
			.append(tfcode.substring(2, 4)).append(File.separator)
			.append(tfcode.substring(4, 8)).append(File.separator)
			.toString();
			
			break;
		case  2: 
			path = new StringBuffer().append("AreaBase").append(File.separator)
			.append(districtid).append(File.separator)
			.append(year).append(File.separator)
			.append(tfcode.substring(2, 4)).append(File.separator)
			.append(tfcode.substring(4, 8)).append(File.separator)
			.toString();
			break;
		}
		return path ;
	}
	

	
	public static String getResCodeForDistrictRes(int scope,String tfcode){
		
		String resCode = "";
		switch(scope){
		case  1:
			resCode = new StringBuffer().append("SC")
			.append(tfcode.substring(2, 4)).append(File.separator)
			.append(tfcode.substring(4, 8)).append(File.separator)
			.append(UUID.randomUUID().toString())
			.toString();
			
			break;
		case  2: 
			resCode = new StringBuffer().append("AR")
			.append(tfcode.substring(2, 4)).append(File.separator)
			.append(tfcode.substring(4, 8)).append(File.separator)
			.append(UUID.randomUUID().toString())
			.toString();
			break;
		}
		return resCode ;
		
	}
	
	
	/*
	public static void main(String[] args) {
		String tfcode = "RJCZ01010101";
		long schoolid = 123;
		long districtid = 6666;
		
		
		
		
		System.out.println(getAreaPathPrefix(2, schoolid, districtid, tfcode));
		System.out.println(getAreaPathPrefix(1, schoolid, districtid, tfcode));
		
	}
	*/
	
	public static void main(String[] args) {
		String path = "upFile\\2016\\390410126\\10105\\2016070415531745742-31.mp4";
		path = path.replaceAll("\\\\", "\\\\\\\\");
		System.out.println(path);
	}
	
	
	
}
