package net.tfedu.zhl.cloud.resource.customizeres.dao;

import java.util.List;

import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetView;
import net.tfedu.zhl.cloud.resource.customizeres.entity.CustomizeRes;
import net.tfedu.zhl.cloud.resource.customizeres.entity.CustomizeResResult;
import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.subject.entity.JSubject;

public interface CustomizeResMapper extends CoreMapper<CustomizeRes> {
	
	
	/**
	 * 获取全部的学科
	 * @return
	 */
	public List<JSubject> getAllSubject();
	
	/**
	 * 获取全部的定制资源
	 */
	public List<ZAssetView> getCustomizeResResult(String subjectCode);
	
	
	
	
	
}