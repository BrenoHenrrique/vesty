package com.localcode.vesty.store.product.service;

import com.localcode.vesty.store.product.dto.MaterialCategoryDetailDTO;
import com.localcode.vesty.store.product.dto.MaterialDTO;
import com.localcode.vesty.store.product.dto.MaterialSubTypeDetailDTO;
import com.localcode.vesty.store.product.enums.MaterialCategoryEnum;
import com.localcode.vesty.store.product.enums.MaterialEnum;
import com.localcode.vesty.store.product.enums.MaterialSubTypeEnum;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class MaterialCategoryServiceImpl implements MaterialCategoryService {
    @Override
    public List<MaterialCategoryDetailDTO> findAll() {
        return Arrays.stream(MaterialCategoryEnum.values())
                .map(this::buildCategoryDetail)
                .toList();
    }

    private MaterialCategoryDetailDTO buildCategoryDetail(MaterialCategoryEnum category) {
        List<MaterialSubTypeDetailDTO> subTypes = buildSubTypesForCategory(category);

        return new MaterialCategoryDetailDTO(
                category.name(),
                category.getDescription(),
                subTypes
        );
    }

    private List<MaterialSubTypeDetailDTO> buildSubTypesForCategory(MaterialCategoryEnum category) {
        return Arrays.stream(MaterialSubTypeEnum.values())
                .map(subType -> buildSubTypeDetail(category, subType))
                .filter(Objects::nonNull)
                .toList();
    }

    private MaterialSubTypeDetailDTO buildSubTypeDetail(MaterialCategoryEnum category,
                                                        MaterialSubTypeEnum subType) {

        List<MaterialDTO> materials = findMaterials(category, subType);

        if (materials.isEmpty()) {
            return null;
        }

        return new MaterialSubTypeDetailDTO(
                subType.name(),
                subType.getDescription(),
                materials
        );
    }

    private List<MaterialDTO> findMaterials(MaterialCategoryEnum category,
                                            MaterialSubTypeEnum subType) {

        return Arrays.stream(MaterialEnum.values())
                .filter(material -> belongsToCategoryAndSubType(material, category, subType))
                .map(material -> new MaterialDTO(material.name(), material.getDescription()))
                .toList();
    }

    private boolean belongsToCategoryAndSubType(MaterialEnum material,
                                                MaterialCategoryEnum category,
                                                MaterialSubTypeEnum subType) {
        return material.getCategory() == category &&
                material.getSubType() == subType;
    }
}
