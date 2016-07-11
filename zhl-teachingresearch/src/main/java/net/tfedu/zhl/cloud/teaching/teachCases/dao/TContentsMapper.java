package net.tfedu.zhl.cloud.teaching.teachCases.dao;

import java.util.List;

import net.tfedu.zhl.cloud.teaching.teachCases.entity.TContents;
import net.tfedu.zhl.helper.CoreMapper;

public interface TContentsMapper extends CoreMapper<TContents> {
	
	/**
	 * 查询所有的内容类型
	 * @return
	 */
	public List<TContents> getAllContentTypes();
}