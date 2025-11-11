package com.localcode.vesty.store.product.controller;

import com.localcode.vesty.store.product.dto.MaterialCategoryDTO;
import com.localcode.vesty.store.product.dto.MaterialCategoryDetailDTO;
import com.localcode.vesty.store.product.service.MaterialCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/materials-categories")
public class MaterialCategoryController {
    private final MaterialCategoryService service;

    @GetMapping
    public List<MaterialCategoryDetailDTO> findAll() {
        return service.findAll();
    }
}
