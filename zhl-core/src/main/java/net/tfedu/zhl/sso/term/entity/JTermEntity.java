package net.tfedu.zhl.sso.term.entity;

import java.io.Serializable;

public class JTermEntity implements Serializable {

	private static final long serialVersionUID = -4154529847915546034L;
	
	private Long term_id;
	private String term_name;
	public Long getTerm_id() {
		return term_id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public void setTerm_id(Long term_id) {
		this.term_id = term_id;
	}
	public String getTerm_name() {
		return term_name;
	}
	public void setTerm_name(String term_name) {
		this.term_name = term_name;
	}
	
}
