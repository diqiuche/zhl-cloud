package net.tfedu.zhl.cloud.resource.navigation.dao;

import java.util.HashMap;

import net.tfedu.zhl.cloud.resource.navigation.entity.JUserDefault;
import net.tfedu.zhl.helper.CoreMapper;

/**
 * 查询、增加、更新用户历史选择的学段、学科、版本、教材
 * 
 * @author WeiCuicui
 *
 */
public interface JUserDefaultMapper extends CoreMapper<JUserDefault> {

    /**
     *  查询用户历史选择的学段、学科、版本、教材
     * @param map
     * @return
     */
    public JUserDefault getUserHistoryDefault(HashMap<String, Object> map);

    /**
     *  增加用户历史选择
     * @param map
     */
    public void addUserHistoryDefault(HashMap<String, Object> map);

    /**
     *  更新用户历史选择
     * @param map
     */
    public void updateUserHistoryDefault(HashMap<String, Object> map);

}