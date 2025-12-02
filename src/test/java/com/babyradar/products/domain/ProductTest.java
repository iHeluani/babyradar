package com.babyradar.products.domain;

import com.babyradar.products.util.ProductMother;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    @Test
    void shouldCreateProductWithExpectedAttributes() {
        Product product = ProductMother.hippMulticereales();

        assertEquals("4062300345593", product.getEan());
        assertEquals("Multicereales sin azúcares añadidos Hipp", product.getName());
        assertEquals("Hipp", product.getBrand());
        assertEquals(ProductCategory.CEREAL, product.getCategory());
        assertTrue(product.isBio());
        assertTrue(product.isSugarFree());
        assertTrue(product.isPalmOilFree());
        assertEquals("+6M", product.getRecommendedAge());
    }
}