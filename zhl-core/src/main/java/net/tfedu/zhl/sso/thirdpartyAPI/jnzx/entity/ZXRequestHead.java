package net.tfedu.zhl.sso.thirdpartyAPI.jnzx.entity;

import java.util.List;

/**
 * 中兴接口的请求头部信息
 * @author wangwr
 *
 */
public class ZXRequestHead {

	List<ZXRequestInfo> RET;
	
	String RET_STATUS;

	public List<ZXRequestInfo> getRET() {
		return RET;
	}

	public void setRET(List<ZXRequestInfo> rET) {
		RET = rET;
	}

	public String getRET_STATUS() {
		return RET_STATUS;
	}

	public void setRET_STATUS(String rET_STATUS) {
		RET_STATUS = rET_STATUS;
	}
	
}
