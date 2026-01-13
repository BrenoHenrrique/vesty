package com.localcode.vesty.store.product.controller;

import com.localcode.vesty.store.product.dto.ProductDTO;
import com.localcode.vesty.store.product.dto.ProductFilterDTO;
import com.localcode.vesty.store.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    @GetMapping
    public List<ProductDTO> findAll(ProductFilterDTO filter) {
        return service.findAll(filter);
    }

    @GetMapping("/pageable")
    public Page<ProductDTO> findPageable(Pageable pageable, ProductFilterDTO filter) {
        filter.setPageable(pageable);
        return service.findPageable(filter);
    }

    @GetMapping("/{id}")
    public ProductDTO findModelById(@PathVariable Long id) {
        return service.findModelById(id);
    }

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ProductDTO save(ProductDTO product) {
        return service.save(product);
    }

    @PutMapping("/{id}")
    public ProductDTO edit(@PathVariable Long id, @RequestBody ProductDTO product) {
        return service.edit(id, product);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
