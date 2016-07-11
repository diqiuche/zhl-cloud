package net.tfedu.zhl.cloud.resource.navigation.entity;

import org.apache.ibatis.annotations.Param;



/**
 * 题库接口知识点的属性
 * @author wangwr
 *
 */
public class KonwladgeViewTk {
	
	String know_id;
	String know_name;
	String know_code;
	
	String term_id;
	
	String subj_id; 
	
	
	public String getKnow_id() {
		return know_id;
	}
	public void setKnow_id(String know_id) {
		this.know_id = know_id;
	}
	public String getKnow_name() {
		return know_name;
	}
	public void setKnow_name(String know_name) {
		this.know_name = know_name;
	}
	public String getKnow_code() {
		return know_code;
	}
	public void setKnow_code(String know_code) {
		this.know_code = know_code;
	}
	public String getTerm_id() {
		return term_id;
	}
	public void setTerm_id(String term_id) {
		this.term_id = term_id;
	}
	public String getSubj_id() {
		return subj_id;
	}
	public void setSubj_id(String subj_id) {
		this.subj_id = subj_id;
	}
	
	
	
	

}
