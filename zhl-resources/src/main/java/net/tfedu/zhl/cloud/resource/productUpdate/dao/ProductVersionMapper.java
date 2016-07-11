package net.tfedu.zhl.cloud.resource.productUpdate.dao;

import net.tfedu.zhl.cloud.resource.productUpdate.entity.ProductVersion;
import net.tfedu.zhl.helper.CoreMapper;

import org.apache.ibatis.annotations.Param;

public interface ProductVersionMapper extends CoreMapper<ProductVersion> {
	
	/**
	 * 根据产品code，版本code，产品类型，查询最新版本信息
	 * @param productCode  产品code
	 * @param versionCode  版本code
	 * @param productType  产品类型
	 * @return
	 */
	public ProductVersion latestVersionInfoByCode(@Param("productCode")String productCode,@Param("versionCode")long versionCode,@Param("productType")int productType);
	
	/**
	 * 根据产品编码，版本名称，产品类型，查询最新版本信息
	 * @param productName  产品名称
	 * @param versionCode  版本code
	 * @param productType  产品类型
	 * @return
	 */
	public ProductVersion latestVersionInfoByName(@Param("productCode")String productCode,@Param("versionName")String versionName,@Param("productType")int productType);
}