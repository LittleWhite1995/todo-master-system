package com.todo.system.util.web;

import com.todo.system.util.common.CommonCodes;

/**
 * 统一的对外数据格式化
 */
public class UnifiedResponseObject<T> {
    private T statusCode;
    private T body;
    private T msgerr;

    public T getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(T statusCode) {
        this.statusCode = statusCode;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }

    public T getMsgerr() {
        return msgerr;
    }

    public void setMsgerr(T msgerr) {
        this.msgerr = msgerr;
    }

    public UnifiedResponseObject() {

    }

    /**
     * 有两个参数据构造
     * @param statusCode
     * @param body
     */
    public UnifiedResponseObject(T statusCode, T body, T msgerr) {
        this.statusCode = statusCode;
        this.body = body;
        this.msgerr = msgerr;
    }

    /**
     * 只有statusCode的构造
     * @param statusCode
     */
    public UnifiedResponseObject(T statusCode) {
        this.statusCode = statusCode;
    }

    public UnifiedResponseObject(T statusCode, T msgerr) {
        this.statusCode = statusCode;
        this.msgerr = msgerr;
    }

    public UnifiedResponseObject<T> successMsg(T body) {
        this.statusCode = (T) CommonCodes.ApiResponseStatus.SUCCESS;
        this.body = body;
        return this;
    }

    public UnifiedResponseObject<T> failMsg(T msgerr) {
        this.statusCode = (T) CommonCodes.ApiResponseStatus.FAIL;
        this.msgerr = msgerr;
        return this;
    }

    @Override
    public String toString() {
        return "UnifiedResponseObject{" +
                "statusCode=" + statusCode +
                ", body=" + body +
                '}';
    }
}
