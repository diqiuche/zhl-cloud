package net.tfedu.zhl.sso.thirdpartyAPI.jnzx.entity;

public class ZXUserInfoResult {
	ZXRequestHead SYS_HEAD;
	
	ZXUserInfoBody BODY;

	public ZXRequestHead getSYS_HEAD() {
		return SYS_HEAD;
	}

	public void setSYS_HEAD(ZXRequestHead sYS_HEAD) {
		SYS_HEAD = sYS_HEAD;
	}

	public ZXUserInfoBody getBODY() {
		return BODY;
	}

	public void setBODY(ZXUserInfoBody bODY) {
		BODY = bODY;
	}
	
	
}
