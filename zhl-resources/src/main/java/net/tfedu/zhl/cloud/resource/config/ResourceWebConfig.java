package net.tfedu.zhl.cloud.resource.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 资源中心web端的配置项
 * @author WeiCuicui
 *
 */
@Component("resourceWebConfig")
public class ResourceWebConfig {

	/**
	 * 系统资源来源
	 */
	@Value("#{configProperties['sys_from']}")
	public String sys_from;
	
	/**
	 * 距离当前日期的天数，判断是否是最新文件
	 */
	@Value("#{configProperties['expire']}")
	public String expire ;
	
	/**
	 * 产品码
	 */
	@Value("#{configProperties['proCode']}")
	public String proCode ;
	
	
	/**
	 * 用户历史选择表的类型 
	 */
	@Value("#{configProperties['type']}")
	public String type ;
	
	/**
	 * e备课，需要排除的资源类型
	 */
	@Value("#{configProperties['removeTypeIds']}")
	public String removeTypeIds ;
	

	public String getSys_from() {
		return sys_from;
	}


	public void setSys_from(String sys_from) {
		this.sys_from = sys_from;
	}


	public String getExpire() {
		return expire;
	}


	public void setExpire(String expire) {
		this.expire = expire;
	}


	public String getProCode() {
		return proCode;
	}


	public void setProCode(String proCode) {
		this.proCode = proCode;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getRemoveTypeIds() {
		return removeTypeIds;
	}


	public void setRemoveTypeIds(String removeTypeIds) {
		this.removeTypeIds = removeTypeIds;
	}

	
	/**
	 * 获取系统资源来源
	 * @param request
	 * @return
	 */
	public List<Integer> getSys_from(HttpServletRequest request){
 
		List<Integer> sysFroms = new ArrayList<Integer>();
		if(sys_from != null){
			String[] froms = sys_from.trim().split(",");
			for(int i = 0; i < froms.length; i++)
				sysFroms.add(Integer.parseInt(froms[i].trim()));
		}
        return sysFroms;
	}
	
	/**
	 * e备课，需要排除的资源类型
	 * @param request
	 * @return
	 */
	public List<Integer> getRemoveTypes(HttpServletRequest request){
 
		List<Integer> removeTypes = new ArrayList<Integer>();
		if(removeTypeIds != null){
			String[] typeIds = removeTypeIds.trim().split(",");
			for(int i = 0; i < typeIds.length; i++)
				removeTypes.add(Integer.parseInt(typeIds[i].trim()));
		}
        return removeTypes;
	}

	/**
	 * 获取expire
	 * @param request
	 * @return
	 */
	public int getExpire(HttpServletRequest request){
 
		return Integer.parseInt(expire.trim());
       
	}
	
	/**
	 * 获取type
	 * @param request
	 * @return
	 */
	public int getType(HttpServletRequest request){
 
		return Integer.parseInt(type.trim());
       
	}
	
}
