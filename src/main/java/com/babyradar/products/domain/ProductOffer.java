package com.babyradar.products.domain;

import lombok.Builder;
import lombok.Value;

import java.time.LocalDateTime;

/**
 * Oferta concreta de un producto en una tienda (precio, url, stock...).
 */
@Value
@Builder
public class ProductOffer {

    Long id;
    Product product;

    String shopName;   // Carrefour, Alcampo, Amazon...
    String url;

    Double price;
    Double oldPrice;
    Boolean inStock;

    LocalDateTime firstSeenAt;
    LocalDateTime lastSeenAt;
}