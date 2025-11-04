package com.localcode.vesty.shared.utility;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tools.jackson.databind.ObjectMapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GenericAssembler {
    private final ObjectMapper objectMapper;

    public <T, U> U toModel(T entity, Class<U> targetClass) {
        return objectMapper.convertValue(entity, targetClass);
    }

    public <T, U> List<U> toCollectionModel(List<T> entities, Class<U> modelClass) {
        return entities.stream().map(entity -> toModel(entity, modelClass)).toList();
    }
}