package com.babyradar.products.domain;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {

    Optional<Product> findById(Long id);

    Optional<Product> findByEan(String ean);

    List<Product> findByBrand(String brand);

    List<Product> findByCategory(ProductCategory category);

    List<Product> findByNameContains(String namePart);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);
}