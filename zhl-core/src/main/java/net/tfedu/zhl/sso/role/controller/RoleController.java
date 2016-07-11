package net.tfedu.zhl.sso.role.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.tfedu.zhl.helper.ResultJSON;
import net.tfedu.zhl.sso.role.service.RoleService;

/**
 * 角色管理、角色分配等
 * @author wangwr
 *
 */

@Controller
@RequestMapping("/*RestAPI")
public class RoleController {
	
	
	@Resource
	RoleService roleService;
	
	/**
	 *  查询（教研角色管理的）角色
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/v1.0/roles_teaching",method=RequestMethod.GET)
	@ResponseBody
	public ResultJSON  queryRolesForTeachingResearch()throws Exception{
		return  roleService.queryRoleForTeachingResearch();
	}
	
	
	
	/**
	 * 设置用户角色
	 * @param roleId
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value="/v1.0/userRole",method=RequestMethod.POST)
	@ResponseBody
	public ResultJSON  addUserRole(HttpServletRequest request,long roleId,long[] userIds)throws Exception{
		return roleService.addUserRole(userIds, roleId);
	}
	
	
	
	
	
	
	
	
	

}
