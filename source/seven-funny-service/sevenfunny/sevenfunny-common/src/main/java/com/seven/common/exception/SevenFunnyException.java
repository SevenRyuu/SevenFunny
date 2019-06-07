package com.seven.common.exception;

/**
 * 自定义异常
 * @author ：SevenRyuu
 * date   ：2019/6/7 5:02 PM
 * email  ：sevenryuu77@gmail.com
 */
public class SevenFunnyException extends RuntimeException{

    private static final long serialVersionUID = 2483705162736068411L;

    public SevenFunnyException() {
        super();
    }

    public SevenFunnyException(String message) {
        super(message);
    }

    public SevenFunnyException(String message, Throwable cause) {
        super(message, cause);
    }

    public SevenFunnyException(Throwable cause) {
        super(cause);
    }

    protected SevenFunnyException(String message, Throwable cause,
                               boolean enableSuppression,
                               boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
