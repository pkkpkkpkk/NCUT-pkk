package com.ncut.myblog.service.ex;

public class NullUsernameException extends ServiceException{
    public NullUsernameException() {
        super();
    }

    public NullUsernameException(String message) {
        super(message);
    }

    public NullUsernameException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullUsernameException(Throwable cause) {
        super(cause);
    }

    protected NullUsernameException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
