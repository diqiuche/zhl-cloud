package net.tfedu.zhl.sso.user.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户信息简易版
 * 
 * @author wangwr
 *
 */
public class UserSimple implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4154529847915546034L;
    
    String userName;
    Long userId;
    String trueName;
    String roleName;
    String schoolName;
    String male;
    String termName;
    String userImage;
    Long roleId;
    String token;
    Date logintime;
    
    
    
    /**
     * 登录产品
     */
    String  model;
    
    /**
     * 获取用户学科ids
     */
    private String subjectIds;

    /**
     * 获取用户学科
     */
    private String subjectNames;
    
    /**
     * 用户附加角色
     */
    @Transient
    private Set<Long> roleIds;
    
    /**
     * 用户权限
     */
    private Set<String> funcPaths;

    public String getSubjectIds() {
        return subjectIds;
    }

    public void setSubjectIds(String subjectIds) {
        this.subjectIds = subjectIds;
    }

    public String getSubjectNames() {
        return subjectNames;
    }

    public void setSubjectNames(String subjectNames) {
        this.subjectNames = subjectNames;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getMale() {
        return male;
    }

    public void setMale(String male) {
        this.male = male;
    }

    public String getTermName() {
        return termName;
    }

    public void setTermName(String termName) {
        this.termName = termName;
    }

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getLogintime() {
        return logintime;
    }

    public void setLogintime(Date logintime) {
        this.logintime = logintime;
    }



    public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Set<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(Set<Long> roleIds) {
        this.roleIds = roleIds;
    }

    @JsonIgnore
    public Set<String> getFuncPaths() {
        return funcPaths;
    }

    public void setFuncPaths(Set<String> funcPaths) {
        this.funcPaths = funcPaths;
    }

    @Override
    public String toString() {
        return "UserSimple [userName=" + userName + ", userId=" + userId + ", trueName=" + trueName + ", roleName="
                + roleName + ", schoolName=" + schoolName + ", male=" + male + ", termName=" + termName + ", userImage="
                + userImage + ", roleId=" + roleId + ", token=" + token + ", logintime=" + logintime + ", model="
                + model + ", subjectIds=" + subjectIds + ", subjectNames=" + subjectNames + ", roleIds=" + roleIds
                + ", funcPaths=" + funcPaths + "]";
    }

    
}
