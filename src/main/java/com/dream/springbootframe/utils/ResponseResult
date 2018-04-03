package com.dream.springbootframe.utils;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseResult<T> {

    private int status = 200;
    private String message;
    private T data;
    private String error;
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public ResponseResult() {
    }

    public static ResponseResult<Void> ok() {
        ResponseResult<Void> r = new ResponseResult<>();
        r.setStatus(200);
        return r;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public static <T> ResponseResult<T> of(T data) {
        ResponseResult<T> r = new ResponseResult<T>();
        r.setData( data );
        return r;
    }
}
