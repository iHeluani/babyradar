package com.babyradar.products.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Optional<Product> findByEan(String ean);

    List<Product> findAll();

    Product save(Product product);
}