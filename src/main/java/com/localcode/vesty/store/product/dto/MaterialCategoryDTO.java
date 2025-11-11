package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialCategoryDTO {
    private String code;
    private String description;

    public MaterialCategoryDTO(String code, String description) {
        this.code = code;
        this.description = description;
    }
}
