package com.ncut.myblog.service.ex;

public class DataNullException extends ServiceException{
    public DataNullException() {
        super();
    }

    public DataNullException(String message) {
        super(message);
    }

    public DataNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataNullException(Throwable cause) {
        super(cause);
    }

    protected DataNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
