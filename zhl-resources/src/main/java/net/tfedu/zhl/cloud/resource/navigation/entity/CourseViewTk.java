package net.tfedu.zhl.cloud.resource.navigation.entity;


/**
 * 题库接口 教材目录的显示字段 
 * @author wangwr
 *
 */
public class CourseViewTk  {
	String cour_id;
	
	String cour_name;
	
	String cour_tf_code;
	String cour_pid;

	public String getCour_pid() {
		return cour_pid;
	}

	public void setCour_pid(String cour_pid) {
		this.cour_pid = cour_pid;
	}

	public String getCour_id() {
		return cour_id;
	}

	public void setCour_id(String cour_id) {
		this.cour_id = cour_id;
	}

	public String getCour_name() {
		return cour_name;
	}

	public void setCour_name(String cour_name) {
		this.cour_name = cour_name;
	}

	public String getCour_tf_code() {
		return cour_tf_code;
	}

	public void setCour_tf_code(String cour_tf_code) {
		this.cour_tf_code = cour_tf_code;
	}
	
	
	

}
