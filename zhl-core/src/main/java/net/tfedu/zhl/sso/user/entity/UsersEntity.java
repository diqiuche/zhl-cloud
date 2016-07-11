package net.tfedu.zhl.sso.user.entity;

import java.io.Serializable;

/**
 * 题库对接，根据user_name查询用户信息的entity
 * @author WeiCuicui
 *
 */
public class UsersEntity implements Serializable {
	 private static final long serialVersionUID = -4154529847915546034L;
	 
	 private Long user_id;

	 private String user_name;
	 
	 private String user_true_name;
	 
	 private String user_image;
	 
	 private Long sch_id;
	 
	 /**
      * 用户学校
      */
     private String sch_name;
     
     private Long dist_id;
	 
	 /**
      * 用户学校
      */
     private String dist_name;
	 
	 /**
      * 用户学段
      */
     private String term_name;

     private Long term_id;

    
     /**
      * 用户学科id
      */
     private String subj_id;

     /**
      * 用户学科名
      */
     private String subj_name;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_true_name() {
		return user_true_name;
	}

	public void setUser_true_name(String user_true_name) {
		this.user_true_name = user_true_name;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}

	public Long getSch_id() {
		return sch_id;
	}

	public void setSch_id(Long sch_id) {
		this.sch_id = sch_id;
	}

	public String getSch_name() {
		return sch_name;
	}

	public void setSch_name(String sch_name) {
		this.sch_name = sch_name;
	}

	public Long getDist_id() {
		return dist_id;
	}

	public void setDist_id(Long dist_id) {
		this.dist_id = dist_id;
	}

	public String getDist_name() {
		return dist_name;
	}

	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}

	public String getTerm_name() {
		return term_name;
	}

	public void setTerm_name(String term_name) {
		this.term_name = term_name;
	}

	public Long getTerm_id() {
		return term_id;
	}

	public void setTerm_id(Long term_id) {
		this.term_id = term_id;
	}

	public String getSubj_id() {
		return subj_id;
	}

	public void setSubj_id(String subj_id) {
		this.subj_id = subj_id;
	}

	public String getSubj_name() {
		return subj_name;
	}

	public void setSubj_name(String subj_name) {
		this.subj_name = subj_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
