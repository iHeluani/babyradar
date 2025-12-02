package com.babyradar.products.util;

import com.babyradar.products.domain.Product;
import com.babyradar.products.domain.ProductOffer;

import java.time.LocalDateTime;

public class ProductOfferMother {

    public static ProductOffer carrefourOffer(Product product) {
        return ProductOffer.builder()
                .id(1L)
                .product(product)
                .shopName("Carrefour")
                .url("https://carrefour.es/producto-hipp")
                .price(3.19)
                .oldPrice(3.49)
                .inStock(true)
                .firstSeenAt(LocalDateTime.now().minusDays(3))
                .lastSeenAt(LocalDateTime.now())
                .build();
    }

    public static ProductOffer amazonOffer(Product product) {
        return ProductOffer.builder()
                .id(2L)
                .product(product)
                .shopName("Amazon")
                .url("https://amazon.es/producto-hipp")
                .price(3.05)
                .oldPrice(null)
                .inStock(true)
                .firstSeenAt(LocalDateTime.now().minusDays(5))
                .lastSeenAt(LocalDateTime.now())
                .build();
    }
}