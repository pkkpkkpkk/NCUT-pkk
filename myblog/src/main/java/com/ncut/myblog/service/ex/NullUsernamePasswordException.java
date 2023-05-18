package com.ncut.myblog.service.ex;

public class NullUsernamePasswordException extends ServiceException{
    public NullUsernamePasswordException() {
        super();
    }

    public NullUsernamePasswordException(String message) {
        super(message);
    }

    public NullUsernamePasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullUsernamePasswordException(Throwable cause) {
        super(cause);
    }

    protected NullUsernamePasswordException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
