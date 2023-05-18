package com.ncut.myblog.service.ex;

public class PasswordNotCorrectException extends ServiceException{
    public PasswordNotCorrectException() {
        super();
    }

    public PasswordNotCorrectException(String message) {
        super(message);
    }

    public PasswordNotCorrectException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotCorrectException(Throwable cause) {
        super(cause);
    }

    protected PasswordNotCorrectException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
