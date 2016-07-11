package net.tfedu.zhl.sso.user.service;

import java.util.HashMap;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.user.entity.JUser;
import net.tfedu.zhl.sso.user.entity.UserSimple;

/**
 * 用户相关接口
 * 
 * @author wangwr
 *
 */
public interface UserService {

    /**
     * 根据id获取用户
     * 
     * @param id
     * @return
     */
    public JUser getUserById(long id);

    /**
     * 根据name获取用户
     * 
     * @param id
     * @return
     */
    public JUser getUserByName(String name);

    /**
     * 根据id获取用户
     * 
     * @param id
     * @return
     */
    public UserSimple getUserSimpleById(long id, String model,boolean isRepeatLogin);
    /**
     * 根据id获取用户
     * 
     * @param id
     * @return
     */
    public UserSimple getUserSimpleById(long id, String model);

    /**
     * 根据name获取用户
     * 
     * @param id
     * @return
     */
    public UserSimple getUserSimpleByName(String name);

    /**
     * 修改用户的信息
     * 
     * @param userId
     * @param trueName
     * @param male
     * @param termId
     * @param subjectId
     */
    public void updateUserInfo(Long userId, String trueName, Boolean male, Long termId, Long subjectId);

    /**
     * 修改用户头像
     * 
     * @param userId
     * @param userImage
     */
    public void updateUserImage(Long userId, String userImage);

    /**
     * 登出
     * @param token
     */
    void logout(String token,boolean isRepeatLogin);
    
    

	/**
	 * 获取用户地区信息
	 * @return
	 */
	public HashMap<String,String> getUserTermAndSubject(Long userId);
	
	
	/**
	 * 根据角色、姓名分页获取用户列表(教研平台使用)
	 * @param roleId
	 * @param name
	 * @param model
	 * @param page
	 * @param perPage
	 * @return
	 * @throws Exception
	 */
	public ResultJSON queryUserWithRoleAndName(long roleId,String name,String model,int page,int perPage) throws Exception;
	
	

}
