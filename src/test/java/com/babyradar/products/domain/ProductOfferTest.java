package com.babyradar.products.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfferTest {

    @Test
    void shouldHoldBasicOfferData() {
        Product product = ProductMother.hippMulticereales();

        ProductOffer offer = new ProductOffer(
                1L,
                product,
                "Carrefour",
                "https://carrefour.es/...",
                3.19,
                3.49,
                true,
                LocalDateTime.now().minusDays(1),
                LocalDateTime.now()
        );

        assertEquals("Carrefour", offer.getShopName());
        assertEquals(3.19, offer.getPrice());
        assertEquals(3.49, offer.getOldPrice());
        assertTrue(offer.getInStock());
        assertSame(product, offer.getProduct());
    }
}