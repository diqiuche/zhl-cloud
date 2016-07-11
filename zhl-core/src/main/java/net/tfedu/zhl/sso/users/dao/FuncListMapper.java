package net.tfedu.zhl.sso.users.dao;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.users.entity.FuncList;

/**
 * 权限资源类
 * @author bruce
 *
 */
public interface FuncListMapper extends CoreMapper<FuncList> {
    /**
     * 根据角色编号查询用户权限
     * @param roleIds
     * @param model
     * @return
     */
    Set<String> getRoleFuncByRoleIds(@Param("roleIds") Set<Long> roleIds, @Param("model")String model);
}