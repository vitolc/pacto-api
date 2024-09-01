package com.vitulc.pactotestapi.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.http.HttpStatus;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseResult<T> {

    private static final String STATUS_SUCCESS = "SUCCESS";
    private static final String STATUS_ERROR = "ERROR";

    private String code;
    private String status;
    private String description;
    private T data;

    public ResponseResult(String code, String status, String description, T data) {
        this.code = code;
        this.status = status;
        this.description = description;
        this.data = data;
    }

    public static <T> ResponseResult<T> success(T data) {
        return new ResponseResult<>(HttpStatus.OK.toString(), STATUS_SUCCESS, null, data);
    }

    public static <T> ResponseResult<T> success(String description, T data) {
        return new ResponseResult<>(HttpStatus.OK.toString(), STATUS_SUCCESS, description, data);
    }

    public static <T> ResponseResult<T> error(String code, String description, T data) {
        return new ResponseResult<>(code, STATUS_ERROR, description, data);
    }

    public static <T> ResponseResult<T> error(String code, String description) {
        return new ResponseResult<>(code, STATUS_ERROR, description, null);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
