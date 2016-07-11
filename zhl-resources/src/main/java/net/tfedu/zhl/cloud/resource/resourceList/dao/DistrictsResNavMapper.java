package net.tfedu.zhl.cloud.resource.resourceList.dao;

import net.tfedu.zhl.cloud.resource.resourceList.entity.DistrictsResNav;
import net.tfedu.zhl.helper.CoreMapper;

public interface DistrictsResNavMapper extends CoreMapper<DistrictsResNav> {
	
	/**
	 * 插入区本资源导航（只有tfcode，没有syscourseid）
	 */
	public void insertWithoutSyscourseId(DistrictsResNav nav);
	
}