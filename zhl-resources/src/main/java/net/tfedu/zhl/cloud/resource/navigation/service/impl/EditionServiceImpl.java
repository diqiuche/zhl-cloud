package net.tfedu.zhl.cloud.resource.navigation.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.dao.JSyscourseMapper;
import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;
import net.tfedu.zhl.cloud.resource.navigation.service.EditionService;

import org.springframework.stereotype.Service;

/**
 * 根据学段、学科，查询所有版本
 * 
 * @author WeiCuicui
 *
 */
@Service("editionService")
public class EditionServiceImpl implements EditionService {

    @Resource
    JSyscourseMapper jSyscourseMapper;

    /**
     *  根据学段、学科，查询所有版本
     */
    @Override
    public List<JSyscourse> getAllEditionsByTermAndSub(long termId,long subjectId) {
    	HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("termId", termId);
        map.put("subjectId", subjectId);
        return jSyscourseMapper.getAllEditions(map);
    }

}
