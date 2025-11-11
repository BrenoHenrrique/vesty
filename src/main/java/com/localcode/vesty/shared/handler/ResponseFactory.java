package com.localcode.vesty.shared.handler;

public class ResponseFactory {
    private ResponseFactory() {}

    public static <T> ApiResponse<T> success(T data) {
        return ApiResponse.<T>builder()
                .data(data)
                .ok(true)
                .status(200)
                .timestamp(System.currentTimeMillis())
                .build();
    }

    public static ApiResponse<?> error(String msg, int status) {
        return ApiResponse.builder()
                .error(msg)
                .ok(false)
                .status(status)
                .timestamp(System.currentTimeMillis())
                .build();
    }
}

