package com.localcode.vesty.store.product.service;

import com.localcode.vesty.store.product.ProductEntity;
import com.localcode.vesty.store.product.dto.ProductDTO;
import com.localcode.vesty.store.product.dto.ProductFilterDTO;

import java.util.List;

public interface ProductService {
    List<ProductEntity> findAll(ProductFilterDTO filter);

    List<ProductEntity> findPageable(ProductFilterDTO filter);

    List<ProductEntity> save(ProductDTO product);

    List<ProductEntity> edit(Long id, ProductDTO product);

    void delete(Long id);
}
