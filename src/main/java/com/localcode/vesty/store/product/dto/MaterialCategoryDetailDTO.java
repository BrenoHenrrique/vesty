package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MaterialCategoryDetailDTO {

    private String categoryCode;
    private String categoryDescription;

    private List<MaterialDTO> materials;

    public MaterialCategoryDetailDTO(String categoryCode, String categoryDescription, List<MaterialDTO> materials) {
        this.categoryCode = categoryCode;
        this.categoryDescription = categoryDescription;
        this.materials = materials;
    }
}
