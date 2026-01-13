package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductFilterDTO {
    private String id;
    private String name;
    private String color;
    private String size;
    private int quantity;
    private BigDecimal price;
    private List<String> images;
    private Pageable pageable;
}
