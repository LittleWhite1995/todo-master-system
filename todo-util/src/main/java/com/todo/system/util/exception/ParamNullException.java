package com.todo.system.util.exception;

/**
 * @program: food-management-system-parent
 * @description:
 * @author: liangbo
 * @create: 2019-02-27 17:15
 **/
public class ParamNullException extends Exception{
    public ParamNullException() {
    }

    public ParamNullException(String message) {
        super(message);
    }

    public ParamNullException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParamNullException(Throwable cause) {
        super(cause);
    }

    public ParamNullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
