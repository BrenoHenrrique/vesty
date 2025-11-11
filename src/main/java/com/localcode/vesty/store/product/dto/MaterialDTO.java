package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaterialDTO {
    private String id;
    private String name;

    public MaterialDTO(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
