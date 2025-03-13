package com.daisypig.common.api.dto;


import com.daisypig.common.api.enums.BasicCode;
import com.daisypig.common.api.enums.ResponseCodeI;


public class Response extends DTO {

    private static final long serialVersionUID = 1L;

    private boolean status;

    private String message;

    private String code;

    public static Response buildFailure(ResponseCodeI responseCode) {
        Response response = new Response();
        response.setStatus(false);
        response.setCode(responseCode.getCode());
        response.setMessage(responseCode.getDesc());
        return response;
    }

    public static Response buildFailure(String errMessage) {
        Response response = new Response();
        response.setStatus(false);
        response.setCode(BasicCode.UNKNOWN_ERROR.getCode());
        response.setMessage(errMessage != null && errMessage != "" && errMessage != "null" ?
                errMessage : BasicCode.UNKNOWN_ERROR.getDesc());
        return response;
    }

    public static Response buildFailure(String errCode, String errMessage) {
        Response response = new Response();
        response.setStatus(false);
        response.setCode(errCode);
        response.setMessage(errMessage);
        return response;
    }

    public static Response buildFailure(ResponseCodeI responseCode, String errMessage) {
        Response response = new Response();
        response.setStatus(false);
        response.setCode(responseCode.getCode());
        response.setMessage(errMessage);
        return response;
    }

    public static Response buildSuccess() {
        Response response = new Response();
        response.setStatus(true);
        response.setCode(BasicCode.SUCCESS.getCode());
        response.setMessage(BasicCode.SUCCESS.getDesc());
        return response;
    }

    public static Response buildSuccess(String message) {
        Response response = new Response();
        response.setStatus(true);
        response.setCode(BasicCode.SUCCESS.getCode());
        response.setMessage(message);
        return response;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Response [status=" + status + ", code=" + code + ", message=" + message + "]";
    }
}