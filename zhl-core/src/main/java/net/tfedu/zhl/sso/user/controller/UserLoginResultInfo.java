package net.tfedu.zhl.sso.user.controller;

/**
 * 用户登录之后返回的接口信息
 * 
 * @author wangwr
 *
 */
public class UserLoginResultInfo {

    String userId;// 用户ID
    String userName;// 用户账号
    String token;// 登录成功返回的token，用于用户验证
    String trueName;// String 真实姓名
    long roleId;// 角色id

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

}
