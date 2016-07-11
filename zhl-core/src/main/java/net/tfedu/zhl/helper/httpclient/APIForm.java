package net.tfedu.zhl.helper.httpclient;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * 查询api的表单参数
 * @author wangwr
 *
 */
public class APIForm {

	/**
	 * url 非空
	 */
	String url ;
	
	/**
	 * 方法
	 */
	String http_method ;
	
	/**
	 * 参数 headers
	 */
	ArrayList<HashMap<String,String>> header_params =new ArrayList<HashMap<String,String>>();
	 
	
	/**
	 * 参数
	 */
	ArrayList<HashMap<String,String>> request_params =new ArrayList<HashMap<String,String>>();

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	

	public String getHttp_method() {
		return http_method;
	}

	public void setHttp_method(String http_method) {
		this.http_method = http_method;
	}

	public ArrayList<HashMap<String, String>> getHeader_params() {
		return header_params;
	}

	public void setHeader_params(ArrayList<HashMap<String, String>> header_params) {
		this.header_params = header_params;
	}

	public ArrayList<HashMap<String, String>> getRequest_params() {
		return request_params;
	}

	public void setRequest_params(ArrayList<HashMap<String, String>> request_params) {
		this.request_params = request_params;
	}
	
}
