package com.localcode.vesty.store.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaterialCategoryEnum {
    CLOTHING("Roupa"),
    FOOTWEAR("Calçado");

    private final String description;
}
