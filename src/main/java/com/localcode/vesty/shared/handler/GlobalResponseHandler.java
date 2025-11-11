package com.localcode.vesty.shared.handler;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@Component
@ControllerAdvice
public class GlobalResponseHandler implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter returnType,
                                  MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType,
                                  org.springframework.http.server.ServerHttpRequest request,
                                  org.springframework.http.server.ServerHttpResponse response) {

        if (body instanceof ApiResponse) {
            return body;
        }

        if (body instanceof ResponseEntity<?> entity) {
            Object entityBody = entity.getBody();

            // se já for ApiResponse, retorna direto
            if (entityBody instanceof ApiResponse) {
                return entityBody;
            }

            return ResponseFactory.success(entityBody);
        }

        // Qualquer outra resposta vira sucesso automaticamente
        return ResponseFactory.success(body);
    }
}

