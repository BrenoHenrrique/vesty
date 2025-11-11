package com.localcode.vesty.store.product.service;

import com.localcode.vesty.store.product.dto.MaterialCategoryDetailDTO;

import java.util.List;

public interface MaterialCategoryService {
    List<MaterialCategoryDetailDTO> findAll();
}
