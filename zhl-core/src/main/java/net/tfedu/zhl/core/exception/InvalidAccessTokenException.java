package net.tfedu.zhl.core.exception;

public class InvalidAccessTokenException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public InvalidAccessTokenException() {
        super("InvalidAccessToken", "登陆超时或提供的token无效，请重新登录！");
    }
    
}
