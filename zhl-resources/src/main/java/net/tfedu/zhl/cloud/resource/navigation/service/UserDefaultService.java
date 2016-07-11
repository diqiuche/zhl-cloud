package net.tfedu.zhl.cloud.resource.navigation.service;

import net.tfedu.zhl.cloud.resource.navigation.entity.JUserDefault;

/**
 * 查询、增加、更新用户历史选择的学段、学科、版本、教材
 * 
 * @author WeiCuicui
 *
 */
public interface UserDefaultService {

    /**
     *  查询用户历史选择的学段、学科、版本、教材
     * @param map
     * @return
     */
    public JUserDefault getUserHistoryDefault(long userId,int type);

    /**
     *  增加或修改用户历史选择
     * @param map
     */
    public void updateUserHistoryDefault(long userId,String tfcode,int type);

}
