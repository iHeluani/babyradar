package com.babyradar.products.domain;

public class ProductMother {

    public static Product hippMulticereales() {
        return new Product(
                1L,
                "4062300345593",
                "Multicereales sin azúcares añadidos Hipp",
                "Hipp",
                ProductCategory.CEREAL,
                true,      // bio
                true,      // sugarFree
                true,      // palmOilFree
                "+6M",
                "Procesado bueno BLW"
        );
    }
}
