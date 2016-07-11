package net.tfedu.zhl.cloud.resource.navigation.service.impl;

import java.util.HashMap;

import javax.annotation.Resource;

import net.tfedu.zhl.cloud.resource.navigation.dao.JUserDefaultMapper;
import net.tfedu.zhl.cloud.resource.navigation.entity.JUserDefault;
import net.tfedu.zhl.cloud.resource.navigation.service.UserDefaultService;

import org.springframework.stereotype.Service;

/**
 * 查询、增加、更新用户历史选择的学段、学科、版本、教材 的service
 * 
 * @author WeiCuicui
 *
 */
@Service("userDefaultService")
public class UserDefaultServiceImpl implements UserDefaultService {

    @Resource
    JUserDefaultMapper jUserDefaultMapper;

    /**
     *  查询用户历史选择的学段、学科、版本、教材
     */
    @Override
    public JUserDefault getUserHistoryDefault(long userId,int type) {
    	
    	HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("type", type);
        return jUserDefaultMapper.getUserHistoryDefault(map);
    }

    /**
     *  增加 或 修改 用户历史选择
     * @param map
     */
    @Override
    public void updateUserHistoryDefault(long userId,String tfcode,int type) {
    	
    	// 封装参数
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        map.put("type", type);
        map.put("tfcode", tfcode);
        
        HashMap<String, Object> map1 = new HashMap<String, Object>();
        map1.put("userId", userId);
        map1.put("type", type);
        
        JUserDefault userDefault = jUserDefaultMapper.getUserHistoryDefault(map1);
        
        if(userDefault == null){//若之前没有历史结点记录，则新增一条历史记录
        	jUserDefaultMapper.addUserHistoryDefault(map);
        } else { //更新历史记录
        	jUserDefaultMapper.updateUserHistoryDefault(map);
		}
    }
}