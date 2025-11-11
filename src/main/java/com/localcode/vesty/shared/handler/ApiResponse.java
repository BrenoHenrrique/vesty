package com.localcode.vesty.shared.handler;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse<T> {
    private T data;
    private String message;
    private String error;
    private Integer status;
    private Long timestamp;
}
