package net.tfedu.zhl.cloud.resource.asset.dao;

import net.tfedu.zhl.cloud.resource.asset.entity.ZAssetSyscourse;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface ZAssetSyscourseMapper extends CoreMapper<ZAssetSyscourse> {
	
	/**
	 * 根据resId，查询所在的第一个课程结点
	 * @return
	 */
	public String getFirstCourseByResId(@Param("resId")long resId);
	
	
	
	/**
	 * 获取自建的共享范围
	 * @param userId
	 * @param assetPath
	 * @return 1 校本   2  区本
	 */
	public Integer getAssetShareScope(@Param("userId")String userId,@Param("assetPath")String assetPath);
	
	
	
	
	
	/**
	 * 修改资源的目录节点
	 * @param resId
	 * @param tfcode
	 * @param scope
	 */
	public void updateAssetSyscourse(@Param("resId")String resId,@Param("tfcode")String tfcode,@Param("scope")String scope);
	
	
	
}