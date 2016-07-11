package net.tfedu.zhl.cloud.demo.dao;

import java.util.List;
import java.util.Map;

import net.tfedu.zhl.cloud.demo.entity.Country;
import net.tfedu.zhl.helper.CoreMapper;

/**
 * xxx实体类
 * 
 * @author bruce
 *
 */
public interface CountryMapper extends CoreMapper<Country> {
    /**
     * 自由查询，万能的map，最佳伙伴是lambda
     * 
     * @return List<Map<?,?>>
     */
    List<Map<?, ?>> queryMaps();

    /**
     * 根据单个属性查询
     * 
     * @return List<Long>
     */
    List<Long> queryIds();

}
