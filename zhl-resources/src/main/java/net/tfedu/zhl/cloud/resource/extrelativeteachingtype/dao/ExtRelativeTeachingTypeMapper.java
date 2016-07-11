package net.tfedu.zhl.cloud.resource.extrelativeteachingtype.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.cloud.resource.extrelativeteachingtype.entity.ExtRelativeTeachingType;
import net.tfedu.zhl.cloud.resource.poolTypeFormat.entity.FirstLevelResType;
import net.tfedu.zhl.helper.CoreMapper;

public interface ExtRelativeTeachingTypeMapper extends CoreMapper<ExtRelativeTeachingType> {

	
	/**
	 *  根据文件的后缀获取资源类型
	 * @param ext
	 * @return
	 */
	public List<FirstLevelResType> getTypeForExt(@Param("ext")String ext);
	

}