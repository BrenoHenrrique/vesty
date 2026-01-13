package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String id;
    private String name;
    private String color;
    private String size;
    private int quantity;
    private String company;
    private BigDecimal price;
    List<MultipartFile> files;
}
