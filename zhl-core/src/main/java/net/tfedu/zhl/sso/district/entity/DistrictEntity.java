package net.tfedu.zhl.sso.district.entity;

import java.io.Serializable;

public class DistrictEntity implements Serializable{

	private static final long serialVersionUID = -4154529847915546034L;
	
	private int dist_id;
	private String dist_name;
	public int getDist_id() {
		return dist_id;
	}
	public void setDist_id(int dist_id) {
		this.dist_id = dist_id;
	}
	public String getDist_name() {
		return dist_name;
	}
	public void setDist_name(String dist_name) {
		this.dist_name = dist_name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
