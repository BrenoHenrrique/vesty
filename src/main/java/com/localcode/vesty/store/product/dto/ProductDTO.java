package com.localcode.vesty.store.product.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ProductDTO {
    private String id;
    private String name;
    private String category;
    private String subCategory;
    private String brand;
    private String color;
    private String shortDescription;
    private String fullDescription;
    private String material;
    private String size;
    private List<String> tags;
    private List<String> images;
    private double weight;
    private double length;
    private double width;
    private double height;
}
