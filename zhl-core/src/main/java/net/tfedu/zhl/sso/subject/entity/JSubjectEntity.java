package net.tfedu.zhl.sso.subject.entity;

import java.io.Serializable;

public class JSubjectEntity implements Serializable{

	private static final long serialVersionUID = -4154529847915546034L;
	
	private Long subj_id;
	private String subj_name;
	public Long getSubj_id() {
		return subj_id;
	}
	public void setSubj_id(Long subj_id) {
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
