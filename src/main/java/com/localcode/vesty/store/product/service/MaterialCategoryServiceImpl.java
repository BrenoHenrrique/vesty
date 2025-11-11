package com.localcode.vesty.store.product.service;

import com.localcode.vesty.store.product.dto.MaterialCategoryDTO;
import com.localcode.vesty.store.product.dto.MaterialCategoryDetailDTO;
import com.localcode.vesty.store.product.dto.MaterialDTO;
import com.localcode.vesty.store.product.enums.MaterialCategoryEnum;
import com.localcode.vesty.store.product.enums.MaterialEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MaterialCategoryServiceImpl implements MaterialCategoryService {
    @Override
    public List<MaterialCategoryDetailDTO> findAll() {
        return Arrays.stream(MaterialCategoryEnum.values())
                .map(category -> {
                    List<MaterialDTO> materials = Arrays.stream(MaterialEnum.values())
                            .filter(mat -> mat.getCategory() == category)
                            .map(mat -> new MaterialDTO(mat.name(), mat.getDescription()))
                            .toList();

                    return new MaterialCategoryDetailDTO(
                            category.name(),
                            category.getDescription(),
                            materials
                    );
                })
                .toList();
    }
}
