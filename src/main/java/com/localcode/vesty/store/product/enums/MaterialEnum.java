package com.localcode.vesty.store.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaterialEnum {

    // --- CLOTHING: TSHIRT ---
    TSHIRT_COTTON("Algodão", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.TSHIRT),
    TSHIRT_POLYESTER("Poliéster", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.TSHIRT),
    TSHIRT_LINEN("Linho", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.TSHIRT),

    // --- CLOTHING: SHIRT ---
    SHIRT_COTTON("Algodão", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.SHIRT),
    SHIRT_POLYESTER("Poliéster", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.SHIRT),
    SHIRT_LINEN("Linho", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.SHIRT),

    // --- CLOTHING: PANTS ---
    PANTS_DENIM("Jeans", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.PANTS),
    PANTS_COTTON("Algodão", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.PANTS),
    PANTS_POLYESTER("Poliéster", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.PANTS),

    // --- CLOTHING: SHORTS ---
    SHORTS_COTTON("Algodão", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.SHORTS),
    SHORTS_POLYESTER("Poliéster", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.SHORTS),
    SHORTS_DENIM("Jeans", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.SHORTS),

    // --- CLOTHING: JACKET ---
    JACKET_WOOL("Lã", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.JACKET),
    JACKET_LEATHER("Couro", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.JACKET),

    // --- CLOTHING: HOODIE ---
    HOODIE_COTTON("Algodão", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.HOODIE),
    HOODIE_POLYESTER("Poliéster", MaterialCategoryEnum.CLOTHING, MaterialSubTypeEnum.HOODIE),

    // --- FOOTWEAR: SNEAKER ---
    SNEAKER_EVA("EVA", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SNEAKER),
    SNEAKER_RUBBER("Borracha", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SNEAKER),
    SNEAKER_SYNTHETIC("Tecido Sintético", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SNEAKER),

    // --- FOOTWEAR: SAPATENIS ---
    SAPATENIS_LEATHER("Couro", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SAPATENIS),
    SAPATENIS_SYNTHETIC("Tecido Sintético", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SAPATENIS),

    // --- FOOTWEAR: BOOT ---
    BOOT_LEATHER("Couro", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.BOOT),
    BOOT_SUEDE("Camurça", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.BOOT),
    BOOT_NEOPRENE("Neoprene", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.BOOT),

    // --- FOOTWEAR: SANDAL ---
    SANDAL_RUBBER("Borracha", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SANDAL),
    SANDAL_SYNTHETIC("Tecido Sintético", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.SANDAL),

    // --- FOOTWEAR: FLIPFLOP ---
    FLIPFLOP_RUBBER("Borracha", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.FLIPFLOP),
    FLIPFLOP_EVA("EVA", MaterialCategoryEnum.FOOTWEAR, MaterialSubTypeEnum.FLIPFLOP);

    private final String description;
    private final MaterialCategoryEnum category;
    private final MaterialSubTypeEnum subType;
}
