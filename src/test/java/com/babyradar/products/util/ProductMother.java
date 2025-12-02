package com.babyradar.products.util;

import com.babyradar.products.domain.Product;
import com.babyradar.products.domain.ProductCategory;

public class ProductMother {

    public static Product hippMulticereales() {
        return Product.builder()
                .id(1L)
                .ean("4062300345593")
                .name("Multicereales sin azúcares añadidos Hipp")
                .brand("Hipp")
                .category(ProductCategory.CEREAL)
                .bio(true)
                .sugarFree(true)
                .palmOilFree(true)
                .recommendedAge("+6M")
                .notes("Procesado bueno BLW")
                .build();
    }
}
