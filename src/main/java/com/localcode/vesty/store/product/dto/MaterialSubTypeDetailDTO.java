package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MaterialSubTypeDetailDTO {

    private String id;
    private String name;

    private List<MaterialDTO> materials;

    public MaterialSubTypeDetailDTO(String id, String name, List<MaterialDTO> materials) {
        this.id = id;
        this.name = name;
        this.materials = materials;
    }
}
