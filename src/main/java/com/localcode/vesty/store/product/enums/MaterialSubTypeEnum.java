package com.localcode.vesty.store.product.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum MaterialSubTypeEnum {
    // CLOTHING
    TSHIRT("Camiseta"),
    SHIRT("Camisa"),
    JACKET("Jaqueta"),
    HOODIE("Moletom"),
    PANTS("Calça"),
    SHORTS("Bermuda"),

    // FOOTWEAR
    SNEAKER("Tênis"),
    SAPATENIS("Sapatenis"),
    BOOT("Bota"),
    SANDAL("Sandália"),
    FLIPFLOP("Chinelo");

    private final String description;
}

