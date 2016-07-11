package net.tfedu.zhl.sso.users.dao;

import org.apache.ibatis.annotations.Param;

import net.tfedu.zhl.helper.CoreMapper;
import net.tfedu.zhl.sso.users.entity.SRegister;

/**
 * 注册表接口
 * 
 * @author wangwr
 *
 */
public interface SRegisterMapper extends CoreMapper<SRegister> {

    /**
     * 修改密码
     * 
     * @param pwd
     * @param id
     */
    public void modifyPassword(Long id, byte[] pwd);
    
    
    
    
    /**
     * 增加用户
     * @param register
     */
    public void addRegister(@Param("register")SRegister register);
    
    

}