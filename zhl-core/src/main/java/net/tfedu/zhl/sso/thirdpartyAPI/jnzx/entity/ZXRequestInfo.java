package net.tfedu.zhl.sso.thirdpartyAPI.jnzx.entity;


/**
 * 济宁中心接口的请求状态信息
 * @author wangwr
 *
 */
public class ZXRequestInfo {

	
	
	/**
	 * 请求结果信息 
	 */
	public String RET_MSG;
	
	/**
	 * 请求结果状态
	 */
	public String RET_CODE;
	
	
	/**
	 * 请求服务的编码
	 */
	public String SERVICE_CODE;


	public String getRET_MSG() {
		return RET_MSG;
	}


	public void setRET_MSG(String rET_MSG) {
		RET_MSG = rET_MSG;
	}


	public String getRET_CODE() {
		return RET_CODE;
	}


	public void setRET_CODE(String rET_CODE) {
		RET_CODE = rET_CODE;
	}


	public String getSERVICE_CODE() {
		return SERVICE_CODE;
	}


	public void setSERVICE_CODE(String sERVICE_CODE) {
		SERVICE_CODE = sERVICE_CODE;
	}
	
	
	
	
	
	
	
	
}
