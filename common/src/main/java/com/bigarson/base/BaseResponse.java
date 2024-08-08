package com.bigarson.base;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
public class BaseResponse<T> {
    private boolean isSuccess;
    private String message;
    private T data;

    public static <T> ResponseEntity<BaseResponse<T>> ok(T data, HttpStatus statusCode) {
        BaseResponse<T> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return ResponseEntity.status(statusCode).body(response);
    }


    public static  ResponseEntity<BaseResponse<?>> ok(HttpStatus statusCode) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setSuccess(true);
        response.setData(null);
        return ResponseEntity.status(statusCode).body(response);
    }

    public static ResponseEntity<BaseResponse<?>> error(String message, HttpStatus statusCode) {
        BaseResponse<?> response = new BaseResponse<>();
        response.setSuccess(false);
        response.setMessage(message);
        return ResponseEntity.status(statusCode).body(response);
    }
}
