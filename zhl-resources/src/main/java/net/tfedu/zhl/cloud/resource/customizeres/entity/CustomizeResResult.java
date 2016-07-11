package net.tfedu.zhl.cloud.resource.customizeres.entity;

import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetView;
import net.tfedu.zhl.sso.subject.entity.JSubject;

/**
 * 返回全部的推荐、定制资源
 * @author wangwr
 *
 */
public class CustomizeResResult {

	
	
	/**
	 * 学科
	 */
	public JSubject subject ; 
	
	
	/**
	 * 学科下的(定制)资源
	 * 
	 * ZAssetView  只是指明需要展示的内容，并不是指 其为自建资源
	 * 
	 */
	public List<ZAssetView> list ;


	public JSubject getSubject() {
		return subject;
	}


	public void setSubject(JSubject subject) {
		this.subject = subject;
	}


	public List<ZAssetView> getList() {
		return list;
	}


	public void setList(List<ZAssetView> list) {
		this.list = list;
	} 
	
	
	
	
	
}
