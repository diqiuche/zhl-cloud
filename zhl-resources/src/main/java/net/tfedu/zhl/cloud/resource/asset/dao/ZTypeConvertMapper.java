package net.tfedu.zhl.cloud.resource.asset.dao;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.cloud.resource.asset.entity.ZTypeConvert;
import net.tfedu.zhl.helper.CoreMapper;

public interface ZTypeConvertMapper extends CoreMapper<ZTypeConvert> {
	
	
	
	/**
	 * 根据条件获取转换记录
	 * @param userId
	 * @param resPath
	 * @return
	 */
	public ZTypeConvert getConvertRecord(@Param("userId") Long userId,@Param("resPath") String resPath);
	
	
	

}