package net.tfedu.zhl.sso.city.entity;

import java.io.Serializable;

public class CityEntity implements Serializable{
	
	private static final long serialVersionUID = -4154529847915546034L;

	private int city_id;
	private String city_name;
	public int getCity_id() {
		return city_id;
	}
	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}
	public String getCity_name() {
		return city_name;
	}
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}
}
