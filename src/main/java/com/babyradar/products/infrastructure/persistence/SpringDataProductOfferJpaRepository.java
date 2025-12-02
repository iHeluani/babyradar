package com.babyradar.products.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataProductOfferJpaRepository extends JpaRepository<ProductOfferEntity, Long> {

    List<ProductOfferEntity> findByProduct(ProductEntity product);

    List<ProductOfferEntity> findByProduct_Ean(String ean);

    List<ProductOfferEntity> findByShopNameIgnoreCase(String shopName);

    List<ProductOfferEntity> findByProduct_Id(Long productId);
}