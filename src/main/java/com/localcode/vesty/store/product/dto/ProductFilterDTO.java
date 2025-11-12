package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
public class ProductFilterDTO {
    private String name;
    private String category;
    private String material;
    private String subCategory;
    private Pageable pageable;
}
