package com.localcode.vesty.store.product.controller;

import com.localcode.vesty.store.product.ProductEntity;
import com.localcode.vesty.store.product.dto.ProductDTO;
import com.localcode.vesty.store.product.dto.ProductFilterDTO;
import com.localcode.vesty.store.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<ProductEntity> findAll(ProductFilterDTO filter) {
        return service.findAll(filter);
    }

    @GetMapping("/pageable")
    public List<ProductEntity> findPageable(Pageable pageable, ProductFilterDTO filter) {
        filter.setPageable(pageable);
        return service.findPageable(filter);
    }

    @PostMapping
    public List<ProductEntity> save(@RequestBody ProductDTO product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public List<ProductEntity> edit(@PathVariable Long id, @RequestBody ProductDTO product) {
        return service.edit(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
