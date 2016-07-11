package net.tfedu.zhl.sso.role.service;

import net.tfedu.zhl.core.service.BaseService;
import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.role.entity.JRole;

public interface RoleService extends BaseService<JRole> {
	
	
	
	/**
	 * 查询（教研角色管理的）角色
	 * @return
	 */
	public  ResultJSON queryRoleForTeachingResearch() throws Exception;
	
	
	
	/**
	 * 为增加角色
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public ResultJSON  addUserRole(long userId,long roleId)throws Exception;
	
	

	/**
	 * 为增加角色
	 * @param userId
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	public ResultJSON  addUserRole(long[] userIds,long roleId)throws Exception;
	
	
	

}
