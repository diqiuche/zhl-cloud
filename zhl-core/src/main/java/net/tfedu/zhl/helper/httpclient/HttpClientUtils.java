package net.tfedu.zhl.helper.httpclient;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSONObject;

import net.tfedu.zhl.core.exception.APIErrorException;
import net.tfedu.zhl.core.exception.CustomException;



/**
 * http接口工具类
 * @author wangwr
 *
 */
public class HttpClientUtils {
	
	
	public static void main(String[] args) throws Exception {
		String json = "{\"CONSUMER_ID\":\"Default-69dee715b1d14f64adad1a4dd18a9564\",\"SERVICE_CODE\":\"zteict.proxy.user.LoginStatus\"}";
		String url = "http://edu.myjining.cn/serviceProxy/servlet/?json="+URLEncoder.encode(json, "utf-8");
		
		String result = doGET(url);

		System.out.println(result);
		
		
	}
	
	
	public static String doGET(String url) throws Exception{
		String result = null ;
		HttpClient client = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
	
		HttpResponse response=client.execute(get);

			String statusLine = response.getStatusLine().toString();
			if(statusLine.contains("200")){
				HttpEntity entity = response.getEntity();
				result = (EntityUtils.toString(entity, "utf-8"));	
			}else{
				throw new APIErrorException(statusLine);
			}
			return result ;
	}
	
	

	
	
	
	public static String doGet(APIForm form)
			throws ClientProtocolException, IOException, CustomException, URISyntaxException {

		String json = null;
		CloseableHttpClient client = HttpClients.createDefault();

		ArrayList<HashMap<String, String>> header_params = form.getHeader_params();

		ArrayList<HashMap<String, String>> request_params = form.getRequest_params();

		URIBuilder ub = new URIBuilder();
		ub.setPath(form.getUrl());

		ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();
		if (request_params != null && request_params.size() > 0) {
			for (HashMap<String, String> hashMap : request_params) {
				Set<Entry<String, String>> temp = hashMap.entrySet();
				for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
					Entry<String, String> entry = (Entry<String, String>) iterator.next();
					NameValuePair e = new BasicNameValuePair(entry.getKey(), entry.getValue());
					pairs.add(e);
				}

			}
		}
		ub.setParameters(pairs);

		HttpGet get = new HttpGet(ub.build());

		// 增加header
		if (header_params != null && header_params.size() > 0) {
			for (HashMap<String, String> hashMap : header_params) {
				Set<Entry<String, String>> temp = hashMap.entrySet();
				for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
					Entry<String, String> entry = (Entry<String, String>) iterator.next();
					get.addHeader(entry.getKey(), entry.getValue());
				}

			}

		}

		CloseableHttpResponse response = client.execute(get);
		String statusLine = response.getStatusLine().toString();
		if (statusLine.contains("200")) {
			HttpEntity entity = response.getEntity();
			json = EntityUtils.toString(entity, "utf-8");
			response.close();
			client.close();
		} else {
			throw new APIErrorException(statusLine);
		}

		return json;
	}

	public static String doPost(APIForm form) throws ClientProtocolException, IOException, CustomException {
		// 获取form表单中的参数
		ArrayList<HashMap<String, String>> header_params = form.getHeader_params();

		ArrayList<HashMap<String, String>> request_params = form.getRequest_params();

		String json = null;

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(form.getUrl());

		// 增加header
		if (header_params != null && header_params.size() > 0) {
			for (HashMap<String, String> hashMap : header_params) {
				Set<Entry<String, String>> temp = hashMap.entrySet();
				for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
					Entry<String, String> entry = (Entry<String, String>) iterator.next();
					post.addHeader(entry.getKey(), entry.getValue());
				}

			}
		}

		List<NameValuePair> params = new ArrayList<NameValuePair>();

		if (request_params != null && request_params.size() > 0) {
			for (HashMap<String, String> hashMap : request_params) {
				Set<Entry<String, String>> temp = hashMap.entrySet();
				for (Iterator iterator = temp.iterator(); iterator.hasNext();) {
					Entry<String, String> entry = (Entry<String, String>) iterator.next();
					NameValuePair value = new BasicNameValuePair(entry.getKey(), entry.getValue());
					params.add(value);
				}

			}
		}
		post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
		CloseableHttpResponse response = client.execute(post);

		String statusLine = response.getStatusLine().toString();
		if (statusLine.contains("200")) {
			HttpEntity entity = response.getEntity();
			json = (EntityUtils.toString(entity));
			response.close();
			client.close();
		} else {
			throw new APIErrorException(statusLine);
		}
		return json;
	}
	
	
	

}
