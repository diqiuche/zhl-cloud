package net.tfedu.zhl.sso.school.entity;

import java.io.Serializable;

public class JSchoolEntity implements Serializable{

	private static final long serialVersionUID = -4154529847915546034L;
	
	private Long sch_id;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private String sch_name;
}
