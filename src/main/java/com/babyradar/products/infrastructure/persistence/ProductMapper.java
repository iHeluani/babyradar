package com.babyradar.products.infrastructure.persistence;

import com.babyradar.products.domain.Product;

public final class ProductMapper {

    private ProductMapper() {}

    public static Product toDomain(ProductEntity e) {
        if (e == null) return null;

        return Product.builder()
                .id(e.getId())
                .ean(e.getEan())
                .name(e.getName())
                .brand(e.getBrand())
                .category(e.getCategory())
                .bio(e.isBio())
                .sugarFree(e.isSugarFree())
                .palmOilFree(e.isPalmOilFree())
                .recommendedAge(e.getRecommendedAge())
                .notes(e.getNotes())
                .build();
    }

    public static ProductEntity toEntity(Product p) {
        if (p == null) return null;

        return ProductEntity.builder()
                .id(p.getId())
                .ean(p.getEan())
                .name(p.getName())
                .brand(p.getBrand())
                .category(p.getCategory())
                .bio(p.isBio())
                .sugarFree(p.isSugarFree())
                .palmOilFree(p.isPalmOilFree())
                .recommendedAge(p.getRecommendedAge())
                .notes(p.getNotes())
                .build();
    }
}