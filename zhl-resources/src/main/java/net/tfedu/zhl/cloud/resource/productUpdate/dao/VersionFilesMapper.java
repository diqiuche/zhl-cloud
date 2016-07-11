package net.tfedu.zhl.cloud.resource.productUpdate.dao;

import java.util.List;

import net.tfedu.zhl.cloud.resource.productUpdate.entity.VersionFiles;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface VersionFilesMapper extends CoreMapper<VersionFiles> {
	
	/**
	 * 根据产品code，版本code，产品类型，查询当前版本后的所有升级文件
	 * @param productCode
	 * @param versionCode
	 * @param productType
	 * @return
	 */
	public List<VersionFiles> allUpdatedFilesByCode(@Param("productCode")String productCode,@Param("versionCode")long versionCode,@Param("productType")int productType);
	
	/**
	 * 根据产品code，版本name，产品类型，查询当前版本后的所有升级文件
	 */
	public List<VersionFiles> allUpdatedFilesByName(@Param("productCode")String productCode,@Param("versionName")String versionName,@Param("productType")int productType);
	
}
