package com.daisypig.common.api.dto;


import com.daisypig.common.api.enums.BasicCode;
import com.daisypig.common.api.enums.ResponseCodeI;


public class DataResponse<T> extends Response {

    private T data;

    public static <T> DataResponse<T> of(T data) {
        DataResponse<T> response = new DataResponse<>();
        response.setStatus(true);
        response.setData(data);
        response.setCode(BasicCode.SUCCESS.getCode());
        response.setMessage(BasicCode.SUCCESS.getDesc());
        return response;
    }
    public static <T> DataResponse<T> ok(T data) {
        DataResponse<T> response = new DataResponse<>();
        response.setStatus(true);
        response.setData(data);
        response.setCode(BasicCode.SUCCESS.getCode());
        response.setMessage(BasicCode.SUCCESS.getDesc());
        return response;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }

    public static <T> DataResponse<T> of(boolean status, ResponseCodeI responseCode, T data) {
        DataResponse<T> response = new DataResponse<T>();
        response.setStatus(status);
        response.setData(data);
        response.setCode(responseCode.getCode());
        response.setMessage(responseCode.getDesc());
        return response;
    }

    public static DataResponse buildFailure(ResponseCodeI responseCode) {
        DataResponse response = new DataResponse();
        response.setStatus(false);
        response.setCode(responseCode.getCode());
        response.setMessage(responseCode.getDesc());
        return response;
    }

    public static DataResponse buildFailure(ResponseCodeI responseCode, String message) {
        DataResponse response = new DataResponse();
        response.setStatus(false);
        response.setCode(responseCode.getCode());
        response.setMessage(message != null && message != "" && message != "null" ?
                message : BasicCode.UNKNOWN_ERROR.getDesc());
        return response;
    }

    public static DataResponse buildSuccess() {
        DataResponse response = new DataResponse();
        response.setStatus(true);
        response.setCode(BasicCode.SUCCESS.getCode());
        response.setMessage(BasicCode.SUCCESS.getDesc());
        return response;
    }
}
