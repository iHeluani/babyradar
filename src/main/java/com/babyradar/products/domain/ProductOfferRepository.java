package com.babyradar.products.domain;

import java.util.List;
import java.util.Optional;

public interface ProductOfferRepository {

    Optional<ProductOffer> findById(Long id);

    List<ProductOffer> findByProduct(Product product);

    List<ProductOffer> findByProductEan(String ean);

    List<ProductOffer> findByShopName(String shopName);

    List<ProductOffer> findByProductId(Long id);

    ProductOffer save(ProductOffer offer);

    void deleteById(Long id);
}