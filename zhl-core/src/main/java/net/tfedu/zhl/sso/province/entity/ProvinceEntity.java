package net.tfedu.zhl.sso.province.entity;

import java.io.Serializable;

public class ProvinceEntity implements Serializable{

	private static final long serialVersionUID = -4154529847915546034L;
	
	private Long pro_id;
	private String pro_name;
	public Long getPro_id() {
		return pro_id;
	}
	public void setPro_id(Long pro_id) {
		this.pro_id = pro_id;
	}
	public String getPro_name() {
		return pro_name;
	}
	public void setPro_name(String pro_name) {
		this.pro_name = pro_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
