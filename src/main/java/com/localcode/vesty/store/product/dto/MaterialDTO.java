package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialDTO {

    private String code;
    private String name;

    public MaterialDTO(String code, String name) {
        this.code = code;
        this.name = name;
    }
}
