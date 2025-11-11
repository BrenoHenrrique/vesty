package com.localcode.vesty.store.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaterialEnum {
    COTTON("Algodão", MaterialCategoryEnum.CLOTHING),
    POLYESTER("Poliéster", MaterialCategoryEnum.CLOTHING),
    WOOL("Lã", MaterialCategoryEnum.CLOTHING),
    SILK("Seda", MaterialCategoryEnum.CLOTHING),
    LINEN("Linho", MaterialCategoryEnum.CLOTHING),
    DENIM("Jeans", MaterialCategoryEnum.CLOTHING),

    LEATHER("Couro", MaterialCategoryEnum.FOOTWEAR),
    SUEDE("Camurça", MaterialCategoryEnum.FOOTWEAR),
    RUBBER("Borracha", MaterialCategoryEnum.FOOTWEAR),
    EVA("EVA", MaterialCategoryEnum.FOOTWEAR),
    SYNTHETIC_FABRIC("Tecido Sintético", MaterialCategoryEnum.FOOTWEAR),
    NEOPRENE("Neoprene", MaterialCategoryEnum.FOOTWEAR);


    private final String description;
    private final MaterialCategoryEnum category;
}
