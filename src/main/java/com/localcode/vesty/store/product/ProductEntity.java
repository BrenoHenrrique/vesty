package com.localcode.vesty.store.product;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "product", schema = "public")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String category;
    private String subCategory;
    private String brand;
    private String color;

    @Column(length = 500)
    private String shortDescription;

    @Column(length = 5000)
    private String fullDescription;

    private String material;
    private String size;

    @ElementCollection
    private List<String> tags;

    @ElementCollection
    private List<String> images;

    private double weight;
    private double length;
    private double width;
    private double height;
}
