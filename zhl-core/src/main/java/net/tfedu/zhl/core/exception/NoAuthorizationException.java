package net.tfedu.zhl.core.exception;

public class NoAuthorizationException extends CustomException {
    /**
     * 
     */
    private static final long serialVersionUID = -5245657609530099014L;

    public NoAuthorizationException() {
        super("NoAuthorizationException", "您没有权限。");
    }

}
