package net.tfedu.zhl.sso.user.dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.user.entity.JUser;
import net.tfedu.zhl.sso.user.entity.JUserTeachingQueryEntity;
import net.tfedu.zhl.sso.user.entity.UserSimple;
import net.tfedu.zhl.sso.user.entity.UsersEntity;

/**
 * 用户业务表
 * 
 * @author wangwr
 *
 */
public interface JUserMapper extends CoreMapper<JUser> {

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
	public UserSimple getUserSimpleById(long id);

	/**
	 * 根据name获取用户
	 * 
	 * @param id
	 * @return
	 */
	public UserSimple getUserSimpleByName(String name);

	/**
	 * 修改用户头像信息
	 * 
	 * @param userId
	 * @param userImage用户头像的相对路径
	 */
	public void updateUserImage(Long userId, String userImage);

	/**
	 * 获取用户地区信息
	 * 
	 * @return
	 */
	public HashMap<String, Object> getUserAreaInfo(Long userId);

	/**
	 * 获取用户地区信息
	 * 
	 * @return
	 */
	public HashMap<String, String> getUserTermAndSubject(Long userId);

	/**
	 * 题库对接，根据name查询所有用户信息
	 * 
	 * @param userName
	 * @return
	 */
	public List<UsersEntity> queryUserBasicInfo(@Param("userName") String userName);

	/**
	 * 根据userId查询用户的truename
	 * 
	 * @param userId
	 * @return
	 */
	public String getTrueNameById(@Param("userId") long userId);

	/**
	 * 根据角色、姓名分页获取用户列表(教研平台使用)
	 * 
	 * @param roleId
	 * @param name
	 * @param model
	 * @return
	 * @throws Exception
	 */
	public List<JUserTeachingQueryEntity> queryUserWithRoleAndName(@Param("roleId") long roleId,
			@Param("name") String name, @Param("model") String model) throws Exception;

}