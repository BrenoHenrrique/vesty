package com.localcode.vesty.store.product.service;

import com.localcode.vesty.store.product.dto.ProductDTO;
import com.localcode.vesty.store.product.dto.ProductFilterDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    List<ProductDTO> findAll(ProductFilterDTO filter);

    Page<ProductDTO> findPageable(ProductFilterDTO filter);

    ProductDTO findModelById(Long id);

    ProductDTO save(ProductDTO product);

    ProductDTO edit(Long id, ProductDTO product);

    void delete(Long id);
}
