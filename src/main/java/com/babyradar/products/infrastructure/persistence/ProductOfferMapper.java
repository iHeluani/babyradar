package com.babyradar.products.infrastructure.persistence;

import com.babyradar.products.domain.ProductOffer;

public final class ProductOfferMapper {

    private ProductOfferMapper() {}

    public static ProductOffer toDomain(ProductOfferEntity e) {
        if (e == null) return null;

        return ProductOffer.builder()
                .id(e.getId())
                .product(ProductMapper.toDomain(e.getProduct()))
                .shopName(e.getShopName())
                .url(e.getUrl())
                .price(e.getPrice())
                .oldPrice(e.getOldPrice())
                .inStock(e.getInStock())
                .firstSeenAt(e.getFirstSeenAt())
                .lastSeenAt(e.getLastSeenAt())
                .build();
    }

    public static ProductOfferEntity toEntity(ProductOffer o, ProductEntity productEntity) {
        if (o == null) return null;

        return ProductOfferEntity.builder()
                .id(o.getId())
                .product(productEntity)
                .shopName(o.getShopName())
                .url(o.getUrl())
                .price(o.getPrice())
                .oldPrice(o.getOldPrice())
                .inStock(o.getInStock())
                .firstSeenAt(o.getFirstSeenAt())
                .lastSeenAt(o.getLastSeenAt())
                .build();
    }
}