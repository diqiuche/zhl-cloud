package net.tfedu.zhl.cloud.resource.navigation.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.dao.JSyscourseMapper;
import net.tfedu.zhl.cloud.resource.navigation.entity.JSyscourse;
import net.tfedu.zhl.cloud.resource.navigation.service.BookService;

import org.springframework.stereotype.Service;

/**
 * 获取教材
 * @author WeiCuicui
 *
 */
@Service("bookService")
public class BookServiceImpl implements BookService {

    @Resource
    JSyscourseMapper jSyscourseMapper;

    /**
     *  获得所有教材信息
     */
    @Override
    public List<JSyscourse> getAllBooks(long pnodeId, String proCode) {

        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("pnodeId", pnodeId);
        map.put("proCode", proCode);
        // 根据所属版本和产品编码，查询所有的教材
        return jSyscourseMapper.getAllBooks(map);
    }
}
