package com.babyradar.products.infrastructure.persistence;

import com.babyradar.products.domain.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataProductJpaRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByEan(String ean);

    List<ProductEntity> findByBrandIgnoreCase(String brand);

    List<ProductEntity> findByCategory(ProductCategory category);

    List<ProductEntity> findByNameContainingIgnoreCase(String namePart);
}